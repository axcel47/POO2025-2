package com.example.guiganalealosdadoscurlys;

//Un botón al lado de una etiqueta usas un HBox.
//Una etiqueta encima de un campo de texto usas un VBox.


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIGanaleALosDadosCurlysSOLITARIO extends Application {

    public void start(Stage stage) throws IOException {
        BorderPane pane = new BorderPane();
        Font font = Font.font("Arial", FontWeight.BOLD, 18);
        Font fontPuntos = Font.font("Arial", FontWeight.BOLD, 22); // Fuente para resultados
        Font fontContador = Font.font("Arial", FontWeight.NORMAL, 14); // Fuente para el contador
        // --- NUEVO: Fuente para las instrucciones ---
        Font fontInstrucciones = Font.font("Arial", FontWeight.NORMAL, 12);

        JuegoGanaleACurlys juego = new JuegoGanaleACurlys();

        // --- Panel Superior (Jugador 1) ---
        Label marcadorJugador1 = new Label("Puntos del jugador 1");
        marcadorJugador1.setFont(font);
        Label puntosJugador1 = new Label ("0"); // Inicia en 0
        puntosJugador1.setFont(fontPuntos);
        VBox panelJugador1 = new VBox(5);
        panelJugador1.getChildren().addAll(marcadorJugador1, puntosJugador1);
        panelJugador1.setAlignment(Pos.CENTER);


        // --- NUEVO: Panel de Instrucciones ---
        String textoInstrucciones = "[*] Recibe una ficha\n" +
                "[L] Pierde una ficha\n" +
                "[C] Duplica fichas (solo una vez por turno)\n" +
                "[R] Pierde dos fichas";
        Label labelInstrucciones = new Label(textoInstrucciones);
        labelInstrucciones.setFont(fontInstrucciones);
        VBox panelInstrucciones = new VBox(5);
        panelInstrucciones.getChildren().add(labelInstrucciones);


        // --- Panel Inferior (Lanzadas Anteriores) ---
        Label marcadorCentral = new Label("Lanzadas anteriores"); // Texto cambiado
        marcadorCentral.setFont(font);
        Label puntosCentro = new Label ("-"); // Valor inicial
        VBox panelCentral = new VBox(5);
        panelCentral.getChildren().addAll(marcadorCentral,puntosCentro);
        panelCentral.setAlignment(Pos.CENTER);


        // --- Etiqueta para la tirada actual ---
        Label tiradaActual = new Label("-");
        tiradaActual.setFont(fontPuntos);

        // --- Etiqueta para el conteo de tiradas ---
        Label conteoLanzadas = new Label("Lanzada #0");
        conteoLanzadas.setFont(fontContador);


        // --- Botón Lanzar y Lógica Principal ---
        Button lanzar = new Button("Lanzar");
        lanzar.setFont(font);
        lanzar.setOnAction(e -> {
            juego.jugarTurno();

            String nuevosPuntos = String.valueOf(juego.getFichas());
            puntosJugador1.setText(nuevosPuntos);

            String valorDado1 = juego.getValorDado1().toString();
            String valorDado2 = juego.getValorDado2().toString();
            String resultadoTirada = "Tirada: " + "[" + valorDado1 +"]" + " y " + "[" + valorDado2 + "]";

            puntosCentro.setText(tiradaActual.getText());
            tiradaActual.setText(resultadoTirada);

            conteoLanzadas.setText("Lanzada #" + juego.getConteo());

            if (juego.getFinJuego()) {
                lanzar.setDisable(true);
                tiradaActual.setText("Fin del Juego");
                puntosCentro.setText("Fichas finales: " + nuevosPuntos);
            }
        });


        // --- Área Central ---
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

        VBox centroContenedor = new VBox(10);
        centroContenedor.setAlignment(Pos.CENTER);
        centroContenedor.getChildren().addAll(tiradaActual, controles, conteoLanzadas);


        // --- Ensamblaje Final ---
        pane.setTop(panelJugador1);
        pane.setBottom(panelCentral);
        pane.setCenter(centroContenedor);
        // --- NUEVO: Se añade el panel de instrucciones a la izquierda ---
        pane.setLeft(panelInstrucciones);

        // Se ajustan las alineaciones y el padding para que se vea bien
        BorderPane.setAlignment(panelJugador1, Pos.CENTER);
        pane.setPadding(new Insets(20));


        Scene scene = new Scene(pane, 800, 600);
        stage.setTitle("SOLITARIO JuegoGanaleACurlys");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

