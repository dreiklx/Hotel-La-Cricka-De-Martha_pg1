package com.practicaguiadauno.mvc.controllers;

import java.time.LocalDate;

import com.practicaguiadauno.mvc.model.Alimento;
import com.practicaguiadauno.mvc.model.CategoriaAlimento;
import com.practicaguiadauno.mvc.model.Habitacion;
import com.practicaguiadauno.mvc.model.ListaCategoriasA;
import com.practicaguiadauno.mvc.model.ListaHabitaciones;
import com.practicaguiadauno.mvc.model.ListaReservaciones;
import com.practicaguiadauno.mvc.model.Reservacion;
import com.practicaguiadauno.mvc.view.ViewPrincipal;

public class MainController {

	private ListaCategoriasA categorias;
	private ListaHabitaciones habitaciones;
	private ListaReservaciones model;
	private ViewPrincipal vp;

	public MainController() {
		this.categorias = new ListaCategoriasA();
		this.habitaciones = new ListaHabitaciones();
		this.model = new ListaReservaciones();
		this.vp = new ViewPrincipal();

		init();
	}

	public void init() {

		cargarDatos();

		vp.getBtnNuevaReservacion().addActionListener(e -> {
			new ControllerReserva(vp, model, habitaciones, categorias).create();
		});

		vp.getBtnReservaciones().addActionListener(e -> {
			new ControllerReserva(vp, model, habitaciones, categorias).index();
		});

		vp.getBtnReportes().addActionListener(e -> {
			new ControllerReportes(vp).reportes();
		});

		vp.init();

		new ControllerReserva(vp, model, habitaciones, categorias).create();
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
	}
}