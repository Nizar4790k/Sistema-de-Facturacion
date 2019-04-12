package controlador.producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import vista.cliente.ClienteForm;
import vista.producto.ProductoForm;

public class AccionConsultaAutomaticaProducto  implements ActionListener{

	ProductoForm form;
	
	public AccionConsultaAutomaticaProducto(ProductoForm form) {
		this.form = form;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	
		
				if(form.getRadConsultar().isSelected()) {
			
				form.getBtnDale().setEnabled(false);
			} else {
				form.getBtnDale().setEnabled(true);
			}
			
			form.rellenarTablaConsulta();
		
		
		
	}
	
	
}
