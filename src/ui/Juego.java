package ui;
import javax.swing.JFrame;

import domain.GestionJuego;

public class Juego extends JFrame
{
    public final static int ANCHO = 600;
    public final static int ALTO = 600;

    public static boolean JUGANDO = true; 

    public Juego()
    {
        GestionJuego gestion = new GestionJuego(this);
        gestion.initJuego();
        this.setTitle("JManzanas");

        //this.setFocusable(true); //Descomentar, si el control de los eventos de teclado lo queremos hacer aquí

        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new Juego().setVisible(true);
    }
}
