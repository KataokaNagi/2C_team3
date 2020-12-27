/**
* @file      MonsterAttackStatusSearchDAO.java
* @brief     「モンスター攻撃ステータス検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-28 00:54:39
* $Version   1.0
* $Revision  1.0
* @par       ADD: 新規作成
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;

/**
 * @class MonsterAttackStatusSearchDAO
 * @brief 「モンスター攻撃ステータス検索」テーブルのDAO
 */
public class MonsterAttackStatusSearchDAO extends BattleDAO {
  /**
   * @fn MonsterAttackStatusSearchDAO
   * @brief 「モンスター攻撃ステータス検索」テーブルの作成を行うコンストラクタ
   */
  public MonsterAttackStatusSearchDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    MonsterAttackStatusSearchTable();
  }

  /**
   * @fn MonsterAttackStatusSearchTable
   * @brief 「モンスター攻撃ステータス検索」テーブルの作成
   */
  private void MonsterAttackStatusSearchTable() {
    // TODO
  }

  /**
   * @fn dropPlayerStatusSearchTable
   * @brief 「モンスター攻撃ステータス検索」テーブルの削除
   */
  public void dropMonsterAttackStatusSearchTable() {
    // TODO
  }

  //////////////////////////////////////////////////
  // 以降、全て selectFirst
  //////////////////////////////////////////////////

  /**
   * @fn selectAllMonsterAttackName
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃名カラムの全てのフィールドを返す
   * @return モンスター攻撃名のリスト
   */
  public ArrayList<String> selectAllMonsterAttackName() {
    String columnName = "monster_attack_name";
    String tableName = "monster_attack_status_search";
    String primaryKeyColumnName = "monster_attack_code";
    return selectColumn(columnName, tableName, primaryKeyColumnName);
  }

  /**
   * @fn selectAllMonsterAttackVal
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃力カラムの全てのフィールドを返す
   * @return モンスター攻撃力のリスト
   */
  public ArrayList<Integer> selectAllMonsterAttackVal() {
    String columnName = "monster_attack_val";
    String tableName = "monster_attack_status_search";
    String primaryKeyColumnName = "monster_attack_code";
    return this.toIntegerList(selectColumn(columnName, tableName, primaryKeyColumnName));
  }

  /**
   * @fn selectAllMonsterAttackMissProb
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃ミス確率カラムの全てのフィールドを返す
   * @return モンスター攻撃ミス確率のリスト
   */
  public ArrayList<Float> selectAllMonsterAttackMissProb() {
    String columnName = "monster_attack_miss_prob";
    String tableName = "monster_attack_status_search";
    String primaryKeyColumnName = "monster_attack_code";
    return this.toFloatList(selectColumn(columnName, tableName, primaryKeyColumnName));
  }
}
