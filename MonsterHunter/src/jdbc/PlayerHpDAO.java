/**
* @file      PlayerHpDAO.java
* @brief     「プレイヤー体力」テーブル
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-28 06:31:02
* $Version   1.0
* $Revision  1.1
* @par       ADD: 仮組の作成
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

/**
 * @class PlayerHpDAO
 * @brief 「プレイヤー体力」テーブルのDAO
 */
public class PlayerHpDAO extends BattleDAO {

  /**
   * @fn PlayerHpDAO
   * @brief 「プレイヤー体力」テーブルの作成を行うコンストラクタ
   */
  public PlayerHpDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    createPlayerHpTable();
  }

  /**
   * @fn createPlayerHpTable
   * @brief 「プレイヤー体力」テーブルの作成
   */
  private void createPlayerHpTable() {
    // TODO
  }

  /**
   * @fn dropPlayerHpTable
   * @brief 「プレイヤー体力」テーブルの削除
   */
  public void dropPlayerHpTable() {
    // TODO
  }

  /**
   * @fn selectFirstPlayerHp
   * @brief 「プレイヤー体力」テーブルの、プレイヤー体力カラムの先頭のフィールドを返す
   * @return プレイヤー体力の先頭のフィールド
   */
  public int selectFirstPlayerHp() {
    String columnName = "player_hp";
    String tableName = "player_hp_table";
    String primaryKeyColumnName = "player_code";
    return Integer.parseInt(selectFirstField(columnName, tableName, primaryKeyColumnName));
  }

  /**
   * @fn updateFirstPlayerHp
   * @brief 「プレイヤー体力」テーブルの、プレイヤー体力カラムの先頭のフィールドを更新
   */
  public void updateFirstPlayerHp() {
    String columnName = "player_hp";
    String tableName = "player_hp_table";
    String primaryKeyColumnName = "player_code";
    this.updateFirstField(columnName, tableName, primaryKeyColumnName);
  }
}
