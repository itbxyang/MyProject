/*
 Navicat Premium Data Transfer

 Source Server         : db1
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : empdb

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 04/12/2019 15:20:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL COMMENT '编号',
  `ename` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位',
  `hiredate` date NOT NULL COMMENT '受聘日期',
  `sal` double(30, 0) NOT NULL COMMENT '工资',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '卜向阳', '软件工程师', '2019-12-05', 80000);
INSERT INTO `employee` VALUES (2, '张三', '测试', '2019-08-06', 60000);
INSERT INTO `employee` VALUES (3, '李四', '前端工程师', '2019-09-03', 70000);
INSERT INTO `employee` VALUES (4, '王五', '安卓工程师', '2019-12-10', 50000);
INSERT INTO `employee` VALUES (5, '赵六', 'JAVA讲师', '2019-02-06', 20000);
INSERT INTO `employee` VALUES (6, '田七', 'PHP讲师', '2019-12-18', 40000);

SET FOREIGN_KEY_CHECKS = 1;
