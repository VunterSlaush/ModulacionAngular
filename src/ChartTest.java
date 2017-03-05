
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
 

 
public class ChartTest
{ 
   public static void main (String[] args) throws IOException, Exception
   {
      try {
          for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (Exception e) {
          // If Nimbus is not available, you can set the GUI to another look and feel.
      }
      FirstForm frame = new FirstForm();
      frame.setVisible(true);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       /*
       double fc = ConversorDeUnidades.getInstance().convertir(1000, "Hz");
       double fm = ConversorDeUnidades.getInstance().convertir(100, "Hz");
       Signal m = new Signal(fm,1,0.0,false,Signal.SIN);
       Signal p = new Signal(fc,10,0.0,false,Signal.SIN);
       ModulateSignal md = new ModulateSignal(p,m,1.0,0);
       for (int i = 0; i < 10000; i++) {
                  double t = (double) i/100000;
           System.out.println("t:"+t);             
       System.out.println("resultado Dev Inst Fase"+Calculador.getInstance().frecuenciaInstantanea(md, t));
       //System.out.println("Portadora:"+p.evaluate(t));
           //System.out.println("Moduladora integrada:"+m.evaluarIntegrado(t));
           System.out.println("------");
       }
//System.out.println(Signal.sawTooth(90));*/

   }
   

   
}