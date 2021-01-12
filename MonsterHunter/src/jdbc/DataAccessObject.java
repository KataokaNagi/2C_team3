/**
* @file      DataAccessObject.java
* @brief     DAOの汎用部分を実装する抽象クラス
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-13 03:09:13
* $Version   1.2
* $Revision  1.0
* @par       変更点：update関係の完成
* @par       メモ：SQL文の最後に;が必要である可能性がある
* @see       https://www.kenschool.jp/blog/?p=1644
 */

package jdbc;

import java.sql.*;
import java.util.ArrayList;

import jdbc.consts.*;
import jdbc.utils.DebugUtil;

/**
 * @class DataAccessObject
 * @brief DAOの汎用部分を実装する抽象クラス
 */
abstract class DataAccessObject<T extends Enum<T> & TableName> extends DBConnector {

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
    createTableSQL += "( ";
    createTableSQL += tableRecordDetailSQL;
    createTableSQL += ")";
    System.out.println(createTableSQL);

    // 実行
    try {
      // DBの接続と実行
      resultSet = this.exeSQL(connection, statement, createTableSQL);
      System.out.println("Table \"" + tableName.toLowerCase() + "\" was created.");

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
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    String dropTableSQL = ""; // ! 実行SQL文

    // SQL文の作成
    dropTableSQL += "DROP TABLE ";
    dropTableSQL += tableName.toLowerCase();
    System.out.println(dropTableSQL);

    // 実行
    try {
      // DBの接続と実行
      resultSet = this.exeSQL(connection, statement, dropTableSQL);
      System.out.println("Table \"" + tableName.toLowerCase() + "\" was droped.");

      // 例外処理
    } catch (SQLException e) {
      System.err.println(e.getMessage());

      // 後処理
    } finally {
      this.closeDBResources(resultSet, statement, connection);
    }
  }

  /**
   * @fn createIdx
   * @param[in] idxName 張るインデックス名
   * @param[in] tableName インデックスを張るテーブル名
   * @param[in] columnName インデックスを張るコラム名
   * @brief テーブルのインデックスを張る
   */
  protected void createIdx(IdxName idxName, DenormalizedTableName tableName, ColumnName idxColumnName) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    String createIdxSQL = ""; // ! 実行SQL文

    // SQL文の作成
    createIdxSQL += "CREATE INDEX ";
    createIdxSQL += idxName.toLowerCase();
    createIdxSQL += " ON ";
    createIdxSQL += tableName.toLowerCase();
    createIdxSQL += " ( ";
    createIdxSQL += idxColumnName.toLowerCase();
    createIdxSQL += " )";
    System.out.println(createIdxSQL);

    // 実行
    try {
      // DBの接続と実行
      resultSet = this.exeSQL(connection, statement, createIdxSQL);
      System.out.println("Table \"" + tableName.toLowerCase() + "\" was droped.");

      // 例外処理
    } catch (SQLException e) {
      System.err.println(e.getMessage());

      // 後処理
    } finally {
      this.closeDBResources(resultSet, statement, connection);
    }
  }

  /**
   * @fn selectColumn
   * @brief カラム内のフィールドを全て返す
   * @param[in] columnName: 検索したいカラムの名前
   * @param[in] tableName: 検索したいカラムが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 検索したいカラムの存在するテーブルの主キーの名前
   * @return 指定されたカラムの全フィールドのオブジェクトリスト
   */
  protected <T extends Enum<T> & TableName> ArrayList<String> selectColumn(ColumnName columnName, T tableName,
      ColumnName primaryKeyColumnName) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    ArrayList<String> rtnColumnList = new ArrayList<String>();
    String selectColumnSQL = ""; // ! 実行SQL文

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    selectColumnSQL += "SELECT " + columnName.toLowerCase();
    selectColumnSQL += " FROM " + tableName.toLowerCase();
    selectColumnSQL += "ORDER BY " + primaryKeyColumnName.toLowerCase();

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
   * @brief "WHERE"で指定したカラム内のフィールドを全て返す
   * @param[in] columnName: 検索したいカラムの名前
   * @param[in] tableName: 検索したいカラムが存在するテーブルの名前
   * @param[in] primaryKeyColumnName: 検索したいカラムの存在するテーブルの主キーの名前
   * @return "WHERE"で指定されたカラムの全フィールドのオブジェクトリスト
   */
  protected <T extends Enum<T> & TableName> ArrayList<String> selectColumn(ColumnName columnName, T tableName,
      ColumnName primaryKeyColumnName, String whereSQL) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    ArrayList<String> rtnColumnList = new ArrayList<String>();
    String selectColumnSQL = ""; // ! 実行SQL文

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    selectColumnSQL += "SELECT " + columnName.toLowerCase();
    selectColumnSQL += " FROM " + tableName.toLowerCase();
    selectColumnSQL += " " + whereSQL; // オーバーロードでここだけ異なる
    selectColumnSQL += " ORDER BY " + primaryKeyColumnName.toLowerCase();

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
  protected String selectField(ColumnName columnName, DenormalizedTableName tableName, ColumnName primaryKeyColumnName,
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
  protected String selectFirstField(ColumnName columnName, DenormalizedTableName tableName,
      ColumnName primaryKeyColumnName) {
    // // selectFieldを実装するならこちらを採用
    // String primaryKey = "1"; // ! @attention primaryKeyが数字で張られているときにしか通用しない
    // return selectField(columnName, tableName, primaryKeyColumnName, primaryKey);

    // 1番目のレコードの取り出し方がわからなかったのでコラムを全て取得
    // 本来なら激重コードになるので控えるべき
    ArrayList<String> fieldsList = selectColumn(columnName, tableName, primaryKeyColumnName);
    if (!fieldsList.isEmpty() || fieldsList.size() != 0) {
      return fieldsList.get(0);
    } else {
      System.err.println("Error: null refelence" + DebugUtil.getProcessPositionStr());
      return "error";
    }
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
  protected void updateField(String field, ColumnName beingUpdatedColumnName, DenormalizedTableName tableName,
      ColumnName primaryKeyColumnName, String primaryKey) {
    Connection connection = null; // ! DBコネクション
    Statement statement = null; // ! SQLステートメント
    ResultSet resultSet = null; // ! SQLリザルトセット
    ArrayList<String> rtnColumnList = new ArrayList<String>();
    String updateFirstFieldSQL = ""; // ! 実行SQL文

    // SQL文の作成
    // 主キーで整列することでSELECT文の順序を保証し、
    // 武器名と武器スキルを同じインデックスで取得できるようにする
    updateFirstFieldSQL += "UPDATE ";
    updateFirstFieldSQL += tableName.toLowerCase();
    updateFirstFieldSQL += " SET ";
    updateFirstFieldSQL += beingUpdatedColumnName.toLowerCase();
    updateFirstFieldSQL += " = ";
    updateFirstFieldSQL += field;
    updateFirstFieldSQL += " WHERE ";
    updateFirstFieldSQL += primaryKeyColumnName.toLowerCase();
    updateFirstFieldSQL += " = ";
    updateFirstFieldSQL += primaryKey;

    try {
      // DBの接続と実行
      resultSet = this.exeSQL(connection, statement, updateFirstFieldSQL);

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
  protected void updateFirstField(String field, ColumnName beingUpdatedColumnName, DenormalizedTableName tableName,
      ColumnName primaryKeyColumnName) {
    // 間に合わせコード1
    // 主キーが0である保証がないので保留
    // String primaryKey = "0"; // ! @attention primaryKeyが数字で張られているときにしか通用しない
    // updateField(field, columnName, tableName, primaryKeyColumnName, primaryKey);

    // 間に合わせコード2
    // 激重コードだが、レコード数が1つしかないので、実際そんなに重くない
    String firstPrimaryKeyField = this.selectFirstField(primaryKeyColumnName, tableName, primaryKeyColumnName);
    updateField(field, beingUpdatedColumnName, tableName, primaryKeyColumnName, firstPrimaryKeyField);
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
