package com.practicaguiadauno.utils;

import javax.swing.JOptionPane;

public class Message {

    public static void info(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void warning(String msg) {
        JOptionPane.showMessageDialog(null, msg, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
    }

    public static boolean confirm(String msg) {
        int res = JOptionPane.showConfirmDialog(null, msg, "Confirmación", JOptionPane.YES_NO_OPTION);
        return res == JOptionPane.YES_OPTION;
    }
}