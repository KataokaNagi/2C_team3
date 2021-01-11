/**
* @file      MenuDAO.java
* @brief     メニュー画面で用いるデータアクセスオブジェクト
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2020-12-30 18:22:25
* $Version   1.1
* $Revision  1.1
* @par       編集：カラム、テーブル名を命名規則に合わせて変更（https://qiita.com/genzouw/items/35022fa96c120e67c637）
* @par       TODO：クエスト後に検索が不要になるようにリストに退避
* @par       TODO：ConnectionとStatementのタイミングが頻繁すぎる気がする
* @par       TODO：Debianへの対応
* @see       https://www.kenschool.jp/blog/?p=1644
*/

package jdbc;

import java.util.ArrayList;
import static jdbc.consts.ColumnName.*;
import static jdbc.consts.NormalizedTableName.*;

/**
 * @class MenuDAO
 * @brief メニュー画面で用いるデータアクセスオブジェクト
 */
public class MenuDAO extends DataAccessObject {

  /**
   * @fn selectAllWeaponName
   * @brief 武器テーブルの武器名カラムの全てのフィールドを返す
   * @return 全武器名のリスト
   */
  public MenuDAO() {
    // TODO: クエスト後に検索が不要になるようにリストに退避？
    // ↑ GUIの方でやる（やらなくてもよい）仕事ですね恐らく
  }

  /**
   * @fn selectAllWeaponName
   * @brief 武器テーブルの武器名カラムの全てのフィールドを返す
   * @return 全武器名のリスト
   */
  public ArrayList<String> selectAllWeaponName() {
    return super.selectColumn(WEAPON_NAME, WEAPONS, WEAPON_CODE);
  }

  /**
   * @fn selectAllArmorName
   * @brief 防具テーブルの防具名カラムの全てのフィールドを返す
   * @return 全防具名のリスト
   */
  public ArrayList<String> selectAllArmorName() {
    return super.selectColumn(ARMOR_NAME, ARMORS, ARMOR_CODE);
  }

  /**
   * @fn selectAllMonsterName
   * @brief モンスターテーブルのモンスター名カラムの全てのフィールドを返す
   * @return 全モンスター名のリスト
   */
  public ArrayList<String> selectAllMonsterName() {
    return super.selectColumn(MONSTER_NAME, MONSTERS, MONSTER_CODE);
  }

  /**
   * @fn selectAllWeaponAttackVal
   * @brief 武器テーブルの武器攻撃力カラムの全てのフィールドを返す
   * @return 全武器攻撃力のリスト
   */
  public ArrayList<Integer> selectAllWeaponAttackVal() {
    return super.toIntegerList(super.selectColumn(WEAPON_ATTACK_VALUE, WEAPONS, WEAPON_CODE));
  }

  /**
   * @fn selectAllArmorDiffenceVal
   * @brief 防具テーブルの防具防御力カラムの全てのフィールドを返す
   * @return 全防具防御力のリスト
   */
  public ArrayList<Integer> selectAllArmorDiffenceVal() {
    return super.toIntegerList(super.selectColumn(ARMOR_DIFFENCE_VALUE, ARMORS, ARMOR_CODE));
  }
}
