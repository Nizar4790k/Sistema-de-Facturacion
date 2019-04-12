/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import modelo.ManipulaBD;
import modelo.objetos.Cliente;
import modelo.objetos.Factura;
import modelo.objetos.Producto;
import modelo.objetos.ProductoFacturado;
import vista.VentanaEmergente;
import vista.factura.FacturaForm;

/**
 *
 * @author Nizar
 */
public class AccionQueryFactura implements ActionListener {

	FacturaForm form ;
	Factura factura;
	
	public AccionQueryFactura(FacturaForm form) {
		
		this.form = form;
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		
		
		
		if(form.getRadCrearFactura().isSelected()) {
			
			
			
			
			if (form.getTxtIdCliente().getText().equals("")) {
				
				VentanaEmergente.errorEmergente("Asegurese de que no haya campos vacios");
					
				return;
				
			}
			
			int id = 0;
			
			try {
				
				 id = Integer.parseInt(form.getTxtIdCliente().getText());
			
			} catch(NumberFormatException e) {
				
				VentanaEmergente.errorEmergente("Solo se admiten caracteres numericos ");
				return;
			}
			
			
			Cliente cliente = ManipulaBD.getObject(id, Cliente.class);
			
			if(cliente==null) {
				VentanaEmergente.errorEmergente("Cliente no encontrado");
				return ;
			}
			
			
			form.getTxtNombreCliente().setText(cliente.getNombre() + " " + cliente.getApellido());		
			
			VentanaEmergente.exito("Cliente cargado con exito");
			form.activarComponentes(true);
			form.getBtnImprimirFactura().setText("Imprimir Factura");
		
		
		
			
		} else if(form.getRadConsultarFactura().isSelected()) {
			
			consultarFactura();
		
				
			
			
		}else if(form.getRadEliminarFactura().isSelected()) {
			consultarFactura();
			form.getBtnImprimirFactura().setText("Eliminar Factura");
			form.getBtnImprimirFactura().setEnabled(true);
			
			
			
		}		
	
		
		
		
		
	}
		



	public void consultarFactura() {
		Cliente cliente;
		
		List<ProductoFacturado> listaProductosFacturados2 = null;
		if (form.getTxtIdFactura().getText().equals("")) {
			
			VentanaEmergente.errorEmergente("Asegurese de que no haya campos vacios");
				
			return;
			
		}
		
		
		
		int idFactura = 0;
		
		try {
			
			 idFactura = Integer.parseInt(form.getTxtIdFactura().getText());
		
		} catch(NumberFormatException e) {
			
			VentanaEmergente.errorEmergente("Solo se admiten caracteres numericos ");
			return;
		}
		
		
		
			factura = ManipulaBD.getObject(idFactura, Factura.class);
			
			if(factura==null) {
				VentanaEmergente.errorEmergente("Factura no encontrada");
				return;
				
			}
			
			
			cliente = ManipulaBD.getObject(factura.getIdCliente(), Cliente.class);
			
			form.getTxtNombreCliente().setText(cliente.getNombre() + " " + cliente.getApellido());			
			form.getTxtFechaYhora().setText(factura.getFecha() + " " + factura.getHora());
			form.getTxtIdCliente().setText(String.valueOf(cliente.getId()));
		
		
			try {
				List<ProductoFacturado> listaProductosFacturados = ManipulaBD.consultarObjeto(ProductoFacturado.class);
				
				 listaProductosFacturados2=new LinkedList<>();
				
			
				DefaultTableModel model =  new DefaultTableModel();
				

			     List<String> columnas = (List) ManipulaBD.getColumnNames("productos_facturados");
					
					for(String col : columnas) {
						if(col.equals("id_factura")  || col.equals("indice")) {
							continue;
						}
						model.addColumn(col);
				
					
					}
				
				
				for(ProductoFacturado prod: listaProductosFacturados) {
					
					if(prod.getIdFactura()==factura.getId()) {
						listaProductosFacturados2.add(prod);
					
						Object [] obj = {prod.getIndiceFactura(),prod.getPrecio(),prod.getDescripcion(),prod.getTasaItbis(),prod.getIdProducto(),prod.getCantidadFacturada()};
						
						model.addRow(obj);
						
						
					// Me quede aqui.
					
					}
				
					
				}
			
				form.getTxtSubTotal().setText(String.valueOf(factura.getSubTotal()));
				form.getTxtTotalItbis().setText(String.valueOf(factura.getTotalItbis()));
				form.getTxtTotalPagar().setText(String.valueOf(factura.getTotalApagar()));
				
				
				form.getTblProductos().setModel(model);
				
				
				
				
				
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
		







	












}
