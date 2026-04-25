package com;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    public String time;
    // Привязываем к элементам из FXML (id должны совпадать)
    @FXML
    private TextField nameField;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label newtime;

    private int clickCount = 0;
    @FXML
    private void initialize() {
        System.out.println("🔵 main() начал работу");

        // 1. Получаем время через API
        System.out.println("🔵 Вызов GetTime.get()...");
        String time = GetTime.get();
        if (!time.isEmpty()) {
            System.out.println("🔵 time..." + time);
            newtime.setText(time);
        } else {
            newtime.setText("Время недоступно!");
        }

        // 2. Запускаем JavaFX
        System.out.println("🔵 Запуск JavaFX приложения...");
        System.out.println("🔵 launch(args) будет вызван сейчас");
    }
    // Метод, который вызывается при нажатии кнопки
    @FXML
    private void onButtonClick() {
        String name = nameField.getText();
        clickCount++;

        if (name.isEmpty()) {
            welcomeLabel.setText("Привет, незнакомец! (Клик #" + clickCount + ")");
        } else {
            welcomeLabel.setText("Привет, " + name + "! (Клик #" + clickCount + ")");
        }
    }
}
