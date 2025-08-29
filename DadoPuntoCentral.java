
/**
 * Write a description of class DadoPuntoCentral here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DadoPuntoCentral
{

    private int xPosition;
    private int yPosition;
    
    public void pintarPuntoCentral(){
        final  int size = 40 ;
        final  String color = "blue";
        final  boolean isVisible = true;
        
        int areaDado = 150;
        int xDado = (500 - areaDado) / 2;
        int yDado = (300 - areaDado) /2;
         
        int xInicial = xDado + (areaDado - 4*size) /2 ;
        int yInicial = yDado + (areaDado - 5*size) /2 ;
        
        Square dado1 = new Square();
        dado1.changeSize(size*4);
        dado1.changeColor("black");
        dado1.moveHorizontal(xPosition);
        dado1.moveVertical(yPosition);
        
        Square dado2 = new Square();
        dado2.changeSize(size*4-2);
        dado2.changeColor("white");
        dado2.moveHorizontal(xPosition+1);
        dado2.moveVertical(yPosition+1);
        
        Circle punto = new Circle();
        punto.changeSize(size);
        punto.changeColor(color);
        punto.moveHorizontal(xInicial+xPosition - size);
        punto.moveVertical(yInicial+yPosition+size-5);
        
        
        dado1.makeVisible();
        dado2.makeVisible();
        punto.makeVisible();
        
    }
    
    
}