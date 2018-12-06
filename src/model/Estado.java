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
public class Estado {
    public double t;
    public double x;
    public double v;
    public Estado(double t, double x, double v){
        this.t = t;
        this.x = x;
        this.v = v;
    }
}
