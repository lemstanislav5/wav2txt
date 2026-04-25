package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println("🚀 JavaFX start() метод вызван");

        try {
            System.out.println("📁 Пытаюсь загрузить sample.fxml...");

            // Пробуем загрузить FXML
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            System.out.println("✅ sample.fxml успешно загружен");

            // Создаем сцену
            Scene scene = new Scene(root, 400, 300);
            System.out.println("✅ Сцена создана");

            // Настраиваем окно
            primaryStage.setTitle("Мое первое JavaFX приложение");
            primaryStage.setScene(scene);
            primaryStage.show();

            System.out.println("✅ Окно отображено. Приложение работает!");

        } catch (Exception e) {
            System.err.println("❌ ОШИБКА при запуске JavaFX: " + e.getMessage());
            e.printStackTrace();

            // Показываем диалог ошибки
            System.err.println("\n📋 Возможные причины:");
            System.err.println("1. Отсутствует файл sample.fxml в папке com/");
            System.err.println("2. JavaFX модули не добавлены в проект");
            System.err.println("3. Путь к файлу FXML указан неверно");
        }
    }

    public static void main(String[] args) {

        launch(args);

        System.out.println("🔵 main() завершил работу (это сообщение появится только после закрытия окна)");
    }
}