/**
* @file      MonsterAttackStatusSearchDAO.java
* @brief     「モンスター攻撃ステータス検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-31 02:28:02
* $Version   1.0
* $Revision  1.4
* @par       追加：createTableメソッドの完成
* @par       変更予定：BattleDAOにgetMonsterCodeメソッドを実装
*/

package jdbc;

import java.util.ArrayList;

/**
 * @class MonsterAttackStatusSearchDAO
 * @brief 「モンスター攻撃ステータス検索」テーブルのDAO
 */
public class MonsterAttackStatusSearchDAO extends BattleDAO {

  private final String FROM_TABLE_NAME = "monsters_attacks";
  private final String TABLE_NAME = "monster_attack_statuses_searches";

  private final String MONSTER_CODE = "monster_code";

  private final String PRIMARY_KEY_COLUMN_NAME = "monster_attack_code";
  private final String MONSTER_ATTACK_NAME = "monster_attack_name";
  private final String MONSTER_ATTACK_VAL = "monster_attack_value";
  private final String MONSTER_ATTACK_MISS_PROB = "monster_attack_miss_probability";

  /**
   * @fn MonsterAttackStatusSearchDAO
   * @brief 「モンスター攻撃ステータス検索」テーブルの作成を行うコンストラクタ
   */
  public MonsterAttackStatusSearchDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    this.MonsterAttackStatusSearchTable();
    this.createMonsterAttackStatusSearchIdx();
  }

  /**
   * @fn MonsterAttackStatusSearchTable
   * @brief 「モンスター攻撃ステータス検索」テーブルの作成
   */
  private void MonsterAttackStatusSearchTable() {
    String tableRecordDetailSQL = ""; // ! CREATE TABLE () の中身

    // SQLの作成
    tableRecordDetailSQL += "AS ";
    tableRecordDetailSQL += "SELECT ";
    tableRecordDetailSQL += "ATTACKS." + PRIMARY_KEY_COLUMN_NAME + ", ";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_ATTACK_NAME + ", ";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_ATTACK_VAL + ", ";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_ATTACK_MISS_PROB + " ";
    tableRecordDetailSQL += "FROM" + FROM_TABLE_NAME + " ATTACKS";
    tableRecordDetailSQL += "WHERE";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_CODE;
    tableRecordDetailSQL += " = ATTACKS." + super.getMonsterCode();

    // テーブルの作成
    super.createTable(TABLE_NAME, tableRecordDetailSQL, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn dropPlayerStatusSearchTable
   * @brief 「モンスター攻撃ステータス検索」テーブルの削除
   */
  public void dropMonsterAttackStatusSearchTable() {
    // TODO
  }

  /**
   * @fn createMonsterAttackStatusSearchIdx
   * @brief テーブルのインデックスを張る
   */
  private void createMonsterAttackStatusSearchIdx() {
    String idxName = "idx_" + TABLE_NAME;
    String idxColumnName = PRIMARY_KEY_COLUMN_NAME;
    super.createIdx(idxName, TABLE_NAME, idxColumnName);
  }

  //////////////////////////////////////////////////
  // 以降、全て selectAll
  //////////////////////////////////////////////////

  /**
   * @fn selectAllMonsterAttackName
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃名カラムの全てのフィールドを返す
   * @return モンスター攻撃名のリスト
   */
  public ArrayList<String> selectAllMonsterAttackName() {
    String columnName = MONSTER_ATTACK_NAME;
    return super.selectColumn(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectAllMonsterAttackVal
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃力カラムの全てのフィールドを返す
   * @return モンスター攻撃力のリスト
   */
  public ArrayList<Integer> selectAllMonsterAttackVal() {
    String columnName = MONSTER_ATTACK_VAL;
    return super.toIntegerList(super.selectColumn(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectAllMonsterAttackMissProb
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃ミス確率カラムの全てのフィールドを返す
   * @return モンスター攻撃ミス確率のリスト
   */
  public ArrayList<Float> selectAllMonsterAttackMissProb() {
    String columnName = MONSTER_ATTACK_MISS_PROB;
    return super.toFloatList(super.selectColumn(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }
}
