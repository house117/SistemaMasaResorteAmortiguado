/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import model.Estado;
import model.OsciladorAmortiguado;
import static view.Graficadora.planoEm;
import view.MainFrame;
import view.Ventana;

/**
 *
 * @author House
 */
public class Aplicacion {
        public static plano plano;
    public static planoEmulador planoEm;
    public static Double arr[][];
    public static void main(String[] args) {
        double h = 0.01; //pasito pasito suave suaveciito
        double w0 = 5.0; //frecuencia para las oscilaciones
        double g = 0.5;
        double t = 20.0; //punto final a resolver de la ED
        //Ingresamos la posicion inicial
        double x0 = 1.5; //elongación (posición) inicial
        double v0 = 0.0; //velocidad inicial
        Estado e = new Estado(0.0, x0, v0); //estado inicial
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame ventana = new MainFrame(arr);
                
            }
        });
        //osilaciones
        /*System.out.println("Oscilaciones libres");
        Oscilador oscilador = new Oscilador(h, w0);
        for (int i = 0; i < t/h; i++) {
            oscilador.resolver(e);
            System.out.println(e.x);
        }
        System.out.println("Posición aproximada "+e.x);
        System.out.println("velocidad aproximada "+e.v);
        //Valor exacto
        double fi = Math.atan(w0*x0/v0);
        double A = x0/Math.sin(fi);
        double x = A*Math.sin(w0*t+fi);
        double v = A*w0*Math.cos(w0*t+fi);
        System.out.println("posición exacta "+x);
        System.out.println("Velocidad exacta "+v);*/
        //Osilaciones Amortiguadas
        /*System.out.println("Osilaciones amortiguadas");
        OsciladorAmortiguado osciladorAmortiguado = new OsciladorAmortiguado(h, g, w0);
       
        for(int i=0; i<t/h; i++){
            osciladorAmortiguado.resolver(e);
            System.out.println(e.x);
        }*/
    }
}
