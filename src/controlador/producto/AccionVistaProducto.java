package controlador.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.cliente.ClienteForm;
import vista.producto.ProductoForm;

public class AccionVistaProducto implements ActionListener {

	ProductoForm form ;
	
	public AccionVistaProducto(ProductoForm form)
	{
		this.form = form;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(form.getRadConsultar().isSelected() || form.getRadEliminar().isSelected() ||  form.getRadActualizar().isSelected() ) 
		{
				
			form.txtActivacion(false);
			form.vaciarTxt();
			
			
			if(form.getRadActualizar().isSelected()){
				if(form.getjTable1().getSelectedRowCount()!=1) 
				{
					form.txtActivacion(false);
					return;
					
				}else {
					
					form.txtActivacion(true);
					form.rellenarCamposProducto();;
					
					
					}
				
				}
		
			
		} else if(form.getRadCrear().isSelected()) 
		
		{
			form.txtActivacion(true);
			form.vaciarTxt();
		
		
		
		
		
		
		}
		
		
	}
	
		
	}


