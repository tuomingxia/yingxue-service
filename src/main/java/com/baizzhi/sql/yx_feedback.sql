/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50550
 Source Host           : 127.0.0.1:3306
 Source Schema         : yingx

 Target Server Type    : MySQL
 Target Server Version : 50550
 File Encoding         : 65001

 Date: 18/09/2021 20:04:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yx_feedback
-- ----------------------------
DROP TABLE IF EXISTS `yx_feedback`;
CREATE TABLE `yx_feedback`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(8) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `delete_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of yx_feedback
-- ----------------------------
INSERT INTO `yx_feedback` VALUES (1, '头像修改', '修改头像失败', 3, '2021-09-07 20:01:39', '2021-09-07 20:01:39', NULL);
INSERT INTO `yx_feedback` VALUES (2, '登录bug', '登录不上去', 1, '2021-09-16 20:01:42', '2021-09-16 20:01:42', NULL);
INSERT INTO `yx_feedback` VALUES (3, '视频播放异常', '视频播放异常', 3, '2021-09-15 20:01:45', '2021-09-15 20:01:45', NULL);

SET FOREIGN_KEY_CHECKS = 1;
