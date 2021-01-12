package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class BattleController {

	MenuController menuCon;
	BattleManager battleMan;

	ArrayList<String> monsterParts = new ArrayList<String>();
	ArrayList<String> logList = new ArrayList<String>();

	private int turnNum=1;
	private int nowSharpness;
	private int flag=0;

	@FXML
	private Label Attack_Log;

	@FXML
	private Label HP_Value;

	@FXML
	private Label Sharpness_Value;

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
		if(Parts_name.getValue()==null) {
			return;
		}
		if(flag==1)
			return;
		int n=0;
		//test用
//		int dmg = 20;

		int dmg = battleMan.PlayerAttack(Parts_name.getValue());
		
		logList.add(n,turnNum+"：プレイヤーの攻撃--->"+Parts_name.getValue()+"に攻撃した！");
		logUpdate();
		++n;
		//モンスターの体力が０なら終了
		if(dmg==-1) {
			finish(true);
			return;
		}

		if(battleMan.sharpnessColor!=nowSharpness) {
			logList.add(n,turnNum+"：切れ味が落ちた");
			logUpdate();
			nowSharpness = battleMan.sharpnessColor;
			Sharpness_Value.setText("切れ味："+nowSharpness);
			++n;
		}

		//test
//		if(4!=nowSharpness) {
//			logList.add(n,turnNum+"：切れ味が落ちた");
//			logUpdate();
//			nowSharpness = 4;
//			Sharpness_Value.setText("切れ味："+nowSharpness);
//			++n;
//		}


		//モンスターの攻撃
		dmg = battleMan.MonsterAttack();

		//test用
//		dmg = -1;


		if(dmg==-2) {
			logList.add(n,turnNum+"：モンスターの攻撃--->あなたは攻撃をかわした");
			logUpdate();
		}else if(dmg==-1) {
			logList.add(n,turnNum+"：モンスターの攻撃--->力尽きました");
			logUpdate();
			finish(false);
			return;
		}else {
			logList.add(n,turnNum+"：モンスターの攻撃--->あなたは"+dmg+"ダメージ受けた");
			logUpdate();
		}

		HP_Value.setText("体力："+battleMan.HP_player);
//		HP_Value.setText("体力："+80);
		logList.add(0,"\n\n\n************************");
		logUpdate();
		turnNum++;
	}

	@FXML
	void OnFinishButton(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void OnReturnButton(ActionEvent event) {
		new Main().changeView("Menu.fxml");
	}

	@FXML
	void initialize() {
		ReturnButton.setVisible(false);
		FinishButton.setVisible(false);

		battleMan = new BattleManager(Main.selectWeapon, Main.selectArmor, Main.selectMonster);
		HP_Value.setText("体力：" + battleMan.HP_player);
		nowSharpness = battleMan.sharpnessColor;
		Sharpness_Value.setText("切れ味：" + nowSharpness);

		monsterParts = battleMan.getPartsName();

		//test用
//		for(int i=0;i<5;++i) {
//			monsterParts.add(""+i);
//		}
//		HP_Value.setText("体力："+100);
//		nowSharpness = 5;
//		Sharpness_Value.setText("切れ味"+nowSharpness);

		Parts_name.getItems().setAll(monsterParts);


	}

	// 終了時に呼び出される (勝ち:true 負け:0false)
	void finish(boolean clear) {
		logList.add(0,"************************");
		logUpdate();
		if(clear) {
			logList.add(0,"あなたは"+Main.selectMonster+"を倒しました");
			logList.add(1,"クエストクリア！！");
		}else {
			logList.add(0,"あなたは力尽きました");
			logList.add(1,"クエスト失敗");
		}
		logUpdate();

		ReturnButton.setVisible(true);
		FinishButton.setVisible(true);
		flag=1;

	}

	//log更新
	void logUpdate() {
		String Log="";
		for(int i=0; i<logList.size();++i) {
			Log += logList.get(i)+"\n";
		}
		Attack_Log.setText(Log);

	}
}
