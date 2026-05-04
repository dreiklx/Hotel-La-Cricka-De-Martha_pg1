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

		// try {
		this.categories = new FoodCategoryList();
		this.rooms = new RoomList();
		this.model = new ReservationList();
		this.vp = new ViewMajor();

		init();

		// } catch (Exception e) {
		// Message.error("Error al iniciar la aplicación");
		// }
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
			categories.find(1).getFoodList().add(new Food("Gallo pinto con huevo y maduro", 2500));
			categories.find(1).getFoodList().add(new Food("Casado (chuleta, pollo o pescado)", 3500));
			categories.find(1).getFoodList().add(new Food("Arroz con pollo", 3000));
			categories.find(1).getFoodList().add(new Food("Sopa de mariscos", 5500));
			categories.find(1).getFoodList().add(new Food("Rice and Beans", 4500));

			categories.find(2).getFoodList().add(new Food("Hamburguesa con papas", 3500));
			categories.find(2).getFoodList().add(new Food("Taco doble", 3000));
			categories.find(2).getFoodList().add(new Food("Burrito", 3000));
			categories.find(2).getFoodList().add(new Food("Chalupa (pollo o carne)", 3500));

			categories.find(3).getFoodList().add(new Food("Refresco natural", 1000));
			categories.find(3).getFoodList().add(new Food("Refresco gaseoso", 1500));
			categories.find(3).getFoodList().add(new Food("Cerveza", 2000));
			categories.find(3).getFoodList().add(new Food("Café", 800));

			categories.find(4).getFoodList().add(new Food("Tres leches", 2500));
			categories.find(4).getFoodList().add(new Food("Flan de coco", 2000));
			categories.find(4).getFoodList().add(new Food("Queque de chocolate", 1500));

			// HABITACIONES
			rooms.add(new Room("Bocaracá", 6, 7000));
			rooms.add(new Room("Terciopelo", 5, 8000));
			rooms.add(new Room("Oropel", 4, 9000));
			rooms.add(new Room("Coral", 3, 10000));

			// RESERVACIONES
			model.add(new Reservation(rooms.find(1), "Juan Pérez", LocalDate.of(2026, 5, 1), LocalDate.of(2026, 5, 5),
					2));
			model.add(new Reservation(rooms.find(2), "María López", LocalDate.of(2026, 5, 3), LocalDate.of(2026, 5, 6),
					3));
			model.add(new Reservation(rooms.find(3), "Carlos Gómez", LocalDate.of(2026, 5, 7),
					LocalDate.of(2026, 5, 10), 2));
			model.add(new Reservation(rooms.find(4), "Ana Rodríguez", LocalDate.of(2026, 5, 2),
					LocalDate.of(2026, 5, 4), 1));
			model.add(new Reservation(rooms.find(1), "Luis Fernández", LocalDate.of(2026, 5, 8),
					LocalDate.of(2026, 5, 12), 4));
			model.add(new Reservation(rooms.find(2), "Sofía Morales", LocalDate.of(2026, 5, 10),
					LocalDate.of(2026, 5, 13), 2));
			model.add(new Reservation(rooms.find(3), "Jorge Castillo", LocalDate.of(2026, 5, 6),
					LocalDate.of(2026, 5, 9), 3));
			model.add(new Reservation(rooms.find(4), "Valeria Rojas", LocalDate.of(2026, 5, 12),
					LocalDate.of(2026, 5, 15), 2));
			model.add(new Reservation(rooms.find(1), "Daniel Vargas", LocalDate.of(2026, 5, 14),
					LocalDate.of(2026, 5, 18), 5));
			model.add(new Reservation(rooms.find(2), "Paula Jiménez", LocalDate.of(2026, 5, 16),
					LocalDate.of(2026, 5, 20), 3));

			// CLIENTES REPETIDOS (para ranking)
			model.add(new Reservation(rooms.find(1), "Juan Pérez", LocalDate.of(2026, 5, 21), LocalDate.of(2026, 5, 23),
					2));
			model.add(new Reservation(rooms.find(2), "María López", LocalDate.of(2026, 5, 22),
					LocalDate.of(2026, 5, 25), 3));
			model.add(new Reservation(rooms.find(3), "Juan Pérez", LocalDate.of(2026, 5, 26), LocalDate.of(2026, 5, 28),
					1));
			model.add(new Reservation(rooms.find(2), "Carlos Gómez", LocalDate.of(2026, 5, 20),
					LocalDate.of(2026, 5, 22), 2));
			model.add(new Reservation(rooms.find(3), "Carlos Gómez", LocalDate.of(2026, 5, 23),
					LocalDate.of(2026, 5, 26), 2));

			// ALIMENTOS CONSUMIDOS (para reportes)
			
			// 1. Reservación de Juan Pérez
			Food f1_1 = new Food("Gallo pinto con huevo y maduro", 2500);
			f1_1.setQuantity(2);
			Food f1_2 = new Food("Café", 800);
			f1_2.setQuantity(3);
			Food f1_3 = new Food("Refresco natural", 1000);
			f1_3.setQuantity(1);
			Food f1_4 = new Food("Queque de chocolate", 1500);
			f1_4.setQuantity(2);
			Food f1_5 = new Food("Flan de coco", 2000);
			f1_5.setQuantity(1);
			model.find(1).getFoodList().add(f1_1);
			model.find(1).getFoodList().add(f1_2);
			model.find(1).getFoodList().add(f1_3);
			model.find(1).getFoodList().add(f1_4);
			model.find(1).getFoodList().add(f1_5);

			// 2. Reservación de María López
			Food f2_1 = new Food("Casado (chuleta, pollo o pescado)", 3500);
			f2_1.setQuantity(3);
			Food f2_2 = new Food("Refresco gaseoso", 1500);
			f2_2.setQuantity(3);
			Food f2_3 = new Food("Tres leches", 2500);
			f2_3.setQuantity(2);
			Food f2_4 = new Food("Café", 800);
			f2_4.setQuantity(4);
			Food f2_5 = new Food("Queque de chocolate", 1500);
			f2_5.setQuantity(1);
			model.find(2).getFoodList().add(f2_1);
			model.find(2).getFoodList().add(f2_2);
			model.find(2).getFoodList().add(f2_3);
			model.find(2).getFoodList().add(f2_4);
			model.find(2).getFoodList().add(f2_5);

			// 3. Reservación de Carlos Gómez
			Food f3_1 = new Food("Rice and Beans", 4500);
			f3_1.setQuantity(2);
			Food f3_2 = new Food("Cerveza", 2000);
			f3_2.setQuantity(6);
			Food f3_3 = new Food("Taco doble", 3000);
			f3_3.setQuantity(2);
			Food f3_4 = new Food("Sopa de mariscos", 5500);
			f3_4.setQuantity(1);
			Food f3_5 = new Food("Flan de coco", 2000);
			f3_5.setQuantity(2);
			model.find(3).getFoodList().add(f3_1);
			model.find(3).getFoodList().add(f3_2);
			model.find(3).getFoodList().add(f3_3);
			model.find(3).getFoodList().add(f3_4);
			model.find(3).getFoodList().add(f3_5);

			// 4. Reservación de Ana Rodríguez
			Food f4_1 = new Food("Hamburguesa con papas", 3500);
			f4_1.setQuantity(2);
			Food f4_2 = new Food("Burrito", 3000);
			f4_2.setQuantity(2);
			Food f4_3 = new Food("Refresco natural", 1000);
			f4_3.setQuantity(3);
			Food f4_4 = new Food("Tres leches", 2500);
			f4_4.setQuantity(1);
			Food f4_5 = new Food("Café", 800);
			f4_5.setQuantity(2);
			model.find(4).getFoodList().add(f4_1);
			model.find(4).getFoodList().add(f4_2);
			model.find(4).getFoodList().add(f4_3);
			model.find(4).getFoodList().add(f4_4);
			model.find(4).getFoodList().add(f4_5);

			// 5. Reservación de Luis Fernández
			Food f5_1 = new Food("Arroz con pollo", 3000);
			f5_1.setQuantity(4);
			Food f5_2 = new Food("Chalupa (pollo o carne)", 3500);
			f5_2.setQuantity(2);
			Food f5_3 = new Food("Cerveza", 2000);
			f5_3.setQuantity(4);
			Food f5_4 = new Food("Taco doble", 3000);
			f5_4.setQuantity(2);
			Food f5_5 = new Food("Refresco gaseoso", 1500);
			f5_5.setQuantity(3);
			model.find(5).getFoodList().add(f5_1);
			model.find(5).getFoodList().add(f5_2);
			model.find(5).getFoodList().add(f5_3);
			model.find(5).getFoodList().add(f5_4);
			model.find(5).getFoodList().add(f5_5);

		} catch (Exception e) {
			Message.error("Error al cargar datos iniciales");
		}
	}
}