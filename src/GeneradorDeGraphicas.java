
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author Slaush
 */
public class GeneradorDeGraphicas 
{	
    private static final int AXIS = 2; //EJES EN EL PLANO!
    private static GeneradorDeGraphicas instance;
    private GeneradorDeGraphicas(){}

    public static GeneradorDeGraphicas getInstance()
    {
    	if(instance == null)
    		instance = new GeneradorDeGraphicas();
    	return instance;
    }	

    public JFreeChart drawSignal(IEvaluableEnTiempo e)
    {
        return drawSignal(e,0,1000,10000);
    }
    
    public JFreeChart drawSignal(IEvaluableEnTiempo  s, int from, int to,int unidad)
    {
    	int frames = to - from;
    	double [][] matrix = new double[AXIS][frames];     
        DefaultXYDataset dataset = new DefaultXYDataset();
	fillMatrix(matrix,to,from,unidad);
        fillMatrix(matrix,s,frames);
    	dataset.addSeries(s.getTipo(), matrix);
        JFreeChart chart = ChartFactory.createXYLineChart
       (
         "", // The chart title
         "t(seg)", // x axis label
         "A(V)", // y axis label
         dataset, // The dataset for the chart
         PlotOrientation.VERTICAL,
         true, // Is a legend required?
         true, // Use tooltips
         false // Configure chart to generate URLs?
       );
        XYPlot plot = chart.getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(3,169,244));
        return chart;
    }

    private void fillMatrix(double [][] matrix, IEvaluableEnTiempo e,int frames)
    {
    	for (int i = 0;i<frames ; i++) 
        {   
            matrix[1][i]=e.evaluate(matrix[0][i]);
            System.out.println("Evaluando:"+matrix[0][i]+" = "+matrix[1][i]);
    	}
    }

    private void fillMatrix(double[][] matrix, int to, int from, int unidad) 
    {
        int frames = to - from;
        
        for(int i = 0; i<frames; i++)
        {
            matrix[0][i]=(double)(to-i)/unidad;
        }
    }
    
    public JFreeChart drawSpectro(HashMap<Double,Double> spectro)
    {   
 
        IntervalXYDataset dataset = createBarDataSet(spectro);
     
        return ChartFactory.createXYBarChart
       (
         "Espectro de Frecuencias", // The chart title
         "Hz", // x axis label
         false, // y axis label
         "V",
         dataset, // The dataset for the chart
         PlotOrientation.VERTICAL,
         false, // Is a legend required?
         false, // Use tooltips
         true // Configure chart to generate URLs?
       );
    }

    private IntervalXYDataset createBarDataSet(HashMap<Double, Double> spectro) {
        
        XYSeriesCollection collection = new XYSeriesCollection();
        String unit = evualuateSpectroUnit(spectro);
        System.out.println("Unit"+unit);
        Double value;
        for (Map.Entry<Double,Double> map : spectro.entrySet()) 
        {   
            value = map.getKey()/ConversorDeUnidades.getInstance().convertir(1, unit);
             System.out.println("Value:"+value);
             XYSeries jn = new XYSeries(value);
             System.out.println("Key:"+map.getKey());
             
             jn.add(Math.abs(map.getKey()),Math.abs(map.getValue()));
             collection.addSeries(jn);
        }
        if(unit.equals("MHz"))
            return new XYBarDataset(collection,10);
        else if(unit.equals("KHz"))
            return new XYBarDataset(collection,10);
        else
             return new XYBarDataset(collection,1);
    }

    private String evualuateSpectroUnit(HashMap<Double, Double> spectro) {
     
       double minValue = Double.MAX_VALUE;
       for (Map.Entry<Double,Double> map : spectro.entrySet()) 
       {
           if(map.getKey() < minValue)
                minValue = map.getKey();
       }
       
       if(minValue > 1000000)
           return "MHz";
       else if(minValue>1000)
           return "KHz";
       else
           return "Hz";

    }



}
