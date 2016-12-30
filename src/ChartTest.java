
import java.io.IOException;

import javax.swing.JFrame;
 

 
public class ChartTest
{ 
   public static void main (String[] args) throws IOException
   {
     
      FirstForm frame = new FirstForm();
      frame.setVisible(true);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            
       /*Signal m = new Signal(100,1,0.0,false,Signal.SIN);
       Signal p = new Signal(400.0,10,0.0,false,Signal.SIN);
       ModulateSignal  md = new ModulateSignal(p,m,3,0);
       for (int i = 0; i < 30; i++) {
                  double t = (double) i/10000;
           System.out.println("t:"+t);             
       System.out.println("Modulada:"+md.evaluate(t));
       //System.out.println("Portadora:"+p.evaluate(t));
           //System.out.println("Moduladora integrada:"+m.evaluarIntegrado(t));
           System.out.println("------");
       } System.out.println(md);
//System.out.println(Signal.sawTooth(90));*/
       
    
   }
   
}