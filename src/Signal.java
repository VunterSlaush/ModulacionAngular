



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
   private static final double RUIDO_MAXIMO = 30.0;
   private static final int CIFRAS_SIGNIFICATIVAS = 1000000;//Cada 0 es 1 cifra
   double amplitud; 
   double frecuencia;
   double fase;
   boolean ruido; 
   String tipo;
   double w;//Frecuencia Angular Portadora

   

    public Signal(double frecuencia,double amplitud, double fase, boolean ruido, String tipo) 
    {
        this.amplitud = amplitud;
        this.frecuencia = frecuencia;
        this.fase = fase;
        this.ruido = ruido;
        this.tipo = tipo;
        this.w = frecuencia * pi2;
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
        return "Signal{" + "amplitud=" + amplitud + ", frecuencia=" + frecuencia + ", fase=" + fase + ", ruido=" + ruido + ", tipo=" + tipo + ", w=" + w + '}';
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
        double value = t*w + fase;
        
        if(tipo.equals(SAWTOOTH))
                value = sawTooth(frecuencia * Math.PI * t + fase);
        if(tipo.equals(SQUARE))
                value = square(value);
        if(tipo.equals(TRIANGULAR))
                value = triangle(value);
        if(tipo.equals(SIN))
            value = Calculador.getInstance().sin(value);       
        if(tipo.equals(COS))
                value = Calculador.getInstance().cos(value); 
        
        if(tipo.equals(SAWTOOTH) || tipo.equals(TRIANGULAR))
            value*= -(2*amplitud/Math.PI); 
        else
            value*=amplitud;
        
        if(ruido)
            value+= Math.random() % RUIDO_MAXIMO;

        return value;
    }
    
    public double evaluarIntegrado(double t)
    {   
        double value = (double) t*w + fase;
       
        if(tipo.equals(SIN))
                value = -Calculador.getInstance().cos(value); 
        if(tipo.equals(COS))
                value = Calculador.getInstance().sin(value); 
        if(tipo.equals(TRIANGULAR))
                value = Calculador.getInstance().triangleIntegrate(t, w);
        if(tipo.equals(SAWTOOTH))
                value = sawToothI(t,frecuencia*Math.PI);
        
        if(ruido)
            value+= Math.random() % (RUIDO_MAXIMO/amplitud);
        
        return value;
    }
    
   public static double sawTooth(double n)
   {
       return Calculador.getInstance().sawTooth(n);
   }
   
   public static double sawToothI(double t,double w)
   {
       return -((w*Math.pow(t, 2))/2 + t*Math.atan(Calculador.getInstance().cot(w*t)));
   }
   
   private static double triangle(double x)
   {
       
      return Calculador.getInstance().triangle(x);
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

    @Override
    public int unidadOptima() {
        int n = 9;
        double div;
        for (int i = 9; i > 0; i--) 
        {
            div = (double)(frecuencia / Math.pow(10, i));
            System.out.println("Div:"+div);
            if(Double.compare(0.1, div)<= 0)
            {
                n = i;
                break;
            }    
        }
        if(n<9)
           n++;
        String unidad = "10^-"+n+"s";
        System.out.println("UNIDAD:"+unidad);
        return ConversorDeUnidades.getInstance().retornarMultiploUnidad(unidad);
        
    }
    
    public double evaluateSinRuido(double t)
    {
        double value = t*w + fase;
        
        if(tipo.equals(SAWTOOTH))
                value = sawTooth(frecuencia * Math.PI * t + fase);
        if(tipo.equals(SQUARE))
                value = square(value);
        if(tipo.equals(TRIANGULAR))
                value = triangle(value);
        if(tipo.equals(SIN))
            value = Calculador.getInstance().sin(value);       
        if(tipo.equals(COS))
                value = Calculador.getInstance().cos(value); 
        
        if(tipo.equals(SAWTOOTH) || tipo.equals(TRIANGULAR))
            value*= -(2*amplitud/Math.PI); 
        else
            value*=amplitud;
        
        if(ruido)
            value+= Math.random() % (RUIDO_MAXIMO/amplitud);

        return value;
    }

    
}
