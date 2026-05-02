package com.practicaguiadauno.mvc.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ViewMajor extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel pnlContent;
	private JLabel lblTitle;

	private JButton btnNuevaReservacion;
	private JButton btnReservaciones;
	private JButton btnReportes;

	private JPanel pnlMenu;

	public ViewMajor() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 525);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);

		initComponents();
	}

	public void init() {

		setTitle("La Cricka de Martha");
		setLocationRelativeTo(null);
		setVisible(true); 
		// antes se llamaba primero visible y luego location → mala práctica
	}

	public void initComponents() {

		pnlMenu = new JPanel();
		pnlMenu.setPreferredSize(new Dimension(180, 10));
		contentPane.add(pnlMenu, BorderLayout.WEST);
		pnlMenu.setBorder(BorderFactory.createTitledBorder("Menú"));

		btnNuevaReservacion = new JButton("Nueva reservación");
		btnNuevaReservacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevaReservacion.setPreferredSize(new Dimension(150, 40));
		pnlMenu.add(btnNuevaReservacion);

		btnReservaciones = new JButton("Reservaciones"); 
		// antes decía "Recervaciones" 
		btnReservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReservaciones.setPreferredSize(new Dimension(150, 40));
		pnlMenu.add(btnReservaciones);

		btnReportes = new JButton("Reportes");
		btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReportes.setPreferredSize(new Dimension(150, 40));
		pnlMenu.add(btnReportes);

		JPanel pnlMajor = new JPanel();
		contentPane.add(pnlMajor, BorderLayout.CENTER);
		pnlMajor.setLayout(new BorderLayout(0, 0));
		pnlMajor.setBorder(BorderFactory.createTitledBorder(""));

		JPanel pnlHeader = new JPanel();
		pnlHeader.setBorder(BorderFactory.createTitledBorder(""));
		pnlHeader.setPreferredSize(new Dimension(10, 60));
		pnlMajor.add(pnlHeader, BorderLayout.NORTH);
		pnlHeader.setLayout(new BorderLayout(0, 0));

		lblTitle = new JLabel("Hotel La Cricka de Martha - Nueva Reservación");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnlHeader.add(lblTitle, BorderLayout.CENTER);

		pnlContent = new JPanel();
		pnlMajor.add(pnlContent, BorderLayout.CENTER);
		pnlContent.setLayout(new BorderLayout(0, 0));
	}

	public void setContenido(JComponent c, String titulo) {

		lblTitle.setText(titulo);

		pnlContent.removeAll();
		pnlContent.add(c, BorderLayout.CENTER);

		pnlContent.revalidate();
		pnlContent.repaint(); 
		// antes faltaba repaint a veces no refresca bien
	}


	public JButton getBtnNuevaReservacion() { return btnNuevaReservacion; }

	public JButton getBtnReservaciones() { return btnReservaciones; }

	public JButton getBtnReportes() { return btnReportes; }
}