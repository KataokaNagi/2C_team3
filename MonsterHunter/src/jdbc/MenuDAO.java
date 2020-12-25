/**
* @file      MenuDAO.java
* @brief     メニュー画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-26 05:39:40
* $Version   1.0
* $Revision  1.0
* @par       EDIT：記事から引用し，メソッド名を変更
* @par       TODO：クエスト後に検索が不要になるようにリストに退避
* @par       TODO：ConnectionとStatementのタイミングが頻繁すぎる気がする
* @par       TODO：Debianへの対応
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.sql.*;
import java.util.ArrayList;

/**
 * @class MenuDAO
 * @brief メニュー画面で用いるデータアクセスオブジェクト
 */
public class MenuDAO extends DBConnector {

  /**
   * @fn selectAllWeaponName
   * @brief 武器テーブルの武器名カラムの全てのフィールドを返す
   * @return 全武器名のリスト
   */
  public MenuDAO() {
    // TODO: クエスト後に検索が不要になるようにリストに退避
  }

  /**
   * @fn selectAllWeaponName
   * @brief 武器テーブルの武器名カラムの全てのフィールドを返す
   * @return 全武器名のリスト
   */
  public ArrayList<String> selectAllWeaponName() {
    String columnName = "weapon_name";
    String tableName = "weapon";
    String primaryKeyName = "weapon_id";
    return selectColumn(columnName, tableName, primaryKeyName);
  }

  /**
   * @fn selectAllArmorName
   * @brief 防具テーブルの防具名カラムの全てのフィールドを返す
   * @return 全防具名のリスト
   */
  public ArrayList<String> selectAllArmorName() {
    String columnName = "armor_name";
    String tableName = "armor";
    String primaryKeyName = "armor_id";
    return selectColumn(columnName, tableName, primaryKeyName);
  }

  /**
   * @fn selectAllMonsterName
   * @brief モンスターテーブルのモンスター名カラムの全てのフィールドを返す
   * @return 全モンスター名のリスト
   */
  public ArrayList<String> selectAllMonsterName() {
    String columnName = "monster_name";
    String tableName = "monster";
    String primaryKeyName = "monster_id";
    return selectColumn(columnName, tableName, primaryKeyName);
  }

  /**
   * @fn selectAllWeaponAttackVal
   * @brief 武器テーブルの武器攻撃力カラムの全てのフィールドを返す
   * @return 全武器攻撃力のリスト
   */
  public ArrayList<Integer> selectAllWeaponAttackVal() {
    String columnName = "weapon_attack_val";
    String tableName = "weapon";
    String primaryKeyName = "weapon_id";
    return toIntegerList(selectColumn(columnName, tableName, primaryKeyName));
  }

  /**
   * @fn selectAllArmorDiffenceVal
   * @brief 防具テーブルの防具防御力カラムの全てのフィールドを返す
   * @return 全防具防御力のリスト
   */
  public ArrayList<Integer> selectAllArmorDiffenceVal() {
    String columnName = "armor_diffence_val";
    String tableName = "armor";
    String primaryKeyName = "armor_id";
    return toIntegerList(selectColumn(columnName, tableName, primaryKeyName));
  }

  /**
   * @fn selectColumn
   * @brief カラム内のフィールドを全て返す
   * @param[in] columnName: 検索したいカラムの名前
   * @param[in] tableName: 検索したいカラムが存在するテーブルの名前
   * @param[in] primaryKeyName: 検索したいカラムの主キーの名前
   * @return 指定されたカラムの全フィールドのオブジェクトリスト
   */
  private ArrayList<String> selectColumn(String columnName, String tableName, String primaryKeyName) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ArrayList<String> rtnColumnList = new ArrayList<String>();

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    String sql = "";
    sql += "SELECT " + columnName;
    sql += " FROM " + tableName;
    sql += "ORDER BY " + primaryKeyName;

    try {
      // DBに接続
      connection = DBConnector.getConnection();
      statement = connection.createStatement();

      // SQL文発行
      ResultSet rs = statement.executeQuery(sql);

      // 検索結果をArrayListに格納
      while (rs.next()) {
        rtnColumnList.add(rs.getString("isbn"));
      }

      // 例外処理
    } catch (SQLException e) {
      System.out.println("Error: Failed to select column" + e);

      // 後処理
    } finally {
      closeResources(statement, connection);
    }

    return rtnColumnList;
  }

  /**
   * @fn toIntegerList
   * @brief StringのリストをIntegerのリストに変換
   * @param[in] strList
   * @return intList
   */
  private ArrayList<Integer> toIntegerList(ArrayList<String> strList) {
    ArrayList<Integer> intList = new ArrayList<Integer>();
    for (String str : strList) {
      intList.add(Integer.parseInt(str));
    }
    return intList;
  }

  /**
   * @fn closeResources
   * @brief ステートメントとコネクションをこの順番にクローズする
   * @param[in] statement: DBのステートメント
   * @param[in] connection: DBの接続情報
   */
  private void closeResources(Statement statement, Connection connection) {
    // statementの後処理
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException ignore) {
      }
    }

    // connectionの後処理
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException ignore) {
      }
    }
  }
}
