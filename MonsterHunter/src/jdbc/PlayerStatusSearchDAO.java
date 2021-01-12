/**
* @file      PlayerStatusSearchDAO.java
* @brief     「プレイヤーステータス検索」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-12 11:57:25
* $Version   1.0
* $Revision  1.4
* @par       追加：createTable関係
* @par       変更予定：createTable関係の結合検索を複数プレイヤーに対応（発表時点では未実装でよい）
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import static jdbc.consts.NormalizedTableName.PLAYERS;
import static jdbc.consts.NormalizedTableName.WEAPONS;
import static jdbc.consts.NormalizedTableName.WEAPONS_ELEMENTS;
import static jdbc.consts.NormalizedTableName.ARMORS;
import static jdbc.consts.NormalizedTableName.ARMORS_ELEMENTS_RESISTANCES;
import static jdbc.consts.NormalizedTableName.ARMORS_SKILLS;
import static jdbc.consts.DenormalizedTableName.PLAYERS_STATUSES_SEARCH;
import static jdbc.consts.ColumnName.*;
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
    String tableRecordDetailSQL = ""; // ! CREATE TABLE () の中身

    // SQLの作成

    // 作成する非正規化テーブルのカラムを指定
    // プレイヤーコード、
    // 武器コード、武器名、武器攻撃力、武器会心率、武器属性数値、武器属性コード
    // 武器属性名、
    // 防具コード、防具名、防具防御力、防具スキルコード、
    // 防具スキル名、防具スキル上昇対象、防具スキル上昇数値、
    // 防具属性耐性コード、
    // 防具火耐性、防具水耐性、防具雷耐性、防具氷耐性、防具龍耐性
    tableRecordDetailSQL += "AS ";
    tableRecordDetailSQL += "SELECT ";
    tableRecordDetailSQL += "PRIMARY KEY ";
    tableRecordDetailSQL += "( ";
    tableRecordDetailSQL += "PLAYERS." + PLAYER_CODE.toLowerCase();
    tableRecordDetailSQL += " )";
    tableRecordDetailSQL += ", WEAPONS." + WEAPON_CODE.toLowerCase();
    tableRecordDetailSQL += ", WEAPONS." + WEAPON_NAME.toLowerCase();
    tableRecordDetailSQL += ", WEAPONS." + WEAPON_ATTACK_VALUE.toLowerCase();
    tableRecordDetailSQL += ", WEAPONS." + WEAPON_CRITIVAL_RATE.toLowerCase();
    tableRecordDetailSQL += ", WEAPONS." + WEAPON_ELEMENT_VALUE.toLowerCase();
    tableRecordDetailSQL += ", WEAPONS." + WEAPON_ELEMENT_CODE.toLowerCase();
    tableRecordDetailSQL += ", WEAPONS_ELEMS." + WEAPON_ELEMENT_NAME.toLowerCase();
    tableRecordDetailSQL += ", ARMORS." + ARMOR_CODE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS." + ARMOR_NAME.toLowerCase();
    tableRecordDetailSQL += ", ARMORS." + ARMOR_DIFFENCE_VALUE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS." + ARMOR_SKILL_CODE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_SKILLS." + ARMOR_SKILL_NAME.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_SKILLS." + ARMOR_SKILL_INCREASE_TARGET.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_SKILLS." + ARMOR_SKILL_INCREASE_VALUE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS." + ARMOR_ELEMENT_RESISTANCE_CODE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_ELEMS." + ARMOR_FIRE_RESISTANCE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_ELEMS." + ARMOR_WATER_RESISTANCE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_ELEMS." + ARMOR_THUNDER_RESISTANCE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_ELEMS." + ARMOR_ICE_RESISTANCE.toLowerCase();
    tableRecordDetailSQL += ", ARMORS_ELEMS." + ARMOR_DRAGON_RESISTANCE.toLowerCase();

    // 結合検索の基となる正規化テーブルの名前を指定
    // 「プレイヤー」「武器」「武器属性」「防具」「防具属性耐性」「防具スキル」テーブル
    tableRecordDetailSQL += "FROM ";
    tableRecordDetailSQL += PLAYERS.toLowerCase() + " PLAYERS";
    tableRecordDetailSQL += ", " + WEAPONS.toLowerCase() + " WEAPONS";
    tableRecordDetailSQL += ", " + WEAPONS_ELEMENTS.toLowerCase() + " WEAPONS_ELEMS";
    tableRecordDetailSQL += ", " + ARMORS.toLowerCase() + " ARMORS";
    tableRecordDetailSQL += ", " + ARMORS_ELEMENTS_RESISTANCES.toLowerCase() + " ARMORS_ELEMS";
    tableRecordDetailSQL += ", " + ARMORS_SKILLS.toLowerCase() + " ARMORS_SKILLS";

    // ※※※※以下、複数テーブルの結合検索がうまく噛み合うかが少しあやしい※※※※

    // ユーザーが選択したプレイヤーコード、武器コード、防具コード、モンスターコードのみを含むレコードを使用し、
    tableRecordDetailSQL += " WHERE ";
    tableRecordDetailSQL += "PLAYERS." + PLAYER_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getPlayerCode();
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "WEAPONS." + WEAPON_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getWeaponCode();
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "ARMORS." + ARMOR_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getArmorCode();
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "MONSTERS." + MONSTER_CODE.toLowerCase();
    tableRecordDetailSQL += " = " + super.getMonsterCode();

    // テーブル「武器」「武器属性」を主キー「武器属性コード」で結合
    // テーブル「防具」「防具属性耐性」を主キー「防具属性耐性コード」で結合
    // テーブル「防具」「防具スキル」を主キー「防具スキルコード」で結合
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "WEAPONS." + WEAPON_CODE.toLowerCase();
    tableRecordDetailSQL += " = WEAPONS_ELEMS." + WEAPON_ELEMENT_CODE.toLowerCase();
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "ARMORS." + ARMOR_CODE.toLowerCase();
    tableRecordDetailSQL += " = ARMORS_ELEMS." + ARMOR_ELEMENT_RESISTANCE_CODE.toLowerCase();
    tableRecordDetailSQL += " AND ";
    tableRecordDetailSQL += "ARMORS." + ARMOR_CODE.toLowerCase();
    tableRecordDetailSQL += " = ARMORS_SKILLS." + ARMOR_SKILL_CODE.toLowerCase();

    // テーブル名を指定して非正規化テーブルを作成
    // 「プレイヤーステータス検索」テーブル
    super.createTable(PLAYERS_STATUSES_SEARCH, tableRecordDetailSQL, MONSTER_ATTACK_CODE);
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
   * @fn selectFirstPlayerCode
   * @brief 「プレイヤーステータス検索」テーブルの、プレイヤーコードカラムの最初のフィールドを返す
   * @return プレイヤーコード
   */
  public String selectFirstPlayerCode() {
    return super.selectFirstField(PLAYER_CODE, PLAYERS_STATUSES_SEARCH, WEAPON_SHARPNESS_COLOR_CODE);
  }

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
