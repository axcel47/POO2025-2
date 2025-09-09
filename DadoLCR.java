    
/**
 * Write a description of class DadoLCR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DadoLCR
{
    // instance variables - replace the example below with your own
    private Dado dado;
    private char valor;

    public DadoLCR(){
        dado= new Dado();
        char valor = 'O';

    }
    
    public void setValor(char valor){
        this.valor =  valor;
    }
    
    public char getValor(){
        int valorActualDado = dado.getValor();
        
        switch (valorActualDado){
            case 1:
            case 2:
            case 3:
                valor = '*';
                break;
            case 4:
                valor = 'L';
                break;
            case 5:
                valor = 'C';
                break;
            case 6:
                valor = 'R';
                break;
        }
        
        return valor;
    }
    
        public char lanzar(){
            char valor = 'X';
            
            dado.lanzar();
            valor=getValor();
            
            return valor;
        }
        
        // public char lanzar(){
        // char valor = 'X';

        // switch (dado.lanzar()){
            // case 1:
            // case 2:
            // case 3:
                // valor = '*';
                // break;
            // case 4:
                // valor = 'L';
                // break;
            // case 5:
                // valor = 'C';
                // break;
            // case 6:
                // valor = 'R';
                // break;
        // }
        // return valor;
    // }
    
    // public char lanzar(){
        // char valor = 'X';
        // int valorActualDado = dado.getValor();

        // switch (valorActualDado()){
            // case 1:
            // case 2:
            // case 3:
                // valor = '*';
                // break;
            // case 4:
                // valor = 'L';
                // break;
            // case 5:
                // valor = 'C';
                // break;
            // case 6:
                // valor = 'R';
                // break;
        // }
        // return valor;
    // }
    


    }

