/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author House
 */
public class plano extends JPanel{
    public plano(){
        init();
    }
    public void init(){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent(g);
        g.setColor(Color.cyan);
        g.drawString("X (elongación, posición)", (this.getWidth()/2)+15, 20);
        g.setColor(Color.red);
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
    }
    public void paintSQRFunc(Graphics g, double x2mult, double x1mult, double cons, double x1, double x2){
        for (double i=x1; i<x2; i++) {
            double y = ((double)Math.pow(i, 2)*x2mult)+i*x1mult+cons;
            double xp = i+1;
            double yp = ((double)Math.pow(xp, 2)*x2mult)+xp*x1mult+cons;
            g.drawLine((int)coord_x(i), (int)coord_y(y), (int)coord_x(xp), (int)coord_y(yp));
            try {
                Thread.sleep(15);
               
            } catch (InterruptedException ex) {
                Logger.getLogger(plano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Métodos importantes para devolver la cordenada real
    private double coord_x(double x){
        double real_x = x+this.getWidth()/2;
        return real_x;
    }
    private double coord_y(double y){
        double real_y = -y+this.getHeight()/2;
        return real_y;
    }
}   
