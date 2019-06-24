package lesson4.HW.FX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextField txtField;
    @FXML
    public TextArea txtArea;
    @FXML
    public Button sendMsg;
    @FXML
    public Button clear;
    @FXML
    public MenuItem exit;
    @FXML
    public MenuItem sendMenu;
    @FXML
    public MenuItem clearMenu;

    public void sendMessage() {
        if (!txtField.getText().trim().isEmpty()) {
            txtArea.appendText( txtField.getText() + "\n");
            txtField.clear();
        }
    }

    public void exit() {
        System.exit(0);
    }

    public void clear() {
        txtArea.clear();
    }
}
