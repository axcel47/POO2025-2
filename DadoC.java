
/**
 * Write a description of class DadoC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DadoC
{
     private int xPosition;
     private int yPosition;
     
    public DadoC(){
        xPosition = 310;
        yPosition = 120;
       
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
    // instance variables - replace the example below with your own
}