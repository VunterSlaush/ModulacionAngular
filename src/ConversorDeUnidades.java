
/**
 *
 * @author Slaush
 */
public class ConversorDeUnidades 
{
	private static ConversorDeUnidades instance;
	private ConversorDeUnidades(){}

	//Unidades Estandares SI??
        private static final double nano = Math.pow(10,-9);
	private static final double micro = Math.pow(10,-6);
	private static final double m = Math.pow(10,-3);
	private static final double K = Math.pow(10,3);//10 a la 3
	private static final double M = Math.pow(10,6);
	private static final double G = Math.pow(10,9);

	//Unidades de Tiempo!
	private static final double S = 1000;
	private static final double MIN = 60*1000;
	private static final double H = 3600*60*1000;

	public static ConversorDeUnidades getInstance()
	{
		if (instance == null) 
		{
			instance = new ConversorDeUnidades();	
		}
		return instance;
	}
    
    public double convertir(double valor, String unidad)
    {
    	if (unidad.contains("G"))
    		return G * valor;
    	if(unidad.contains("K"))
    		return K * valor;
    	if(unidad.contains("M"))
    		return M * valor;
    	if(unidad.contains("m"))
    		return m * valor;
    	if(unidad.contains("µ"))
    		return micro * valor;
		
		return valor; 
    }

    public double convertirTiempo(int valor, String unidad)
    {   
    	if ("s".equals(unidad))
    		return valor * S;
    	if("min".equals(unidad))
    		return valor * MIN;
        if("µs".equals(unidad))
                return valor * micro;
    	
    	return valor;
    }

    int retornarMultiploUnidad(String unidad) {
        if ("s".equals(unidad))
    		return 1;
        if("ms".equals(unidad))
                return 1000;
        if("10^-4s".equals(unidad))
                return 10000;
        if("µs".equals(unidad))
                return 100000;
        
        return 1000;
    }
}
