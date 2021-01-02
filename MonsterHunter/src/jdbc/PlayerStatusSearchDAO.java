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

/**
 * @class PlayerStatusSearchDAO
 * @brief 「プレイヤーステータス検索」テーブルのDAO
 */
public class PlayerStatusSearchDAO extends BattleDAO {

  private final String TABLE_NAME = "players_statuses";
  private final String PRIMARY_KEY_COLUMN_NAME = "player_code";

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
    String idxName = "idx_" + TABLE_NAME;
    String idxColumnName = PRIMARY_KEY_COLUMN_NAME;
    super.createIdx(idxName, TABLE_NAME, idxColumnName);
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
    String columnName = "weapon_code";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstWeaponName
   * @brief 「プレイヤーステータス検索」テーブルの、武器名カラムの先頭のフィールドを返す
   * @return 武器名の先頭のフィールド
   */
  public String selectFirstWeaponName() {
    String columnName = "weapon_name";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstWeaponAttackVal
   * @brief 「プレイヤーステータス検索」テーブルの、武器攻撃力カラムの先頭のフィールドを返す
   * @return 武器攻撃力の先頭のフィールド
   */
  public int selectFirstWeaponAttackVal() {
    String columnName = "weapon_value";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstWeaponCriticalRate
   * @brief 「プレイヤーステータス検索」テーブルの、武器会心率カラムの先頭のフィールドを返す
   * @return 武器会心率の先頭のフィールド
   */
  public float selectFirstWeaponCriticalRate() {
    String columnName = "weapon_criticalRate";
    return Float.parseFloat(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstWeaponElementVal
   * @brief 「プレイヤーステータス検索」テーブルの、武器属性数値カラムの先頭のフィールドを返す
   * @return 武器属性数値の先頭のフィールド
   */
  public int selectFirstWeaponElementVal() {
    String columnName = "weapon_element_value";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstWeaponElementCode
   * @brief 「プレイヤーステータス検索」テーブルの、武器属性コードカラムの先頭のフィールドを返す
   * @return 武器属性コードの先頭のフィールド
   */
  public String selectFirstWeaponElementCode() {
    String columnName = "weapon_element_code";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstWeaponElementName
   * @brief 「プレイヤーステータス検索」テーブルの、武器属性名カラムの先頭のフィールドを返す
   * @return 武器属性名の先頭のフィールド
   */
  public String selectFirstWeaponElementName() {
    String columnName = "weapon_element_name";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstArmorCode
   * @brief 「プレイヤーステータス検索」テーブルの、防具コードカラムの先頭のフィールドを返す
   * @return 防具コードの先頭のフィールド
   */
  public String selectFirstArmorCode() {
    String columnName = "armor_code";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstArmorName
   * @brief 「プレイヤーステータス検索」テーブルの、防具コードカラムの先頭のフィールドを返す
   * @return 防具コードの先頭のフィールド
   */
  public String selectFirstArmorName() {
    String columnName = "aromor_name";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstArmorDiffenceVal
   * @brief 「プレイヤーステータス検索」テーブルの、防具防御力カラムの先頭のフィールドを返す
   * @return 防具防御力の先頭のフィールド
   */
  public int selectFirstArmorDiffenceVal() {
    String columnName = "aromor_diffence_value";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstArmorSkillCode
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキルコードカラムの先頭のフィールドを返す
   * @return 防具スキルコードの先頭のフィールド
   */
  public String selectFirstArmorSkillCode() {
    String columnName = "aromor_skill_code";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstArmorSkillName
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキル名カラムの先頭のフィールドを返す
   * @return 防具スキル名の先頭のフィールド
   */
  public String selectFirstArmorSkillName() {
    String columnName = "aromor_skill_name";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstArmorIncreasingSkillTarget
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキル上昇対象カラムの先頭のフィールドを返す
   * @return 防具スキル上昇対象の先頭のフィールド
   */
  public String selectFirstArmorIncreasingSkillTarget() {
    String columnName = "aromor_increasing_skill_target";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstArmorIncreasingSkillVal
   * @brief 「プレイヤーステータス検索」テーブルの、防具スキル上昇数値カラムの先頭のフィールドを返す
   * @return 防具スキル上昇数値の先頭のフィールド
   */
  public int selectFirstArmorIncreasingSkillVal() {
    String columnName = "aromor_increasing_skill_value";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstArmorElementResistanceCode
   * @brief 「プレイヤーステータス検索」テーブルの、防具属性耐性コードカラムの先頭のフィールドを返す
   * @return 防具属性耐性コードの先頭のフィールド
   */
  public String selectFirstArmorElementResistanceCode() {
    String columnName = "aromor_element_resistance_code";
    return super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }

  /**
   * @fn selectFirstArmorFireResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具火耐性カラムの先頭のフィールドを返す
   * @return 防具火耐性の先頭のフィールド
   */
  public int selectFirstArmorFireResistance() {
    String columnName = "aromor_fire_resistance";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstArmorWaterResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具水耐性カラムの先頭のフィールドを返す
   * @return 防具水耐性の先頭のフィールド
   */
  public int selectFirstArmorWaterResistance() {
    String columnName = "aromor_water_resistance";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstArmorElectricResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具雷耐性カラムの先頭のフィールドを返す
   * @return 防具雷耐性の先頭のフィールド
   */
  public int selectFirstArmorElectricResistance() {
    String columnName = "aromor_electric_resistance";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstArmorIceResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防こ氷耐性カラムの先頭のフィールドを返す
   * @return 防こ氷耐性の先頭のフィールド
   */
  public int selectFirstArmorIceResistance() {
    String columnName = "aromor_ice_resistance";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn selectFirstArmorDragonResistance
   * @brief 「プレイヤーステータス検索」テーブルの、防具龍耐性カラムの先頭のフィールドを返す
   * @return 防具龍耐性の先頭のフィールド
   */
  public int selectFirstArmorDragonResistance() {
    String columnName = "aromor_dragon_resistance";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }
}
