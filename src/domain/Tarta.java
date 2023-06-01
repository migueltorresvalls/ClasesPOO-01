package domain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import ui.Juego;

public class Tarta extends ObjetoJuego{

    private int velocidad = Generador.generaVelocidad();

    private int yInicial; 
    private boolean rebote = false; 

    public Tarta(){
        super(30, 30, Color.CYAN);
        yInicial = Generador.generaX(0, Juego.ALTO/3);
        int x = Generador.generaX(0, Juego.ANCHO-30);

        setX(x);
        setY(yInicial);
        velocidad = Generador.generaVelocidad();
    }

    public void setY(int y){
        this.y = y; 
    }

    public void movTarta(){
        if (rebote){
            if (y > yInicial+50){
                setY(y-velocidad);
            } else {
                rebote = false; 
                yInicial += 50;
            }
        } else {
            setY(y+velocidad);
        }
    }

    public void detectarColision(Bandeja bandeja){
        if (getRectanguloInterseccion().intersects(bandeja.getRectanguloInterseccion())){
            rebote = true; 
        }
    }

    @Override
    public void pintar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, ancho, alto);

        g.setColor(Color.RED);
        Rectangle rectangle = getRectanguloInterseccion();
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    @Override
    public Rectangle getRectanguloInterseccion() {
        return new Rectangle(x, y, ancho, alto);
    }
}
