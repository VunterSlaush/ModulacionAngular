
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javolution.lang.MathLib;
import org.jfree.data.xy.XYSeries;


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

    public double j0(double x) throws ArithmeticException 
    {
        double ax;

        if( (ax=Math.abs(x)) < 8.0 ) {
           double y=x*x;
           double ans1=57568490574.0+y*(-13362590354.0+y*(651619640.7
                       +y*(-11214424.18+y*(77392.33017+y*(-184.9052456)))));
           double ans2=57568490411.0+y*(1029532985.0+y*(9494680.718
                       +y*(59272.64853+y*(267.8532712+y*1.0))));

           return ans1/ans2;

        } else {
           double z=8.0/ax;
           double y=z*z;
           double xx=ax-0.785398164;
           double ans1=1.0+y*(-0.1098628627e-2+y*(0.2734510407e-4
                       +y*(-0.2073370639e-5+y*0.2093887211e-6)));
           double ans2 = -0.1562499995e-1+y*(0.1430488765e-3
                       +y*(-0.6911147651e-5+y*(0.7621095161e-6
                       -y*0.934935152e-7)));
           
           return Math.sqrt(0.636619772/ax)*
                  (Math.cos(xx)*ans1-z*Math.sin(xx)*ans2);
	}
    }
  /**
   * @param x a double value
   * @return the Bessel function of order 1 of the argument.
   */
    public double j1(double x) throws ArithmeticException {

      double ax;
      double y;
      double ans1, ans2;

      if ((ax=Math.abs(x)) < 8.0) {
         y=x*x;
         ans1=x*(72362614232.0+y*(-7895059235.0+y*(242396853.1
               +y*(-2972611.439+y*(15704.48260+y*(-30.16036606))))));
         ans2=144725228442.0+y*(2300535178.0+y*(18583304.74
               +y*(99447.43394+y*(376.9991397+y*1.0))));
         return ans1/ans2;
       } else {
         double z=8.0/ax;
         double xx=ax-2.356194491;
         y=z*z;

         ans1=1.0+y*(0.183105e-2+y*(-0.3516396496e-4
              +y*(0.2457520174e-5+y*(-0.240337019e-6))));
         ans2=0.04687499995+y*(-0.2002690873e-3
              +y*(0.8449199096e-5+y*(-0.88228987e-6
              +y*0.105787412e-6)));
         double ans=Math.sqrt(0.636619772/ax)*
                   (Math.cos(xx)*ans1-z*Math.sin(xx)*ans2);
         if (x < 0.0) ans = -ans;
         return ans;
       }
    }

  /**
   * @param n integer order
   * @param x a double value
   * @return the Bessel function of order n of the argument.
   */
    public double besselAt(int n, double x) throws ArithmeticException {
       int j,m;
       double ax,bj,bjm,bjp,sum,tox,ans;
       boolean jsum;

       double ACC   = 40.0;
       double BIGNO = 1.0e+10;
       double BIGNI = 1.0e-10;

       if(n == 0) return j0(x);
       if(n == 1) return j1(x);

       ax=Math.abs(x);
       if(ax == 0.0)  return 0.0;
       else 
       if (ax > (double)n) {
         tox=2.0/ax;
         bjm=j0(ax);
         bj=j1(ax);
         for (j=1;j<n;j++) {
            bjp=j*tox*bj-bjm;
            bjm=bj;
            bj=bjp;
         }
         ans=bj;
       } else {
         tox=2.0/ax;
         m=2*((n+(int)Math.sqrt(ACC*n))/2);
         jsum=false;
         bjp=ans=sum=0.0;
         bj=1.0;
         for (j=m;j>0;j--) {
            bjm=j*tox*bj-bjp;
            bjp=bj;
            bj=bjm;
            if (Math.abs(bj) > BIGNO) {
               bj *= BIGNI;
               bjp *= BIGNI;
               ans *= BIGNI;
               sum *= BIGNI;
            }
            if (jsum) sum += bj;
            jsum=!jsum;
            if (j == n) ans=bjp;
          }
          sum=2.0*sum-bj;
          ans /= sum;
       }
       return  x < 0.0 && n%2 == 1 ? -ans : ans;
   }
    
    int factorial(int a)
    {   
        if(a==0)
            return 1;
        return a * factorial(--a);
    }
    
    public Double redondear(double a) 
    {
        return Math.round(a * 100.0) / 100.0;
    }

    double sin(double value) {
        return MathLib.sin(value);
 
    }
    
     double cos(double value) {
        return MathLib.cos(value);
    }


    double triangle(double x) 
    {   
        return MathLib.asin(MathLib.cos(x)); 
    }
    
    double triangleIntegrate(double x,double w)
    {  
        double sin = Math.sin(w*x);
        double sqrt = Math.sqrt(Math.pow(sin,2));
        double csc = csc(w*x);
        double asin = x * Math.asin(Math.cos(w*x));
        return -(2/Math.PI)*((w*Math.pow(x,2))/2 * sqrt * csc + asin);
    }
    
    double sawToothIntegrate(double x, double w)
    {
       return -((w*Math.pow(x, 2))/2 + x*Math.atan(Calculador.getInstance().cot(w*x)));
    }

    double desviacionInstantaneaFreq(ModulateSignal modulada, double t) {
        
        double aF = (double)  modulada.moduladora.evaluarIntegrado(t);
        return aF;
    }
    
    double desviacionInstantaneaFase(ModulateSignal modulada, double t) 
    {    
        double aF = (double) modulada.moduladora.evaluate(t);
        return aF;
    }
    
    double faseInstantanea(ModulateSignal modulada, double t)
    {
        return modulada.portadora.w*t + modulada.moduladora.evaluate(t);
    }
    
    double frecuenciaInstantanea(ModulateSignal modulada, double t)
    {
        return  modulada.portadora.frecuencia + 
                modulada.moduladora.evaluarIntegrado(t)/(MathLib.PI * 2);
    }
    
    double potenciaInstantanea(ModulateSignal m, double resis, double t)
    {
        return redondear(Math.pow(m.evaluate(t), 2)/resis);
    }

    double sawTooth(double n) 
    {
        return Math.atan(cot(n));
    }

    double cot(double n) {
         return Math.cos(n)/Math.sin(n);
    }
    
    double csc(double n)
    {
        return 1 / Math.sin(n);
    }

    double potenciaPromedio(ModulateSignal modulada, double resis) 
    {
        return redondear(Math.pow(modulada.portadora.amplitud,2)/resis);
    }

    double potenciaTotal(ModulateSignal modulada, double d) {
        HashMap<Double, Double> spectro = modulada.getSpectro();
        Set<Double> amplitudes = new HashSet<>();
        double pt = potenciaPromedio(modulada,d);
        for (Map.Entry<Double,Double> map : spectro.entrySet()) 
        {   
            System.out.println("Map.key:"+map.getKey());
            System.out.println("Map.Value:"+map.getValue());
            amplitudes.add(map.getValue());
        }
        for(Double v : amplitudes)
        {
            pt+= Math.pow(v, 2)/d;
        }
        return redondear(pt);
    }
}
