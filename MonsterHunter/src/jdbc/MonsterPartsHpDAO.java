/**
* @file      MonsterPartsHpDAO.java
* @brief     「モンスター部位体力」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-12 12:25:26
* $Version   1.1
* $Revision  1.5
* @par       追加：createTable関係
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;
import static jdbc.consts.NormalizedTableName.MONSTERS_PARTS;
import static jdbc.consts.NormalizedTableName.MONSTERS_PARTS_NAMES;
import static jdbc.consts.DenormalizedTableName.MONSTERS_PARTS_HITPOINTS;
import static jdbc.consts.ColumnName.*;
import static jdbc.consts.IdxName.*;

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
    this.createMonsterPartsHpTable();
    this.createMonsterPartsHpIdx();
  }

  /**
   * @fn createMonsterPartsHpTable
   * @brief 「モンスター部位体力」テーブルの作成
   */
  private void createMonsterPartsHpTable() {
    String tableRecordDetailSQL = ""; // ! CREATE TABLE () の中身

    // SQLの作成

    // 作成する非正規化テーブルのカラムを指定
    // モンスターコード、モンスター部位コード、モンスター名、モンスター部位体力、モンスター肉質
    tableRecordDetailSQL += "AS ";
    tableRecordDetailSQL += "SELECT ";
    tableRecordDetailSQL += "PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "PARTS." + MONSTER_CODE.toLowerCase();
    tableRecordDetailSQL += " )";
    tableRecordDetailSQL += ", PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "PARTS_NAMES." + MONSTER_PART_CODE.toLowerCase();
    tableRecordDetailSQL += " )";
    tableRecordDetailSQL += ", PARTS_NAMES." + MONSTER_NAME.toLowerCase();
    tableRecordDetailSQL += ", PARTS." + MONSTER_PART_NAME.toLowerCase();
    tableRecordDetailSQL += ", PARTS." + MONSTER_PART_HITPOINT.toLowerCase();
    tableRecordDetailSQL += ", PARTS." + MONSTER_PART_HARDNESS.toLowerCase() + " ";

    // 結合検索の基となる正規化テーブルの名前を指定
    // 「モンスター部位名」「モンスター部位」テーブル
    tableRecordDetailSQL += "FROM ";
    tableRecordDetailSQL += MONSTERS_PARTS_NAMES.toLowerCase() + " PARTS_NAMES";
    tableRecordDetailSQL += ", " + MONSTERS_PARTS.toLowerCase() + " PARTS";

    // ユーザーが選択したモンスターコードのみを含むレコードを使用し、
    // テーブル「モンスター部位名」「モンスター部位」を主キー「モンスター部位コード」で結合
    tableRecordDetailSQL += " WHERE ";
    tableRecordDetailSQL += "PARTS." + MONSTER_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getMonsterCode();
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "PARTS." + MONSTER_PART_CODE.toLowerCase();
    tableRecordDetailSQL += " = PARTS_NAMES." + MONSTER_PART_CODE.toLowerCase();

    // テーブル名を指定して非正規化テーブルを作成
    // 「モンスター部位体力」テーブル
    super.createTable(MONSTERS_PARTS_HITPOINTS, tableRecordDetailSQL, MONSTER_ATTACK_CODE);
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
    super.createIdx(TODO, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE);
  }

  //////////////////////////////////////////////////
  // SELECT SELECT ALL
  //////////////////////////////////////////////////

  /**
   * @fn selectAllMonsterPartsCode
   * @brief 「モンスター部位体力」テーブルの、モンスター部位コードカラムの全てのフィールドを返す
   * @return 全モンスター部位コードのリスト
   */
  public ArrayList<String> selectAllMonsterPartsCode() {
    return super.selectColumn(MONSTER_PART_CODE, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE);
  }

  /**
   * @fn selectAllMonsterPartsName
   * @brief 「モンスター部位体力」テーブルの、モンスター部位名カラムの全てのフィールドを返す
   * @return 全モンスター部位名のリスト
   */
  public ArrayList<String> selectAllMonsterPartsName() {
    return super.selectColumn(MONSTER_PART_NAME, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE);
  }

  /**
   * @fn selectAllMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの全てのフィールドを返す
   * @return 全モンスター部位体力のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHp() {
    return super.toIntegerList(super.selectColumn(MONSTER_PART_HITPOINT, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE));
  }

  /**
   * @fn selectAllMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの全てのフィールドを返す
   * @return 全モンスター部位肉質のリスト
   */
  public ArrayList<Integer> selectAllMonsterPartsHardness() {
    return super.toIntegerList(super.selectColumn(MONSTER_PART_HARDNESS, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE));
  }

  //////////////////////////////////////////////////
  // UPADATE
  //////////////////////////////////////////////////

  /**
   * @fn updateMonsterPartsName
   * @brief 「モンスター部位体力」テーブルの、モンスター部位名カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsName(String monsterPartsName, String primaryKey) {
    this.updateField(monsterPartsName, MONSTER_PART_NAME, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE, primaryKey);
  }

  /**
   * @fn updateMonsterPartsHp
   * @brief 「モンスター部位体力」テーブルの、モンスター部位体力カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHp(int monsterPartsHp, String primaryKey) {
    this.updateField(Integer.toString(monsterPartsHp), MONSTER_PART_HITPOINT, MONSTERS_PARTS_HITPOINTS, MONSTER_CODE,
        primaryKey);
  }

  /**
   * @fn updateMonsterPartsHardness
   * @brief 「モンスター部位体力」テーブルの、モンスター部位肉質カラムの先頭のフィールドを更新
   */
  public void updateMonsterPartsHardness(int monsterPartsHardness, String primaryKey) {
    this.updateField(Integer.toString(monsterPartsHardness), MONSTER_PART_HARDNESS, MONSTERS_PARTS_HITPOINTS,
        MONSTER_CODE, primaryKey);
  }
}
