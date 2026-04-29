package com.practicaguiadauno.mvc.model;

public class Alimento {
	private int id;
	private String nombre;
	private int precio;
	private int cantidad;

	public Alimento(int id, String nombre, int precio, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Alimento(String nombre, int precio) {
		this.id = 0;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = 0;
	}
	//constructor para agregar a la lista de la Reservacion
	public Alimento(Alimento a, int cantidad) {
		this.id = 0;
		this.nombre = a.getNombre();
		this.precio = a.getPrecio();
		this.cantidad = cantidad;
	}
	
	//Calcula el Subtotal
	public int getSubtotal() {
		return precio * cantidad;
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
