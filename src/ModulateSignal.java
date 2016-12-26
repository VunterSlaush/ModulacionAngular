/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class ModulateSignal implements IEvaluableEnTiempo
{   
    private static final int FM = 0;
    private static final int PM = 1;
    private final double k;// K es el Simbolo de Sensiblidad a La Desviacion/Modulacion !
    private final Signal portadora;
    private final Signal moduladora;
    private final int modulationType;
    private final double m;
    private final double B;// B es Ancho de banda!
    public ModulateSignal(Signal p, Signal mod, double k, int type)
    {   
        portadora = p;
        moduladora = mod;
        this.k = generarSensibilidad(k);
        modulationType = type;
        this.m = generarIndiceModulacion();
        B = generarAnchoDeBanda();
    }
    
    @Override
    public double evaluate(double t)
    {
        if(modulationType == FM)
            return evaluarFM(t);
        else if(modulationType == PM)
            return evualarPM(t);
        else
            return -1.0;
    }

    private double evaluarFM(double t) 
    {
       double moduladoraResultado = m*moduladora.evaluarIntegrado(t);
       double fase = portadora.fase;
       portadora.fase = moduladoraResultado;
       double value = portadora.evaluate(t);
       portadora.fase = fase;
       return value;
    }

    private double evualarPM(double t) {
       double moduladoraResultado = k*moduladora.evaluate(t);
       double fase = portadora.fase;
       portadora.fase = moduladoraResultado;
       double value = portadora.evaluate(t);
       portadora.fase = fase;
       return value;
    }

    @Override
    public String toString() {
        return "ModulateSignal{" + "k=" + k + ", portadora=" + portadora + ", moduladora=" + moduladora + ", modulationType=" + modulationType + ", m=" + m + ", B=" + B + '}';
    }




    @Override
    public String getTipo() {
        if(modulationType == FM)
            return "Modulacion FM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
        else
            return "Modulacion PM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
    }

    private double calcularIndiceModulacion() 
    {   
        //Este Valor puede cambiar dependiendo del tipo de unidad de K! 
        if(modulationType == FM)
            return (k*moduladora.amplitud)/(moduladora.frecuencia);
        else
            return k*moduladora.amplitud;
    }

    private double generarIndiceModulacion() 
    {
        if(modulationType == FM)//Este valor puede cambiar dependiendo del tipo de unidad de K!
            return (moduladora.amplitud * k) /(moduladora.frecuencia);
        else
            return (moduladora.amplitud * k);
    }
    
    private double generarAnchoDeBanda()
    {
        if(modulationType == FM)
            return generarAnchoDeBandaFM();
        return generarAnchoDeBandaPM();
    }
    
    /**Ancho de BANDA FM segun Regla de Carson!
    *  Segun Carson ancho de banda = 2 * b * frecuencia moduladora
    *  b = N(b) + a 
    *  a = 2 si b > 1 y b < 5
    *  a = 1 si b >= 5 y b<= 20
    *  a = 0 si b>20
    *  si b < 1
    *  ancho de banda = 2 * frecuencia moduladora
    *  lo que es igual a 2 * b(b = 1)*frecuencia moduladora
    */ 
    private double generarAnchoDeBandaFM()
    {   
        
        int b = (int)m;
        if(b>1 && b<5)
            b +=2;
        else if(b>=5 && b<=20)
            b+=1;
        else if(b < 1)
            b = 1;
                 
        return (double)2*b*moduladora.frecuencia;//Hz!
    }

    private double generarSensibilidad(double k) {
        if(modulationType == FM)
            return k * 1000;//Convertimos a KHZ!
        else
            return k;
    }

    private double generarAnchoDeBandaPM() {
       return (double) 2*m*moduladora.frecuencia + 2*moduladora.frecuencia;
    }
    
}
