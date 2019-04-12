package vista;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class VentanaEmergente {

	
	public  static void exito(String mensaje) 
	    { // Ventana de emergente de error
	    	
	   	 JOptionPane.showMessageDialog(null, mensaje, "Enhorabuena!", JOptionPane.OK_OPTION, new ImageIcon("vista\\cliente\\Imagenes\\checkIcon.png"));
	    }
	
	  
	public static void errorEmergente(String mensaje) 
	    { // Ventana emergente de error
	   	JOptionPane.showMessageDialog(null , mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
}
