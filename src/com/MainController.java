package com;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    // Привязываем к элементам из FXML (id должны совпадать)
    @FXML
    private TextField nameField;

    @FXML
    private Label welcomeLabel;

    private int clickCount = 0;

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
