/**
* @file      PlayerHpDAO.java
* @brief     「プレイヤー体力」テーブル
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 18:21:24
* $Version   1.1
* $Revision  1.1
* @par       編集：カラム、テーブル名を命名規則に合わせて変更（https://qiita.com/genzouw/items/35022fa96c120e67c637）
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
    String columnName = "player_hitpoint";
    String tableName = "players_hitpoints";
    String primaryKeyColumnName = "player_code";
    return Integer.parseInt(selectFirstField(columnName, tableName, primaryKeyColumnName));
  }

  /**
   * @fn updateFirstPlayerHp
   * @brief 「プレイヤー体力」テーブルの、プレイヤー体力カラムの先頭のフィールドを更新
   */
  public void updateFirstPlayerHp(int playerHp) {
    String columnName = "player_hitpoint";
    String tableName = "players_hitpoints";
    String primaryKeyColumnName = "player_code";
    this.updateFirstField(Integer.toString(playerHp), columnName, tableName, primaryKeyColumnName);
  }
}
