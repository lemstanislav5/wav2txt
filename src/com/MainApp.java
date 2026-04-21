package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Загружаем FXML файл с интерфейсом
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // Создаем сцену с размером 400x300
        Scene scene = new Scene(root, 400, 300);

        // Настраиваем окно
        primaryStage.setTitle("Мое первое JavaFX приложение");
        primaryStage.setScene(scene);
        primaryStage.show(); // Показываем окно
    }

    public static void main(String[] args) {
        launch(args); // Запускаем JavaFX
    }
}