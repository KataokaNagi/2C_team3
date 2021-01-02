/**
* @file      MonsterMainHpDAO.java
* @brief     「モンスター総合体力」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 19:32:08
* $Version   1.1
* $Revision  1.3
* @par       リファクタリング：テーブル名とPK名をメンバ変数へ
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

/**
 * @class MonsterMainHpDAO
 * @brief 「モンスター総合体力」テーブルのDAO
 */
public class MonsterMainHpDAO extends BattleDAO {

  private final String TABLE_NAME = "monster_main_hitpoints";
  private final String PRIMARY_KEY_COLUMN_NAME = "monster_code";

  /**
   * @fn MonsterMainHpDAO
   * @brief 「モンスター総合体力」テーブルの作成を行うコンストラクタ
   */
  public MonsterMainHpDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    this.createMonsterMainHpTable();
    this.createMonsterMainHpIdx();
  }

  /**
   * @fn createMonsterMainHpTable
   * @brief 「モンスター総合体力」テーブルの作成
   */
  private void createMonsterMainHpTable() {
    // TODO
  }

  /**
   * @fn dropMonsterMainHpTable
   * @brief 「モンスター総合体力」テーブルの削除
   */
  public void dropMonsterMainHpTable() {
    // TODO
  }

  /**
   * @fn createMonsterMainHpIdx
   * @brief テーブルのインデックスを張る
   */
  private void createMonsterMainHpIdx() {
    String idxName = "idx_" + TABLE_NAME;
    String idxColumnName = PRIMARY_KEY_COLUMN_NAME;
    super.createIdx(idxName, TABLE_NAME, idxColumnName);
  }

  /**
   * @fn selectFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを返す
   * @return モンスター体力の先頭のフィールド
   */
  public int selectFirstMonsterMainHp() {
    String columnName = "monster_main_hitpoint";
    return Integer.parseInt(super.selectFirstField(columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME));
  }

  /**
   * @fn updateFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを更新
   */
  public void updateFirstMonsterMainHp(int monsterMainHp) {
    String columnName = "monster_main_hitpoint";
    super.updateFirstField(Integer.toString(monsterMainHp), columnName, TABLE_NAME, PRIMARY_KEY_COLUMN_NAME);
  }
}
