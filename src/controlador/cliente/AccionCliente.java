/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.exception.ConstraintViolationException;

import modelo.ManipulaBD;
import modelo.objetos.Cliente;
import vista.MenuPrincipal;
import vista.cliente.ClienteForm;

/**
 *
 * @author Nizar
 */
public class AccionCliente extends WindowAdapter implements ActionListener {

	private ClienteForm form;
	
	
	
	public AccionCliente (ClienteForm form) {
		
		this.form = form;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String nombre = form.getTxtNombre().getText();
		String apellido = form.getTxtApellidos().getText();  // recogiendo los datos desde los campos de texto
		String telefono = form.getTxtTelefono().getText();
		String correo = form.getTxtCorreo().getText();
		Cliente cliente;
		
		if (form.getRadCrear().isSelected())
		{
		
			if (form.camposTextoVacios()) { // validando que los campos no esten vacios
				
				return;
			}
		
			cliente = new Cliente(nombre,apellido,telefono,correo);
			
			form.vaciarTxt();     // Vaciando los campos de texto
			
		
		try 
		{
			ManipulaBD.guardarObjeto(cliente);
			form.exito("Cliente creado con exito"); // ventana emergente indicando el exito de la operacion
			form.rellenarTablaConsulta();
			
			
		}	 catch (Exception e) {
			// TODO Auto-generated catch block
		
			form.errorEmergente("Este correo ya existe!");
			return;
			
		
	
		} 
			 
			
			
		} 
		
		else if (form.getRadActualizar().isSelected()) 
		{
		
			if (form.camposTextoVacios())
			{ // validando que los campos no esten vacios
				return;
			}
		
			
			if(form.getjTable1().getSelectedRowCount()!=1) {
				
				form.errorEmergente("Usted no ha seleccionado ninguna fila o a seleccionado mas de una fila ");;
				
				return;
				
			}
			
			int selectedRow = form.getjTable1().getSelectedRow();   // Obteniendo la fila seleccionada
			int id = (int) form.getjTable1().getModel().getValueAt(selectedRow, 0); //
			
			cliente = ManipulaBD.<Cliente>getObject(id, Cliente.class);
			 
			cliente.setTelefono(telefono);
			cliente.setApellido(apellido);
			cliente.setEmail(correo);
			cliente.setNombre(nombre);
			 
			 try 
			 {
				ManipulaBD.actualizarObjeto(cliente);
				form.exito("Cliente actualizado con exito");
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
				form.errorEmergente("Usted no ha seleccionado ninguna fila");  // Comprobando si no hay fila seleccionadas
				
				return;
				
			}
			
			
			int [] idEliminados = form.getSelectedId();
			
			
			for(int id : idEliminados)    
			{
				try 
				{
					ManipulaBD.<Cliente>borrarObjeto(id, Cliente.class); // Eliminando todos los elementos seleccionados en la tabla
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
			form.exito("Cliente(s) eliminado(s) con exito");
			form.rellenarTablaConsulta();
			
			
			
			
			
			// hola como estas ? yeaaaah
		} else if (form.getRadConsultar().isSelected()) 
		{
			form.vaciarTxt();
			form.rellenarTablaConsulta();
			form.exito("Consulta realizada con exito");
		
			
		}

		
		
	}
    
	@Override
	public void windowClosing(WindowEvent e)  // Al cerrar con la x que vuelva al menu principal
	{
		
		form.dispose();  
		
		
		// Evento al cerrar
		new MenuPrincipal().setVisible(true);;
		
		
		
	}
	
	
	
		
	}



	



	
	
	
	

