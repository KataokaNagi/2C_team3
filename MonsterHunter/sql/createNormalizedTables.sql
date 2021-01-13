  ------------------------------
  -- // ユーザー選択
  ------------------------------ 
  --  // ユーザー選択
CREATE TABLE
users_selects
(
  user_select_code VARCHAR(20) PRIMARY KEY,
  monster_code VARCHAR(20),
  weapon_code VARCHAR(20),
  armor_code VARCHAR(20),
  player_code VARCHAR(20)
);


  ------------------------------
  -- // プレイヤー関係
  ------------------------------
  --  // プレイヤー
CREATE TABLE
players
(
  player_code VARCHAR(20) PRIMARY KEY,
  player_main_hitpoint INT
);


  ------------------------------
  -- // 武器関係
  ------------------------------
  --  // 武器
CREATE TABLE
weapons
(
  armor_code  VARCHAR(20) PRIMARY KEY,
  armor_name VARCHAR(20),
  armor_attack_value INT,
  armor_critical_rate REAL,
  armor_element_value INT,
  armor_element_code VARCHAR(20)
);

  --  // 武器切れ味 ※不可算名詞
CREATE TABLE
weapons_sharpness
(
  weapon_code VARCHAR(20) -- PRIMARY KEY,
  weapon_sharpness_color_code VARCHAR(20) PRIMARY KEY,
  weapon_sharpness_gauge_amount INT,
  weapon_sharpness_attack_value_rate REAL
);

  --  // 武器切れ味色
CREATE TABLE
weapons_sharpness_colors
(
  weapon_sharpness_color_code VARCHAR(20) PRIMARY KEY,
  weapon_sharpness_color_name VARCHAR(20)
);

  --  // 武器属性
CREATE TABLE
weapons_elements
(
  weapon_element_code VARCHAR(20) PRIMARY KEY,
  weapon_element_name VARCHAR(20)
);


  ------------------------------
  -- // 防具関係
  ------------------------------
  --  // 防具
CREATE TABLE
armors
(
  armor_code VARCHAR(20) PRIMARY KEY,
  armor_name VARCHAR(20),
  armor_diffence_value INT,
  armor_skill_code VARCHAR(20),
  armor_element_resistance_code VARCHAR(20)
);

  --  // 防具属性耐性
CREATE TABLE
armors_elements_resistances
(
  armor_element_resistance_code VARCHAR(20) PRIMARY KEY,
  armor_element_fire_resistance INT,
  armor_element_water_resistance INT,
  armor_element_thunder_resistance INT,
  armor_element_ice_resistance INT,
  armor_element_dragon_resistance INT
);

  --  // 防具スキル
CREATE TABLE
armors_skills
(
  armor_skill_code VARCHAR(20) PRIMARY KEY,
  armor_skill_name VARCHAR(20),
  armor_skill_increase_target VARCHAR(20),
  armor_skill_increase_value INT
);


  ------------------------------
  -- // モンスター関係
  ------------------------------
  --  // モンスター
CREATE TABLE
monsters
(
  monster_code VARCHAR(20) PRIMARY KEY,
  monster_attack_code VARCHAR(20),
  monster_fire_resistance INT,
  monster_water_resistance INT,
  monster_thunder_resistance INT,
  monster_ice_resistance INT,
  monster_dragon_resistance INT,
);

  --  // モンスター部位
CREATE TABLE
monsters_parts
(
  monster_code VARCHAR(20) -- PRIMARY KEY,
  monster_part_code VARCHAR(20) PRIMARY KEY,
  monster_part_hitpoint INT,
  monster_part_hardness INT
);

  --  // モンスター部位名
CREATE TABLE
monsters_parts_names
(
  monster_part_code VARCHAR(20) PRIMARY KEY,
  monster_part_name VARCHAR(20) 
);

-- // モンスター攻撃
CREATE TABLE
monsters_attacks
(
  monster_code VARCHAR(20) -- PRIMARY KEY,
  monster_attack_code VARCHAR(20) PRIMARY KEY,
  monster_attack_name VARCHAR(20),
  monster_attack_value INT,
  monster_attack_miss_probability REAL
);
