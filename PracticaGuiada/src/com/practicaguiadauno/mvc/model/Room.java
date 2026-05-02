package com.practicaguiadauno.mvc.model;

public class Room {

	private int id;
	private String name;
	private int capacity;
	private int rate;

	public Room(int id, String name, int capacity, int rate) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.rate = rate;
	}

	public Room(String name, int capacity, int rate) {
		this.id = 0;
		this.name = name;
		this.capacity = capacity;
		this.rate = rate;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {

		if (capacity < 0) {
			return; // antes se permitían capacidades negativas
		}

		this.capacity = capacity;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {

		if (rate < 0) {
			return; // antes se permitían tarifas negativas
		}

		this.rate = rate;
	}

	@Override
	public String toString() {
		return name;
	}
}