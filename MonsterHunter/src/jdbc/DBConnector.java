/**
* @file      DBConnector.java
* @brief     DBへの接続を行うDAOの抽象クラス
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-10 08:48:22
* $Version   1.1
* $Revision  1.1
* @par       変更点　：ユーザー名の変更
* @par       変更予定：Debianで使えるように編集する必要があるかも
* @see       https://qiita.com/wb773/items/27dc0e77a4c8b035d6fc
 */

package jdbc;

import java.sql.*;

/**
 * @class DBConnector
 * @brief DBへの接続
 */
abstract class DBConnector {
  private static final String RDB_DRIVE = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/monsterhunter_db";
  private static final String USER = "team_03";
  private static final String PASSWD = "bond";

  /**
   * @fn getConnection
   * @brief データベース接続を行うメソッド
   * @param[in] void
   * @return コネクション情報
   */
  public static Connection getConnection() {
    try {
      Class.forName(RDB_DRIVE);
      Connection con = DriverManager.getConnection(URL, USER, PASSWD);
      return con;
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }
}
