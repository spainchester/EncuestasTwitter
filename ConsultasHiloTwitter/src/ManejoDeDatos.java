import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class ManejoDeDatos extends JFrame {

     static String datos[] = new String[10000000];
     static JTextArea areaSI, areaNO;
     static JProgressBar tablaPorcentajeNo, tablaPorcentajeSi;

    public ManejoDeDatos() {//componentes
        getContentPane().setLayout(null);
        setSize(885, 600);
        setTitle("Encuesta Twitter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //Componente generales
        JPanel general = new JPanel();
        general.setLayout(null);
        general.setSize(1000, 1000);
        general.setLocation(0, 0);
        general.setBackground(new Color(247, 125, 25));

        JLabel titulo = new JLabel("Encuesta twitter");
        titulo.setFont(new Font("ARIAL", Font.BOLD, 25));
        titulo.setForeground(Color.BLUE);
        titulo.setSize(400, 30);
        titulo.setLocation(300, 20);
        general.add(titulo);

        //SeccionSI
        JLabel seccionSI = new JLabel("SI");
        seccionSI.setFont(new Font("ARIAL", Font.BOLD, 24));
        seccionSI.setForeground(Color.BLACK);
        seccionSI.setSize(200, 30);
        seccionSI.setLocation(30, 80);
        general.add(seccionSI);

        areaSI = new JTextArea();
        areaSI.setSize(300, 400);
        areaSI.setLocation(30, 120);
        areaSI.setFont(new Font("ARIAL", Font.ITALIC, 18));
        areaSI.setLineWrap(true);
        areaSI.setWrapStyleWord(true);
        areaSI.setEditable(false);
        general.add(areaSI);

        JPanel tablaSi = new JPanel();
        tablaSi.setSize(50, 400);
        tablaSi.setBackground(new Color(207, 225, 255));
        tablaSi.setLocation(330, 120);
        tablaPorcentajeSi = new JProgressBar(0, 10000000);
        tablaPorcentajeSi.setOrientation(JProgressBar.VERTICAL);
        tablaPorcentajeSi.setStringPainted(true);
        tablaPorcentajeSi.setLocation(0, 5);
        Border barraSi = BorderFactory.createTitledBorder("SI");
        tablaPorcentajeSi.setBorder(barraSi);
        tablaPorcentajeSi.setVisible(true);
        tablaSi.add(tablaPorcentajeSi);
        general.add(tablaSi);


        //SeccionNo
        JLabel seccionNO = new JLabel("NO");
        seccionNO.setFont(new Font("ARIAL", Font.BOLD, 24));
        seccionNO.setForeground(Color.BLACK);
        seccionNO.setSize(200, 30);
        seccionNO.setLocation(500, 80);
        general.add(seccionNO);

        areaNO = new JTextArea();
        areaNO.setSize(300, 400);
        areaNO.setLocation(500, 120);
        areaNO.setFont(new Font("ARIAL", Font.BOLD, 16));
        areaNO.setLineWrap(true);
        areaNO.setWrapStyleWord(true);
        areaNO.setEditable(false);
        general.add(areaNO);

        JPanel tablaNo = new JPanel();
        tablaNo.setSize(50, 400);
       // tablaNo.setBackground(new Color(207, 225, 255));
        tablaNo.setLocation(800, 120);
        tablaPorcentajeNo = new JProgressBar(0, 10000000);
        tablaPorcentajeNo.setOrientation(JProgressBar.VERTICAL);
        tablaPorcentajeNo.setStringPainted(true);
        tablaPorcentajeNo.setLocation(0, 0);
        Border barraNo = BorderFactory.createTitledBorder("NO");
        tablaPorcentajeNo.setBorder(barraNo);
        tablaPorcentajeNo.setVisible(true);
        tablaNo.add(tablaPorcentajeNo);
        general.add(tablaNo);

        add(general);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManejoDeDatos();

                Thread hilo1 = new Thread(new BaseDeDatos(datos, areaSI, areaNO));
                Thread hilo2 = new Thread(new Datos(datos , tablaPorcentajeSi, tablaPorcentajeNo));
                hilo1.start();
                hilo2.start();
            }
        });
    }
}

