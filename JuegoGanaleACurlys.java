package com.example.guiganalealosdadoscurlys;

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
    private int fichas;
    private int conteo;
    public boolean finJuego;

    public JuegoGanaleACurlys(){
        int jugador = 0;
        fichas = 0;
        conteo = 0;
        dado1 = new DadoLCR();
        dado2 = new DadoLCR();
        finJuego = false;
    }


    public void procesarCara(){
        do{
            if (finJuego)
                break;
            cambiarFichas(dado1.getValor());
            cambiarFichas(dado2.getValor());

            if(dado1.getValor() == 'C' && dado2.getValor() == 'C'){
                dado2.setValor('O');
                break;
            }

            if (conteo == 10 || fichas >=6){
                finJuego = true;
                break;
            }

        }while (finJuego = false);


    }

    public void jugarTurno(){
        // Si el juego ya terminó, no hace nada.
        if (finJuego) {
            return;
        }

        // 1. Lanza los dados
        dado1.lanzar();
        dado2.lanzar();
        conteo++;

        // 2. Procesa el resultado de cada dado
        cambiarFichas(dado1.getValor());
        cambiarFichas(dado2.getValor());

        // 3. Verifica si el juego ha terminado después de este turno
        if (conteo >= 10 || fichas >= 6) {
            finJuego = true;
        }
    }
    public void cambiarFichas(char valor){
        if (valor == '*'){
            fichas += +1;
        } else if (valor == 'L'){
            fichas = fichas-1;
        } else if (valor == 'R'){
            fichas = fichas - 2;
        } else if (valor == 'C'){
            fichas = fichas*2;
        }
    }

    public void lanzar(){
        do{
            if (finJuego)
                break;
            dado1.lanzar();
            dado2.lanzar();
            conteo++;

            if (conteo > 11 || fichas >=6)
                finJuego = true;

        }while (finJuego = false);

    }

    public DadoLCR getValorDado1(){
        return dado1;
    }

    public DadoLCR getValorDado2(){
        return dado2;
    }

    public int getFichas(){
        return fichas;
    }

    public int getConteo(){
        return conteo;
    }

    public boolean getFinJuego(){
        return finJuego;
    }




    // public void lanzar() {
    // dado1.lanzar();
    // dado2.lanzar();
    // conteo++;

    // if (conteo == 10 || fichas >=6){
    // finJuego = true;
    // }

    // }
}