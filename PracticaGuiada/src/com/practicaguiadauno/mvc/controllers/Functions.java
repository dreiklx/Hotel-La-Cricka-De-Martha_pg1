package com.practicaguiadauno.mvc.controllers;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Functions {

	// Funciones generalizadas

	public void search(JTable table, String text, int... cols) {

		if (table == null || text == null) return;
		// antes no se validaba null y podía romper

		TableRowSorter<TableModel> sorter =
				new TableRowSorter<>(table.getModel());

		table.setRowSorter(sorter);

		if (text.trim().isEmpty()) {
			sorter.setRowFilter(null); 
			// antes siempre aplicaba filtro aunque estuviera vacío
			return;
		}

		sorter.setRowFilter(
				RowFilter.regexFilter("(?i)" + text.trim(), cols)
		);
	}

	public int getSelectedID(JTable table) {

		if (table == null || table.getSelectedRow() < 0) {
			return -1;
		}

		try {

			int viewRow = table.getSelectedRow();

			int modelRow = table.convertRowIndexToModel(viewRow);
			// antes no convertía → fallaba cuando había filtro

			Object value = table.getModel().getValueAt(modelRow, 0);

			if (value instanceof Integer) {
				return (int) value;
			}

			return Integer.parseInt(value.toString());
			// antes asumía siempre int directo → podía explotar

		} catch (Exception e) {
			return -1;
			// antes no manejaba errores
		}
	}
}