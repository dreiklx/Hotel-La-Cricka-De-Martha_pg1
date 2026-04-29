package com.practicaguiadauno.mvc.view.reservaciones;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class See extends JPanel {
	private JButton btnEditar;
	private JLabel lblId;
	private JLabel lblCliente;
	private JLabel lblHabitacion;
	private JLabel lblCapMax;
	private JLabel lblTarifa;
	private JLabel lblEntrada;
	private JLabel lblSalida;
	private JButton btnAlimentos;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblCantPer;
	private JLabel lblCantNoches;
	private JLabel lblCostoNoche;
	private JLabel lblCostoTHospe;
	private JLabel lblCostoTAlimentos;
	private JLabel lblTotal;

	/**
	 * Create the panel.
	 */
	public See() {
		setLayout(new BorderLayout(0, 0));
		
		panelReservacion();
		panelAlimentos();
		panelInferior();
	}

	public void panelReservacion() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Datos de la Reservación"));

		panel.setPreferredSize(new Dimension(270, 10));
		add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 30, 24, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Entrada:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 156, 100, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 56, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tarifa por persona por Noche:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 131, 166, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Habitaci\u00F3n:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 81, 63, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Capacidad M\u00E1xima:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 106, 115, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha de Salida:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 181, 100, 14);
		panel.add(lblNewLabel_6);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(99, 251, 89, 23);
		panel.add(btnEditar);
		
		lblId = new JLabel("");
		lblId.setBounds(44, 30, 81, 14);
		panel.add(lblId);
		
		lblCliente = new JLabel("");
		lblCliente.setBounds(64, 56, 112, 14);
		panel.add(lblCliente);
		
		lblHabitacion = new JLabel("");
		lblHabitacion.setBounds(83, 81, 115, 14);
		panel.add(lblHabitacion);
		
		lblCapMax = new JLabel("");
		lblCapMax.setBounds(130, 106, 89, 14);
		panel.add(lblCapMax);
		
		lblTarifa = new JLabel("");
		lblTarifa.setBounds(186, 131, 74, 14);
		panel.add(lblTarifa);
		
		lblEntrada = new JLabel("");
		lblEntrada.setBounds(120, 156, 140, 14);
		panel.add(lblEntrada);
		
		lblSalida = new JLabel("");
		lblSalida.setBounds(118, 181, 142, 14);
		panel.add(lblSalida);
	}
	
	public void panelAlimentos() {
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setBorder(BorderFactory.createTitledBorder("Alimentos"));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.SOUTH);
		
		btnAlimentos = new JButton("Alimentos");
		panel.add(btnAlimentos);
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
	}
	
	public void panelInferior(){
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder(""));
		panel_2.setPreferredSize(new Dimension(10, 200));
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(null);
		
		lblNewLabel_7 = new JLabel("Cantidad de Personas:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 11, 134, 14);
		panel_2.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Cantidad de Noches:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 39, 124, 14);
		panel_2.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Costo por Noche:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(10, 64, 100, 14);
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Costo Total Hospedaje:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(10, 107, 134, 14);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Costo Total Alimentos:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(10, 132, 134, 14);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Total:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_12.setBounds(10, 157, 57, 21);
		panel_2.add(lblNewLabel_12);
		
		lblCantPer = new JLabel("");
		lblCantPer.setBounds(143, 11, 124, 14);
		panel_2.add(lblCantPer);
		
		lblCantNoches = new JLabel("");
		lblCantNoches.setBounds(133, 39, 134, 14);
		panel_2.add(lblCantNoches);
		
		lblCostoNoche = new JLabel("");
		lblCostoNoche.setBounds(120, 64, 147, 14);
		panel_2.add(lblCostoNoche);
		
		lblCostoTHospe = new JLabel("");
		lblCostoTHospe.setBounds(154, 107, 113, 14);
		panel_2.add(lblCostoTHospe);
		
		lblCostoTAlimentos = new JLabel("");
		lblCostoTAlimentos.setBounds(154, 132, 113, 14);
		panel_2.add(lblCostoTAlimentos);
		
		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotal.setBounds(77, 157, 124, 21);
		panel_2.add(lblTotal);
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblCliente() {
		return lblCliente;
	}

	public void setLblCliente(JLabel lblCliente) {
		this.lblCliente = lblCliente;
	}

	public JLabel getLblHabitacion() {
		return lblHabitacion;
	}

	public void setLblHabitacion(JLabel lblHabitacion) {
		this.lblHabitacion = lblHabitacion;
	}

	public JLabel getLblCapMax() {
		return lblCapMax;
	}

	public void setLblCapMax(JLabel lblCapMax) {
		this.lblCapMax = lblCapMax;
	}

	public JLabel getLblTarifa() {
		return lblTarifa;
	}

	public void setLblTarifa(JLabel lblTarifa) {
		this.lblTarifa = lblTarifa;
	}

	public JLabel getLblEntrada() {
		return lblEntrada;
	}

	public void setLblEntrada(JLabel lblEntrada) {
		this.lblEntrada = lblEntrada;
	}

	public JLabel getLblSalida() {
		return lblSalida;
	}

	public void setLblSalida(JLabel lblSalida) {
		this.lblSalida = lblSalida;
	}

	public JButton getBtnAlimentos() {
		return btnAlimentos;
	}

	public void setBtnAlimentos(JButton btnAlimentos) {
		this.btnAlimentos = btnAlimentos;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JLabel getLblNewLabel_7() {
		return lblNewLabel_7;
	}

	public void setLblNewLabel_7(JLabel lblNewLabel_7) {
		this.lblNewLabel_7 = lblNewLabel_7;
	}

	public JLabel getLblNewLabel_8() {
		return lblNewLabel_8;
	}

	public void setLblNewLabel_8(JLabel lblNewLabel_8) {
		this.lblNewLabel_8 = lblNewLabel_8;
	}

	public JLabel getLblNewLabel_9() {
		return lblNewLabel_9;
	}

	public void setLblNewLabel_9(JLabel lblNewLabel_9) {
		this.lblNewLabel_9 = lblNewLabel_9;
	}

	public JLabel getLblNewLabel_10() {
		return lblNewLabel_10;
	}

	public void setLblNewLabel_10(JLabel lblNewLabel_10) {
		this.lblNewLabel_10 = lblNewLabel_10;
	}

	public JLabel getLblNewLabel_11() {
		return lblNewLabel_11;
	}

	public void setLblNewLabel_11(JLabel lblNewLabel_11) {
		this.lblNewLabel_11 = lblNewLabel_11;
	}

	public JLabel getLblCantPer() {
		return lblCantPer;
	}

	public void setLblCantPer(JLabel lblCantPer) {
		this.lblCantPer = lblCantPer;
	}

	public JLabel getLblCantNoches() {
		return lblCantNoches;
	}

	public void setLblCantNoches(JLabel lblCantNoches) {
		this.lblCantNoches = lblCantNoches;
	}

	public JLabel getLblCostoNoche() {
		return lblCostoNoche;
	}

	public void setLblCostoNoche(JLabel lblCostoNoche) {
		this.lblCostoNoche = lblCostoNoche;
	}

	public JLabel getLblCostoTHospe() {
		return lblCostoTHospe;
	}

	public void setLblCostoTHospe(JLabel lblCostoTHospe) {
		this.lblCostoTHospe = lblCostoTHospe;
	}

	public JLabel getLblCostoTAlimentos() {
		return lblCostoTAlimentos;
	}

	public void setLblCostoTAlimentos(JLabel lblCostoTAlimentos) {
		this.lblCostoTAlimentos = lblCostoTAlimentos;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}
	
}

