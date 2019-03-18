/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost:3306
 Source Schema         : musicexam

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 18/03/2019 16:58:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for music_admin
-- ----------------------------
DROP TABLE IF EXISTS `music_admin`;
CREATE TABLE `music_admin`  (
  `adm_id` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '管理员id',
  `adm_name` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  `adm_accounts` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '管理员帐号',
  `adm_password` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `adm_header` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '管理员头像',
  `adm_isroot` int(2) NULL DEFAULT NULL COMMENT '是否是超级管理员（1是 ，0 否）',
  `adm_createtime` datetime(0) NULL DEFAULT NULL COMMENT '管理员创建时间',
  `adm_createbyid` varchar(0) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '管理员创建人id',
  `adm_updatetime` datetime(0) NULL DEFAULT NULL COMMENT '管理员更新时间',
  `adm_updatebyid` varchar(0) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '管理员更新人id',
  `adm_isdel` int(2) NULL DEFAULT NULL COMMENT '是否删除（0删除，1不删除）',
  PRIMARY KEY (`adm_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music_admin
-- ----------------------------
INSERT INTO `music_admin` VALUES ('AD86af0b96-5f51-4c2a-bdab-9a587b5852f4', '我正在更新', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:47:45', NULL, '2019-03-18 13:11:12', NULL, 1);
INSERT INTO `music_admin` VALUES ('AD7617a6a5-745b-4a7b-8bde-bcb52ac60c82', '测试', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:22', NULL, '2019-03-18 11:48:22', NULL, 1);
INSERT INTO `music_admin` VALUES ('AD3def43d4-8528-478e-b6a3-53569c0db9b4', '测试', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:25', NULL, '2019-03-18 11:48:25', NULL, 1);
INSERT INTO `music_admin` VALUES ('ADca419be9-4d25-4fca-94f4-9c43230e888f', '测试', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:27', NULL, '2019-03-18 11:48:27', NULL, 1);
INSERT INTO `music_admin` VALUES ('AD56487097-59c1-4eee-bff1-a4e2c7ebdfc9', '测试', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:29', NULL, '2019-03-18 11:48:29', NULL, 1);
INSERT INTO `music_admin` VALUES ('ADf3e79345-ed87-431b-ad98-857c9a42f29a', '测试', '123456', 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:31', NULL, '2019-03-18 11:48:31', NULL, 1);
INSERT INTO `music_admin` VALUES ('ADf7373e2f-b6f6-434c-ae7a-bce87b3b7c02', '我爱', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:34', NULL, '2019-03-18 11:48:34', NULL, 1);
INSERT INTO `music_admin` VALUES ('ADc1a6ef11-1c92-41a7-9771-5748a9baa91c', '测试', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:42', NULL, '2019-03-18 11:48:42', NULL, 1);
INSERT INTO `music_admin` VALUES ('AD39ac81be-e977-4ec8-bf72-3046ed890d8a', '我爱', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:44', NULL, '2019-03-18 11:48:44', NULL, 1);
INSERT INTO `music_admin` VALUES ('AD76e80db5-7cad-4f17-8e10-b9c5047f1c50', '测试', NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 0, '2019-03-18 11:48:46', NULL, '2019-03-18 11:48:46', NULL, 1);

-- ----------------------------
-- Table structure for music_instruments
-- ----------------------------
DROP TABLE IF EXISTS `music_instruments`;
CREATE TABLE `music_instruments`  (
  `ins_id` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '乐器id',
  `ins_name` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '乐器名称',
  `ins_createtime` datetime(0) NULL DEFAULT NULL COMMENT '乐器创建时间',
  `ins_createbyid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '乐器创建人id',
  `ins_updatetime` datetime(0) NULL DEFAULT NULL COMMENT '乐器更新时间',
  `ins_updatebyid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '乐器更新人',
  `ins_isdel` int(255) NULL DEFAULT NULL COMMENT '是否删除（0删除，1不删除）',
  PRIMARY KEY (`ins_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music_instruments
-- ----------------------------
INSERT INTO `music_instruments` VALUES ('YQ4b139f9c-3aa7-47ee-9656-01b0cc80367e', '我正在更新', '2019-03-18 15:00:58', NULL, '2019-03-18 15:11:54', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQ7af1ccf4-7257-474c-bb38-e7b57f4e5f4a', '萨克斯管', '2019-03-18 15:01:38', NULL, '2019-03-18 15:01:38', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQ41ccdda4-b8dd-4503-92df-25f3101e620e', '萨克斯管', '2019-03-18 15:01:46', NULL, '2019-03-18 15:01:46', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQ937f2a26-1b16-4863-a68b-df5f62131296', '萨克斯管', '2019-03-18 15:01:48', NULL, '2019-03-18 15:01:48', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQ2f9a48d6-1e63-445d-b197-28d8d1e5a97a', '我正在更新', '2019-03-18 15:01:50', NULL, '2019-03-18 15:01:50', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQbd3feac6-8535-4c5e-a6a9-820ad54e0c18', '萨克斯管', '2019-03-18 15:06:22', NULL, '2019-03-18 15:06:22', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQ56ea6890-e881-4cd1-a2b6-eb1302751c3a', '萨克斯管', '2019-03-18 15:40:52', NULL, '2019-03-18 15:40:52', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQd13afd38-49f4-4807-acbe-fd862e428b2a', '萨克斯管', '2019-03-18 15:41:09', NULL, '2019-03-18 15:41:09', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQadec4926-40b6-4690-bc3a-4e6381431814', '萨克斯管', '2019-03-18 15:41:12', NULL, '2019-03-18 15:41:12', NULL, 1);
INSERT INTO `music_instruments` VALUES ('YQ965f797a-9c42-44fb-8ecf-e68effb65b7e', '萨克斯管', '2019-03-18 15:41:14', NULL, '2019-03-18 15:41:14', NULL, 1);

-- ----------------------------
-- Table structure for music_student
-- ----------------------------
DROP TABLE IF EXISTS `music_student`;
CREATE TABLE `music_student`  (
  `stu_id` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '学生id',
  `stu_accounts` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '学生帐号',
  `stu_password` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '学生密码',
  `stu_name` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `stu_sex` int(1) NULL DEFAULT NULL COMMENT '学生性别 （0 女生 ， 1男生）',
  `stu_header` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '学生头像',
  `stu_instrumentsid` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '乐器id',
  `stu_instruments` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '学生乐器',
  `stu_examination` int(100) NULL DEFAULT NULL COMMENT '考试得分   百分制 ',
  `stu_teacherid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师id',
  `stu_createtime` datetime(0) NULL DEFAULT NULL COMMENT '学生创建时间',
  `stu_createbyid` varchar(0) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '学生创建人id',
  `stu_updatetime` datetime(0) NULL DEFAULT NULL COMMENT '学生更新时间',
  `stu_updatebyid` varchar(0) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '学生更新人id',
  `stu_isdel` int(1) NULL DEFAULT NULL COMMENT '是否删除（0删除，1不删除）',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of music_student
-- ----------------------------
INSERT INTO `music_student` VALUES ('XS45ee6bcc-91f4-43e9-b9f3-b727a057bea9', '123456', 'e10adc3949ba59abbe56e057f20f883e', '莉莉', 0, NULL, NULL, NULL, NULL, NULL, '2019-03-18 16:40:11', NULL, '2019-03-18 16:40:11', NULL, 1);
INSERT INTO `music_student` VALUES ('XS71bfa25c-1558-4b9e-94c8-58207e15b946', '123456', 'e10adc3949ba59abbe56e057f20f883e', '莉莉', 0, NULL, NULL, NULL, NULL, NULL, '2019-03-18 16:41:08', NULL, '2019-03-18 16:41:08', NULL, 1);
INSERT INTO `music_student` VALUES ('XS3213c087-cbcf-4bfd-84bd-7916579dacd2', '123456', 'e10adc3949ba59abbe56e057f20f883e', '莉莉', 0, NULL, NULL, NULL, NULL, NULL, '2019-03-18 16:41:10', NULL, '2019-03-18 16:41:10', NULL, 1);
INSERT INTO `music_student` VALUES ('XS11be5bda-a194-457b-a15c-8d01677c67e1', '123456', 'e10adc3949ba59abbe56e057f20f883e', '莉莉', 0, NULL, NULL, NULL, NULL, NULL, '2019-03-18 16:41:12', NULL, '2019-03-18 16:41:12', NULL, 1);
INSERT INTO `music_student` VALUES ('XSf0d60858-5e90-4e8d-8af5-e9575f90cfb3', '123456', 'e10adc3949ba59abbe56e057f20f883e', '我正在更新', 0, NULL, NULL, NULL, NULL, NULL, '2019-03-18 16:44:39', NULL, '2019-03-18 16:48:04', NULL, 1);

-- ----------------------------
-- Table structure for music_teacher
-- ----------------------------
DROP TABLE IF EXISTS `music_teacher`;
CREATE TABLE `music_teacher`  (
  `tea_id` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '教师id',
  `tea_name` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL COMMENT '教师姓名',
  `tea_accounts` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师帐号',
  `tea_password` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师密码',
  `tea_sex` int(2) NULL DEFAULT NULL COMMENT '教师性别（0女生 1男生）',
  `tea_header` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师头像',
  `tea_instrumentsid` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师科目id',
  `tea_instruments` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师科目',
  `tea_createtime` datetime(0) NULL DEFAULT NULL COMMENT '教师创建时间',
  `tea_createbyid` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师创建人id',
  `tea_updatetime` datetime(0) NULL DEFAULT NULL COMMENT '教师更新时间',
  `tea_updatebyid` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '教师更新人id',
  `tea_isdel` int(1) NULL DEFAULT NULL COMMENT '是否删除（0删除，1不删除）',
  PRIMARY KEY (`tea_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
