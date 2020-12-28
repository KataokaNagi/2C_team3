package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class BattleController {

    @FXML
    private Label Attack_Log;

    @FXML
    private Label HP_Value;

    @FXML
    private Label Sharpmess_Value;

    @FXML
    private Button AttackButton;

    @FXML
    private ComboBox<String> Parts_name;

    @FXML
    private Button ReturnButton;

    @FXML
    private Button FinishButton;

    @FXML
    void OnAttackButton(ActionEvent event) {

    }

    @FXML
    void OnFinishButton(ActionEvent event) {

    }

    @FXML
    void OnReturnButton(ActionEvent event) {
    }

    @FXML
    void initialize() {
    	ReturnButton.setVisible(false);
    	FinishButton.setVisible(false);
    }

    public void finish(boolean crear) {

    }


}
