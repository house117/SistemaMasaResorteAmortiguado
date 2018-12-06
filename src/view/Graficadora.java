/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.plano;
import controller.planoEmulador;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author House
 */
public class Graficadora {
    public static plano plano;
    public static planoEmulador planoEm;
    public static void main(String[] args) {
        Ventana frame = new Ventana();
        frame.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 580, 680);
        frame.setLayout(new BorderLayout());
        //plano = new plano();
        planoEm = new planoEmulador();
        //Crear metodo en plano de graficar solo un punto
        //Luego llamar a todo esto en el método graficar de nuestro programita
        //Y enviar un arrayList de los puntos a graficar, luego hacemos otro método graficar tabla
        //el cual llamará muchas veces al método graficar un punto somos bien chidos jajja
        JButton start = new JButton("Iniciar");
        start.addActionListener(frame);
        start.setText("Iniciar");
        //frame.add(plano, BorderLayout.CENTER);
        frame.add(planoEm, BorderLayout.CENTER);
        frame.add(start, BorderLayout.SOUTH);
        frame.setVisible(true);
        int x = planoEm.getResorte().getBounds().x;
        int y = planoEm.getResorte().getBounds().y;
        for (int i = 0; i < 10; i++) {
            planoEm.getResorte().setBounds(planoEm.getResorte().getBounds().x, planoEm.getResorte().getBounds().y, 
                    planoEm.getResorte().getBounds().width, planoEm.getResorte().getBounds().height+10);
            ImageIcon imgResorte =  (ImageIcon) planoEm.getResorte().getIcon();
        ImageIcon scaledResorte = new ImageIcon(imgResorte.getImage().getScaledInstance(planoEm.getResorte().getWidth(), planoEm.getResorte().getHeight(), Image.SCALE_DEFAULT));
        planoEm.getResorte().setIcon(scaledResorte);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Graficadora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
