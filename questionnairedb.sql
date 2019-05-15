/*
Navicat MySQL Data Transfer

Source Server         : lian
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : questionnairedb

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-05-09 14:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for announce_table
-- ----------------------------
DROP TABLE IF EXISTS `announce_table`;
CREATE TABLE `announce_table` (
  `id` int(20) NOT NULL auto_increment,
  `sponsorId` int(20) default NULL,
  `content` varchar(255) default NULL,
  `submitTime` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announce_table
-- ----------------------------
INSERT INTO `announce_table` VALUES ('4', '1', '服务器将于18日维修', '2019-04-16 14:27:08');

-- ----------------------------
-- Table structure for answer_table
-- ----------------------------
DROP TABLE IF EXISTS `answer_table`;
CREATE TABLE `answer_table` (
  `id` int(20) NOT NULL auto_increment,
  `ownerQuestionnaireId` int(20) default NULL,
  `ownerQuestionId` int(20) NOT NULL,
  `ownerQuestionHeading` varchar(255) default NULL,
  `ownerStudentId` int(20) NOT NULL,
  `option` varchar(255) default NULL,
  `answer` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer_table
-- ----------------------------
INSERT INTO `answer_table` VALUES ('64', '13', '43', '您择业首先考虑的因素是', '52', 'A', '经济收入');
INSERT INTO `answer_table` VALUES ('65', '13', '44', '您毕业后的打算是', '52', 'B', '先择业后就业');
INSERT INTO `answer_table` VALUES ('66', '13', '45', '你最希望从你的第一份工作学到什么', '52', 'C', '未来事业的发展方向');
INSERT INTO `answer_table` VALUES ('67', '13', '46', '你首选的就业方向', '52', 'D', '自主创业');
INSERT INTO `answer_table` VALUES ('72', '11', '21', '感到他/她聪明和机智？', '52', 'A', '很不真实的描述');
INSERT INTO `answer_table` VALUES ('73', '11', '22', '期待未来会有好的事情发生', '52', 'A', '非常不确定');
INSERT INTO `answer_table` VALUES ('74', '11', '23', '所在年级？', '52', 'A', '大一');
INSERT INTO `answer_table` VALUES ('75', '11', '24', '对自己情绪的控制方式？', '52', 'A', '压抑');
INSERT INTO `answer_table` VALUES ('80', '13', '43', '您择业首先考虑的因素是', '41', 'C', '工作稳定性');
INSERT INTO `answer_table` VALUES ('81', '13', '44', '您毕业后的打算是', '41', 'B', '先择业后就业');
INSERT INTO `answer_table` VALUES ('82', '13', '45', '你最希望从你的第一份工作学到什么', '41', 'C', '未来事业的发展方向');
INSERT INTO `answer_table` VALUES ('83', '13', '46', '你首选的就业方向', '41', 'B', '学校及科研研究所');
INSERT INTO `answer_table` VALUES ('84', '11', '21', '感到他/她聪明和机智？', '38', 'B', '有点不真实的描述');
INSERT INTO `answer_table` VALUES ('85', '11', '22', '期待未来会有好的事情发生', '38', 'A', '非常不确定');
INSERT INTO `answer_table` VALUES ('86', '11', '23', '所在年级？', '38', 'C', '大三');
INSERT INTO `answer_table` VALUES ('87', '11', '24', '对自己情绪的控制方式？', '38', 'B', '接纳');
INSERT INTO `answer_table` VALUES ('88', '13', '43', '您择业首先考虑的因素是', '38', 'D', '专业相关度');
INSERT INTO `answer_table` VALUES ('89', '13', '44', '您毕业后的打算是', '38', 'C', '继续深造');
INSERT INTO `answer_table` VALUES ('90', '13', '45', '你最希望从你的第一份工作学到什么', '38', 'A', '工作经验');
INSERT INTO `answer_table` VALUES ('91', '13', '46', '你首选的就业方向', '38', 'A', '政府机关');
INSERT INTO `answer_table` VALUES ('92', '11', '21', '感到他/她聪明和机智？', '41', 'C', '有点真实的描述');
INSERT INTO `answer_table` VALUES ('93', '11', '22', '期待未来会有好的事情发生', '41', 'C', '有点确定');
INSERT INTO `answer_table` VALUES ('94', '11', '23', '所在年级？', '41', 'B', '大二');
INSERT INTO `answer_table` VALUES ('95', '11', '24', '对自己情绪的控制方式？', '41', 'D', '不在乎');
INSERT INTO `answer_table` VALUES ('96', '14', '47', '你通常几点起床', '52', 'A', '5点多');
INSERT INTO `answer_table` VALUES ('97', '14', '48', '你一天学习多长时间', '52', 'B', '2小时以内');
INSERT INTO `answer_table` VALUES ('98', '14', '49', '你如何背诵课文', '52', 'B', '小声朗读');

-- ----------------------------
-- Table structure for class_table
-- ----------------------------
DROP TABLE IF EXISTS `class_table`;
CREATE TABLE `class_table` (
  `id` int(20) NOT NULL auto_increment,
  `className` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_table
-- ----------------------------
INSERT INTO `class_table` VALUES ('16', '15计科一班', '争创计算机一流');
INSERT INTO `class_table` VALUES ('30', '15计科二班', '夺取ACM冠军');
INSERT INTO `class_table` VALUES ('35', '16音乐一班', '声乐我最强');
INSERT INTO `class_table` VALUES ('36', '16会计二班', '精通各种税务');

-- ----------------------------
-- Table structure for gift_table
-- ----------------------------
DROP TABLE IF EXISTS `gift_table`;
CREATE TABLE `gift_table` (
  `id` int(20) NOT NULL auto_increment,
  `score` int(20) NOT NULL,
  `giftName` varchar(255) default NULL,
  `giftDescription` varchar(255) default NULL,
  `giftSrc` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gift_table
-- ----------------------------
INSERT INTO `gift_table` VALUES ('1', '10', '苹果', '红富士苹果', 'apple.jpg');
INSERT INTO `gift_table` VALUES ('3', '2', '足球', '签名的足球', 'scoer.jpg');
INSERT INTO `gift_table` VALUES ('4', '3', '三体', '一本科幻巨著', 'book.jpg');

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `id` int(20) NOT NULL auto_increment,
  `studentId` int(20) default NULL,
  `giftId` int(20) default NULL,
  `giftName` varchar(255) default NULL,
  `address` varchar(255) NOT NULL,
  `status` varchar(255) default NULL,
  `submitTime` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_table
-- ----------------------------
INSERT INTO `order_table` VALUES ('1', '52', '1', '苹果', '平顶山', '失败', '2019-03-20 16:14:54');
INSERT INTO `order_table` VALUES ('2', '23', '3', '足球', '郑州', '失败', '2019-03-20 16:40:24');
INSERT INTO `order_table` VALUES ('3', '12', '1', '苹果', '信阳', '成功', '2019-03-20 16:43:43');
INSERT INTO `order_table` VALUES ('4', '22', '4', '三体', '商丘', '失败', '2019-03-20 17:14:39');
INSERT INTO `order_table` VALUES ('5', '41', '1', '苹果', '安阳', '未审核', '2019-03-20 17:14:55');
INSERT INTO `order_table` VALUES ('6', '21', '4', '三体', '平顶山', '未审核', '2019-03-20 17:15:23');
INSERT INTO `order_table` VALUES ('7', '52', '3', '足球', '平顶山', '失败', '2019-03-20 17:15:28');
INSERT INTO `order_table` VALUES ('30', '52', '4', '三体', '平顶山', '未审核', '2019-04-28 11:01:34');
INSERT INTO `order_table` VALUES ('31', '52', '3', '足球', '平顶山', '未审核', '2019-04-28 13:33:57');

-- ----------------------------
-- Table structure for questionnaire_table
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire_table`;
CREATE TABLE `questionnaire_table` (
  `id` int(20) NOT NULL auto_increment,
  `sponsorId` int(20) default NULL,
  `score` int(20) default NULL,
  `questionnaireTitle` varchar(255) default NULL,
  `questionnaireDescription` varchar(255) default NULL,
  `questionnaireType` varchar(255) default NULL,
  `submitTime` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionnaire_table
-- ----------------------------
INSERT INTO `questionnaire_table` VALUES ('11', '1', '3', '心理调查', '调查学生心理状况', '校园', '2019-03-07 15:41:23', '已发布');
INSERT INTO `questionnaire_table` VALUES ('13', '1', '1', '毕业生调查', '毕业生调查', '人文', '2019-03-07 16:36:45', '已发布');
INSERT INTO `questionnaire_table` VALUES ('14', '1', '3', '如何高效学习', '学习', '人文', '2019-03-20 14:42:53', '已发布');

-- ----------------------------
-- Table structure for question_table
-- ----------------------------
DROP TABLE IF EXISTS `question_table`;
CREATE TABLE `question_table` (
  `id` int(20) NOT NULL auto_increment,
  `ownerQuestionnaireId` int(20) default NULL,
  `ownerQuestionnaireTitle` varchar(255) default NULL,
  `questionHeading` varchar(255) default NULL,
  `questionType` varchar(255) default NULL,
  `optionA` varchar(255) default NULL,
  `optionB` varchar(255) default NULL,
  `optionC` varchar(255) default NULL,
  `optionD` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_table
-- ----------------------------
INSERT INTO `question_table` VALUES ('21', '11', '心理调查', '感到他/她聪明和机智？', '单选题', '很不真实的描述', '有点不真实的描述', '有点真实的描述', '很真实的描述');
INSERT INTO `question_table` VALUES ('22', '11', '心理调查', '期待未来会有好的事情发生', '单选题', '非常不确定', '不确定', '有点确定', '非常不确定');
INSERT INTO `question_table` VALUES ('23', '11', '心理调查', '所在年级？', '单选题', '大一', '大二', '大三', '大四');
INSERT INTO `question_table` VALUES ('43', '13', '毕业生调查', '您择业首先考虑的因素是', '单选题', '经济收入', '个人发展', '工作稳定性', '专业相关度');
INSERT INTO `question_table` VALUES ('44', '13', '毕业生调查', '您毕业后的打算是', '单选题', '先就业后择业', '先择业后就业', '继续深造', '自主创业');
INSERT INTO `question_table` VALUES ('45', '13', '毕业生调查', '你最希望从你的第一份工作学到什么', '单选题', '工作经验', '人际关系', '未来事业的发展方向', '纯粹一份稳定的工作，作为经济支柱');
INSERT INTO `question_table` VALUES ('46', '13', '毕业生调查', '你首选的就业方向', '单选题', '政府机关', '学校及科研研究所', '国有企业', '自主创业');
INSERT INTO `question_table` VALUES ('47', '14', '如何高效学习', '你通常几点起床', '单选题', '5点多', '6点多', '7点多', '8点多');
INSERT INTO `question_table` VALUES ('48', '14', '如何高效学习', '你一天学习多长时间', '单选题', '1小时以内', '2小时以内', '3小时以内', '4小时以内');
INSERT INTO `question_table` VALUES ('49', '14', '如何高效学习', '你如何背诵课文', '单选题', '大声朗读', '小声朗读', '边看边默写', '默背');
INSERT INTO `question_table` VALUES ('50', '11', '心理调查', 'ddv', '单选题', 'v', 'vb', 'v', 'v');

-- ----------------------------
-- Table structure for student_table
-- ----------------------------
DROP TABLE IF EXISTS `student_table`;
CREATE TABLE `student_table` (
  `id` int(20) NOT NULL auto_increment,
  `ownerClassId` int(20) default NULL,
  `phoneNumber` varchar(255) default NULL,
  `score` int(20) default NULL,
  `studyNumber` int(20) default NULL,
  `account` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `isAdmin` varchar(255) default NULL,
  `registerTime` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_table
-- ----------------------------
INSERT INTO `student_table` VALUES ('1', '2', '13071715642', '0', '151210204', 'qwe', 'asd', '李东博', '男', '平顶山', 'admin', '2019-02-27 21:15:41');
INSERT INTO `student_table` VALUES ('38', '2', '13071715641', '54', '151210230', 'zzz', 'zzz', '小刚', '男', '商丘', 'notAdmin', '2019-02-23 18:24:16');
INSERT INTO `student_table` VALUES ('41', '1', '15852654752', '8', '151210223', 'ccc', 'ccc', '小红', '女', '信阳', 'notAdmin', '2019-02-25 17:18:25');
INSERT INTO `student_table` VALUES ('52', '2', '13085621435', '16', '151210204', 'xxx', 'xxx', '李桦', '女', '平顶山', 'notAdmin', '2019-03-05 18:40:03');
INSERT INTO `student_table` VALUES ('54', '1', '15985632562', '0', '0', 'vvv', 'vvv', '小志', '男', '郑州', 'notAdmin', '2019-03-06 17:33:14');
INSERT INTO `student_table` VALUES ('61', '0', '', '0', '0', '', '123456', '', '', '', 'notAdmin', '2019-04-28 13:32:36');
