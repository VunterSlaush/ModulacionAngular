
import java.util.HashMap;

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
    private final double m; // Indice De Modulacion
    private final double B;// B es Ancho de banda!
    private HashMap<Integer, Double> frecuenciasLaterales;
    private int cantidad_frecuencias;
    
    public ModulateSignal(Signal p, Signal mod, double m, int type)
    {   
        portadora = p;
        moduladora = mod;
        this.m = m;
        this.k = generarSensibilidad();
        modulationType = type;
        B = generarAnchoDeBanda();
        ejecutarBessel();
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
       double moduladoraResultado = (double) m * moduladora.evaluarIntegrado(t);
       double fase = portadora.fase;
       portadora.fase = moduladoraResultado;
       double value = portadora.evaluate(t);
       portadora.fase = fase;
       return value;
    }

    private double evualarPM(double t) {
       double moduladoraResultado = (double)m*moduladora.evaluate(t);
       double fase = portadora.fase;
       portadora.fase = moduladoraResultado;
       double value = portadora.evaluate(t);
       portadora.fase = fase;
       return value;
    }
    
    public DemodulateSignal demodulada()
    {
        return new DemodulateSignal(this);
    }
    
    public double evaluateDemodulate(double t)
    {
        return (double) evaluate(t)/moduladora.evaluate(t);
    }

    @Override
    public String toString() {
        return "ModulateSignal{" + "k=" + k + ", portadora=" + portadora + ", moduladora=" + moduladora + ", modulationType=" + modulationType + ", m=" + m + ", B=" + B + ", frecuenciasLaterales=" + frecuenciasLaterales + ", cantidad_frecuencias=" + cantidad_frecuencias + '}';
    }
   




    @Override
    public String getTipo() {
        if(modulationType == FM)
            return "Modulacion FM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
        else
            return "Modulacion PM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
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

    private double generarSensibilidad() 
    {
        if(modulationType == FM)
            return (double)(m*Signal.pi2*moduladora.frecuencia)/moduladora.amplitud ;
        else
            return (double) m/moduladora.amplitud;
    }

    private double generarAnchoDeBandaPM() {
       return (double) 2*m*moduladora.frecuencia + 2*moduladora.frecuencia;
    }

    private void ejecutarBessel() 
    {
       cantidad_frecuencias = 0;
       double calculo_bessel = 0.0;
       frecuenciasLaterales = new HashMap<>();
       do
       {
           calculo_bessel = Calculador.getInstance().besselAt(cantidad_frecuencias,m);
           if(calculo_bessel > 0.01 || calculo_bessel<-0.01)
           {
               frecuenciasLaterales.put(cantidad_frecuencias, redondear(calculo_bessel));
               cantidad_frecuencias++;
           }
       }while(calculo_bessel > 0.01 || calculo_bessel<-0.01);
    }

    HashMap<Integer, Double> getSpectro() {
        return frecuenciasLaterales;
    }

    private Double redondear(double a) {
        return Math.round(a * 100.0) / 100.0;
    }
    
    
    
}
