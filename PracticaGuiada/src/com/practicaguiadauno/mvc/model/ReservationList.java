package com.practicaguiadauno.mvc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationList {

	private int id;
	private ArrayList<Reservation> reservationList;

	public ReservationList() {
		this.id = 1;
		this.reservationList = new ArrayList<>();
	}

	public void add(Reservation item) {

		if (item == null) {
			return; // antes no se controlaba null y podï¿½a romper
		}

		if (item.getId() == 0) {
			item.setId(id++);
		}

		reservationList.add(item);
	}

	public Reservation find(int id) {

		for (Reservation r : reservationList) {
			if (r.getId() == id) {
				return r;
			}
		}

		return null;
	}

	public void delete(int id) {

		Reservation item = find(id);

		if (item != null) {
			reservationList.remove(item);
		} // antes intentaba eliminar null
	}

	public String getAll() {
		return reservationList.stream().map(obj -> obj.toString()).collect(Collectors.joining("\n"));
	}

	public String[] getColumns() {
		return new String[] { "ID", "Cliente", "Habitación", "Entrada", "Salida", "Personas", "Noches" };
	}

	public Object[][] getData() {

		Object[][] data = new Object[reservationList.size()][getColumns().length];

		int i = 0;

		for (Reservation item : reservationList) {

			data[i][0] = item.getId();
			data[i][1] = item.getClientName();
			data[i][2] = item.getRoom().getName(); // antes usaba getNombre()
			data[i][3] = item.getEntryDate();
			data[i][4] = item.getExitDate();
			data[i][5] = item.getTotalPeople();
			data[i][6] = item.getTotalNights();

			i++;
		}

		return data;
	}

	public boolean isAvailable(Room room, LocalDate entry, LocalDate exit) {
		if (room == null || entry == null || exit == null) {
			return false;
		}
		return reservationList.stream().filter(e -> e.getRoom().getId() == room.getId())
				.noneMatch(e -> entry.isBefore(e.getExitDate()) && exit.isAfter(e.getEntryDate()));
	}

	public boolean isAvailableExcluding(Room room, LocalDate entry, LocalDate exit, int excludeId) {
		if (room == null || entry == null || exit == null) {
			return false;
		}
		return reservationList.stream().filter(e -> e.getId() != excludeId)//excluye la reservacion actual en edit
				.filter(e -> e.getRoom().getId() == room.getId())
				.noneMatch(e -> entry.isBefore(e.getExitDate()) && exit.isAfter(e.getEntryDate()));
	}

	public ReservationList findByClient(String client) {

		ReservationList filtered = new ReservationList();

		if (client == null || client.trim().isEmpty()) {
			return filtered; // antes no validaba esto
		}

		List<Reservation> result = reservationList.stream()
				.filter(e -> e.getClientName().equalsIgnoreCase(client.trim())).collect(Collectors.toList());

		filtered.reservationList.addAll(result);

		return filtered;
	}

	public ArrayList<Object[]> topClients() {

		ArrayList<String> clients = new ArrayList<>();
		ArrayList<Object[]> list = new ArrayList<>();

		for (Reservation r : reservationList) {

			if (!clients.contains(r.getClientName())) {
				clients.add(r.getClientName());
			}
		}

		for (String c : clients) {

			int count = findByClient(c).reservationList.size();

			Object[] o = new Object[2];
			o[0] = c;
			o[1] = count;

			list.add(o);
		}

		list.sort((a, b) -> Integer.compare((int) b[1], (int) a[1]));

		if (list.size() > 3) {
			return new ArrayList<>(list.subList(0, 3));
		}

		return list;
	}

	public String[] getClientColumns() {
		return new String[] { "Nombre", "Num. Reservaciones" };
	}

	public Object[][] getClientData() {

		ArrayList<Object[]> list = topClients();

		Object[][] data = new Object[list.size()][getClientColumns().length];

		int i = 0;

		for (Object[] item : list) {

			data[i][0] = item[0];
			data[i][1] = item[1];

			i++;
		}

		return data;
	}

	public Object[][] getTopFoods() {

		java.util.HashMap<String, Integer> map = new java.util.HashMap<>();

		for (Reservation r : reservationList) {

			for (Food f : r.getFoodList().getFoodList()) {

				map.put(f.getName(), map.getOrDefault(f.getName(), 0) + f.getQuantity());
			}
		}

		java.util.List<java.util.Map.Entry<String, Integer>> list = new java.util.ArrayList<>(map.entrySet());

		list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

		int size = Math.min(5, list.size());

		Object[][] data = new Object[size][2];

		for (int i = 0; i < size; i++) {
			data[i][0] = list.get(i).getKey();
			data[i][1] = list.get(i).getValue();
		}

		return data;
	}

	public String[] getFoodColumns() {
		return new String[] { "Nombre", "Cantidad" };
	}

	public ArrayList<Reservation> getReservationList() {
		return reservationList;
	}
}