import java.util.Random;

/**
 * Write a description of class JuegoGanaleACurlys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JuegoGanaleACurlys
{
    private DadoLCR dado1;
    private DadoLCR dado2;
    private int jugador;
    private int fichas;
    private int conteo;
    private boolean finJuego;


    public JuegoGanaleACurlys(){
        int jugador = 0;
        fichas = 0;
        conteo = 0;
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        finJuego = false;
    }
   
    
        
    public void procesarCara(){
        cambiarFichas(dado1.getValor());
        cambiarFichas(dado2.getValor());
         if(dado1.getValor() == 'C' && dado2.getValor() == 'C'){
             dado2.setValor('O');
         }
    

        if (fichas >= 6){
            finJuego = true;
        }
    }
    
    private void cambiarFichas(char valor){
        if (valor == '*'){
                fichas ++;
            } else if (valor == 'L'){
                fichas= fichas - 1;
            } else if (valor == 'R'){
                fichas = 2*fichas;
            } else if (valor == 'C'){
                fichas = fichas - 2;  
            }
    }
    
      public void lanzar() {
        dado1.lanzar();
        dado2.lanzar();
        conteo++;
        
        if (conteo == 10){
            finJuego = true;
        }
    } 
}
 
