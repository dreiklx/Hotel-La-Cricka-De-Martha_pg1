package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.*;
import java.awt.*;

import com.toedter.calendar.JDateChooser;
import com.practicaguiadauno.mvc.model.Room; // antes Habitacion
import com.practicaguiadauno.mvc.view.components.BackgroundCustom;
import com.practicaguiadauno.utils.Fonts;
import com.practicaguiadauno.utils.ImageUtils;
import com.practicaguiadauno.utils.LoadImages;

@SuppressWarnings("unused")
public class Edit extends BackgroundCustom {

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
    	super(LoadImages.Background);
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 525, 300);
        panel.setBackground(new Color(41,77,76,50));
        add(panel);
        panel.setLayout(null);

        JLabel lblRoom = new JLabel("Habitación:");
        lblRoom.setBounds(33, 22, 104, 24);
        lblRoom.setFont(Fonts.text(13));

        panel.add(lblRoom);

        cmbRoom = new JComboBox<>();
        cmbRoom.setBounds(147, 19, 184, 24);
        cmbRoom.setFont(Fonts.text(13));
        panel.add(cmbRoom);

        JLabel lblClient = new JLabel("Cliente:");
        lblClient.setBounds(33, 64, 104, 24);
        lblClient.setFont(Fonts.text(13));

        panel.add(lblClient);

        txtClient = new JTextField();
        txtClient.setBounds(147, 60, 165, 24);
        txtClient.setFont(Fonts.text(13));
        panel.add(txtClient);

        JLabel lblEntry = new JLabel("Fecha de entrada:");
        lblEntry.setBounds(33, 109, 104, 24);
        lblEntry.setFont(Fonts.text(13));

        panel.add(lblEntry);

        jclEntryDate = new JDateChooser();
        jclEntryDate.setBounds(147, 109, 184, 24);
        jclEntryDate.setFont(Fonts.text(13));
        panel.add(jclEntryDate);

        JLabel lblExit = new JLabel("Fecha de salida:");
        lblExit.setBounds(33, 144, 104, 24);
        lblExit.setFont(Fonts.text(13));
       
        panel.add(lblExit);

        jclExitDate = new JDateChooser();
        jclExitDate.setBounds(147, 144, 184, 24);
        jclExitDate.setFont(Fonts.text(13));
        panel.add(jclExitDate);

        JLabel lblPeople = new JLabel("Personas:");
        lblPeople.setBounds(33, 179, 104, 24);
        lblPeople.setFont(Fonts.text(13));
        
        panel.add(lblPeople);

        spnPeople = new JSpinner();
        spnPeople.setBounds(147, 179, 184, 24);
        spnPeople.setFont(Fonts.text(13));
        panel.add(spnPeople);

        btnUpdate = new JButton("Actualizar");
        btnUpdate.setFont(Fonts.title(17));
        btnUpdate.setBounds(147, 231, 100, 30);
        
        ImageUtils.setImageButton(btnUpdate, LoadImages.ButtonGreen, 100, 30);
        
        panel.add(btnUpdate);

        btnCancel = new JButton("Cancelar");
        btnCancel.setFont(Fonts.title(17));
        btnCancel.setBounds(252, 231, 100, 30);
        
        ImageUtils.setImageButton(btnCancel, LoadImages.ButtonRed, 100, 30);
        
        panel.add(btnCancel);
        
        
    }

    public JComboBox<Room> getCmbRoom() { return cmbRoom; }
    public JTextField getTxtClient() { return txtClient; }
    public JDateChooser getJclEntryDate() { return jclEntryDate; }
    public JDateChooser getJclExitDate() { return jclExitDate; }
    public JSpinner getSpnPeople() { return spnPeople; }
    public JButton getBtnUpdate() { return btnUpdate; }
    public JButton getBtnCancel() { return btnCancel; }
}