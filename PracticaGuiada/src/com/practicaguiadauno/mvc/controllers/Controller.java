package com.practicaguiadauno.mvc.controllers;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import com.github.weisj.jsvg.nodes.View;
import com.practicaguiadauno.mvc.model.Alimento;
import com.practicaguiadauno.mvc.model.CategoriaAlimento;
import com.practicaguiadauno.mvc.model.Habitacion;
import com.practicaguiadauno.mvc.model.ListaAlimentos;
import com.practicaguiadauno.mvc.model.ListaCategoriasA;
import com.practicaguiadauno.mvc.model.ListaHabitaciones;
import com.practicaguiadauno.mvc.model.ListaReservaciones;
import com.practicaguiadauno.mvc.model.Reservacion;
import com.practicaguiadauno.mvc.view.ViewPrincipal;
import com.practicaguiadauno.mvc.view.reservaciones.Alimentos;
import com.practicaguiadauno.mvc.view.reservaciones.Index;
import com.practicaguiadauno.mvc.view.reservaciones.Reportes;
import com.practicaguiadauno.mvc.view.reservaciones.See;
import com.practicaguiadauno.mvc.view.reservaciones.Create;

public class Controller extends Functions {
	private ListaCategoriasA categorias;
	private ListaHabitaciones habitaciones;

	private ListaReservaciones model;

	private ViewPrincipal vp;

	public Controller() {
		this.categorias = new ListaCategoriasA();
		this.habitaciones = new ListaHabitaciones();
		this.model = new ListaReservaciones();

		this.vp = new ViewPrincipal();

		init();
	}

	public void init() {
		cargarDatos();

		vp.getBtnNuevaReservacion().addActionListener(e -> {
			create();
		});
		vp.getBtnReservaciones().addActionListener(e -> {
			index();
		});
		vp.getBtnReportes().addActionListener(e -> {
			reportes();
		});
		vp.init();
		create();

	}

	public void cargarDatos() {

		categorias.add(new CategoriaAlimento("Comida tradicional"));
		categorias.add(new CategoriaAlimento("Comida rápida"));
		categorias.add(new CategoriaAlimento("Bebidas"));
		categorias.add(new CategoriaAlimento("Postres"));

		categorias.find(1).getListaAlimentos().add(new Alimento("Gallo pinto con huevo y maduro", 2500));
		categorias.find(1).getListaAlimentos().add(new Alimento("Casado (chuleta, pollo o pescado)", 3500));
		categorias.find(1).getListaAlimentos().add(new Alimento("Arroz con pollo", 3000));
		categorias.find(1).getListaAlimentos().add(new Alimento("Sopa de mariscos", 5500));
		categorias.find(1).getListaAlimentos().add(new Alimento("Rice and Beans", 4500));

		categorias.find(2).getListaAlimentos().add(new Alimento("Hamburguesa con papas", 3500));
		categorias.find(2).getListaAlimentos().add(new Alimento("Taco doble", 3000));
		categorias.find(2).getListaAlimentos().add(new Alimento("Burrito", 3000));
		categorias.find(2).getListaAlimentos().add(new Alimento("Chalupa (pollo o carne)", 3500));

		categorias.find(3).getListaAlimentos().add(new Alimento("Refresco natural", 1000));
		categorias.find(3).getListaAlimentos().add(new Alimento("Refresco gaseoso", 1500));
		categorias.find(3).getListaAlimentos().add(new Alimento("Cerveza", 2000));
		categorias.find(3).getListaAlimentos().add(new Alimento("Café", 800));

		categorias.find(4).getListaAlimentos().add(new Alimento("Tres leches", 2500));
		categorias.find(4).getListaAlimentos().add(new Alimento("Flan de coco", 2000));
		categorias.find(4).getListaAlimentos().add(new Alimento("Queque de chocolate", 1500));

		habitaciones.add(new Habitacion("Bocaracá", 6, 7000));
		habitaciones.add(new Habitacion("Terciopelo", 5, 8000));
		habitaciones.add(new Habitacion("Oropel", 4, 9000));
		habitaciones.add(new Habitacion("Coral", 3, 10000));

		model.add(new Reservacion(habitaciones.find(1), "Juan Pérez", LocalDate.of(2026, 5, 1),
				LocalDate.of(2026, 5, 5), 2));
		model.add(new Reservacion(habitaciones.find(2), "María Rodríguez", LocalDate.of(2026, 5, 10),
				LocalDate.of(2026, 5, 12), 4));
		model.add(new Reservacion(habitaciones.find(3), "Carlos Soto", LocalDate.of(2026, 6, 1),
				LocalDate.of(2026, 6, 8), 1));
		model.add(new Reservacion(habitaciones.find(4), "Ana Brenes", LocalDate.of(2026, 6, 15),
				LocalDate.of(2026, 6, 20), 3));
		model.add(new Reservacion(habitaciones.find(1), "Luis Chaves", LocalDate.of(2026, 7, 4),
				LocalDate.of(2026, 7, 6), 2));
		model.add(new Reservacion(habitaciones.find(2), "Elena Gómez", LocalDate.of(2026, 7, 20),
				LocalDate.of(2026, 7, 25), 5));
		model.add(new Reservacion(habitaciones.find(3), "Roberto Méndez", LocalDate.of(2026, 8, 1),
				LocalDate.of(2026, 8, 3), 2));
		model.add(new Reservacion(habitaciones.find(4), "Sofía Alfaro", LocalDate.of(2026, 8, 15),
				LocalDate.of(2026, 8, 17), 2));
		model.add(new Reservacion(habitaciones.find(1), "Diego Morales", LocalDate.of(2026, 9, 10),
				LocalDate.of(2026, 9, 15), 4));
		model.add(new Reservacion(habitaciones.find(2), "Lucía Vargas", LocalDate.of(2026, 10, 1),
				LocalDate.of(2026, 10, 5), 2));

		// Reservacion 1 - Juan Pérez
		model.find(1).getListaAlimentos().add(new Alimento(new Alimento("Gallo pinto con huevo y maduro", 2500), 2));
		model.find(1).getListaAlimentos().add(new Alimento(new Alimento("Refresco natural", 1000), 3));
		model.find(1).getListaAlimentos().add(new Alimento(new Alimento("Tres leches", 2500), 1));

		// Reservacion 2 - María Rodríguez
		model.find(2).getListaAlimentos().add(new Alimento(new Alimento("Casado (chuleta, pollo o pescado)", 3500), 4));
		model.find(2).getListaAlimentos().add(new Alimento(new Alimento("Cerveza", 2000), 2));
		model.find(2).getListaAlimentos().add(new Alimento(new Alimento("Flan de coco", 2000), 3));

		// Reservacion 3 - Carlos Soto
		model.find(3).getListaAlimentos().add(new Alimento(new Alimento("Arroz con pollo", 3000), 1));
		model.find(3).getListaAlimentos().add(new Alimento(new Alimento("Café", 800), 2));
		model.find(3).getListaAlimentos().add(new Alimento(new Alimento("Queque de chocolate", 1500), 2));

		// Reservacion 4 - Ana Brenes
		model.find(4).getListaAlimentos().add(new Alimento(new Alimento("Hamburguesa con papas", 3500), 3));
		model.find(4).getListaAlimentos().add(new Alimento(new Alimento("Refresco gaseoso", 1500), 3));
		model.find(4).getListaAlimentos().add(new Alimento(new Alimento("Tres leches", 2500), 2));

		// Reservacion 5 - Luis Chaves
		model.find(5).getListaAlimentos().add(new Alimento(new Alimento("Rice and Beans", 4500), 2));
		model.find(5).getListaAlimentos().add(new Alimento(new Alimento("Cerveza", 2000), 2));
		model.find(5).getListaAlimentos().add(new Alimento(new Alimento("Flan de coco", 2000), 1));
	}

	public void create() {
		Create v = new Create();
		for (Habitacion h : habitaciones.getListaHabitaciones()) {
			v.getCbxHabitaciones().addItem(h);
		}
		v.getBtnReservar().addActionListener(e -> {
			Habitacion habitacion = (Habitacion) v.getCbxHabitaciones().getSelectedItem();
			LocalDate fechaEntrada = v.gettFechaEntrada().getDate().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			LocalDate fechaSalida = v.gettFechaSalida().getDate().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
			String cliente = v.getTxtCliente().getText().trim();
			int personas = Integer.parseInt(v.getSpinner().getValue().toString());

			Reservacion r = new Reservacion(habitacion, cliente, fechaEntrada, fechaSalida, personas);
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
			model.add(new Reservacion(habitacion, cliente, fechaEntrada, fechaSalida, personas));

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
		v.getModelo().setDataVector(model.getDataReservaciones(), model.getColumsRes());
		// Texto Buscar
		v.getTextField().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				String buscar = v.getTextField().getText();
				buscar(v.getTable(), buscar, 1, 2, 3, 4);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		// Boton Nuevo
		v.getBtnNueva().addActionListener(e -> {
			create();
		});
		// Boton Ver
		v.getBtnVer().addActionListener(e -> {
			int id = getSelectedID(v.getTable());
			if (id > 0) {
				see(id);
			} else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Registro");
			}
		});
		// Boton Eliminar
		v.getBtnEliminar().addActionListener(e -> {
			int id = getSelectedID(v.getTable());
			if (id > 0) {
				model.delete(id);
				index();
			} else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar  un Registro");
			}
		});
		// Boton Alimentos
		v.getBtnAlimentos().addActionListener(e -> {
			int id = getSelectedID(v.getTable());
			if (id > 0) {
				alimentos(id);
			} else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar un Registro");
			}
		});
		vp.setContenido(v, "Hotel La Cricka de Martha - Reservaciones");
	}

	public void see(int id) {
		See v = new See();
		Reservacion r = model.find(id);

		v.getModelo().setDataVector(r.getListaAlimentos().getData(), r.getListaAlimentos().getColums());
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

	// Cambiar a como dice la guia
	public void alimentos(int id) {
		Alimentos v = new Alimentos();
		ListaAlimentos listaTemp = new ListaAlimentos();
		Reservacion r = model.find(id);
		for (CategoriaAlimento c : categorias.getListaCategoria()) {
			v.getCbxCategoria().addItem(c);
		}

		v.getModelo().setDataVector(r.getListaAlimentos().getData(), r.getListaAlimentos().getColums());
		v.getLblId().setText(String.valueOf(r.getId()));
		v.getLblCliente().setText(r.getNomCliente());
		v.getLblHabitacion().setText(r.getHabitacion().getNombre());
		v.getLblCapMax().setText(String.valueOf(r.getHabitacion().getCapacidad()));
		v.getLblTarifa().setText(String.valueOf(r.getHabitacion().getTarifa()));
		v.getLblEntrada().setText(String.valueOf(r.getFechaEntrada()));
		v.getLblSalida().setText(String.valueOf(r.getFechaSalida()));
		v.getLblTotalalimentos().setText(String.valueOf(r.getListaAlimentos().totalAlimentos()));
		
		v.getCbxCategoria().addActionListener(e -> {
			CategoriaAlimento categoria = (CategoriaAlimento) v.getCbxCategoria().getSelectedItem();
			v.getCbxAlimento().removeAllItems();
			for (Alimento a : categoria.getListaAlimentos().getListaAlimentos()) {
				v.getCbxAlimento().addItem(a);
			}
		});
		// Boton Agregar
		v.getBtnAgregar().addActionListener(e -> {

			Alimento alimentoSeleccionado = (Alimento) v.getCbxAlimento().getSelectedItem();
			int cantidad = (int) v.getSpinner().getValue();
			Alimento existente = r.getListaAlimentos().findByName(alimentoSeleccionado.getNombre());
			if (existente != null) {
				existente.setCantidad(existente.getCantidad() + cantidad);
			} else {
				Alimento a = new Alimento(alimentoSeleccionado, cantidad);
				listaTemp.add(a);
				v.getLblSubtotal().setText(String.valueOf(a.getSubtotal()));
			}
			v.getModelo().setDataVector(listaTemp.getData(), listaTemp.getColums());
			v.getSpinner().setValue(0);
			v.getLblTotalalimentos().setText(String.valueOf(listaTemp.totalAlimentos()));
		});
		// Boton Eliminar
		v.getBtnCancelar().addActionListener(e -> {
			int idd = getSelectedID(v.getTable());
			if (idd > 0) {
				listaTemp.delete(idd);
				v.getModelo().setDataVector(listaTemp.getData(), listaTemp.getColums());
				v.getLblTotalalimentos().setText(String.valueOf(listaTemp.totalAlimentos()));
			} else {
				JOptionPane.showMessageDialog(null, "Debe Seleccionar  un Registro");
			}
		});
		//BotonGuardar
		v.getBtnGuardar().addActionListener(e -> {
			r.setListaAlimentos(listaTemp);
			JOptionPane.showMessageDialog(null, "La Lista de Alimentos Ha Sido Actualizada");
		});
		vp.setContenido(v, "Hotel La Cricka de Martha - Alimentos");
	}

	public void reportes() {
		Reportes v = new Reportes();
		
		vp.setContenido(v, "Hotel La Cricka de Martha - Reportes");
	}
}
