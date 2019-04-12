package controlador.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.cliente.ClienteForm;

public class AccionVistaCliente implements ActionListener {

	ClienteForm form ;
	
	public AccionVistaCliente(ClienteForm form)
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
					form. rellenarCamposTexto();
					
					
					}
				
				}
		
			
		} else if(form.getRadCrear().isSelected()) 
		
		{
			form.txtActivacion(true);
		
		
		
		
		
		
		}
		
		
	}
	
		
	}


