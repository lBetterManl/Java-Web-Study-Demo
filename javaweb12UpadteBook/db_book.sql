/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : db_book

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2016-04-21 21:10:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES ('1', 'java', 'yy', '78');
INSERT INTO `t_book` VALUES ('2', 'C语言', 'pp', '52');
INSERT INTO `t_book` VALUES ('3', 'PHP', 'tt', '42');
INSERT INTO `t_book` VALUES ('4', 'Go', 'sd', '13');
INSERT INTO `t_book` VALUES ('5', 'DGDS', 'sdf', '27');
INSERT INTO `t_book` VALUES ('6', 'AEV', 'sds', '72');
INSERT INTO `t_book` VALUES ('7', 'ACS', 'gd', '48');
INSERT INTO `t_book` VALUES ('8', 'EGY', 'xv', '16');
INSERT INTO `t_book` VALUES ('9', 'JH', 'd', '45');
INSERT INTO `t_book` VALUES ('10', 'kg', 'g', '34');
INSERT INTO `t_book` VALUES ('11', 'th', 'eg', '38');
