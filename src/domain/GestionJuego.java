package domain;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import ui.Juego;
import ui.Tablero;

public class GestionJuego {
    ArrayList<ObjetoJuego> objetos = new ArrayList<>();
    private JFrame juego; 

    private Bandeja bandeja; 

    public GestionJuego(JFrame juego){
        this.juego = juego; 
    }

    public void initBandeja(){
        generateBandeja();

        juego.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    bandeja.move(15);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    bandeja.move(-15);
                }
            }
        });
    }

    public void generateTartas(){
        for(int i=0; i<3; i++){
            Tarta tarta = new Tarta();
            objetos.add(tarta);
        }
    }

    public void generateBandeja(){
        Bandeja bandeja = new Bandeja();
        objetos.add(bandeja);
        this.bandeja = bandeja; 
    }

    public void recalcularPosicion(){
        // No puedes cambiar longitud array dentro de un bucle for/forEach
        int size = objetos.size();
        for(int i=0; i<size; i++){
            if (objetos.get(i) instanceof Tarta tarta){
                tarta.movTarta();
                tarta.detectarColision(bandeja);
                if (tarta.getY()+tarta.getAlto() > Juego.ALTO){
                    objetos.remove(i);
                    objetos.add(new Tarta());
                }
            } else if(objetos.get(i) instanceof Bandeja bandeja){
                // Colision
                
            }
        }
    }

    public void initJuego(){
        Tablero tablero = new Tablero(this);
        juego.add(tablero);

        generateTartas();
        initBandeja();
        tablero.initMov();
    }

    public ArrayList<ObjetoJuego> getObjetos(){
        return objetos; 
    }
}
