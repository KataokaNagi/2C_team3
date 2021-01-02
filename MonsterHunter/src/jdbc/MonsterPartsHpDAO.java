/**
* @file      MonsterPartsHpDAO.java
* @brief     「モンスター部位体力」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 19:31:59
* $Version   1.1
* $Revision  1.3
* @par       リファクタリング：テーブル名とPK名をメンバ変数へ
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;

/**
 * @class MonsterPartsHpDAO
 * @brief 「モンスター部位体力」テーブルのDAO
 */
public class MonsterPartsHpDAO extends BattleDAO {

  private final String TABLE_NAME = "monster_parts_hitpoints";
  private final String PRIMARY_KEY_COLUMN_NAME = "monster_code";

  /**
   * @fn MonsterPartsHpDAO
   * @brief 「モンスター部位体力」テーブルの作成を行うコンストラクタ
   */
  public MonsterPartsHpDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    this.createMonsterPartsHpTable();
    this.createMonsterPartsHpIdx();
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

  /**
   * @fn createMonsterPartsHpIdx
   * @brief テーブルのインデックスを張る
   */
  private void createMonsterPartsHpIdx() {
    String idxName = "idx_" + TABLE_NAME;
    String idxColumnName = PRIMARY_KEY_COLUMN_NAME;
    super.createIdx(idxName, TABLE_NAME, idxColumnName);
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
    return super.selectColumn(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectAllMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの全てのフィールドを返す
   * @return 全モンスター部位体力のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHp() {
    String columnName = "monster_part_hitpoint";
    return super.toIntegerList(super.selectColumn(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectAllMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの全てのフィールドを返す
   * @return 全モンスター部位肉質のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHardness() {
    String columnName = "monster_part_hardness";
    return super.toIntegerList(super.selectColumn(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
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
    this.updateField(monsterPartsName, columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME, primaryKey);
  }

  /**
   * @fn updateMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHp(int monsterPartsHp, String primaryKey) {
    String columnName = "monster_part_hitpoint";
    this.updateField(Integer.toString(monsterPartsHp), columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME, primaryKey);
  }

  /**
   * @fn updateMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHardness(int monsterPartsHardness, String primaryKey) {
    String columnName = "monster_part_hardness";
    this.updateField(Integer.toString(monsterPartsHardness), columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME,
        primaryKey);
  }
}
