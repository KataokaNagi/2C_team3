/**
* @file      MonsterMainHpDAO.java
* @brief     「モンスター総合体力」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-12 12:25:15
* $Version   1.1
* $Revision  1.5
* @par       追加：createTable関係
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import static jdbc.consts.NormalizedTableName.MONSTERS;
import static jdbc.consts.DenormalizedTableName.MONSTERS_MAIN_HITPOINTS;
import static jdbc.consts.ColumnName.*;
import static jdbc.consts.IdxName.*;

/**
 * @class MonsterMainHpDAO
 * @brief 「モンスター総合体力」テーブルのDAO
 */
public class MonsterMainHpDAO extends BattleDAO {

  /**
   * @fn MonsterMainHpDAO
   * @brief 「モンスター総合体力」テーブルの作成を行うコンストラクタ
   */
  public MonsterMainHpDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    this.createMonsterMainHpTable();
    this.createMonsterMainHpIdx();
  }

  /**
   * @fn createMonsterMainHpTable
   * @brief 「モンスター総合体力」テーブルの作成
   */
  private void createMonsterMainHpTable() {
    String tableRecordDetailSQL = ""; // ! CREATE TABLE () の中身

    // SQLの作成

    // 作成する非正規化テーブルのカラムを指定
    // モンスターコード、モンスター名、モンスター体力
    tableRecordDetailSQL += "AS ";
    tableRecordDetailSQL += "SELECT ";
    tableRecordDetailSQL += "PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "MONSTERS." + MONSTER_CODE.toLowerCase();
    tableRecordDetailSQL += " )";
    tableRecordDetailSQL += ", MONSTERS." + MONSTER_NAME.toLowerCase();
    tableRecordDetailSQL += ", MONSTERS." + MONSTER_MAIN_HITPOINT.toLowerCase() + " ";

    // 結合検索の基となる正規化テーブルの名前を指定
    // 「モンスター」テーブル
    tableRecordDetailSQL += "FROM ";
    tableRecordDetailSQL += MONSTERS.toLowerCase() + " MONSTERS ";

    // ユーザーが選択したモンスターコードのみを含むレコードを検索
    tableRecordDetailSQL += "WHERE ";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_CODE.toLowerCase() + " ";
    tableRecordDetailSQL += "= " + super.getMonsterCode();

    // テーブル名を指定して非正規化テーブルを作成
    // 「モンスター総合体力」テーブル
    super.createTable(MONSTERS_MAIN_HITPOINTS, tableRecordDetailSQL, MONSTER_CODE);
  }

  /**
   * @fn dropMonsterMainHpTable
   * @brief 「モンスター総合体力」テーブルの削除
   */
  public void dropMonsterMainHpTable() {
    // TODO
  }

  /**
   * @fn createMonsterMainHpIdx
   * @brief テーブルのインデックスを張る
   */
  private void createMonsterMainHpIdx() {
    super.createIdx(TODO, MONSTERS_MAIN_HITPOINTS, MONSTER_CODE);
  }

  /**
   * @fn selectFirstMonsterCode
   * @brief 「モンスター総合体力」テーブルの、モンスターコードカラムの先頭のフィールドを返す
   * @return モンスターコードの先頭のフィールド
   */
  public String selectFirstMonsterCode() {
    return super.selectFirstField(MONSTER_CODE, MONSTERS_MAIN_HITPOINTS, MONSTER_CODE);
  }

  /**
   * @fn selectFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを返す
   * @return モンスター体力の先頭のフィールド
   */
  public int selectFirstMonsterMainHp() {
    return Integer.parseInt(super.selectFirstField(MONSTER_MAIN_HITPOINT, MONSTERS_MAIN_HITPOINTS, MONSTER_CODE));
  }

  /**
   * @fn updateFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを更新
   */
  public void updateFirstMonsterMainHp(int monsterMainHp) {
    super.updateFirstField(Integer.toString(monsterMainHp), MONSTER_MAIN_HITPOINT, MONSTERS_MAIN_HITPOINTS,
        MONSTER_CODE);
  }
}
