/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Slaush
 */
public interface IEvaluableEnTiempo 
{
    public double evaluate(double t);
    public String getTipo();
    public int unidadOptima();
}
