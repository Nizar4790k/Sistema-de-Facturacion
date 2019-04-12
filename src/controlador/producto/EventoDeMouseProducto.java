package controlador.producto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo.ManipulaBD;
import modelo.objetos.Cliente;
import vista.cliente.ClienteForm;
import vista.producto.ProductoForm;

public class EventoDeMouseProducto implements MouseListener {

	ProductoForm form ;
	
	
	public EventoDeMouseProducto(ProductoForm form) {
		this.form = form;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		
		if(form.getRadActualizar().isSelected())
		{
			if(form.getjTable1().getSelectedRowCount()!=1) 
			{
				form.txtActivacion(false);
			
				return;
			
			}else 
			{
				form.txtActivacion(true);
				form.rellenarCamposProducto();
			}
			
		}
		
	}
		
	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
