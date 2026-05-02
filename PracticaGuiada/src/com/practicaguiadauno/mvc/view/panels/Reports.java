package com.practicaguiadauno.mvc.view.panels;

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

	private JDateChooser startDate; // antes eran variables locales
	private JDateChooser endDate;

	public Reports() {
		setLayout(new BorderLayout(0, 0));
		panelClientesFrecuentes();
		panelAlimentosConsumidos();
		panelVentasTotales();
	}

	public void panelClientesFrecuentes() {

		JPanel pnlFrequentClients = new JPanel();
		pnlFrequentClients.setBorder(BorderFactory.createTitledBorder("Clientes frecuentes"));

		pnlFrequentClients.setPreferredSize(new Dimension(320, 10));
		add(pnlFrequentClients, BorderLayout.WEST);
		pnlFrequentClients.setLayout(new BorderLayout(0, 0));

		scpClients = new JScrollPane();
		pnlFrequentClients.add(scpClients, BorderLayout.CENTER);

		modeloClientes = new DefaultTableModel();

		tableClientes = new JTable(modeloClientes) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};

		tableClientes.getTableHeader().setReorderingAllowed(false);
		tableClientes.getTableHeader().setResizingAllowed(false);

		scpClients.setViewportView(tableClientes);
	}

	public void panelAlimentosConsumidos() {

		JPanel pnlMoreConsumed = new JPanel();
		pnlMoreConsumed.setBorder(BorderFactory.createTitledBorder("Alimentos más consumidos"));

		add(pnlMoreConsumed, BorderLayout.CENTER);
		pnlMoreConsumed.setLayout(new BorderLayout(0, 0));

		scpFood = new JScrollPane();
		pnlMoreConsumed.add(scpFood, BorderLayout.CENTER);

		modeloAlimentos = new DefaultTableModel();

		tableAlimentos = new JTable(modeloAlimentos) {
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};

		tableAlimentos.getTableHeader().setReorderingAllowed(false);
		tableAlimentos.getTableHeader().setResizingAllowed(false);

		scpFood.setViewportView(tableAlimentos);
		// antes usaba scpClients 
	}

	public void panelVentasTotales() {

		JPanel pnlTotalSales = new JPanel();
		pnlTotalSales.setBorder(BorderFactory.createTitledBorder("Ventas totales"));

		pnlTotalSales.setPreferredSize(new Dimension(10, 200));
		add(pnlTotalSales, BorderLayout.SOUTH);
		pnlTotalSales.setLayout(null);

		JLabel lblStartT = new JLabel("Fecha inicio");
		lblStartT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStartT.setBounds(25, 43, 100, 14);
		pnlTotalSales.add(lblStartT);

		JLabel lblEndT = new JLabel("Fecha fin");
		lblEndT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndT.setBounds(25, 90, 100, 14);
		pnlTotalSales.add(lblEndT);

		startDate = new JDateChooser();
		startDate.setBounds(97, 43, 173, 20);
		pnlTotalSales.add(startDate);

		endDate = new JDateChooser(); // antes no se podia acceder desde controller
		endDate.setBounds(97, 84, 173, 20);
		pnlTotalSales.add(endDate);

		btnLoad = new JButton("Cargar");
		btnLoad.setBounds(97, 141, 89, 23);
		pnlTotalSales.add(btnLoad);

		JLabel lblReservationsT = new JLabel("Reservaciones:");
		lblReservationsT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReservationsT.setBounds(354, 43, 100, 14);
		pnlTotalSales.add(lblReservationsT);

		JLabel lblLodgingT = new JLabel("Total hospedaje:");
		lblLodgingT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLodgingT.setBounds(354, 78, 120, 14);
		pnlTotalSales.add(lblLodgingT);

		JLabel lblTotalFoodT = new JLabel("Total alimentos:");
		lblTotalFoodT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalFoodT.setBounds(354, 114, 120, 14);
		pnlTotalSales.add(lblTotalFoodT);

		JLabel lblTotalT = new JLabel("Total:");
		lblTotalT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalT.setBounds(354, 150, 60, 14);
		pnlTotalSales.add(lblTotalT);

		lblReservations = new JLabel("");
		lblReservations.setBounds(470, 43, 230, 14);
		pnlTotalSales.add(lblReservations);

		lblLodging = new JLabel("");
		lblLodging.setBounds(470, 78, 230, 14);
		pnlTotalSales.add(lblLodging);

		lblTotalFood = new JLabel("");
		lblTotalFood.setBounds(470, 114, 230, 14);
		pnlTotalSales.add(lblTotalFood);

		lblTotal = new JLabel("");
		lblTotal.setBounds(410, 150, 290, 14);
		pnlTotalSales.add(lblTotal);
	}


	public JDateChooser getStartDate() {
		return startDate;
	}

	public JDateChooser getEndDate() {
		return endDate;
	}


	public JTable getTableClientes() { return tableClientes; }
	public JTable getTableAlimentos() { return tableAlimentos; }
	public JScrollPane getScrollPaneClientes() { return scpClients; }
	public JScrollPane getScrollPaneAlimentos() { return scpFood; }
	public JButton getBtnCargar() { return btnLoad; }
	public JLabel getLblTotal() { return lblTotal; }
	public JLabel getLblTotalalimentos() { return lblTotalFood; }
	public JLabel getLblTotalhospedaje() { return lblLodging; }
	public JLabel getLblReservaciones() { return lblReservations; }
	public DefaultTableModel getModeloClientes() { return modeloClientes; }
	public DefaultTableModel getModeloAlimentos() { return modeloAlimentos; }
}