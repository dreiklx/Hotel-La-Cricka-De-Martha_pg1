package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Reports extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableClientes;
	private JTable tableAlimentos;
	private DefaultTableModel modeloClientes;
	private DefaultTableModel modeloAlimentos;
	private JScrollPane scpClients;
	private JScrollPane scpFood;
	private JButton btnLoad;
	private JLabel lblTotal;
	private JLabel lblTotalFood;
	private JLabel lblLodging;
	private JLabel lblReservations;

	/**
	 * Create the panel.
	 */
	public Reports() {
		setLayout(new BorderLayout(0, 0));
		panelClientesFrecuentes();
		panelAlimentosConsumidos();
		panelVentasTotales();

	}

	public void panelClientesFrecuentes() {
		JPanel pnlFrequentClients = new JPanel();
		pnlFrequentClients.setBorder(BorderFactory.createTitledBorder("Clientes Frecuentes"));

		pnlFrequentClients.setPreferredSize(new Dimension(320, 10));
		add(pnlFrequentClients, BorderLayout.WEST);
		pnlFrequentClients.setLayout(new BorderLayout(0, 0));

		scpClients = new JScrollPane();
		pnlFrequentClients.add(scpClients, BorderLayout.CENTER);

		modeloClientes = new DefaultTableModel();
		tableClientes = new JTable(modeloClientes);
		scpClients.setViewportView(tableClientes);

	}

	public void panelAlimentosConsumidos() {
		JPanel pnlMoreConsumed = new JPanel();
		pnlMoreConsumed.setBorder(BorderFactory.createTitledBorder("Alimentos Más Consumidos"));

		add(pnlMoreConsumed, BorderLayout.CENTER);
		pnlMoreConsumed.setLayout(new BorderLayout(0, 0));

		scpFood = new JScrollPane();
		pnlMoreConsumed.add(scpFood, BorderLayout.CENTER);

		modeloAlimentos = new DefaultTableModel();
		tableAlimentos = new JTable(modeloAlimentos);
		scpClients.setViewportView(tableAlimentos);

	}

	public void panelVentasTotales() {
		JPanel pnlTotalSales = new JPanel();
		pnlTotalSales.setBorder(BorderFactory.createTitledBorder("Ventas Totales"));

		pnlTotalSales.setPreferredSize(new Dimension(10, 200));
		add(pnlTotalSales, BorderLayout.SOUTH);
		pnlTotalSales.setLayout(null);

		JLabel lblStartT = new JLabel("Fecha Inicio");
		lblStartT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStartT.setBounds(25, 43, 67, 14);
		pnlTotalSales.add(lblStartT);

		JLabel lblEndT = new JLabel("Fecha Fin");
		lblEndT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndT.setBounds(25, 90, 62, 14);
		pnlTotalSales.add(lblEndT);

		JDateChooser start = new JDateChooser();
		start.setBounds(97, 43, 173, 20);
		pnlTotalSales.add(start);

		JDateChooser end = new JDateChooser();
		end.setBounds(97, 84, 173, 20);
		pnlTotalSales.add(end);

		btnLoad = new JButton("Cargar");
		btnLoad.setBounds(97, 141, 89, 23);
		pnlTotalSales.add(btnLoad);

		JLabel lblReservationsT = new JLabel("Reservaciones:");
		lblReservationsT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservationsT.setBounds(354, 43, 86, 14);
		pnlTotalSales.add(lblReservationsT);

		JLabel lblLodgingT = new JLabel("Total Hospedaje:");
		lblLodgingT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLodgingT.setBounds(354, 78, 95, 14);
		pnlTotalSales.add(lblLodgingT);

		JLabel lblTotalFoodT = new JLabel("Total Alimentos:");
		lblTotalFoodT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalFoodT.setBounds(354, 114, 95, 14);
		pnlTotalSales.add(lblTotalFoodT);

		JLabel lblTotalT = new JLabel("Total:");
		lblTotalT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalT.setBounds(354, 150, 46, 14);
		pnlTotalSales.add(lblTotalT);

		lblReservations = new JLabel("");
		lblReservations.setBounds(450, 43, 252, 14);
		pnlTotalSales.add(lblReservations);

		lblLodging = new JLabel("");
		lblLodging.setBounds(459, 78, 243, 14);
		pnlTotalSales.add(lblLodging);

		lblTotalFood = new JLabel("");
		lblTotalFood.setBounds(459, 114, 243, 14);
		pnlTotalSales.add(lblTotalFood);


		lblTotal = new JLabel("");
		lblTotal.setBounds(394, 150, 308, 14);
		pnlTotalSales.add(lblTotal);

	}

	public JTable getTableClientes() {
		return tableClientes;
	}

	public void setTableClientes(JTable tableClientes) {
		this.tableClientes = tableClientes;
	}

	public JTable getTableAlimentos() {
		return tableAlimentos;
	}

	public void setTableAlimentos(JTable tableAlimentos) {
		this.tableAlimentos = tableAlimentos;
	}

	public JScrollPane getScrollPaneClientes() {
		return scpClients;
	}

	public void setScrollPaneClientes(JScrollPane scrollPaneClientes) {
		this.scpClients = scrollPaneClientes;
	}

	public JScrollPane getScrollPaneAlimentos() {
		return scpFood;
	}

	public void setScrollPaneAlimentos(JScrollPane scrollPaneAlimentos) {
		this.scpFood = scrollPaneAlimentos;
	}

	public JButton getBtnCargar() {
		return btnLoad;
	}

	public void setBtnCargar(JButton btnCargar) {
		this.btnLoad = btnCargar;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}

	public JLabel getLblTotalalimentos() {
		return lblTotalFood;
	}

	public void setLblTotalalimentos(JLabel lblTotalalimentos) {
		this.lblTotalFood = lblTotalalimentos;
	}

	public JLabel getLblTotalhospedaje() {
		return lblLodging;
	}

	public void setLblTotalhospedaje(JLabel lblTotalhospedaje) {
		this.lblLodging = lblTotalhospedaje;
	}

	public JLabel getLblReservaciones() {
		return lblReservations;
	}

	public void setLblReservaciones(JLabel lblReservaciones) {
		this.lblReservations = lblReservaciones;
	}

	public DefaultTableModel getModeloClientes() {
		return modeloClientes;
	}

	public void setModeloClientes(DefaultTableModel modeloClientes) {
		this.modeloClientes = modeloClientes;
	}

	public DefaultTableModel getModeloAlimentos() {
		return modeloAlimentos;
	}

	public void setModeloAlimentos(DefaultTableModel modeloAlimentos) {
		this.modeloAlimentos = modeloAlimentos;
	}

}
