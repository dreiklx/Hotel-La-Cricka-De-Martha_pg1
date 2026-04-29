package com.practicaguiadauno.mvc.view.reservaciones;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.practicaguiadauno.mvc.model.CategoriaAlimento;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class Alimentos extends JPanel {
	private JLabel lblId;
	private JLabel lblCliente;
	private JLabel lblHabitacion;
	private JLabel lblCapMax;
	private JLabel lblTarifa;
	private JLabel lblEntrada;
	private JLabel lblSalida;
	private JTable table;
	private DefaultTableModel modelo;
	private JComboBox cbxCategoria;
	private JComboBox cbxAlimento;
	private JSpinner spinner;
	private JLabel lblSubtotal;
	private JButton btnAgregar;
	private JScrollPane scrollPane;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblTotalalimentos;

	/**
	 * Create the panel.
	 */
	public Alimentos() {
		setLayout(new BorderLayout(0, 0));
		panelReservacion();
		panelGestionarAlimentos();
		panelTotaAlimentos();

	}

	public void panelReservacion() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(250, 10));
		add(panel, BorderLayout.WEST);
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
	
	public void panelGestionarAlimentos() {
		JPanel panelGestionAlimentos = new JPanel();
		add(panelGestionAlimentos, BorderLayout.CENTER);
		panelGestionAlimentos.setBorder(BorderFactory.createTitledBorder("Gestionar Alimentos"));
		panelGestionAlimentos.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 120));
		panelGestionAlimentos.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Categoria:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(10, 11, 67, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Alimento:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 36, 67, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Cantidad:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(10, 61, 53, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Subtotal:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_10.setBounds(10, 86, 79, 21);
		panel.add(lblNewLabel_10);
		
		cbxCategoria = new JComboBox<CategoriaAlimento>();
		cbxCategoria.setBounds(87, 8, 223, 20);
		panel.add(cbxCategoria);
		
		cbxAlimento = new JComboBox();
		cbxAlimento.setBounds(87, 33, 223, 20);
		panel.add(cbxAlimento);
		
		spinner = new JSpinner();
		spinner.setBounds(87, 58, 223, 20);
		panel.add(spinner);
		
		lblSubtotal = new JLabel("");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSubtotal.setBounds(99, 86, 110, 21);
		panel.add(lblSubtotal);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(221, 88, 89, 23);
		panel.add(btnAgregar);
		
		scrollPane = new JScrollPane();
		panelGestionAlimentos.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
	}
	
	public void panelTotaAlimentos() {
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 100));
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Total Alimentos:");
		lblNewLabel_11.setBounds(10, 33, 140, 21);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblNewLabel_11);
		
		lblTotalalimentos = new JLabel("");
		lblTotalalimentos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalalimentos.setBounds(160, 33, 160, 21);
		panel_2.add(lblTotalalimentos);
		
		JLabel label = new JLabel("");
		label.setBounds(500, 15, 0, 0);
		panel_2.add(label);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(382, 35, 89, 23);
		panel_2.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(500, 35, 89, 23);
		panel_2.add(btnCancelar);
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

	public JComboBox getCbxCategoria() {
		return cbxCategoria;
	}

	public void setCbxCategoria(JComboBox cbxCategoria) {
		this.cbxCategoria = cbxCategoria;
	}

	public JComboBox getCbxAlimento() {
		return cbxAlimento;
	}

	public void setCbxAlimento(JComboBox cbxAlimento) {
		this.cbxAlimento = cbxAlimento;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JLabel getLblSubtotal() {
		return lblSubtotal;
	}

	public void setLblSubtotal(JLabel lblSubtotal) {
		this.lblSubtotal = lblSubtotal;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JLabel getLblTotalalimentos() {
		return lblTotalalimentos;
	}

	public void setLblTotalalimentos(JLabel lblTotalalimentos) {
		this.lblTotalalimentos = lblTotalalimentos;
	}
	
}
