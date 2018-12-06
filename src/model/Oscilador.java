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
public class Oscilador extends RungeKutta{
    protected double w0;
    public Oscilador(double h, double w0){
        super(h);
        this.w0 = w0;
    }
    @Override
    public double f(double x, double y, double t) {
        return ( -w0*w0*x);
    }
    
}
