package com.practicaguiadauno.mvc.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaReservaciones {
	private int id;
	private ArrayList<Reservacion> listaReservaciones;

	public ListaReservaciones() {
		this.id = 1;
		this.listaReservaciones = new ArrayList<>();
	}

	public void add(Reservacion item) {
		if (item.getId() == 0) {
			item.setId(id++);
		}
		listaReservaciones.add(item);
	}

	public Reservacion find(int id) {
		Reservacion item = null;
		for (Reservacion r : listaReservaciones) {
			if (r.getId() == id) {
				item = r;
				break;
			}
		}
		return item;
	}

	public void delete(int id) {
		Reservacion item = find(id);
		listaReservaciones.remove(item);
	}

	public String getAll() {
		return listaReservaciones.stream().map(obj -> obj.toString()).collect(Collectors.joining("\n"));
	}

	public String[] getColumsRes() {
		return new String[] { "ID", "Cliente", "Habitación", "Entrada", "Salida",
				"Personas", "Noches" };
	}

	// Informacion de la tabla de Reservaciones
	public Object[][] getDataReservaciones() {
		Object[][] data = new Object[listaReservaciones.size()][getColumsRes().length];
		int i = 0;
		for (Reservacion item : listaReservaciones) {
			data[i][0] = item.getId();
			data[i][1] = item.getNomCliente();
			data[i][2] = item.getHabitacion().getNombre();
			data[i][3] = item.getFechaEntrada();
			data[i][4] = item.getFechaSalida();
			data[i][5] = item.getCantPersonas();
			data[i][6] = item.getCantNoches();
			i++;
		}
		return data;
	}

	// Metodo para que la reservacion no choque con otras
	public boolean disponible(Habitacion habitacion, LocalDate entrada, LocalDate salida) {
		return listaReservaciones.stream().filter(e -> e.getHabitacion().getId() == habitacion.getId())
				.noneMatch(e -> entrada.isBefore(e.getFechaSalida()) && salida.isAfter(e.getFechaEntrada()));
	}

	// Filtra las reservaciones por cliente
	public ListaReservaciones reservacionesPorCliente(String cliente) {
		ListaReservaciones filtradas = new ListaReservaciones();

		List<Reservacion> filtro = listaReservaciones.stream().filter(e -> e.getNomCliente().equalsIgnoreCase(cliente))
				.collect(Collectors.toList());

		filtradas.listaReservaciones.addAll(filtro);
		return filtradas;
	}

	// Devuelve los clientes más frecuentes
	public ArrayList<Object[]> clientesFrecuente() {

		ArrayList<String> clientes = new ArrayList<>();
		ArrayList<Object[]> lista = new ArrayList<>();

		for (Reservacion r : listaReservaciones) {
			if (!clientes.contains(r.getNomCliente())) {
				clientes.add(r.getNomCliente());
			}
		}
		for (String c : clientes) {
			int cantidad = reservacionesPorCliente(c).listaReservaciones.size();
			Object[] o = new Object[2];
			o[0] = c;
			o[1] = cantidad;
			lista.add(o);
		}
		lista.sort((a, b) -> Integer.compare((int) b[1], (int) a[1]));

		if (lista.size() > 3) {
			return new ArrayList<>(lista.subList(0, 3));
		}
		return lista;
	}

	// Columnas de la lista clientes frecuentes
	public String[] getColumsCli() {
		return new String[] { "Nombre", "Num. Reservaciones" };
	}

	// Informacion de la tabla de Clientes Frecuentes
	public Object[][] getDataClientesFrec() {
		ArrayList<Object[]> lista = clientesFrecuente();
		Object[][] data = new Object[lista.size()][getColumsCli().length];
		int i = 0;
		for (Object[] item : lista) {
			data[i][0] = item[0];
			data[i][1] = item[1];
			i++;
		}
		return data;
	}

}
