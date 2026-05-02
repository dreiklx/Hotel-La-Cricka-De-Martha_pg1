package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.*;
import java.awt.*;

import com.toedter.calendar.JDateChooser;
import com.practicaguiadauno.mvc.model.Room; // antes Habitacion

@SuppressWarnings("unused")
public class Edit extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Room> cmbRoom; // antes Habitacion
    private JTextField txtClient;
    private JDateChooser jclEntryDate;
    private JDateChooser jclExitDate;
    private JSpinner spnPeople;

    private JButton btnUpdate;
    private JButton btnCancel;

    public Edit() {

        setLayout(null);

        JLabel lblRoom = new JLabel("Habitación:");
        lblRoom.setBounds(30, 30, 100, 20);
        add(lblRoom);

        cmbRoom = new JComboBox<>();
        cmbRoom.setBounds(150, 30, 200, 20);
        add(cmbRoom);

        JLabel lblClient = new JLabel("Cliente:");
        lblClient.setBounds(30, 60, 100, 20);
        add(lblClient);

        txtClient = new JTextField();
        txtClient.setBounds(150, 60, 200, 20);
        add(txtClient);

        JLabel lblEntry = new JLabel("Fecha de entrada:");
        lblEntry.setBounds(30, 90, 100, 20);
        add(lblEntry);

        jclEntryDate = new JDateChooser();
        jclEntryDate.setBounds(150, 90, 200, 20);
        add(jclEntryDate);

        JLabel lblExit = new JLabel("Fecha de salida:");
        lblExit.setBounds(30, 120, 100, 20);
        add(lblExit);

        jclExitDate = new JDateChooser();
        jclExitDate.setBounds(150, 120, 200, 20);
        add(jclExitDate);

        JLabel lblPeople = new JLabel("Personas:");
        lblPeople.setBounds(30, 150, 100, 20);
        add(lblPeople);

        spnPeople = new JSpinner();
        spnPeople.setBounds(150, 150, 200, 20);
        add(spnPeople);

        btnUpdate = new JButton("Actualizar");
        btnUpdate.setBounds(150, 200, 90, 25);
        add(btnUpdate);

        btnCancel = new JButton("Cancelar");
        btnCancel.setBounds(260, 200, 90, 25);
        add(btnCancel);
    }

    public JComboBox<Room> getCmbRoom() { return cmbRoom; }
    public JTextField getTxtClient() { return txtClient; }
    public JDateChooser getJclEntryDate() { return jclEntryDate; }
    public JDateChooser getJclExitDate() { return jclExitDate; }
    public JSpinner getSpnPeople() { return spnPeople; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnCancel() { return btnCancel; }
}