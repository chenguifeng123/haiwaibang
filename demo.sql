/*
Navicat MySQL Data Transfer

Source Server         : 47.105.189.37
Source Server Version : 50624
Source Host           : 47.105.189.37:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-03-22 13:46:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tp_client`
-- ----------------------------
DROP TABLE IF EXISTS `tp_client`;
CREATE TABLE `tp_client` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Uid` int(10) DEFAULT '0' COMMENT '用户ID',
  `Cid` int(10) DEFAULT '0' COMMENT '默认联系人ID',
  `CompanyName` char(60) DEFAULT NULL COMMENT '公司名称',
  `Address` char(100) DEFAULT NULL COMMENT '详细地址',
  `ZipCode` char(10) DEFAULT NULL COMMENT '邮编',
  `WebUrl` varchar(60) DEFAULT NULL COMMENT '网站地址',
  `Industry` tinyint(4) DEFAULT '0' COMMENT '属所行业',
  `ClientType` tinyint(4) DEFAULT '0' COMMENT '客户类型',
  `ClientLevel` tinyint(4) DEFAULT '0' COMMENT '客户级别',
  `ClientSource` tinyint(4) DEFAULT '0' COMMENT '客户来源',
  `FollowUp` tinyint(4) DEFAULT '0' COMMENT '跟进情况',
  `Wast` tinyint(4) DEFAULT '0' COMMENT '跟单类型',
  `Intent` tinyint(4) DEFAULT '0' COMMENT '户客意向',
  `MainItems` varchar(200) DEFAULT NULL COMMENT '主营项目',
  `Message` varchar(1000) DEFAULT NULL COMMENT '备注，其它',
  `OpenShare` tinyint(1) DEFAULT '0' COMMENT '是否共享',
  `Share` varchar(500) DEFAULT NULL COMMENT '针对共享',
  `Recycle` tinyint(1) DEFAULT '0' COMMENT '是否在回收站',
  `Dtime` datetime DEFAULT NULL COMMENT '录入时间',
  `FinalTime` datetime DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_client
-- ----------------------------
INSERT INTO `tp_client` VALUES ('5', '1', '5', '开玩笑有限公司', '地球中国', '', 'http://www.zhongguo.com', '36', '7', '16', '11', '56', '46', '59', '什么都做。。', '有潜力的客户.....', '1', null, '0', '2014-01-07 19:40:46', '2014-01-07 19:40:46');
INSERT INTO `tp_client` VALUES ('6', '1', '6', '某某国际有限公司', '美国洛杉矶', '', 'http://www.luoshanji.com', '35', '10', '16', '12', '56', '47', '59', '医疗行业。。', '没了。。。', '1', null, '1', '2014-01-07 19:42:29', '2014-01-07 19:42:29');
INSERT INTO `tp_client` VALUES ('11', '9', '11', 'wu', 'wu', '', 'wu', '34', '8', '16', '11', '55', '46', '59', '', '', '0', null, '0', '2014-01-08 14:30:50', '2014-01-08 14:30:50');
INSERT INTO `tp_client` VALUES ('12', '9', '13', 'd', 'd', 'd', 'd', '34', '7', '16', '11', '55', '46', '58', '', '', '0', null, '0', '2014-01-08 14:37:17', '2014-01-08 21:38:24');
INSERT INTO `tp_client` VALUES ('13', '9', '14', 'd', 'd', 'd', 'd', '34', '7', '16', '11', '55', '46', '58', '', '', '0', null, '1', '2014-01-08 14:37:17', '2014-01-08 14:37:17');
INSERT INTO `tp_client` VALUES ('14', '1', '15', 'aaa', 'aaa', '1233444', 'aaaa', '34', '7', '16', '11', '55', '46', '58', '', '', '0', null, '1', '2019-02-18 14:49:31', '2019-02-18 14:49:31');
INSERT INTO `tp_client` VALUES ('15', '1', '16', '客户A', '南京', '200000', 'www.aaa.com', '44', '7', '16', '11', '55', '46', '58', '', '', '0', null, '0', '2019-02-18 15:06:33', '2019-02-18 15:06:33');
INSERT INTO `tp_client` VALUES ('16', '11', '17', '客户A', '南京', '200000', 'www.aaa.com', '34', '7', '16', '11', '55', '46', '58', '', '', '0', null, '0', '2019-02-18 15:14:45', '2019-02-18 15:14:45');
INSERT INTO `tp_client` VALUES ('17', '13', '18', '谢先生（海口）', '海口', '', '', '34', '7', '21', '11', '55', '46', '58', '想做欧洲，海口的', '', '0', null, '0', '2019-02-18 22:04:41', '2019-02-19 16:37:50');
INSERT INTO `tp_client` VALUES ('18', '14', '19', '纪', '', '', '', '34', '7', '21', '11', '55', '46', '58', '魁省客户，客户没有告诉过小月情况，只是说别家已经评估过说可以做', '', '0', null, '0', '2019-02-19 14:43:01', '2019-02-19 14:43:01');
INSERT INTO `tp_client` VALUES ('19', '14', '20', '李老师', '', '', '', '34', '7', '21', '11', '55', '46', '58', '魁省，老公航空公司年薪20-30万，房产700万左右，有现金；在别家公司持暗股，商铺2套，少量房租', '', '0', null, '0', '2019-02-19 14:51:16', '2019-02-19 14:51:45');
INSERT INTO `tp_client` VALUES ('20', '13', '21', '王先生（北京）', '', '', '', '34', '7', '21', '11', '55', '46', '58', '加拿大，塞浦路斯，二手房、有房产证；已经考察过，但是没有签约', '', '0', null, '0', '2019-02-19 16:21:04', '2019-02-19 16:22:12');
INSERT INTO `tp_client` VALUES ('21', '13', '22', '刘烜 xuan （北京客户）', '', '', '', '34', '7', '21', '11', '55', '46', '58', '给客户发送塞浦路斯，葡萄牙，美国的移民资料 ly82256@163.com', '', '0', null, '0', '2019-02-19 16:31:05', '2019-02-19 16:31:30');
INSERT INTO `tp_client` VALUES ('22', '14', '23', '税号陈总', '', '', '', '34', '7', '16', '11', '55', '46', '58', '', '', '0', null, '0', '2019-02-27 21:22:30', '2019-02-27 21:22:30');
INSERT INTO `tp_client` VALUES ('23', '14', '24', 'BVI税号 李总', '', '', '', '34', '7', '16', '11', '55', '46', '58', '', '', '0', null, '0', '2019-02-27 21:24:00', '2019-02-27 21:24:00');
INSERT INTO `tp_client` VALUES ('24', '14', '25', '加拿大周先生', '', '', '', '34', '7', '16', '11', '55', '46', '58', '', '', '0', null, '0', '2019-02-27 21:24:46', '2019-02-27 21:24:46');

-- ----------------------------
-- Table structure for `tp_competence`
-- ----------------------------
DROP TABLE IF EXISTS `tp_competence`;
CREATE TABLE `tp_competence` (
  `ID` int(5) NOT NULL AUTO_INCREMENT COMMENT 'ID编号',
  `Sid` int(5) DEFAULT '0' COMMENT '权限分组',
  `Cname` varchar(20) DEFAULT '' COMMENT '权限名称',
  `Description` varchar(50) DEFAULT '' COMMENT '说明',
  `Status` tinyint(2) DEFAULT '0' COMMENT '状态',
  `Dtime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_competence
-- ----------------------------
INSERT INTO `tp_competence` VALUES ('1', '0', '用户管理', '登录用户管理', '0', '2013-12-08 17:08:27');
INSERT INTO `tp_competence` VALUES ('2', '1', '用户列表', '', '0', '2013-12-08 17:08:47');
INSERT INTO `tp_competence` VALUES ('3', '1', '添加用户', '', '0', '2013-12-08 17:08:54');
INSERT INTO `tp_competence` VALUES ('4', '1', '修改用户', '', '0', '2013-12-08 17:09:02');
INSERT INTO `tp_competence` VALUES ('5', '1', '删除用户', '', '0', '2013-12-08 17:09:30');
INSERT INTO `tp_competence` VALUES ('6', '0', '角色管理', '角色、级别分类', '0', '2013-12-08 17:09:53');
INSERT INTO `tp_competence` VALUES ('7', '6', '浏览角色', '', '0', '2013-12-08 17:10:03');
INSERT INTO `tp_competence` VALUES ('8', '6', '添加角色', '', '0', '2013-12-08 17:10:14');
INSERT INTO `tp_competence` VALUES ('9', '6', '修改角色', '', '0', '2013-12-08 17:10:24');
INSERT INTO `tp_competence` VALUES ('10', '6', '删除角色', '', '0', '2013-12-08 17:10:33');
INSERT INTO `tp_competence` VALUES ('11', '0', '权限列表', '对权限、功能的管理、操作需谨慎', '0', '2013-12-08 17:11:27');
INSERT INTO `tp_competence` VALUES ('12', '11', '浏览权限', '', '0', '2013-12-08 17:11:38');
INSERT INTO `tp_competence` VALUES ('13', '11', '添加权限', '', '0', '2013-12-08 17:11:47');
INSERT INTO `tp_competence` VALUES ('14', '11', '修改权限', '', '0', '2013-12-08 17:11:54');
INSERT INTO `tp_competence` VALUES ('15', '11', '删除权限', '', '0', '2013-12-08 17:12:04');
INSERT INTO `tp_competence` VALUES ('16', '0', '系统管理', '对系统管理的设置、修改', '0', '2013-12-08 17:15:50');
INSERT INTO `tp_competence` VALUES ('17', '0', '其它权限', '其它琐碎、无关痛痒的操作', '0', '2013-12-08 17:16:22');
INSERT INTO `tp_competence` VALUES ('18', '17', '修改资料', '', '0', '2013-12-08 17:17:09');
INSERT INTO `tp_competence` VALUES ('19', '17', '登录日志查看', '', '0', '2013-12-13 00:24:45');
INSERT INTO `tp_competence` VALUES ('20', '17', '删除登录日志', '', '0', '2013-12-13 00:25:04');
INSERT INTO `tp_competence` VALUES ('21', '16', 'IP封禁管理', '', '0', '2013-12-13 15:31:39');
INSERT INTO `tp_competence` VALUES ('22', '16', '添加封禁IP', '', '0', '2013-12-13 15:34:41');
INSERT INTO `tp_competence` VALUES ('23', '16', '删除封禁IP', '', '0', '2013-12-13 15:36:04');
INSERT INTO `tp_competence` VALUES ('24', '16', '清空缓存', '清空文件缓存、日志等', '0', '2013-12-13 17:56:04');
INSERT INTO `tp_competence` VALUES ('25', '16', '模块管理', '后台功能模块管理', '0', '2013-12-15 13:35:24');
INSERT INTO `tp_competence` VALUES ('26', '16', '添加模块', '', '0', '2013-12-15 13:35:37');
INSERT INTO `tp_competence` VALUES ('27', '16', '修改模块', '', '0', '2013-12-15 13:35:47');
INSERT INTO `tp_competence` VALUES ('28', '16', '删除模块', '', '0', '2013-12-15 13:35:56');
INSERT INTO `tp_competence` VALUES ('29', '31', '系统配置浏览', '浏览系统核心配置参数', '0', '2013-12-19 09:33:41');
INSERT INTO `tp_competence` VALUES ('30', '31', '系统配置修改', '', '0', '2013-12-19 09:33:54');
INSERT INTO `tp_competence` VALUES ('31', '0', '系统配置', '配置系统核心参数', '0', '2013-12-19 09:56:54');
INSERT INTO `tp_competence` VALUES ('32', '31', '核心配置', '浏览核心配置参数', '0', '2013-12-19 09:58:04');
INSERT INTO `tp_competence` VALUES ('33', '31', '核心配置修改', '', '0', '2013-12-19 09:58:35');
INSERT INTO `tp_competence` VALUES ('34', '0', '云端文件', '云端文件管理', '0', '2013-12-19 11:37:54');
INSERT INTO `tp_competence` VALUES ('35', '34', '文件管理', '管理所有已上传的文件', '0', '2013-12-19 11:38:18');
INSERT INTO `tp_competence` VALUES ('36', '34', '添加目录', '', '0', '2013-12-19 11:38:28');
INSERT INTO `tp_competence` VALUES ('37', '34', '修改目录', '', '0', '2013-12-19 11:38:36');
INSERT INTO `tp_competence` VALUES ('38', '34', '删除目录', '', '0', '2013-12-19 11:38:43');
INSERT INTO `tp_competence` VALUES ('39', '34', '移动文件', '移动文件到其它目录', '0', '2013-12-19 11:39:31');
INSERT INTO `tp_competence` VALUES ('40', '34', '上传文件', '', '0', '2013-12-19 11:39:47');
INSERT INTO `tp_competence` VALUES ('41', '34', '修改文件', '', '0', '2013-12-19 11:40:21');
INSERT INTO `tp_competence` VALUES ('42', '34', '删除文件', '', '0', '2013-12-19 11:40:28');
INSERT INTO `tp_competence` VALUES ('43', '34', '下载文件', '', '0', '2013-12-24 15:35:52');
INSERT INTO `tp_competence` VALUES ('44', '0', '新闻动态', '', '0', '2013-12-25 15:26:20');
INSERT INTO `tp_competence` VALUES ('45', '44', '分类管理', '管理单页分类', '0', '2013-12-25 15:26:38');
INSERT INTO `tp_competence` VALUES ('46', '44', '添加分类', '', '0', '2013-12-25 15:27:14');
INSERT INTO `tp_competence` VALUES ('47', '44', '修改分类', '', '0', '2013-12-25 15:27:28');
INSERT INTO `tp_competence` VALUES ('48', '44', '删除分类', '', '0', '2013-12-25 15:27:35');
INSERT INTO `tp_competence` VALUES ('49', '44', '添加单页', '', '0', '2013-12-25 15:27:43');
INSERT INTO `tp_competence` VALUES ('50', '44', '修改单页', '', '0', '2013-12-25 15:27:50');
INSERT INTO `tp_competence` VALUES ('51', '44', '删除单页', '', '0', '2013-12-25 15:27:57');
INSERT INTO `tp_competence` VALUES ('52', '31', '网站配置浏览', '', '0', '2013-12-26 23:09:38');
INSERT INTO `tp_competence` VALUES ('53', '31', '网站配置修改', '', '0', '2013-12-26 23:10:15');
INSERT INTO `tp_competence` VALUES ('59', '0', '下拉菜单', '管理下拉菜单', '0', '2013-12-29 22:34:23');
INSERT INTO `tp_competence` VALUES ('60', '59', '浏览下拉菜单', '', '0', '2013-12-29 22:34:43');
INSERT INTO `tp_competence` VALUES ('61', '59', '添加下拉菜单', '', '0', '2013-12-29 22:34:55');
INSERT INTO `tp_competence` VALUES ('62', '59', '修改下拉菜单', '', '0', '2013-12-29 22:35:05');
INSERT INTO `tp_competence` VALUES ('63', '59', '删除下拉菜单', '', '0', '2013-12-29 22:35:16');
INSERT INTO `tp_competence` VALUES ('64', '0', '客户管理', '客户管理中心', '0', '2014-01-01 10:40:22');
INSERT INTO `tp_competence` VALUES ('65', '64', '客户列表', '', '0', '2014-01-01 10:40:35');
INSERT INTO `tp_competence` VALUES ('66', '64', '新增客户', '', '0', '2014-01-01 10:40:44');
INSERT INTO `tp_competence` VALUES ('67', '64', '修改客户信息', '', '0', '2014-01-01 10:40:54');
INSERT INTO `tp_competence` VALUES ('68', '64', '删除客户', '', '0', '2014-01-01 10:41:09');
INSERT INTO `tp_competence` VALUES ('69', '64', '新增联系人', '', '0', '2014-01-01 21:56:11');
INSERT INTO `tp_competence` VALUES ('70', '64', '修改联系人信息', '', '0', '2014-01-01 21:56:24');
INSERT INTO `tp_competence` VALUES ('71', '64', '删除联系人', '', '0', '2014-01-01 21:56:46');
INSERT INTO `tp_competence` VALUES ('72', '64', '共享客户', '', '0', '2014-01-01 21:57:26');
INSERT INTO `tp_competence` VALUES ('73', '64', '浏览共享数据', '', '0', '2014-01-01 21:57:48');
INSERT INTO `tp_competence` VALUES ('74', '64', '回收站', '', '0', '2014-01-01 21:59:01');
INSERT INTO `tp_competence` VALUES ('75', '64', '还原数据', '', '0', '2014-01-01 21:59:43');
INSERT INTO `tp_competence` VALUES ('76', '64', '删除回收站数据', '', '0', '2014-01-01 21:59:54');
INSERT INTO `tp_competence` VALUES ('77', '34', '查看共享文件', '查看共享文件', '0', '2014-01-04 21:06:16');
INSERT INTO `tp_competence` VALUES ('78', '64', '跟单管理', '', '0', '2014-01-05 01:17:01');
INSERT INTO `tp_competence` VALUES ('79', '64', '新建跟单', '', '0', '2014-01-05 01:17:20');
INSERT INTO `tp_competence` VALUES ('80', '64', '修改跟单信息', '', '0', '2014-01-05 01:17:33');
INSERT INTO `tp_competence` VALUES ('81', '64', '删除跟单信息', '', '0', '2014-01-05 01:17:48');
INSERT INTO `tp_competence` VALUES ('82', '17', '操作日志', '', '0', '2014-01-05 14:35:00');
INSERT INTO `tp_competence` VALUES ('83', '17', '删除操作日志', '', '0', '2014-01-05 14:35:12');
INSERT INTO `tp_competence` VALUES ('84', '44', '内容列表', '', '0', '2014-01-21 21:22:26');
INSERT INTO `tp_competence` VALUES ('85', '64', '联系人列表', '', '0', '2014-01-21 21:25:27');

-- ----------------------------
-- Table structure for `tp_contact`
-- ----------------------------
DROP TABLE IF EXISTS `tp_contact`;
CREATE TABLE `tp_contact` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Uid` int(10) DEFAULT '0' COMMENT '用户编号',
  `Cid` int(10) DEFAULT '0' COMMENT '客户档案编号',
  `ContactName` char(30) DEFAULT '' COMMENT '联系人',
  `Sex` char(4) DEFAULT NULL COMMENT '性别',
  `Post` tinyint(4) DEFAULT '0' COMMENT '职位',
  `Qq` char(30) DEFAULT NULL COMMENT '腾讯QQ',
  `Skype` char(30) DEFAULT NULL COMMENT 'msn',
  `Alww` char(30) DEFAULT '' COMMENT '阿里旺旺',
  `Phone` char(30) DEFAULT NULL COMMENT '手机',
  `Tel` char(20) DEFAULT NULL COMMENT '联系电话',
  `Fax` char(20) DEFAULT NULL COMMENT '传真',
  `Email` char(40) DEFAULT '' COMMENT '电子邮箱',
  `Birthday` datetime DEFAULT NULL COMMENT '生日',
  `Content` varchar(1000) DEFAULT NULL COMMENT '备注说明',
  `Recycle` tinyint(1) DEFAULT '0' COMMENT '是否在回收站',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  `FinalTime` datetime DEFAULT NULL COMMENT '最后更新',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_contact
-- ----------------------------
INSERT INTO `tp_contact` VALUES ('5', '1', '5', '开玩笑', '男', '22', '66666666', 'Skype@skype.com', 'lala.com', '15102041255', '445223115', '02066638783', 'qq@qq.com', '2014-01-07 19:40:38', null, '0', '2014-01-07 19:40:46', '2014-01-07 19:40:46');
INSERT INTO `tp_contact` VALUES ('6', '1', '6', '找小姐', '女', '23', '88888888', 'Skype@skype.com', 'lala.com', '1520335225', '445223115', '', 'qq@qq.com', '2014-01-07 19:42:15', null, '1', '2014-01-07 19:42:29', '2014-01-07 19:42:29');
INSERT INTO `tp_contact` VALUES ('15', '1', '14', 'asdfsdf', '男', '22', '', '', '', '12323423234234', '', '', '', '0000-00-00 00:00:00', null, '1', '2019-02-18 14:49:31', '2019-02-18 14:49:31');
INSERT INTO `tp_contact` VALUES ('16', '1', '15', '客户', '男', '22', '', '', '', '13312345678', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-18 15:06:33', '2019-02-18 15:06:33');
INSERT INTO `tp_contact` VALUES ('17', '11', '16', '客户', '男', '22', '', '', '', '13312345678', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-18 15:14:45', '2019-02-18 15:14:45');
INSERT INTO `tp_contact` VALUES ('18', '13', '17', '谢先生', '男', '23', '', '', '', '18789693453', '18789693453', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-18 22:04:41', '2019-02-18 22:04:41');
INSERT INTO `tp_contact` VALUES ('19', '14', '18', '纪', '男', '22', '', '', '', '13961243378', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-19 14:43:01', '2019-02-19 14:43:01');
INSERT INTO `tp_contact` VALUES ('20', '14', '19', '李老师', '女', '30', '', '', '', '18696673925', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-19 14:51:16', '2019-02-19 14:51:16');
INSERT INTO `tp_contact` VALUES ('21', '13', '20', '王先生', '男', '30', '', '', '', '13051201090', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-19 16:21:04', '2019-02-19 16:21:04');
INSERT INTO `tp_contact` VALUES ('22', '13', '21', '刘烜', '男', '30', '', '', '', '13810589615', '', '', 'ly82256@163.com', '0000-00-00 00:00:00', null, '0', '2019-02-19 16:31:05', '2019-02-19 16:31:05');
INSERT INTO `tp_contact` VALUES ('23', '14', '22', '税号陈总', '男', '22', '', '', '', '17092551260', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-27 21:22:30', '2019-02-27 21:22:30');
INSERT INTO `tp_contact` VALUES ('24', '14', '23', 'BVI税号李总', '男', '22', '', '', '', '15189416666', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-27 21:24:00', '2019-02-27 21:24:00');
INSERT INTO `tp_contact` VALUES ('25', '14', '24', '加拿大周先生', '男', '22', '', '', '', '19851407348', '', '', '', '0000-00-00 00:00:00', null, '0', '2019-02-27 21:24:46', '2019-02-27 21:24:46');

-- ----------------------------
-- Table structure for `tp_dmenu`
-- ----------------------------
DROP TABLE IF EXISTS `tp_dmenu`;
CREATE TABLE `tp_dmenu` (
  `ID` int(5) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID编号',
  `Uid` int(8) DEFAULT NULL,
  `Sid` int(5) DEFAULT '0' COMMENT '下级ID',
  `MenuName` char(50) DEFAULT NULL COMMENT '下拉菜单名称',
  `Description` char(100) DEFAULT NULL COMMENT '描述',
  `Sortid` int(5) DEFAULT '0' COMMENT '序排ID',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_dmenu
-- ----------------------------
INSERT INTO `tp_dmenu` VALUES ('1', '1', '0', '客户类型', '', '0', '2013-12-29 21:40:29');
INSERT INTO `tp_dmenu` VALUES ('2', '1', '0', '客户来源', '', '0', '2013-12-29 21:42:30');
INSERT INTO `tp_dmenu` VALUES ('3', '1', '0', '客户级别', '', '0', '2013-12-29 21:42:40');
INSERT INTO `tp_dmenu` VALUES ('4', '1', '0', '职位', '', '0', '2013-12-29 21:42:50');
INSERT INTO `tp_dmenu` VALUES ('5', '1', '0', '跟单类型', '', '0', '2013-12-29 21:43:07');
INSERT INTO `tp_dmenu` VALUES ('6', '1', '0', '是/否', '', '0', '2013-12-29 21:43:55');
INSERT INTO `tp_dmenu` VALUES ('7', '1', '1', '成长型', '', '0', '2013-12-29 21:56:33');
INSERT INTO `tp_dmenu` VALUES ('8', '1', '1', '创业型', '', '1', '2013-12-29 21:56:47');
INSERT INTO `tp_dmenu` VALUES ('9', '1', '1', '完美型', '', '3', '2013-12-29 21:56:56');
INSERT INTO `tp_dmenu` VALUES ('10', '1', '1', '鼎盛时期', '', '2', '2013-12-29 21:57:04');
INSERT INTO `tp_dmenu` VALUES ('11', '1', '2', '搜索引擎', '', '0', '2013-12-29 21:57:35');
INSERT INTO `tp_dmenu` VALUES ('12', '1', '2', '关系介绍', '', '1', '2013-12-29 21:57:44');
INSERT INTO `tp_dmenu` VALUES ('13', '1', '2', '婚博会', '', '2', '2013-12-29 21:58:09');
INSERT INTO `tp_dmenu` VALUES ('14', '1', '2', '代理商', '', '3', '2013-12-29 21:58:18');
INSERT INTO `tp_dmenu` VALUES ('15', '1', '2', '本公司', '', '4', '2013-12-29 21:58:25');
INSERT INTO `tp_dmenu` VALUES ('16', '1', '3', '★★★★★★', '', '0', '2013-12-29 21:59:11');
INSERT INTO `tp_dmenu` VALUES ('17', '1', '3', '★★★★★', '', '1', '2013-12-29 21:59:19');
INSERT INTO `tp_dmenu` VALUES ('18', '1', '3', '★★★★', '', '2', '2013-12-29 21:59:26');
INSERT INTO `tp_dmenu` VALUES ('19', '1', '3', '★★★', '', '3', '2013-12-29 21:59:32');
INSERT INTO `tp_dmenu` VALUES ('20', '1', '3', '★★', '', '4', '2013-12-29 21:59:38');
INSERT INTO `tp_dmenu` VALUES ('21', '1', '3', '★', '', '5', '2013-12-29 21:59:43');
INSERT INTO `tp_dmenu` VALUES ('22', '1', '4', '董事长', '', '0', '2013-12-29 22:01:37');
INSERT INTO `tp_dmenu` VALUES ('23', '1', '4', '总经理', '', '1', '2013-12-29 22:01:53');
INSERT INTO `tp_dmenu` VALUES ('24', '1', '4', '区域经理', '', '2', '2013-12-29 22:02:01');
INSERT INTO `tp_dmenu` VALUES ('25', '1', '4', '部门经理', '', '3', '2013-12-29 22:02:13');
INSERT INTO `tp_dmenu` VALUES ('26', '1', '0', '从事行业', '', '0', '2013-12-29 22:02:24');
INSERT INTO `tp_dmenu` VALUES ('27', '1', '4', '财务', '', '4', '2013-12-29 22:02:32');
INSERT INTO `tp_dmenu` VALUES ('28', '1', '4', '技术类', '', '5', '2013-12-29 22:02:43');
INSERT INTO `tp_dmenu` VALUES ('29', '1', '4', '业务员', '', '6', '2013-12-29 22:02:54');
INSERT INTO `tp_dmenu` VALUES ('30', '1', '4', '其他', '', '7', '2013-12-29 22:03:01');
INSERT INTO `tp_dmenu` VALUES ('34', '1', '26', '服务业', '', '0', '2013-12-29 22:23:21');
INSERT INTO `tp_dmenu` VALUES ('35', '1', '26', '医疗 | 制药 | 环保', '', '8', '2013-12-29 22:23:36');
INSERT INTO `tp_dmenu` VALUES ('36', '1', '26', '财会 | 金融', '', '9', '2013-12-29 22:23:51');
INSERT INTO `tp_dmenu` VALUES ('37', '1', '26', '法律 | 教育 | 翻译 | 出版', '', '10', '2013-12-29 22:24:00');
INSERT INTO `tp_dmenu` VALUES ('38', '1', '26', '网络 | 通信 | 电子', '', '11', '2013-12-29 22:24:52');
INSERT INTO `tp_dmenu` VALUES ('39', '1', '26', '建筑 | 房产 | 物业', '', '7', '2013-12-29 22:25:01');
INSERT INTO `tp_dmenu` VALUES ('40', '1', '26', '汽车制造 | 服务', '', '5', '2013-12-29 22:25:10');
INSERT INTO `tp_dmenu` VALUES ('41', '1', '26', '生产 | 物流 | 质控', '', '4', '2013-12-29 22:25:19');
INSERT INTO `tp_dmenu` VALUES ('42', '1', '26', '市场 | 媒介 | 广告 | 设计', '', '3', '2013-12-29 22:25:27');
INSERT INTO `tp_dmenu` VALUES ('43', '1', '26', '销售 | 客服 | 采购', '', '2', '2013-12-29 22:25:45');
INSERT INTO `tp_dmenu` VALUES ('44', '1', '26', '人力 | 行政 | 管理', '', '1', '2013-12-29 22:25:56');
INSERT INTO `tp_dmenu` VALUES ('45', '1', '26', '其他', '', '12', '2013-12-29 22:26:04');
INSERT INTO `tp_dmenu` VALUES ('46', '1', '5', '电话联系', '', '0', '2013-12-29 22:30:41');
INSERT INTO `tp_dmenu` VALUES ('47', '1', '5', '上门服务', '', '1', '2013-12-29 22:30:57');
INSERT INTO `tp_dmenu` VALUES ('48', '1', '5', 'QQ联系', '', '2', '2013-12-29 22:31:09');
INSERT INTO `tp_dmenu` VALUES ('49', '1', '5', 'Email联系', '', '3', '2013-12-29 22:31:22');
INSERT INTO `tp_dmenu` VALUES ('50', '1', '5', '其它方式', '', '4', '2013-12-29 22:31:38');
INSERT INTO `tp_dmenu` VALUES ('51', '1', '6', '是', '', '0', '2013-12-29 22:33:00');
INSERT INTO `tp_dmenu` VALUES ('52', '1', '6', '否', '', '1', '2013-12-29 22:33:06');
INSERT INTO `tp_dmenu` VALUES ('53', '1', '6', '待定', '', '2', '2013-12-29 22:33:12');
INSERT INTO `tp_dmenu` VALUES ('54', '1', '0', '跟进情况', '', '0', '2013-12-30 20:47:40');
INSERT INTO `tp_dmenu` VALUES ('55', '1', '54', '正在跟进', '', '0', '2013-12-30 20:48:00');
INSERT INTO `tp_dmenu` VALUES ('56', '1', '54', '待跟进', '', '1', '2013-12-30 20:48:41');
INSERT INTO `tp_dmenu` VALUES ('57', '1', '0', '客户意向', '', '0', '2013-12-30 20:49:45');
INSERT INTO `tp_dmenu` VALUES ('58', '1', '57', '有一定意向', '', '0', '2013-12-30 20:49:57');
INSERT INTO `tp_dmenu` VALUES ('59', '1', '57', '意向明确', '', '1', '2013-12-30 20:50:06');
INSERT INTO `tp_dmenu` VALUES ('60', '1', '57', '不明确', '', '2', '2013-12-30 20:50:21');
INSERT INTO `tp_dmenu` VALUES ('61', '1', '57', '未知', '', '3', '2013-12-30 20:50:29');
INSERT INTO `tp_dmenu` VALUES ('62', '1', '54', '完成跟进', '', '2', '2014-01-03 23:30:54');

-- ----------------------------
-- Table structure for `tp_file`
-- ----------------------------
DROP TABLE IF EXISTS `tp_file`;
CREATE TABLE `tp_file` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '//ID编号',
  `Sid` int(8) DEFAULT '0' COMMENT '所属目录/分类',
  `Uid` int(10) DEFAULT '0' COMMENT '添加用户ID',
  `FileName` varchar(50) DEFAULT NULL COMMENT '文件/图片名称，可选',
  `Description` varchar(50) DEFAULT NULL COMMENT '文件/图片说明',
  `FilePath` varchar(100) DEFAULT NULL COMMENT '文件路径',
  `FileSize` int(10) DEFAULT '0' COMMENT '文件大小',
  `FileType` varchar(10) DEFAULT NULL COMMENT '文件类型',
  `Share` tinyint(1) DEFAULT '0' COMMENT '是否共享文件或图片',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_file
-- ----------------------------
INSERT INTO `tp_file` VALUES ('12', '4', '1', '微服务.pdf', null, 'Uploads/Upload//1/20190301/5c788e9740f3d.pdf', '38805', 'pdf', '0', '2019-03-01 09:44:55');
INSERT INTO `tp_file` VALUES ('13', '0', '1', '微服务.pdf', null, 'Uploads/Upload//1/20190301/5c789062c2184.pdf', '38805', 'pdf', '0', '2019-03-01 09:52:34');
INSERT INTO `tp_file` VALUES ('11', '4', '1', '微服务.pdf', null, 'Uploads/Upload//1/20190301/5c788e55845a8.pdf', '38805', 'pdf', '0', '2019-03-01 09:43:49');
INSERT INTO `tp_file` VALUES ('6', '1', '1', 'logo.png', '', 'Uploads/Picture/1/20190301/5c788643ab693.png', '12628', 'png', '1', '2019-03-01 09:09:23');

-- ----------------------------
-- Table structure for `tp_fileclass`
-- ----------------------------
DROP TABLE IF EXISTS `tp_fileclass`;
CREATE TABLE `tp_fileclass` (
  `ID` int(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '文件分类ID',
  `Sid` int(8) DEFAULT '0' COMMENT '分类SID',
  `Uid` int(8) DEFAULT '0' COMMENT '用户ID',
  `Sortid` int(5) DEFAULT '0' COMMENT '排序ID',
  `ClassName` varchar(20) DEFAULT NULL COMMENT '分类名称',
  `Description` varchar(50) DEFAULT NULL COMMENT '分类描述',
  `Status` tinyint(1) DEFAULT '0' COMMENT '状态',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_fileclass
-- ----------------------------
INSERT INTO `tp_fileclass` VALUES ('1', '0', '1', '0', '我的图片', '我的图片', '0', '2014-01-04 20:27:10');
INSERT INTO `tp_fileclass` VALUES ('2', '0', '1', '0', '我的文件', '', '0', '2014-01-04 20:27:20');
INSERT INTO `tp_fileclass` VALUES ('3', '0', '1', '0', 'ueidtor', '', '0', '2014-01-04 20:27:54');
INSERT INTO `tp_fileclass` VALUES ('4', '2', '1', '0', '新目录', '创建的新目录', '0', '2019-03-01 09:31:18');

-- ----------------------------
-- Table structure for `tp_ip`
-- ----------------------------
DROP TABLE IF EXISTS `tp_ip`;
CREATE TABLE `tp_ip` (
  `ID` int(8) NOT NULL AUTO_INCREMENT COMMENT 'ID编号',
  `Uid` int(6) DEFAULT NULL COMMENT '操作用户',
  `Ip` varchar(50) DEFAULT NULL COMMENT '被封禁IP',
  `Description` varchar(50) DEFAULT NULL COMMENT '描述',
  `Status` tinyint(1) DEFAULT '0' COMMENT '是否永久封禁',
  `StartTime` date DEFAULT NULL COMMENT '开始日期',
  `EndTime` date DEFAULT NULL COMMENT '结束日期',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_ip
-- ----------------------------

-- ----------------------------
-- Table structure for `tp_loginlog`
-- ----------------------------
DROP TABLE IF EXISTS `tp_loginlog`;
CREATE TABLE `tp_loginlog` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID编号',
  `Uid` int(8) DEFAULT NULL COMMENT '登录用户',
  `User` char(40) DEFAULT NULL COMMENT '户用名',
  `Description` varchar(40) DEFAULT NULL COMMENT '登录说明',
  `Area` char(20) DEFAULT NULL,
  `Loginip` varchar(30) DEFAULT NULL COMMENT '登录IP',
  `Dtime` datetime DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=280 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_loginlog
-- ----------------------------
INSERT INTO `tp_loginlog` VALUES ('199', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-08 21:26:38');
INSERT INTO `tp_loginlog` VALUES ('200', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-08 21:37:02');
INSERT INTO `tp_loginlog` VALUES ('201', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-08 22:25:34');
INSERT INTO `tp_loginlog` VALUES ('202', '2', 'LITTLE', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-08 22:35:04');
INSERT INTO `tp_loginlog` VALUES ('203', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-08 22:37:50');
INSERT INTO `tp_loginlog` VALUES ('204', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-08 22:41:21');
INSERT INTO `tp_loginlog` VALUES ('205', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-09 21:07:00');
INSERT INTO `tp_loginlog` VALUES ('206', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-09 21:13:05');
INSERT INTO `tp_loginlog` VALUES ('207', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-09 21:15:24');
INSERT INTO `tp_loginlog` VALUES ('208', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-09 21:17:29');
INSERT INTO `tp_loginlog` VALUES ('209', '0', 'test', '<div class=\"de2\">用户不存在</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-13 21:13:03');
INSERT INTO `tp_loginlog` VALUES ('210', '0', 'test', '<div class=\"de2\">用户不存在</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-13 21:13:09');
INSERT INTO `tp_loginlog` VALUES ('211', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-13 21:13:16');
INSERT INTO `tp_loginlog` VALUES ('212', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-13 22:15:48');
INSERT INTO `tp_loginlog` VALUES ('213', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-21 20:44:55');
INSERT INTO `tp_loginlog` VALUES ('214', '1', 'admin', '<div class=\"de1\">登录成功</div>', '本机地址.IAMLE.COM', '127.0.0.1', '2014-01-21 21:36:11');
INSERT INTO `tp_loginlog` VALUES ('215', '0', 'test', '<div class=\"de2\">用户不存在</div>', '.', null, '2019-02-18 14:26:08');
INSERT INTO `tp_loginlog` VALUES ('216', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:26:27');
INSERT INTO `tp_loginlog` VALUES ('217', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:26:29');
INSERT INTO `tp_loginlog` VALUES ('218', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:26:30');
INSERT INTO `tp_loginlog` VALUES ('219', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:27:20');
INSERT INTO `tp_loginlog` VALUES ('220', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:27:49');
INSERT INTO `tp_loginlog` VALUES ('221', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:30:00');
INSERT INTO `tp_loginlog` VALUES ('222', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:30:10');
INSERT INTO `tp_loginlog` VALUES ('223', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:30:12');
INSERT INTO `tp_loginlog` VALUES ('224', '1', 'admin', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:34:38');
INSERT INTO `tp_loginlog` VALUES ('225', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 14:34:46');
INSERT INTO `tp_loginlog` VALUES ('226', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 14:52:29');
INSERT INTO `tp_loginlog` VALUES ('227', '1', 'abcde', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:54:13');
INSERT INTO `tp_loginlog` VALUES ('228', '1', 'abcde', '<div class=\"de2\">登录密码错误</div>', '.', null, '2019-02-18 14:54:22');
INSERT INTO `tp_loginlog` VALUES ('229', '6', 'abcde', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 14:56:23');
INSERT INTO `tp_loginlog` VALUES ('230', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 14:57:18');
INSERT INTO `tp_loginlog` VALUES ('231', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:01:32');
INSERT INTO `tp_loginlog` VALUES ('232', '9', 'user', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:07:21');
INSERT INTO `tp_loginlog` VALUES ('233', '10', 'manage', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:08:59');
INSERT INTO `tp_loginlog` VALUES ('234', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:10:22');
INSERT INTO `tp_loginlog` VALUES ('235', '11', 'hehuo', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:14:03');
INSERT INTO `tp_loginlog` VALUES ('236', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:15:13');
INSERT INTO `tp_loginlog` VALUES ('237', '12', 'hehuo2', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:16:00');
INSERT INTO `tp_loginlog` VALUES ('238', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 15:23:32');
INSERT INTO `tp_loginlog` VALUES ('239', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 21:25:42');
INSERT INTO `tp_loginlog` VALUES ('240', '8', 'chenli', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 21:45:22');
INSERT INTO `tp_loginlog` VALUES ('241', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 21:54:10');
INSERT INTO `tp_loginlog` VALUES ('242', '13', 'zhouqing', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 22:00:47');
INSERT INTO `tp_loginlog` VALUES ('243', '8', 'chenli', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-18 22:19:01');
INSERT INTO `tp_loginlog` VALUES ('244', '8', 'chenli', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 12:09:36');
INSERT INTO `tp_loginlog` VALUES ('245', '8', 'chenli', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 14:36:28');
INSERT INTO `tp_loginlog` VALUES ('246', '14', 'chixiaoyue', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 14:40:11');
INSERT INTO `tp_loginlog` VALUES ('247', '14', 'chixiaoyue', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 14:48:56');
INSERT INTO `tp_loginlog` VALUES ('248', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 15:26:41');
INSERT INTO `tp_loginlog` VALUES ('249', '14', 'chixiaoyue', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 15:45:04');
INSERT INTO `tp_loginlog` VALUES ('250', '13', 'zhouqing', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 16:16:04');
INSERT INTO `tp_loginlog` VALUES ('251', '8', 'chenli', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 16:43:14');
INSERT INTO `tp_loginlog` VALUES ('252', '13', 'zhouqing', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 16:53:56');
INSERT INTO `tp_loginlog` VALUES ('253', '13', 'zhouqing', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-19 17:11:36');
INSERT INTO `tp_loginlog` VALUES ('254', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-20 08:58:43');
INSERT INTO `tp_loginlog` VALUES ('255', '7', 'hanlu', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-20 09:00:51');
INSERT INTO `tp_loginlog` VALUES ('256', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-20 09:02:40');
INSERT INTO `tp_loginlog` VALUES ('257', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-20 15:19:30');
INSERT INTO `tp_loginlog` VALUES ('258', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-21 11:07:15');
INSERT INTO `tp_loginlog` VALUES ('259', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-21 11:12:25');
INSERT INTO `tp_loginlog` VALUES ('260', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-22 08:39:34');
INSERT INTO `tp_loginlog` VALUES ('261', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-22 20:33:10');
INSERT INTO `tp_loginlog` VALUES ('262', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-23 12:38:36');
INSERT INTO `tp_loginlog` VALUES ('263', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-23 12:43:36');
INSERT INTO `tp_loginlog` VALUES ('264', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-24 18:15:56');
INSERT INTO `tp_loginlog` VALUES ('265', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-26 16:04:52');
INSERT INTO `tp_loginlog` VALUES ('266', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-26 21:11:12');
INSERT INTO `tp_loginlog` VALUES ('267', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-26 21:20:50');
INSERT INTO `tp_loginlog` VALUES ('268', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-26 21:47:01');
INSERT INTO `tp_loginlog` VALUES ('269', '14', 'chixiaoyue', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-27 21:21:19');
INSERT INTO `tp_loginlog` VALUES ('270', '8', 'chenli', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-28 11:25:41');
INSERT INTO `tp_loginlog` VALUES ('271', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-28 20:52:02');
INSERT INTO `tp_loginlog` VALUES ('272', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-02-28 21:52:12');
INSERT INTO `tp_loginlog` VALUES ('273', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-03-01 08:46:26');
INSERT INTO `tp_loginlog` VALUES ('274', '12', 'hehuo', '<div class=\"de1\">登录成功</div>', '.', null, '2019-03-01 09:10:06');
INSERT INTO `tp_loginlog` VALUES ('275', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-03-01 09:13:01');
INSERT INTO `tp_loginlog` VALUES ('276', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-03-04 16:26:41');
INSERT INTO `tp_loginlog` VALUES ('277', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-03-07 16:35:48');
INSERT INTO `tp_loginlog` VALUES ('278', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-03-12 17:43:36');
INSERT INTO `tp_loginlog` VALUES ('279', '1', 'admin', '<div class=\"de1\">登录成功</div>', '.', null, '2019-03-22 13:44:45');

-- ----------------------------
-- Table structure for `tp_module`
-- ----------------------------
DROP TABLE IF EXISTS `tp_module`;
CREATE TABLE `tp_module` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Sid` int(5) DEFAULT '0' COMMENT '下级分类',
  `Uid` int(10) DEFAULT '0' COMMENT '操作用户ID',
  `ModuleName` varchar(20) DEFAULT NULL COMMENT '模块名称',
  `ModuleImg` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `ModuleUrl` varchar(50) DEFAULT NULL COMMENT '连接地址',
  `Status` tinyint(4) DEFAULT '0' COMMENT '态状',
  `Description` varchar(50) DEFAULT NULL COMMENT '描述',
  `Msort` int(5) DEFAULT '0' COMMENT '序排ID',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_module
-- ----------------------------
INSERT INTO `tp_module` VALUES ('1', '0', '1', '用户管理', '/Public/image/home/img/21.png', 'User', '0', '', '1', '2013-12-15 17:12:34');
INSERT INTO `tp_module` VALUES ('2', '0', '1', '系统管理', '/Public/image/home/img/23.png', 'System/systemconfig', '0', '', '1', '2013-12-15 17:13:50');
INSERT INTO `tp_module` VALUES ('3', '0', '1', '日志管理', '/Public/image/home/img/45.png', 'Loginlog', '0', '', '2', '2013-12-15 17:14:05');
INSERT INTO `tp_module` VALUES ('4', '1', '1', '用户管理', '/Public/image/home/img/51.png', 'User', '0', '', '0', '2013-12-15 17:15:09');
INSERT INTO `tp_module` VALUES ('5', '1', '1', '角色管理', '/Public/image/home/img/527.png', 'Role', '0', '', '1', '2013-12-15 17:15:54');
INSERT INTO `tp_module` VALUES ('6', '1', '1', '权限列表', '/Public/image/home/img/613.png', 'Competence', '0', '', '2', '2013-12-15 17:18:00');
INSERT INTO `tp_module` VALUES ('7', '2', '1', '模块管理', '/Public/image/home/img/196.png', 'System/module', '0', '', '2', '2013-12-15 17:18:37');
INSERT INTO `tp_module` VALUES ('8', '2', '1', '封禁IP', '/Public/image/home/img/844.png', 'System/ip', '0', '', '3', '2013-12-15 17:20:22');
INSERT INTO `tp_module` VALUES ('9', '2', '1', '系统配置', '/Public/image/home/img/27.png', 'System/systemconfig', '0', '', '1', '2013-12-19 09:29:18');
INSERT INTO `tp_module` VALUES ('10', '2', '1', '核心配置', '/Public/image/home/img/60.png', 'System/systemcore', '0', '系统核心配置项管理', '1', '2013-12-19 10:26:06');
INSERT INTO `tp_module` VALUES ('11', '0', '1', '云端文件', '/Public/image/home/img/56.png', 'File/filelist', '0', '云端文件管理系统', '3', '2013-12-19 11:02:44');
INSERT INTO `tp_module` VALUES ('12', '11', '1', '文件管理', '/Public/image/home/img/36.png', 'File/filelist', '0', '', '0', '2013-12-19 11:03:36');
INSERT INTO `tp_module` VALUES ('13', '11', '1', '上传图片', '/Public/image/home/img/556.png', 'File/uploadpic', '0', '所有文件管理', '1', '2013-12-19 11:05:26');
INSERT INTO `tp_module` VALUES ('14', '11', '1', '上传文件', '/Public/image/home/img/53.png', 'File/uploadfile', '0', '', '2', '2013-12-19 11:05:50');
INSERT INTO `tp_module` VALUES ('15', '0', '1', '新闻动态', '/Public/image/home/img/399.png', '', '0', '', '4', '2013-12-25 14:48:17');
INSERT INTO `tp_module` VALUES ('16', '15', '1', '栏目分类', '/Public/image/home/img/838.png', 'News/classindex', '0', '', '0', '2013-12-25 14:51:07');
INSERT INTO `tp_module` VALUES ('17', '15', '1', '发布文章', '/Public/image/home/img/839.png', 'News/add', '0', '', '1', '2013-12-25 14:51:47');
INSERT INTO `tp_module` VALUES ('18', '15', '1', '新闻列表', '/Public/image/home/img/848.png', 'News/news', '0', '', '2', '2013-12-25 14:52:17');
INSERT INTO `tp_module` VALUES ('19', '2', '1', '网站设置', '/Public/image/home/img/934.png', 'System/systemwebsite', '0', '', '0', '2013-12-26 22:04:03');
INSERT INTO `tp_module` VALUES ('21', '0', '1', '客户管理', '/Public/image/home/img/269.png', 'Client/index', '0', '客户管理中心', '5', '2013-12-29 18:46:05');
INSERT INTO `tp_module` VALUES ('22', '21', '1', '所有客户', '/Public/image/home/img/527.png', 'Client/index', '0', '', '0', '2013-12-29 18:47:07');
INSERT INTO `tp_module` VALUES ('23', '21', '1', '联系人', '/Public/image/home/img/516.png', 'Client/contact', '0', '', '1', '2013-12-29 18:48:37');
INSERT INTO `tp_module` VALUES ('24', '21', '1', '客户共享', '/Public/image/home/img/423.png', 'Client/openshare', '0', '', '3', '2013-12-29 18:49:20');
INSERT INTO `tp_module` VALUES ('25', '2', '1', '下拉菜单', '/Public/image/home/img/98.png', 'Dmenu/index', '0', '', '4', '2013-12-29 20:51:03');
INSERT INTO `tp_module` VALUES ('26', '3', '1', '登录日志', '/Public/image/home/img/303.png', 'Loginlog', '0', '', '0', '2013-12-29 22:38:08');
INSERT INTO `tp_module` VALUES ('27', '3', '1', '操作日志', '/Public/image/home/img/9.png', 'Operating', '0', '', '1', '2013-12-29 22:39:53');
INSERT INTO `tp_module` VALUES ('28', '21', '1', '回收站', '/Public/image/home/img/153.png', 'Client/recycle', '0', '', '5', '2014-01-01 14:04:33');
INSERT INTO `tp_module` VALUES ('29', '0', '1', '管理首页', '/Public/image/home/img/22.png', 'Index/content', '0', '', '0', '2014-01-03 22:12:51');
INSERT INTO `tp_module` VALUES ('30', '11', '1', '共享文件', '/Public/image/home/img/569.png', 'File/fileshare', '0', '', '1', '2014-01-04 21:10:37');
INSERT INTO `tp_module` VALUES ('31', '21', '1', '跟单记录', '/Public/image/home/img/161.png', 'With/with', '0', '', '2', '2014-01-04 22:12:30');

-- ----------------------------
-- Table structure for `tp_news`
-- ----------------------------
DROP TABLE IF EXISTS `tp_news`;
CREATE TABLE `tp_news` (
  `ID` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `Sid` int(6) DEFAULT '0' COMMENT '分类ID',
  `Uid` int(6) DEFAULT '0' COMMENT '用户ID',
  `Title` char(80) DEFAULT NULL COMMENT '标题',
  `Description` char(200) DEFAULT NULL COMMENT '描述',
  `Content` text COMMENT '内容',
  `Sortid` int(6) DEFAULT '0' COMMENT '排序ID',
  `View` int(6) DEFAULT '0' COMMENT '读阅数',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_news
-- ----------------------------
INSERT INTO `tp_news` VALUES ('13', '2', '1', '华人经营者披露日本黑社会索取保护费内幕', '中新网2月18日电 日本新华侨报刊文称，东京都政府指定的“暴力团排除特别强化区域”，长期以来存在着日本人黑社会组织收取“保护费”的问题。随着2020年东京奥运会的临近，东京都政府也积极行动起来，在2月公布了《东京都暴力团排除条例》的修正案，并把东京都内22条繁华街道指定为“暴力团排除特别强化区域”，加大执法力度', '<p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">中新网2月18日电 日本新华侨报刊文称，东京都政府指定的“暴力团排除特别强化区域”，长期以来存在着日本人黑社会组织收取“保护费”的问题。随着2020年东京奥运会的临近，东京都政府也积极行动起来，在2月公布了《东京都暴力团排除条例》的修正案，并把东京都内22条繁华街道指定为“暴力团排除特别强化区域”，加大执法力度。</p><p style=\"text-align: center;\"><img src=\"http://n.sinaimg.cn/edu/crawl/136/w550h386/20190218/qJCH-htacqww4785971.jpg\" alt=\"资料图片：位于日本东京都江东区的丰洲市场。\" data-mcesrc=\"http://image1.chinanews.com.cn/cnsupload/big/2018/10-11/4-426/6e9f160633fd44da91257ebd35a052ec.jpg\" data-mceselected=\"1\" data-link=\"\" style=\"border: 0px; display: block; margin: 0px auto;\"/><span class=\"img_descr\" style=\"line-height: 20px; padding: 6px 0px; font-size: 16px; margin: 5px auto; display: inline-block; zoom: 1; text-align: left; font-weight: 700;\">资料图片：位于日本东京都江东区的丰洲市场。</span></p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　文章摘编如下：</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　过去，警方一旦抓住收取“保护费”的日本黑社会组织，会按照“直罚规定”的原则，对黑社会组织成员立即进行50万日元以下的罚款，情节严重的会进一步通过司法手续，将其判处一年有期徒刑。而对于缴纳“保护费”的店铺，警方一般是采取“劝告”、“发表”、发出“防止再发生命令”等措施，也就是说，警方是把缴纳“保护费”的店铺看作是“受害者”，不进行直接的处罚。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　但是，东京都政府这次把相关法律做了调整。今后遇到“保护费”的问题，不仅要惩罚收取“保护费”的黑社会组织成员，同时也要惩罚缴纳“保护费”的店铺经营者。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　警方指出，这些缴纳“保护费”的店铺经营者，屈服于黑社会组织的压力，导致这些“保护费”成为当地黑社会组织的活动资金。这次，警方试图用“双罚”的方式解决这个“老大难”问题。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　位于新宿的一家中餐馆的华人女老板表示，东京都警方决定今后对缴纳“保护费”的店铺经营者也进行直接处罚，是有失公正的。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　“我们这里开设中餐馆的华侨华人，没有人是愿意主动缴纳‘保护费’的。但是，当地黑社会组织成员或者他们雇用的人员，用各种各样的方式逼迫我们缴纳‘保护费’。如果我们拒绝缴纳的话，他们当中就会有头上卷发、胸脯或者胳膊上露着大片刺青、带着黑墨镜、支着一个没有小指头的巴掌的人，坐在店里的桌前，一杯又一杯地要白开水喝，然后说给了‘保护费’就没有事了。”</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　她说：“我们也曾向警方报警，警方赶到之前，他就要一碗炒饭和一份榨菜在那里吃。警方讯问他情况，他要么就说是我们的服务态度不好，要么就说我们是中国人日语不好，曲解了他的意思。警方拿他也没有办法。这样的黑社会组织成员往往第二天还会来，他可以如数家珍地说出当地警署每一个警员的名字和特长，好像他就是警长一样。”生意受到很大影响，有的时候一天都没有俩个三个客人。</p><p><ins class=\"sinaads sinaads-done\" id=\"Sinads49447\" data-ad-pdps=\"PDPS000000056053\" data-ad-status=\"done\" style=\"display: block; overflow: hidden; text-decoration-line: none;\"><ins style=\"text-decoration-line: none; margin: 0px auto; width: 300px; display: block; position: relative; overflow: hidden;\"><br/></ins></ins></p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　位于池袋的一家中式居酒屋的华人经营者称，当地黑社会组织成员收取“保护费”有各种各样的方式，有的是明火执仗地要现金，有的是过新年的时候给你抱过来两棵放在门口的门松，本来就值3万日元，他们拿过来的发票上却写着30万日元、或者40万日元。如果不给他们，他们就会在店内喝酒，酒没有喝多少，做出一副酩酊大醉的样子，从座位到厕所他可以吐一路，嘴里面还用他们特定的语言骂骂咧咧，客人们纷纷起席离开了。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　有时候碰到这种状况，会有另一拨日本黑社会组织成员从另外一个房间出来，抓住刚才闹事的黑社会成员一顿猛揍，同时会摔坏碗碟，碰断门窗，最后打得闹事的黑社会成员跪在地上给居酒屋的华侨华人老板磕头认罪。这个时候，华侨华人老板都会给出一笔“保护费”的，事后才知道他们这是搞的“苦肉计”，两拨黑社会组织同属一家。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　目前，在2020年东京奥运会来临之前，东京都政府希望打造出“世界上最安全的城市”形象，也为此做了一些努力。但是，如果不在根除黑社会组织上下大功夫，不在保护繁华街店铺经营者权益上有切实可行的措施，这种“世界上最安全的城市”目标建设是难以实现的。</p><p><br/></p>', '2', '2', '2019-02-18 22:19:08');
INSERT INTO `tp_news` VALUES ('14', '1', '1', '海外邦CRM系统上线了', '海外邦CRM系统上线了', '<p>海外邦CRM系统上线了</p>', '3', '1', '2019-02-18 22:26:40');
INSERT INTO `tp_news` VALUES ('12', '1', '1', '华人账户获西班牙银行全面解封 需在15日内补交材料', '中新网2月18日电 据西班牙欧浪网报道，当地时间2月15日，旅西侨界联盟组织了抗议银行大量冻结华人银行账户的集会。之后，BBVA银行高层通过中国驻西班牙大使馆，联系侨界代表，请求会晤。使馆代表、侨界代表在BBVA办公室，进行了近两小时的会谈。目前，BBVA银行已全面解冻华人账户。', '<p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">中新网2月18日电 据西班牙欧浪网报道，当地时间2月15日，旅西侨界联盟组织了抗议银行大量冻结华人银行账户的集会。之后，BBVA银行高层通过中国驻西班牙大使馆，联系侨界代表，请求会晤。使馆代表、侨界代表在BBVA办公室，进行了近两小时的会谈。目前，BBVA银行已全面解冻华人账户。</p><p style=\"text-align: center;\"><img src=\"http://n.sinaimg.cn/edu/crawl/33/w500h333/20190218/pUsn-htacqww4519398.jpg\" alt=\"资料图片：西班牙BBVA银行\" data-mcesrc=\"http://i2.chinanews.com/simg/cmshd/2019/02/18/0a8e017ab1ba4ad8af240f1860b1dbc1.jpg\" data-mceselected=\"1\" data-link=\"\" style=\"border: 0px; display: block; margin: 0px auto;\"/><span class=\"img_descr\" style=\"line-height: 20px; padding: 6px 0px; font-size: 16px; margin: 5px auto; display: inline-block; zoom: 1; text-align: left; font-weight: 700;\">资料图片：西班牙BBVA银行</span></p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　在当地时间15日与BBVA银行的会谈中，无论是使馆代表、还是侨界代表，都对该银行歧视华人的行为，表示了极大的不满和愤慨。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　当地时间2月16日，据旅西侨界联盟发布的消息称，旅西侨界代表接到BBVA高层电话。电话中称，银行方面已经将在2月1日以后被冻结的账户，全面解冻。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　BBVA高层表示，银行已经全面解冻华人账户，除了自动存取款机还不能正常使用之外，几乎所有功能都已经可以使用。此外，银行还会争取在近期纠正自动存取款机的问题。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　报道这次，虽然华人的银行账户已经全部解冻，但这并不代表已经完全解决问题。没有更新资料和补交收入证明的华人，仍需在15天内补齐所有材料，以避免再次被冻结。需要更新的资料包括：</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　个人信息：电话号码、邮箱、最新住址、填写个人信息申报表并签字；</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　收入证明包括：最新的居留、个人所得税、个人保险历史单、工作合同和工资单。如果是老板，则需要各类季度税单；留学生则需要最新的Matricula。</p><p style=\"text-align: center;\"><img src=\"http://n.sinaimg.cn/edu/crawl/23/w500h323/20190218/JSCu-htacqww4520000.jpg\" alt=\"资料图片：西班牙BBVA银行\" style=\"border: 0px; display: block; margin: 0px auto;\"/><span class=\"img_descr\" style=\"line-height: 20px; padding: 6px 0px; font-size: 16px; margin: 5px auto; display: inline-block; zoom: 1; text-align: left; font-weight: 700;\">资料图片：西班牙BBVA银行</span></p><p><ins class=\"sinaads sinaads-done\" id=\"Sinads49447\" data-ad-pdps=\"PDPS000000056053\" data-ad-status=\"done\" style=\"display: block; overflow: hidden; text-decoration-line: none;\"><ins style=\"text-decoration-line: none; margin: 0px auto; width: 300px; display: block; position: relative; overflow: hidden;\"><br/></ins></ins></p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　目前，BBVA银行已经履行解冻手续，但不排除有疏忽发生。如果侨胞的银行账户还没有解冻，请与旅西侨界联盟联系，侨界联盟会跟进情况，并帮助你尽快解决解冻问题。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　侨界联盟联系方式：邮箱：tousuyinhang@gmail.com，微信：jc688577011，电话：688577011。</p><p style=\"margin-top: 0px; margin-bottom: 30px; padding: 0px; font-family: &quot;Hiragino Sans GB&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsun, 宋体, Arial; font-size: 18px; letter-spacing: 1px; white-space: normal;\">　　据了解，近期，旅西侨界联盟代表还将和银行高层举行会谈，请广大侨胞将有关信息反馈给侨界联盟，以便侨界联盟与银行方面沟通。</p><p><br/></p>', '12', '2', '2019-02-18 22:00:39');

-- ----------------------------
-- Table structure for `tp_newsclass`
-- ----------------------------
DROP TABLE IF EXISTS `tp_newsclass`;
CREATE TABLE `tp_newsclass` (
  `ID` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `Sid` int(5) DEFAULT '0' COMMENT '下级分类（预留）',
  `Uid` int(8) DEFAULT '0' COMMENT '用户ID',
  `ClassName` char(20) DEFAULT NULL COMMENT '分类名称',
  `Description` char(30) DEFAULT NULL COMMENT '描述',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_newsclass
-- ----------------------------
INSERT INTO `tp_newsclass` VALUES ('1', '0', '1', '内部新闻', '内部新闻', '2013-12-25 16:23:33');
INSERT INTO `tp_newsclass` VALUES ('2', '0', '1', '焦点新闻', '焦点新闻', '2013-12-25 16:23:53');

-- ----------------------------
-- Table structure for `tp_operating`
-- ----------------------------
DROP TABLE IF EXISTS `tp_operating`;
CREATE TABLE `tp_operating` (
  `ID` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `Uid` int(8) DEFAULT '0',
  `Url` varchar(300) DEFAULT NULL COMMENT '操作块模URL',
  `Description` varchar(300) DEFAULT NULL COMMENT '说明',
  `Ip` char(60) DEFAULT NULL COMMENT '操作IP',
  `Status` tinyint(4) DEFAULT '0' COMMENT '状态,1代表成功2代表失败',
  `Dtime` datetime DEFAULT NULL COMMENT '发生时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_operating
-- ----------------------------
INSERT INTO `tp_operating` VALUES ('4', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-05 13:26:40');
INSERT INTO `tp_operating` VALUES ('23', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-05 13:32:17');
INSERT INTO `tp_operating` VALUES ('29', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-05 13:54:23');
INSERT INTO `tp_operating` VALUES ('30', '1', '/OA/index.php/File/fileindel', '删除成功', '127.0.0.1', '0', '2014-01-05 13:55:23');
INSERT INTO `tp_operating` VALUES ('31', '1', '/OA/index.php/System/module_edit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 13:56:14');
INSERT INTO `tp_operating` VALUES ('32', '1', '/OA/index.php/User/useredit_do', '更改用户资料：小峰', '127.0.0.1', '0', '2014-01-05 14:32:04');
INSERT INTO `tp_operating` VALUES ('33', '1', '/OA/index.php/User/useredit_do', '更改用户资料：小峰', '127.0.0.1', '0', '2014-01-05 14:34:10');
INSERT INTO `tp_operating` VALUES ('34', '1', '/OA/index.php/User/useredit_do', '更改用户资料：小峰', '127.0.0.1', '0', '2014-01-05 14:34:14');
INSERT INTO `tp_operating` VALUES ('35', '1', '/OA/index.php/Competence/cadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 14:35:00');
INSERT INTO `tp_operating` VALUES ('36', '1', '/OA/index.php/Competence/cadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 14:35:12');
INSERT INTO `tp_operating` VALUES ('37', '1', '/OA/index.php/Role/roleedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 14:35:50');
INSERT INTO `tp_operating` VALUES ('38', '1', '/OA/index.php/With/withadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 14:48:00');
INSERT INTO `tp_operating` VALUES ('39', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 14:54:05');
INSERT INTO `tp_operating` VALUES ('40', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 14:54:11');
INSERT INTO `tp_operating` VALUES ('41', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 14:54:55');
INSERT INTO `tp_operating` VALUES ('42', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 14:57:41');
INSERT INTO `tp_operating` VALUES ('43', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 15:12:45');
INSERT INTO `tp_operating` VALUES ('44', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 15:13:00');
INSERT INTO `tp_operating` VALUES ('45', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-05 15:13:08');
INSERT INTO `tp_operating` VALUES ('46', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-05 15:13:13');
INSERT INTO `tp_operating` VALUES ('47', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 15:28:27');
INSERT INTO `tp_operating` VALUES ('48', '1', '/OA/index.php/System/module_edit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 15:32:26');
INSERT INTO `tp_operating` VALUES ('49', '1', '/OA/index.php/System/systemconfig_do', '系统配置修改成功', '127.0.0.1', '0', '2014-01-05 15:39:34');
INSERT INTO `tp_operating` VALUES ('50', '1', '/OA/index.php/System/module_edit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 16:00:20');
INSERT INTO `tp_operating` VALUES ('51', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-05 16:00:27');
INSERT INTO `tp_operating` VALUES ('52', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 16:03:45');
INSERT INTO `tp_operating` VALUES ('53', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 16:03:56');
INSERT INTO `tp_operating` VALUES ('54', '1', '/OA/index.php/With/withadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:05:07');
INSERT INTO `tp_operating` VALUES ('55', '1', '/OA/index.php/With/withadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:05:22');
INSERT INTO `tp_operating` VALUES ('56', '1', '/OA/index.php/With/withadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:05:32');
INSERT INTO `tp_operating` VALUES ('57', '1', '/OA/index.php/With/withadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:05:42');
INSERT INTO `tp_operating` VALUES ('58', '1', '/OA/index.php/With/withadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:05:54');
INSERT INTO `tp_operating` VALUES ('59', '1', '/OA/index.php/With/withadd_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:06:07');
INSERT INTO `tp_operating` VALUES ('60', '1', '/OA/index.php/System/systemconfig_do', '系统配置修改成功', '127.0.0.1', '0', '2014-01-05 16:33:30');
INSERT INTO `tp_operating` VALUES ('61', '1', '/OA/index.php/News/add_do', '新增失败标题请在80个字符以内！', '127.0.0.1', '1', '2014-01-05 16:45:36');
INSERT INTO `tp_operating` VALUES ('62', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:46:41');
INSERT INTO `tp_operating` VALUES ('63', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:48:00');
INSERT INTO `tp_operating` VALUES ('64', '1', '/OA/index.php/News/edit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 16:48:45');
INSERT INTO `tp_operating` VALUES ('65', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:50:11');
INSERT INTO `tp_operating` VALUES ('66', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:51:50');
INSERT INTO `tp_operating` VALUES ('67', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:52:34');
INSERT INTO `tp_operating` VALUES ('68', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:53:25');
INSERT INTO `tp_operating` VALUES ('69', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:54:43');
INSERT INTO `tp_operating` VALUES ('70', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:55:54');
INSERT INTO `tp_operating` VALUES ('71', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:56:56');
INSERT INTO `tp_operating` VALUES ('72', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:58:04');
INSERT INTO `tp_operating` VALUES ('73', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-05 16:59:24');
INSERT INTO `tp_operating` VALUES ('74', '1', '/OA/index.php/System/module_edit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 17:07:28');
INSERT INTO `tp_operating` VALUES ('75', '1', '/OA/index.php/System/module_edit_do', '更新成功', '127.0.0.1', '0', '2014-01-05 17:07:42');
INSERT INTO `tp_operating` VALUES ('76', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-05 17:07:51');
INSERT INTO `tp_operating` VALUES ('77', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-05 19:34:29');
INSERT INTO `tp_operating` VALUES ('78', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-06 00:19:59');
INSERT INTO `tp_operating` VALUES ('79', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-06 00:23:40');
INSERT INTO `tp_operating` VALUES ('80', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-06 00:31:33');
INSERT INTO `tp_operating` VALUES ('81', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-06 00:38:37');
INSERT INTO `tp_operating` VALUES ('82', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-06 22:21:22');
INSERT INTO `tp_operating` VALUES ('83', '1', '/OA/index.php/User/in_user_del', '批量删除ID为：4,3的数据', '127.0.0.1', '0', '2014-01-07 20:47:05');
INSERT INTO `tp_operating` VALUES ('84', '1', '/OA/index.php/News/add_do', '新增成功', '127.0.0.1', '0', '2014-01-08 21:28:30');
INSERT INTO `tp_operating` VALUES ('85', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-08 21:28:39');
INSERT INTO `tp_operating` VALUES ('86', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-08 21:31:51');
INSERT INTO `tp_operating` VALUES ('87', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-08 21:33:23');
INSERT INTO `tp_operating` VALUES ('88', '1', '/OA/index.php/Upload/filedo', '上传成功', '127.0.0.1', '0', '2014-01-08 21:40:11');
INSERT INTO `tp_operating` VALUES ('89', '1', '/OA/index.php/File/filedel', '删除成功', '127.0.0.1', '0', '2014-01-08 21:40:24');
INSERT INTO `tp_operating` VALUES ('90', '1', '/OA/index.php/File/fileindel', '删除成功', '127.0.0.1', '0', '2014-01-08 21:48:14');
INSERT INTO `tp_operating` VALUES ('91', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-08 21:49:06');
INSERT INTO `tp_operating` VALUES ('92', '1', '/OA/index.php/System/systemcore_do', '核心配置文件修改成功', '127.0.0.1', '0', '2014-01-08 21:56:14');
INSERT INTO `tp_operating` VALUES ('93', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-08 21:56:20');
INSERT INTO `tp_operating` VALUES ('94', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-08 21:57:00');
INSERT INTO `tp_operating` VALUES ('95', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-08 21:57:31');
INSERT INTO `tp_operating` VALUES ('96', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-08 23:36:29');
INSERT INTO `tp_operating` VALUES ('97', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-08 23:36:52');
INSERT INTO `tp_operating` VALUES ('98', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-08 23:37:04');
INSERT INTO `tp_operating` VALUES ('99', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-08 23:39:24');
INSERT INTO `tp_operating` VALUES ('100', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-08 23:39:56');
INSERT INTO `tp_operating` VALUES ('101', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-08 23:40:22');
INSERT INTO `tp_operating` VALUES ('102', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-08 23:40:51');
INSERT INTO `tp_operating` VALUES ('104', '1', '/OA/index.php/System/systemconfig_do', '系统配置修改成功', '127.0.0.1', '0', '2014-01-09 21:13:47');
INSERT INTO `tp_operating` VALUES ('105', '1', '/OA/index.php/System/systemconfig_do', '系统配置修改成功', '127.0.0.1', '0', '2014-01-09 21:14:31');
INSERT INTO `tp_operating` VALUES ('106', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-09 21:16:33');
INSERT INTO `tp_operating` VALUES ('107', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-09 21:16:37');
INSERT INTO `tp_operating` VALUES ('108', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-13 22:30:49');
INSERT INTO `tp_operating` VALUES ('109', '1', '/OA/index.php/With/withedit_do', '更新成功', '127.0.0.1', '0', '2014-01-13 22:30:52');
INSERT INTO `tp_operating` VALUES ('110', '1', '/OA/index.php/User/useredit_do', '更改用户资料：admin', '127.0.0.1', '0', '2014-01-21 21:07:12');
INSERT INTO `tp_operating` VALUES ('111', '1', '/OA/index.php/Competence/cedit_do', '更新成功', '127.0.0.1', '0', '2014-01-21 21:08:31');
INSERT INTO `tp_operating` VALUES ('112', '1', '/OA/index.php/System/systemconfig_do', '系统配置修改成功', '127.0.0.1', '0', '2014-01-21 21:15:45');
INSERT INTO `tp_operating` VALUES ('113', '1', '/OA/index.php/Competence/cedit_do', '更新成功', '127.0.0.1', '0', '2014-01-21 21:21:26');
INSERT INTO `tp_operating` VALUES ('114', '1', '/OA/index.php/Competence/cadd_do', '新增成功', '127.0.0.1', '0', '2014-01-21 21:22:26');
INSERT INTO `tp_operating` VALUES ('115', '1', '/OA/index.php/Competence/cedit_do', '更新成功', '127.0.0.1', '0', '2014-01-21 21:23:58');
INSERT INTO `tp_operating` VALUES ('116', '1', '/OA/index.php/Competence/cadd_do', '新增成功', '127.0.0.1', '0', '2014-01-21 21:25:27');
INSERT INTO `tp_operating` VALUES ('117', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-21 21:34:10');
INSERT INTO `tp_operating` VALUES ('118', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:26');
INSERT INTO `tp_operating` VALUES ('119', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:30');
INSERT INTO `tp_operating` VALUES ('120', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:34');
INSERT INTO `tp_operating` VALUES ('121', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:37');
INSERT INTO `tp_operating` VALUES ('122', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:41');
INSERT INTO `tp_operating` VALUES ('123', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:44');
INSERT INTO `tp_operating` VALUES ('124', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:47');
INSERT INTO `tp_operating` VALUES ('125', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:50');
INSERT INTO `tp_operating` VALUES ('126', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:53');
INSERT INTO `tp_operating` VALUES ('127', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:34:56');
INSERT INTO `tp_operating` VALUES ('128', '1', '/OA/index.php/Loginlog/indel', '登录日志删除成功', '127.0.0.1', '0', '2014-01-21 21:35:02');
INSERT INTO `tp_operating` VALUES ('129', '1', '/OA/index.php/User/useredit_do', '更改用户资料：admin', '127.0.0.1', '0', '2014-01-21 21:35:43');
INSERT INTO `tp_operating` VALUES ('130', '1', '/OA/index.php/User/useredit_do', '更改用户资料：admin', '127.0.0.1', '0', '2014-01-21 21:35:52');
INSERT INTO `tp_operating` VALUES ('131', '1', '/OA/index.php/Common/clearcache', '清空站点缓存', '127.0.0.1', '0', '2014-01-21 21:41:10');
INSERT INTO `tp_operating` VALUES ('132', '1', '/ziyuanbang/index.php/News/classedit_do', '更新成功', '122.96.43.136', '0', '2019-02-18 14:48:34');
INSERT INTO `tp_operating` VALUES ('133', '1', '/ziyuanbang/index.php/Client/clientadd_do', '新增客户：aaa', '122.96.43.136', '0', '2019-02-18 14:49:31');
INSERT INTO `tp_operating` VALUES ('134', '1', '/ziyuanbang/index.php/Client/opensharedo', '共享客户编号为：14的数据', '122.96.43.136', '0', '2019-02-18 14:49:44');
INSERT INTO `tp_operating` VALUES ('135', '1', '/ziyuanbang/index.php/Client/opensharedo', '共享客户编号为：14的数据', '122.96.43.136', '0', '2019-02-18 14:49:45');
INSERT INTO `tp_operating` VALUES ('136', '1', '/ziyuanbang/index.php/User/useradd_do', '新增用户：abcde', '122.96.43.136', '0', '2019-02-18 14:53:18');
INSERT INTO `tp_operating` VALUES ('137', '6', '/ziyuanbang/index.php/User/uedit_do', '修改密码成功', '122.96.43.136', '0', '2019-02-18 14:56:45');
INSERT INTO `tp_operating` VALUES ('138', '1', '/index.php/User/userdel', '删除用户ID为：6的数据', '122.96.43.136', '0', '2019-02-18 15:01:55');
INSERT INTO `tp_operating` VALUES ('139', '1', '/index.php/User/useradd_do', '新增用户：hanlu', '122.96.43.136', '0', '2019-02-18 15:02:29');
INSERT INTO `tp_operating` VALUES ('140', '1', '/index.php/User/useradd_do', '新增用户：chenli', '122.96.43.136', '0', '2019-02-18 15:03:24');
INSERT INTO `tp_operating` VALUES ('141', '1', '/index.php/User/in_user_del', '批量删除ID为：5,2的数据', '122.96.43.136', '0', '2019-02-18 15:03:41');
INSERT INTO `tp_operating` VALUES ('142', '1', '/index.php/User/useradd_do', '新增用户：user', '122.96.43.136', '0', '2019-02-18 15:04:22');
INSERT INTO `tp_operating` VALUES ('143', '1', '/index.php/User/useradd_do', '新增用户：manage', '122.96.43.136', '0', '2019-02-18 15:04:43');
INSERT INTO `tp_operating` VALUES ('144', '1', '/index.php/Client/client_indel', '删除成功：Array', '122.96.43.136', '0', '2019-02-18 15:05:15');
INSERT INTO `tp_operating` VALUES ('145', '1', '/index.php/Client/clientadd_do', '新增客户：客户A', '122.96.43.136', '0', '2019-02-18 15:06:33');
INSERT INTO `tp_operating` VALUES ('146', '1', '/index.php/Role/roleadd_do', '新增成功', '122.96.43.136', '0', '2019-02-18 15:12:09');
INSERT INTO `tp_operating` VALUES ('147', '1', '/index.php/Role/roleedit_do', '更新成功', '122.96.43.136', '0', '2019-02-18 15:12:30');
INSERT INTO `tp_operating` VALUES ('148', '1', '/index.php/User/useradd_do', '新增用户：hehuo', '122.96.43.136', '0', '2019-02-18 15:13:15');
INSERT INTO `tp_operating` VALUES ('149', '11', '/index.php/Client/clientadd_do', '新增客户：客户A', '122.96.43.136', '0', '2019-02-18 15:14:45');
INSERT INTO `tp_operating` VALUES ('150', '1', '/index.php/User/useradd_do', '新增用户：hehuo2', '122.96.43.136', '0', '2019-02-18 15:15:38');
INSERT INTO `tp_operating` VALUES ('151', '1', '/index.php/Common/clearcache', '清空站点缓存', '122.96.43.136', '0', '2019-02-18 15:32:04');
INSERT INTO `tp_operating` VALUES ('152', '1', '/index.php/Client/opensharedo', '共享客户编号为：15的数据', '122.96.43.136', '0', '2019-02-18 15:33:42');
INSERT INTO `tp_operating` VALUES ('153', '1', '/index.php/Client/opensharedo', '共享客户编号为：15的数据', '122.96.43.136', '0', '2019-02-18 15:33:43');
INSERT INTO `tp_operating` VALUES ('154', '8', '/index.php/User/useradd_do', '新增用户：zhouqing', '180.101.231.130', '0', '2019-02-18 21:55:15');
INSERT INTO `tp_operating` VALUES ('155', '1', '/index.php/News/add_do', '新增成功', '121.237.233.8', '0', '2019-02-18 22:00:39');
INSERT INTO `tp_operating` VALUES ('156', '1', '/index.php/News/newsindel', '删除成功', '121.237.233.8', '0', '2019-02-18 22:01:08');
INSERT INTO `tp_operating` VALUES ('157', '13', '/index.php/Client/clientadd_do', '新增客户：谢先生', '180.101.231.130', '0', '2019-02-18 22:04:41');
INSERT INTO `tp_operating` VALUES ('158', '13', '/index.php/With/withadd_do', '新增成功', '180.101.231.130', '0', '2019-02-18 22:10:43');
INSERT INTO `tp_operating` VALUES ('159', '13', '/index.php/With/withadd_do', '新增成功', '180.101.231.130', '0', '2019-02-18 22:11:47');
INSERT INTO `tp_operating` VALUES ('160', '1', '/index.php/Common/clearcache', '清空站点缓存', '121.237.233.8', '0', '2019-02-18 22:18:06');
INSERT INTO `tp_operating` VALUES ('161', '1', '/index.php/News/add_do', '新增成功', '121.237.233.8', '0', '2019-02-18 22:19:08');
INSERT INTO `tp_operating` VALUES ('162', '1', '/index.php/Common/clearcache', '清空站点缓存', '121.237.233.8', '0', '2019-02-18 22:19:16');
INSERT INTO `tp_operating` VALUES ('163', '8', '/index.php/User/useredit_do', '更改用户资料：zhouqing', '180.101.231.130', '0', '2019-02-18 22:20:04');
INSERT INTO `tp_operating` VALUES ('164', '1', '/index.php/News/add_do', '新增成功', '121.237.233.8', '0', '2019-02-18 22:26:40');
INSERT INTO `tp_operating` VALUES ('165', '1', '/index.php/Common/clearcache', '清空站点缓存', '121.237.233.8', '0', '2019-02-18 22:26:46');
INSERT INTO `tp_operating` VALUES ('166', '1', '/index.php/Client/client_indel', '删除成功：Array', '121.237.233.8', '0', '2019-02-18 22:29:40');
INSERT INTO `tp_operating` VALUES ('167', '1', '/index.php/With/with_indel', '删除成功', '121.237.233.8', '0', '2019-02-18 22:29:55');
INSERT INTO `tp_operating` VALUES ('168', '1', '/index.php/Common/clearcache', '清空站点缓存', '121.237.233.8', '0', '2019-02-18 22:39:21');
INSERT INTO `tp_operating` VALUES ('169', '8', '/index.php/User/useradd_do', '新增用户：chixiaoyue', '180.101.231.130', '0', '2019-02-19 14:39:46');
INSERT INTO `tp_operating` VALUES ('170', '14', '/index.php/Client/clientadd_do', '新增客户：纪', '180.101.231.130', '0', '2019-02-19 14:43:01');
INSERT INTO `tp_operating` VALUES ('171', '14', '/index.php/Client/clientadd_do', '新增客户：李老师', '180.101.231.130', '0', '2019-02-19 14:51:16');
INSERT INTO `tp_operating` VALUES ('172', '14', '/index.php/Client/clientedit_do', '更新客户资料：李老师', '180.101.231.130', '0', '2019-02-19 14:51:45');
INSERT INTO `tp_operating` VALUES ('173', '14', '/index.php/With/withadd_do', '新增成功', '180.101.231.130', '0', '2019-02-19 15:56:17');
INSERT INTO `tp_operating` VALUES ('174', '13', '/index.php/Client/clientadd_do', '新增客户：王先生 ', '180.101.231.130', '0', '2019-02-19 16:21:04');
INSERT INTO `tp_operating` VALUES ('175', '13', '/index.php/Client/clientedit_do', '更新客户资料：王先生（北京）', '180.101.231.130', '0', '2019-02-19 16:22:12');
INSERT INTO `tp_operating` VALUES ('176', '13', '/index.php/With/withadd_do', '新增成功', '180.101.231.130', '0', '2019-02-19 16:25:06');
INSERT INTO `tp_operating` VALUES ('177', '13', '/index.php/Client/clientadd_do', '新增客户：刘烜 xuan （北京客户）', '180.101.231.130', '0', '2019-02-19 16:31:05');
INSERT INTO `tp_operating` VALUES ('178', '13', '/index.php/Client/clientedit_do', '更新客户资料：刘烜 xuan （北京客户）', '180.101.231.130', '0', '2019-02-19 16:31:30');
INSERT INTO `tp_operating` VALUES ('179', '13', '/index.php/With/withadd_do', '新增成功', '180.101.231.130', '0', '2019-02-19 16:36:12');
INSERT INTO `tp_operating` VALUES ('180', '13', '/index.php/Client/clientedit_do', '更新客户资料：谢先生（海口）', '180.101.231.130', '0', '2019-02-19 16:37:50');
INSERT INTO `tp_operating` VALUES ('181', '1', '/index.php/Common/clearcache', '清空站点缓存', '122.96.42.22', '0', '2019-02-20 08:59:20');
INSERT INTO `tp_operating` VALUES ('182', '1', '/index.php/Role/roleedit_do', '更新成功', '122.96.42.22', '0', '2019-02-20 09:03:48');
INSERT INTO `tp_operating` VALUES ('183', '1', '/index.php/Role/roleedit_do', '更新成功', '121.237.233.8', '0', '2019-02-24 18:17:05');
INSERT INTO `tp_operating` VALUES ('184', '14', '/index.php/Client/clientadd_do', '新增客户：税号陈总', '114.222.225.149', '0', '2019-02-27 21:22:30');
INSERT INTO `tp_operating` VALUES ('185', '14', '/index.php/Client/clientadd_do', '新增客户：BVI税号 李总', '114.222.225.149', '0', '2019-02-27 21:24:00');
INSERT INTO `tp_operating` VALUES ('186', '14', '/index.php/Client/clientadd_do', '新增客户：加拿大周先生', '114.222.225.149', '0', '2019-02-27 21:24:46');
INSERT INTO `tp_operating` VALUES ('187', '1', '/index.php/Upload/filedo', '上传成功', '121.237.233.8', '0', '2019-02-28 22:26:09');
INSERT INTO `tp_operating` VALUES ('188', '1', '/index.php/Upload/filedo', '上传成功', '121.237.233.8', '0', '2019-02-28 22:26:58');
INSERT INTO `tp_operating` VALUES ('189', '1', '/index.php/System/systemcore_do', '核心配置文件修改成功', '122.96.41.41', '0', '2019-03-01 08:48:09');
INSERT INTO `tp_operating` VALUES ('190', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 08:48:37');
INSERT INTO `tp_operating` VALUES ('191', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 08:49:05');
INSERT INTO `tp_operating` VALUES ('192', '1', '/index.php/File/fileedit_do', '修改成功', '122.96.41.41', '0', '2019-03-01 08:49:27');
INSERT INTO `tp_operating` VALUES ('193', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 08:52:39');
INSERT INTO `tp_operating` VALUES ('194', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 08:52:53');
INSERT INTO `tp_operating` VALUES ('195', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:07:00');
INSERT INTO `tp_operating` VALUES ('196', '1', '/index.php/Upload/picdo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:09:23');
INSERT INTO `tp_operating` VALUES ('197', '1', '/index.php/File/fileedit_do', '修改成功', '122.96.41.41', '0', '2019-03-01 09:09:52');
INSERT INTO `tp_operating` VALUES ('198', '1', '/index.php/Common/clearcache', '清空站点缓存', '122.96.41.41', '0', '2019-03-01 09:13:09');
INSERT INTO `tp_operating` VALUES ('199', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 09:18:57');
INSERT INTO `tp_operating` VALUES ('200', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 09:19:03');
INSERT INTO `tp_operating` VALUES ('201', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:19:38');
INSERT INTO `tp_operating` VALUES ('202', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 09:19:59');
INSERT INTO `tp_operating` VALUES ('203', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 09:21:31');
INSERT INTO `tp_operating` VALUES ('204', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:21:50');
INSERT INTO `tp_operating` VALUES ('205', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 09:22:28');
INSERT INTO `tp_operating` VALUES ('206', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:24:00');
INSERT INTO `tp_operating` VALUES ('207', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:24:09');
INSERT INTO `tp_operating` VALUES ('208', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 09:24:28');
INSERT INTO `tp_operating` VALUES ('209', '1', '/index.php/File/filedel', '删除成功', '122.96.41.41', '0', '2019-03-01 09:24:32');
INSERT INTO `tp_operating` VALUES ('210', '1', '/index.php/File/fileclass_add_do', '新增成功', '122.96.41.41', '0', '2019-03-01 09:31:18');
INSERT INTO `tp_operating` VALUES ('211', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:43:49');
INSERT INTO `tp_operating` VALUES ('212', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:44:55');
INSERT INTO `tp_operating` VALUES ('213', '1', '/index.php/Upload/filedo', '上传成功', '122.96.41.41', '0', '2019-03-01 09:52:34');

-- ----------------------------
-- Table structure for `tp_role`
-- ----------------------------
DROP TABLE IF EXISTS `tp_role`;
CREATE TABLE `tp_role` (
  `ID` int(5) NOT NULL AUTO_INCREMENT,
  `Rolename` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `Description` varchar(50) DEFAULT NULL COMMENT '用户组说明',
  `Competence` varchar(255) DEFAULT NULL COMMENT '用户组权限列表',
  `Status` tinyint(2) DEFAULT '0' COMMENT '用户组状态',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_role
-- ----------------------------
INSERT INTO `tp_role` VALUES ('1', '超级管理员', '拥有全部权限，网站主要管理人员', '2,3,4,5,7,8,9,10,12,13,14,15,21,22,23,24,25,26,27,28,18,19,20,82,83,29,30,32,33,52,53,35,36,37,38,39,40,41,42,43,77,45,46,47,48,49,50,51,84,60,61,62,63,65,66,67,68,69,70,71,72,73,74,75,76,78,79,80,81,85,', '0', '2013-12-08 17:13:02');
INSERT INTO `tp_role` VALUES ('2', '普通管理员', '只拥有部分权限操作权限', '2,7,12,21,25,18,19,29,32,52,35,43,77,45,60,65,72,73,74,78,', '0', '2013-12-08 17:14:40');
INSERT INTO `tp_role` VALUES ('3', '来宾用户', '只供浏览本系统', '2,7,12,21,25,18,19,29,32,52,35,43,77,45,60,65,72,73,74,78,', '0', '2013-12-08 17:18:25');
INSERT INTO `tp_role` VALUES ('4', '合伙人', '海外邦合伙人', '35,39,40,41,43,77,65,66,67,69,70,72,73,78,79,80,85,', '0', '2019-02-18 15:12:09');

-- ----------------------------
-- Table structure for `tp_statis`
-- ----------------------------
DROP TABLE IF EXISTS `tp_statis`;
CREATE TABLE `tp_statis` (
  `ID` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `Uid` int(8) DEFAULT '0',
  `Dtime` char(12) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_statis
-- ----------------------------
INSERT INTO `tp_statis` VALUES ('35', '1', '1553233516');

-- ----------------------------
-- Table structure for `tp_user`
-- ----------------------------
DROP TABLE IF EXISTS `tp_user`;
CREATE TABLE `tp_user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `Password` char(40) DEFAULT NULL COMMENT '密码',
  `Email` varchar(30) DEFAULT NULL COMMENT '管理员Email',
  `Roleid` tinyint(2) DEFAULT '0' COMMENT '用户角色',
  `Status` tinyint(2) DEFAULT '0' COMMENT '状态',
  `Competence` varchar(255) DEFAULT NULL COMMENT '权限列表',
  `Description` varchar(50) DEFAULT NULL COMMENT '说明',
  `Loginarea` varchar(20) DEFAULT NULL COMMENT '最后登录地',
  `Logincount` int(5) DEFAULT '0' COMMENT '登录次数',
  `Loginip` varchar(30) DEFAULT NULL COMMENT '最后登录IP',
  `Logintime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `Dtime` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_user
-- ----------------------------
INSERT INTO `tp_user` VALUES ('1', 'admin', '036d0ef7567a20b5a4ad24a354ea4a945ddab676', 'gu@qq.com', '1', '0', '2,3,4,5,7,8,9,10,12,13,14,15,21,22,23,24,25,26,27,28,18,19,20,82,83,29,30,32,33,52,53,35,36,37,38,39,40,41,42,43,77,45,46,47,48,49,50,51,84,60,61,62,63,65,66,67,68,69,70,71,72,73,74,75,76,78,79,80,81,85,', '超级管理员', '.', '251', null, '2019-03-22 13:44:45', '2013-12-08 17:18:54');
INSERT INTO `tp_user` VALUES ('11', 'hehuo', '628dadb55b94fa690351543a33af4034eb914e95', 'hehuo@qq.com', '4', '0', '35,39,40,41,43,77,65,66,67,69,70,72,73,78,79,80,85,', '合伙人', '.', '1', null, '2019-02-18 15:14:03', '2019-02-18 15:13:15');
INSERT INTO `tp_user` VALUES ('9', 'user', '856008f9f26bd8fb28130e546dd0a791d6dacae0', 'user@qq.com', '3', '0', '2,7,12,21,25,18,19,29,32,52,35,43,77,45,60,65,72,73,74,78,', '', '.', '1', null, '2019-02-18 15:07:21', '2019-02-18 15:04:22');
INSERT INTO `tp_user` VALUES ('10', 'manage', '63e423f71a319af4403dadc3eee3eb6291564fbd', 'manage@qq.com', '2', '0', '2,7,12,21,25,18,19,29,32,52,35,43,77,45,60,65,72,73,74,78,', '', '.', '1', null, '2019-02-18 15:08:59', '2019-02-18 15:04:43');
INSERT INTO `tp_user` VALUES ('7', 'hanlu', '5b491766eb7fa0bbf66e6bb6375cfd5f5a40fd4e', 'hanlu@qq.com', '1', '0', '2,3,4,5,7,8,9,10,12,13,14,15,21,22,23,24,25,26,27,28,18,19,20,82,83,29,30,32,33,52,53,35,36,37,38,39,40,41,42,43,77,45,46,47,48,49,50,51,84,60,61,62,63,65,66,67,68,69,70,71,72,73,74,75,76,78,79,80,81,85,', '超级管理员', '.', '1', null, '2019-02-20 09:00:51', '2019-02-18 15:02:29');
INSERT INTO `tp_user` VALUES ('8', 'chenli', '76576a11c38b5dcec17959bb156381b9e2789dcc', 'chenli@qq.com', '1', '0', '2,3,4,5,7,8,9,10,12,13,14,15,21,22,23,24,25,26,27,28,18,19,20,82,83,29,30,32,33,52,53,35,36,37,38,39,40,41,42,43,77,45,46,47,48,49,50,51,84,60,61,62,63,65,66,67,68,69,70,71,72,73,74,75,76,78,79,80,81,85,', '', '.', '6', null, '2019-02-28 11:25:41', '2019-02-18 15:03:24');
INSERT INTO `tp_user` VALUES ('12', 'hehuo2', '628dadb55b94fa690351543a33af4034eb914e95', 'hehuo@qq.com', '4', '0', '35,39,40,41,43,77,65,66,67,69,70,72,73,78,79,80,85,', '', '.', '2', null, '2019-03-01 09:10:06', '2019-02-18 15:15:38');
INSERT INTO `tp_user` VALUES ('13', 'zhouqing', '7c1e2bb2f6e25fa39ccf0022409198e9d651df63', '24283294@qq.com', '4', '0', '35,39,40,43,77,65,66,67,69,70,72,73,78,79,80,85,', '', '.', '4', null, '2019-02-19 17:11:36', '2019-02-18 21:55:15');
INSERT INTO `tp_user` VALUES ('14', 'chixiaoyue', '269f58a8c26baf896174236f215b42e0a1c40aa3', '24283294@qq.com', '4', '0', '35,39,40,41,43,77,65,66,67,69,70,72,73,78,79,80,85,', '', '.', '4', null, '2019-02-27 21:21:19', '2019-02-19 14:39:46');

-- ----------------------------
-- Table structure for `tp_with`
-- ----------------------------
DROP TABLE IF EXISTS `tp_with`;
CREATE TABLE `tp_with` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Uid` int(10) DEFAULT '0' COMMENT '户用ID',
  `Cid` int(10) DEFAULT '0' COMMENT '客户档案编号',
  `Wast` tinyint(4) DEFAULT NULL COMMENT '跟单类型',
  `NameId` tinyint(4) DEFAULT NULL COMMENT '跟单对象',
  `NextTime` datetime DEFAULT NULL COMMENT '下次联系时间',
  `RemindTime` datetime DEFAULT NULL COMMENT '提醒时间',
  `Status` tinyint(4) DEFAULT '0',
  `Remind` tinyint(2) DEFAULT '0' COMMENT '是否已完成',
  `Content` varchar(1000) DEFAULT NULL COMMENT '详细描述',
  `Dtime` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_with
-- ----------------------------
INSERT INTO `tp_with` VALUES ('11', '14', '19', '46', '20', '2019-02-22 11:00:00', '2019-02-22 10:00:00', '0', '0', '客户说这2天正在看资产够不够1000万，说我们双方都需要先评估看看，加个微信，这2天跟进吧', '2019-02-19 15:56:17');
INSERT INTO `tp_with` VALUES ('3', '1', '5', '48', '5', '2014-01-09 00:00:00', '2014-01-08 23:40:00', '0', '1', '重要客户', '2014-01-07 19:43:36');
INSERT INTO `tp_with` VALUES ('8', '9', '12', '46', '13', '2014-01-09 00:00:00', '2014-01-09 00:00:00', '0', '0', '', '2014-01-08 14:39:36');
INSERT INTO `tp_with` VALUES ('9', '13', '17', '46', '18', '2019-02-21 10:09:45', '2019-02-21 10:09:45', '0', '0', '客户对欧洲感兴趣，，，', '2019-02-18 22:10:43');
INSERT INTO `tp_with` VALUES ('10', '13', '17', '46', '18', '2019-02-22 11:11:20', '2019-02-22 11:11:20', '0', '0', '再接着联系', '2019-02-18 22:11:47');
INSERT INTO `tp_with` VALUES ('12', '13', '20', '46', '21', '2019-02-26 10:24:21', '2019-02-26 10:24:21', '0', '0', '客户说了声 “讨厌” 就挂了，北京腔好重，嘻嘻', '2019-02-19 16:25:06');
INSERT INTO `tp_with` VALUES ('13', '13', '21', '46', '22', '2019-02-26 10:00:00', '2019-02-26 10:00:00', '0', '0', '说目前没这个需求', '2019-02-19 16:36:12');
