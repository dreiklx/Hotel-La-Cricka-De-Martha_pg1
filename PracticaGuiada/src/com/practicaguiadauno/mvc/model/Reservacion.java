package com.practicaguiadauno.mvc.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservacion {
	private int id;
	private Habitacion habitacion;
	private String nomCliente;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private int cantNoches;
	private int cantPersonas;
	private ListaAlimentos listaAlimentos;

	public Reservacion(int id, Habitacion habitacion, String nomCliente, LocalDate fechaEntrada, LocalDate fechaSalida,
			 int cantPersonas) {
		this.id = id;
		this.habitacion = habitacion;
		this.nomCliente = nomCliente;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cantNoches = totalNoches();
		this.cantPersonas = cantPersonas;
		this.listaAlimentos = new ListaAlimentos();
	}

	public Reservacion(Habitacion habitacion, String nomCliente, LocalDate fechaEntrada, LocalDate fechaSalida,
			 int cantPersonas) {
		this.id = 0;
		this.habitacion = habitacion;
		this.nomCliente = nomCliente;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.cantNoches = totalNoches();
		this.cantPersonas = cantPersonas;
		this.listaAlimentos = new ListaAlimentos();
	}

	// Obtiene el total de noches
	public int totalNoches() {
		return (int) fechaEntrada.until(fechaSalida, ChronoUnit.DAYS);
	}

	// Retorna el costo por noche
	public int costoPorNoche() {
		return habitacion.getTarifa() * cantPersonas;
	}

	// retorna el costo total del hospedaje
	public int costoTotalHospedaje() {
		return costoPorNoche() * cantNoches;
	}

	// Obtener el total general de la reservacion
	public int totalGeneral() {
		return costoTotalHospedaje() + listaAlimentos.totalAlimentos();
	}

	//Devuelve un true si no supera la capacidad máxima
	public boolean capacidadMaximaPermitida() {
		return cantPersonas <= habitacion.getCapacidad();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		this.cantNoches = totalNoches();
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
		this.cantNoches = totalNoches();
	}

	public int getCantNoches() {
		return cantNoches;
	}

	public void setCantNoches(int cantNoches) {
		this.cantNoches = cantNoches;
	}

	public int getCantPersonas() {
		return cantPersonas;
	}

	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}

	public ListaAlimentos getListaAlimentos() {
		return listaAlimentos;
	}

	public void setListaAlimentos(ListaAlimentos listaAlimentos) {
		this.listaAlimentos = listaAlimentos;
	}
	
	
}
