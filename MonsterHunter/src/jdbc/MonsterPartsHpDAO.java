/**
* @file      MonsterPartsHpDAO.java
* @brief     「モンスター部位体力」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 18:21:43
* $Version   1.1
* $Revision  1.1
* @par       編集：カラム、テーブル名を命名規則に合わせて変更（https://qiita.com/genzouw/items/35022fa96c120e67c637）
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;

/**
 * @class MonsterPartsHpDAO
 * @brief 「モンスター部位体力」テーブルのDAO
 */
public class MonsterPartsHpDAO extends BattleDAO {

  /**
   * @fn MonsterPartsHpDAO
   * @brief 「モンスター部位体力」テーブルの作成を行うコンストラクタ
   */
  public MonsterPartsHpDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    createMonsterPartsHpTable();
  }

  /**
   * @fn createMonsterPartsHpTable
   * @brief 「モンスター部位体力」テーブルの作成
   */
  private void createMonsterPartsHpTable() {
    // TODO
  }

  /**
   * @fn dropMonsterPartsHpTable
   * @brief 「モンスター部位体力」テーブルの削除
   */
  public void dropMonsterPartsHpTable() {
    // TODO
  }

  //////////////////////////////////////////////////
  // SELECT SELECT ALL
  //////////////////////////////////////////////////

  /**
   * @fn selectAllMonsterPartsName
   * @brief 「モンスター部位体力」テーブルの、モンスター部位名カラムの全てのフィールドを返す
   * @return 全モンスター部位名のリスト
   */
  public ArrayList<String> selectAllMonsterPartsName() {
    String columnName = "monster_part_name";
    String tableName = "monster_parts_hitpoints";
    String primaryKeyColumnName = "monster_code";
    return selectColumn(columnName, tableName, primaryKeyColumnName);
  }

  /**
   * @fn selectAllMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの全てのフィールドを返す
   * @return 全モンスター部位体力のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHp() {
    String columnName = "monster_part_hitpoint";
    String tableName = "monster_parts_hitpoints";
    String primaryKeyColumnName = "monster_code";
    return this.toIntegerList(selectColumn(columnName, tableName, primaryKeyColumnName));
  }

  /**
   * @fn selectAllMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの全てのフィールドを返す
   * @return 全モンスター部位肉質のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHardness() {
    String columnName = "monster_part_hardness";
    String tableName = "monster_parts_hitpoints";
    String primaryKeyColumnName = "monster_code";
    return this.toIntegerList((selectColumn(columnName, tableName, primaryKeyColumnName)));
  }

  //////////////////////////////////////////////////
  // UPADATE
  //////////////////////////////////////////////////

  /**
   * @fn updateMonsterPartsName
   * @brief 「モンスター部位体力」テーブルの、モンスター部位名カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsName(String monsterPartsName, String primaryKey) {
    String columnName = "monster_part_name";
    String tableName = "monster_parts_hitpoints";
    String primaryKeyColumnName = "monster_code";
    this.updateField(monsterPartsName, columnName, tableName, primaryKeyColumnName, primaryKey);
  }

  /**
   * @fn updateMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHp(int monsterPartsHp, String primaryKey) {
    String columnName = "monster_part_hitpoint";
    String tableName = "monster_parts_hitpoints";
    String primaryKeyColumnName = "monster_code";
    this.updateField(Integer.toString(monsterPartsHp), columnName, tableName, primaryKeyColumnName, primaryKey);
  }

  /**
   * @fn updateMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHardness(int monsterPartsHardness, String primaryKey) {
    String columnName = "monster_part_hardness";
    String tableName = "monster_parts_hitpoints";
    String primaryKeyColumnName = "monster_code";
    this.updateField(Integer.toString(monsterPartsHardness), columnName, tableName, primaryKeyColumnName, primaryKey);
  }
}
