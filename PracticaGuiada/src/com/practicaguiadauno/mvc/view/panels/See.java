package com.practicaguiadauno.mvc.view.panels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.practicaguiadauno.utils.Fonts;
import com.practicaguiadauno.utils.ImageUtils;
import com.practicaguiadauno.utils.LoadImages;
import com.practicaguiadauno.utils.Themes;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

public class See extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnEditar;
	private JLabel lblId;
	private JLabel lblCliente;
	private JLabel lblHabitacion;
	private JLabel lblCapMax;
	private JLabel lblTarifa;
	private JLabel lblEntrada;
	private JLabel lblSalida;
	private JButton btnAlimentos;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;

	private JLabel lblCantPer;
	private JLabel lblCantNoches;
	private JLabel lblCostoNoche;
	private JLabel lblCostoTHospe;
	private JLabel lblCostoTAlimentos;
	private JLabel lblTotal;

	public See() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));

		panelReservacion();
		panelAlimentos();
		panelInferior();
	}

	public void panelReservacion() {

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		TitledBorder border=BorderFactory.createTitledBorder("Datos de la reservación");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		panel.setBorder(border);
		
		panel.setPreferredSize(new Dimension(230, 10));
		add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		
		lblNewLabel.setFont(Fonts.text(13));
		lblNewLabel.setBounds(10, 30, 24, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fecha de entrada:");
		
		lblNewLabel_1.setFont(Fonts.text(13));
		lblNewLabel_1.setBounds(10, 156, 125, 25);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		
		lblNewLabel_2.setFont(Fonts.text(13));
		lblNewLabel_2.setBounds(10, 55, 46, 25);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tarifa por persona por noche:");
		
		lblNewLabel_3.setFont(Fonts.text(13));
		lblNewLabel_3.setBounds(10, 131, 178, 25);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Habitación:");
		
		lblNewLabel_4.setFont(Fonts.text(13));
		lblNewLabel_4.setBounds(10, 81, 115, 25);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Capacidad máxima:");
		
		lblNewLabel_5.setFont(Fonts.text(13));
		lblNewLabel_5.setBounds(10, 106, 115, 25);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Fecha de salida:");
		
		lblNewLabel_6.setFont(Fonts.text(13));
		lblNewLabel_6.setBounds(10, 181, 125, 25);
		panel.add(lblNewLabel_6);

		btnEditar = new JButton("Editar");
		btnEditar.setPreferredSize(new Dimension(100, 30));
		btnEditar.setFont(Fonts.title(17));
		
		ImageUtils.setImageButton(btnEditar, LoadImages.ButtonGreen, 100, 30);
		
		btnEditar.setBounds(66, 251, 100, 30);
		panel.add(btnEditar);

		lblId = new JLabel("");
		lblId.setBounds(33, 30, 81, 25);
		lblId.setFont(Fonts.text(13));
		panel.add(lblId);

		lblCliente = new JLabel("");
		lblCliente.setBounds(66, 55, 112, 25);
		lblCliente.setFont(Fonts.text(13));
		panel.add(lblCliente);

		lblHabitacion = new JLabel("");
		lblHabitacion.setBounds(87, 81, 130, 25);
		lblHabitacion.setFont(Fonts.text(13));
		panel.add(lblHabitacion);

		lblCapMax = new JLabel("");
		lblCapMax.setBounds(130, 106, 130, 25);
		lblCapMax.setFont(Fonts.text(13));
		panel.add(lblCapMax);

		lblTarifa = new JLabel("");
		lblTarifa.setBounds(186, 131, 94, 25);
		lblTarifa.setFont(Fonts.text(13));
		panel.add(lblTarifa);

		lblEntrada = new JLabel("");
		lblEntrada.setBounds(130, 156, 130, 25);
		lblEntrada.setFont(Fonts.text(13));
		panel.add(lblEntrada);

		lblSalida = new JLabel("");
		lblSalida.setBounds(130, 181, 130, 25);
		lblSalida.setFont(Fonts.text(13));
		panel.add(lblSalida);
	}

	public void panelAlimentos() {

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1, BorderLayout.CENTER);
		TitledBorder border=BorderFactory.createTitledBorder("Alimentos");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		panel_1.setBorder(border);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(40, 50));
		panel_1.add(panel, BorderLayout.SOUTH);

		btnAlimentos = new JButton("Alimentos");
		btnAlimentos.setFont(Fonts.title(17));
		btnAlimentos.setPreferredSize(new Dimension(120, 40));
		
		ImageUtils.setImageButton(btnAlimentos, LoadImages.ButtonBlue, 120, 40);
		
		panel.add(btnAlimentos);

		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setPreferredSize(new Dimension(450, 400));
		scrollPane.setFont(Fonts.text(13));
		panel_1.add(scrollPane, BorderLayout.CENTER);

		modelo = new DefaultTableModel();

		table = new JTable(modelo) {
		    /**
			 * //No quiero cosas en amarillo
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		table.setOpaque(false);
		table.setPreferredSize(new Dimension(500, 500));
		table.setBackground(new Color(41,77,76));
		Themes.setThemes(table);
		table.setFont(Fonts.text(13));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		scrollPane.setViewportView(table);
	}

	public void panelInferior() {

		JPanel panel_2 = new JPanel();
		TitledBorder border=BorderFactory.createTitledBorder("");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		panel_2.setBorder(border);
		panel_2.setPreferredSize(new Dimension(10, 200));
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(null);

		lblNewLabel_7 = new JLabel("Cantidad de personas:");

		lblNewLabel_7.setFont(Fonts.text(13));
		lblNewLabel_7.setBounds(10, 11, 134, 25);
		panel_2.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Cantidad de noches:");

		lblNewLabel_8.setFont(Fonts.text(13));
		lblNewLabel_8.setBounds(10, 39, 134, 25);
		panel_2.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Costo por noche:");

		lblNewLabel_9.setFont(Fonts.text(13));
		lblNewLabel_9.setBounds(10, 64, 134, 25);
		panel_2.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("Costo total de hospedaje:");
	
		lblNewLabel_10.setFont(Fonts.text(13));
		lblNewLabel_10.setBounds(10, 100, 164, 25);
		panel_2.add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel("Costo total de alimentos:");
	
		lblNewLabel_11.setFont(Fonts.text(13));
		lblNewLabel_11.setBounds(10, 136, 164, 25);
		panel_2.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Total:");
	
		lblNewLabel_12.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(20, 164, 55, 25);
		panel_2.add(lblNewLabel_12);

		lblCantPer = new JLabel("");
		lblCantPer.setBounds(143, 11, 124, 25);
		lblCantPer.setFont(Fonts.text(13));
		panel_2.add(lblCantPer);

		lblCantNoches = new JLabel("");
		lblCantNoches.setBounds(133, 39, 134, 25);
		lblCantNoches.setFont(Fonts.text(13));
		panel_2.add(lblCantNoches);

		lblCostoNoche = new JLabel("");
		lblCostoNoche.setBounds(120, 64, 147, 25);
		lblCostoNoche.setFont(Fonts.text(13));
		panel_2.add(lblCostoNoche);

		lblCostoTHospe = new JLabel("");
		lblCostoTHospe.setBounds(167, 100, 113, 25);
		lblCostoTHospe.setFont(Fonts.text(13));
		panel_2.add(lblCostoTHospe);

		lblCostoTAlimentos = new JLabel("");
		lblCostoTAlimentos.setBounds(167, 132, 113, 25);
		lblCostoTAlimentos.setFont(Fonts.text(13));
		panel_2.add(lblCostoTAlimentos);

		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTotal.setBounds(85, 164, 124, 25);
		panel_2.add(lblTotal);
	}


	public JButton getBtnEditar() { return btnEditar; }
	public JLabel getLblId() { return lblId; }
	public JLabel getLblCliente() { return lblCliente; }
	public JLabel getLblHabitacion() { return lblHabitacion; }
	public JLabel getLblCapMax() { return lblCapMax; }
	public JLabel getLblTarifa() { return lblTarifa; }
	public JLabel getLblEntrada() { return lblEntrada; }
	public JLabel getLblSalida() { return lblSalida; }
	public JButton getBtnAlimentos() { return btnAlimentos; }
	public JTable getTable() { return table; }
	public JScrollPane getScrollPane() { return scrollPane; }
	public DefaultTableModel getModelo() { return modelo; }
	public JLabel getLblCantPer() { return lblCantPer; }
	public JLabel getLblCantNoches() { return lblCantNoches; }
	public JLabel getLblCostoNoche() { return lblCostoNoche; }
	public JLabel getLblCostoTHospe() { return lblCostoTHospe; }
	public JLabel getLblCostoTAlimentos() { return lblCostoTAlimentos; }
	public JLabel getLblTotal() { return lblTotal; }
}