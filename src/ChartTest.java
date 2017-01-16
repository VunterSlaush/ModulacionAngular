
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
 

 
public class ChartTest
{ 
   public static void main (String[] args) throws IOException, Exception
   {
     
      FirstForm frame = new FirstForm();
      frame.setVisible(true);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       /*
       double fc = ConversorDeUnidades.getInstance().convertir(100, "KHz");
       double fm = ConversorDeUnidades.getInstance().convertir(10, "KHz");
       Signal m = new Signal(fm,1,0.0,false,Signal.SIN);
       Signal p = new Signal(fc,10,0.0,false,Signal.SIN);
       ModulateSignal md = new ModulateSignal(p,m,1.0,0);
       for (int i = 0; i < 10000; i++) {
                  double t = (double) i/10000;
           System.out.println("t:"+t);             
       System.out.println("Modulada:"+md.evaluate(t));
       //System.out.println("Portadora:"+p.evaluate(t));
           //System.out.println("Moduladora integrada:"+m.evaluarIntegrado(t));
           System.out.println("------");
       }
//System.out.println(Signal.sawTooth(90));*/

   }
   

   
}