/**
* @file      IdxName.java
* @brief     正規化インデックス名（定数）の列挙
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-11 08:59:25
* $Version   1.0
* $Revision  1.0
* @par       追加点　：新規作成
* @par       変更予定：インデックス名の列挙
* @see       片岡のenumメモ https://hackmd.io/@xcalmx/ryXX-gdAw
* @see       データベースオブジェクトの命名規約 https://qiita.com/genzouw/items/35022fa96c120e67c637
*/

package jdbc.consts;

import jdbc.utils.DebugUtil;

public enum IdxName implements Consts {

  // ユーザー選択関係
  // なし

  // プレイヤー関係
  IDX_PLAYERS_HITPOINTS, // プレイヤー体力
  IDX_PLAYERS_STATUSES_SEARCH, // プレイヤーステータス検索
  IDX_SHARPNESS_COLORS_SEARCH, // 切れ味色ごと検索 ※SHARPNESSは負可算名詞

  // モンスター関係
  IDX_MONSTERS_MAIN_HITPOINTS, // モンスター総合体力
  IDX_MONSTERS_PARTS_HITPOINTS, // モンスター部位体力
  IDX_MONSTERS_ATTACKS_STATUSES_SEARCH; // モンスター攻撃ステータス検索

  /**
   * @fn IdxName
   * @brief コンストラクタ
   */
  private IdxName() {
  }

  /**
   * @fn toLowerCase
   * @return String DBで使用する列挙子のキャメルケース版
   */
  public String toLowerCase() {
    String rtnStr = this.name().toLowerCase();
    // System.out.println("return : " + rtnStr + DebugUtil.getProcessPositionStr());
    return rtnStr;
  }
}
