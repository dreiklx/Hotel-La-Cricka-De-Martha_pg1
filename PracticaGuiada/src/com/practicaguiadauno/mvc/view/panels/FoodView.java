package com.practicaguiadauno.mvc.view.panels;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.practicaguiadauno.mvc.model.Food; // antes Alimento
import com.practicaguiadauno.mvc.model.FoodCategory; // antes CategoriaAlimento
import com.practicaguiadauno.utils.Fonts;
import com.practicaguiadauno.utils.ImageUtils;
import com.practicaguiadauno.utils.LoadImages;
import com.practicaguiadauno.utils.Themes;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;

public class FoodView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblId;
	private JLabel lblClient;
	private JLabel lblRoom;
	private JLabel lblCapacity;
	private JLabel lblRate;
	private JLabel lblEntry;
	private JLabel lblExit;
	private JTable table;
	private DefaultTableModel modelo;
	private JComboBox<FoodCategory> cbxCategory; 
	private JComboBox<Food> cbxFood; 
	private JSpinner spnLot;
	private JLabel lblSubtotal;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JButton btnCancel;
	private JButton btnSave;
	private JLabel lblTotalFood;
	private JButton btnDelete;

	public FoodView() {
		setOpaque(false);
		setLayout(new BorderLayout(0, 0));
		pnlComponentsReservation();
		pnlComponentsFoodManagement();
		pnlComponentsResult();
	}

	public void pnlComponentsReservation() {
		JPanel pnlDataReservation = new JPanel();
		pnlDataReservation.setOpaque(false);
		pnlDataReservation.setPreferredSize(new Dimension(290, 80));
		add(pnlDataReservation, BorderLayout.WEST);
		TitledBorder border=BorderFactory.createTitledBorder("Datos de la reservación");
		border.setTitleFont(Fonts.title(20));
		border.setTitleColor(Color.WHITE);
		pnlDataReservation.setBorder(border);

		pnlDataReservation.setPreferredSize(new Dimension(270, 10));
		add(pnlDataReservation, BorderLayout.WEST);
		pnlDataReservation.setLayout(null);

		JLabel lblIdT = new JLabel("ID:");
		lblIdT.setFont(Fonts.text(13));
		
		lblIdT.setBounds(10, 30, 46, 25);
		pnlDataReservation.add(lblIdT);

		JLabel lblEntryT = new JLabel("Fecha de entrada:");
		lblEntryT.setFont(Fonts.text(13));
		
		lblEntryT.setBounds(10, 156, 115, 25);
		pnlDataReservation.add(lblEntryT);

		JLabel lblClientT = new JLabel("Cliente:");
		lblClientT.setFont(Fonts.text(13));
		
		lblClientT.setBounds(10, 55, 46, 25);
		pnlDataReservation.add(lblClientT);

		JLabel lblrateT = new JLabel("Tarifa por persona por noche:");
		lblrateT.setFont(Fonts.text(13));
		
		lblrateT.setBounds(10, 131, 177, 25);
		pnlDataReservation.add(lblrateT);

		JLabel lblroomT = new JLabel("Habitación:");
		lblroomT.setFont(Fonts.text(13));
		
		lblroomT.setBounds(10, 81, 75, 25);
		pnlDataReservation.add(lblroomT);

		JLabel lblCapacityT = new JLabel("Capacidad máxima:");
		lblCapacityT.setFont(Fonts.text(13));
		
		lblCapacityT.setBounds(10, 106, 115, 25);
		pnlDataReservation.add(lblCapacityT);

		JLabel lblExitT = new JLabel("Fecha de salida:");
		lblExitT.setFont(Fonts.text(13));
		
		lblExitT.setBounds(10, 181, 115, 25);
		pnlDataReservation.add(lblExitT);

		lblId = new JLabel("");
		lblId.setFont(Fonts.text(13));
		
		lblId.setBounds(75, 30, 81, 25);
		pnlDataReservation.add(lblId);

		lblClient = new JLabel("");
		lblClient.setBounds(75, 56, 112, 24);
		lblClient.setFont(Fonts.text(13));
		
		pnlDataReservation.add(lblClient);

		lblRoom = new JLabel("");
		lblRoom.setBounds(74, 81, 103, 25);
		lblRoom.setFont(Fonts.text(13));
		
		pnlDataReservation.add(lblRoom);

		lblCapacity = new JLabel("");
		lblCapacity.setBounds(130, 106, 89, 25);
		lblCapacity.setFont(Fonts.text(13));
		
		pnlDataReservation.add(lblCapacity);

		lblRate = new JLabel("");
		lblRate.setBounds(186, 131, 84, 25);
		lblRate.setFont(Fonts.text(13));
		
		pnlDataReservation.add(lblRate);

		lblEntry = new JLabel("");
		lblEntry.setBounds(135, 156, 125, 25);
		lblEntry.setFont(Fonts.text(13));
		
		pnlDataReservation.add(lblEntry);

		lblExit = new JLabel("");
		lblExit.setBounds(135, 181, 125, 25);
		lblExit.setFont(Fonts.text(13));
		
		pnlDataReservation.add(lblExit);
	}

	public void pnlComponentsFoodManagement() {

		JPanel pnlFoodManagement = new JPanel();
		pnlFoodManagement.setOpaque(false);
		add(pnlFoodManagement, BorderLayout.CENTER);
		TitledBorder border=BorderFactory.createTitledBorder("Gestionar alimentos");
		border.setTitleColor(Color.DARK_GRAY);
		border.setTitleFont(Fonts.title(20));
		pnlFoodManagement.setLayout(new BorderLayout(0, 0));

		JPanel pnl = new JPanel();
		pnl.setOpaque(false);
		pnl.setPreferredSize(new Dimension(10, 170));
		pnlFoodManagement.add(pnl, BorderLayout.NORTH);
		pnl.setLayout(null);

		JLabel lblCategoryT = new JLabel("Categoria:");
		lblCategoryT.setForeground(Color.BLACK);
		lblCategoryT.setFont(Fonts.text(13));
		lblCategoryT.setBounds(10, 11, 67, 25);
		pnl.add(lblCategoryT);

		JLabel lblFoodT = new JLabel("Alimento:");
		lblFoodT.setForeground(Color.BLACK);
		lblFoodT.setFont(Fonts.text(13));
		lblFoodT.setBounds(10, 47, 67, 25);
		pnl.add(lblFoodT);

		JLabel lblLotT = new JLabel("Cantidad:");
		lblLotT.setForeground(Color.BLACK);
		lblLotT.setFont(Fonts.text(13));
		lblLotT.setBounds(10, 83, 67, 25);
		pnl.add(lblLotT);

		JLabel lblSubTotalT = new JLabel("Subtotal:");
		lblSubTotalT.setForeground(Color.BLACK);
		lblSubTotalT.setFont(Fonts.text(13));
		lblSubTotalT.setBounds(10, 137, 79, 25);
		pnl.add(lblSubTotalT);

		cbxCategory = new JComboBox<>();
		cbxCategory.setBounds(87, 11, 223, 25);
		cbxCategory.setFont(Fonts.text(13));
		pnl.add(cbxCategory);

		cbxFood = new JComboBox<>();
		cbxFood.setBounds(87, 47, 223, 25);
		cbxFood.setFont(Fonts.text(13));
		pnl.add(cbxFood);

		spnLot = new JSpinner();
		spnLot.setBounds(87, 83, 223, 25);
		spnLot.setFont(Fonts.text(13));
		pnl.add(spnLot);

		lblSubtotal = new JLabel("");
		lblSubtotal.setFont(Fonts.text(13));
		lblSubtotal.setBounds(96, 137, 110, 25);
		pnl.add(lblSubtotal);

		btnAdd = new JButton("Agregar");
		btnAdd.setFont(Fonts.title(17));
		btnAdd.setBounds(221, 137, 100, 30);
		
		ImageUtils.setImageButton(btnAdd, LoadImages.ButtonGreen, 100, 30);
		
		pnl.add(btnAdd);

		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setFont(Fonts.text(13));
		pnlFoodManagement.add(scrollPane, BorderLayout.CENTER);

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
		table.setBackground(new Color(41,77,76));
		table.setPreferredSize(new Dimension(500, 500));
		Themes.setThemes(table);
		table.setFont(Fonts.text(13));
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnlFoodManagement.add(panel, BorderLayout.SOUTH);
		
		btnDelete = new JButton("Eliminar");
		btnDelete.setFont(Fonts.title(17));
		btnDelete.setPreferredSize(new Dimension(100, 30));
		
		ImageUtils.setImageButton(btnDelete, LoadImages.ButtonRed, 100, 30);
		
		panel.add(btnDelete);
	}

	public void pnlComponentsResult() {

		JPanel pnlResult = new JPanel();
		pnlResult.setBackground(new Color(220, 236, 250)); 
		pnlResult.setPreferredSize(new Dimension(10, 100));
		add(pnlResult, BorderLayout.SOUTH);
		pnlResult.setLayout(null);

		JLabel lblTotalFoodT = new JLabel("Total alimentos:");
		lblTotalFoodT.setForeground(Color.BLACK);
		lblTotalFoodT.setBounds(10, 33, 145, 25);
		lblTotalFoodT.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlResult.add(lblTotalFoodT);

		lblTotalFood = new JLabel("");
		lblTotalFood.setForeground(Color.BLACK);
		lblTotalFood.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTotalFood.setBounds(157, 33, 176, 25);
		pnlResult.add(lblTotalFood);

		btnSave = new JButton("Guardar");
		btnSave.setFont(Fonts.title(17));
		btnSave.setBounds(380, 33, 100, 30);
		
		ImageUtils.setImageButton(btnSave, LoadImages.ButtonGreen, 100, 30);
		
		pnlResult.add(btnSave);

		btnCancel = new JButton("Cancelar");
		btnCancel.setFont(Fonts.title(17));
		btnCancel.setBounds(495, 33, 100, 30);
		
		ImageUtils.setImageButton(btnCancel, LoadImages.ButtonRed, 100, 30);
		
		pnlResult.add(btnCancel);
	}


	public JLabel getLblId() { return lblId; }
	public JLabel getLblCliente() { return lblClient; }
	public JLabel getLblHabitacion() { return lblRoom; }
	public JLabel getLblCapMax() { return lblCapacity; }
	public JLabel getLblTarifa() { return lblRate; }
	public JLabel getLblEntrada() { return lblEntry; }
	public JLabel getLblSalida() { return lblExit; }
	public JTable getTable() { return table; }
	public DefaultTableModel getModelo() { return modelo; }
	public JComboBox<FoodCategory> getCbxCategoria() { return cbxCategory; }
	public JComboBox<Food> getCbxAlimento() { return cbxFood; }
	public JSpinner getSpinner() { return spnLot; }
	public JLabel getLblSubtotal() { return lblSubtotal; }
	public JButton getBtnAgregar() { return btnAdd; }
	public JButton getBtnCancelar() { return btnCancel; }
	public JButton getBtnGuardar() { return btnSave; }
	public JLabel getLblTotalalimentos() { return lblTotalFood; }
	public JButton getBtnEliminar() { return btnDelete;}
}