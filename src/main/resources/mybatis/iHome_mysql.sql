/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50015
Source Host           : localhost:3306
Source Database       : develop

Target Server Type    : MYSQL
Target Server Version : 50015
File Encoding         : 65001

Date: 2013-04-03 17:22:38
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '用户ID，主键32为UUID',
  `userName` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(16) NOT NULL COMMENT '密码',
  `realName` varchar(40) NOT NULL COMMENT '真实姓名',
  `sex` varchar(2) default NULL COMMENT '性别',
  `age` varchar(3) default NULL COMMENT '年龄',
  `email` varchar(100) default NULL COMMENT '邮箱'
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('AAA', 'admin', 'test', 'administrator', '男', '500', 'admin@sinamail.com');
