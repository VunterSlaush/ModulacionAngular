
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;


/**
 *
 * @author Slaush
 */
public class GeneradorDeGraphicas 
{
    private static GeneradorDeGraphicas instance;
    private GeneradorDeGraphicas(){}

    public static GeneradorDeGraphicas getInstance()
    {
    	if(instance == null)
    		instance = new GeneradorDeGraphicas();
    	return instance;
    }

    public JFreeChart generarGrafica(Signal signal)
    {

    }

    public JFreeChart generarGrafica(Signal signal, double from, double to)
    {
    	
    }
}
