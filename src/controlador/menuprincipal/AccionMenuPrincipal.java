/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.menuprincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import vista.MenuPrincipal;
import vista.cliente.ClienteForm;

import vista.factura.FacturaForm;
import vista.producto.ProductoForm;

/**
 *
 * @author nizar4790k
 */
public class AccionMenuPrincipal extends MouseAdapter   {

    MenuPrincipal form =null;
    
    
     public AccionMenuPrincipal(MenuPrincipal form){
       
         this.form = form;
    }
    
    
    
   
        
        
      @Override
        
         public void mouseClicked(MouseEvent e){
       
         JPanel panelPulsado = (JPanel) e.getSource();
        
       
        
        if(panelPulsado == form.getPnlClientes()){
        
           ClienteForm frame = new ClienteForm();
           frame.setVisible(true);
           
        }else if (panelPulsado == form.getPnlProductos()){
            
            ProductoForm frame = new   ProductoForm();
            form.dispose();
          
            
        } else if(panelPulsado==form.getPnlFactura()){
            
            FacturaForm frame = new FacturaForm();
        }
        
              form.dispose();
        
        
        
        
    }
        
        
    }
    

