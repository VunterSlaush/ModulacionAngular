
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
        return drawSignal(e,0,1000,1000);
    }
    
    public JFreeChart drawSignal(IEvaluableEnTiempo  s, int from, int to,int unidad)
    {
    	int frames = to - from;
        System.out.println("from:"+from+" to:"+to+" frames:"+frames);
    	double [][] matrix = new double[AXIS][frames];     
        DefaultXYDataset dataset = new DefaultXYDataset();
	fillMatrix(matrix,to,from,unidad);
        fillMatrix(matrix,s,frames);
    	dataset.addSeries(s.getTipo(), matrix);
        return ChartFactory.createXYLineChart
       (
         "", // The chart title
         "t(seg)", // x axis label
         "A(V)", // y axis label
         dataset, // The dataset for the chart
         PlotOrientation.VERTICAL,
         true, // Is a legend required?
         false, // Use tooltips
         true // Configure chart to generate URLs?
       );
    }

    private void fillMatrix(double [][] matrix, IEvaluableEnTiempo e,int frames)
    {
    	for (int i = 0;i<frames ; i++) 
        {   
            matrix[1][i]=e.evaluate(matrix[0][i]);
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

}
