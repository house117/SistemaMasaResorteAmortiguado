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
import view.Graficadora;
import static view.Graficadora.planoEm;

/**
 *
 * @author House
 */
public class planoEmulador extends JPanel {

    JLabel pared = null;

    private JLabel resorte = null;
    JLabel masa = null;
    JLabel amortiguador = null;
    private int delay;
    private Double arr[][];
    private Double posInicial;

    public planoEmulador(int delay, Double posInicial) {
        this.delay = delay;
        this.posInicial = posInicial;
        super.setLayout(null);
        init();
    }

    public void init() {
        System.out.println("POS INICIAL ???: "+(int)coord_y(posInicial));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        pared = new JLabel();
        pared.setBounds(0, 0, 560, 40);
        ImageIcon imgPared = new ImageIcon(getClass().getResource("/images/pared.jpg"));
        ImageIcon scaledPared = new ImageIcon(imgPared.getImage().getScaledInstance(pared.getWidth(), pared.getHeight(), Image.SCALE_DEFAULT));
        pared.setIcon(scaledPared);
        //this.add(pared);

        setResorte(new JLabel());
        getResorte().setBounds(290, 10, 30, (340)-((int)coord_y(posInicial)));
        ImageIcon imgResorte = new ImageIcon(getClass().getResource("/images/resorte.jpg"));
        ImageIcon scaledResorte = new ImageIcon(imgResorte.getImage().getScaledInstance(getResorte().getWidth(), getResorte().getHeight(), Image.SCALE_DEFAULT));
        getResorte().setIcon(scaledResorte);
        this.add(getResorte());
        
        //getResorte().setBounds(10, 50, 250, 250);
        masa = new JLabel();
        masa.setBounds(280, 340-(int)coord_y(posInicial)+20, 50, 50);
        ImageIcon imgMasa = new ImageIcon(getClass().getResource("/images/masa.jpg"));
        ImageIcon scaledMasa = new ImageIcon(imgMasa.getImage().getScaledInstance(masa.getWidth(), masa.getHeight(), Image.SCALE_DEFAULT));
        masa.setIcon(scaledMasa);
        this.add(masa);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.cyan);
        //g.drawString("X (elongación, posición)", (this.getWidth()/2)+15, 20);
        //g.setColor(Color.red);
        //g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        //g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
    }

    public void emular(Graphics g, Double arr[][]) {
        /*this.setBorder(BorderFactory.createLineBorder(Color.black));
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
        masa.setBounds(10,50,250,250);*/
        System.out.println("HAGO ALGO???");
        int inutil = 1;
        for (int i = 0; i < arr[0].length; i++) {
            pared.setBounds(0, 0, 560+inutil, 40);
            this.getResorte().setBounds(this.getResorte().getBounds().x, this.getResorte().getBounds().y,
            this.getResorte().getBounds().width, (int) coord_y(arr[1][i]));
            ImageIcon imgResorter = (ImageIcon) this.getResorte().getIcon();
            ImageIcon scaledResorter = new ImageIcon(imgResorter.getImage().getScaledInstance(this.getResorte().getWidth(), this.getResorte().getHeight(), Image.SCALE_DEFAULT));
            masa.setBounds(masa.getBounds().x, 50+(int) coord_y(arr[1][i]),
            masa.getBounds().width, masa.getBounds().height);
            this.getResorte().setIcon(scaledResorter);
            try {
                Thread.sleep(delay);
                super.update(g);
            } catch (InterruptedException ex) {
                Logger.getLogger(Graficadora.class.getName()).log(Level.SEVERE, null, ex);
            }
            inutil*=-1;
        }
        System.out.println("Terminó el loop");
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
