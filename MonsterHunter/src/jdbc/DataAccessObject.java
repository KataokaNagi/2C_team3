/**
* @file      DataAccessObject.java
* @brief     DAOの汎用部分を実装する抽象クラス
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 18:33:31
* $Version   1.1
* $Revision  1.1
* @par       追加：createIdxメソッドの仮組みを作成
* @see       https://www.kenschool.jp/blog/?p=1644
 */

package jdbc;

import java.sql.*;
import java.util.ArrayList;

/**
 * @class DataAccessObject
 * @brief DAOの汎用部分を実装する抽象クラス
 */
abstract class DataAccessObject extends DBConnector {

  /**
   * @fn createTable
   * @brief SQL文でよく使うカラムを非正規化する汎用メソッド
   * @param[in] tableName 作成するテーブル名
   */
  protected void createTable(String tableName) {
    // TODO
  }

  /**
   * @fn dropTable
   * @brief 指定したテーブルを削除する
   * @param[in] tableName 削除するテーブル名
   */
  protected void dropTable(String tableName) {
    // TODO
  }

  /**
   * @fn createIdx
   * @param[in] idxName 張るインデックス名
   * @param[in] tableName インデックスを張るテーブル名
   * @param[in] columnName インデックスを張るコラム名
   * @brief テーブルのインデックスを張る
   */
  protected void createIdx(String idxName, String tableName, String columnName) {
    // TODO
  }

  /**
   * @fn selectColumn
   * @brief カラム内のフィールドを全て返す
   * @param[in] columnName: 検索したいカラムの名前
   * @param[in] tableName: 検索したいカラムが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 検索したいカラムの存在するテーブルの主キーの名前
   * @return 指定されたカラムの全フィールドのオブジェクトリスト
   */
  protected ArrayList<String> selectColumn(String columnName, String tableName, String primaryKeyColumnName) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    ArrayList<String> rtnColumnList = new ArrayList<String>();

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    String sql = "";
    sql += "SELECT " + columnName;
    sql += " FROM " + tableName;
    sql += "ORDER BY " + primaryKeyColumnName;

    try {
      // DBに接続
      connection = DBConnector.getConnection();
      statement = connection.createStatement();

      // SQL文発行
      resultSet = statement.executeQuery(sql);

      // 検索結果をArrayListに格納
      while (resultSet.next()) {
        rtnColumnList.add(resultSet.getString("isbn"));
      }

      // 例外処理
    } catch (SQLException e) {
      System.out.println("Error: Failed to select column" + e);

      // 後処理
    } finally {
      this.closeDBResources(resultSet, statement, connection);
    }

    return rtnColumnList;
  }

  /**
   * @fn toIntegerList
   * @brief StringのリストをIntegerのリストに変換
   * @param[in] strList
   * @return intList
   */
  protected ArrayList<Integer> toIntegerList(ArrayList<String> strList) {
    ArrayList<Integer> intList = new ArrayList<Integer>();
    for (String str : strList) {
      intList.add(Integer.parseInt(str));
    }
    return intList;
  }

  /**
   * @fn toFloatList
   * @brief StringのリストをFloatのリストに変換
   * @param[in] strList
   * @return floatList
   */
  protected ArrayList<Float> toFloatList(ArrayList<String> strList) {
    ArrayList<Float> floatList = new ArrayList<Float>();
    for (String str : strList) {
      floatList.add(Float.parseFloat(str));
    }
    return floatList;
  }

  /**
   * @fn selectField
   * @brief 主キーで指定したフィールドを返す
   * @param[in] columnName: 検索したいフィールドが存在するカラムの名前
   * @param[in] tableName: 検索したいフィールドが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 検索したいフィールドが存在するテーブルの主キーの名前
   * @param[in] primaryKey: 検索したいフィールドに対応する主キー
   * @return String: 主キーで指定したフィールド
   */
  protected String selectField(String columnName, String tableName, String primaryKeyColumnName, String primaryKey) {
    // TODO
    return "tmp";
  }

  /**
   * @fn selectFirstField
   * @brief 指定したカラムの1番目のフィールドを返す
   * @param[in] columnName: 検索したいフィールドが存在するカラムの名前
   * @param[in] tableName: 検索したいフィールドが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 検索したいフィールドが存在するテーブルの主キーの名前
   * @param[in] primaryKey: 検索したいフィールドに対応する主キー
   * @return String: 主キーで指定したフィールド
   */
  protected String selectFirstField(String columnName, String tableName, String primaryKeyColumnName) {
    String primaryKey = "0"; // ! @attention primaryKeyが数字で張られているときにしか通用しない
    return selectField(columnName, tableName, primaryKeyColumnName, primaryKey);

    // // 1番目のレコードの取り出し方がわからなかったのでコラムを全て取得
    // // 本来なら激重コードになるので控えるべき
    // ArrayList<String> fieldsList = selectColumn(columnName, tableName,
    // primaryKeyColumnName);
    // if (!fieldsList.isEmpty()) {
    // return fieldsList.get(0);
    // } else {
    // System.out.println("Error: null refelence @ selectFirstField() in
    // DataAccessObject.java");
    // return "error";
    // }
  }

  /**
   * @fn updateField
   * @brief 主キーで指定したフィールドを更新する
   * @param[in] field: 更新したいフィールド
   * @param[in] columnName: 更新したいフィールドが存在するカラムの名前
   * @param[in] tableName: 更新したいフィールドが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 更新したいフィールドが存在するテーブルの主キーの名前
   * @param[in] primaryKey: 更新したいフィールドに対応する主キー
   */
  protected void updateField(String field, String columnName, String tableName, String primaryKeyColumnName,
      String primaryKey) {
    // TODO
  }

  /**
   * @fn updateFirstField
   * @brief 指定したカラムの1番目のフィールドを更新する
   * @param[in] field: 更新したいフィールド
   * @param[in] columnName: 更新したいフィールドが存在するカラムの名前
   * @param[in] tableName: 更新したいフィールドが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 更新したいフィールドが存在するテーブルの主キーの名前
   * @param[in] primaryKey: 更新したいフィールドに対応する主キー
   */
  protected void updateFirstField(String field, String columnName, String tableName, String primaryKeyColumnName) {
    String primaryKey = "0"; // ! @attention primaryKeyが数字で張られているときにしか通用しない
    updateField(field, columnName, tableName, primaryKeyColumnName, primaryKey);
  }

  /**
   * @fn closeDBResources
   * @brief 後処理
   * @note 後処理の順番 = 前処理の順番の逆
   * @param[in] statement: DBのステートメント
   * @param[in] connection: DBの接続情報
   */
  protected void closeDBResources(ResultSet resultSet, Statement statement, Connection connection) {
    // resultsetの後処理
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException ignore) { // ! よくわかってないけど他のを真似した
      }
    }

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
