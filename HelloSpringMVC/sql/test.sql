/*
Navicat MySQL Data Transfer

Source Server         : msqyl2
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2018-07-24 16:39:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '财务部');
INSERT INTO `department` VALUES ('2', '开发部');
INSERT INTO `department` VALUES ('3', '人事部');
INSERT INTO `department` VALUES ('4', '公关部');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('1', 'Tom', 'tom@163.com', '1');
INSERT INTO `employees` VALUES ('2', 'Jerry', 'jerry@163.com', '2');
INSERT INTO `employees` VALUES ('3', 'Mike', 'mike@163.com', '3');
INSERT INTO `employees` VALUES ('4', 'Rose', 'rose@163.com', '4');
INSERT INTO `employees` VALUES ('5', 'Jack', 'david@163.com', '5');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `account` decimal(10,0) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '咖啡', '1314520', '7000', null, null);
INSERT INTO `t_user` VALUES ('2', '咖啡', '1314520', '7000', null, null);
INSERT INTO `t_user` VALUES ('3', '咖啡', '1314520', '7000', null, null);
INSERT INTO `t_user` VALUES ('4', '咖啡', '1314520', '7000', null, null);
INSERT INTO `t_user` VALUES ('5', '咖啡', '1314520', '7000', null, null);
INSERT INTO `t_user` VALUES ('6', '咖啡', '1314520', '7000', null, null);
INSERT INTO `t_user` VALUES ('7', '咖啡', '1314520', '7000', null, null);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '中国');
INSERT INTO `user_info` VALUES ('3', 'Add from Hibernate-中文');
