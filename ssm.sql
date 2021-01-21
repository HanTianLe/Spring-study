/*
Navicat MySQL Data Transfer

Source Server         : mysql-8.0.16
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-09-24 07:41:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roleDesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '院长', '负责全面工作');
INSERT INTO `sys_role` VALUES ('2', '研究员', '课程研发工作');
INSERT INTO `sys_role` VALUES ('3', '讲师', '授课工作');
INSERT INTO `sys_role` VALUES ('4', '助教', '协助解决学生的问题');
INSERT INTO `sys_role` VALUES ('5', '班主任', '专门解决学生斗殴问题');
INSERT INTO `sys_role` VALUES ('6', '就业指导', '负责忽悠');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '刘成盛', 'wangwu@itcast.cn', '123', '18599999999');
INSERT INTO `sys_user` VALUES ('2', '韩天乐', 'hantianlehh@163.com', '123', '13999999999');
INSERT INTO `sys_user` VALUES ('3', '陈权', 'wangwu@itcast.cn', '123', '18599999999');
INSERT INTO `sys_user` VALUES ('4', '测试1', 'wangwu@itcast.cn', '123', '18599999999');
INSERT INTO `sys_user` VALUES ('5', '测试2', 'wangwu@itcast.cn', '123', '18599999999');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`) USING BTREE,
  KEY `roleId` (`roleId`) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('2', '3');
INSERT INTO `sys_user_role` VALUES ('4', '3');
INSERT INTO `sys_user_role` VALUES ('4', '4');
INSERT INTO `sys_user_role` VALUES ('5', '6');
