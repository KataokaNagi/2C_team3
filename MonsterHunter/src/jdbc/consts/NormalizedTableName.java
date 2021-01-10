/**
* @file      NormalizedTableName.java
* @brief     正規化テーブル名（定数）の列挙
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-11 04:55:28
* $Version   1.0
* $Revision  1.0
* @par       追加点　：新規作成
* @par       変更予定：デバッグ文のコメントアウト
* @see       片岡のenumメモ https://hackmd.io/@xcalmx/ryXX-gdAw
* @see       データベースオブジェクトの命名規約 https://qiita.com/genzouw/items/35022fa96c120e67c637
*/

package jdbc.consts;

public enum NormalizedTableName {

  // ユーザー選択
  USERS_SELECTES, // ユーザー選択

  // プレイヤー関係
  PLAYERS, // プレイヤー

  // 武器関係
  WEAPONS, // 武器
  WEAPONS_SHARPNESS, // 武器切れ味 ※不可算名詞
  WEAPONS_SHARPNESS_COLORS, // 武器切れ味色
  WEAPONS_ELEMENTS, // 武器属性

  // 防具関係
  ARMORS, // 防具
  ARMORS_ELEMENTS_RESISTANCES, // 防具属性耐性
  ARMORS_SKILLS, // 防具スキル

  // モンスター関係
  MONSTERS, // モンスター
  MONSTERS_PARTS, // モンスター部位
  MONSTERS_PARTS_NAMES, // モンスター部位名
  MONSTERS_ATTACKS; // モンスター攻撃

  /**
   * @fn NormalizedTableName
   * @brief コンストラクタ
   */
  private NormalizedTableName() {
  }

  /**
   * @fn toLowerCase
   * @return String DBで使用する列挙子のキャメルケース版
   */
  public String toLowerCase() {
    String rtnStr = this.name().toLowerCase();
    System.out.println("TableName.toLowerCase() being used (return : " + rtnStr + ")");
    return rtnStr;
  }
}
