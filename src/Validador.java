
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class Validador 
{
    private static Validador INSTANCE;
    
    private Validador()
    {
        
    }
    
    public static Validador getInstance()
    {
        if(INSTANCE == null)
            INSTANCE = new Validador();
        return INSTANCE;
    }

    boolean validarModulacion(ModulateSignal m) 
    {
        return m.moduladora.frecuencia * m.cantidad_frecuencias < m.portadora.frecuencia;
    }

    void mostrarErrorMsj(Component parent ,String error) {
       JOptionPane.showMessageDialog(parent, error, "ERROR 404",  JOptionPane.ERROR_MESSAGE);
    }
}
