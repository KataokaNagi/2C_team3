/**
* @file      SharpnessSearchDAO.java
* @brief     「切れ味色ごと検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 18:59:41
* $Version   1.0
* $Revision  1.3
* @par       編集：create*Idx()の仮組の作成
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;

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
    createIdx(IDX_NAME, TABLE_NAME, COLUMN_NAME);
  }

  //////////////////////////////////////////////////
  // 以降、全て selectAll
  //////////////////////////////////////////////////

  /**
   * @fn selectAllSharpnessColorName
   * @brief 切れ味色ごと検索テーブルの、切れ味色名カラムの全てのフィールドを返す
   * @return 全切れ味色名のリスト
   */
  public ArrayList<String> selectAllSharpnessColorName() {
    String columnName = "sharpness_color_name";
    String tableName = "sharpness_searches"; // 不可算名詞
    String primaryKeyColumnName = "sharpness_color_code";
    return selectColumn(columnName, tableName, primaryKeyColumnName);
  }

  /**
   * @fn selectAllSharpnessGaugeAmount
   * @brief 切れ味色ごと検索テーブルの切れ味ゲージ量名カラムの全てのフィールドを返す
   * @return 全切れ味ゲージ量名のリスト
   */
  public ArrayList<Integer> selectAllSharpnessGaugeAmount() {
    String columnName = "sharpness_gauge_amount";
    String tableName = "sharpness_searches";
    String primaryKeyColumnName = "sharpness_color_code";
    return this.toIntegerList(selectColumn(columnName, tableName, primaryKeyColumnName));
  }

  /**
   * @fn selectAllSharpnessIncreasingAttackValueRate
   * @brief 切れ味色ごと検索テーブルの切れ味攻撃力倍率カラムの全てのフィールドを返す
   * @return 全切れ味攻撃力倍率のリスト
   */
  public ArrayList<Float> selectAllSharpnessIncreasingAttackValueRate() {
    String columnName = "sharpness_increasing_attack_value_rate";
    String tableName = "sharpness_searches";
    String primaryKeyColumnName = "sharpness_color_code";
    return this.toFloatList(selectColumn(columnName, tableName, primaryKeyColumnName));
  }
}
