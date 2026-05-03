package com.practicaguiadauno.mvc.view.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.practicaguiadauno.utils.Fonts;
import com.practicaguiadauno.utils.ImageUtils;
import com.practicaguiadauno.utils.LoadImages;
import com.practicaguiadauno.utils.Themes;
import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

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
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		panelClientesFrecuentes();
		panelAlimentosConsumidos();
		panelVentasTotales();
	}

	public void panelClientesFrecuentes() {

		JPanel pnlFrequentClients = new JPanel();
		pnlFrequentClients.setOpaque(false);
		TitledBorder border = BorderFactory.createTitledBorder("Clientes frecuentes");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.DARK_GRAY);
		pnlFrequentClients.setBorder(border);

		pnlFrequentClients.setPreferredSize(new Dimension(320, 10));
		add(pnlFrequentClients, BorderLayout.WEST);
		pnlFrequentClients.setLayout(new BorderLayout(0, 0));

		scpClients = new JScrollPane();
		scpClients.setOpaque(false);
		pnlFrequentClients.add(scpClients, BorderLayout.CENTER);

		modeloClientes = new DefaultTableModel();

		tableClientes = new JTable(modeloClientes) {
			/**
			 * No quiero cosas en amerillo
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableClientes.setOpaque(false);
		tableClientes.setBackground(new Color(41, 77, 76));
		tableClientes.setPreferredSize(new Dimension(300, 500));
		Themes.setThemes(tableClientes);
		tableClientes.getTableHeader().setReorderingAllowed(false);
		tableClientes.getTableHeader().setResizingAllowed(false);

		scpClients.setViewportView(tableClientes);
	}

	public void panelAlimentosConsumidos() {

		JPanel pnlMoreConsumed = new JPanel();
		pnlMoreConsumed.setOpaque(false);
		TitledBorder border = BorderFactory.createTitledBorder("Alimentos más consumidos");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.DARK_GRAY);
		pnlMoreConsumed.setBorder(border);

		add(pnlMoreConsumed, BorderLayout.CENTER);
		pnlMoreConsumed.setLayout(new BorderLayout(0, 0));

		scpFood = new JScrollPane();
		scpFood.setOpaque(false);
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
		tableAlimentos.setOpaque(false);
		tableAlimentos.setBackground(new Color(41, 77, 76));
		tableAlimentos.setPreferredSize(new Dimension(300, 500));
		Themes.setThemes(tableAlimentos);
		tableAlimentos.setFont(Fonts.text(13));
		tableAlimentos.getTableHeader().setReorderingAllowed(false);
		tableAlimentos.getTableHeader().setResizingAllowed(false);

		scpFood.setViewportView(tableAlimentos);
		// antes usaba scpClients
	}

	public void panelVentasTotales() {
		TitledBorder border = BorderFactory.createTitledBorder("Ventas totales");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.DARK_GRAY);

		JPanel pnlTotalSales = new JPanel();
		pnlTotalSales.setBorder(border);

		pnlTotalSales.setPreferredSize(new Dimension(10, 250));
		add(pnlTotalSales, BorderLayout.SOUTH);
		pnlTotalSales.setLayout(null);

		JLabel lblStartT = new JLabel("Fecha inicio");
		lblStartT.setForeground(Color.BLACK);
		lblStartT.setFont(Fonts.text(13));
		lblStartT.setBounds(25, 43, 100, 25);
		pnlTotalSales.add(lblStartT);

		JLabel lblEndT = new JLabel("Fecha fin");
		lblEndT.setForeground(Color.BLACK);
		lblEndT.setFont(Fonts.text(13));
		lblEndT.setBounds(25, 90, 100, 25);
		pnlTotalSales.add(lblEndT);

		startDate = new JDateChooser();
		startDate.setBounds(135, 43, 173, 25);
		startDate.setFont(Fonts.text(13));
		pnlTotalSales.add(startDate);

		endDate = new JDateChooser(); // antes no se podia acceder desde controller
		endDate.setBounds(135, 90, 173, 25);
		endDate.setFont(Fonts.text(13));
		pnlTotalSales.add(endDate);

		btnLoad = new JButton("Cargar");
		btnLoad.setPreferredSize(new Dimension(90, 35));
		btnLoad.setFont(Fonts.title(17));

		ImageUtils.setImageButton(btnLoad, LoadImages.ButtonBlue, 100, 30);

		btnLoad.setBounds(135, 143, 89, 28);
		pnlTotalSales.add(btnLoad);

		JLabel lblReservationsT = new JLabel("Reservaciones:");
		lblReservationsT.setForeground(Color.BLACK);
		lblReservationsT.setFont(Fonts.text(13));
		lblReservationsT.setBounds(354, 43, 112, 25);
		pnlTotalSales.add(lblReservationsT);

		JLabel lblLodgingT = new JLabel("Total hospedaje:");
		lblLodgingT.setForeground(Color.BLACK);
		lblLodgingT.setFont(Fonts.text(13));
		lblLodgingT.setBounds(354, 78, 112, 25);
		pnlTotalSales.add(lblLodgingT);

		JLabel lblTotalFoodT = new JLabel("Total alimentos:");
		lblTotalFoodT.setForeground(Color.BLACK);
		lblTotalFoodT.setFont(Fonts.text(13));
		lblTotalFoodT.setBounds(354, 114, 112, 25);
		pnlTotalSales.add(lblTotalFoodT);

		JLabel lblTotalT = new JLabel("Total:");
		lblTotalT.setForeground(Color.BLACK);
		lblTotalT.setFont(Fonts.text(13));
		lblTotalT.setBounds(354, 150, 112, 25);
		pnlTotalSales.add(lblTotalT);

		lblReservations = new JLabel("");
		lblReservations.setBounds(470, 43, 230, 25);
		lblReservations.setFont(Fonts.text(13));
		pnlTotalSales.add(lblReservations);

		lblLodging = new JLabel("");
		lblLodging.setBounds(470, 78, 230, 25);
		lblLodging.setFont(Fonts.text(13));
		pnlTotalSales.add(lblLodging);

		lblTotalFood = new JLabel("");
		lblTotalFood.setBounds(470, 114, 230, 25);
		lblTotalFood.setFont(Fonts.text(13));
		pnlTotalSales.add(lblTotalFood);

		lblTotal = new JLabel("");
		lblTotal.setBounds(470, 150, 231, 25);
		lblTotal.setFont(Fonts.text(13));
		pnlTotalSales.add(lblTotal);
	}

	public JDateChooser getStartDate() {
		return startDate;
	}

	public JDateChooser getEndDate() {
		return endDate;
	}

	public JTable getTableClientes() {
		return tableClientes;
	}

	public JTable getTableAlimentos() {
		return tableAlimentos;
	}

	public JScrollPane getScrollPaneClientes() {
		return scpClients;
	}

	public JScrollPane getScrollPaneAlimentos() {
		return scpFood;
	}

	public JButton getBtnCargar() {
		return btnLoad;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public JLabel getLblTotalalimentos() {
		return lblTotalFood;
	}

	public JLabel getLblTotalhospedaje() {
		return lblLodging;
	}

	public JLabel getLblReservaciones() {
		return lblReservations;
	}

	public DefaultTableModel getModeloClientes() {
		return modeloClientes;
	}

	public DefaultTableModel getModeloAlimentos() {
		return modeloAlimentos;
	}
}