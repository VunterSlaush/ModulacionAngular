
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class ChartThread extends Thread 
{   
    IEvaluableEnTiempo evaluable;
    ChartPanel panel;
    boolean stop;
    int frameActual;
    private boolean pause;
    Integer frames;
    Integer time;
    private double unidad;
    public ChartThread(IEvaluableEnTiempo evaluable, ChartPanel panel)
    {
        this.evaluable = evaluable;
        this.panel = panel;
        this.frames = 225;
        this.time = 150;
        frameActual = 0;
        unidad = evaluarUnidad();
        if(unidad>= Math.pow(10, 11))
            this.frames = 1000;
        
    }
    
    @Override
    public void run()
    {
       stop = false;
       pause = false;
       while(!stop)
       {
           try 
           {
             
               if(!pause)
               {
                 panel.setChart(GeneradorDeGraphicas.getInstance().drawSignal(evaluable,
                       frameActual,
                       frameActual+frames, 
                       unidad));
               
                 frameActual+=frames;
               }
                sleep(time);
           } 
           catch (InterruptedException ex) 
           {
               Logger.getLogger(ChartThread.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
    public void stopThread()
    {
        stop = true;
    }
    
    public void switchPause()
    {
        pause = !pause;
    }
    
 
    public boolean isRunning()
    {
        return !stop;
    }
    
    public void changeEvaluable(IEvaluableEnTiempo e)
    {
        evaluable = e;
        unidad = e.unidadOptima();
        frameActual = 0;
        changeFrames(225);
    }

    boolean isPause() {
        return pause;
    }
    
    public synchronized void changeFrames(int frames)
    {
        this.frames = frames;
        if(unidad>= Math.pow(10, 11))
            this.frames+=775;
    }
    
    public synchronized void changeTime(int time)
    {
        this.time = time;
    }

    private double evaluarUnidad() 
    {
        return evaluable.unidadOptima();
    }
}
