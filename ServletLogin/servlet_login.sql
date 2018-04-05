/*
Navicat MySQL Data Transfer

Source Server         : conn
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : servlet_login

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-11-17 18:51:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
