package com.practicaguiadauno.mvc.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FoodList {

	private int id;
	private ArrayList<Food> foodList;

	public FoodList() {
		this.foodList = new ArrayList<>();
		this.id = 1;
	}

	// Agrega un alimento a la lista
	public void add(Food item) {

		if (item == null) {
			return; // antes no se controlaba null
		}

		if (item.getId() == 0) {
			item.setId(id++);
		}

		foodList.add(item);
	}

	// Encuentra un alimento por ID
	public Food find(int id) {

		for (Food a : foodList) {
			if (a.getId() == id) {
				return a; // antes se usaba variable innecesaria
			}
		}

		return null;
	}

	public Food findByName(String name) {

		if (name == null || name.trim().isEmpty()) {
			return null; // antes no se validaba vacío
		}

		for (Food a : foodList) {
			if (a.getName().equalsIgnoreCase(name.trim())) { // antes no ignoraba mayúsculas ni espacios
				return a;
			}
		}

		return null;
	}

	// Elimina un alimento
	public void delete(int id) {

		Food item = find(id);

		if (item != null) {
			foodList.remove(item);
		} // antes se intentaba eliminar null
	}

	// Obtener el total de la lista de alimentos
	public int totalFoods() {
		return foodList.stream()
				.mapToInt(a -> a.getSubtotal())
				.sum();
	}

	// String de alimentos
	public String getAll() {
		return foodList.stream()
				.map(obj -> obj.toString())
				.collect(Collectors.joining("\n"));
	}

	// Obtener Columnas
	public String[] getColumns() {
		return new String[] { "ID", "Nombre", "Precio", "Cantidad", "Subtotal" };
	}

	// Obtener Información
	public Object[][] getData() {

		Object[][] data = new Object[foodList.size()][getColumns().length];

		int i = 0;

		for (Food item : foodList) {

			data[i][0] = item.getId();
			data[i][1] = item.getName();
			data[i][2] = item.getPrice();
			data[i][3] = item.getQuantity();
			data[i][4] = item.getSubtotal();

			i++;
		}

		return data;
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

	public ArrayList<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(ArrayList<Food> foodList) {

		if (foodList == null) {
			return; // antes se podía asignar null
		}

		this.foodList = foodList;
	}
}