package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.practicaguiadauno.mvc.model.Room; // antes Habitacion

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Create extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel pnlRegisterReservation;
	private JPanel pnlRequirements;
	private JPanel pnlPendingReservation;

	private JComboBox<Room> cmbRoom; // antes Habitacion
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

	public Create() {
		setLayout(new BorderLayout(0, 0));
		initReservationPanel();
		initRequirementsPanel();
		initSummaryPanel();
	}

	private void initReservationPanel() {

		pnlRegisterReservation = new JPanel();
		add(pnlRegisterReservation, BorderLayout.CENTER);
		pnlRegisterReservation.setBorder(BorderFactory.createTitledBorder("Datos de la reservación"));
		pnlRegisterReservation.setLayout(null);

		JLabel lblRoom = new JLabel("Habitación:");
		lblRoom.setBounds(20, 39, 100, 20);
		pnlRegisterReservation.add(lblRoom);

		cmbRoom = new JComboBox<>();
		cmbRoom.setBounds(130, 39, 173, 20);
		AutoCompleteDecorator.decorate(cmbRoom);
		pnlRegisterReservation.add(cmbRoom);

		JLabel lblEntryDate = new JLabel("Fecha de entrada:");
		lblEntryDate.setBounds(20, 70, 100, 20);
		pnlRegisterReservation.add(lblEntryDate);

		jclEntryDate = new JDateChooser();
		jclEntryDate.setBounds(130, 70, 173, 20);
		pnlRegisterReservation.add(jclEntryDate);

		JLabel lblExitDate = new JLabel("Fecha de salida:");
		lblExitDate.setBounds(20, 101, 100, 20);
		pnlRegisterReservation.add(lblExitDate);

		jclExitDate = new JDateChooser();
		jclExitDate.setBounds(130, 101, 173, 20);
		pnlRegisterReservation.add(jclExitDate);

		JLabel lblClient = new JLabel("Cliente:");
		lblClient.setBounds(20, 132, 100, 20);
		pnlRegisterReservation.add(lblClient);

		txtClient = new JTextField();
		txtClient.setBounds(130, 132, 173, 20);
		pnlRegisterReservation.add(txtClient);

		JLabel lblPersons = new JLabel("Personas:");
		lblPersons.setBounds(20, 163, 100, 20);
		pnlRegisterReservation.add(lblPersons);

		spnPeople = new JSpinner();
		spnPeople.setBounds(130, 163, 100, 20);
		pnlRegisterReservation.add(spnPeople);
	}

	private void initRequirementsPanel() {

		pnlRequirements = new JPanel();
		pnlRequirements.setPreferredSize(new Dimension(300, 10));
		add(pnlRequirements, BorderLayout.EAST);
		pnlRequirements.setBorder(BorderFactory.createTitledBorder("Requisitos de la reservación"));
		pnlRequirements.setLayout(null);

		JLabel lblRoomFree = new JLabel("Habitación disponible");
		lblRoomFree.setBounds(29, 55, 160, 14);
		pnlRequirements.add(lblRoomFree);

		JLabel lblMaxCapacity = new JLabel("Capacidad máxima");
		lblMaxCapacity.setBounds(29, 134, 160, 14);
		pnlRequirements.add(lblMaxCapacity);

		lblAvailableRoom = new JLabel("...");
		lblAvailableRoom.setOpaque(true);
		lblAvailableRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableRoom.setBounds(190, 52, 50, 40);
		pnlRequirements.add(lblAvailableRoom);

		lblAvailablePeople = new JLabel("...");
		lblAvailablePeople.setOpaque(true);
		lblAvailablePeople.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailablePeople.setBounds(190, 118, 50, 40);
		pnlRequirements.add(lblAvailablePeople);
	}

	private void initSummaryPanel() {

		pnlPendingReservation = new JPanel();
		pnlPendingReservation.setBorder(BorderFactory.createTitledBorder("Finalizar reservación"));
		pnlPendingReservation.setPreferredSize(new Dimension(10, 200));
		add(pnlPendingReservation, BorderLayout.SOUTH);
		pnlPendingReservation.setLayout(null);

		JLabel lblRoom = new JLabel("Habitación:");
		lblRoom.setBounds(10, 46, 120, 14);
		pnlPendingReservation.add(lblRoom);

		JLabel lblCapacity = new JLabel("Capacidad máxima:");
		lblCapacity.setBounds(10, 71, 140, 14);
		pnlPendingReservation.add(lblCapacity);

		JLabel lblRateNight = new JLabel("Tarifa por persona:");
		lblRateNight.setBounds(10, 96, 140, 14);
		pnlPendingReservation.add(lblRateNight);

		JLabel lblEntryDate = new JLabel("Fecha de entrada:");
		lblEntryDate.setBounds(10, 121, 120, 14);
		pnlPendingReservation.add(lblEntryDate);

		JLabel lblExitDate = new JLabel("Fecha de salida:");
		lblExitDate.setBounds(10, 146, 120, 14);
		pnlPendingReservation.add(lblExitDate);

		lblRoomD = new JLabel();
		lblRoomD.setBounds(150, 46, 200, 14);
		pnlPendingReservation.add(lblRoomD);

		lblCapacityD = new JLabel();
		lblCapacityD.setBounds(150, 71, 200, 14);
		pnlPendingReservation.add(lblCapacityD);

		lblRateNightD = new JLabel();
		lblRateNightD.setBounds(150, 96, 200, 14);
		pnlPendingReservation.add(lblRateNightD);

		lblEntryDateD = new JLabel();
		lblEntryDateD.setBounds(150, 121, 200, 14);
		pnlPendingReservation.add(lblEntryDateD);

		lblExitDateD = new JLabel();
		lblExitDateD.setBounds(150, 146, 200, 14);
		pnlPendingReservation.add(lblExitDateD);

		JLabel lblLotPersons = new JLabel("Personas:");
		lblLotPersons.setBounds(400, 46, 120, 14);
		pnlPendingReservation.add(lblLotPersons);

		JLabel lblLotNight = new JLabel("Noches:");
		lblLotNight.setBounds(400, 71, 120, 14);
		pnlPendingReservation.add(lblLotNight);

		JLabel lblCostNight = new JLabel("Costo por noche:");
		lblCostNight.setBounds(400, 96, 140, 14);
		pnlPendingReservation.add(lblCostNight);

		JLabel lblTotalCost = new JLabel("Total hospedaje:");
		lblTotalCost.setBounds(400, 121, 140, 14);
		pnlPendingReservation.add(lblTotalCost);

		lblLotPersonsD = new JLabel();
		lblLotPersonsD.setBounds(540, 46, 100, 14);
		pnlPendingReservation.add(lblLotPersonsD);

		lblLotNightD = new JLabel();
		lblLotNightD.setBounds(540, 71, 100, 14);
		pnlPendingReservation.add(lblLotNightD);

		lblCostNightD = new JLabel();
		lblCostNightD.setBounds(540, 96, 120, 14);
		pnlPendingReservation.add(lblCostNightD);

		lblTotalCostD = new JLabel();
		lblTotalCostD.setBounds(540, 121, 120, 14);
		pnlPendingReservation.add(lblTotalCostD);

		btnReserve = new JButton("Reservar");
		btnReserve.setBounds(400, 150, 120, 25);
		pnlPendingReservation.add(btnReserve);

		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(530, 150, 120, 25);
		pnlPendingReservation.add(btnCancel);
	}

	public void refreshRequirements() {
	    pnlRequirements.revalidate();
	    pnlRequirements.repaint();
	}	
	public JComboBox<Room> getCmbRoom() { return cmbRoom; }
	public JTextField getTxtClient() { return txtClient; }
	public JSpinner getSpnPeople() { return spnPeople; }
	public JDateChooser getJclEntryDate() { return jclEntryDate; }
	public JDateChooser getJclExitDate() { return jclExitDate; }
	public JLabel getLblAvailableRoom() { return lblAvailableRoom; }
	public JLabel getLblAvailablePeople() { return lblAvailablePeople; }
	public JLabel getLblRoomD() { return lblRoomD; }
	public JLabel getLblCapacityD() { return lblCapacityD; }
	public JLabel getLblRateNightD() { return lblRateNightD; }
	public JLabel getLblEntryDateD() { return lblEntryDateD; }
	public JLabel getLblExitDateD() { return lblExitDateD; }
	public JLabel getLblLotPersonsD() { return lblLotPersonsD; }
	public JLabel getLblLotNightD() { return lblLotNightD; }
	public JLabel getLblCostNightD() { return lblCostNightD; }
	public JLabel getLblTotalCostD() { return lblTotalCostD; }
	public JButton getBtnReserve() { return btnReserve; }
	public JButton getBtnCancel() { return btnCancel; }
}