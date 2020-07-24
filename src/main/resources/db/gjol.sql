/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : gjol

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 24/07/2020 15:07:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for big_rigion
-- ----------------------------
DROP TABLE IF EXISTS `big_rigion`;
CREATE TABLE `big_rigion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of big_rigion
-- ----------------------------
INSERT INTO `big_rigion` VALUES (1, '官服');
INSERT INTO `big_rigion` VALUES (2, 'wegame');
INSERT INTO `big_rigion` VALUES (3, '360');

-- ----------------------------
-- Table structure for camp
-- ----------------------------
DROP TABLE IF EXISTS `camp`;
CREATE TABLE `camp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of camp
-- ----------------------------
INSERT INTO `camp` VALUES (1, '神一道天');
INSERT INTO `camp` VALUES (2, '天玄教');
INSERT INTO `camp` VALUES (3, '秦陵之盟');

-- ----------------------------
-- Table structure for login_record
-- ----------------------------
DROP TABLE IF EXISTS `login_record`;
CREATE TABLE `login_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime(0) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_record
-- ----------------------------
INSERT INTO `login_record` VALUES (1, '2020-07-24 10:59:12', 1);

-- ----------------------------
-- Table structure for mastery
-- ----------------------------
DROP TABLE IF EXISTS `mastery`;
CREATE TABLE `mastery`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mastery
-- ----------------------------
INSERT INTO `mastery` VALUES (1, '攻击');
INSERT INTO `mastery` VALUES (2, '防御');
INSERT INTO `mastery` VALUES (3, '治疗');

-- ----------------------------
-- Table structure for message_board
-- ----------------------------
DROP TABLE IF EXISTS `message_board`;
CREATE TABLE `message_board`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(0) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKqf78hi0aeuvclxjm0fnrbe54s`(`user_id`) USING BTREE,
  CONSTRAINT `FKqf78hi0aeuvclxjm0fnrbe54s` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for profession
-- ----------------------------
DROP TABLE IF EXISTS `profession`;
CREATE TABLE `profession`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sects_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKii7uy6qig33v2e9vix3xr55wy`(`sects_id`) USING BTREE,
  CONSTRAINT `FKii7uy6qig33v2e9vix3xr55wy` FOREIGN KEY (`sects_id`) REFERENCES `sects` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of profession
-- ----------------------------
INSERT INTO `profession` VALUES (1, '神虹诀', 1);
INSERT INTO `profession` VALUES (2, '飞星篇', 1);
INSERT INTO `profession` VALUES (3, '三十六章', 2);
INSERT INTO `profession` VALUES (4, '洞渊书', 2);
INSERT INTO `profession` VALUES (5, '唤灵咒', 3);
INSERT INTO `profession` VALUES (6, '娲圣祝由咒', 3);
INSERT INTO `profession` VALUES (7, '窈冥蛊咒', 4);
INSERT INTO `profession` VALUES (8, '圣佑血祭', 4);
INSERT INTO `profession` VALUES (9, '龙城飞将', 5);
INSERT INTO `profession` VALUES (10, '玄武护身', 5);
INSERT INTO `profession` VALUES (11, '酩酊诀', 6);
INSERT INTO `profession` VALUES (12, '弹铗九问', 6);
INSERT INTO `profession` VALUES (13, '花非花', 7);
INSERT INTO `profession` VALUES (14, '香云绕', 7);
INSERT INTO `profession` VALUES (15, '苍石金刀', 8);
INSERT INTO `profession` VALUES (16, '风雨不动', 8);
INSERT INTO `profession` VALUES (17, '贯日御风', 9);

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `big_rigion_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK17jkvexdf3lsnsfyw2grjy51a`(`big_rigion_id`) USING BTREE,
  CONSTRAINT `FK17jkvexdf3lsnsfyw2grjy51a` FOREIGN KEY (`big_rigion_id`) REFERENCES `big_rigion` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES (1, '太华山', 1);
INSERT INTO `region` VALUES (2, '天鹿城', 1);
INSERT INTO `region` VALUES (3, '流月城', 1);
INSERT INTO `region` VALUES (4, '流花宫', 1);
INSERT INTO `region` VALUES (5, '迎仙门', 1);
INSERT INTO `region` VALUES (6, '腾雾台', 1);
INSERT INTO `region` VALUES (7, '国色庄', 1);
INSERT INTO `region` VALUES (8, '玉皇池', 1);
INSERT INTO `region` VALUES (9, '游龙滩', 1);
INSERT INTO `region` VALUES (10, '百草谷', 1);
INSERT INTO `region` VALUES (11, '天墉城', 1);
INSERT INTO `region` VALUES (12, '补天岭', 1);
INSERT INTO `region` VALUES (13, '梦付千秋', 1);
INSERT INTO `region` VALUES (14, '永夜初晗', 1);
INSERT INTO `region` VALUES (15, '琴心剑魄', 1);
INSERT INTO `region` VALUES (16, '星火竟天', 1);
INSERT INTO `region` VALUES (17, '剑舞飞花', 1);
INSERT INTO `region` VALUES (18, '沙海遗珠', 1);
INSERT INTO `region` VALUES (19, '名动瀚海', 1);
INSERT INTO `region` VALUES (20, '梦回太古', 2);
INSERT INTO `region` VALUES (21, '晴风暖雪', 2);
INSERT INTO `region` VALUES (22, '星虹贯月', 2);
INSERT INTO `region` VALUES (23, '龙星领域', 2);
INSERT INTO `region` VALUES (24, '沧江龙吟', 3);

-- ----------------------------
-- Table structure for role_for_camp
-- ----------------------------
DROP TABLE IF EXISTS `role_for_camp`;
CREATE TABLE `role_for_camp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `camp_id` int(11) DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK8b1hc85ehvnjks5gpgw11jk4n`(`camp_id`) USING BTREE,
  INDEX `FKgkrrl6c2a548o44ahw5ycubgk`(`user_role_id`) USING BTREE,
  CONSTRAINT `FK8b1hc85ehvnjks5gpgw11jk4n` FOREIGN KEY (`camp_id`) REFERENCES `camp` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKgkrrl6c2a548o44ahw5ycubgk` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_for_mastery
-- ----------------------------
DROP TABLE IF EXISTS `role_for_mastery`;
CREATE TABLE `role_for_mastery`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mastery_id` int(11) DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK509dm2v8chj0vr5gcb2rva413`(`mastery_id`) USING BTREE,
  INDEX `FKbdb8bnm4f1nogliu9pe43qh3y`(`user_role_id`) USING BTREE,
  CONSTRAINT `FK509dm2v8chj0vr5gcb2rva413` FOREIGN KEY (`mastery_id`) REFERENCES `mastery` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKbdb8bnm4f1nogliu9pe43qh3y` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_for_profession
-- ----------------------------
DROP TABLE IF EXISTS `role_for_profession`;
CREATE TABLE `role_for_profession`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profession_id` int(11) DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKj8hh53wa92amtb69yywr7j3u1`(`profession_id`) USING BTREE,
  INDEX `FKkvxx2smrx15hi0its95ayb07t`(`user_role_id`) USING BTREE,
  CONSTRAINT `FKj8hh53wa92amtb69yywr7j3u1` FOREIGN KEY (`profession_id`) REFERENCES `profession` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKkvxx2smrx15hi0its95ayb07t` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_for_region
-- ----------------------------
DROP TABLE IF EXISTS `role_for_region`;
CREATE TABLE `role_for_region`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `region_id` int(11) DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKjw0h8c1qo9c8roaed6l9wtufo`(`region_id`) USING BTREE,
  INDEX `FKqpwjrho872u5ydpo4ceilu49k`(`user_role_id`) USING BTREE,
  CONSTRAINT `FKjw0h8c1qo9c8roaed6l9wtufo` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKqpwjrho872u5ydpo4ceilu49k` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_for_team
-- ----------------------------
DROP TABLE IF EXISTS `role_for_team`;
CREATE TABLE `role_for_team`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKikmac9xlya6rr76fxjjrodqv6`(`team_id`) USING BTREE,
  INDEX `FK18tlw27rf8bci9e390q2k64hp`(`user_role_id`) USING BTREE,
  CONSTRAINT `FK18tlw27rf8bci9e390q2k64hp` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKikmac9xlya6rr76fxjjrodqv6` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_for_user
-- ----------------------------
DROP TABLE IF EXISTS `role_for_user`;
CREATE TABLE `role_for_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK9k4yppovniiyvpsewi4buuy24`(`user_id`) USING BTREE,
  INDEX `FKs1khrrutsb4jcw22e19j9sksm`(`user_role_id`) USING BTREE,
  CONSTRAINT `FK9k4yppovniiyvpsewi4buuy24` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKs1khrrutsb4jcw22e19j9sksm` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sects
-- ----------------------------
DROP TABLE IF EXISTS `sects`;
CREATE TABLE `sects`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sects
-- ----------------------------
INSERT INTO `sects` VALUES (1, '#436a7b', '御剑');
INSERT INTO `sects` VALUES (2, NULL, '妙法');
INSERT INTO `sects` VALUES (3, '#398875', '司命');
INSERT INTO `sects` VALUES (4, NULL, '咒隐');
INSERT INTO `sects` VALUES (5, '#8a2229', '天罡');
INSERT INTO `sects` VALUES (6, '#1f7131', '斩风');
INSERT INTO `sects` VALUES (7, '#ebded5', '异芳');
INSERT INTO `sects` VALUES (8, '#584a85', '珑瑛');
INSERT INTO `sects` VALUES (9, '#7e4122', '朝弦');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime(0) DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `team_leader_id` int(11) DEFAULT NULL,
  `is_public` bit(1) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKs2bnkde5uftqmee40qf4dmc5n`(`team_leader_id`) USING BTREE,
  CONSTRAINT `FKs2bnkde5uftqmee40qf4dmc5n` FOREIGN KEY (`team_leader_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `wx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, NULL, 'one@taokoo.com', '123456', NULL, NULL, NULL, 'taokoo', NULL, NULL, NULL, NULL, 1, 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equip_lv` int(11) DEFAULT NULL,
  `is_big` bit(1) DEFAULT NULL,
  `is_leader` bit(1) DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  `camp_id` int(11) DEFAULT NULL,
  `profession_id` int(11) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_public` bit(1) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mastery_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK9nbt6cn7w3dcjr412vre5gcw6`(`region_id`) USING BTREE,
  INDEX `FK89mblfdcqx4n6iwjt7tew7t62`(`camp_id`) USING BTREE,
  INDEX `FK2j1in4rnw3r6ih2juo4honhx0`(`profession_id`) USING BTREE,
  INDEX `FKabqmdr8rans6cx16tp53joand`(`team_id`) USING BTREE,
  INDEX `FK859n2jvi8ivhui0rl0esws6o`(`user_id`) USING BTREE,
  INDEX `FKosc9vfugihsujvvvorecfwso9`(`mastery_id`) USING BTREE,
  CONSTRAINT `FK2j1in4rnw3r6ih2juo4honhx0` FOREIGN KEY (`profession_id`) REFERENCES `profession` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK89mblfdcqx4n6iwjt7tew7t62` FOREIGN KEY (`camp_id`) REFERENCES `camp` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK9nbt6cn7w3dcjr412vre5gcw6` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKabqmdr8rans6cx16tp53joand` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKosc9vfugihsujvvvorecfwso9` FOREIGN KEY (`mastery_id`) REFERENCES `mastery` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role_mastery
-- ----------------------------
DROP TABLE IF EXISTS `user_role_mastery`;
CREATE TABLE `user_role_mastery`  (
  `user_role_id` int(11) NOT NULL,
  `mastery_id` int(11) NOT NULL,
  UNIQUE INDEX `UK_ria5l2p2o1mo3c1rj8qr1t5mf`(`mastery_id`) USING BTREE,
  INDEX `FKc15xotrj3qdcq42mo8rdngcti`(`user_role_id`) USING BTREE,
  CONSTRAINT `FKc15xotrj3qdcq42mo8rdngcti` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh8gxhpkhkf5syxnp4iyo28m86` FOREIGN KEY (`mastery_id`) REFERENCES `mastery` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
