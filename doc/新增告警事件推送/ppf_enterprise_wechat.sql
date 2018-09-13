/*
Navicat MySQL Data Transfer

Source Server         : 172.16.5.12
Source Server Version : 50528
Source Host           : 172.16.5.12:3306
Source Database       : emcp_0711

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-24 16:26:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ppf_enterprise_wechat
-- ----------------------------
DROP TABLE IF EXISTS `ppf_enterprise_wechat`;
CREATE TABLE `ppf_enterprise_wechat` (
  `open_id` varchar(40) NOT NULL,
  `enterprise_id` int(11) NOT NULL,
  `account` varchar(40) NOT NULL COMMENT '登录账号',
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
