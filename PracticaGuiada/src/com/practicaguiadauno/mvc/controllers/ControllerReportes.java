package com.practicaguiadauno.mvc.controllers;

import com.practicaguiadauno.mvc.view.ViewPrincipal;
import com.practicaguiadauno.mvc.view.reservaciones.Reportes;

public class ControllerReportes extends Functions {

	private ViewPrincipal vp;

	public ControllerReportes(ViewPrincipal vp) {
		this.vp = vp;
	}

	public void reportes() {

		Reportes v = new Reportes();

		vp.setContenido(v, "Hotel La Cricka de Martha - Reportes");
	}
}