/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.plano;
import java.awt.BorderLayout;
import javax.swing.JButton;


/**
 *
 * @author House
 */
public class Graficadora {
    public static plano plano;
    public static void main(String[] args) {
        Ventana frame = new Ventana();
        frame.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        frame.setBounds(300, 300, 510, 600);
        frame.setLayout(new BorderLayout());
        plano = new plano();
        //Crear metodo en plano de graficar solo un punto
        //Luego llamar a todo esto en el método graficar de nuestro programita
        //Y enviar un arrayList de los puntos a graficar, luego hacemos otro método graficar tabla
        //el cual llamará muchas veces al método graficar un punto somos bien chidos jajja
        JButton start = new JButton("Iniciar");
        start.addActionListener(frame);
        start.setText("Iniciar");
        frame.add(plano, BorderLayout.CENTER);
        frame.add(start, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
