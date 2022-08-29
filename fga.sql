/*
 Navicat Premium Data Transfer

 Source Server         : Connection
 Source Server Type    : MySQL
 Source Server Version : 100424
 Source Host           : localhost:3306
 Source Schema         : fga

 Target Server Type    : MySQL
 Target Server Version : 100424
 File Encoding         : 65001

 Date: 29/08/2022 01:23:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `UserId` int(11) NOT NULL,
  `Username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `RoleId` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES (1, 'Admin', 'Admin', 1);

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data`  (
  `IdBarang` int(11) NOT NULL AUTO_INCREMENT,
  `Kode_Barang` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Nama_Barang` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Model` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Jenis` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Kadar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Berat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdBarang`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES (1, 'ABC32', 'Emas Antam', 'Gelang', 'Emas Kuning', '99%', '25');
INSERT INTO `data` VALUES (2, 'ABC33', 'Emas Aneka', 'Gelang', 'Emas Kuning', '99%', '23');
INSERT INTO `data` VALUES (3, 'ABC34', 'Emas Aneka', 'Gelang', 'Emas Kuning', '80%', '23');
INSERT INTO `data` VALUES (5, 'A425', 'Emas Antam', 'Gelang Kaki', 'Emas Putih', '80%', '20');
INSERT INTO `data` VALUES (6, 'AG45', 'Emas Aneka', 'Gelang', 'Emas Putih', '80%', '27');
INSERT INTO `data` VALUES (7, 'AG566AL', 'Emas Aneka', 'Cincin', 'Emas Putih', '99%', '77');
INSERT INTO `data` VALUES (8, 'Test', 'Emas Antam', 'Kalung', 'Emas Kuning', '80%', '22');
INSERT INTO `data` VALUES (9, 'da', 'ss', 'asd', 'Emas Kuning', '80%', '23');
INSERT INTO `data` VALUES (10, 'asda', 'fas', 'asd', 'Emas Kuning', '80%', '23');
INSERT INTO `data` VALUES (11, 'asd', 'fasd', 'asd', 'Emas Putih', '99%', '23');
INSERT INTO `data` VALUES (12, 'das', 'ffas', 'dass', 'Emas Kuning', '99%', '23');
INSERT INTO `data` VALUES (13, 'asd', 'fafas', 'sd', 'Emas Putih', '99%', '23');
INSERT INTO `data` VALUES (14, 'asd', 'dd', 'asd', 'Emas Putih', '99%', '23');
INSERT INTO `data` VALUES (15, 'ABC32', 'Emas', 'Gelang', 'Emas Kuning', '99%', '25');
INSERT INTO `data` VALUES (16, 'ABC32', 'Emas', 'Gelang', 'Emas Kuning', '99%', '25');
INSERT INTO `data` VALUES (17, 'ABC32', 'Emas Antam', 'Gelang', 'Emas Kuning', '99%', '25');
INSERT INTO `data` VALUES (18, 'aas', '23', '44', 'Emas Putih', '99%', '11');
INSERT INTO `data` VALUES (19, 'aas', '23', '44', 'Emas Putih', '99%', '11');

SET FOREIGN_KEY_CHECKS = 1;
