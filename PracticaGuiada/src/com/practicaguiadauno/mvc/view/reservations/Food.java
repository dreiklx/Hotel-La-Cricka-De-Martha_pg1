package com.practicaguiadauno.mvc.view.reservations;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.practicaguiadauno.mvc.model.Alimento;
import com.practicaguiadauno.mvc.model.CategoriaAlimento;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class Food extends JPanel {
	/**
	 * 
	 */
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
	private JComboBox<CategoriaAlimento> cbxCategory;
	private JComboBox<Alimento> cbxFood;
	private JSpinner spnLot;
	private JLabel lblSubtotal;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JButton btnCancel;
	private JButton btnSave;
	private JLabel lblTotalFood;

	/**
	 * Create the panel.
	 */
	public Food() {
		setLayout(new BorderLayout(0, 0));
		pnlComponentsReservation();
		pnlComponentsFoodManagement();
		pnlComponentsResult();

	}

	public void pnlComponentsReservation() {
		JPanel pnlDataReservation = new JPanel();
		pnlDataReservation.setPreferredSize(new Dimension(250, 10));
		add(pnlDataReservation, BorderLayout.WEST);
		pnlDataReservation.setBorder(BorderFactory.createTitledBorder("Datos de la Reservación"));

		pnlDataReservation.setPreferredSize(new Dimension(270, 10));
		add(pnlDataReservation, BorderLayout.WEST);
		pnlDataReservation.setLayout(null);

		JLabel lblIdT = new JLabel("ID:");
		lblIdT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdT.setBounds(10, 30, 24, 14);
		pnlDataReservation.add(lblIdT);

		JLabel lblEntryT = new JLabel("Fecha de Entrada:");
		lblEntryT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEntryT.setBounds(10, 156, 100, 14);
		pnlDataReservation.add(lblEntryT);

		JLabel lblClientT = new JLabel("Cliente:");
		lblClientT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClientT.setBounds(10, 56, 46, 14);
		pnlDataReservation.add(lblClientT);

		JLabel lblrateT = new JLabel("Tarifa por persona por Noche:");
		lblrateT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblrateT.setBounds(10, 131, 166, 14);
		pnlDataReservation.add(lblrateT);

		JLabel lblroomT = new JLabel("Habitaci\u00F3n:");
		lblroomT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblroomT.setBounds(10, 81, 63, 14);
		pnlDataReservation.add(lblroomT);

		JLabel lblCapacityT = new JLabel("Capacidad M\u00E1xima:");
		lblCapacityT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCapacityT.setBounds(10, 106, 115, 14);
		pnlDataReservation.add(lblCapacityT);

		JLabel lblExitT = new JLabel("Fecha de Salida:");
		lblExitT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExitT.setBounds(10, 181, 100, 14);
		pnlDataReservation.add(lblExitT);

		lblId = new JLabel("");
		lblId.setBounds(44, 30, 81, 14);
		pnlDataReservation.add(lblId);

		lblClient = new JLabel("");
		lblClient.setBounds(64, 56, 112, 14);
		pnlDataReservation.add(lblClient);

		lblRoom = new JLabel("");
		lblRoom.setBounds(83, 81, 115, 14);
		pnlDataReservation.add(lblRoom);

		lblCapacity = new JLabel("");
		lblCapacity.setBounds(130, 106, 89, 14);
		pnlDataReservation.add(lblCapacity);

		lblRate = new JLabel("");
		lblRate.setBounds(186, 131, 74, 14);
		pnlDataReservation.add(lblRate);

		lblEntry = new JLabel("");
		lblEntry.setBounds(120, 156, 140, 14);
		pnlDataReservation.add(lblEntry);

		lblExit = new JLabel("");
		lblExit.setBounds(118, 181, 142, 14);
		pnlDataReservation.add(lblExit);
	}
	
	public void pnlComponentsFoodManagement() {
		JPanel pnlFoodManagement = new JPanel();
		add(pnlFoodManagement, BorderLayout.CENTER);
		pnlFoodManagement.setBorder(BorderFactory.createTitledBorder("Gestionar Alimentos"));
		pnlFoodManagement.setLayout(new BorderLayout(0, 0));
		
		JPanel pnl = new JPanel();
		pnl.setPreferredSize(new Dimension(10, 120));
		pnlFoodManagement.add(pnl, BorderLayout.NORTH);
		pnl.setLayout(null);
		
		JLabel lblCategoryT = new JLabel("Categoria:");
		lblCategoryT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategoryT.setBounds(10, 11, 67, 14);
		pnl.add(lblCategoryT);
		
		JLabel lblFoodT = new JLabel("Alimento:");
		lblFoodT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFoodT.setBounds(10, 36, 67, 14);
		pnl.add(lblFoodT);
		
		JLabel lblLotT = new JLabel("Cantidad:");
		lblLotT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLotT.setBounds(10, 61, 53, 14);
		pnl.add(lblLotT);
		
		JLabel lblSubTotalT = new JLabel("Subtotal:");
		lblSubTotalT.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSubTotalT.setBounds(10, 86, 79, 21);
		pnl.add(lblSubTotalT);
		
		cbxCategory = new JComboBox<CategoriaAlimento>();
		cbxCategory.setBounds(87, 8, 223, 20);
		pnl.add(cbxCategory);
		
		cbxFood = new JComboBox<Alimento>();
		cbxFood.setBounds(87, 33, 223, 20);
		pnl.add(cbxFood);
		
		spnLot = new JSpinner();
		spnLot.setBounds(87, 58, 223, 20);
		pnl.add(spnLot);
		
		lblSubtotal = new JLabel("");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSubtotal.setBounds(99, 86, 110, 21);
		pnl.add(lblSubtotal);
		
		btnAdd = new JButton("Agregar");
		btnAdd.setBounds(221, 88, 89, 23);
		pnl.add(btnAdd);
		
		scrollPane = new JScrollPane();
		pnlFoodManagement.add(scrollPane, BorderLayout.CENTER);
		
		modelo = new DefaultTableModel();
		table = new JTable(modelo);
		scrollPane.setViewportView(table);
	}
	
	public void pnlComponentsResult() {
		JPanel pnlResult = new JPanel();
		pnlResult.setPreferredSize(new Dimension(10, 100));
		add(pnlResult, BorderLayout.SOUTH);
		pnlResult.setLayout(null);
		
		JLabel lblTotalFoodT = new JLabel("Total Alimentos:");
		lblTotalFoodT.setBounds(10, 33, 140, 21);
		lblTotalFoodT.setFont(new Font("Tahoma", Font.BOLD, 17));
		pnlResult.add(lblTotalFoodT);
		
		lblTotalFood = new JLabel("");
		lblTotalFood.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalFood.setBounds(160, 33, 160, 21);
		pnlResult.add(lblTotalFood);
		
		btnSave = new JButton("Guardar");
		btnSave.setBounds(382, 35, 89, 23);
		pnlResult.add(btnSave);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(500, 35, 89, 23);
		pnlResult.add(btnCancel);
	}

	public JLabel getLblId() {
		return lblId;
	}

	public void setLblId(JLabel lblId) {
		this.lblId = lblId;
	}

	public JLabel getLblCliente() {
		return lblClient;
	}

	public void setLblCliente(JLabel lblCliente) {
		this.lblClient = lblCliente;
	}

	public JLabel getLblHabitacion() {
		return lblRoom;
	}

	public void setLblHabitacion(JLabel lblHabitacion) {
		this.lblRoom = lblHabitacion;
	}

	public JLabel getLblCapMax() {
		return lblCapacity;
	}

	public void setLblCapMax(JLabel lblCapMax) {
		this.lblCapacity = lblCapMax;
	}

	public JLabel getLblTarifa() {
		return lblRate;
	}

	public void setLblTarifa(JLabel lblTarifa) {
		this.lblRate = lblTarifa;
	}

	public JLabel getLblEntrada() {
		return lblEntry;
	}

	public void setLblEntrada(JLabel lblEntrada) {
		this.lblEntry = lblEntrada;
	}

	public JLabel getLblSalida() {
		return lblExit;
	}

	public void setLblSalida(JLabel lblSalida) {
		this.lblExit = lblSalida;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JComboBox<CategoriaAlimento> getCbxCategoria() {
		return cbxCategory;
	}

	public void setCbxCategoria(JComboBox<CategoriaAlimento> cbxCategoria) {
		this.cbxCategory = cbxCategoria;
	}

	public JComboBox<Alimento> getCbxAlimento() {
		return cbxFood;
	}

	public void setCbxAlimento(JComboBox<Alimento> cbxAlimento) {
		this.cbxFood = cbxAlimento;
	}

	public JSpinner getSpinner() {
		return spnLot;
	}

	public void setSpinner(JSpinner spinner) {
		this.spnLot = spinner;
	}

	public JLabel getLblSubtotal() {
		return lblSubtotal;
	}

	public void setLblSubtotal(JLabel lblSubtotal) {
		this.lblSubtotal = lblSubtotal;
	}

	public JButton getBtnAgregar() {
		return btnAdd;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAdd = btnAgregar;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JButton getBtnCancelar() {
		return btnCancel;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancel = btnCancelar;
	}

	public JButton getBtnGuardar() {
		return btnSave;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnSave = btnGuardar;
	}

	public JLabel getLblTotalalimentos() {
		return lblTotalFood;
	}

	public void setLblTotalalimentos(JLabel lblTotalalimentos) {
		this.lblTotalFood = lblTotalalimentos;
	}
	
}
