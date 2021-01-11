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

import static jdbc.consts.ColumnName.*;
import static jdbc.consts.DenormalizedTableName.*;
import static jdbc.consts.IdxName.*;

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
    super.createIdx(TODO, MONSTERS_MAIN_HITPOINTS, MONSTER_CODE);
  }

  /**
   * @fn selectFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを返す
   * @return モンスター体力の先頭のフィールド
   */
  public int selectFirstMonsterMainHp() {
    return Integer.parseInt(super.selectFirstField(MONSTER_MAIN_HITPOINT, MONSTERS_MAIN_HITPOINTS, MONSTER_CODE));
  }

  /**
   * @fn updateFirstMonsterMainHp
   * @brief 「モンスター総合体力」テーブルの、モンスター体力カラムの先頭のフィールドを更新
   */
  public void updateFirstMonsterMainHp(int monsterMainHp) {
    super.updateFirstField(Integer.toString(monsterMainHp), MONSTER_MAIN_HITPOINT, MONSTERS_MAIN_HITPOINTS,
        MONSTER_CODE);
  }
}
