package com.practicaguiadauno.utils;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;

public class IconUtils {
    public static ImageIcon getIcon(String name, int width, int height) {
        URL resource = IconUtils.class.getClassLoader().getResource("images/" + name);
        if (resource == null) return null;
        ImageIcon icon = new ImageIcon(resource);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}