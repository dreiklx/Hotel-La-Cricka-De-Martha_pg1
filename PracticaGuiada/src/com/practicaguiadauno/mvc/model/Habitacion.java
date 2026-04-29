package com.practicaguiadauno.mvc.model;

public class Habitacion {
	private int id;
	private String nombre;
	private int capacidad;
	private int tarifa;

	public Habitacion(int id, String nombre, int capacidad, int tarifa) {
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tarifa = tarifa;
	}

	public Habitacion(String nombre, int capacidad, int tarifa) {
		this.id = 0;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tarifa = tarifa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
