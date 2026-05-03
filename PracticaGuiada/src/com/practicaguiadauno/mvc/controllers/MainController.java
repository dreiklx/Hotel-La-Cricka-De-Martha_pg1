package com.practicaguiadauno.mvc.controllers;

import java.time.LocalDate;

import com.practicaguiadauno.mvc.model.Food;
import com.practicaguiadauno.mvc.model.FoodCategory;
import com.practicaguiadauno.mvc.model.FoodCategoryList;
import com.practicaguiadauno.mvc.model.Room;
import com.practicaguiadauno.mvc.model.RoomList;
import com.practicaguiadauno.mvc.model.Reservation;
import com.practicaguiadauno.mvc.model.ReservationList;
import com.practicaguiadauno.mvc.view.ViewMajor;
import com.practicaguiadauno.utils.Message;

public class MainController {

	private FoodCategoryList categories;
	private RoomList rooms;
	private ReservationList model;
	private ViewMajor vp;

	public MainController() {

		//try {
			this.categories = new FoodCategoryList();
			this.rooms = new RoomList();
			this.model = new ReservationList();
			this.vp = new ViewMajor();

			init();

	//	} catch (Exception e) {
			//Message.error("Error al iniciar la aplicación");
		//}
	}

	public void init() {

		try {

			loadData();

			vp.getBtnNuevaReservacion().addActionListener(e -> {
				try {
					new ReservationController(vp, model, rooms, categories).create();
				} catch (Exception ex) {
					Message.error("Error al abrir creación de reservación");
				}
			});

			vp.getBtnReservaciones().addActionListener(e -> {
				try {
					new ReservationController(vp, model, rooms, categories).index();
				} catch (Exception ex) {
					Message.error("Error al cargar reservaciones");
				}
			});

			vp.getBtnReportes().addActionListener(e -> {
				try {
					new ReportController(vp, model).reports();
				} catch (Exception ex) {
					Message.error("Error al abrir reportes");
				}
			});

			vp.init();

			new ReservationController(vp, model, rooms, categories).create();

		} catch (Exception e) {
			Message.error("Error al inicializar el sistema");
		}
	}

	public void loadData() {

		try {

			// CATEGORÍAS
			categories.add(new FoodCategory("Comida tradicional"));
			categories.add(new FoodCategory("Comida rápida"));
			categories.add(new FoodCategory("Bebidas"));
			categories.add(new FoodCategory("Postres"));

			// COMIDA
			categories.find(1).getFoodList().add(new Food("Gallo pinto", 2500));
			categories.find(1).getFoodList().add(new Food("Casado", 3500));
			categories.find(1).getFoodList().add(new Food("Olla de carne", 4000));

			categories.find(2).getFoodList().add(new Food("Hamburguesa", 3500));
			categories.find(2).getFoodList().add(new Food("Pizza", 5000));
			categories.find(2).getFoodList().add(new Food("Hot dog", 2500));

			categories.find(3).getFoodList().add(new Food("Café", 800));
			categories.find(3).getFoodList().add(new Food("Refresco", 1500));
			categories.find(3).getFoodList().add(new Food("Batido", 2000));

			categories.find(4).getFoodList().add(new Food("Tres leches", 2500));
			categories.find(4).getFoodList().add(new Food("Helado", 1800));
			categories.find(4).getFoodList().add(new Food("Brownie", 2200));

			// HABITACIONES
			rooms.add(new Room("Bocaracá", 6, 7000));
			rooms.add(new Room("Terciopelo", 5, 8000));
			rooms.add(new Room("Oropel", 4, 9000));
			rooms.add(new Room("Coral", 3, 10000));

			// RESERVACIONES
			model.add(new Reservation(rooms.find(1), "Juan Pérez", LocalDate.of(2026,5,1), LocalDate.of(2026,5,5),2));
			model.add(new Reservation(rooms.find(2), "María López", LocalDate.of(2026,5,3), LocalDate.of(2026,5,6),3));
			model.add(new Reservation(rooms.find(3), "Carlos Gómez", LocalDate.of(2026,5,7), LocalDate.of(2026,5,10),2));
			model.add(new Reservation(rooms.find(4), "Ana Rodríguez", LocalDate.of(2026,5,2), LocalDate.of(2026,5,4),1));
			model.add(new Reservation(rooms.find(1), "Luis Fernández", LocalDate.of(2026,5,8), LocalDate.of(2026,5,12),4));
			model.add(new Reservation(rooms.find(2), "Sofía Morales", LocalDate.of(2026,5,10), LocalDate.of(2026,5,13),2));
			model.add(new Reservation(rooms.find(3), "Jorge Castillo", LocalDate.of(2026,5,6), LocalDate.of(2026,5,9),3));
			model.add(new Reservation(rooms.find(4), "Valeria Rojas", LocalDate.of(2026,5,12), LocalDate.of(2026,5,15),2));
			model.add(new Reservation(rooms.find(1), "Daniel Vargas", LocalDate.of(2026,5,14), LocalDate.of(2026,5,18),5));
			model.add(new Reservation(rooms.find(2), "Paula Jiménez", LocalDate.of(2026,5,16), LocalDate.of(2026,5,20),3));

			// CLIENTES REPETIDOS (para ranking)
			model.add(new Reservation(rooms.find(1), "Juan Pérez", LocalDate.of(2026,5,21), LocalDate.of(2026,5,23),2));
			model.add(new Reservation(rooms.find(2), "María López", LocalDate.of(2026,5,22), LocalDate.of(2026,5,25),3));
			model.add(new Reservation(rooms.find(3), "Juan Pérez", LocalDate.of(2026,5,26), LocalDate.of(2026,5,28),1));
			model.add(new Reservation(rooms.find(2), "Carlos Gómez", LocalDate.of(2026,5,20), LocalDate.of(2026,5,22),2));
			model.add(new Reservation(rooms.find(3), "Carlos Gómez", LocalDate.of(2026,5,23), LocalDate.of(2026,5,26),2));

			// ALIMENTOS CONSUMIDOS (para reportes)
			Food f1 = new Food("Café", 800);
			f1.setQuantity(2);
			model.find(1).getFoodList().add(f1);

			Food f2 = new Food("Café", 800);
			f2.setQuantity(3);
			model.find(2).getFoodList().add(f2);

			Food f3 = new Food("Pizza", 5000);
			f3.setQuantity(1);
			model.find(3).getFoodList().add(f3);

			Food f4 = new Food("Hamburguesa", 3500);
			f4.setQuantity(2);
			model.find(4).getFoodList().add(f4);

			Food f5 = new Food("Café", 800);
			f5.setQuantity(1);
			model.find(5).getFoodList().add(f5);

		} catch (Exception e) {
			Message.error("Error al cargar datos iniciales");
		}
	}
}