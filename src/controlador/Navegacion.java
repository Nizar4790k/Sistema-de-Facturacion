
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vista.MenuPrincipal;


public class Navegacion implements ActionListener {

     private JFrame frame;
        
     public Navegacion(JFrame frame){
         
         this.frame = frame;
         
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
       frame.dispose();
       
       MenuPrincipal miMenu = new MenuPrincipal();
      
       
        
        
    }
    
}
