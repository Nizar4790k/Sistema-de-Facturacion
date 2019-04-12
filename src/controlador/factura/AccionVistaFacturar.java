package controlador.factura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import vista.factura.FacturaForm;

public class AccionVistaFacturar implements ActionListener {

	
	FacturaForm form;
	
	public AccionVistaFacturar(FacturaForm form) {
		
		this.form = form;
		
	
	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{

	
		JRadioButton botonPulsado =  (JRadioButton)(e.getSource());

		if(botonPulsado==form.getRadAgregar() || form.getRadEliminar()==botonPulsado) {
		
		if(form.getRadAgregar().isSelected()) {
		
			
		activarComponentes(true);
		
		
		}else  if(form.getRadEliminar().isSelected()) {
			
			activarComponentes(false);
			form.getBtnFacturar().setEnabled(true);
		
		}
			
		} else if(botonPulsado==form.getRadConsultarFactura()|| botonPulsado==form.getRadActualizarFactura()|| botonPulsado==form.getRadEliminarFactura()) {
			form.vaciarComponentes();
			
			if(botonPulsado==form.getRadConsultarFactura()) {
				form.activarComponentes(false);
			
			
			}
			
			
			form.getTxtIdCliente().setEditable(false);
			form.getTxtIdFactura().setEditable(true);
			
		}else {
			form.vaciarComponentes();
			form.getTxtIdCliente().setEditable(true);
			form.getTxtIdFactura().setEditable(false);
		}
		
		
		
		
		
		
		}

	
	private void activarComponentes(boolean value ) {
		
		form.getTxtCodigoArticulo().setEnabled(value);
		form.getSpnCantidadAFacturar().setEnabled(value);
		form.getBtnFacturar().setEnabled(value);
	
		
	}
	
	
	
}
