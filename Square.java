import java.awt.*;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 7.0
 */

public class Square
{
    private int size;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new square at default position with default color.
     */
    public Square()
    {
        size = 60;
        xPosition = 310;
        yPosition = 120;
        color = "red";
        isVisible = false;
    }

    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Move the square a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the square a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the square a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    
    /**
     * Move the square a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the square horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the square vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the square horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the square vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize)
    {
        erase();
        size = newSize;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /**
     * Draw the square with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                        new Rectangle(xPosition, yPosition, size, size));
            canvas.wait(10);
        }
    }

    /**
     * Erase the square on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    private int getXPosition(){
        return xPosition;
    }
    
    private int getYPosition(){
        return yPosition;
    }
    
    public void pintarC(){
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
        dado1.moveHorizontal(xPosition-30);
        dado1.moveVertical(yPosition-20);
        
        Square dado2 = new Square();
        dado2.changeSize(size*4-2);
        dado2.changeColor("white");
        dado2.moveHorizontal(xPosition-29);
        dado2.moveVertical(yPosition-19);
        
        Square c1 = new Square();
        c1.changeSize(size);
        c1.changeColor(color);
        c1.moveHorizontal(xPosition);
        c1.moveVertical(yPosition);
        
        Square c2 = new Square();
        c2.changeSize(size);
        c2.changeColor(color);
        c2.moveHorizontal(xPosition);
        c2.moveVertical(yPosition + size);
        
        Square c3 = new Square();
        c3.changeSize(size);
        c3.changeColor(color);
        c3.moveHorizontal(xPosition);
        c3.moveVertical(yPosition + 2 * size);
        
        Square c4 = new Square();
        c4.changeSize(size);
        c4.changeColor(color);
        c4.moveHorizontal(xPosition + size);
        c4.moveVertical(yPosition);
        
        Square c5 = new Square();
        c5.changeSize(size);
        c5.changeColor(color);
        c5.moveHorizontal(xPosition + size);
        c5.moveVertical(yPosition + 2 * size);
       
        dado1.makeVisible();
        dado2.makeVisible();
        c1.makeVisible();
        c2.makeVisible();
        c3.makeVisible();
        c4.makeVisible();
        c5.makeVisible();
        c1.makeVisible();
        c2.makeVisible();
        c3.makeVisible();
        c4.makeVisible();
        c5.makeVisible();
    
    }
    
    
    public void pintarL(){
        int size = 40 ;
        String color = "blue";
        boolean isVisible = true;
     
        int areaDado = 150;
        int xDado = (500 - areaDado) / 2;
        int yDado = (300 - areaDado) /2;
         
        int xInicial = xDado + (areaDado - 4*size) /2 ;
        int yInicial = yDado + (areaDado - 5*size) /2 ;
        
        Square dado1 = new Square();
        dado1.changeSize(size*4);
        dado1.changeColor("black");
        dado1.moveHorizontal(xPosition-30);
        dado1.moveVertical(yPosition-20);
        
        Square dado2 = new Square();
        dado2.changeSize(size*4-2);
        dado2.changeColor("white");
        dado2.moveHorizontal(xPosition-29);
        dado2.moveVertical(yPosition-19);
        
        Square c1 = new Square();
        c1.changeSize(size);
        c1.changeColor(color);
        c1.moveHorizontal(xPosition);
        c1.moveVertical(yPosition);
                
        Square c2 = new Square();
        c2.changeSize(size);
        c2.changeColor(color);
        c2.moveHorizontal(xPosition);
        c2.moveVertical(yPosition + size);
        
        Square c3 = new Square();
        c3.changeSize(size);
        c3.changeColor(color);
        c3.moveHorizontal(xPosition);
        c3.moveVertical(yPosition + 2 * size);
        
        Square c4 = new Square();
        c4.changeSize(size);
        c4.changeColor(color);
        c4.moveHorizontal(xPosition + size);
        c4.moveVertical(yPosition + 2 * size);
        
        dado1.makeVisible();
        dado2.makeVisible();
        c1.makeVisible();
        c2.makeVisible();
        c3.makeVisible();
        c4.makeVisible();
        
    }
        
   public void pintarR(){
         int size = 20;
         String color = "blue";
        
         
         //Dado con respecto a la medida de canvas
         int areaDado = 150;
         int xDado = (500 - areaDado) / 2;
         int yDado = (300 - areaDado) /2;
         
         
         int xInicial = xDado + (areaDado - 4*size) /2 ;
         int yInicial = yDado + (areaDado - 5*size) /2 ;
         
        Square dado1 = new Square();
        dado1.changeSize(size*6);
        dado1.changeColor("black");
        dado1.moveHorizontal(xDado+size);
        dado1.moveVertical(yDado+size);
        dado1.makeVisible();
        
        Square dado2 = new Square();
        dado2.changeSize(size*6-2);
        dado2.changeColor("white");
        dado2.moveHorizontal(xDado+size+1);
        dado2.moveVertical(yDado+size+1);
        dado2.makeVisible();
         
         Square r1 = new Square();
         r1.changeSize(size);
         r1.changeColor(color);
         r1.moveHorizontal(xInicial + 0);
         r1.moveVertical(yInicial + 0);
         r1.makeVisible();
         
         Square r2 = new Square();
         r2.changeSize(size);
         r2.changeColor(color);
         r2.moveHorizontal(xInicial + 20);
         r2.moveVertical(yInicial + 0);
         r2.makeVisible();
         
         Square r3 = new Square();
         r3.changeSize(size);
         r3.changeColor(color);
         r3.moveHorizontal(xInicial + 40);
         r3.moveVertical(yInicial + 0);
         r3.makeVisible();
         
         Square r4 = new Square();
         r4.changeSize(size);
         r4.changeColor(color);
         r4.moveHorizontal(xInicial + 60);
         r4.moveVertical(yInicial + 0);
         r4.makeVisible();
         
         Square r5 = new Square();
         r5.changeSize(size);
         r5.changeColor(color);
         r5.moveHorizontal(xInicial + 0);
         r5.moveVertical(yInicial + 20);
         r5.makeVisible();
         
         Square r6 = new Square();
         r6.changeSize(size);
         r6.changeColor(color);
         r6.moveHorizontal(xInicial + 60);
         r6.moveVertical(yInicial + 20);
         r6.makeVisible();
         
         Square r7 = new Square();
         r7.changeSize(size);
         r7.changeColor(color);
         r7.moveHorizontal(xInicial + 0);
         r7.moveVertical(yInicial + 40);
         r7.makeVisible();
         
         Square r8 = new Square();
         r8.changeSize(size);
         r8.changeColor(color);
         r8.moveHorizontal(xInicial + 20);
         r8.moveVertical(yInicial + 40);
         r8.makeVisible();
         
         Square r9 = new Square();
         r9.changeSize(size);
         r9.changeColor(color);
         r9.moveHorizontal(xInicial + 40);
         r9.moveVertical(yInicial + 40);
         r9.makeVisible();
         
         Square r10 = new Square();
         r10.changeSize(size);
         r10.changeColor(color);
         r10.moveHorizontal(xInicial + 60);
         r10.moveVertical(yInicial + 40);
         r10.makeVisible();
         
         Square r11 = new Square();
         r11.changeSize(size);
         r11.changeColor(color);
         r11.moveHorizontal(xInicial + 0);
         r11.moveVertical(yInicial + 60);
         r11.makeVisible();
         
         Square r12 = new Square();
         r12.changeSize(size);
         r12.changeColor(color);
         r12.moveHorizontal(xInicial + 40);
         r12.moveVertical(yInicial + 60);
         r12.makeVisible();
         
         Square r13 = new Square();
         r13.changeSize(size);
         r13.changeColor(color);
         r13.moveHorizontal(xInicial + 0);
         r13.moveVertical(yInicial + 80);
         r13.makeVisible();
         
         Square r14 = new Square();
         r14.changeSize(size);
         r14.changeColor(color);
         r14.moveHorizontal(xInicial + 60);
         r14.moveVertical(yInicial + 80);
         r14.makeVisible();
        
     
     }
     
     
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
    

