/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author House
 */
public class Ventana extends JFrame implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Graficadora.plano.paintSQRFunc(Graficadora.plano.getGraphics(), 0.2,-3,3,-200,200);
    }
    
    
}
