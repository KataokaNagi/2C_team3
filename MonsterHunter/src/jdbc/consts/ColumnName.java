/**
* @file      ColumnName.java
* @brief     カラム名（定数）の列挙
* @note      高度情報演習2C 後半 木村教授担当分 Team3
* @auther    AL18036 Kataoka Nagi
* @date      2021-01-11 05:11:51
* $Version   1.0
* $Revision  1.0
* @par       追加点　：新規作成
* @par       変更予定：デバッグ文のコメントアウト
* @see       片岡のenumメモ https://hackmd.io/@xcalmx/ryXX-gdAw
* @see       データベースオブジェクトの命名規約 https://qiita.com/genzouw/items/35022fa96c120e67c637
*/

package jdbc.consts;

import jdbc.utils.DebugUtil;

public enum ColumnName implements Consts {

  /////////////////////////
  // ユーザー選択
  /////////////////////////
  // ユーザー選択
  USER_SELECTE_CODE, // ユーザー選択コード
  MONSTER_CODE, // モンスターコード
  WEAPON_CODE, // 武器コード
  ARMOR_CODE, // 防具コード
  PLAYER_CODE, // プレイヤーコード

  /////////////////////////
  // プレイヤー関係
  /////////////////////////
  // プレイヤー
  PLAYER_HITPOINT, // プレイヤー体力

  /////////////////////////
  // 武器
  /////////////////////////
  // 武器
  WEAPON_NAME, // 武器名
  WEAPON_ATTACK_VALUE, // 武器攻撃力
  WEAPON_CRITIVAL_RATE, // 武器会心率
  WEAPON_ELEMENT_VALUE, // 武器属性数値
  WEAPON_ELEMENT_CODE, // 武器属性コード

  // 武器切れ味 ※不可算名詞
  WEAPON_SHARPNESS_COLOR_CODE, // 切れ味色コード
  WEAPON_SHARPNESS_COLOR_GAGE_AMOUNT, // 切れ味色ゲージ量
  WEAPON_SHARPNESS_ATTACK_VALUE_RATE, // 切れ味攻撃力倍率

  // 武器切れ味色
  WEAPON_SHARPNESS_COLOR_NAME, // 切れ味色名

  // 武器属性
  WEAPON_ELEMENT_NAME, // 武器属性名

  /////////////////////////
  // 防具関係
  /////////////////////////
  // 防具
  ARMOR_NAME, // 防具名
  ARMOR_DIFFENCE_VALUE, // 防具防御力
  ARMOR_SKILL_CODE, // 防具スキルコード
  ARMOR_ELEMENT_RESISTANCE_CODE, // 防具耐性コード

  // 防具属性耐性
  ARMOR_FIRE_RESISTANCE, // 防具火耐性
  ARMOR_WATER_RESISTANCE, // 防具水耐性
  ARMOR_ICE_RESISTANCE, // 防具氷耐性
  ARMOR_THUNDER_RESISTANCE, // 防具雷耐性
  ARMOR_DRAGON_RESISTANCE, // 防具龍耐性

  // 防具スキル
  ARMOR_SKILL_NAME, // 防具スキル名
  ARMOR_SKILL_INCREASE_TARGET, // 防具スキル上昇対象
  ARMOR_SKILL_INCREASE_VALUE, // 防具スキル上昇値

  /////////////////////////
  // モンスター関係
  /////////////////////////
  // モンスター
  MONSTER_NAME, // モンスター名
  MONSTER_MAIN_HITPOINT, // モンスター体力
  MONSTER_FIRE_RESISTANCE, // モンスター火耐性
  MONSTER_WATER_RESISTANCE, // モンスター水耐性
  MONSTER_ICE_RESISTANCE, // モンスター氷耐性
  MONSTER_THUNDER_RESISTANCE, // モンスター雷耐性
  MONSTER_DRAGON_RESISTANCE, // モンスター龍耐性

  // モンスター部位
  MONSTER_PART_CODE, // モンスター部位コード
  MONSTER_PART_HITPOINT, // モンスター部位体力
  MONSTER_PART_HARDNESS, // モンスター部位肉質

  // モンスター部位名
  MONSTER_PART_NAME, // モンスター部位名

  // モンスター攻撃
  MONSTER_ATTACK_CODE, // モンスター攻撃コード
  MONSTER_ATTACK_NAME, // モンスター攻撃名
  MONSTER_ATTACK_VALUE, // モンスター攻撃力
  MONSTER_ATTACK_MISS_PROBABILITY; // モンスター攻撃ミス確率

  /**
   * @fn ColumnName
   * @brief コンストラクタ
   */
  private ColumnName() {
  }

  /**
   * @fn toLowerCase
   * @return String DBで使用する列挙子のキャメルケース版
   */
  public String toLowerCase() {
    String rtnStr = this.name().toLowerCase();
    System.out.println("return : " + rtnStr + DebugUtil.getProcessPositionStr());
    return rtnStr;
  }
}
