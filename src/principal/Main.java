/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JFrame;

import modelo.ManipulaBD;
import vista.*;

/**
 *
 * @author Nizar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    MenuPrincipal miMenu = new MenuPrincipal();
    
    ManipulaBD.getConnection();
    
   
    
    }
    
}
