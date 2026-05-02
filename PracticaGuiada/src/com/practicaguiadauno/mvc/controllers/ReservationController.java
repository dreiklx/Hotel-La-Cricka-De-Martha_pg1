package com.practicaguiadauno.mvc.controllers;

import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;

import com.practicaguiadauno.mvc.model.*;
import com.practicaguiadauno.mvc.view.ViewMajor;
import com.practicaguiadauno.mvc.view.panels.See;
import com.practicaguiadauno.mvc.view.reservations.Create;
import com.practicaguiadauno.mvc.view.reservations.Edit;
import com.practicaguiadauno.mvc.view.reservations.Index;
import com.practicaguiadauno.utils.IconUtils;
import com.practicaguiadauno.utils.Message;

public class ReservationController extends Functions {

	private ViewMajor vp;
	private ReservationList reservations;
	private RoomList rooms;
	private FoodCategoryList categories;

	public ReservationController(ViewMajor vp, ReservationList reservations,
			RoomList rooms, FoodCategoryList categories) {

		this.vp = vp;
		this.reservations = reservations;
		this.rooms = rooms;
		this.categories = categories;
	}

	// ================= CREATE =================

	public void create() {

		Create v = new Create();

		for (Room r : rooms.getRoomList()) {
			v.getCmbRoom().addItem(r);
		}

		v.getCmbRoom().addActionListener(e -> updateRoomData(v));

		v.getJclEntryDate().addPropertyChangeListener(e -> updateDates(v));
		v.getJclExitDate().addPropertyChangeListener(e -> updateDates(v));

		v.getSpnPeople().addChangeListener(e -> updatePeople(v));

		v.getBtnReserve().addActionListener(e -> {

			try {

				Room room = getSelectedRoom(v);

				if (room == null) throw new Exception("Seleccione una habitación");

				String client = v.getTxtClient().getText().trim();

				if (client.isEmpty()) throw new Exception("Nombre del cliente requerido");

				if (v.getJclEntryDate().getDate() == null ||
					v.getJclExitDate().getDate() == null) {
					throw new Exception("Fechas requeridas");
				}

				LocalDate entry = getEntry(v);
				LocalDate exit = getExit(v);

				if (exit.isBefore(entry)) {
					throw new Exception("Fecha de salida inválida");
				}

				int people = getPeople(v);

				if (people <= 0) throw new Exception("Cantidad inválida");

				if (people > room.getCapacity()) {
					throw new Exception("Supera la capacidad");
				}

				if (!reservations.isAvailable(room, entry, exit)) {
					throw new Exception("Habitación no disponible");
				}

				Reservation r = new Reservation(room, client, entry, exit, people);

				reservations.add(r);

				Message.info("Reservación creada");

				clearForm(v);

			} catch (Exception ex) {
				Message.error(ex.getMessage());
			}
		});

		v.getBtnCancel().addActionListener(e -> clearForm(v));

		vp.setContenido(v, "Hotel La Cricka de Martha - Nueva Reservación");
	}

	// ================= INDEX =================

	public void index() {

		Index v = new Index();

		v.getModelo().setDataVector(
				reservations.getData(),
				reservations.getColumns()
		);

		v.getBtnNueva().addActionListener(e -> create());

		v.getTxtSearch().addKeyListener(new java.awt.event.KeyAdapter() {
		    @Override
		    public void keyReleased(java.awt.event.KeyEvent e) {

		        try {

		            String text = java.util.regex.Pattern.quote(v.getTxtSearch().getText());

		            search(v.getTable(), text, 1, 2);

		        } catch (Exception ex) {
		            Message.error("Error al buscar");
		        }
		    }
		});
		
		v.getBtnVer().addActionListener(e -> {

			int id = getSelectedID(v.getTable());

			if (id > 0) {
				see(id);
			} else {
				Message.warning("Seleccione un registro");
			}
		});

		v.getBtnEliminar().addActionListener(e -> {

			int id = getSelectedID(v.getTable());

			if (id > 0) {

				if (Message.confirm("¿Eliminar reservación?")) {
					reservations.delete(id);
					index();
				}

			} else {
				Message.warning("Seleccione un registro");
			}
		});

		v.getBtnAlimentos().addActionListener(e -> {

			int id = getSelectedID(v.getTable());

			if (id > 0) {

				new FoodController(vp, reservations, categories).food(id);

			} else {
				Message.warning("Seleccione un registro");
			}
		});

		v.getBtnEditar().addActionListener(e -> {
			try {

				int id = getSelectedID(v.getTable());

				if (id <= 0) {
					Message.error("Debe seleccionar un registro");
					return;
				}

				edit(id);

			} catch (Exception ex) {
				Message.error("Error al abrir edición");
			}
		});
		
		vp.setContenido(v, "Hotel La Cricka de Martha - Reservaciones");
	}

	// ================= EDIT =================

	public void edit(int id) {

		Edit v = new Edit();

		Reservation r = reservations.find(id);

		if (r == null) {
			Message.error("Reservación no encontrada");
			return;
		}

		for (Room room : rooms.getRoomList()) {
			v.getCmbRoom().addItem(room);
		}

		v.getTxtClient().setText(r.getClientName());
		v.getSpnPeople().setValue(r.getTotalPeople());
		v.getJclEntryDate().setDate(java.sql.Date.valueOf(r.getEntryDate()));
		v.getJclExitDate().setDate(java.sql.Date.valueOf(r.getExitDate()));

		v.getBtnUpdate().addActionListener(e -> {

			try {

				String client = v.getTxtClient().getText().trim();

				if (client.isEmpty()) throw new Exception("Nombre requerido");

				Room room = (Room) v.getCmbRoom().getSelectedItem();

				if (room == null) throw new Exception("Seleccione habitación");

				int people = (int) v.getSpnPeople().getValue();

				if (people <= 0) throw new Exception("Cantidad inválida");

				if (people > room.getCapacity()) {
					throw new Exception("Supera capacidad");
				}

				LocalDate entry = getDate(v.getJclEntryDate());
				LocalDate exit = getDate(v.getJclExitDate());

				if (entry == null || exit == null) {
					throw new Exception("Fechas requeridas");
				}

				if (exit.isBefore(entry)) {
					throw new Exception("Fechas inválidas");
				}

				r.setClientName(client);
				r.setRoom(room);
				r.setTotalPeople(people);
				r.setEntryDate(entry);
				r.setExitDate(exit);

				Message.info("Reservación actualizada");

				index();

			} catch (Exception ex) {
				Message.error(ex.getMessage());
			}
		});

		v.getBtnCancel().addActionListener(e -> index());

		vp.setContenido(v, "Editar Reservación");
	}

	// ================= SEE =================

	public void see(int id) {

		See v = new See();

		Reservation r = reservations.find(id);

		if (r == null) {
			Message.error("Reservación no encontrada");
			return;
		}

		v.getModelo().setDataVector(
				r.getFoodList().getData(),
				r.getFoodList().getColumns()
		);
		
		v.getBtnAlimentos().addActionListener(e -> {
			try {
				int idd = r.getId();
				new FoodController(vp, reservations, categories).food(idd);
			} catch (Exception ex) {
				Message.error("Error al abrir alimentos");
			}
		});

		v.getLblId().setText(String.valueOf(r.getId()));
		v.getLblCliente().setText(r.getClientName());
		v.getLblHabitacion().setText(r.getRoom().getName());
		v.getLblCapMax().setText(String.valueOf(r.getRoom().getCapacity()));
		v.getLblTarifa().setText(String.valueOf(r.getRoom().getRate()));
		v.getLblEntrada().setText(String.valueOf(r.getEntryDate()));
		v.getLblSalida().setText(String.valueOf(r.getExitDate()));
		v.getLblCantPer().setText(String.valueOf(r.getTotalPeople()));
		v.getLblCantNoches().setText(String.valueOf(r.getTotalNights()));
		v.getLblCostoNoche().setText(String.valueOf(r.costPerNight()));
		v.getLblCostoTHospe().setText(String.valueOf(r.totalLodgingCost()));
		v.getLblCostoTAlimentos().setText(String.valueOf(r.getFoodList().totalFoods()));
		v.getLblTotal().setText(String.valueOf(r.totalCost()));

		vp.setContenido(v, "Ver Reservación");
	}

	// ================= HELPERS =================

	private Room getSelectedRoom(Create v) {
		return (Room) v.getCmbRoom().getSelectedItem();
	}

	private int getPeople(Create v) {
		return (int) v.getSpnPeople().getValue();
	}

	private LocalDate getEntry(Create v) {
		return getDate(v.getJclEntryDate());
	}

	private LocalDate getExit(Create v) {
		return getDate(v.getJclExitDate());
	}

	private LocalDate getDate(com.toedter.calendar.JDateChooser d) {
		if (d.getDate() == null) return null;
		return d.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private void updateRoomData(Create v) {

		Room room = getSelectedRoom(v);

		if (room == null) return;

		v.getLblRoomD().setText(room.getName());
		v.getLblCapacityD().setText(String.valueOf(room.getCapacity()));
		v.getLblRateNightD().setText(String.valueOf(room.getRate()));

		updateCalculations(v);
	}

	private void updateDates(Create v) {
		updateAvailability(v);
		updateCalculations(v);
	}

	private void updatePeople(Create v) {
	    Room room = getSelectedRoom(v);
	    if (room == null) return;

	    int people = getPeople(v);
	    v.getLblLotPersonsD().setText(String.valueOf(people));
	    v.getLblAvailablePeople().setText("");
	    v.getLblAvailablePeople().setOpaque(true);

	    if (people > room.getCapacity()) {
	        v.getLblAvailablePeople().setIcon(IconUtils.getIcon("x.png", 32, 32));
	    } else {
	        v.getLblAvailablePeople().setIcon(IconUtils.getIcon("check.png", 32, 32));
	    }

	    v.refreshRequirements();
	    updateCalculations(v);
	}

	
	private void updateAvailability(Create v) {
	    Room room = getSelectedRoom(v);
	    if (room == null) return;

	    LocalDate entry = getEntry(v);
	    LocalDate exit = getExit(v);
	    if (entry == null || exit == null) return;

	    v.getLblAvailableRoom().setText("");
	    v.getLblAvailableRoom().setOpaque(true);

	    if (!reservations.isAvailable(room, entry, exit)) {
	        v.getLblAvailableRoom().setIcon(IconUtils.getIcon("x.png", 32, 32));
	    } else {
	        v.getLblAvailableRoom().setIcon(IconUtils.getIcon("check.png", 32, 32));
	    }

	    v.refreshRequirements();
	}

	private void updateCalculations(Create v) {

		if (getEntry(v) == null || getExit(v) == null || getSelectedRoom(v) == null) return;

		Reservation r = new Reservation(
				getSelectedRoom(v),
				v.getTxtClient().getText(),
				getEntry(v),
				getExit(v),
				getPeople(v)
		);

		v.getLblLotNightD().setText(String.valueOf(r.getTotalNights()));
		v.getLblCostNightD().setText(String.valueOf(r.costPerNight()));
		v.getLblTotalCostD().setText(String.valueOf(r.totalLodgingCost()));
	}

	private void clearForm(Create v) {

		v.getTxtClient().setText("");
		v.getSpnPeople().setValue(0);
		v.getJclEntryDate().setDate(null);
		v.getJclExitDate().setDate(null);

		v.getLblAvailableRoom().setText("");
		v.getLblAvailablePeople().setText("");
	}
}