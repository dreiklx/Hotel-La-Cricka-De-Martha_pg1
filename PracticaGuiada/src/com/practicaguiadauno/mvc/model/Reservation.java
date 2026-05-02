package com.practicaguiadauno.mvc.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

	private int id;
	private Room room;
	private String clientName;
	private LocalDate entryDate;
	private LocalDate exitDate;
	private int totalNights;
	private int totalPeople;
	private FoodList foodList;

	public Reservation(int id, Room room, String clientName, LocalDate entryDate, LocalDate exitDate,
			int totalPeople) {

		this.id = id;
		this.room = room;
		this.clientName = clientName;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.totalPeople = totalPeople;
		this.foodList = new FoodList(); // antes se usaba ListaAlimentos

		this.totalNights = calculateNights();
	}

	public Reservation(Room room, String clientName, LocalDate entryDate, LocalDate exitDate,
			int totalPeople) {

		this.id = 0;
		this.room = room;
		this.clientName = clientName;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.totalPeople = totalPeople;
		this.foodList = new FoodList(); // antes se usaba ListaAlimentos

		this.totalNights = calculateNights();
	}

	public int calculateNights() {

		if (entryDate == null || exitDate == null) {
			return 0;
		}

		long days = ChronoUnit.DAYS.between(entryDate, exitDate);

		if (days < 0) {
			return 0; // antes podía devolver negativos
		}

		return (int) days;
	}

	public int costPerNight() {

		if (room == null) {
			return 0; // antes podía tirar NullPointer
		}

		return room.getRate() * totalPeople;
	}

	public int totalLodgingCost() {
		return costPerNight() * totalNights;
	}

	public int totalCost() {

		if (foodList == null) {
			return totalLodgingCost(); // antes podía tirar NullPointer
		}

		return totalLodgingCost() + foodList.totalFoods();
	}

	public boolean isWithinCapacity() {
		return room != null && totalPeople <= room.getCapacity(); 
	}

	public boolean isValid() {

		return room != null &&
			   clientName != null &&
			   !clientName.trim().isEmpty() &&
			   entryDate != null &&
			   exitDate != null &&
			   totalPeople > 0 &&
			   !exitDate.isBefore(entryDate);
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {

		if (room == null) {
			return; // antes se podía dejar null
		}

		this.room = room;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {

		if (clientName == null || clientName.trim().isEmpty()) {
			return; // antes se permitían strings vacíos
		}

		this.clientName = clientName.trim();
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {

		if (entryDate == null) {
			return; // antes podía romper
		}

		this.entryDate = entryDate;
		this.totalNights = calculateNights();
	}

	public LocalDate getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDate exitDate) {

		if (exitDate == null) {
			return; // antes podía romper
		}

		this.exitDate = exitDate;
		this.totalNights = calculateNights();
	}

	public int getTotalNights() {
		return totalNights;
	}

	public void setTotalNights(int totalNights) {
		this.totalNights = totalNights;
	}

	public int getTotalPeople() {
		return totalPeople;
	}

	public void setTotalPeople(int totalPeople) {

		if (totalPeople < 0) {
			return; // antes se permitían negativos
		}

		this.totalPeople = totalPeople;
	}

	public FoodList getFoodList() {
		return foodList;
	}

	public void setFoodList(FoodList foodList) {

		if (foodList == null) {
			return; // antes se podía dejar null
		}

		this.foodList = foodList;
	}
}