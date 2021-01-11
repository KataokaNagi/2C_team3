/**
* @file      DataAccessObject.java
* @brief     DAOの汎用部分を実装する抽象クラス
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-10 08:45:52
* $Version   1.1
* $Revision  1.3
* @par       リファクタリング：exeSQLメソッドを作成して分離するなど
* @par       追加：WHERE用のselectColumn()オーバーロードの追加
* @par       メモ：SQL文の最後に;が必要である可能性がある
* @see       https://www.kenschool.jp/blog/?p=1644
 */

package jdbc;

import java.sql.*;
import java.util.ArrayList;

import jdbc.consts.ColumnName;
import jdbc.consts.DenormalizedTableName;

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
  protected void createTable(DenormalizedTableName tableName, String tableRecordDetailSQL,
      ColumnName primaryKeyColumnName) {

    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    String createTableSQL = ""; // ! 実行SQL文

    // SQL文の作成

    // // Example
    // //! @see
    // https://www.codeflow.site/ja/article/jdbc__jdbc-statement-example-create-a-table
    // String createTableSQL = "CREATE TABLE DBUSER("
    // createTableSQL += "USER__ID NUMBER(5) NOT NULL, ";
    // createTableSQL += "USERNAME VARCHAR(20) NOT NULL, ";
    // createTableSQL += "CREATED__BY VARCHAR(20) NOT NULL, ";
    // createTableSQL += "CREATED__DATE DATE NOT NULL, ";
    // createTableSQL += "PRIMARY KEY (USER__ID) ";
    // createTableSQL += ")";

    createTableSQL += "CREATE TABLE " + tableName.toLowerCase();
    createTableSQL += tableRecordDetailSQL;
    createTableSQL += "PRIMARY KEY (" + primaryKeyColumnName.toLowerCase() + ") ";
    createTableSQL += ")";
    System.out.println(createTableSQL);

    // 実行
    try {
      // DBの接続と実行
      resultSet = this.exeSQL(connection, statement, createTableSQL);
      System.out.println("Table \"" + tableName.toLowerCase() + "\" is created.");

      // 例外処理
    } catch (SQLException e) {
      System.err.println(e.getMessage());

      // 後処理
    } finally {
      this.closeDBResources(resultSet, statement, connection);
    }
  }

  /**
   * @fn dropTable
   * @brief 指定したテーブルを削除する
   * @param[in] tableName 削除するテーブル名
   */
  protected void dropTable(DenormalizedTableName tableName) {
    // TODO
  }

  /**
   * @fn createIdx
   * @param[in] idxName 張るインデックス名
   * @param[in] tableName インデックスを張るテーブル名
   * @param[in] columnName インデックスを張るコラム名
   * @brief テーブルのインデックスを張る
   */
  protected void createIdx(String idxName, DenormalizedTableName tableName, ColumnName columnName) {
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
  protected ArrayList<String> selectColumn(ColumnName columnName, String tableName, ColumnName primaryKeyColumnName) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    ArrayList<String> rtnColumnList = new ArrayList<String>();
    String selectColumnSQL = ""; // ! 実行SQL文

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    selectColumnSQL += "SELECT " + columnName;
    selectColumnSQL += " FROM " + tableName;
    selectColumnSQL += "ORDER BY " + primaryKeyColumnName;

    try {
      // DBの接続と実行
      resultSet = this.exeSQL(connection, statement, selectColumnSQL);

      // 検索結果をArrayListに格納
      while (resultSet.next()) {
        rtnColumnList.add(resultSet.getString("isbn"));
      }

      // 例外処理
    } catch (SQLException e) {
      System.err.println(e.getSQLState());

      // 後処理
    } finally {
      this.closeDBResources(resultSet, statement, connection);
    }

    return rtnColumnList;
  }

  /**
   * @fn selectColumn
   * @note オーバーロード
   * @brief カラム内のフィールドを全て返す
   * @param[in] columnName: 検索したいカラムの名前
   * @param[in] tableName: 検索したいカラムが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 検索したいカラムの存在するテーブルの主キーの名前
   * @return 指定されたカラムの全フィールドのオブジェクトリスト
   */
  protected ArrayList<String> selectColumn(ColumnName columnName, String tableName, ColumnName primaryKeyColumnName,
      String whereSQL) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    ArrayList<String> rtnColumnList = new ArrayList<String>();
    String selectColumnSQL = ""; // ! 実行SQL文

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    selectColumnSQL += "SELECT " + columnName;
    selectColumnSQL += " FROM " + tableName;
    selectColumnSQL += " " + whereSQL; // オーバーロードでここだけ異なる
    selectColumnSQL += " ORDER BY " + primaryKeyColumnName;

    try {
      // DBの接続と実行
      resultSet = this.exeSQL(connection, statement, selectColumnSQL);

      // 検索結果をArrayListに格納
      while (resultSet.next()) {
        rtnColumnList.add(resultSet.getString("isbn"));
      }

      // 例外処理
    } catch (SQLException e) {
      System.err.println(e.getSQLState());

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
  protected String selectField(ColumnName columnName, String tableName, ColumnName primaryKeyColumnName,
      String primaryKey) {
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
  protected String selectFirstField(ColumnName columnName, String tableName, ColumnName primaryKeyColumnName) {
    String primaryKey = "0"; // ! @attention primaryKeyが数字で張られているときにしか通用しない
    return selectField(columnName, tableName, primaryKeyColumnName, primaryKey);

    // // 1番目のレコードの取り出し方がわからなかったのでコラムを全て取得
    // // 本来なら激重コードになるので控えるべき
    // ArrayList<String> fieldsList = selectColumn(columnName, tableName,
    // primaryKeyColumnName);
    // if (!fieldsList.isEmpty() || fieldsList.size() != 0) {
    // return fieldsList.get(0);
    // } else {
    // System.err.println("Error: null refelence @ selectFirstField() in
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
  protected void updateField(String field, ColumnName columnName, String tableName, ColumnName primaryKeyColumnName,
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
  protected void updateFirstField(String field, ColumnName columnName, String tableName,
      ColumnName primaryKeyColumnName) {
    String primaryKey = "0"; // ! @attention primaryKeyが数字で張られているときにしか通用しない
    updateField(field, columnName, tableName, primaryKeyColumnName, primaryKey);
  }

  /**
   * @fn exeSQL
   * @brief DBの接続とSQLの実行
   * @param[in] connection: DBの接続情報
   * @param[in] statement: DBのステートメント
   * @param[in] sql: SQL文
   */
  private ResultSet exeSQL(Connection connection, Statement statement, String sql) throws SQLException {
    // DBに接続
    connection = DBConnector.getConnection();
    statement = connection.createStatement();

    // SQL文発行
    return statement.executeQuery(sql);
  }

  /**
   * @fn closeDBResources
   * @brief 後処理
   * @note 後処理の順番 = 前処理の順番の逆
   * @param[in] resultSet: SQLの実行結果
   * @param[in] statement: DBのステートメント
   * @param[in] connection: DBの接続情報
   */
  private void closeDBResources(ResultSet resultSet, Statement statement, Connection connection) {
    // resultsetの後処理
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException ignore) {
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
