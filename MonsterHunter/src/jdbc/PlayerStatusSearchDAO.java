/**
* @file      PlayerStatusSearchDAO.java
* @brief     「プレイヤーステータス検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 19:31:42
* $Version   1.0
* $Revision  1.3
* @par       リファクタリング：テーブル名とPK名をメンバ変数へ
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import static jdbc.consts.ColumnName.*;
import static jdbc.consts.DenormalizedTableName.*;
import static jdbc.consts.IdxName.*;

/**
 * @class PlayerStatusSearchDAO
 * @brief 「プレイヤーステータス検索」テーブルのDAO
 */
public class PlayerStatusSearchDAO extends BattleDAO {

  /**
   * @fn PlayerStatusSearchDAO
   * @brief 「プレイヤーステータス検索」テーブルの作成を行うコンストラクタ
   */
  public PlayerStatusSearchDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    this.createPlayerStatusSearchTable();
    this.createPlayerStatusSearchIdx();
  }

  /**
   * @fn createPlayerStatusSearchTable
   * @brief 「プレイヤーステータス検索」テーブルの作成
   */
  private void createPlayerStatusSearchTable() {
    // TODO
  }

  /**
   * @fn dropPlayerStatusSearchTable
   * @brief 「プレイヤーステータス検索」テーブルの削除
   */
  public void dropPlayerStatusSearchTable() {
    // TODO
  }

  /**
   * @fn createPlayerStatusSearchIdx
   * @brief テーブルのインデックスを張る
   */
  private void createPlayerStatusSearchIdx() {
    super.createIdx(TODO, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  //////////////////////////////////////////////////
  // 以降、全て selectFirst
  //////////////////////////////////////////////////

  /**
   * @fn selectFirstWeaponCode
   * @brief 「プレイヤーステータス検索」テーブルの、武器コードカラムの先頭のフィールドを返す
   * @return 武器コードの先頭のフィールド
   */
  public String selectFirstWeaponCode() {
    return super.selectFirstField(WEAPON_CODE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstWeaponName
   * @brief 「プレイヤーステータス検索」テーブルの、武器名カラムの先頭のフィールドを返す
   * @return 武器名の先頭のフィールド
   */
  public String selectFirstWeaponName() {
    return super.selectFirstField(WEAPON_NAME, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstWeaponAttackVal
   * @brief 「プレイヤーステータス検索」テーブルの、武器攻撃力カラムの先頭のフィールドを返す
   * @return 武器攻撃力の先頭のフィールド
   */
  public int selectFirstWeaponAttackVal() {
    return Integer.parseInt(super.selectFirstField(WEAPON_ATTACK_VALUE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstWeaponCriticalRate
   * @brief 「プレイヤーステータス検索」テーブルの、武器会心率カラムの先頭のフィールドを返す
   * @return 武器会心率の先頭のフィールド
   */
  public float selectFirstWeaponCriticalRate() {
    return Float.parseFloat(super.selectFirstField(WEAPON_CRITIVAL_RATE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstWeaponElementVal
   * @brief 「プレイヤーステータス検索」テーブルの、武器属性数値カラムの先頭のフィールドを返す
   * @return 武器属性数値の先頭のフィールド
   */
  public int selectFirstWeaponElementVal() {
    return Integer.parseInt(super.selectFirstField(WEAPON_ELEMENT_VALUE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstWeaponElementCode
   * @brief 「プレイヤーステータス検索」テーブルの、武器属性コードカラムの先頭のフィールドを返す
   * @return 武器属性コードの先頭のフィールド
   */
  public String selectFirstWeaponElementCode() {
    return super.selectFirstField(WEAPON_ELEMENT_CODE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstWeaponElementName
   * @brief 「プレイヤーステータス検索」テーブルの、武器属性名カラムの先頭のフィールドを返す
   * @return 武器属性名の先頭のフィールド
   */
  public String selectFirstWeaponElementName() {
    return super.selectFirstField(WEAPON_ELEMENT_NAME, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstArmorCode
   * @brief 「プレイヤーステータス検索」テーブルの、防具コードカラムの先頭のフィールドを返す
   * @return 防具コードの先頭のフィールド
   */
  public String selectFirstArmorCode() {
    return super.selectFirstField(ARMOR_CODE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstArmorName
   * @brief 「プレイヤーステータス検索」テーブルの、防具コードカラムの先頭のフィールドを返す
   * @return 防具コードの先頭のフィールド
   */
  public String selectFirstArmorName() {
    return super.selectFirstField(ARMOR_NAME, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstArmorDiffenceVal
   * @brief 「プレイヤーステータス検索」テーブルの、防具防御力カラムの先頭のフィールドを返す
   * @return 防具防御力の先頭のフィールド
   */
  public int selectFirstArmorDiffenceVal() {
    return Integer.parseInt(super.selectFirstField(ARMOR_DIFFENCE_VALUE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstArmorSkillCode
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキルコードカラムの先頭のフィールドを返す
   * @return 防具スキルコードの先頭のフィールド
   */
  public String selectFirstArmorSkillCode() {
    return super.selectFirstField(ARMOR_SKILL_CODE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstArmorSkillName
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキル名カラムの先頭のフィールドを返す
   * @return 防具スキル名の先頭のフィールド
   */
  public String selectFirstArmorSkillName() {
    return super.selectFirstField(ARMOR_SKILL_NAME, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstArmorIncreasingSkillTarget
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキル上昇対象カラムの先頭のフィールドを返す
   * @return 防具スキル上昇対象の先頭のフィールド
   */
  public String selectFirstArmorIncreasingSkillTarget() {
    return super.selectFirstField(ARMOR_SKILL_INCREASE_TARGET, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstArmorIncreasingSkillVal
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキル上昇数値カラムの先頭のフィールドを返す
   * @return 防具スキル上昇数値の先頭のフィールド
   */
  public int selectFirstArmorIncreasingSkillVal() {
    return Integer.parseInt(super.selectFirstField(ARMOR_SKILL_INCREASE_VALUE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstArmorElementResistanceCode
   * @brief 「プレイヤーステータス検索」テーブルの、防具属性耐性コードカラムの先頭のフィールドを返す
   * @return 防具属性耐性コードの先頭のフィールド
   */
  public String selectFirstArmorElementResistanceCode() {
    return super.selectFirstField(ARMOR_ELEMENT_RESISTANCE_CODE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE);
  }

  /**
   * @fn selectFirstArmorFireResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具火耐性カラムの先頭のフィールドを返す
   * @return 防具火耐性の先頭のフィールド
   */
  public int selectFirstArmorFireResistance() {
    return Integer.parseInt(super.selectFirstField(ARMOR_FIRE_RESISTANCE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstArmorWaterResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具水耐性カラムの先頭のフィールドを返す
   * @return 防具水耐性の先頭のフィールド
   */
  public int selectFirstArmorWaterResistance() {
    return Integer.parseInt(super.selectFirstField(ARMOR_WATER_RESISTANCE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstArmorElectricResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具雷耐性カラムの先頭のフィールドを返す
   * @return 防具雷耐性の先頭のフィールド
   */
  public int selectFirstArmorElectricResistance() {
    return Integer.parseInt(super.selectFirstField(ARMOR_THUNDER_RESISTANCE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstArmorIceResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防こ氷耐性カラムの先頭のフィールドを返す
   * @return 防こ氷耐性の先頭のフィールド
   */
  public int selectFirstArmorIceResistance() {
    return Integer.parseInt(super.selectFirstField(ARMOR_ICE_RESISTANCE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }

  /**
   * @fn selectFirstArmorDragonResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具龍耐性カラムの先頭のフィールドを返す
   * @return 防具龍耐性の先頭のフィールド
   */
  public int selectFirstArmorDragonResistance() {
    return Integer.parseInt(super.selectFirstField(ARMOR_DRAGON_RESISTANCE, PLAYERS_STATUSES_SEARCH, PLAYER_CODE));
  }
}
