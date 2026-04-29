package com.practicaguiadauno.mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel contenido;
	private JLabel lblTitulo;
	private JButton btnNuevaReservacion;
	private JButton btnReservaciones;
	private JButton btnReportes;
	private JPanel panelMenu;

	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelMenu = new JPanel();
		panelMenu.setPreferredSize(new Dimension(180, 10));
		contentPane.add(panelMenu, BorderLayout.WEST);
		panelMenu.setBorder(BorderFactory.createTitledBorder("Menú"));
		
		btnNuevaReservacion = new JButton("Nueva Reservaci\u00F3n");
		btnNuevaReservacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNuevaReservacion.setPreferredSize(new Dimension(150, 40));
		panelMenu.add(btnNuevaReservacion);
		
		btnReservaciones = new JButton("Recervaciones");
		btnReservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReservaciones.setPreferredSize(new Dimension(150, 40));
		panelMenu.add(btnReservaciones);
		
		btnReportes = new JButton("Reportes");
		btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReportes.setPreferredSize(new Dimension(150, 40));
		panelMenu.add(btnReportes);
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		panelPrincipal.setBorder(BorderFactory.createTitledBorder(""));
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setPreferredSize(new Dimension(10, 60));
		panelPrincipal.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblTitulo = new JLabel("Hotel La Cricka de Martha - Nueva Reservación");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		panel.add(lblTitulo, BorderLayout.CENTER);
		
		contenido = new JPanel();
		panelPrincipal.add(contenido, BorderLayout.CENTER);
		contenido.setLayout(new BorderLayout(0, 0));
	}
	
	public void init() {
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("La Cricka");
	}
	
	public void setContenido(JComponent c, String titulo) {
		lblTitulo.setText(titulo);
		contenido.removeAll();
		contenido.add(c, BorderLayout.CENTER);
		contenido.revalidate();
	}

	public JButton getBtnNuevaReservacion() {
		return btnNuevaReservacion;
	}

	public JButton getBtnReservaciones() {
		return btnReservaciones;
	}

	public JButton getBtnReportes() {
		return btnReportes;
	}


}
