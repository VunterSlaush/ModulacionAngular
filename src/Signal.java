/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.Math.*;
/**
 * Esta es la clase que tendra la evaluacion de las señales!
 * @author Jmota 
 * 
 */
public class Signal implements IEvaluableEnTiempo
{
   static public String SAWTOOTH = "Diente sierra";
   static public String TRIANGULAR = "Triangular";
   static public String SQUARE = "Cuadrada";
   static public String SIN = "Senoidal";
   static public String COS = "Cosenoidal"; 
   
   
   
   public static final double pi2 = Math.PI * 2;
   private static final double RUIDO_MAXIMO = 50.0;
   private static final int CIFRAS_SIGNIFICATIVAS = 1000000;//Cada 0 es 1 cifra
   double amplitud; 
   double frecuencia;
   double fase;
   boolean ruido; 
   String tipo;
   

    public Signal(double frecuencia,double amplitud, double fase, boolean ruido, String tipo) 
    {
        this.amplitud = amplitud;
        this.frecuencia = frecuencia;
        this.fase = fase;
        this.ruido = ruido;
        this.tipo = tipo;
    }
  
    public double getAmplitud() {
        return amplitud;
    }

    public void setAmplitud(double amplitud) {
        this.amplitud = amplitud;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public double getFase() {
        return fase;
    }

    public void setFase(double fase) {
        this.fase = fase;
    }

    public boolean isRuido() {
        return ruido;
    }

    @Override
    public String toString() {
        return "Signal{" + "amplitud=" + amplitud + ", frecuencia=" + frecuencia + ", fase=" + fase + ", ruido=" + ruido + ", tipo=" + tipo + '}';
    }

    public void setRuido(boolean ruido) {
        this.ruido = ruido;
    }

   @Override
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
   @Override
    public double evaluate(double t)
    {
        double value = t*frecuencia*pi2 + fase;
        if(tipo.equals(SAWTOOTH))
                value = sawTooth(value);
        if(tipo.equals(SQUARE))
                value = square(value);
        if(tipo.equals(TRIANGULAR))
                value = triangle(value);
        if(tipo.equals(SIN))
                value = Math.sin(Math.toRadians(value));//TODO ver si quitar o no el 2 
        if(tipo.equals(COS))
                value = Math.cos(Math.toRadians(value)); // TODO ver si quitar o no el 2 
        
        value*=amplitud;
        
        if(ruido)
            value+= Math.random() % RUIDO_MAXIMO;
        
        return Math.floor(value * CIFRAS_SIGNIFICATIVAS) / CIFRAS_SIGNIFICATIVAS;//Truncamos 
        //return value;
    }
    
    public double evaluarIntegrado(double t)
    {   
        double value = (double) t*frecuencia*pi2;
        if(tipo.equals(SIN))
                value = Math.cos(Math.toRadians(value));
        if(tipo.equals(COS))
                value = Math.sin(Math.toRadians(value));
        
        if(ruido)
            value+= Math.random() % RUIDO_MAXIMO;
        return value;
    }
    
   public static double sawTooth(double n)
   {   /*
       double tn;
       tn = ceil((n+Math.PI)/(2*Math.PI));
       return ((n - tn*2*Math.PI) + 2*Math.PI)/Math.PI;*/
       //System.out.println(fractPart(n));
       return fractPart((double)n/(4*Math.PI));
   }
   
   private static double triangle(double x)
   {
       
      return (2/Math.PI)*(Math.asin(Math.sin(Math.toRadians(Math.PI*x))));
      //return  1 - Math.abs( 1 - x % 2);
   }
   
   private static double square(double x)
   {
       double s = Math.sin(x);
       if(s>=0)
           return 1;
       else
           return 0;
   }
   
   private static double fractPart(double n)
   {
     if (n > 0) {
        return n - Math.floor(n);
    } else {
        return ((n - Math.ceil(n)) * -1);
    }
   }

   
}
