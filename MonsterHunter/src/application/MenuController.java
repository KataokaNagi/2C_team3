package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MenuController {

    @FXML
    private ComboBox<String> weapon_field;

    @FXML
    private ComboBox<String> armor_field;

    @FXML
    private ComboBox<String> monster_field;

    @FXML
    private Button StartButton;

    @FXML
    private Button EndButton;

    @FXML
    private Label Attack_value;

    @FXML
    private Label Defense_value;

    @FXML
    void OnEndButton(ActionEvent event) {

    }

    @FXML
    void OnStartButton(ActionEvent event) {

    }

    @FXML
    void selectArmor(ActionEvent event) {

    }

    @FXML
    void selectWeapon(ActionEvent event) {

    }

}
