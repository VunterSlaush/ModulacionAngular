
/**
 *
 * @author Slaush
 */
public class ConversorDeUnidades 
{
	private static ConversorDeUnidades instance;
    static String[] unidades = {"10^-1s","10^-2s","10^-3s",
                              "10^-4s","10^-5s","10^-6s",
                              "10^-7s","10^-8s","10^-9s",
                              "10^-10s","10^-11s","10^-12s"};
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

    double retornarMultiploUnidad(String unidad) {
        if ("s".equals(unidad))
    		return 1;
        if("10^-1s".equals(unidad))
                return 10;
        if("10^-2s".equals(unidad))
                return 100;
        if("ms".equals(unidad) || "10^-3s".equals(unidad))
                return 1000;
        if("10^-4s".equals(unidad))
                return 10000;
        if("10^-5s".equals(unidad))
                return 100000;
        if("µs".equals(unidad) || "10^-6s".equals(unidad))
                return 1000000;
        if("10^-7s".equals(unidad))
                return 10000000;
        if("10^-8s".equals(unidad))
                return 100000000;
        if("10^-9s".equals(unidad))
                return 1000000000;
        if("10^-10s".equals(unidad))
                return Math.pow(10, 10);
        if("10^-11s".equals(unidad))
                return Math.pow(10, 11);
        if("10^-12s".equals(unidad))
                return Math.pow(10, 12);
        return 1000;
    }
}
