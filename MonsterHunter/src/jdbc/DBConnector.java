/**
* @file      DBConnector.java
* @brief     DBへの接続を行うDAOの抽象クラス
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-26 01:58:29
* $Version   1.0
* $Revision  1.0
* @par       変更点　：記事から引用し，USERとPASSWDを変更
* @par       変更予定：Debianで使えるように編集する必要があるかも
* @see       https://www.kenschool.jp/blog/?p=1644
 */

package jdbc;

import java.sql.*;

/**
 * @class DBConnector
 * @brief DBへの接続
 */
abstract class DBConnector {
  private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
  private static final String URL = "jdbc:mysql://localhost/mybookdb";
  private static final String USER = "group-b";
  private static final String PASSWD = "monhan";

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
