package com.practicaguiadauno.utils;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.formdev.flatlaf.intellijthemes.*;


public class Themes {
	
	public static void setThemes(JTable t) {

	    FlatGradiantoNatureGreenIJTheme themeTable = new FlatGradiantoNatureGreenIJTheme();
	    UIDefaults d = themeTable.getDefaults();

	    Color bg = d.getColor("Table.background");
	    Color fg = d.getColor("Table.foreground");
	    Color selBg = d.getColor("Table.selectionBackground");
	    Color selFg = d.getColor("Table.selectionForeground");
	    Color alt = d.getColor("Table.alternateRowColor");

	    // Renderer con alternating
	    t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	        public Component getTableCellRendererComponent(
	                JTable table, Object value, boolean isSelected,
	                boolean hasFocus, int row, int column) {

	            Component c = super.getTableCellRendererComponent(
	                    table, value, isSelected, hasFocus, row, column);

	            if (isSelected) {
	                c.setBackground(selBg);
	                c.setForeground(selFg);
	            } else {
	                if (row % 2 == 0) {
	                    c.setBackground(bg);
	                } else {
	                    c.setBackground(alt != null ? alt : new Color(41,77,76));
	                }
	                c.setForeground(fg);
	            }

	            return c;
	        }
	    });

	    // Header
	    JTableHeader header = t.getTableHeader();
	    header.setBackground(d.getColor("TableHeader.background"));
	    header.setForeground(d.getColor("TableHeader.foreground"));

	    // Fuente
	    t.setFont(Fonts.text(13));
	}

}
