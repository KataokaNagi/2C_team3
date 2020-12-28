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
    private Label Error;


    @FXML
    void OnEndButton(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void OnStartButton(ActionEvent event) {
    	if(weapon_field.getValue()==null || armor_field.getValue()==null || monster_field==null) {
    		Error.setVisible(true);
    		return;
    	}
    	new Main().changeView("Battle.fxml");
    }

    @FXML
    void selectArmor(ActionEvent event) {

    }

    @FXML
    void selectWeapon(ActionEvent event) {
    	if(armor_field.getValue()==null)
    		return;
    	System.out.println("ok");
    }

    @FXML
    void initialize() {
    	for(int i=0;i<10;++i) {
    		weapon_field.getItems().add(""+i);
    	}
    	for(int i = 0;i<10;++i) {
    		armor_field.getItems().add(""+i);
    	}
    	for(int i=0;i<10;++i) {
    		monster_field.getItems().add(""+i);
    	}

    	Error.setVisible(false);
    }

}
