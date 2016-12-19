/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta es la clase que tendra la evaluacion de las señales!
 * @author Jmota 
 * 
 */
public class Signal 
{
   static public String SAWTOOTH = "Diente sierra";
   static public String TRIANGULAR = "Triangular";
   static public String SQUARE = "Cuadrada";
   static public String SIN = "Senoidal";
   static public String COS = "Cosenoidal"; 
   
   private static double pi2 = Math.PI*2;
   private static double RUIDO_MAXIMO = 0.5;
   
   double amplitud; 
   double frecuencia;
   double fase;
   boolean ruido; 
   String tipo;
   

    public Signal(double amplitud, double fase, boolean ruido, String tipo) 
    {
        this.amplitud = amplitud;
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

    public void setRuido(boolean ruido) {
        this.ruido = ruido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double evaluar(double t)
    {
        double value = 0;
        if(tipo.equals(SAWTOOTH))
                value = sawTooth(t*frecuencia*pi2 + fase);
        if(tipo.equals(SQUARE))
                value = square(t*frecuencia*pi2 + fase);
        if(tipo.equals(TRIANGULAR))
                value = triangle(t*frecuencia*pi2 + fase);
        if(tipo.equals(SIN))
                value = Math.sin(t*frecuencia*pi2 + fase);
        if(tipo.equals(COS))
                value = Math.cos(t*frecuencia*pi2 + fase);
        
        value*=amplitud;
        
        if(ruido)
            value+= Math.random()%RUIDO_MAXIMO;
        return value;
    }
    
    public double evaluarIntegrado(double t)
    {
         if(tipo.equals(SIN))
                return amplitud*Math.cos(t*frecuencia*pi2 + fase);
        if(tipo.equals(COS))
                return amplitud*Math.sin(t*frecuencia*pi2 + fase);
        return 0;
    }
    
   private static double sawTooth(double n)
   {   
       
       double tn;

       tn = ceil((n+Math.PI)/(2*Math.PI));
           //System.out.println(tn);
       return ((n - tn*2*Math.PI) + 2*Math.PI)/Math.PI;
           //System.out.println(n[1][i]);
       
   }
   
   private static double triangle(double x)
   {
      return Math.abs( 1 - x % (2*1) );
   }
   
   private static double square(double x)
   {
       double s = Math.sin(x);
       if(s>=0)
           return 1;
       else
           return 0;
   }
   

   private static double ceil(double d)
   {
       long iPart = (long) d;
       double fPart = d - iPart;
       if(fPart >= 0.5d)
           return iPart+1;
       else 
           return iPart;
   }
   
   
}
