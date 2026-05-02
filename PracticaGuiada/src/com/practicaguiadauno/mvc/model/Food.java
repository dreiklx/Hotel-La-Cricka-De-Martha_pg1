package com.practicaguiadauno.mvc.model;

public class Food {

	private int id;
	private String name;
	private int price;
	private int quantity;

	public Food(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Food(String name, int price) {
		this.id = 0;
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}

	// constructor para agregar a la lista de la reservación
	public Food(Food f, int quantity) {

		if (f == null) {
			this.id = 0;
			this.name = "";
			this.price = 0;
			this.quantity = 0;
			return; // antes si venía null rompía todo
		}

		this.id = 0;
		this.name = f.getName();
		this.price = f.getPrice();
		this.quantity = quantity;
	}

	// Calcula el subtotal
	public int getSubtotal() {
		return price * quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {

		if (id < 0) {
			return; // antes se permitían ids negativos
		}

		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {

		if (name == null || name.trim().isEmpty()) {
			return; // antes se permitían nombres vacíos o null
		}

		this.name = name.trim();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {

		if (price < 0) {
			return; // antes se permitían precios negativos
		}

		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {

		if (quantity < 0) {
			return; // antes se permitían cantidades negativas
		}

		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return name;
	}
}