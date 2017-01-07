
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
    private static final int CANT_MAXIMA_FRAMES = 225;
    IEvaluableEnTiempo evaluable;
    ChartPanel panel;
    boolean stop;
    int frameActual;
    private static final long TIME_TO_RENDER = 150;
    private boolean pause;
    Integer frames;
    Integer time;
    public ChartThread(IEvaluableEnTiempo evaluable, ChartPanel panel)
    {
        this.evaluable = evaluable;
        this.panel = panel;
        this.frames = 225;
        this.time = 150;
        frameActual = 0;
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
                       ConversorDeUnidades.getInstance().retornarMultiploUnidad("µs")));
               
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
    }

    boolean isPause() {
        return pause;
    }
    
    public synchronized void changeFrames(int frames)
    {
        this.frames = frames;
    }
    
    public synchronized void changeTime(int time)
    {
        this.time = time;
    }
}
