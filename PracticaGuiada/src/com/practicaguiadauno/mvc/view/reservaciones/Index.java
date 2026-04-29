package com.practicaguiadauno.mvc.view.reservaciones;

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
	private JTextField textField;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JButton btnAlimentos;
	private JButton btnEliminar;
	private JButton btnVer;
	private JButton btnNueva;

	/**
	 * Create the panel.
	 */
	public Index() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelBuscar = new JPanel();

		panelBuscar.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelBuscar.setPreferredSize(new Dimension(10, 60));
		add(panelBuscar, BorderLayout.NORTH);
		panelBuscar.setBorder(BorderFactory.createTitledBorder("Reservaciones"));
		panelBuscar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setHorizontalTextPosition(SwingConstants.LEFT);
		lblBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		panelBuscar.add(lblBuscar);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setPreferredSize(new Dimension(400, 20));
		panelBuscar.add(textField);
		textField.setColumns(10);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setAlignmentY(5.0f);
		panelBotones.setAlignmentX(5.0f);
		panelBotones.setPreferredSize(new Dimension(10, 60));
		add(panelBotones, BorderLayout.SOUTH);
		FlowLayout fl_panelBotones = new FlowLayout(FlowLayout.RIGHT, 15, 17);
		fl_panelBotones.setAlignOnBaseline(true);
		panelBotones.setLayout(fl_panelBotones);
		
		btnNueva = new JButton("Nueva");
		btnNueva.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNueva.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNueva.setHorizontalTextPosition(SwingConstants.CENTER);
		panelBotones.add(btnNueva);
		
		btnVer = new JButton("Ver");
		btnVer.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnVer.setHorizontalTextPosition(SwingConstants.CENTER);
		panelBotones.add(btnVer);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
		panelBotones.add(btnEliminar);
		
		btnAlimentos = new JButton("Alimentos");
		btnAlimentos.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAlimentos.setHorizontalTextPosition(SwingConstants.CENTER);
		panelBotones.add(btnAlimentos);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);

	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
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
		return btnAlimentos;
	}

	public void setBtnAlimentos(JButton btnAlimentos) {
		this.btnAlimentos = btnAlimentos;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnVer() {
		return btnVer;
	}

	public void setBtnVer(JButton btnVer) {
		this.btnVer = btnVer;
	}

	public JButton getBtnNueva() {
		return btnNueva;
	}

	public void setBtnNueva(JButton btnNueva) {
		this.btnNueva = btnNueva;
	}

}
