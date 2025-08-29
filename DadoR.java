
/**
 * Write a description of class DadoR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DadoR {
    
    private int xPosition;
    private int yPosition;
    
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
    }