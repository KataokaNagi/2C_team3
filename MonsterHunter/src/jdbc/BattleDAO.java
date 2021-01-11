/**
* @file      BattleDAO.java
* @brief     バトル画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-11 11:27:42
* $Version   1.2
* $Revision  1.1
* @par       修正：アクセス修飾子を変更（getter以外はprivateに）
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import static jdbc.consts.NormalizedTableName.*;

abstract class BattleDAO extends DataAccessObject {
  private String weaponName;
  private String weaponCode;
  private String armorName;
  private String armorCode;
  private String monsterName;
  private String monsterCode;

  /**
   * @fn BattleDAO
   * @brief メンバの初期化（メニュー画面で選択した項目名）
   */
  public BattleDAO(String weaponName, String armorName, String monsterName) {
    this.setWeaponName(weaponName);
    this.setArmorName(armorName);
    this.setMonsterName(monsterName);
    this.setWeaponCode(this.selectWeaponCode(weaponName));
    this.setArmorCode(this.selectArmorCode(armorName));
    this.setMonsterCode(this.selectMonsterCode(monsterName));
  }

  // SELECT codes WHERE
  private String selectWeaponCode(String weaponName) {
    String whereSQL = "";
    whereSQL += "WHERE ";
    whereSQL += " ";
    // return selectColumn(columnName, tableName, primaryKeyColumnName, whereSQL) ;
    return null;
  }

  private String selectArmorCode(String armorName) {
    return armorCode;
  }

  private String selectMonsterCode(String monsterName) {
    return monsterCode;
  }

  // Setter
  private void setWeaponName(String weaponName) {
    this.weaponName = weaponName;
  }

  private void setWeaponCode(String weaponCode) {
    this.weaponCode = weaponCode;
  }

  private void setArmorName(String armorName) {
    this.armorName = armorName;
  }

  private void setArmorCode(String armorCode) {
    this.armorCode = armorCode;
  }

  private void setMonsterName(String monsterName) {
    this.monsterName = monsterName;
  }

  private void setMonsterCode(String monsterCode) {
    this.monsterCode = monsterCode;
  }

  // Getter
  public String getWeaponName() {
    return this.weaponName;
  }

  public String getWeaponCode() {
    return weaponCode;
  }

  public String getArmorName() {
    return this.armorName;
  }

  public String getArmorCode() {
    return armorCode;
  }

  public String getMonsterName() {
    return this.monsterName;
  }

  public String getMonsterCode() {
    return monsterCode;
  }
}
