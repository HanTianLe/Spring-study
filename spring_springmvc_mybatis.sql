/*
Navicat MySQL Data Transfer

Source Server         : mysql-8.0.16
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : spring_springmvc_mybatis

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-09-24 07:35:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `money` double(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '张三', '10000.00');
INSERT INTO `account` VALUES ('4', '李四', '4000.00');
INSERT INTO `account` VALUES ('5', '赵6', '6666.00');
INSERT INTO `account` VALUES ('6', '韩天乐', '50000.00');
INSERT INTO `account` VALUES ('7', '韩天琪', '12312.00');
INSERT INTO `account` VALUES ('8', '李四1111111', '10000.00');
INSERT INTO `account` VALUES ('9', '韩天喜', '20000.00');
INSERT INTO `account` VALUES ('10', '赵六敏感词呵呵', '10000.00');
