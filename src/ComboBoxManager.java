
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class ComboBoxManager 
{   
    private static ComboBoxManager instance;
    private ComboBoxManager()
    {}
    
    public static ComboBoxManager getInstance()
    {
    	if (instance == null) 
    		instance = new ComboBoxManager();
    	
    	return instance;
    }

    public void initFrequencyBox(JComboBox fBox)
    {
    	String [] unidades = {"MHz","KHz","Hz"}; 
    	initBox(fBox,unidades);
    }

    public void initPhaseBox(JComboBox fBox)
    {

    }

    public void initAmplitudBox(JComboBox fBox)
    {
    	String [] unidades = {"GV","MV","KV","V","mV","µV"};
    	initBox(fBox,unidades); 
    }

    public void initTimeBox(JComboBox fBox)
    {
    	String [] unidades = {"ms","10^-2s","10^-3s","10^-4s","10^-5s","µs","10^-7s","10^-8s","10^-9s"};
    	initBox(fBox,unidades); 
    }


    public void initSignalFunctionBox(JComboBox jBox)
    {
    	String [] unidades = {Signal.SIN, Signal.COS, Signal.SAWTOOTH, Signal.TRIANGULAR};
    	initBox(jBox,unidades); 
    }	

    public void initModulationTypeBox(JComboBox mBox)
    {
    	String [] unidades = {"Modulacion de Frecuencia(FM)","Modulacion de Fase(PM)"};
    	initBox(mBox,unidades); 
    }

    private void initBox(JComboBox fBox, String[] unidades) 
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel(unidades);
        fBox.setModel(model);
    }


}
