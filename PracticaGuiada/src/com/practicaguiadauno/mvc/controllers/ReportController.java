package com.practicaguiadauno.mvc.controllers;

import com.practicaguiadauno.mvc.model.Reservation;
import com.practicaguiadauno.mvc.model.ReservationList;
import com.practicaguiadauno.mvc.view.ViewMajor;
import com.practicaguiadauno.mvc.view.panels.Reports;
import com.practicaguiadauno.utils.Message;

import java.time.LocalDate;
import java.time.ZoneId;

public class ReportController extends Functions {

	private ViewMajor vp;
	private ReservationList reservations;

	public ReportController(ViewMajor vp, ReservationList reservations) {
		this.vp = vp;
		this.reservations = reservations;
	}

	public void reports() {

		try {

			Reports v = new Reports();

			// cargar clientes y alimentos frecuentes
			v.getModeloClientes().setDataVector(
					reservations.getClientData(),
					reservations.getClientColumns()
			);
			
			v.getModeloAlimentos().setDataVector(
			        reservations.getTopFoods(),
			        reservations.getFoodColumns()
			);

			v.getBtnCargar().addActionListener(e -> {

				try {

					LocalDate start = getDate(v.getStartDate());
					LocalDate end = getDate(v.getEndDate());

					if (start == null || end == null) {
						throw new Exception("Debe seleccionar ambas fechas");
					}

					if (end.isBefore(start)) {
						throw new Exception("Rango de fechas inválido");
					}

					int totalReservations = 0;
					int totalLodging = 0;
					int totalFood = 0;

					for (Reservation r : reservations.getReservationList()) {

						if (!r.getEntryDate().isBefore(start) &&
							!r.getExitDate().isAfter(end)) {

							totalReservations++;
							totalLodging += r.totalLodgingCost();
							totalFood += r.getFoodList().totalFoods();
						}
					}

					v.getLblReservaciones().setText(String.valueOf(totalReservations));
					v.getLblTotalhospedaje().setText(String.valueOf(totalLodging));
					v.getLblTotalalimentos().setText(String.valueOf(totalFood));
					v.getLblTotal().setText(String.valueOf(totalLodging + totalFood));

				} catch (Exception ex) {
					Message.error(ex.getMessage());
				}
			});

			vp.setContenido(v, "Hotel La Cricka de Martha - Reportes");

		} catch (Exception e) {
			Message.error("Error al cargar reportes");
		}
	}

	private LocalDate getDate(com.toedter.calendar.JDateChooser d) {
		if (d.getDate() == null) return null;
		return d.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}