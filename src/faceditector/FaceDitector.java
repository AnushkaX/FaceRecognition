/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faceditector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Anushka
 */
public class FaceDitector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(System.getProperty("java.library.path"));
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FaceDitector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FaceDitector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FaceDitector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FaceDitector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run(){
                new MainFrame();
            }
            
        }
        );
        
        
    }
    
}
