package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.practicaguiadauno.mvc.model.Room; // antes Habitacion
import com.practicaguiadauno.mvc.view.components.BackgroundCustom;
import com.practicaguiadauno.utils.Fonts;
import com.practicaguiadauno.utils.ImageUtils;
import com.practicaguiadauno.utils.LoadImages;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
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
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		initReservationPanel();
		initRequirementsPanel();
		initSummaryPanel();
	}

	private void initReservationPanel() {

		pnlRegisterReservation = new BackgroundCustom(LoadImages.Background);
		pnlRegisterReservation.setOpaque(false);
		add(pnlRegisterReservation, BorderLayout.CENTER);
		TitledBorder border=BorderFactory.createTitledBorder("Datos de la reservación");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		pnlRegisterReservation.setBorder(border);
		pnlRegisterReservation.setLayout(null);

		JLabel lblRoom = new JLabel("Habitación:");
		lblRoom.setBounds(20, 37, 128, 25);
		lblRoom.setFont(Fonts.text(13));
		pnlRegisterReservation.add(lblRoom);

		cmbRoom = new JComboBox<>();
		cmbRoom.setBounds(181, 37, 193, 25);
		cmbRoom.setFont(Fonts.text(13));
		AutoCompleteDecorator.decorate(cmbRoom);
		pnlRegisterReservation.add(cmbRoom);

		JLabel lblEntryDate = new JLabel("Fecha de entrada:");
		lblEntryDate.setBounds(20, 73, 128, 25);
		lblEntryDate.setFont(Fonts.text(13));

		pnlRegisterReservation.add(lblEntryDate);

		jclEntryDate = new JDateChooser();
		jclEntryDate.setBounds(181, 73, 193, 25);
		jclEntryDate.setFont(Fonts.text(13));
		pnlRegisterReservation.add(jclEntryDate);

		JLabel lblExitDate = new JLabel("Fecha de salida:");
		lblExitDate.setBounds(20, 109, 128, 25);
		lblExitDate.setFont(Fonts.text(13));
		pnlRegisterReservation.add(lblExitDate);

		jclExitDate = new JDateChooser();
		jclExitDate.setBounds(181, 109, 193, 25);
		jclExitDate.setFont(Fonts.text(13));
		pnlRegisterReservation.add(jclExitDate);

		JLabel lblClient = new JLabel("Cliente:");
		lblClient.setBounds(20, 145, 128, 25);
		lblClient.setFont(Fonts.text(13));

		pnlRegisterReservation.add(lblClient);

		txtClient = new JTextField();
		txtClient.setBounds(181, 145, 173, 25);
		txtClient.setFont(Fonts.text(13));
		pnlRegisterReservation.add(txtClient);

		JLabel lblPersons = new JLabel("Personas:");
		lblPersons.setBounds(20, 181, 128, 25);
		lblPersons.setFont(Fonts.text(13));

		pnlRegisterReservation.add(lblPersons);

		spnPeople = new JSpinner();
		spnPeople.setBounds(181, 181, 193, 25);
		spnPeople.setFont(Fonts.text(13));
		pnlRegisterReservation.add(spnPeople);
	}

	private void initRequirementsPanel() {

		pnlRequirements = new JPanel();
		pnlRequirements.setBackground(new Color(23, 7, 0));
		pnlRequirements.setPreferredSize(new Dimension(300, 10));
		add(pnlRequirements, BorderLayout.EAST);
		TitledBorder border=BorderFactory.createTitledBorder("Requisitos de la reservación");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		pnlRequirements.setBorder(border);
		pnlRequirements.setLayout(null);

		JLabel lblRoomFree = new JLabel("Habitación disponible");
		lblRoomFree.setBounds(29, 55, 160, 14);
		lblRoomFree.setFont(Fonts.text(13));

		pnlRequirements.add(lblRoomFree);

		JLabel lblMaxCapacity = new JLabel("Capacidad máxima");
		lblMaxCapacity.setBounds(29, 134, 160, 14);
		lblMaxCapacity.setFont(Fonts.text(13));

		pnlRequirements.add(lblMaxCapacity);

		lblAvailableRoom = new JLabel("...");
		lblAvailableRoom.setOpaque(false);
		lblAvailableRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailableRoom.setBounds(190, 52, 50, 40);
		pnlRequirements.add(lblAvailableRoom);

		lblAvailablePeople = new JLabel("...");
		lblAvailablePeople.setBackground(Color.LIGHT_GRAY);
		lblAvailablePeople.setOpaque(false);
		lblAvailablePeople.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvailablePeople.setBounds(190, 118, 50, 40);
		pnlRequirements.add(lblAvailablePeople);
	}

	private void initSummaryPanel() {

		pnlPendingReservation = new JPanel();
		pnlPendingReservation.setBackground(new Color(71, 137, 125));
		TitledBorder border=BorderFactory.createTitledBorder("Finalizar reservación");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		pnlPendingReservation.setBorder(border);
		pnlPendingReservation.setPreferredSize(new Dimension(10, 200));
		add(pnlPendingReservation, BorderLayout.SOUTH);
		pnlPendingReservation.setLayout(null);

		JLabel lblRoom = new JLabel("Habitación:");
		lblRoom.setBounds(10, 29, 120, 25);
		lblRoom.setForeground(Color.BLACK);
		lblRoom.setFont(Fonts.text(13));

		pnlPendingReservation.add(lblRoom);

		JLabel lblCapacity = new JLabel("Capacidad máxima:");
		lblCapacity.setBounds(10, 60, 140, 25);
		lblCapacity.setFont(Fonts.text(13));
		lblCapacity.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblCapacity);

		JLabel lblRateNight = new JLabel("Tarifa por persona:");
		lblRateNight.setBounds(10, 91, 140, 25);
		lblRateNight.setFont(Fonts.text(13));
		lblRateNight.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblRateNight);

		JLabel lblEntryDate = new JLabel("Fecha de entrada:");
		lblEntryDate.setBounds(10, 121, 120, 25);
		lblEntryDate.setFont(Fonts.text(13));
		lblEntryDate.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblEntryDate);

		JLabel lblExitDate = new JLabel("Fecha de salida:");
		lblExitDate.setBounds(10, 150, 120, 25);
		lblExitDate.setFont(Fonts.text(13));
		lblExitDate.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblExitDate);

		lblRoomD = new JLabel();
		lblRoomD.setBounds(150, 29, 200, 25);
		lblRoomD.setFont(Fonts.text(13));
		lblRoomD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblRoomD);

		lblCapacityD = new JLabel();
		lblCapacityD.setBounds(150, 60, 200, 25);
		lblCapacityD.setFont(Fonts.text(13));
		lblCapacityD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblCapacityD);

		lblRateNightD = new JLabel();
		lblRateNightD.setBounds(150, 91, 200, 25);
		lblRateNightD.setFont(Fonts.text(13));
		lblRateNightD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblRateNightD);

		lblEntryDateD = new JLabel();
		lblEntryDateD.setBounds(150, 121, 200, 25);
		lblEntryDateD.setFont(Fonts.text(13));
		lblEntryDateD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblEntryDateD);

		lblExitDateD = new JLabel();
		lblExitDateD.setBounds(150, 150, 200, 25);
		lblExitDateD.setFont(Fonts.text(13));
		lblExitDateD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblExitDateD);

		JLabel lblLotPersons = new JLabel("Personas:");
		lblLotPersons.setBounds(400, 29, 120, 25);
		lblLotPersons.setFont(Fonts.text(13));
		lblLotPersons.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblLotPersons);

		JLabel lblLotNight = new JLabel("Noches:");
		lblLotNight.setBounds(400, 60, 120, 25);
		lblLotNight.setFont(Fonts.text(13));
		lblLotNight.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblLotNight);

		JLabel lblCostNight = new JLabel("Costo por noche:");
		lblCostNight.setBounds(400, 91, 140, 25);
		lblCostNight.setFont(Fonts.text(13));
		lblCostNight.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblCostNight);

		JLabel lblTotalCost = new JLabel("Total hospedaje:");
		lblTotalCost.setBounds(400, 121, 140, 25);
		lblTotalCost.setFont(Fonts.text(13));
		lblTotalCost.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblTotalCost);

		lblLotPersonsD = new JLabel();
		lblLotPersonsD.setBounds(540, 29, 187, 25);
		lblLotPersonsD.setFont(Fonts.text(13));
		lblLotPersonsD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblLotPersonsD);

		lblLotNightD = new JLabel();
		lblLotNightD.setBounds(540, 60, 187, 25);
		lblLotNightD.setFont(Fonts.text(13));
		lblLotNightD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblLotNightD);

		lblCostNightD = new JLabel();
		lblCostNightD.setBounds(540, 91, 187, 25);
		lblCostNightD.setFont(Fonts.text(13));
		lblCostNightD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblCostNightD);

		lblTotalCostD = new JLabel();
		lblTotalCostD.setBounds(540, 121, 187, 25);
		lblTotalCostD.setFont(Fonts.text(13));
		lblTotalCostD.setForeground(Color.BLACK);
		pnlPendingReservation.add(lblTotalCostD);

		btnReserve = new JButton("Reservar");
		btnReserve.setPreferredSize(new Dimension(110, 30));
		btnReserve.setFont(Fonts.title(17));
		
		ImageUtils.setImageButton(btnReserve, LoadImages.ButtonGreen, 110, 30);
		
		btnReserve.setBounds(400, 157, 110, 30);
		pnlPendingReservation.add(btnReserve);

		btnCancel = new JButton("Cancelar");
		btnCancel.setPreferredSize(new Dimension(110, 30));
		
		ImageUtils.setImageButton(btnCancel, LoadImages.ButtonRed, 110, 30);
		
		btnCancel.setFont(Fonts.title(17));
		btnCancel.setBounds(540, 157, 120, 30);
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