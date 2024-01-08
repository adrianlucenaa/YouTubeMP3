package org.example.model;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Simulacion extends Application {

    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simulación Descarga YouTube a MP3");

        statusLabel = new Label("Presiona el botón para simular la descarga y conversión");

        Button startButton = new Button("Iniciar Simulación");
        startButton.setOnAction(e -> iniciarSimulacion());

        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(statusLabel, startButton);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void iniciarSimulacion() {
        // Inicia dos tareas simultáneas para simular la descarga y la conversión
        Task<Void> downloadTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                updateStatus("Descargando video...");
                // Simular descarga (cambiar según necesites)
                Thread.sleep(5000); // Simula 5 segundos de descarga
                updateStatus("Descarga completa");
                return null;
            }
        };

        Task<Void> conversionTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                updateStatus("Convirtiendo a MP3...");
                // Simular conversión (cambiar según necesites)
                Thread.sleep(3000); // Simula 3 segundos de conversión
                updateStatus("Conversión a MP3 completada");
                return null;
            }
        };

        // Ejecuta las tareas en hilos separados
        Thread downloadThread = new Thread(downloadTask);
        Thread conversionThread = new Thread(conversionTask);

        downloadThread.start();
        conversionThread.start();
    }

    private void updateStatus(String message) {
        // Actualiza el estado en la interfaz gráfica
        statusLabel.setText(message);
    }

    public static void main(String[] args) {
        launch(args);
    }
}