/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public class DemodulateSignal implements IEvaluableEnTiempo {
    
    private final ModulateSignal parent;
    
    
    DemodulateSignal(ModulateSignal modulate) {
        parent = modulate;
    }

    @Override
    public double evaluate(double t) {
        return parent.evaluateDemodulate(t);
    }

    @Override
    public String getTipo() {
        return "Señal Demodulada";
    }

    @Override
    public int unidadOptima() {
       return parent.unidadOptima();
    }

    
}
