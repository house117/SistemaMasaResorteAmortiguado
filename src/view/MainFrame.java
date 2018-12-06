/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.plano;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Estado;
import model.OsciladorAmortiguado;
import oracle.jrockit.jfr.JFR;
import static view.Graficadora.planoEm;

/**
 *
 * @author House
 */
public class MainFrame extends JFrame {

    /*
    double h = 0.01; //pasito pasito suave suaveciito
        double w0 = 2.0; //frecuencia para las oscilaciones
        double g = 0.5; //Coeficiente de amortiguamiento
        double t = 20.0; //punto final a resolver de la ED
        //Ingresamos la posicion inicial
        double x0 = 1.5; //elongación (posición) inicial
        double v0 = 0.0; //velocidad inicial
        Estado e = new Estado(0.0, x0, v0); //estado inicial
     */
    JTextField txtH;
    JTextField txtW;
    JTextField txtG;
    JTextField txtT;
    JTextField txtX0;
    JTextField txtV0;
    JTextField txtTiempoInicial;
    JTextField txtDelay;
    JLabel lblH;
    JLabel lblW;
    JLabel lblG;
    JLabel lblT;
    JLabel lblx0;
    JLabel lblv0;
    JLabel lblDelay;
    JLabel lbltInicial;
    JPanel pnlCentro;
    JPanel pnlIzq;
    JPanel pnlDer;
    JButton btnObtenerGrafica;
    JButton btnObtenerEmulacion;
    JButton btnGraficaYEmulacion;
    JLabel titulo;
    JLabel titulo2;
    public Double arr[][];
    public MainFrame(Double arr[][]) {
        super("Sistema Masa Resorte Amortiguado By House & Dany");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        super.setLayout(new BorderLayout());
        super.setSize(500, 400);
        pnlCentro = new JPanel();
        pnlCentro.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlIzq = new JPanel();
        pnlIzq.setLayout(new BoxLayout(pnlIzq, BoxLayout.Y_AXIS));
        pnlDer = new JPanel();
        pnlDer.setLayout(new BoxLayout(pnlDer, BoxLayout.Y_AXIS));
        this.arr = arr;
        //creamos labels
        lblH = new JLabel("Paso:");
        lblW = new JLabel("Frecuencia de osilaciones:");
        lblG = new JLabel("Constante de amortiguamiento:");
        lblT = new JLabel("Tiempo final:");
        lblx0 = new JLabel("Posición/elongacion inicial:");
        lblv0 = new JLabel("Velocidad inicial:");
        lbltInicial = new JLabel("Tiempo Inicial:");
        lbltInicial = new JLabel("Delay de animación:");
        //creamos textFields
        txtH = new JTextField(10);
        txtW = new JTextField(10);
        txtG = new JTextField(10);
        txtT = new JTextField(10);
        txtX0 = new JTextField(10);
        txtV0 = new JTextField(10);
        txtTiempoInicial = new JTextField(10);
        txtDelay = new JTextField(10);
        //agregamos todos a pnl izq
        pnlIzq.add(lblH);
        pnlIzq.add(txtH);
        pnlIzq.add(lblW);
        pnlIzq.add(txtW);
        pnlIzq.add(lblG);
        pnlIzq.add(txtG);
        pnlIzq.add(lblT);
        pnlIzq.add(txtT);
        pnlIzq.add(lblx0);
        pnlIzq.add(txtX0);
        pnlIzq.add(lblv0);
        pnlIzq.add(txtV0);
        pnlIzq.add(lbltInicial);
        pnlIzq.add(txtTiempoInicial);

        //Creamos botones
        btnObtenerGrafica = new JButton("Obtener Gráfica");
        btnObtenerGrafica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtH.getText().isEmpty() || txtG.getText().isEmpty() || txtW.getText().isEmpty() || txtT.getText().isEmpty() || txtX0.getText().isEmpty()
                        || txtV0.getText().isEmpty() || txtTiempoInicial.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MainFrame.this, "¡Falta algún dato!, asegúrate de ingresar todos los datos", "Error entrada de datos", JOptionPane.WARNING_MESSAGE);
                } else {
                    /*double h = obtenerNumero(txtH.getText()); //pasito pasito suave suaveciito
                    double w0 = obtenerNumero(txtW.getText()); //frecuencia para las oscilaciones
                    double g = obtenerNumero(txtG.getText()); //Coeficiente de amortiguamiento
                    double t = obtenerNumero(txtT.getText()); //punto final a resolver de la ED
                    //Ingresamos la posicion inicial
                    double x0 = obtenerNumero(txtX0.getText()); //elongación (posición) inicial
                    double v0 = obtenerNumero(txtV0.getText()); //velocidad inicial
                    Estado estado = new Estado(obtenerNumero(txtTiempoInicial.getText()), x0, v0); //estado inicial
                    int delay = Integer.parseInt(String.format("%.0f", obtenerNumero(txtDelay)));*/
                    
                    double h = 0.01; //pasito pasito suave suaveciito
                    double w0 = 5.0; //frecuencia para las oscilaciones
                    double g = 0.5;
                    double t = 10.0; //punto final a resolver de la ED
                    //Ingresamos la posicion inicial
                    double x0 = 1.5; //elongación (posición) inicial
                    double v0 = 0.0; //velocidad inicial
                    int delay = 5;
                    Estado estado = new Estado(0.0, x0, v0); //estado inicial
                    
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
                    frame.setBounds(200, 200, 900, 680);
                    frame.setLayout(new BorderLayout());
                    plano plano = new plano(delay);
                    frame.add(plano, BorderLayout.CENTER);
                    JButton start = new JButton("Volver a ver");
                    
                    frame.add(start, BorderLayout.SOUTH);
                    frame.setVisible(true);
                    int tam = Integer.parseInt(String.format("%.0f", (t/h)));
                    MainFrame.this.arr = new Double[2][tam];
                    for (int i = 0; i < t / h; i++) {
                        OsciladorAmortiguado osciladorAmortiguado = new OsciladorAmortiguado(h, g, w0);
                        osciladorAmortiguado.resolver(estado);
                        MainFrame.this.arr[0][i] = estado.t*50;
                        MainFrame.this.arr[1][i] = estado.x*50;
                    }
                    System.out.println("Se termino de resolver");
                    plano.graficarArray(plano.getGraphics(), MainFrame.this.arr);
                    plano.setArr(MainFrame.this.arr);
                    start.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            plano.removeAll();
                            plano.graficarArray(plano.getGraphics(), MainFrame.this.arr);
                        }
                    });
                    //plano.graficarArray(plano.getGraphics(), MainFrame.this.arr);
                    
                }
            }
        });
        btnObtenerEmulacion = new JButton("Obtener Emulación");
        btnGraficaYEmulacion = new JButton("Obtener Gráfica y Emulación");

        //agregando botones a pnl Derecho
        pnlDer.add(btnObtenerGrafica);
        pnlDer.add(Box.createVerticalStrut(20));
        pnlDer.add(btnObtenerEmulacion);
        pnlDer.add(Box.createVerticalStrut(20));
        pnlDer.add(btnGraficaYEmulacion);
        //agregar paneles a pnlCentro
        pnlCentro.add(pnlIzq);

        pnlCentro.add(pnlDer);

        //Titulo
        titulo = new JLabel("Sistema Masa-Resorte");
        titulo.setFont(new Font("Century Gothic", Font.ITALIC, 36));
        titulo2 = new JLabel("Amortiguado");
        titulo2.setFont(new Font("Century Gothic", Font.ITALIC, 36));
        super.add(titulo, BorderLayout.NORTH);
        super.add(titulo2, BorderLayout.SOUTH);
        super.add(pnlCentro, BorderLayout.CENTER);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    public double obtenerNumero(String cadena) {
        double resultado;
        if (cadena.contains("/")) {
            String[] arrOfStr = cadena.split("/", 2);
            Double num = Double.parseDouble(arrOfStr[0]);
            Double denom = Double.parseDouble(arrOfStr[1]);
            resultado = num / denom;
            System.out.println("Valor es: " + resultado);
        } else {
            resultado = Double.parseDouble(cadena);
        }
        return resultado;
    }
}
