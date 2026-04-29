package com.practicaguiadauno.mvc.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListaAlimentos {

	private int id;
	private ArrayList<Alimento> listaAlimentos;

	public ListaAlimentos() {
		listaAlimentos = new ArrayList<>();
		id = 1;
	}

	// Agrega un alimento a la lista
	public void add(Alimento item) {
		if (item.getId() == 0) {
			item.setId(id++);
		}
		listaAlimentos.add(item);
	}

	// Encuentra un alimento por ID
	public Alimento find(int id) {
		Alimento item = null;
		for (Alimento a : listaAlimentos) {
			if (a.getId() == id) {
				item = a;
				break;
			}
		}
		return item;
	}
	public Alimento findByName(String nombre) {
		Alimento item = null;
		for (Alimento a : listaAlimentos) {
			if (a.getNombre() == nombre) {
				item = a;
				break;
			}
		}
		return item;
	}

	// Elimina un Alimento
	public void delete(int id) {
		Alimento item = find(id);
		listaAlimentos.remove(item);
	}

	// Obtener el total de la lista de alimentos
	public int totalAlimentos() {
		return listaAlimentos.stream().mapToInt(a -> a.getSubtotal()).sum();
	}

	// String de alimentos
	public String getAll() {
		return listaAlimentos.stream().map(obj -> obj.toString()).collect(Collectors.joining("\n"));
	}

	// Obtener Columnas
	public String[] getColums() {
		return new String[] { "ID", "Nombre", "Precio", "Cantidad", "Subtotal" };
	}

	// Obtener Información, tabla Gestionar Alimentos, Alimentos
	// Consumidos
	public Object[][] getData() {
		Object[][] data = new Object[listaAlimentos.size()][getColums().length];
		int i = 0;
		for (Alimento item : listaAlimentos) {
			data[i][0] = item.getId();
			data[i][1] = item.getNombre();
			data[i][2] = item.getPrecio();
			data[i][3] = item.getCantidad();
			data[i][4] = item.getSubtotal();
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

	public ArrayList<Alimento> getListaAlimentos() {
		return listaAlimentos;
	}

	public void setListaAlimentos(ArrayList<Alimento> listaAlimentos) {
		this.listaAlimentos = listaAlimentos;
	}

}