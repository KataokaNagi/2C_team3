/**
* @file      MenuDAO.java
* @brief     メニュー画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-26 22:30:14
* $Version   1.1
* $Revision  1.0
* @par       EDIT：汎用的なコードをDataAccessObject.javaに移動
* @par       TODO：クエスト後に検索が不要になるようにリストに退避
* @par       TODO：ConnectionとStatementのタイミングが頻繁すぎる気がする
* @par       TODO：Debianへの対応
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;

/**
 * @class MenuDAO
 * @brief メニュー画面で用いるデータアクセスオブジェクト
 */
public class MenuDAO extends DataAccessObject {

  /**
   * @fn selectAllWeaponName
   * @brief 武器テーブルの武器名カラムの全てのフィールドを返す
   * @return 全武器名のリスト
   */
  public MenuDAO() {
    // TODO: クエスト後に検索が不要になるようにリストに退避？
    // ↑ GUIの方でやる（やらなくてもよい）仕事ですね恐らく
  }

  /**
   * @fn selectAllWeaponName
   * @brief 武器テーブルの武器名カラムの全てのフィールドを返す
   * @return 全武器名のリスト
   */
  public ArrayList<String> selectAllWeaponName() {
    String columnName = "weapon_name";
    String tableName = "weapon_table";
    String primaryKeyColumnName = "weapon_id";
    return selectColumn(columnName, tableName, primaryKeyColumnName);
  }

  /**
   * @fn selectAllArmorName
   * @brief 防具テーブルの防具名カラムの全てのフィールドを返す
   * @return 全防具名のリスト
   */
  public ArrayList<String> selectAllArmorName() {
    String columnName = "armor_name";
    String tableName = "armor_table";
    String primaryKeyColumnName = "armor_id";
    return selectColumn(columnName, tableName, primaryKeyColumnName);
  }

  /**
   * @fn selectAllMonsterName
   * @brief モンスターテーブルのモンスター名カラムの全てのフィールドを返す
   * @return 全モンスター名のリスト
   */
  public ArrayList<String> selectAllMonsterName() {
    String columnName = "monster_name";
    String tableName = "monster_table";
    String primaryKeyColumnName = "monster_id";
    return selectColumn(columnName, tableName, primaryKeyColumnName);
  }

  /**
   * @fn selectAllWeaponAttackVal
   * @brief 武器テーブルの武器攻撃力カラムの全てのフィールドを返す
   * @return 全武器攻撃力のリスト
   */
  public ArrayList<Integer> selectAllWeaponAttackVal() {
    String columnName = "weapon_attack_val";
    String tableName = "weapon_table";
    String primaryKeyColumnName = "weapon_id";
    return toIntegerList(selectColumn(columnName, tableName, primaryKeyColumnName));
  }

  /**
   * @fn selectAllArmorDiffenceVal
   * @brief 防具テーブルの防具防御力カラムの全てのフィールドを返す
   * @return 全防具防御力のリスト
   */
  public ArrayList<Integer> selectAllArmorDiffenceVal() {
    String columnName = "armor_diffence_val";
    String tableName = "armor_table";
    String primaryKeyColumnName = "armor_id";
    return toIntegerList(selectColumn(columnName, tableName, primaryKeyColumnName));
  }
}
