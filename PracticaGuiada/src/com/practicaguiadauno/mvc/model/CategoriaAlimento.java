package com.practicaguiadauno.mvc.model;

public class CategoriaAlimento {
	private int id;
	private String nombre;
	private ListaAlimentos listaAlimentos;
	
	public CategoriaAlimento(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.listaAlimentos = new ListaAlimentos();
	}
	
	public CategoriaAlimento(String nombre) {
		this.id = 0;
		this.nombre = nombre;
		this.listaAlimentos = new ListaAlimentos();
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

	public ListaAlimentos getListaAlimentos() {
		return listaAlimentos;
	}

	public void setListaAlimentos(ListaAlimentos listaAlimentos) {
		this.listaAlimentos = listaAlimentos;
	}

	@Override
	public String toString() {
		return  nombre;
	}
	
}
