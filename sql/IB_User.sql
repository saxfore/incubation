/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : incubation

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 11/08/2019 17:48:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for IB_User
-- ----------------------------
DROP TABLE IF EXISTS `IB_User`;
CREATE TABLE `IB_User` (
  `id` varchar(36) PRIMARY KEY  NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `del_flag` int(2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
