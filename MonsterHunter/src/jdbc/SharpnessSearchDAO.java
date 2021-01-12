/**
* @file      SharpnessSearchDAO.java
* @brief     「切れ味色ごと検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-12 12:28:09
* $Version   1.0
* $Revision  1.6
* @par       追加：createTable関係
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;

import jdbc.consts.ColumnName;

import static jdbc.consts.NormalizedTableName.PLAYERS;
import static jdbc.consts.NormalizedTableName.WEAPONS_SHARPNESS;
import static jdbc.consts.NormalizedTableName.WEAPONS_SHARPNESS_COLORS;
import static jdbc.consts.DenormalizedTableName.SHARPNESS_COLORS_SEARCH;
import static jdbc.consts.ColumnName.*;
import static jdbc.consts.IdxName.*;

/**
 * @class SharpnessSearchDAO
 * @brief 「切れ味色ごと検索」テーブルのDAO
 */
public class SharpnessSearchDAO extends BattleDAO {

  /**
   * @fn SharpnessSearchDAO
   * @brief 切れ味色ごと検索テーブルの作成を行うコンストラクタ
   */
  public SharpnessSearchDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    this.createSharpnessSearchTable();
    this.createSharpnessSearchIdx();
  }

  /**
   * @fn createSharpnessSearchTable
   * @brief 切れ味色ごと検索テーブルの作成
   */
  private void createSharpnessSearchTable() {
    String tableRecordDetailSQL = ""; // ! CREATE TABLE () の中身

    // SQLの作成

    // 作成する非正規化テーブルのカラムを指定
    // プレイヤーコード、切れ味色コード、切れ味色名、切れ味ゲージ量、切れ味攻撃力倍率
    tableRecordDetailSQL += "AS ";
    tableRecordDetailSQL += "SELECT ";
    tableRecordDetailSQL += "PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "PARTS." + PLAYER_CODE.toLowerCase();
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
    // 「プレイヤー」「切れ味」「切れ味色」テーブル
    tableRecordDetailSQL += "FROM ";
    tableRecordDetailSQL += PLAYERS.toLowerCase() + " PLAYERS";
    tableRecordDetailSQL += ", SHARPNESS" + WEAPONS_SHARPNESS.toLowerCase() + "SHARPNESS";
    tableRecordDetailSQL += ", " + WEAPONS_SHARPNESS_COLORS.toLowerCase() + "SHARPNES_COLORS";

    // ユーザーが選択したプレイヤーコード、武器コードのみを含むレコードを使用
    tableRecordDetailSQL += " WHERE ";
    tableRecordDetailSQL += "PLAYERS." + PLAYER_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getMonsterCode();
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "PARTS." + MONSTER_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getMonsterCode();

    // テーブル「切れ味色」「切れ味」を主キー「切れ味色コード」で結合
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "SHARPNESS_COLORS." + WEAPON_SHARPNESS_COLOR_CODE.toLowerCase();
    tableRecordDetailSQL += " = SHARPNESS." + WEAPON_SHARPNESS_COLOR_CODE.toLowerCase();

    // テーブル名を指定して非正規化テーブルを作成
    // 「切れ味色ごと検索」テーブル
    super.createTable(SHARPNESS_COLORS_SEARCH, tableRecordDetailSQL, MONSTER_ATTACK_CODE);
  }

  /**
   * @fn dropSharpnessSearchTable
   * @brief 切れ味色ごと検索テーブルの削除
   */
  public void dropSharpnessSearchTable() {
    // TODO
  }

  /**
   * @fn createSharpnessSearchIdx
   * @brief テーブルのインデックスを張る
   */
  private void createSharpnessSearchIdx() {
    super.createIdx(TODO, SHARPNESS_COLORS_SEARCH, WEAPON_SHARPNESS_COLOR_CODE);
  }

  //////////////////////////////////////////////////
  // 以降、全て selectAll
  //////////////////////////////////////////////////

  /**
   * @fn selectFirstPlayerCode
   * @brief 切れ味色ごと検索テーブルの、プレイヤーコードカラムの最初のフィールドを返す
   * @return プレイヤーコード
   */
  public String selectFirstPlayerCode() {
    return super.selectFirstField(PLAYER_CODE, SHARPNESS_COLORS_SEARCH, WEAPON_SHARPNESS_COLOR_CODE);
  }

  /**
   * @fn selectAllSharpnessColorCode
   * @brief 切れ味色ごと検索テーブルの、切れ味色コードカラムの全てのフィールドを返す
   * @return 全切れ味色コードのリスト
   */
  public ArrayList<String> selectAllSharpnessColorCode() {
    return super.selectColumn(WEAPON_SHARPNESS_COLOR_CODE, SHARPNESS_COLORS_SEARCH, WEAPON_SHARPNESS_COLOR_CODE);
  }

  /**
   * @fn selectAllSharpnessColorName
   * @brief 切れ味色ごと検索テーブルの、切れ味色名カラムの全てのフィールドを返す
   * @return 全切れ味色名のリスト
   */
  public ArrayList<String> selectAllSharpnessColorName() {
    return super.selectColumn(WEAPON_SHARPNESS_COLOR_NAME, SHARPNESS_COLORS_SEARCH, WEAPON_SHARPNESS_COLOR_CODE);
  }

  /**
   * @fn selectAllSharpnessGaugeAmount
   * @brief 切れ味色ごと検索テーブルの切れ味ゲージ量名カラムの全てのフィールドを返す
   * @return 全切れ味ゲージ量名のリスト
   */
  public ArrayList<Integer> selectAllSharpnessGaugeAmount() {
    return super.toIntegerList(
        super.selectColumn(WEAPON_SHARPNESS_COLOR_GAGE_AMOUNT, SHARPNESS_COLORS_SEARCH, WEAPON_SHARPNESS_COLOR_CODE));
  }

  /**
   * @fn selectAllSharpnessIncreasingAttackValueRate
   * @brief 切れ味色ごと検索テーブルの切れ味攻撃力倍率カラムの全てのフィールドを返す
   * @return 全切れ味攻撃力倍率のリスト
   */
  public ArrayList<Float> selectAllSharpnessIncreasingAttackValueRate() {
    return super.toFloatList(
        super.selectColumn(WEAPON_SHARPNESS_ATTACK_VALUE_RATE, SHARPNESS_COLORS_SEARCH, WEAPON_SHARPNESS_COLOR_CODE));
  }
}
