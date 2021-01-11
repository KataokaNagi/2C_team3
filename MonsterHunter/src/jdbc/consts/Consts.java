/**
* @file      Consts.java
* @brief     enumの疑似拡張用のインターフェース（全定数用）
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-11 08:59:25
* $Version   1.0
* $Revision  1.0
* @par       追加点　：新規作成
* @par       変更予定：現状なし
* @see       拡張可能な enum をインタフェースで模倣する https://thekingsmuseum.info/entry/2016/05/15/235038
*/

package jdbc.consts;

interface Consts {

  /**
   * @fn toLowerCase
   * @return String DBで使用する列挙子のキャメルケース版
   */
  public String toLowerCase();
}
