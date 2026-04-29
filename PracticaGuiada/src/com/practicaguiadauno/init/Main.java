package com.practicaguiadauno.init;

import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import com.practicaguiadauno.mvc.controllers.MainController;

public class Main {

	public static void main(String[] args) {
		FlatGradiantoNatureGreenIJTheme.setup();
		new MainController();
	}
	
}
