package com.practicaguiadauno.utils;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

public class ImageUtils {
	
    public static ImageIcon getIcon(String name, int width, int height) {
        URL resource = ImageUtils.class.getClassLoader().getResource("images/" + name);
        if (resource == null) return null;
        ImageIcon icon = new ImageIcon(resource);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    
    public static ImageIcon getScaledIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    public static void setImageButton(JButton btn,ImageIcon icon,int width,int height) {
		btn.setIcon(ImageUtils.getScaledIcon(icon, width, height));
		btn.setHorizontalTextPosition(JButton.CENTER);
		btn.setVerticalTextPosition(JButton.CENTER);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setForeground(Color.BLACK);
    }

}