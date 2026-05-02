package com.practicaguiadauno.mvc.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class RoomList {

	private int id;
	private ArrayList<Room> roomList;

	public RoomList() {
		this.id = 1;
		this.roomList = new ArrayList<>();
	}

	public void add(Room item) {

		if (item == null) {
			return; // antes no se controlaba null
		}

		if (item.getId() == 0) {
			item.setId(id++);
		}

		roomList.add(item);
	}

	public Room find(int id) {

		for (Room h : roomList) {
			if (h.getId() == id) {
				return h; // antes se usaba variable innecesaria
			}
		}

		return null;
	}

	public void delete(int id) {

		Room item = find(id);

		if (item != null) {
			roomList.remove(item);
		} // antes se intentaba eliminar null
	}

	public String getAll() {
		return roomList.stream()
				.map(obj -> obj.toString())
				.collect(Collectors.joining("\n"));
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

	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(ArrayList<Room> roomList) {

		if (roomList == null) {
			return; // antes se podía asignar null
		}

		this.roomList = roomList;
	}
}