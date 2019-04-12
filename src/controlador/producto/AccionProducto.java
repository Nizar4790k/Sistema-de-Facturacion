/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import modelo.ManipulaBD;
import modelo.objetos.Producto;
import vista.MenuPrincipal;
import vista.VentanaEmergente;
import vista.producto.ProductoForm;


/**
 *
 * @author Nizar
 */
public class AccionProducto  implements ActionListener {

	private ProductoForm form;
	
	
	
	public AccionProducto(ProductoForm form) {
		
		this.form = form;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int cantidad = 0;
		double tasaItbis = 0;
		double precio = 0;
		
		String descripcion = form.getTxtNombre().getText();
		
		
		
		
		Producto producto;
		
		if (form.getRadCrear().isSelected())
		{
			
		
			
				if (form.camposTextoVacios()) { // validando que los campos no esten vacios
					
					return;
			}
			
			
			
			try 
			{
			 cantidad  = (int) form.getSpnCantidad().getValue();
			 tasaItbis = Double.parseDouble(form.getTxtTasaITBIS().getText());
			 precio = Double.parseDouble(form.getTxtPrecio().getText());  // recogiendo los datos desde los campos de texto
			}catch(NumberFormatException ex) {
				
				VentanaEmergente.errorEmergente("Ha ingresado un caracter no valido en un campo numerico");
				return;
			}
		
		
			producto= new Producto(descripcion,precio,tasaItbis,cantidad);
			
			form.vaciarTxt();     // Vaciando los campos de texto
			
		
		try 
		{
			ManipulaBD.guardarObjeto(producto);
			VentanaEmergente.exito("Producto creado con exito"); // ventana emergente indicando el exito de la operacion
			form.rellenarTablaConsulta();
			
			
		}	 catch (Exception e) {
			// TODO Auto-generated catch block
		
			VentanaEmergente.errorEmergente("Error al guardar producto!");
			return;
			
		
	
		} 
			 
			
			
		} 
		
		else if (form.getRadActualizar().isSelected()) 
		{
		
			int filaSeleccionadaContador = form.getjTable1().getSelectedRowCount();
			System.out.println(filaSeleccionadaContador);
			
			
			if(filaSeleccionadaContador!=1) {
				
				VentanaEmergente.errorEmergente("Usted no ha seleccionado ninguna fila o a seleccionado mas de una fila ");
				
				return;
				
			}
			
			
			
			if (form.camposTextoVacios())
			{ // validando que los campos no esten vacios
				return;
			}
			
			
			try 
			{
			 cantidad  = (int) form.getSpnCantidad().getValue();
			 tasaItbis = Double.parseDouble(form.getTxtTasaITBIS().getText());
			 precio = Double.parseDouble(form.getTxtPrecio().getText());  // recogiendo los datos desde los campos de texto
			}catch(NumberFormatException ex) {
				
				VentanaEmergente.errorEmergente("Ha ingresado un caracter no valido en un campo numerico");
				return;
			}
			
			
			
			
			int selectedRow = form.getjTable1().getSelectedRow();   // Obteniendo la fila seleccionada
			int id = (int) form.getjTable1().getModel().getValueAt(selectedRow, 0); //
			
			producto = ManipulaBD.<Producto>getObject(id, Producto.class);
			 
			producto.setDescripcion(descripcion);
			producto.setCantidad(cantidad);
			producto.setPrecio(precio);
			producto.setTasaItbis(tasaItbis);
			 
			 try 
			 {
				ManipulaBD.actualizarObjeto(producto);
				VentanaEmergente.exito("Producto actualizado con exito");
				form.rellenarTablaConsulta();
			 } 
			 
			 catch(SQLException ex) 
			 {
		
				ex.printStackTrace();
			 }
			
			
			
		} 

		else if (form.getRadEliminar().isSelected())
		{
			form.vaciarTxt();
			
			if(form.getjTable1().getSelectedRowCount()==0) 
			{
				VentanaEmergente.errorEmergente("Usted no ha seleccionado ninguna fila");  // Comprobando si no hay fila seleccionadas
				
				return;
				
			}
			
			
			int [] idEliminados = form.getSelectedId();
			
			
			for(int id : idEliminados)    
			{
				try 
				{
					ManipulaBD.<Producto>borrarObjeto(id, Producto.class); // Eliminando todos los elementos seleccionados en la tabla
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
			VentanaEmergente.exito("Producto(s) eliminado(s) con exito");
			form.rellenarTablaConsulta();
			
			
			
			
			
			
		} else if (form.getRadConsultar().isSelected()) 
		{
			form.vaciarTxt();
			form.rellenarTablaConsulta();
			VentanaEmergente.exito("Consulta realizada con exito");
		
			
		}

		
		
	}
    
			
	}
	
	
	
		
	



	



	
	
	
	

