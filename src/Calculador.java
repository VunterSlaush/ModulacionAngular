/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class Calculador 
{   
    private static Calculador instance;
    private Calculador(){}
    public static Calculador getInstance()
    {
        if(instance == null)
            instance = new Calculador();
        return instance;
    }
    

}
