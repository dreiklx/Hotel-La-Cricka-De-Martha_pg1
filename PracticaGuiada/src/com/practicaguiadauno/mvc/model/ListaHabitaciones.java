package com.practicaguiadauno.mvc.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaHabitaciones {
	private int id;
	private ArrayList<Habitacion> listaHabitaciones;

	public ListaHabitaciones() {
		this.id = 1;
		this.listaHabitaciones = new ArrayList<>();
	}

	public void add(Habitacion item) {
		if (item.getId() == 0) {
			item.setId(id++);
		}
		listaHabitaciones.add(item);
	}

	public Habitacion find(int id) {
		Habitacion item = null;
		for (Habitacion h : listaHabitaciones) {
			if (h.getId() == id) {
				item = h;
				break;
			}
		}
		return item;
	}

	public void delete(int id) {
		Habitacion item = find(id);
		listaHabitaciones.remove(item);
	}

	public String getAll() {
		return listaHabitaciones.stream()
				.map(obj -> obj.toString()).collect(Collectors.joining("\n"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}

}
