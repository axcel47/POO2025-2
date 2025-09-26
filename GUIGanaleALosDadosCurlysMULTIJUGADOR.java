package com.example.guiganalealosdadoscurlysmultijugador;

//Un botón al lado de una etiqueta usas un HBox.
//Una etiqueta encima de un campo de texto usas un VBox.
//"null" no es que el valor sea 0, SINO que no hay numero.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GUIGanaleALosDadosCurlysMULTIJUGADOR extends Application {

    public void start(Stage stage) throws IOException {
        BorderPane pane = new BorderPane();
        Font font = Font.font("Arial", FontWeight.BOLD, 18);
        Font fontPuntos = Font.font("Arial", FontWeight.BOLD, 22);
        Font fontContador = Font.font("Arial", FontWeight.NORMAL, 14);
        Font fontInstrucciones = Font.font("Arial", FontWeight.NORMAL, 12);


        GanaleACurlysMultijugador juego = new GanaleACurlysMultijugador();

        TextInputDialog numJugadoresDialog = new TextInputDialog("");
        numJugadoresDialog.setTitle("Configuracion del Juego");
        numJugadoresDialog.setHeaderText("Cantidad de jugadores");
        numJugadoresDialog.setContentText("Cantidad de jugadores: ");

       String textoNumJugadores = numJugadoresDialog.showAndWait().orElse(null);

        if (textoNumJugadores != null) {
            int numJugadores = 0;
            boolean esNumeroValido = true;

            for (char cantidad : textoNumJugadores.toCharArray()) {
                if (cantidad < '0' || cantidad > '9') {
                    esNumeroValido = false;
                    break;
                }
            }

            if (esNumeroValido) {
                for (int i = 0; i < textoNumJugadores.length(); i++) {
                    numJugadores = numJugadores * 10 + (textoNumJugadores.charAt(i) - '0');
                }

                if (numJugadores > 0) {
                    for (int i = 1; i <= numJugadores; i++) {
                        TextInputDialog nombreJugadorDialog = new TextInputDialog("Jugador " + i);
                        nombreJugadorDialog.setTitle("Configuración del Juego");
                        nombreJugadorDialog.setHeaderText("Nombre del Jugador " + i);
                        nombreJugadorDialog.setContentText("Introduce el nombre:");

                        // Se aplica la misma lógica: se convierte el Optional a un String o null
                        String nombreTemporal = nombreJugadorDialog.showAndWait().orElse(null);

                        String nombreFinal;
                        // Se usa un if-else clásico para manejar el caso de "Cancelar"
                        if (nombreTemporal != null) {
                            nombreFinal = nombreTemporal;
                        } else {
                            nombreFinal = "Jugador " + i;
                        }
                        juego.agregarJugador(nombreFinal);
                    }
                } else {
                    return; // Termina si el número es 0 o negativo
                }
            } else {
                return; // Termina si no se introdujo un número
            }
        } else {
            return; // Termina si se presiona "Cancelar"
        }


        // --- Lista para guardar las etiquetas de puntos y poder actualizarlas ---
        ArrayList<Label> etiquetasPuntos = new ArrayList<>();

        // --- Contenedor horizontal para todos los paneles de jugador ---
        HBox panelJugadores = new HBox(20);
        panelJugadores.setAlignment(Pos.CENTER);

        // --- Bucle para crear un panel por cada jugador ---
        for (JugadorGanaleACurlys jugador : juego.getJugadores()) {
            Label marcadorJugador = new Label(jugador.getNombre());
            marcadorJugador.setFont(font);
            Label puntosJugador = new Label(String.valueOf(jugador.getFichas()));
            puntosJugador.setFont(fontPuntos);

            etiquetasPuntos.add(puntosJugador);

            VBox panelJugador = new VBox(5);
            panelJugador.getChildren().addAll(marcadorJugador, puntosJugador);
            panelJugador.setAlignment(Pos.CENTER);
            panelJugador.setMinWidth(120);

            panelJugadores.getChildren().add(panelJugador);
        }


        // --- Panel de Instrucciones ---
        String textoInstrucciones = "[*] Recibe una ficha\n" +
                "[L] Pierde una ficha\n" +
                "[C] Duplica fichas (solo una vez por turno)\n" +
                "[R] Pierde dos fichas";
        Label labelInstrucciones = new Label(textoInstrucciones);
        labelInstrucciones.setFont(fontInstrucciones);
        VBox panelInstrucciones = new VBox(5);
        panelInstrucciones.getChildren().add(labelInstrucciones);


        // Etiqueta para el resultado de la tirada
        Label tiradaResultado = new Label("Presiona Lanzar");
        tiradaResultado.setFont(fontPuntos);
        VBox panelResultado = new VBox(5);
        panelResultado.getChildren().add(tiradaResultado);
        panelResultado.setAlignment(Pos.CENTER);

        // Area Central
        Label marcadorTurno = new Label("Turno de:");
        marcadorTurno.setFont(font);
        Label jugadorDeTurno = new Label(juego.getJugadorActual().getNombre());
        jugadorDeTurno.setFont(fontPuntos);
        VBox panelTurno = new VBox(5);
        panelTurno.getChildren().addAll(marcadorTurno, jugadorDeTurno);
        panelTurno.setAlignment(Pos.CENTER);

        Label contadorLanzadas = new Label("Lanzada #0");
        contadorLanzadas.setFont(fontContador);


        // Botón Lanzar y FUNCIONAMIENTO
        Button lanzar = new Button("Lanzar");
        lanzar.setFont(font);
        lanzar.setOnAction(e -> {
            JugadorGanaleACurlys jugadorQueTiro = juego.getJugadorActual();

            juego.jugarTurno();

            for (int i = 0; i < juego.getJugadores().size(); i++) {
                Label etiquetaActual = etiquetasPuntos.get(i);
                int fichasActuales = juego.getJugadores().get(i).getFichas();
                etiquetaActual.setText(String.valueOf(fichasActuales));
            }

            String resultado = "Tirada " + jugadorQueTiro.getNombre() + ": " + "[" + juego.getValorDado1() + "]" + " y " + "[" + juego.getValorDado2() + "]";
            tiradaResultado.setText(resultado);

            jugadorDeTurno.setText(juego.getJugadorActual().getNombre());

            contadorLanzadas.setText("Lanzada #" + jugadorQueTiro.getConteoTiros());

            boolean juegoHaTerminado = false;
            for(JugadorGanaleACurlys jugador : juego.getJugadores()) {
                if(jugador.finJuego()) {
                    juegoHaTerminado = true;
                    break;
                }
            }

            if (juegoHaTerminado) {
                lanzar.setVisible(false);

                // Enontrar al ganador
                JugadorGanaleACurlys ganador = juego.getJugadores().get(0);
                for(int i = 1; i < juego.getJugadores().size(); i++) {
                    if (juego.getJugadores().get(i).getFichas() > ganador.getFichas()) {
                        ganador = juego.getJugadores().get(i);
                    }
                }

                tiradaResultado.setText("Juego Terminado\n Ganador: " + ganador.getNombre());
                jugadorDeTurno.setText("-");
            }
        });


        // Posicionamientos del Area central
        Label labelL = new Label("L");
        labelL.setPrefSize(50, 50);
        labelL.setAlignment(Pos.CENTER);
        Label labelC = new Label("C");
        labelC.setPrefSize(50, 50);
        labelC.setAlignment(Pos.CENTER);
        Label labelR = new Label("R");
        labelR.setPrefSize(50, 50);
        labelR.setAlignment(Pos.CENTER);

        HBox controles = new HBox(10);
        controles.setAlignment(Pos.CENTER);
        controles.getChildren().addAll(lanzar, labelL, labelC, labelR);

        VBox centroContenedor = new VBox(15);
        centroContenedor.setAlignment(Pos.CENTER);
        centroContenedor.getChildren().addAll(panelTurno, controles, contadorLanzadas);


        // Ubicacion de paneles
        pane.setTop(panelJugadores);
        pane.setLeft(panelInstrucciones);
        pane.setBottom(panelResultado);
        pane.setCenter(centroContenedor);
        pane.setPadding(new Insets(20));

        Scene scene = new Scene(pane, 900, 600);
        stage.setTitle("MULTIJUGADOR JuegoGanaleACurlys");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

