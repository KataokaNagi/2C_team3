/**
* @file      DebugUtil.java
* @brief     デバッグ用のメソッドを保持
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-11 08:49:29
* $Version   1.0
* $Revision  1.0
* @par       追加点　：新規作成
* @see       Javaで実行中のクラス名・メソッド名を取得する方法 https://qiita.com/munieru_jp/items/02533ebe5c822e6e29bb
*/

package jdbc.utils;

public class DebugUtil {

  public static String getProcessPositionStr() {
    return " @ " + getClassName() + ", " + getMethodName() + " ";
  }

  /**
   * 実行中のクラス名を取得します。
   * 
   * @return クラス名
   */
  private static String getClassName() {
    return Thread.currentThread().getStackTrace()[2].getClassName();
  }

  /**
   * 実行中のメソッド名を取得します。
   * 
   * @return メソッド名
   */
  private static String getMethodName() {
    return Thread.currentThread().getStackTrace()[2].getMethodName();
  }
}
