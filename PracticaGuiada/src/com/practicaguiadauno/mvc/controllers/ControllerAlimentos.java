package com.practicaguiadauno.mvc.controllers;

import javax.swing.JOptionPane;

import com.practicaguiadauno.mvc.model.Alimento;
import com.practicaguiadauno.mvc.model.CategoriaAlimento;
import com.practicaguiadauno.mvc.model.ListaAlimentos;
import com.practicaguiadauno.mvc.model.ListaCategoriasA;
import com.practicaguiadauno.mvc.model.ListaReservaciones;
import com.practicaguiadauno.mvc.model.Reservacion;
import com.practicaguiadauno.mvc.view.ViewPrincipal;
import com.practicaguiadauno.mvc.view.reservaciones.Alimentos;

public class ControllerAlimentos extends Functions {

	private ViewPrincipal vp;
	private ListaReservaciones model;
	private ListaCategoriasA categorias;

	public ControllerAlimentos(ViewPrincipal vp,
			ListaReservaciones model,
			ListaCategoriasA categorias) {

		this.vp = vp;
		this.model = model;
		this.categorias = categorias;
	}

	public void alimentos(int id) {

		Alimentos v = new Alimentos();

		ListaAlimentos listaTemp = new ListaAlimentos();

		Reservacion r = model.find(id);

		for (CategoriaAlimento c : categorias.getListaCategoria()) {
			v.getCbxCategoria().addItem(c);
		}

		v.getModelo().setDataVector(
				r.getListaAlimentos().getData(),
				r.getListaAlimentos().getColums()
		);

		v.getLblId().setText(String.valueOf(r.getId()));
		v.getLblCliente().setText(r.getNomCliente());
		v.getLblHabitacion().setText(r.getHabitacion().getNombre());
		v.getLblCapMax().setText(String.valueOf(r.getHabitacion().getCapacidad()));
		v.getLblTarifa().setText(String.valueOf(r.getHabitacion().getTarifa()));
		v.getLblEntrada().setText(String.valueOf(r.getFechaEntrada()));
		v.getLblSalida().setText(String.valueOf(r.getFechaSalida()));
		v.getLblTotalalimentos().setText(
				String.valueOf(r.getListaAlimentos().totalAlimentos())
		);

		v.getCbxCategoria().addActionListener(e -> {

			CategoriaAlimento categoria =
					(CategoriaAlimento) v.getCbxCategoria().getSelectedItem();

			v.getCbxAlimento().removeAllItems();

			for (Alimento a : categoria.getListaAlimentos().getListaAlimentos()) {
				v.getCbxAlimento().addItem(a);
			}
		});

		v.getBtnAgregar().addActionListener(e -> {

			Alimento alimentoSeleccionado =
					(Alimento) v.getCbxAlimento().getSelectedItem();

			int cantidad = (int) v.getSpinner().getValue();

			Alimento existente =
					r.getListaAlimentos().findByName(
							alimentoSeleccionado.getNombre()
					);

			if (existente != null) {

				existente.setCantidad(
						existente.getCantidad() + cantidad
				);

			} else {

				Alimento a = new Alimento(
						alimentoSeleccionado,
						cantidad
				);

				listaTemp.add(a);

				v.getLblSubtotal().setText(
						String.valueOf(a.getSubtotal())
				);
			}

			v.getModelo().setDataVector(
					listaTemp.getData(),
					listaTemp.getColums()
			);

			v.getSpinner().setValue(0);

			v.getLblTotalalimentos().setText(
					String.valueOf(listaTemp.totalAlimentos())
			);
		});

		v.getBtnCancelar().addActionListener(e -> {

			int idd = getSelectedID(v.getTable());

			if (idd > 0) {

				listaTemp.delete(idd);

				v.getModelo().setDataVector(
						listaTemp.getData(),
						listaTemp.getColums()
				);

				v.getLblTotalalimentos().setText(
						String.valueOf(listaTemp.totalAlimentos())
				);

			} else {
				JOptionPane.showMessageDialog(
						null,
						"Debe Seleccionar  un Registro"
				);
			}
		});

		v.getBtnGuardar().addActionListener(e -> {

			r.setListaAlimentos(listaTemp);

			JOptionPane.showMessageDialog(
					null,
					"La Lista de Alimentos Ha Sido Actualizada"
			);
		});

		vp.setContenido(v, "Hotel La Cricka de Martha - Alimentos");
	}
}