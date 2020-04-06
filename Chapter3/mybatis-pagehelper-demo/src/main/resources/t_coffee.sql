/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 05/04/2020 14:25:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_coffee
-- ----------------------------
DROP TABLE IF EXISTS `t_coffee`;
CREATE TABLE `t_coffee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_coffee
-- ----------------------------
BEGIN;
INSERT INTO `t_coffee` VALUES (3, 'espresso', 2000, '2020-04-05', '2020-04-05');
INSERT INTO `t_coffee` VALUES (4, 'latte', 2500, '2020-04-05', '2020-04-05');
INSERT INTO `t_coffee` VALUES (5, 'capuccino', 2500, '2020-04-05', '2020-04-05');
INSERT INTO `t_coffee` VALUES (6, 'mocha', 3000, '2020-04-05', '2020-04-05');
INSERT INTO `t_coffee` VALUES (7, 'macchiato', 3000, '2020-04-05', '2020-04-05');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
