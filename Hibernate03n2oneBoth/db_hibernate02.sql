/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : db_hibernate02

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2016-05-08 20:27:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `CUSTOMER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', 'AA');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_NAME` varchar(255) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ORDER_ID`),
  KEY `FK_57wwsm6wqqkcr1amp4dtsk5bs` (`CUSTOMER_ID`),
  CONSTRAINT `FK_57wwsm6wqqkcr1amp4dtsk5bs` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `customers` (`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'ORDER-1', '1');
INSERT INTO `orders` VALUES ('2', 'ORDER-2', '1');
