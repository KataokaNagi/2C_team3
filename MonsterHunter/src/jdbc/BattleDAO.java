/**
* @file      BattleDAO.java
* @brief     バトル画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-10 08:49:51
* $Version   1.2
* $Revision  1.0
* @par       追加：get*Code(), set*Code()
* @par       追加：select*Code()
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

abstract class BattleDAO extends DataAccessObject {
  private final String WEAPON_TABLE_NAME = "weapons";
  private final String ARMOR_TABLE_NAME = "armors";
  private final String MONSTER_TABLE_NAME = "monsters";
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
  public String selectWeaponCode(String weaponName) {
    String whereSQL = "";
    whereSQL += "WHERE ";
    whereSQL += " ";
    // return selectColumn(columnName, tableName, primaryKeyColumnName, whereSQL) ;
    return null;
  }

  public String selectArmorCode(String armorName) {
    return armorCode;
  }

  public String selectMonsterCode(String monsterName) {
    return monsterCode;
  }

  // Setter
  public void setWeaponName(String weaponName) {
    this.weaponName = weaponName;
  }

  public void setWeaponCode(String weaponCode) {
    this.weaponCode = weaponCode;
  }

  public void setArmorName(String armorName) {
    this.armorName = armorName;
  }

  public void setArmorCode(String armorCode) {
    this.armorCode = armorCode;
  }

  public void setMonsterName(String monsterName) {
    this.monsterName = monsterName;
  }

  public void setMonsterCode(String monsterCode) {
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
