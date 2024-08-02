/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : yuapi

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 02/08/2024 18:04:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for interface_info
-- ----------------------------
DROP TABLE IF EXISTS `interface_info`;
CREATE TABLE `interface_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口地址',
  `requestHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求头',
  `responseHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '响应头',
  `requestParams` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '接口状态 0-关闭 1-开启',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求类型',
  `userId` bigint(20) NOT NULL COMMENT '创建人',
  `createTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除(0-未删 1-已删)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interface_info
-- ----------------------------
INSERT INTO `interface_info` VALUES (1, '许擎宇5', 'xxxx', 'www.cary-king.net', 'xxxx', 'xxxxx', 'xxx', 0, 'xxxx', 1, '2024-07-30 15:00:09', '2024-07-30 15:00:10', 0);
INSERT INTO `interface_info` VALUES (2, '测试接口', 'xxxxxxxxx', 'http://localhost:1234', 'xxxxx', 'xxxxxxx', NULL, 0, 'GET', 1, '2024-07-29 12:04:59', NULL, 0);
INSERT INTO `interface_info` VALUES (3, '测试接口2', '嘻嘻嘻嘻嘻嘻嘻嘻嘻', 'http://localhost:123', 'xxxxx', 'xxxxx', NULL, 0, 'GET', 1, '2024-07-29 14:36:23', '2024-07-29 14:36:23', 1);
INSERT INTO `interface_info` VALUES (4, '测试接口6', 'xxxxxx', 'http://localhost:123', 'xxxx', 'xxxx', NULL, 0, 'GET', 1, '2024-07-30 14:29:08', '2024-07-30 14:29:09', 0);
INSERT INTO `interface_info` VALUES (5, 'getNameByPost', '获取用户名', 'http://localhost:8123/api/name/user', '{\n  \"Content-Type\": \"application/json\"\n}', '{\n  \"Content-Type\": \"application/json\"\n}', '[\n  {\n    \"name\": \"username\",\n    \"type\": \"string\"\n  }\n]', 1, 'POST', 1, '2024-07-30 16:07:52', '2024-07-30 16:07:53', 0);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `gender` tinyint(4) NOT NULL DEFAULT 0 COMMENT '性别（0-男, 1-女）',
  `education` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `place` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地点',
  `job` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `contact` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `loveExp` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '感情经历',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容（个人介绍）',
  `photo` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片地址',
  `reviewStatus` int(11) NOT NULL DEFAULT 0 COMMENT '状态（0-待审核, 1-通过, 2-拒绝）',
  `reviewMessage` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核信息',
  `viewNum` int(11) NOT NULL DEFAULT 0 COMMENT '浏览数',
  `thumbNum` int(11) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `userId` bigint(20) NOT NULL COMMENT '创建用户 id',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '帖子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userName` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `userAccount` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `userAvatar` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `gender` tinyint(4) NULL DEFAULT NULL COMMENT '性别',
  `userRole` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'user' COMMENT '用户角色：user / admin',
  `userPassword` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `accessKey` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'accessKey',
  `secretKey` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'secretKey',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_userAccount`(`userAccount`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lhy', 'serpent', 'https://cdnjson.com/images/2024/07/03/photomode_15122020_183521.png', NULL, 'admin', 'b0dd3697a192885d7c055db46155b26a', 'lhy', 'abcdefg', '2024-07-28 14:35:07', '2024-07-29 16:49:20', 0);
INSERT INTO `user` VALUES (2, 'xxx', 'lhyyy', NULL, NULL, 'user', 'b0dd3697a192885d7c055db46155b26a', 'e50d3545608289a13fc163723dd4e482', 'd71123d1eed57bf594afcd41f8fa9765', '2024-07-30 14:47:40', '2024-08-01 18:53:59', 0);

-- ----------------------------
-- Table structure for user_interface_info
-- ----------------------------
DROP TABLE IF EXISTS `user_interface_info`;
CREATE TABLE `user_interface_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) NOT NULL COMMENT '调用用户id',
  `interfaceInfoId` bigint(20) NOT NULL COMMENT '接口id',
  `totalNum` int(10) NOT NULL DEFAULT 0 COMMENT '总调用次数',
  `leftNum` int(10) NOT NULL DEFAULT 10 COMMENT '剩余调用次数',
  `status` int(10) NOT NULL DEFAULT 0 COMMENT '0正常1禁用',
  `createTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(3) NULL DEFAULT 0 COMMENT '是否删除0删除1已删',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_interface_info
-- ----------------------------
INSERT INTO `user_interface_info` VALUES (1, 1, 5, 8, 4, 0, '2024-08-01 18:33:36', '2024-08-01 18:33:36', 0);
INSERT INTO `user_interface_info` VALUES (2, 2, 5, 2, 8, 0, '2024-08-02 16:16:57', '2024-08-02 16:16:57', 0);
INSERT INTO `user_interface_info` VALUES (3, 1, 5, 13, 10, 0, '2024-08-02 17:31:27', '2024-08-02 17:31:27', 0);
INSERT INTO `user_interface_info` VALUES (4, 2, 2, 13, 10, 0, '2024-08-02 17:32:08', '2024-08-02 17:32:08', 0);
INSERT INTO `user_interface_info` VALUES (5, 1, 4, 1, 10, 0, '2024-08-02 17:32:11', '2024-08-02 17:32:11', 0);
INSERT INTO `user_interface_info` VALUES (6, 2, 5, 23, 10, 0, '2024-08-02 17:32:15', '2024-08-02 17:32:15', 0);
INSERT INTO `user_interface_info` VALUES (7, 1, 2, 23, 10, 0, NULL, NULL, 0);
INSERT INTO `user_interface_info` VALUES (8, 2, 4, 22, 10, 0, NULL, NULL, 0);

SET FOREIGN_KEY_CHECKS = 1;
