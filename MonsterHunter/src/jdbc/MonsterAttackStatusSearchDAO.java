/**
* @file      MonsterAttackStatusSearchDAO.java
* @brief     「モンスター攻撃ステータス検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-12 12:25:05
* $Version   1.0
* $Revision  1.6
* @par       追加：createTable関係
* @par       変更予定：BattleDAOにgetMonsterCodeメソッドを実装
*/

package jdbc;

import java.util.ArrayList;

import jdbc.consts.DenormalizedTableName;
import jdbc.consts.IdxName;

import static jdbc.consts.NormalizedTableName.MONSTERS_ATTACKS;
import static jdbc.consts.DenormalizedTableName.MONSTERS_ATTACKS_STATUSES_SEARCH;
import static jdbc.consts.ColumnName.*;
import static jdbc.consts.IdxName.IDX_MONSTERS_ATTACKS_STATUSES_SEARCH;

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

    // 作成する非正規化テーブルのカラムを指定
    // モンスターコード、モンスター攻撃コード、モンスター攻撃名、モンスター攻撃力、モンスター攻撃ミス確率
    tableRecordDetailSQL += "AS ";
    tableRecordDetailSQL += "SELECT ";
    tableRecordDetailSQL += "PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_CODE.toLowerCase();
    tableRecordDetailSQL += " )";
    tableRecordDetailSQL += ", PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_ATTACK_CODE.toLowerCase();
    tableRecordDetailSQL += " )";
    tableRecordDetailSQL += ", ATTACKS." + MONSTER_ATTACK_NAME.toLowerCase();
    tableRecordDetailSQL += ", ATTACKS." + MONSTER_ATTACK_VALUE.toLowerCase();
    tableRecordDetailSQL += ", ATTACKS." + MONSTER_ATTACK_MISS_PROBABILITY.toLowerCase() + " ";

    // 結合検索の基となる正規化テーブルの名前を指定
    // 「モンスター攻撃」テーブル
    tableRecordDetailSQL += "FROM";
    tableRecordDetailSQL += MONSTERS_ATTACKS.toLowerCase() + " ATTACKS ";

    // ユーザーが選択したモンスターコードのみを含むレコードを検索
    tableRecordDetailSQL += "WHERE ";
    tableRecordDetailSQL += "ATTACKS." + MONSTER_CODE.toLowerCase() + " ";
    tableRecordDetailSQL += "= " + super.getMonsterCode();

    // テーブル名を指定して非正規化テーブルを作成
    // 「モンスター攻撃ステータス検索」テーブル
    super.createTable(MONSTERS_ATTACKS_STATUSES_SEARCH, tableRecordDetailSQL, MONSTER_ATTACK_CODE);
  }

  /**
   * @fn dropPlayerStatusSearchTable
   * @brief 「モンスター攻撃ステータス検索」テーブルの削除
   */
  public void dropMonsterAttackStatusSearchTable() {
    super.dropTable(MONSTERS_ATTACKS_STATUSES_SEARCH);
  }

  /**
   * @fn createMonsterAttackStatusSearchIdx
   * @brief テーブルのインデックスを張る
   */
  private void createMonsterAttackStatusSearchIdx() {
    super.createIdx(IDX_MONSTERS_ATTACKS_STATUSES_SEARCH, MONSTERS_ATTACKS_STATUSES_SEARCH, MONSTER_ATTACK_CODE);
  }

  //////////////////////////////////////////////////
  // 以降、全て selectAll
  //////////////////////////////////////////////////

  /**
   * @fn selectAllMonsterAttackCode
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃コードカラムの全てのフィールドを返す
   * @return モンスター攻撃コードのリスト
   */
  public ArrayList<String> selectAllMonsterAttackCode() {
    return super.selectColumn(MONSTER_ATTACK_CODE, MONSTERS_ATTACKS_STATUSES_SEARCH, MONSTER_ATTACK_CODE);
  }

  /**
   * @fn selectAllMonsterAttackName
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃名カラムの全てのフィールドを返す
   * @return モンスター攻撃名のリスト
   */
  public ArrayList<String> selectAllMonsterAttackName() {
    return super.selectColumn(MONSTER_ATTACK_NAME, MONSTERS_ATTACKS_STATUSES_SEARCH, MONSTER_ATTACK_CODE);
  }

  /**
   * @fn selectAllMonsterAttackVal
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃力カラムの全てのフィールドを返す
   * @return モンスター攻撃力のリスト
   */
  public ArrayList<Integer> selectAllMonsterAttackVal() {
    return super.toIntegerList(
        super.selectColumn(MONSTER_ATTACK_VALUE, MONSTERS_ATTACKS_STATUSES_SEARCH, MONSTER_ATTACK_CODE));
  }

  /**
   * @fn selectAllMonsterAttackMissProb
   * @brief 「モンスター攻撃ステータス検索」テーブルの、モンスター攻撃ミス確率カラムの全てのフィールドを返す
   * @return モンスター攻撃ミス確率のリスト
   */
  public ArrayList<Float> selectAllMonsterAttackMissProb() {
    return super.toFloatList(
        super.selectColumn(MONSTER_ATTACK_MISS_PROBABILITY, MONSTERS_ATTACKS_STATUSES_SEARCH, MONSTER_ATTACK_CODE));
  }
}
