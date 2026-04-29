package com.practicaguiadauno.mvc.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaCategoriasA {
	private int id;
	private ArrayList<CategoriaAlimento> listaCategoria;
	
	public ListaCategoriasA() {
		listaCategoria = new ArrayList<>();
		id = 1;
	}
	
    
	// Agrega una categoria a la lista
	public void add(CategoriaAlimento item) {
		if (item.getId() == 0) {
			item.setId(id++);
		}
		listaCategoria.add(item);
	}

	// Encuentra una categoria por ID
	public CategoriaAlimento find(int id) {
		CategoriaAlimento item = null;
		for (CategoriaAlimento c : listaCategoria) {
			if (c.getId() == id) {
				item = c;
				break;
			}
		}
		return item;
	}

	// Elimina un Alimento
	public void delete(int id) {
		CategoriaAlimento item = find(id);
		listaCategoria.remove(item);
	}

	// String de alimentos
	public String getAll() {
		return listaCategoria.stream().map(obj -> obj.toString()).collect(Collectors.joining("\n\n"));
	}

	// Obtener Columnas
	public String[] getColums() {
		return new String[] { "ID", "Nombre", "Lista" };
	}

	// Obtener Ingormación
	public Object[][] getData() {
		Object[][] data = new Object[listaCategoria.size()][getColums().length];
		int i = 0;
		for (CategoriaAlimento item : listaCategoria) {
			data[i][0] = item.getId();
			data[i][1] = item.getNombre();
			data[i][2] = item.getListaAlimentos().getAll();
			i++;
		}
		return data;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<CategoriaAlimento> getListaCategoria() {
		return listaCategoria;
	}


	public void setListaCategoria(ArrayList<CategoriaAlimento> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
	
}
