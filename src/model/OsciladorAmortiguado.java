/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author House
 */
public class OsciladorAmortiguado extends Oscilador{
    protected double g;
    public OsciladorAmortiguado(double h, double g, double w0){
        super(h, w0);
        this.g = g;
    }
    @Override
    public double f(double x, double v, double t){
        return (-2*g*v-w0*w0*x);
    }
}
