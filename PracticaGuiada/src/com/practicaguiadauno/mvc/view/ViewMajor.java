package com.practicaguiadauno.mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.practicaguiadauno.mvc.view.components.BackgroundCustom;
import com.practicaguiadauno.utils.Fonts;
import com.practicaguiadauno.utils.ImageUtils;
import com.practicaguiadauno.utils.LoadImages;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		
		setIconImage(ImageUtils.getScaledIcon(LoadImages.Icon, 128, 128).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 602);

		contentPane = new JPanel();
		contentPane.setBorder(null);
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

		pnlMenu = new BackgroundCustom(LoadImages.Menu);
		pnlMenu.setPreferredSize(new Dimension(350, 10));
		contentPane.add(pnlMenu, BorderLayout.WEST);
		TitledBorder border=BorderFactory.createTitledBorder("Menú");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		pnlMenu.setBorder(border);

		btnNuevaReservacion = new JButton("Nueva reservación");
		btnNuevaReservacion.setFont(Fonts.title(20));
		
		ImageUtils.setImageButton(btnNuevaReservacion, LoadImages.Button, 200, 40);
		
		btnNuevaReservacion.setPreferredSize(new Dimension(200, 40));
		pnlMenu.add(btnNuevaReservacion);

		btnReservaciones = new JButton("Reservaciones"); 
		btnReservaciones.setFont(Fonts.title(20));

		ImageUtils.setImageButton(btnReservaciones,LoadImages.Button, 200, 40);
		
		btnReservaciones.setPreferredSize(new Dimension(200, 40));
		pnlMenu.add(btnReservaciones);

		btnReportes = new JButton("Reportes");
		btnReportes.setFont(Fonts.title(20));
		btnReportes.setForeground(Color.BLACK);
		
		ImageUtils.setImageButton(btnReportes, LoadImages.Button, 200, 40);

		
		btnReportes.setPreferredSize(new Dimension(200, 40));
		pnlMenu.add(btnReportes);

		JPanel pnlMajor = new JPanel();
		contentPane.add(pnlMajor, BorderLayout.CENTER);
		pnlMajor.setLayout(new BorderLayout(0, 0));
		pnlMajor.setBorder(BorderFactory.createTitledBorder(""));

		JPanel pnlHeader = new BackgroundCustom(LoadImages.TopBar);
		pnlHeader.setBorder(BorderFactory.createTitledBorder(""));
		pnlHeader.setPreferredSize(new Dimension(10, 60));
		pnlMajor.add(pnlHeader, BorderLayout.NORTH);
		pnlHeader.setLayout(new BorderLayout(0, 0));
 
		lblTitle = new JLabel("Hotel La Cricka de Martha - Nueva Reservación");
		lblTitle.setFont(Fonts.title(30));
		lblTitle.setForeground(new Color(51, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnlHeader.add(lblTitle, BorderLayout.CENTER);

		pnlContent = new JPanel();
		pnlContent.setOpaque(false);
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