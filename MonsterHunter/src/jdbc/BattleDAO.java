/**
* @file      BattleDAO.java
* @brief     バトル画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-12 10:53:20
* $Version   1.2
* $Revision  1.2
* @par       追加：playerCode関係
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import static jdbc.consts.NormalizedTableName.*;

import java.util.ArrayList;

import jdbc.utils.DebugUtil;

import static jdbc.consts.ColumnName.*;

abstract class BattleDAO extends DataAccessObject {
  private String weaponName;
  private String weaponCode;
  private String armorName;
  private String armorCode;
  private String monsterName;
  private String monsterCode;
  private String playerCode;

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
    this.setPlayerCode("0"); // tmp
  }

  //////////////////////////////////////////////////
  // SELECT the code WHERE the name is correspond to
  //////////////////////////////////////////////////

  private String selectWeaponCode(String weaponName) {
    ArrayList<String> weaponCodeList;
    String whereSQL = "";

    // Codeを指定するWHERE文の作成
    whereSQL += "WHERE ";
    whereSQL += WEAPON_NAME.toLowerCase();
    whereSQL += " = " + weaponName;

    // 指定したCodeが1つだけ入っている（はずの）リストを取得
    weaponCodeList = selectColumn(WEAPON_CODE, WEAPONS, WEAPON_CODE, whereSQL);

    return this.getFirstElementSafely(weaponCodeList);
  }

  private String selectArmorCode(String armorName) {
    ArrayList<String> armorCodeList;
    String whereSQL = "";

    // Codeを指定するWHERE文の作成
    whereSQL += "WHERE ";
    whereSQL += ARMOR_NAME.toLowerCase();
    whereSQL += " = " + armorName;

    // 指定したCodeが1つだけ入っている（はずの）リストを取得
    armorCodeList = selectColumn(ARMOR_CODE, ARMORS, ARMOR_CODE, whereSQL);

    return this.getFirstElementSafely(armorCodeList);
  }

  private String selectMonsterCode(String monsterName) {
    ArrayList<String> monsterCodeList;
    String whereSQL = "";

    // Codeを指定するWHERE文の作成
    whereSQL += "WHERE ";
    whereSQL += MONSTER_NAME.toLowerCase();
    whereSQL += " = " + monsterName;

    // 指定したCodeが1つだけ入っている（はずの）リストを取得
    monsterCodeList = selectColumn(MONSTER_CODE, MONSTERS, MONSTER_CODE, whereSQL);

    return this.getFirstElementSafely(monsterCodeList);
  }

  private String getFirstElementSafely(ArrayList<String> list) {
    if (!list.isEmpty() || list.size() != 0) {
      return list.get(0);
    } else {
      System.err.println("Error: null refelence" + DebugUtil.getProcessPositionStr());
      return "error";
    }
  }

  //////////////////////////////////////////////////
  // Setter
  //////////////////////////////////////////////////

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

  public void setPlayerCode(String playerCode) {
    this.playerCode = playerCode;
  }

  //////////////////////////////////////////////////
  // Getter
  //////////////////////////////////////////////////

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

  public String getPlayerCode() {
    return playerCode;
  }
}
