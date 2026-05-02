package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import javax.swing.JTable;

@SuppressWarnings("unused")
public class Index extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;

	private JButton btnFood;
	private JButton btnDelete;
	private JButton btnSee;
	private JButton btnEdit;
	private JButton btnNew;

	public Index() {

		setLayout(new BorderLayout(0, 0));

		JPanel pnlSearch = new JPanel();

		pnlSearch.setBorder(new EmptyBorder(10, 0, 10, 0));
		pnlSearch.setPreferredSize(new Dimension(10, 60));
		add(pnlSearch, BorderLayout.NORTH);
		pnlSearch.setBorder(BorderFactory.createTitledBorder("Reservaciones"));
		pnlSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblSearch = new JLabel("Buscar:");
		lblSearch.setHorizontalAlignment(SwingConstants.LEFT);
		pnlSearch.add(lblSearch);

		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setPreferredSize(new Dimension(400, 25));
		txtSearch.setColumns(10);
		pnlSearch.add(txtSearch);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setPreferredSize(new Dimension(10, 60));
		add(pnlButtons, BorderLayout.SOUTH);

		FlowLayout fl_pnlButtons = new FlowLayout(FlowLayout.RIGHT, 15, 17);
		fl_pnlButtons.setAlignOnBaseline(true);
		pnlButtons.setLayout(fl_pnlButtons);

		btnNew = new JButton("Nueva");
		pnlButtons.add(btnNew);

		btnSee = new JButton("Ver");
		pnlButtons.add(btnSee);
		
		btnEdit = new JButton("Editar");
		pnlButtons.add(btnEdit);

		btnDelete = new JButton("Eliminar");
		pnlButtons.add(btnDelete);

		btnFood = new JButton("Alimentos");
		pnlButtons.add(btnFood);

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);


		modelo = new DefaultTableModel();

		table = new JTable(modelo) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};

		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		// bloquear mover columnas
		table.getTableHeader().setReorderingAllowed(false);

		// bloquear cambiar tamaño
		table.getTableHeader().setResizingAllowed(false);

		scrollPane.setViewportView(table);
	}

	// getters

	public JTextField getTxtSearch() { 
		return txtSearch; 
	}
	public JButton getBtnEditar() {
		return btnEdit;
	}

	public JTable getTable() { return table; }

	public DefaultTableModel getModelo() { return modelo; }

	public JScrollPane getScrollPane() { return scrollPane; }

	public JButton getBtnAlimentos() { return btnFood; }

	public JButton getBtnEliminar() { return btnDelete; }

	public JButton getBtnVer() { return btnSee; }

	public JButton getBtnNueva() { return btnNew; }
}