package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.font.ImageGraphicAttribute;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.practicaguiadauno.utils.Fonts;
import com.practicaguiadauno.utils.ImageUtils;
import com.practicaguiadauno.utils.LoadImages;
import com.practicaguiadauno.utils.Themes;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import java.awt.Color;

@SuppressWarnings("unused")
public class Index extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;

	private JButton btnFood;
	private JButton btnDelete;
	private JButton btnSee;
	private JButton btnEdit;
	private JButton btnNew;

	public Index() {
		setOpaque(false);

		setLayout(new BorderLayout(0, 0));

		JPanel pnlSearch = new JPanel();
		pnlSearch.setOpaque(false);

		pnlSearch.setBorder(new EmptyBorder(10, 0, 10, 0));
		pnlSearch.setPreferredSize(new Dimension(100, 70));
		add(pnlSearch, BorderLayout.NORTH);
		TitledBorder border=BorderFactory.createTitledBorder("Reservaciones");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		pnlSearch.setBorder(border);
		pnlSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblSearch = new JLabel("Buscar:");
		lblSearch.setFont(Fonts.text(13));

		lblSearch.setHorizontalAlignment(SwingConstants.LEFT);
		pnlSearch.add(lblSearch);

		txtSearch =  new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setPreferredSize(new Dimension(500, 30));
		txtSearch.setFont(Fonts.text(13));
		txtSearch.setColumns(10);
		pnlSearch.add(txtSearch);

		JPanel pnlButtons = new JPanel();
		pnlButtons.setOpaque(false);
		pnlButtons.setPreferredSize(new Dimension(10, 60));
		add(pnlButtons, BorderLayout.SOUTH);

		FlowLayout fl_pnlButtons = new FlowLayout(FlowLayout.RIGHT, 15, 17);
		fl_pnlButtons.setAlignOnBaseline(true);
		pnlButtons.setLayout(fl_pnlButtons);

		btnNew = new JButton("Nueva");
		btnNew.setPreferredSize(new Dimension(100, 30));
		btnNew.setFont(Fonts.title(17));
		
		ImageUtils.setImageButton(btnNew, LoadImages.ButtonGreen, 100, 30);
		
		pnlButtons.add(btnNew);

		btnSee = new JButton("Ver");
		btnSee.setPreferredSize(new Dimension(100, 30));
		btnSee.setFont(Fonts.title(17));
		
		ImageUtils.setImageButton(btnSee, LoadImages.ButtonGreen, 100, 30);
		
		pnlButtons.add(btnSee);
		
		btnEdit = new JButton("Editar");
		btnEdit.setPreferredSize(new Dimension(100, 30));
		btnEdit.setFont(Fonts.title(17));
		
		ImageUtils.setImageButton(btnEdit, LoadImages.ButtonGreen, 100, 30);
		
		pnlButtons.add(btnEdit);

		btnDelete = new JButton("Eliminar");
		btnDelete.setPreferredSize(new Dimension(100, 30));
		btnDelete.setFont(Fonts.title(17));
		
		ImageUtils.setImageButton(btnDelete, LoadImages.ButtonRed, 100, 30);
		
		pnlButtons.add(btnDelete);

		btnFood = new JButton("Alimentos");
		btnFood.setPreferredSize(new Dimension(100, 30));
		btnFood.setFont(Fonts.title(17));
		
		ImageUtils.setImageButton(btnFood, LoadImages.ButtonBlue, 100, 30);
		
		pnlButtons.add(btnFood);

		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		scrollPane.setFont(Fonts.text(13));
		add(scrollPane, BorderLayout.CENTER);


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
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		// bloquear mover columnas
		table.getTableHeader().setReorderingAllowed(false);

		// bloquear cambiar tamaño
		table.getTableHeader().setResizingAllowed(false);

		scrollPane.setViewportView(table);
	}

	// getters

	public JTextField getTxtSearch() { 
		return txtSearch; 
	}
	public JButton getBtnEditar() {
		return btnEdit;
	}

	public JTable getTable() { return table; }

	public DefaultTableModel getModelo() { return modelo; }

	public JScrollPane getScrollPane() { return scrollPane; }

	public JButton getBtnAlimentos() { return btnFood; }

	public JButton getBtnEliminar() { return btnDelete; }

	public JButton getBtnVer() { return btnSee; }

	public JButton getBtnNueva() { return btnNew; }
}