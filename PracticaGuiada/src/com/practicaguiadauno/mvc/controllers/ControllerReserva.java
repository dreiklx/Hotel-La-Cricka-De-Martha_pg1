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
import com.practicaguiadauno.mvc.view.ViewPrincipal;
import com.practicaguiadauno.mvc.view.reservaciones.Create;
import com.practicaguiadauno.mvc.view.reservaciones.Index;
import com.practicaguiadauno.mvc.view.reservaciones.See;

public class ControllerReserva extends Functions {

	private ViewPrincipal vp;
	private ListaReservaciones model;
	private ListaHabitaciones habitaciones;
	private ListaCategoriasA categorias;

	public ControllerReserva(ViewPrincipal vp, ListaReservaciones model,
			ListaHabitaciones habitaciones, ListaCategoriasA categorias) {

		this.vp = vp;
		this.model = model;
		this.habitaciones = habitaciones;
		this.categorias = categorias;
	}

	public void create() {

		Create v = new Create();

		for (Habitacion h : habitaciones.getListaHabitaciones()) {
			v.getCbxHabitaciones().addItem(h);
		}

		v.getBtnReservar().addActionListener(e -> {

			Habitacion habitacion = (Habitacion) v.getCbxHabitaciones().getSelectedItem();

			LocalDate fechaEntrada = v.gettFechaEntrada().getDate()
					.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();

			LocalDate fechaSalida = v.gettFechaSalida().getDate()
					.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();

			String cliente = v.getTxtCliente().getText().trim();

			int personas = Integer.parseInt(v.getSpinner().getValue().toString());

			Reservacion r = new Reservacion(
					habitacion,
					cliente,
					fechaEntrada,
					fechaSalida,
					personas
			);

			if (!model.disponible(habitacion, fechaEntrada, fechaSalida)) {

				v.getLblYesNoHabDisp().setBackground(Color.RED);
				v.getLblYesNoHabDisp().setText("No");
				return;
			}

			if (!r.capacidadMaximaPermitida()) {

				v.getLblyesNoPeople().setBackground(Color.RED);
				v.getLblyesNoPeople().setText("No");
				return;
			}

			v.getLblYesNoHabDisp().setBackground(Color.GREEN);
			v.getLblYesNoHabDisp().setText("Si");

			v.getLblyesNoPeople().setBackground(Color.GREEN);
			v.getLblyesNoPeople().setText("Si");

			v.getLblDato1().setText(habitacion.getNombre());
			v.getLblDato2().setText(String.valueOf(habitacion.getCapacidad()));
			v.getLblDato3().setText(String.valueOf(habitacion.getTarifa()));
			v.getLblDato4().setText(fechaEntrada.toString());
			v.getLblDato5().setText(fechaSalida.toString());
			v.getLblDato6().setText(String.valueOf(personas));
			v.getLblDato7().setText(String.valueOf(r.getCantNoches()));
			v.getLblDato8().setText(String.valueOf(r.costoPorNoche()));
			v.getLblDato9().setText(String.valueOf(r.costoTotalHospedaje()));

			v.getTxtCliente().setText("");
			v.getSpinner().setValue(0);
			v.gettFechaEntrada().setDate(null);
			v.gettFechaSalida().setDate(null);

			model.add(new Reservacion(
					habitacion,
					cliente,
					fechaEntrada,
					fechaSalida,
					personas
			));
		});

		v.getBtnCancelar().addActionListener(e -> {

			v.getTxtCliente().setText("");
			v.getSpinner().setValue(0);
			v.gettFechaEntrada().setDate(null);
			v.gettFechaSalida().setDate(null);

			v.getLblYesNoHabDisp().setBackground(Color.GREEN);
			v.getLblYesNoHabDisp().setText("Si");

			v.getLblyesNoPeople().setBackground(Color.GREEN);
			v.getLblyesNoPeople().setText("Si");
		});

		vp.setContenido(v, "Hotel La Cricka de Martha - Nueva Reservación");
	}

	public void index() {

		Index v = new Index();

		v.getModelo().setDataVector(
				model.getDataReservaciones(),
				model.getColumsRes()
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
				model.delete(id);
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
						model,
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

		Reservacion r = model.find(id);

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