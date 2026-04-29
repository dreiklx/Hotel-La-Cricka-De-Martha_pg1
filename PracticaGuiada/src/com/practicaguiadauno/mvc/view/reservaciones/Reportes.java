package com.practicaguiadauno.mvc.view.reservaciones;

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

public class Reportes extends JPanel {
	private JTable tableClientes;
	private JTable tableAlimentos;
	private DefaultTableModel modeloClientes;
	private DefaultTableModel modeloAlimentos;
	private JScrollPane scrollPaneClientes;
	private JScrollPane scrollPaneAlimentos;
	private JButton btnCargar;
	private JLabel lblTotal;
	private JLabel lblTotalalimentos;
	private JLabel lblTotalhospedaje;
	private JLabel lblReservaciones;

	/**
	 * Create the panel.
	 */
	public Reportes() {
		setLayout(new BorderLayout(0, 0));
		panelClientesFrecuentes();
		panelAlimentosConsumidos();
		panelVentasTotales();

	}

	public void panelClientesFrecuentes() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Clientes Frecuentes"));

		panel.setPreferredSize(new Dimension(320, 10));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		{
			scrollPaneClientes = new JScrollPane();
			panel.add(scrollPaneClientes, BorderLayout.CENTER);
			{
				modeloClientes = new DefaultTableModel();
				tableClientes = new JTable(modeloClientes);
				scrollPaneClientes.setViewportView(tableClientes);
			}
		}
	}
	
	public void panelAlimentosConsumidos() {
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder("Alimentos Más Consumidos"));

		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		{
			scrollPaneAlimentos = new JScrollPane();
			panel_1.add(scrollPaneAlimentos, BorderLayout.CENTER);
			{
				modeloAlimentos = new DefaultTableModel();
				tableAlimentos = new JTable(modeloAlimentos);
				scrollPaneClientes.setViewportView(tableAlimentos);
			}
		}
	}
	
	public void panelVentasTotales() {
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createTitledBorder("Ventas Totales"));

		panel_2.setPreferredSize(new Dimension(10, 200));
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Fecha Inicio");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setBounds(25, 43, 67, 14);
			panel_2.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Fecha Fin");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1.setBounds(25, 90, 62, 14);
			panel_2.add(lblNewLabel_1);
		}
		JDateChooser inicio = new JDateChooser();
		inicio.setBounds(97, 43, 173, 20);
		panel_2.add(inicio);
		
		JDateChooser salida = new JDateChooser();
		salida.setBounds(97, 84, 173, 20);
		panel_2.add(salida);
		{
			btnCargar = new JButton("Cargar");
			btnCargar.setBounds(97, 141, 89, 23);
			panel_2.add(btnCargar);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Reservaciones:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_2.setBounds(354, 43, 86, 14);
			panel_2.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Total Hospedaje:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_3.setBounds(354, 78, 95, 14);
			panel_2.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Total Alimentos:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_4.setBounds(354, 114, 95, 14);
			panel_2.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("Total:");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_5.setBounds(354, 150, 46, 14);
			panel_2.add(lblNewLabel_5);
		}
		{
			lblReservaciones = new JLabel("");
			lblReservaciones.setBounds(450, 43, 252, 14);
			panel_2.add(lblReservaciones);
		}
		{
			lblTotalhospedaje = new JLabel("");
			lblTotalhospedaje.setBounds(459, 78, 243, 14);
			panel_2.add(lblTotalhospedaje);
		}
		{
			lblTotalalimentos = new JLabel("");
			lblTotalalimentos.setBounds(459, 114, 243, 14);
			panel_2.add(lblTotalalimentos);
		}
		{
			lblTotal = new JLabel("");
			lblTotal.setBounds(394, 150, 308, 14);
			panel_2.add(lblTotal);
		}
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
		return scrollPaneClientes;
	}

	public void setScrollPaneClientes(JScrollPane scrollPaneClientes) {
		this.scrollPaneClientes = scrollPaneClientes;
	}

	public JScrollPane getScrollPaneAlimentos() {
		return scrollPaneAlimentos;
	}

	public void setScrollPaneAlimentos(JScrollPane scrollPaneAlimentos) {
		this.scrollPaneAlimentos = scrollPaneAlimentos;
	}

	public JButton getBtnCargar() {
		return btnCargar;
	}

	public void setBtnCargar(JButton btnCargar) {
		this.btnCargar = btnCargar;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblTotal(JLabel lblTotal) {
		this.lblTotal = lblTotal;
	}

	public JLabel getLblTotalalimentos() {
		return lblTotalalimentos;
	}

	public void setLblTotalalimentos(JLabel lblTotalalimentos) {
		this.lblTotalalimentos = lblTotalalimentos;
	}

	public JLabel getLblTotalhospedaje() {
		return lblTotalhospedaje;
	}

	public void setLblTotalhospedaje(JLabel lblTotalhospedaje) {
		this.lblTotalhospedaje = lblTotalhospedaje;
	}

	public JLabel getLblReservaciones() {
		return lblReservaciones;
	}

	public void setLblReservaciones(JLabel lblReservaciones) {
		this.lblReservaciones = lblReservaciones;
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
