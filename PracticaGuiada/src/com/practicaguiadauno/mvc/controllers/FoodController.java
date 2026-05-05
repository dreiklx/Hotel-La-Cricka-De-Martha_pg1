package com.practicaguiadauno.mvc.controllers;

import com.practicaguiadauno.mvc.model.Food;
import com.practicaguiadauno.mvc.model.FoodCategory;
import com.practicaguiadauno.mvc.model.FoodList;
import com.practicaguiadauno.mvc.model.FoodCategoryList;
import com.practicaguiadauno.mvc.model.Reservation;
import com.practicaguiadauno.mvc.model.ReservationList;

import com.practicaguiadauno.mvc.view.ViewMajor;
import com.practicaguiadauno.mvc.view.panels.FoodView;

import com.practicaguiadauno.utils.Message;

public class FoodController extends Functions {

	private ViewMajor vp;
	private ReservationList model;
	private FoodCategoryList categories;
	private ReservationController rc;

	public FoodController(ViewMajor vp,
			ReservationList model,
			FoodCategoryList categories, ReservationController rc) {

		this.vp = vp;
		this.model = model;
		this.categories = categories;
		this.rc = rc;
	}

	public void food(int id) {
		
		try {

			com.practicaguiadauno.mvc.view.panels.FoodView v =
					new com.practicaguiadauno.mvc.view.panels.FoodView();


			Reservation r = model.find(id);
			
			if (r == null) {
				Message.error("Reservación no encontrada");
				return; // antes no se validaba esto
			}

			FoodList tempList = new FoodList();
			for (Food f  : r.getFoodList().getFoodList()) {
				tempList.add(new Food(f, f.getQuantity()));
			}
			
			for (FoodCategory c : categories.getCategoryList()) {
				v.getCbxCategoria().addItem(c);
			}

			v.getModelo().setDataVector(
					tempList.getData(),
					tempList.getColumns()
			);

			v.getLblId().setText(String.valueOf(r.getId()));
			v.getLblCliente().setText(r.getClientName());
			v.getLblHabitacion().setText(r.getRoom().getName());
			v.getLblCapMax().setText(String.valueOf(r.getRoom().getCapacity()));
			v.getLblTarifa().setText(String.valueOf(r.getRoom().getRate()));
			v.getLblEntrada().setText(String.valueOf(r.getEntryDate()));
			v.getLblSalida().setText(String.valueOf(r.getExitDate()));
			v.getLblTotalalimentos().setText(
					String.valueOf(tempList.totalFoods())
			);

			v.getCbxCategoria().addActionListener(e -> {

				try {

					FoodCategory category =
							(FoodCategory) v.getCbxCategoria().getSelectedItem();

					if (category == null) return;

					v.getCbxAlimento().removeAllItems();

					for (Food a : category.getFoodList().getFoodList()) {
						v.getCbxAlimento().addItem(a);
					}

				} catch (Exception ex) {
					Message.error("Error al cargar alimentos");
				}
			});

			v.getBtnAgregar().addActionListener(e -> {

				try {

					Food selected =
							(Food) v.getCbxAlimento().getSelectedItem();

					if (selected == null) {
						throw new Exception("Seleccione un alimento");
					}

					int quantity = (int) v.getSpinner().getValue();

					if (quantity <= 0) {
						throw new Exception("Cantidad inválida");
					}

					Food existing =
							tempList.findByName(selected.getName());

					if (existing != null) {

						existing.setQuantity(
								existing.getQuantity() + quantity
						);

					} else {

						Food f = new Food(selected, quantity);

						tempList.add(f);

						v.getLblSubtotal().setText(
								String.valueOf(f.getSubtotal())
						);
					}

					v.getModelo().setDataVector(
							tempList.getData(),
							tempList.getColumns()
					);

					v.getSpinner().setValue(0);

					v.getLblTotalalimentos().setText(
							String.valueOf(tempList.totalFoods())
					);

				} catch (Exception ex) {
					Message.error(ex.getMessage());
				}
			});

			v.getBtnEliminar().addActionListener(e -> {
				
				try {

					int idd = getSelectedID(v.getTable());

					if (idd <= 0) {
						throw new Exception("Debe seleccionar un registro");
					}

					tempList.delete(idd);

					v.getModelo().setDataVector(
							tempList.getData(),
							tempList.getColumns()
					);

					v.getLblTotalalimentos().setText(
							String.valueOf(tempList.totalFoods())
					);

				} catch (Exception ex) {
					Message.error(ex.getMessage());
				}
			});

			v.getBtnGuardar().addActionListener(e -> {

				try {

					if (tempList.getFoodList().isEmpty()) {
						throw new Exception("No hay alimentos para guardar");
					}

					r.setFoodList(tempList);

					Message.info("Lista de alimentos actualizada");

				} catch (Exception ex) {
					Message.error(ex.getMessage());
				}
			});

			v.getSpinner().addChangeListener(e -> {setSubtotal(v);});		
			v.getCbxAlimento().addActionListener(e -> {setSubtotal(v);});
			
			v.getBtnCancelar().addActionListener(e -> {
			    rc.index();
			});
			
			vp.setContenido(v, "Hotel La Cricka de Martha - Alimentos");

		} catch (Exception e) {
			Message.error("Error al cargar vista de alimentos");
		}
	}
	
	// ================= HELPERS =================
	
	private void setSubtotal(FoodView v) {
	    try {
	        Food selected = (Food) v.getCbxAlimento().getSelectedItem();
	        if (selected == null) return;

	        int quantity = (int) v.getSpinner().getValue();

	        Food temp = new Food(selected, quantity);
	        v.getLblSubtotal().setText(String.valueOf(temp.getSubtotal()));
	    } catch (Exception ex) {}
	}
	
	
	
}