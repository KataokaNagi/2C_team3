package application;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import jdbc.MenuDAO;

public class MenuController {

	//MenuDAOからArrayListを取得
//	MenuDAO MenuDao = new MenuDAO();
//	ArrayList<String> weaponArry = MenuDao.selectAllWeaponName();
//	ArrayList<String> armorArry = MenuDao.selectAllArmorName();
//	ArrayList<String> monsterArry = MenuDao.selectAllMonsterName();
//	ArrayList<Integer> AttackArry = MenuDao.selectAllWeaponAttackVal();
//	ArrayList<Integer> DeffenseArry = MenuDao.selectAllArmorDiffenceVal();

	//テスト用
	ArrayList<String> weaponArry = new ArrayList<String>(Arrays.asList("あ","い","う","え","お"));
	ArrayList<String> armorArry = new ArrayList<String>(Arrays.asList("か","き","く","け","こ"));
	ArrayList<String> monsterArry = new ArrayList<String>(Arrays.asList("さ","し","す","せ","そ"));
	ArrayList<Integer> AttackArry = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	ArrayList<Integer> DeffenseArry = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));


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
	void OnEndButton(ActionEvent event) { //終了ボタン
		System.exit(0);
	}

	@FXML
	void OnStartButton(ActionEvent event) { // スタートボタン
		if (weapon_field.getValue() == null || armor_field.getValue() == null || monster_field == null) { // 武器防具モンスターどれか一つでも選択されていない場合
			Error.setVisible(true);
			return;
		}
		new Main().changeView("Battle.fxml");// バトル画面へ遷移
	}

	@FXML
	void selectArmor(ActionEvent event) {
		int n = armorArry.indexOf(armor_field.getValue());
		if(n==-1)
			return;
		Defense_value.setText("防御力："+DeffenseArry.get(n));
	}

	@FXML
	void selectWeapon(ActionEvent event) {
		int n = weaponArry.indexOf(weapon_field.getValue());
		if(n==-1)
			return;
		Attack_value.setText("攻撃力："+AttackArry.get(n));
	}

	@FXML
	void initialize() {

		// ComboBoxにそれぞれの値をセット
		weapon_field.getItems().setAll(weaponArry);
		armor_field.getItems().setAll(armorArry);
		monster_field.getItems().setAll(monsterArry);


		Error.setVisible(false);
	}



}
