package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.BorderFactory;
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
import javax.swing.JButton;

public class Create extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlRegisterReservation;
	private JPanel pnlRequirements;
	private JPanel pnlPendingReservation;
	private JComboBox<Habitacion> cmbRoom;
	private JTextField txtClient;
	private JSpinner spnPeople;
	private JDateChooser jclEntryDate;
	private JDateChooser jclExitDate;
	private JLabel lblAvailableRoom;
	private JLabel lblAvailablePeople;
	private JLabel lblRoomD;
	private JLabel lblCapacityD;
	private JLabel lblRateNightD;
	private JLabel lblEntryDateD;
	private JLabel lblExitDateD;
	private JLabel lblLotPersonsD;
	private JLabel lblLotNightD;
	private JLabel lblCostNightD;
	private JLabel lblTotalCostD;
	private JButton btnReserve;
	private JButton btnCancel;

	/**
	 * Create the panel.
	 */
	public Create() {
		setLayout(new BorderLayout(0, 0));
		pnlComponentsReservation();
		pnlComponentsRequirements();
		pnlComponentsFinalData();

	}
	
	public void pnlComponentsReservation() {
		pnlRegisterReservation = new JPanel();
		add(pnlRegisterReservation, BorderLayout.CENTER);
		pnlRegisterReservation.setBorder(BorderFactory.createTitledBorder("Datos de la Reservación"));
		pnlRegisterReservation.setLayout(null);
		
		JLabel lblRoom = new JLabel("Habitaci\u00F3n:");
		lblRoom.setBounds(20, 39, 86, 20);
		pnlRegisterReservation.add(lblRoom);
		
		cmbRoom = new JComboBox<Habitacion>();

		cmbRoom.setEditable(false);
		cmbRoom.setBounds(106, 39, 173, 20);
		//cbxHabitaciones.setPreferredSize(new Dimension(170, 30));
		AutoCompleteDecorator.decorate(cmbRoom);
		pnlRegisterReservation.add(cmbRoom);
		
		
		JLabel lblEntryDate = new JLabel("Fecha Entrada:");
		lblEntryDate.setBounds(20, 70, 86, 20);
		pnlRegisterReservation.add(lblEntryDate);
		
		jclEntryDate = new JDateChooser();
		jclEntryDate.setBounds(106, 70, 173, 20);
		pnlRegisterReservation.add(jclEntryDate);
		
		JLabel lblExitDate = new JLabel("Fecha Salida:");
		lblExitDate.setBounds(20, 101, 86, 20);
		pnlRegisterReservation.add(lblExitDate);
		
		jclExitDate = new JDateChooser();
		jclExitDate.setBounds(106, 101, 173, 20);
		pnlRegisterReservation.add(jclExitDate);
		
		JLabel lblClient = new JLabel("Cliente:");
		lblClient.setBounds(20, 132, 86, 20);
		pnlRegisterReservation.add(lblClient);
		
		JLabel lblPersons = new JLabel("Personas:");
		lblPersons.setBounds(20, 163, 86, 20);
		pnlRegisterReservation.add(lblPersons);
		
		txtClient = new JTextField();
		txtClient.setBounds(106, 132, 173, 20);
		pnlRegisterReservation.add(txtClient);
		txtClient.setColumns(10);
		
		spnPeople = new JSpinner();
		spnPeople.setBounds(106, 163, 109, 20);
		pnlRegisterReservation.add(spnPeople);
	}
	
	public void pnlComponentsRequirements() {
		pnlRequirements = new JPanel();
		pnlRequirements.setPreferredSize(new Dimension(300, 10));
		add(pnlRequirements, BorderLayout.EAST);
		pnlRequirements.setBorder(BorderFactory.createTitledBorder("Requisitos de la Reservación"));
		pnlRequirements.setLayout(null);
		
		JLabel lblRoomFree = new JLabel("Habitaci\u00F3n Disponible");
		lblRoomFree.setBounds(29, 55, 142, 14);
		pnlRequirements.add(lblRoomFree);
		
		JLabel lblMaxCapacity = new JLabel("Capacidad M\u00E1xima");
		lblMaxCapacity.setBounds(29, 134, 142, 14);
		pnlRequirements.add(lblMaxCapacity);
		
		lblAvailableRoom = new JLabel("Si");
		lblAvailableRoom.setOpaque(true);
		lblAvailableRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableRoom.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAvailableRoom.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblAvailableRoom.setBounds(171, 52, 46, 40);
		pnlRequirements.add(lblAvailableRoom);
		
		lblAvailablePeople = new JLabel("Si");
		lblAvailablePeople.setOpaque(true);
		lblAvailablePeople.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailablePeople.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAvailablePeople.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblAvailablePeople.setBounds(171, 118, 46, 40);
		pnlRequirements.add(lblAvailablePeople);
	}
	
	public void pnlComponentsFinalData() {
		pnlPendingReservation = new JPanel();
		pnlPendingReservation.setBorder(BorderFactory.createTitledBorder("Finalizar Reservación"));
		pnlPendingReservation.setPreferredSize(new Dimension(10, 200));
		add(pnlPendingReservation, BorderLayout.SOUTH);
		pnlPendingReservation.setBorder(BorderFactory.createTitledBorder("Finalizar Reservación"));
		pnlPendingReservation.setLayout(null);
		
		JLabel lblRoom = new JLabel("Habitaci\u00F3n:");
		lblRoom.setBounds(10, 46, 72, 14);
		pnlPendingReservation.add(lblRoom);
		
		JLabel lblCapacity = new JLabel("Capacidad M\u00E1xima:");
		lblCapacity.setBounds(10, 71, 109, 14);
		pnlPendingReservation.add(lblCapacity);
		
		JLabel lblRateNight = new JLabel("Tarifa Por Persona por Noche:");
		lblRateNight.setBounds(10, 96, 166, 14);
		pnlPendingReservation.add(lblRateNight);
		
		JLabel lblEntryDate = new JLabel("Fecha de Entrada:");
		lblEntryDate.setBounds(10, 121, 109, 14);
		pnlPendingReservation.add(lblEntryDate);
		
		JLabel lblExitDate = new JLabel("Fecha de Salida:");
		lblExitDate.setBounds(10, 146, 94, 14);
		pnlPendingReservation.add(lblExitDate);
		
		lblRoomD = new JLabel("");
		lblRoomD.setBounds(93, 46, 186, 14);
		pnlPendingReservation.add(lblRoomD);
		
		lblCapacityD = new JLabel("");
		lblCapacityD.setBounds(126, 71, 153, 14);
		pnlPendingReservation.add(lblCapacityD);
		
		lblRateNightD = new JLabel("");
		lblRateNightD.setBounds(182, 96, 97, 14);
		pnlPendingReservation.add(lblRateNightD);
		
		lblEntryDateD = new JLabel("");
		lblEntryDateD.setBounds(126, 121, 153, 14);
		pnlPendingReservation.add(lblEntryDateD);
		
		lblExitDateD = new JLabel("");
		lblExitDateD.setBounds(126, 146, 153, 14);
		pnlPendingReservation.add(lblExitDateD);
		
		JLabel lblLotPersons = new JLabel("Cantidad de Personas:");
		lblLotPersons.setBounds(315, 46, 133, 14);
		pnlPendingReservation.add(lblLotPersons);
		
		JLabel lblLotNight = new JLabel("Cantidad de Noches:");
		lblLotNight.setBounds(315, 71, 118, 14);
		pnlPendingReservation.add(lblLotNight);
		
		JLabel lblCostNight = new JLabel("Costo por Noche:");
		lblCostNight.setBounds(315, 96, 97, 14);
		pnlPendingReservation.add(lblCostNight);
		
		JLabel lblTotalCost = new JLabel("Costo Total Hospedaje:");
		lblTotalCost.setBounds(315, 121, 133, 14);
		pnlPendingReservation.add(lblTotalCost);
		
		lblLotPersonsD = new JLabel("");
		lblLotPersonsD.setBounds(445, 46, 98, 14);
		pnlPendingReservation.add(lblLotPersonsD);
		
		lblLotNightD = new JLabel("");
		lblLotNightD.setBounds(445, 71, 98, 14);
		pnlPendingReservation.add(lblLotNightD);
		
		lblCostNightD = new JLabel("");
		lblCostNightD.setBounds(434, 96, 121, 14);
		pnlPendingReservation.add(lblCostNightD);
		
		lblTotalCostD = new JLabel("");
		lblTotalCostD.setBounds(458, 121, 97, 14);
		pnlPendingReservation.add(lblTotalCostD);
		
		btnReserve = new JButton("Reservar");
		btnReserve.setBounds(315, 142, 118, 23);
		pnlPendingReservation.add(btnReserve);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(453, 142, 118, 23);
		pnlPendingReservation.add(btnCancel);
	}

	public JPanel getPnlRegisterReservation() {
		return pnlRegisterReservation;
	}

	public void setPnlRegisterReservation(JPanel pnlRegisterReservation) {
		this.pnlRegisterReservation = pnlRegisterReservation;
	}

	public JPanel getPnlRequirements() {
		return pnlRequirements;
	}

	public void setPnlRequirements(JPanel pnlRequirements) {
		this.pnlRequirements = pnlRequirements;
	}

	public JPanel getPnlPendingReservation() {
		return pnlPendingReservation;
	}

	public void setPnlPendingReservation(JPanel pnlPendingReservation) {
		this.pnlPendingReservation = pnlPendingReservation;
	}

	public JComboBox<Habitacion> getCmbRoom() {
		return cmbRoom;
	}

	public void setCmbRoom(JComboBox<Habitacion> cmbRoom) {
		this.cmbRoom = cmbRoom;
	}

	public JTextField getTxtClient() {
		return txtClient;
	}

	public void setTxtClient(JTextField txtClient) {
		this.txtClient = txtClient;
	}

	public JSpinner getSpnPeople() {
		return spnPeople;
	}

	public void setSpnPeople(JSpinner spnPeople) {
		this.spnPeople = spnPeople;
	}

	public JDateChooser getJclEntryDate() {
		return jclEntryDate;
	}

	public void setJclEntryDate(JDateChooser jclEntryDate) {
		this.jclEntryDate = jclEntryDate;
	}

	public JDateChooser getJclExitDate() {
		return jclExitDate;
	}

	public void setJclExitDate(JDateChooser jclExitDate) {
		this.jclExitDate = jclExitDate;
	}

	public JLabel getLblAvailableRoom() {
		return lblAvailableRoom;
	}

	public void setLblAvailableRoom(JLabel lblAvailableRoom) {
		this.lblAvailableRoom = lblAvailableRoom;
	}

	public JLabel getLblAvailablePeople() {
		return lblAvailablePeople;
	}

	public void setLblAvailablePeople(JLabel lblAvailablePeople) {
		this.lblAvailablePeople = lblAvailablePeople;
	}

	public JLabel getLblRoomD() {
		return lblRoomD;
	}

	public void setLblRoomD(JLabel lblRoomD) {
		this.lblRoomD = lblRoomD;
	}

	public JLabel getLblCapacityD() {
		return lblCapacityD;
	}

	public void setLblCapacityD(JLabel lblCapacityD) {
		this.lblCapacityD = lblCapacityD;
	}

	public JLabel getLblRateNightD() {
		return lblRateNightD;
	}

	public void setLblRateNightD(JLabel lblRateNightD) {
		this.lblRateNightD = lblRateNightD;
	}

	public JLabel getLblEntryDateD() {
		return lblEntryDateD;
	}

	public void setLblEntryDateD(JLabel lblEntryDateD) {
		this.lblEntryDateD = lblEntryDateD;
	}

	public JLabel getLblExitDateD() {
		return lblExitDateD;
	}

	public void setLblExitDateD(JLabel lblExitDateD) {
		this.lblExitDateD = lblExitDateD;
	}

	public JLabel getLblLotPersonsD() {
		return lblLotPersonsD;
	}

	public void setLblLotPersonsD(JLabel lblLotPersonsD) {
		this.lblLotPersonsD = lblLotPersonsD;
	}

	public JLabel getLblLotNightD() {
		return lblLotNightD;
	}

	public void setLblLotNightD(JLabel lblLotNightD) {
		this.lblLotNightD = lblLotNightD;
	}

	public JLabel getLblCostNightD() {
		return lblCostNightD;
	}

	public void setLblCostNightD(JLabel lblCostNightD) {
		this.lblCostNightD = lblCostNightD;
	}

	public JLabel getLblTotalCostD() {
		return lblTotalCostD;
	}

	public void setLblTotalCostD(JLabel lblTotalCostD) {
		this.lblTotalCostD = lblTotalCostD;
	}

	public JButton getBtnReserve() {
		return btnReserve;
	}

	public void setBtnReserve(JButton btnReserve) {
		this.btnReserve = btnReserve;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	
	
}

