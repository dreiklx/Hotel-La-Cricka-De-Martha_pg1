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

public class Index extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JButton btnFood;
	private JButton btnDelete;
	private JButton btnSee;
	private JButton btnNew;

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSearch = new JPanel();

		pnlSearch.setBorder(new EmptyBorder(10, 0, 10, 0));
		pnlSearch.setPreferredSize(new Dimension(10, 60));
		add(pnlSearch, BorderLayout.NORTH);
		pnlSearch.setBorder(BorderFactory.createTitledBorder("Reservaciones"));
		pnlSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblSearch = new JLabel("Buscar:");
		lblSearch.setHorizontalTextPosition(SwingConstants.LEFT);
		lblSearch.setHorizontalAlignment(SwingConstants.LEFT);
		pnlSearch.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setPreferredSize(new Dimension(400, 20));
		pnlSearch.add(txtSearch);
		txtSearch.setColumns(10);
		
		JPanel pnlButtons = new JPanel();
		pnlButtons.setAlignmentY(5.0f);
		pnlButtons.setAlignmentX(5.0f);
		pnlButtons.setPreferredSize(new Dimension(10, 60));
		add(pnlButtons, BorderLayout.SOUTH);
		FlowLayout fl_pnlButtons = new FlowLayout(FlowLayout.RIGHT, 15, 17);
		fl_pnlButtons.setAlignOnBaseline(true);
		pnlButtons.setLayout(fl_pnlButtons);
		
		btnNew = new JButton("Nueva");
		btnNew.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNew.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNew.setHorizontalTextPosition(SwingConstants.CENTER);
		pnlButtons.add(btnNew);
		
		btnSee = new JButton("Ver");
		btnSee.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSee.setHorizontalTextPosition(SwingConstants.CENTER);
		pnlButtons.add(btnSee);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
		pnlButtons.add(btnDelete);
		
		btnFood = new JButton("Alimentos");
		btnFood.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnFood.setHorizontalTextPosition(SwingConstants.CENTER);
		pnlButtons.add(btnFood);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

	}

	public JTextField getTextField() {
		return txtSearch;
	}

	public void setTextField(JTextField textField) {
		this.txtSearch = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getBtnAlimentos() {
		return btnFood;
	}

	public void setBtnAlimentos(JButton btnAlimentos) {
		this.btnFood = btnAlimentos;
	}

	public JButton getBtnEliminar() {
		return btnDelete;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnDelete = btnEliminar;
	}

	public JButton getBtnVer() {
		return btnSee;
	}

	public void setBtnVer(JButton btnVer) {
		this.btnSee = btnVer;
	}

	public JButton getBtnNueva() {
		return btnNew;
	}

	public void setBtnNueva(JButton btnNueva) {
		this.btnNew = btnNueva;
	}

}
