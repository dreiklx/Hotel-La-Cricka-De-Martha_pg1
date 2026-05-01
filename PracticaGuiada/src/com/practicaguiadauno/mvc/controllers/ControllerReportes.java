package com.practicaguiadauno.mvc.controllers;

import com.practicaguiadauno.mvc.view.ViewMajor;
import com.practicaguiadauno.mvc.view.reservations.Reports;

public class ControllerReportes extends Functions {

	private ViewMajor vp;

	public ControllerReportes(ViewMajor vp) {
		this.vp = vp;
	}

	public void reportes() {

		Reports v = new Reports();

		vp.setContenido(v, "Hotel La Cricka de Martha - Reportes");
	}
}