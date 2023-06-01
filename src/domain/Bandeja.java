package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import ui.Juego;

public class Bandeja extends ObjetoJuego {

    public Bandeja(){
        super(Generador.generaX(0, Juego.ANCHO-80), Juego.ALTO-80, 20, 80, Color.GRAY);
    }
    
    public void setX(int cantidad){
        if ((cantidad+ancho < Juego.ANCHO) && (cantidad > 0)){
            x = cantidad; 
        }        
    }

    public void move(int cantidad){
        setX(x+cantidad);
    }

    @Override
    public void pintar(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);

        g.setColor(Color.RED);
        Rectangle rectangle = getRectanguloInterseccion();
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public Rectangle getRectanguloInterseccion() {
        return new Rectangle(x, y, ancho, alto);
    }
    
}
