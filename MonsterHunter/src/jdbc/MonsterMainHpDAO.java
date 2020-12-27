/**
* @file      MonsterMainHpDAO.java
* @brief     「モンスター総合体力」テーブルのDAO
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-28 06:35:01
* $Version   1.0
* $Revision  1.1
* @par       追加か仮組の作成
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

/**
 * @class MonsterMainHpDAO
 * @brief 「モンスター総合体力」テーブルのDAO
 */
public class MonsterMainHpDAO extends BattleDAO {

  /**
   * @fn MonsterMainHpDAO
   * @brief 「モンスター総合体力」テーブルの作成を行うコンストラクタ
   */
  public MonsterMainHpDAO(String weaponName, String armorName, String monsterName) {
    super(weaponName, armorName, monsterName);
    createMonsterMainHpTable();
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
   * @fn selectFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを返す
   * @return モンスター体力の先頭のフィールド
   */
  public int selectFirstMonsterMainHp() {
    String columnName = "monster_main_hp";
    String tableName = "monster_main_hp_table";
    String primaryKeyColumnName = "monster_code";
    return Integer.parseInt(selectFirstField(columnName, tableName, primaryKeyColumnName));
  }

  /**
   * @fn updateFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを更新
   */
  public void updateFirstMonsterMainHp() {
    String columnName = "monster_main_hp";
    String tableName = "monster_main_hp_table";
    String primaryKeyColumnName = "monster_code";
    this.updateFirstField(columnName, tableName, primaryKeyColumnName);
  }
}
