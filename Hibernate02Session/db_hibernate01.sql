/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : db_hibernate01

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2016-04-22 20:53:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) DEFAULT NULL,
  `AUTHOR` varchar(255) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '哈哈哈', '帅哥', '2016-04-17 20:11:01');
INSERT INTO `news` VALUES ('2', '嘿嘿嘿', '女神', '2016-04-18 20:52:33');
INSERT INTO `news` VALUES ('3', 'HHHH', 'GG', '2016-04-18 21:32:19');
INSERT INTO `news` VALUES ('4', '帅帅帅', 'hah', '2016-04-18 21:42:04');
