/**
* @file      BattleDAO.java
* @brief     バトル画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-28 02:15:41
* $Version   1.1
* $Revision  1.0
* @par       追加：ゲッターとセッター
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
    this.setWeaponName(weaponName);
    this.setArmorName(armorName);
    this.setMonsterName(monsterName);
  }

  // Setter
  public String getWeaponName() {
    return this.weaponName;
  }

  public String getArmorName() {
    return this.armorName;
  }

  public String getMonsterName() {
    return this.monsterName;
  }

  // Getter
  public void setWeaponName(String weaponName) {
    this.weaponName = weaponName;
  }

  public void setArmorName(String armorName) {
    this.armorName = armorName;
  }

  public void setMonsterName(String monsterName) {
    this.monsterName = monsterName;
  }
}
