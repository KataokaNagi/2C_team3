/**
* @file      PlayerHpDAO.java
* @brief     「プレイヤー体力」テーブル
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-12 12:25:39
* $Version   1.1
* $Revision  1.5
* @par       追加：createTable関係
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import static jdbc.consts.NormalizedTableName.PLAYERS;
import static jdbc.consts.DenormalizedTableName.PLAYERS_HITPOINTS;
import static jdbc.consts.ColumnName.*;
import static jdbc.consts.IdxName.*;

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
    this.createPlayerHpTable();
    this.createPlayerHpIdx();
  }

  /**
   * @fn createPlayerHpTable
   * @brief 「プレイヤー体力」テーブルの作成
   */
  private void createPlayerHpTable() {
    String tableRecordDetailSQL = ""; // ! CREATE TABLE () の中身

    // SQLの作成

    // 作成する非正規化テーブルのカラムを指定
    // プレイヤーコード、プレイヤー体力
    tableRecordDetailSQL += "AS ";
    tableRecordDetailSQL += "SELECT ";
    tableRecordDetailSQL += "PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "PARTS." + PLAYER_CODE.toLowerCase();
    tableRecordDetailSQL += " )";
    tableRecordDetailSQL += ", PARTS." + PLAYER_HITPOINT.toLowerCase() + " ";

    // 結合検索の基となる正規化テーブルの名前を指定
    // 「プレイヤー」テーブル
    tableRecordDetailSQL += "FROM ";
    tableRecordDetailSQL += PLAYERS.toLowerCase() + " PLAYERS";

    // ユーザーが選択したプレイヤーコードのみを含むレコードを検索
    tableRecordDetailSQL += " WHERE ";
    tableRecordDetailSQL += "PARTS." + PLAYER_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getPlayerCode();

    // テーブル名を指定して非正規化テーブルを作成
    // 「プレイヤー体力」テーブル
    super.createTable(PLAYERS_HITPOINTS, tableRecordDetailSQL, PLAYER_CODE);
  }

  /**
   * @fn dropPlayerHpTable
   * @brief 「プレイヤー体力」テーブルの削除
   */
  public void dropPlayerHpTable() {
    // TODO
  }

  /**
   * @fn createIdx
   * @brief テーブルのインデックスを張る
   */
  private void createPlayerHpIdx() {
    super.createIdx(TODO, PLAYERS_HITPOINTS, PLAYER_CODE);
  }

  /**
   * @fn selectFirstPlayerCode
   * @brief 「プレイヤー体力」テーブルの、プレイヤーコードカラムの先頭のフィールドを返す
   * @return プレイヤーコードの先頭のフィールド
   */
  public String selectFirstPlayerCode() {
    return super.selectFirstField(PLAYER_CODE, PLAYERS_HITPOINTS, PLAYER_CODE);
  }

  /**
   * @fn selectFirstPlayerHp
   * @brief 「プレイヤー体力」テーブルの、プレイヤー体力カラムの先頭のフィールドを返す
   * @return プレイヤー体力の先頭のフィールド
   */
  public int selectFirstPlayerHp() {
    return Integer.parseInt(super.selectFirstField(PLAYER_HITPOINT, PLAYERS_HITPOINTS, PLAYER_CODE));
  }

  /**
   * @fn updateFirstPlayerHp
   * @brief 「プレイヤー体力」テーブルの、プレイヤー体力カラムの先頭のフィールドを更新
   */
  public void updateFirstPlayerHp(int playerHp) {
    super.updateFirstField(Integer.toString(playerHp), PLAYER_HITPOINT, PLAYERS_HITPOINTS, PLAYER_CODE);
  }
}
