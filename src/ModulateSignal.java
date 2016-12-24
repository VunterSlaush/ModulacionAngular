/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class ModulateSignal implements IEvaluableEnTiempo
{   
    private static final int FM = 0;
    private static final int PM = 1;
    private final double k;
    private final Signal portadora;
    private final Signal moduladora;
    private final int modulationType;
    public ModulateSignal(Signal p, Signal m, double k, int type)
    {   
        portadora = p;
        moduladora = m;
        this.k = k;
        modulationType = type;
    }
    
    @Override
    public double evaluate(double t)
    {
        if(modulationType == FM)
            return evaluarFM(t);
        else if(modulationType == PM)
            return evualarPM(t);
        else
            return -1.0;
    }

    private double evaluarFM(double t) {
       double moduladoraResultado = moduladora.evaluarIntegrado(t);
       double fase = portadora.fase;
       double nfase = (k/moduladora.frecuencia*Signal.pi2)*moduladoraResultado;
       portadora.fase = nfase;
       double value = portadora.evaluate(t);
       portadora.fase = fase;
       return value;
    }

    private double evualarPM(double t) {
       double moduladoraResultado = k*moduladora.evaluate(t);
       double fase = portadora.fase;
       portadora.fase = moduladoraResultado;
       double value = portadora.evaluate(t);
       portadora.fase = fase;
       return value;
    }

    @Override
    public String toString() {
        return "ModulateSignal{" + "k=" + k + ",\n portadora=" + portadora + ",\n moduladora=" + moduladora + ",\n modulationType=" + modulationType + '}';
    }

    @Override
    public String getTipo() {
        if(modulationType == FM)
            return "Modulacion FM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
        else
            return "Modulacion PM: "+portadora.getTipo()+" VS "+moduladora.getTipo();
    }
    
}
