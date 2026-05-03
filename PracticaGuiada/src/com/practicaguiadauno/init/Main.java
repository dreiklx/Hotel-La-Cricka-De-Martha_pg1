package com.practicaguiadauno.init;

import javax.swing.SwingUtilities;

import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import com.practicaguiadauno.mvc.controllers.MainController;
import com.practicaguiadauno.utils.Message;

public class Main {

	public static void main(String[] args) {
		//new MainController();
		try {

			SwingUtilities.invokeLater(() -> {
				try {

					FlatGradiantoNatureGreenIJTheme.setup();

					new MainController();
				} catch (Exception e) {
					Message.error("Error al iniciar la interfaz");
				}
			});

		} catch (Exception e) {
			Message.error("Error crítico al iniciar la aplicación");
		}
	}
}