package domain;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class ObjetoJuego {
    protected int x; 
    protected int y; 

    protected int alto; 
    protected int ancho; 

    protected Color color; 
    

    public ObjetoJuego(int x, int y, int alto, int ancho, Color color){
        this.x = x; 
        this.y = y; 
        this.alto = alto; 
        this.ancho = ancho; 
        this.color = color; 
    }

    public ObjetoJuego(int alto, int ancho, Color color){
        this(0,0, alto, ancho, color);
    }

    public void setX(int x){
        this.x = x; 
    }

    public void setY(int y){
        this.y = y; 
    }

    public int getY(){
        return y; 
    }

    public int getAlto(){
        return alto; 
    }

    public abstract void pintar(Graphics g);
    public abstract Rectangle getRectanguloInterseccion();
}
