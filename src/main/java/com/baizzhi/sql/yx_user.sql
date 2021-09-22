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

 Date: 18/09/2021 20:04:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yx_user
-- ----------------------------
DROP TABLE IF EXISTS `yx_user`;
CREATE TABLE `yx_user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wechat_openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `delete_time` datetime NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of yx_user
-- ----------------------------
INSERT INTO `yx_user` VALUES (1, '123', '小黑', 'lalala2222', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616403447881-9.jpg', '123', 0, '2021-03-25 08:00:00', '2021-03-25 08:00:00', NULL, '男');
INSERT INTO `yx_user` VALUES (2, '15236674712', 'guest', '阿斯顿撒多ssss', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616136641269-11.jpg', '15236674712', 0, '2021-01-18 08:00:00', '2021-01-18 08:00:00', NULL, '女');
INSERT INTO `yx_user` VALUES (3, '12', '测试', '测试', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616136872519-4.jpg', '12', 0, '2021-04-16 14:54:32', '2021-04-16 14:54:32', NULL, '女');
INSERT INTO `yx_user` VALUES (4, '15236674712', 'admin', '蓝色汽车', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616136623182-9.jpg', '15236674712', 0, '2021-05-14 14:50:23', '2021-05-14 14:50:23', NULL, '男');
INSERT INTO `yx_user` VALUES (5, '12', '21', '12', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616403447881-9.jpg', '12', 0, '2021-05-21 16:57:27', '2021-05-21 16:57:27', NULL, '女');
INSERT INTO `yx_user` VALUES (6, '15236674712', 'xiaohei', '阿斯顿撒多', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616137062368-2.jpg', '15236674712', 1, '2021-01-26 14:57:42', '2021-01-26 14:57:42', NULL, '男');

SET FOREIGN_KEY_CHECKS = 1;
