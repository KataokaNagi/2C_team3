package application;
import java.util.ArrayList;
import java.util.Random;

import jdbc.MonsterPartsHpDAO;
import jdbc.PlayerHpDAO;

public class BattleManager {
	//*テーブルから取得
	int monster_id = 0;//*
	int element_player = 0;//*
	int elementValue_player = 0;//*

	ArrayList<String> log = new ArrayList<String>();

	Random rnd = new Random();

	PlayerHpDAO playerHpDAO;

	public int PlayerAttack(int Parts_id) {
		MonsterPartsHpDAO monsterPartsHpDAO;
		int HP_monster = 0;//*
		int hardness = 0;//*
		int attack_player = 0;//*
		int affinity = 0;//*
		float affinityCorrection = 1;//会心補正
		int sharpness = 0;//*
		float sharpnessCorrection = 1;//切れ味補正

		if (rnd.nextInt(100) <= affinity) {
			affinityCorrection = 1.25f;
		}

		float damage = attack_player *( (float)hardness /100) * affinityCorrection * sharpnessCorrection + ElementDamage_PlayerAttack();
		HP_monster -= (int)damage;
		SharpnessDecrease(sharpness);
		if (HP_monster <= 0) {
			//シーン遷移(終了)
			return -1;
		}
		else {
			//HP_monsterを更新
			return (int)damage;
		}
	}

	public int MonsterAttack() {
		int HP_player = playerHpDAO.selectFirstPlayerHp();//*
		int deffence_player = 0;//*
		int attackAction =  rnd.nextInt(10);//攻撃種類の決定
		int attack_monster = 0;//*
		int element = 0;//*

		float damage = attack_monster *(80/(float)(80 + deffence_player)) * ElementCompatibilityCalculation_EnemyAttack(element);
		HP_player -= (int)damage;
		playerHpDAO.updateFirstPlayerHp(HP_player);
		if (HP_player <= 0) {
			//シーン遷移(終了)
			return -1;
		}
		else {
			return (int)damage;
		}
	}

	float ElementDamage_PlayerAttack() {
		float result = 0;
		int elementResistance = 0;//*
		result = ((float)elementValue_player/10) * ((float)elementResistance/100);
		return result;
	}


	float ElementCompatibilityCalculation_EnemyAttack(int attackElement) {
		float result = 0;
		int elementResistance = 0;//*

		result = (100 - elementResistance)/100;
		return result;
	}



	int SharpnessDecrease(int sharpness) {
		sharpness -= 1;
		if (sharpness < 0) {
			//次の色に変更
		}
		return sharpness;
	}
}
