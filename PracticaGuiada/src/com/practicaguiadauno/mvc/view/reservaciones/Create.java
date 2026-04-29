package com.practicaguiadauno.mvc.view.reservaciones;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.practicaguiadauno.mvc.model.Habitacion;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Create extends JPanel {
	private JPanel panelDatosReserv;
	private JPanel panelRequisitos;
	private JPanel panelFinreserv;
	private JComboBox cbxHabitaciones;
	private JTextField txtCliente;
	private JSpinner spinner;
	private JDateChooser tFechaEntrada;
	private JDateChooser tFechaSalida;
	private JLabel lblYesNoHabDisp;
	private JLabel lblyesNoPeople;
	private JLabel lblDato1;
	private JLabel lblDato2;
	private JLabel lblDato3;
	private JLabel lblDato4;
	private JLabel lblDato5;
	private JLabel lblDato6;
	private JLabel lblDato7;
	private JLabel lblDato8;
	private JLabel lblDato9;
	private JButton btnReservar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public Create() {
		setLayout(new BorderLayout(0, 0));
		datosReserv();
		panelRequisitos();
		panelFinReserv();

	}
	
	public void datosReserv() {
		panelDatosReserv = new JPanel();
		add(panelDatosReserv, BorderLayout.CENTER);
		panelDatosReserv.setBorder(BorderFactory.createTitledBorder("Datos de la Reservación"));
		panelDatosReserv.setLayout(null);
		
		JLabel lblHabitacion = new JLabel("Habitaci\u00F3n:");
		lblHabitacion.setBounds(20, 39, 86, 20);
		panelDatosReserv.add(lblHabitacion);
		
		cbxHabitaciones = new JComboBox<Habitacion>();

		cbxHabitaciones.setEditable(false);
		cbxHabitaciones.setBounds(106, 39, 173, 20);
		//cbxHabitaciones.setPreferredSize(new Dimension(170, 30));
		AutoCompleteDecorator.decorate(cbxHabitaciones);
		panelDatosReserv.add(cbxHabitaciones);
		
		
		JLabel lblFechaE = new JLabel("Fecha Entrada:");
		lblFechaE.setBounds(20, 70, 86, 20);
		panelDatosReserv.add(lblFechaE);
		
		tFechaEntrada = new JDateChooser();
		tFechaEntrada.setBounds(106, 70, 173, 20);
		panelDatosReserv.add(tFechaEntrada);
		
		JLabel lblFechaS = new JLabel("Fecha Salida:");
		lblFechaS.setBounds(20, 101, 86, 20);
		panelDatosReserv.add(lblFechaS);
		
		tFechaSalida = new JDateChooser();
		tFechaSalida.setBounds(106, 101, 173, 20);
		panelDatosReserv.add(tFechaSalida);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(20, 132, 86, 20);
		panelDatosReserv.add(lblCliente);
		
		JLabel lblPersonas = new JLabel("Personas:");
		lblPersonas.setBounds(20, 163, 86, 20);
		panelDatosReserv.add(lblPersonas);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(106, 132, 173, 20);
		panelDatosReserv.add(txtCliente);
		txtCliente.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setBounds(106, 163, 109, 20);
		panelDatosReserv.add(spinner);
	}
	
	public void panelRequisitos() {
		panelRequisitos = new JPanel();
		panelRequisitos.setPreferredSize(new Dimension(300, 10));
		add(panelRequisitos, BorderLayout.EAST);
		panelRequisitos.setBorder(BorderFactory.createTitledBorder("Requisitos de la Reservación"));
		panelRequisitos.setLayout(null);
		
		JLabel lblHabitacionDisponible = new JLabel("Habitaci\u00F3n Disponible");
		lblHabitacionDisponible.setBounds(29, 55, 142, 14);
		panelRequisitos.add(lblHabitacionDisponible);
		
		JLabel lblCapacidadMaxima = new JLabel("Capacidad M\u00E1xima");
		lblCapacidadMaxima.setBounds(29, 134, 142, 14);
		panelRequisitos.add(lblCapacidadMaxima);
		
		lblYesNoHabDisp = new JLabel("Si");
		lblYesNoHabDisp.setForeground(new Color(255, 255, 255));
		lblYesNoHabDisp.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblYesNoHabDisp.setOpaque(true);
		lblYesNoHabDisp.setBackground(new Color(50, 205, 50));
		lblYesNoHabDisp.setHorizontalAlignment(SwingConstants.CENTER);
		lblYesNoHabDisp.setHorizontalTextPosition(SwingConstants.CENTER);
		lblYesNoHabDisp.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblYesNoHabDisp.setBounds(171, 52, 46, 40);
		panelRequisitos.add(lblYesNoHabDisp);
		
		lblyesNoPeople = new JLabel("Si");
		lblyesNoPeople.setForeground(new Color(255, 255, 255));
		lblyesNoPeople.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblyesNoPeople.setOpaque(true);
		lblyesNoPeople.setBackground(new Color(50, 205, 50));
		lblyesNoPeople.setHorizontalAlignment(SwingConstants.CENTER);
		lblyesNoPeople.setHorizontalTextPosition(SwingConstants.CENTER);
		lblyesNoPeople.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblyesNoPeople.setBounds(171, 118, 46, 40);
		panelRequisitos.add(lblyesNoPeople);
	}
	
	public void panelFinReserv() {
		panelFinreserv = new JPanel();
		panelFinreserv.setBorder(BorderFactory.createTitledBorder("Finalizar Reservación"));
		panelFinreserv.setPreferredSize(new Dimension(10, 200));
		add(panelFinreserv, BorderLayout.SOUTH);
		panelFinreserv.setBorder(BorderFactory.createTitledBorder("Finalizar Reservación"));
		panelFinreserv.setLayout(null);
		
		JLabel lbl1 = new JLabel("Habitaci\u00F3n:");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl1.setBounds(10, 46, 72, 14);
		panelFinreserv.add(lbl1);
		
		JLabel lbl2 = new JLabel("Capacidad M\u00E1xima:");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl2.setBounds(10, 71, 109, 14);
		panelFinreserv.add(lbl2);
		
		JLabel lbl3 = new JLabel("Tarifa Por Persona por Noche:");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl3.setBounds(10, 96, 166, 14);
		panelFinreserv.add(lbl3);
		
		JLabel lbl4 = new JLabel("Fecha de Entrada:");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl4.setBounds(10, 121, 109, 14);
		panelFinreserv.add(lbl4);
		
		JLabel lbl5 = new JLabel("Fecha de Salida:");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl5.setBounds(10, 146, 94, 14);
		panelFinreserv.add(lbl5);
		
		lblDato1 = new JLabel("");
		lblDato1.setBounds(93, 46, 186, 14);
		panelFinreserv.add(lblDato1);
		
		lblDato2 = new JLabel("");
		lblDato2.setBounds(126, 71, 153, 14);
		panelFinreserv.add(lblDato2);
		
		lblDato3 = new JLabel("");
		lblDato3.setBounds(182, 96, 97, 14);
		panelFinreserv.add(lblDato3);
		
		lblDato4 = new JLabel("");
		lblDato4.setBounds(126, 121, 153, 14);
		panelFinreserv.add(lblDato4);
		
		lblDato5 = new JLabel("");
		lblDato5.setBounds(126, 146, 153, 14);
		panelFinreserv.add(lblDato5);
		
		JLabel lblCantidadDePersonas = new JLabel("Cantidad de Personas:");
		lblCantidadDePersonas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidadDePersonas.setBounds(315, 46, 133, 14);
		panelFinreserv.add(lblCantidadDePersonas);
		
		JLabel lblCantidadDeNoches = new JLabel("Cantidad de Noches:");
		lblCantidadDeNoches.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidadDeNoches.setBounds(315, 71, 118, 14);
		panelFinreserv.add(lblCantidadDeNoches);
		
		JLabel lblCostoPorNoche = new JLabel("Costo por Noche:");
		lblCostoPorNoche.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCostoPorNoche.setBounds(315, 96, 97, 14);
		panelFinreserv.add(lblCostoPorNoche);
		
		JLabel lblCostoTotalHospedaje = new JLabel("Costo Total Hospedaje:");
		lblCostoTotalHospedaje.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCostoTotalHospedaje.setBounds(315, 121, 133, 14);
		panelFinreserv.add(lblCostoTotalHospedaje);
		
		lblDato6 = new JLabel("");
		lblDato6.setBounds(445, 46, 98, 14);
		panelFinreserv.add(lblDato6);
		
		lblDato7 = new JLabel("");
		lblDato7.setBounds(445, 71, 98, 14);
		panelFinreserv.add(lblDato7);
		
		lblDato8 = new JLabel("");
		lblDato8.setBounds(434, 96, 121, 14);
		panelFinreserv.add(lblDato8);
		
		lblDato9 = new JLabel("");
		lblDato9.setBounds(458, 121, 97, 14);
		panelFinreserv.add(lblDato9);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setBounds(315, 142, 118, 23);
		panelFinreserv.add(btnReservar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(453, 142, 118, 23);
		panelFinreserv.add(btnCancelar);
	}

	public JPanel getPanelDatosReserv() {
		return panelDatosReserv;
	}

	public void setPanelDatosReserv(JPanel panelDatosReserv) {
		this.panelDatosReserv = panelDatosReserv;
	}

	public JPanel getPanelRequisitos() {
		return panelRequisitos;
	}

	public void setPanelRequisitos(JPanel panelRequisitos) {
		this.panelRequisitos = panelRequisitos;
	}

	public JPanel getPanelFinreserv() {
		return panelFinreserv;
	}

	public void setPanelFinreserv(JPanel panelFinreserv) {
		this.panelFinreserv = panelFinreserv;
	}

	public JComboBox getCbxHabitaciones() {
		return cbxHabitaciones;
	}

	public void setCbxHabitaciones(JComboBox cbxHabitaciones) {
		this.cbxHabitaciones = cbxHabitaciones;
	}

	public JTextField getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(JTextField txtCliente) {
		this.txtCliente = txtCliente;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JDateChooser gettFechaEntrada() {
		return tFechaEntrada;
	}

	public void settFechaEntrada(JDateChooser tFechaEntrada) {
		this.tFechaEntrada = tFechaEntrada;
	}

	public JDateChooser gettFechaSalida() {
		return tFechaSalida;
	}

	public void settFechaSalida(JDateChooser tFechaSalida) {
		this.tFechaSalida = tFechaSalida;
	}

	public JLabel getLblYesNoHabDisp() {
		return lblYesNoHabDisp;
	}

	public void setLblYesNoHabDisp(JLabel lblYesNoHabDisp) {
		this.lblYesNoHabDisp = lblYesNoHabDisp;
	}

	public JLabel getLblyesNoPeople() {
		return lblyesNoPeople;
	}

	public void setLblyesNoPeople(JLabel lblyesNoPeople) {
		this.lblyesNoPeople = lblyesNoPeople;
	}

	public JLabel getLblDato1() {
		return lblDato1;
	}

	public void setLblDato1(JLabel lblDato1) {
		this.lblDato1 = lblDato1;
	}

	public JLabel getLblDato2() {
		return lblDato2;
	}

	public void setLblDato2(JLabel lblDato2) {
		this.lblDato2 = lblDato2;
	}

	public JLabel getLblDato3() {
		return lblDato3;
	}

	public void setLblDato3(JLabel lblDato3) {
		this.lblDato3 = lblDato3;
	}

	public JLabel getLblDato4() {
		return lblDato4;
	}

	public void setLblDato4(JLabel lblDato4) {
		this.lblDato4 = lblDato4;
	}

	public JLabel getLblDato5() {
		return lblDato5;
	}

	public void setLblDato5(JLabel lblDato5) {
		this.lblDato5 = lblDato5;
	}

	public JLabel getLblDato6() {
		return lblDato6;
	}

	public void setLblDato6(JLabel lblDato6) {
		this.lblDato6 = lblDato6;
	}

	public JLabel getLblDato7() {
		return lblDato7;
	}

	public void setLblDato7(JLabel lblDato7) {
		this.lblDato7 = lblDato7;
	}

	public JLabel getLblDato8() {
		return lblDato8;
	}

	public void setLblDato8(JLabel lblDato8) {
		this.lblDato8 = lblDato8;
	}

	public JLabel getLblDato9() {
		return lblDato9;
	}

	public void setLblDato9(JLabel lblDato9) {
		this.lblDato9 = lblDato9;
	}

	public JButton getBtnReservar() {
		return btnReservar;
	}

	public void setBtnReservar(JButton btnReservar) {
		this.btnReservar = btnReservar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	
}

