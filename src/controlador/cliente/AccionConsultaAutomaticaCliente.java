package controlador.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import vista.cliente.ClienteForm;

public class AccionConsultaAutomaticaCliente implements ActionListener {

	ClienteForm form;
	
	public AccionConsultaAutomaticaCliente(ClienteForm form) {
		this.form = form;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	
		
			if(form.getRadConsultar().isSelected()) {
				form.getBtnDale().setEnabled(false);
			}else {
				
				form.getBtnDale().setEnabled(true);
			}
			
			form.rellenarTablaConsulta();
		
	
		
	}

}
