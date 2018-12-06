/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author House
 */
public class planoEmulador extends JPanel{
    JLabel pared = null;
   
    private JLabel resorte = null;
    JLabel masa = null;
    JLabel amortiguador = null;
    public planoEmulador(){
        init();
    }
    public void init(){
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        pared = new JLabel();
        pared.setBounds(0, 0, 560, 40);
        ImageIcon imgPared = new ImageIcon(getClass().getResource("/images/pared.jpg"));
        ImageIcon scaledPared = new ImageIcon(imgPared.getImage().getScaledInstance(pared.getWidth(), pared.getHeight(), Image.SCALE_DEFAULT));
        pared.setIcon(scaledPared);
        this.add(pared);
    
        setResorte(new JLabel());
        getResorte().setBounds(0, 0, 30, 100);

        ImageIcon imgResorte = new ImageIcon(getClass().getResource("/images/resorte.jpg"));
        ImageIcon scaledResorte = new ImageIcon(imgResorte.getImage().getScaledInstance(getResorte().getWidth(), getResorte().getHeight(), Image.SCALE_DEFAULT));
        getResorte().setIcon(scaledResorte);
        this.add(getResorte());
        getResorte().setBounds(10,50,250,250);
        masa = new JLabel();
        masa.setBounds(10,50,250,250);
    }
    @Override
    public void paintComponent( Graphics g ){
        super.paintComponent(g);
        //g.setColor(Color.cyan);
        //g.drawString("X (elongación, posición)", (this.getWidth()/2)+15, 20);
        //g.setColor(Color.red);
        //g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        //g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
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
                Logger.getLogger(planoEmulador.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * @return the resorte
     */
    public JLabel getResorte() {
        return resorte;
    }

    /**
     * @param resorte the resorte to set
     */
    public void setResorte(JLabel resorte) {
        this.resorte = resorte;
    }
}   
