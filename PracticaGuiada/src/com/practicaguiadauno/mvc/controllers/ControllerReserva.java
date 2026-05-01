package com.practicaguiadauno.mvc.controllers;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JOptionPane;

import com.practicaguiadauno.mvc.model.Habitacion;
import com.practicaguiadauno.mvc.model.ListaCategoriasA;
import com.practicaguiadauno.mvc.model.ListaHabitaciones;
import com.practicaguiadauno.mvc.model.ListaReservaciones;
import com.practicaguiadauno.mvc.model.Reservacion;
import com.practicaguiadauno.mvc.view.ViewMajor;
import com.practicaguiadauno.mvc.view.reservations.Create;
import com.practicaguiadauno.mvc.view.reservations.Index;
import com.practicaguiadauno.mvc.view.reservations.See;

public class ControllerReserva extends Functions {

	private ViewMajor vp;
	private ListaReservaciones reservaciones;
	private ListaHabitaciones habitaciones;
	private ListaCategoriasA categorias;

	public ControllerReserva(ViewMajor vp, ListaReservaciones reservaciones,
			ListaHabitaciones habitaciones, ListaCategoriasA categorias) {

		this.vp = vp;
		this.reservaciones = reservaciones;
		this.habitaciones = habitaciones;
		this.categorias = categorias;
	}

	public void create() {

		Create v = new Create();
		
		
		for (Habitacion h : habitaciones.getListaHabitaciones()) {
			v.getCmbRoom().addItem(h);
		}

		
		v.getCmbRoom().addActionListener(e->{
			Habitacion room =currentRoom(v);
			v.getLblRoomD().setText(room.getNombre());
			v.getLblCapacityD().setText(String.valueOf(room.getCapacidad()));
			v.getLblRateNightD().setText(String.valueOf(room.getTarifa()));
			loadData(v);
		}); 
		
		v.getJclEntryDate().addPropertyChangeListener(e->{
			if(v.getJclEntryDate().getDate() != null) {
				v.getLblEntryDateD().setText(getEntry(v).toString());
				dateFilter(v);
				}
			loadData(v);
		});
		v.getJclExitDate().addPropertyChangeListener(e->{
			if(v.getJclExitDate().getDate() != null) {
				v.getLblExitDateD().setText(getExit(v).toString());
				dateFilter(v);
				}
			loadData(v);
		});
		
		v.getSpnPeople().addChangeListener(e->{
			Habitacion room =currentRoom(v);
			int lot=getLot(v);
			
			v.getLblLotPersonsD().setText(String.valueOf(getLot(v)));
			if (lot>room.getCapacidad()) {
			
					v.getLblAvailablePeople().setBackground(Color.RED);
					v.getLblAvailablePeople().setText("No");
					return;
				}else {
					v.getLblAvailablePeople().setBackground(Color.GREEN);
					v.getLblAvailablePeople().setText("Si");
				}
			loadData(v);
		});

		v.getBtnReserve().addActionListener(e->{
			
		    if (currentRoom(v) == null) return;

		    Reservacion r = new Reservacion(
		        currentRoom(v),
		        v.getTxtClient().getText().trim(),
		        getEntry(v),
		        getExit(v),
		        getLot(v)
		    );

		    reservaciones.add(r);
			v.getTxtClient().setText("");
			v.getSpnPeople().setValue(0);
			v.getJclEntryDate().setDate(null);
			v.getJclExitDate().setDate(null);
			
		});




		
		


		
		

		v.getBtnCancel().addActionListener(e -> {

			v.getTxtClient().setText("");
			v.getSpnPeople().setValue(0);
			v.getJclEntryDate().setDate(null);
			v.getJclExitDate().setDate(null);

			v.getLblAvailableRoom().setBackground(Color.GREEN);
			v.getLblAvailableRoom().setText("Si");

			v.getLblAvailablePeople().setBackground(Color.GREEN);
			v.getLblAvailablePeople().setText("Si");
		});

		vp.setContenido(v, "Hotel La Cricka de Martha - Nueva Reservación");
	}
	public int getLot(Create v) {
		return (int) v.getSpnPeople().getValue();
	}
	public LocalDate getEntry(Create v) {
		return v.getJclEntryDate().getDate()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}
	public LocalDate getExit(Create v) {
		return v.getJclExitDate().getDate()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();
	}
	public void dateFilter(Create v) {
		Habitacion h=currentRoom(v);
		if(getEntry(v)!=null&&getExit(v)!=null) {
			if(!reservaciones.disponible(h, getEntry(v), getExit(v))) {
				v.getLblAvailableRoom().setBackground(Color.RED);
				v.getLblAvailableRoom().setText("No");
			}else {
				v.getLblAvailableRoom().setBackground(Color.GREEN);
				v.getLblAvailableRoom().setText("Si");
			}
		}
	}
	private void loadData(Create v) {

	    if (v.getJclEntryDate().getDate() == null ||
	        v.getJclExitDate().getDate() == null ||
	        currentRoom(v) == null) {
	        return;
	    }

	    String client = v.getTxtClient().getText().trim();

	    Reservacion r = new Reservacion(
	        currentRoom(v),
	        client,
	        getEntry(v),
	        getExit(v),
	        getLot(v)
	    );

	    v.getLblLotNightD().setText(String.valueOf(r.getCantNoches()));
	    v.getLblCostNightD().setText(String.valueOf(r.costoPorNoche()));
	    v.getLblTotalCostD().setText(String.valueOf(r.costoTotalHospedaje()));
	}
	public Habitacion currentRoom(Create v) {
		Habitacion h=(Habitacion)v.getCmbRoom().getSelectedItem();
		return h;
	}

	public void index() {

		Index v = new Index();

		v.getModelo().setDataVector(
				reservaciones.getDataReservaciones(),
				reservaciones.getColumsRes()
		);

		v.getTextField().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {

				String buscar = v.getTextField().getText();
				buscar(v.getTable(), buscar, 1, 2, 3, 4);
			}

			@Override
			public void keyPressed(KeyEvent e) {}
		});

		v.getBtnNueva().addActionListener(e -> {
			create();
		});

		v.getBtnVer().addActionListener(e -> {

			int id = getSelectedID(v.getTable());

			if (id > 0) {
				see(id);
			} else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Registro");
			}
		});

		v.getBtnEliminar().addActionListener(e -> {

			int id = getSelectedID(v.getTable());

			if (id > 0) {
				reservaciones.delete(id);
				index();
			} else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Registro");
			}
		});

		v.getBtnAlimentos().addActionListener(e -> {

			int id = getSelectedID(v.getTable());

			if (id > 0) {

				new ControllerAlimentos(
						vp,
						reservaciones,
						categorias
				).alimentos(id);

			} else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Registro");
			}
		});

		vp.setContenido(v, "Hotel La Cricka de Martha - Reservaciones");
	}

	public void see(int id) {

		See v = new See();

		Reservacion r = reservaciones.find(id);

		v.getModelo().setDataVector(
				r.getListaAlimentos().getData(),
				r.getListaAlimentos().getColums()
		);

		v.getLblId().setText(String.valueOf(r.getId()));
		v.getLblCliente().setText(r.getNomCliente());
		v.getLblHabitacion().setText(r.getHabitacion().getNombre());
		v.getLblCapMax().setText(String.valueOf(r.getHabitacion().getCapacidad()));
		v.getLblTarifa().setText(String.valueOf(r.getHabitacion().getTarifa()));
		v.getLblEntrada().setText(String.valueOf(r.getFechaEntrada()));
		v.getLblSalida().setText(String.valueOf(r.getFechaSalida()));
		v.getLblCantPer().setText(String.valueOf(r.getCantPersonas()));
		v.getLblCantNoches().setText(String.valueOf(r.getCantNoches()));
		v.getLblCostoNoche().setText(String.valueOf(r.getHabitacion().getTarifa()));
		v.getLblCostoTHospe().setText(String.valueOf(r.costoPorNoche()));
		v.getLblCostoTAlimentos().setText(String.valueOf(r.getListaAlimentos().totalAlimentos()));
		v.getLblTotal().setText(String.valueOf(r.totalGeneral()));

		vp.setContenido(v, "Hotel La Cricka de Martha - Ver Reservación");
	}
}