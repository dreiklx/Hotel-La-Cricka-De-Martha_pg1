package com.practicaguiadauno.mvc.model;

public class FoodCategory {

	private int id;
	private String name;
	private FoodList foodList;

	public FoodCategory(int id, String name) {
		this.id = id;
		this.name = name;
		this.foodList = new FoodList();
	}

	public FoodCategory(String name) {
		this.id = 0;
		this.name = name;
		this.foodList = new FoodList();
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

	public FoodList getFoodList() {
		return foodList;
	}

	public void setFoodList(FoodList foodList) {

		if (foodList == null) {
			return; // antes se podía dejar null y romper después
		}

		this.foodList = foodList;
	}

	@Override
	public String toString() {
		return name;
	}
}