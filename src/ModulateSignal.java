
import java.util.HashMap;
import java.util.Map;

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
    public final Signal portadora;
    public final Signal moduladora;
    private final int modulationType;
    public final double m; // Indice De Modulacion
    private final double B;// B es Ancho de banda CARSON
    private final double B2;// ancho de banda Bessele!
    private HashMap<Integer, Double> frecuenciasLaterales;
    public int cantidad_frecuencias;
    
    public ModulateSignal(Signal p, Signal mod, double m, int type)
    {   
        portadora = p;
        moduladora = mod;
        this.m = m;
        modulationType = type;
        this.k = generarSensibilidad();
        B = generarAnchoDeBanda();
        ejecutarBessel();
        B2 = generarAnchoDeBandaBessel();
    }
    
    public ModulateSignal(Signal p, Signal mod, double k, int type,int unused)
    {   
        portadora = p;
        moduladora = mod;
        modulationType = type;
        this.k = k;
        this.m = generarIndice();
        B = generarAnchoDeBanda();
        ejecutarBessel();
        B2 = generarAnchoDeBandaBessel();
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
       double value = portadora.evaluateSinRuido(t);
       portadora.fase = fase;
       return value;
    }

    private double evualarPM(double t) {
       double moduladoraResultado = (double)k*moduladora.evaluate(t);
       double fase = portadora.fase;
       portadora.fase = moduladoraResultado;
       double value = portadora.evaluateSinRuido(t);
       portadora.fase = fase;
       return value;
    }
    
    public DemodulateSignal demodulada()
    {
        return new DemodulateSignal(this);
    }
    
    /**TODO add filters to Demodulacion!
    **/
    public double evaluateDemodulate(double t)
    {
        return (double) moduladora.evaluateSinRuido(t);
    }

    @Override
    public String toString() 
    {   
        String mUnidad;
        if(this.modulationType == FM)
            mUnidad = " (adimensional)";
        else
            mUnidad = " Rad";
        String retorno = "Resultados \n"
                + "Sensibilidad a la Desviacion:" + k+" hz/v \n" 
                +"Frecuencia Angular Portadora: "+Calculador.getInstance().redondear(portadora.w)+" \n"
                +"Frecuencia Angular Moduladora: "+Calculador.getInstance().redondear(moduladora.w)+"\n"
                +"Indice De Modulacion: " + Calculador.getInstance().redondear(m) +mUnidad +" \n"
                +"Ancho de banda calculado meditante Carson:" + B + " hz \n"
                +"Ancho de banda calculado meditante Bessel:" + B2 + " hz \n"
                +"Cantidad de Conjunto de Frecuencias Laterales Significativas: " + cantidad_frecuencias + '\n'
                + "Desviación de frecuencia (∆f): "+
                Calculador.getInstance().redondear(k*moduladora.amplitud)+" hz \n"
                +"Amplitudes de las Frecuencias Laterales:\n" +frecuenciasLateralesToString();
        

        return retorno;
    }
   




    @Override
    public String getTipo() {
        if(modulationType == FM)
            return "Modulación  FM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
        else
            return "Modulación  PM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
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
    
    private double generarIndice()
    {
        if(modulationType == FM)
            return (double)(k*moduladora.amplitud)/(moduladora.frecuencia*Signal.pi2) ;
        else
            return (double) k*moduladora.amplitud;
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
               frecuenciasLaterales.put(cantidad_frecuencias, Calculador.getInstance().redondear(calculo_bessel* portadora.amplitud));
               cantidad_frecuencias++;
           }
       }while(calculo_bessel > 0.01 || calculo_bessel<-0.01);
       cantidad_frecuencias--;
    }

    HashMap<Double, Double> getSpectro() 
    {   
        HashMap<Double,Double> spectro = new HashMap<>();
        for(Map.Entry<Integer,Double> e : frecuenciasLaterales.entrySet())
        {
           if(e.getKey() == 0)
               spectro.put(portadora.frecuencia,e.getValue());
           else
           {
               double derecha = portadora.frecuencia + e.getKey()*moduladora.frecuencia;
               double izquierda = portadora.frecuencia - e.getKey()*moduladora.frecuencia;
               spectro.put(izquierda,e.getValue());
               spectro.put(derecha,e.getValue());
           }
        }
        return spectro;
    }



    private String frecuenciasLateralesToString() 
    {   
        StringBuilder string = new StringBuilder();
         for (Map.Entry<Integer,Double> map : frecuenciasLaterales.entrySet()) 
        {
            string.append("J").append(map.getKey()).append(": ").append(map.getValue()).append("V \n");
             
        }
        return string.toString();
    }
    
    private String potenciasLateralesToString() 
    {   
        
        StringBuilder string = new StringBuilder();
        double value;
        for (Map.Entry<Integer,Double> map : frecuenciasLaterales.entrySet()) 
        {
            value = map.getValue();
            string.append("P").append(map.getKey()).append(": ").append(value).append("V \n");
             
        }
        return string.toString();
    }

    private double generarAnchoDeBandaBessel() 
    {   

        return (portadora.frecuencia + cantidad_frecuencias*moduladora.frecuencia) - (portadora.frecuencia - cantidad_frecuencias*moduladora.frecuencia);
    }

    @Override
    public double unidadOptima() {
        return portadora.unidadOptima();
    }


}
