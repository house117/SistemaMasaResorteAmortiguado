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
public class plano extends JPanel {

    private Double arr[][];
    private int delay;
    public plano(int delay) {
        this.delay = delay;
        init();
        
    }

    public void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.drawString("Gráfica del resorte a través del tiempo", 100, 100);
        g.drawString("Plug-in Creado por Dany y José Luis", 100, 120);
        g.setColor(Color.blue);
        g.drawString("X (elongación, posición)", (this.getWidth() / 2) + 15, 20);
        g.drawString("T (tiempo)", this.getWidth()-80, (this.getHeight()/2)+30);
        g.setColor(Color.red);
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
        for (int i = 0; i < getArr()[0].length; i++) {
            //System.out.println("???");
            //System.out.println("El método fue llamado");
            g.setColor(Color.black);
            //System.out.println("Coordenadas + (" + (int) coord_x(getArr()[0][i]) + ") (" + (int) coord_y(getArr()[1][i]) + ")(" + (int) coord_x(getArr()[0][i]) + ")(" + (int) coord_y(getArr()[1][i]) + ")");
            g.drawLine((int) coord_x(getArr()[0][i]), (int) coord_y(getArr()[1][i]), (int) coord_x(getArr()[0][i]), (int) coord_y(getArr()[1][i]));
        }
    }

    public void graficarArray(Graphics g, Double arr[][]) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.drawString("Gráfica del resorte a través del tiempo", 100, 100);
        g.drawString("Plug-in Creado por Dany y José Luis", 100, 120);
        g.setColor(Color.blue);
        g.drawString("X (elongación, posición)", (this.getWidth() / 2) + 15, 20);
        g.drawString("T (tiempo)", this.getWidth()-80, (this.getHeight()/2)+30);
        g.setColor(Color.red);
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
        g.setColor(Color.black);
        for (int i = 0; i < arr[0].length; i++) {
            //System.out.println("???");
            //System.out.println("El método fue llamado");
            
            //System.out.println("Coordenadas + (" + (int) coord_x(arr[0][i]) + ") (" + (int) coord_y(arr[1][i]) + ")(" + (int) coord_x(arr[0][i]) + ")(" + (int) coord_y(arr[1][i]) + ")");
            g.drawLine((int) coord_x(arr[0][i]), (int) coord_y(arr[1][i]), (int) coord_x(arr[0][i]), (int) coord_y(arr[1][i]));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(plano.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //Métodos importantes para devolver la cordenada real
    private double coord_x(double x) {
        double real_x = x + this.getWidth() / 2;
        return real_x;
    }

    private double coord_y(double y) {
        double real_y = -y + this.getHeight() / 2;
        return real_y;
    }

    /**
     * @return the arr
     */
    public Double[][] getArr() {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(Double[][] arr) {
        this.arr = arr;
    }

    /**
     * @return the delay
     */
    public int getDelay() {
        return delay;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }
}
