/**
* @file      BattleDAO.java
* @brief     バトル画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-26 22:43:31
* $Version   1.0
* $Revision  1.1
* @par       変更点　：メンバの追加と初期化
* @par       変更点　：クラスの抽象化（非正規化のテーブルごとにクラスを作成予定）
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

abstract class BattleDAO extends DataAccessObject {
  private String weaponName;
  private String armorName;
  private String monsterName;

  /**
   * @fn BattleDAO
   * @brief メンバの初期化（メニュー画面で選択した項目名）
   */
  public BattleDAO(String weaponName, String armorName, String monsterName) {
    this.weaponName = weaponName;
    this.armorName = armorName;
    this.monsterName = monsterName;
  }
}
