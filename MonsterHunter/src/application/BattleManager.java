package application;
import java.util.Random;

public class BattleManager {
	//*テーブルから取得
	int monster_id = 0;//*
	int element_player = 0;//*
	int elementValue_player = 0;//*

	Random rnd = new Random();
	public static void main(String[] args) {


	}

	public void PlayerAttack(int Parts_id) {
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
		HP_monster -= damage;

		if (HP_monster <= 0) {
			//シーン遷移(終了)
		}
		else {
			//HP_monsterを更新
			MonsterAttack();
		}
	}

	void MonsterAttack() {
		int HP_player = 0;//*
		int deffence_player = 0;//*
		int attackAction =  rnd.nextInt(10);//攻撃種類の決定
		int attack_monster = 0;//*
		int element = 0;//*

		float damage = attack_monster *(80/(float)(80 + deffence_player)) * ElementCompatibilityCalculation_EnemyAttack(element);
		HP_player -= damage;
		if (HP_player <= 0) {
			//シーン遷移(終了)
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
}
