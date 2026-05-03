package com.practicaguiadauno.utils;

import java.awt.Font;
import java.io.InputStream;

public class Fonts {
	

	private static Font Title=loadFont("/fonts/BebasNeue-Regular.ttf");
	private static Font Text=loadFont("/fonts/Roboto-Bold.ttf");

	public static Font loadFont(String f){
		try {
			InputStream getText=Fonts.class.getResourceAsStream(f);
			return Font.createFont(Font.TRUETYPE_FONT, getText);

		}catch (Exception e) {
			Message.warning("Fallo en carga de la fuente de letra.\n\t"+f+"\n\nSe cargaron fuentes de respaldo.");
			return new Font("Arial", Font.PLAIN, 14);
		}
	}
	public static Font title(float size) {
		return Title.deriveFont(size);
	}
	public static Font text(float size) {
		return Text.deriveFont(size);
	}

}
