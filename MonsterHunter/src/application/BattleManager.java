package application;
import java.util.ArrayList;
import java.util.Random;

import jdbc.MonsterAttackStatusSearchDAO;
import jdbc.MonsterMainHpDAO;
import jdbc.MonsterPartsHpDAO;
import jdbc.PlayerHpDAO;
import jdbc.PlayerStatusSearchDAO;

public class BattleManager {
	//*テーブルから取得
	int monster_id = 0;//*
	int element_player = 0;//*
	int elementValue_player = 0;//*

	ArrayList<String> log = new ArrayList<String>();

	Random rnd = new Random();

	PlayerHpDAO playerHpDAO;
	MonsterMainHpDAO monsterMainHpDAO;
	MonsterPartsHpDAO monsterPartsDAO;
	MonsterAttackStatusSearchDAO monsterAttackStatusSearchDAO;
	PlayerStatusSearchDAO playerStatusSearchDAO;

	public int HP_player = playerHpDAO.selectFirstPlayerHp();


	public int PlayerAttack(String targetPartsName) {
		int targetPartsNum = PartsNumGet(targetPartsName);
		ArrayList<Integer> List_Hp = monsterPartsDAO.selectAllMonsterPartsHp();
		ArrayList<Integer> List_Hardness = monsterPartsDAO.selectAllMonsterPartsHardness();
		int HP_monster_main = monsterMainHpDAO.selectFirstMonsterMainHp();
		int HP_monster_parts = List_Hp.get(targetPartsNum);
		int hardness = List_Hardness.get(targetPartsNum);
		int attack_player = playerStatusSearchDAO.selectFirstWeaponAttackVal();
		int affinity = (int)(playerStatusSearchDAO.selectFirstWeaponCriticalRate() * 100);
		float affinityCorrection = 1;//会心補正
		int sharpness = 0;//*
		float sharpnessCorrection = 1;//切れ味補正

		if (rnd.nextInt(100) <= affinity) {
			affinityCorrection = 1.25f;
		}

		float damage = attack_player *( (float)hardness /100) * affinityCorrection * sharpnessCorrection + ElementDamage_PlayerAttack();
		HP_monster_main -= (int)damage;
		monsterMainHpDAO.updateFirstMonsterMainHp(HP_monster_main);
		HP_monster_parts -= (int)damage;
		SharpnessDecrease(sharpness);
		if (HP_monster_main <= 0) {
			return -1;//シーン遷移(終了)
		}
		else {
			monsterPartsDAO.updateMonsterPartsHp(HP_monster_parts, targetPartsName);
			return (int)damage;
		}
	}

	public int MonsterAttack() {

		ArrayList<Integer> List_attackPower = monsterAttackStatusSearchDAO.selectAllMonsterAttackVal();
		ArrayList<Float> List_attackMiss = monsterAttackStatusSearchDAO.selectAllMonsterAttackMissProb();

		int attackKind = rnd.nextInt(List_attackPower.size());
		int attack_monster = List_attackPower.get(attackKind);
		int attackMissPar = (int)(List_attackMiss.get(attackKind) * 100);
		int deffence_player = 0;//*
		int attackAction =  rnd.nextInt(10);//攻撃種類の決定
		int element = 0;//*
		float damage;
		if (rnd.nextInt(100) < attackMissPar) {
			return -2;//攻撃ミス時
		}
		damage = attack_monster *(80/(float)(80 + deffence_player)) * ElementCompatibilityCalculation_EnemyAttack(element);
		HP_player -= (int)damage;
		playerHpDAO.updateFirstPlayerHp(HP_player);
		if (HP_player <= 0) {
			return -1;//シーン遷移(終了)
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


	int PartsNumGet(String serchName) {
		ArrayList<String> partsName = monsterPartsDAO.selectAllMonsterPartsName();
		for(int i = 0;i < partsName.size();++i) {
			if (serchName.equals(partsName.get(i))) {
				return i;
			}
		}
		return -1;
	}

}
