package com.practicaguiadauno.mvc.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FoodCategoryList {

	private int id;
	private ArrayList<FoodCategory> categoryList;

	public FoodCategoryList() {
		this.categoryList = new ArrayList<>();
		this.id = 1;
	}

	// Agrega una categoria a la lista
	public void add(FoodCategory item) {

		if (item == null) {
			return; // antes no se controlaba null
		}

		if (item.getId() == 0) {
			item.setId(id++);
		}

		categoryList.add(item);
	}

	// Encuentra una categoria por ID
	public FoodCategory find(int id) {

		for (FoodCategory c : categoryList) {
			if (c.getId() == id) {
				return c; // antes se usaba variable innecesaria
			}
		}

		return null;
	}

	// Elimina una categoria
	public void delete(int id) {

		FoodCategory item = find(id);

		if (item != null) {
			categoryList.remove(item);
		} // antes se intentaba eliminar null
	}

	// String de categorias
	public String getAll() {
		return categoryList.stream()
				.map(obj -> obj.toString())
				.collect(Collectors.joining("\n\n"));
	}

	// Obtener Columnas
	public String[] getColumns() {
		return new String[] { "ID", "Nombre", "Lista" };
	}

	// Obtener Información
	public Object[][] getData() {

		Object[][] data = new Object[categoryList.size()][getColumns().length];

		int i = 0;

		for (FoodCategory item : categoryList) {

			data[i][0] = item.getId();
			data[i][1] = item.getName();
			data[i][2] = item.getFoodList().getAll(); // antes usaba clases viejas

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

	public ArrayList<FoodCategory> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<FoodCategory> categoryList) {

		if (categoryList == null) {
			return; // antes se podía asignar null
		}

		this.categoryList = categoryList;
	}
}