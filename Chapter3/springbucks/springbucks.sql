/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : springbucks

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 05/04/2020 15:01:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_coffee
-- ----------------------------
DROP TABLE IF EXISTS `t_coffee`;
CREATE TABLE `t_coffee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_coffee
-- ----------------------------
BEGIN;
INSERT INTO `t_coffee` VALUES (1, '2020-04-05 14:57:28', '2020-04-05 14:57:28', 'espresso', 2000);
INSERT INTO `t_coffee` VALUES (2, '2020-04-05 14:57:28', '2020-04-05 14:57:28', 'latte', 2500);
INSERT INTO `t_coffee` VALUES (3, '2020-04-05 14:57:28', '2020-04-05 14:57:28', 'capuccino', 2500);
INSERT INTO `t_coffee` VALUES (4, '2020-04-05 14:57:28', '2020-04-05 14:57:28', 'mocha', 3000);
INSERT INTO `t_coffee` VALUES (5, '2020-04-05 14:57:28', '2020-04-05 14:57:28', 'macchiato', 3000);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `customer` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (1, '2020-04-05 14:58:07', '2020-04-05 14:58:07', 'li lei', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_order_coffee
-- ----------------------------
DROP TABLE IF EXISTS `t_order_coffee`;
CREATE TABLE `t_order_coffee` (
  `coffee_order_id` bigint(20) NOT NULL,
  `items_id` bigint(20) NOT NULL,
  KEY `FKcm20cgbnblo27okpnlk0njdwy` (`items_id`),
  KEY `FK33ucji9dx64fyog6g17blpx9v` (`coffee_order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order_coffee
-- ----------------------------
BEGIN;
INSERT INTO `t_order_coffee` VALUES (1, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
