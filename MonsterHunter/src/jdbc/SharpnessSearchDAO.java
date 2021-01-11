/**
* @file      SharpnessSearchDAO.java
* @brief     「切れ味色ごと検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-11 11:55:57
* $Version   1.0
* $Revision  1.5
* @par       追加：codeのselectメソッド
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;

import jdbc.consts.ColumnName;

import static jdbc.consts.ColumnName.*;
import static jdbc.consts.DenormalizedTableName.*;
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
    // TODO
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
