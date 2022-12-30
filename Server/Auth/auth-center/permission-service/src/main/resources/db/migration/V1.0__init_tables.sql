-- MySQL dump 10.13  Distrib 5.7.19, for osx10.12 (x86_64)
--
-- Host: 192.168.1.101    Database: auth_center
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `parent_id` bigint DEFAULT NULL COMMENT '父级ID',
    `title` varchar(100) DEFAULT NULL COMMENT '菜单名称',
    `level` int DEFAULT NULL COMMENT '菜单级数',
    `sort` int DEFAULT NULL COMMENT '菜单排序',
    `name` varchar(100) DEFAULT NULL COMMENT '前端名称',
    `url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
    `icon` varchar(200) DEFAULT NULL COMMENT '前端图标',
    `hidden` int DEFAULT NULL COMMENT '前端隐藏',
    `platform_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '平台ID(eg: MCP平台)',
    `company_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '企业ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update` datetime DEFAULT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) COMMENT='后台菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,0,'测试',0,0,'test',NULL,'test',0,NULL,NULL,'2020-09-25 08:14:54',NULL),(2,1,'测试菜单1',1,0,'test_menu1',NULL,'console',0,NULL,NULL,'2020-09-25 08:14:54',NULL),(3,1,'测试菜单2',1,0,'test_menu2',NULL,'console',0,NULL,NULL,'2020-09-25 08:14:54',NULL),(4,0,'物流管理',0,0,'mcp',NULL,'barcode',0,NULL,NULL,'2020-09-27 09:42:41',NULL),(5,4,'组箱数据查看',1,0,'packageList',NULL,'box',0,NULL,NULL,'2020-09-27 09:42:41',NULL),(6,4,'散瓶下线数据查看',1,0,'bottleList',NULL,'bottle',0,NULL,NULL,'2020-09-27 09:42:41',NULL),(7,4,'出库单查看',1,0,'outOfStockList',NULL,'outofstock',0,NULL,NULL,'2020-09-27 09:42:41',NULL),(8,4,'瓶箱码互查',1,0,'bottleBoxQuery',NULL,'bbcode',0,NULL,NULL,'2020-09-27 09:42:41',NULL),(9,4,'退货查看',1,0,'returnList',NULL,'return',0,NULL,NULL,'2020-09-27 09:42:41',NULL),(10,0,'company',0,0,'company',NULL,'company',0,NULL,NULL,'2020-10-09 07:42:33',NULL),(11,10,'companyInfo',1,1,'companyInfo',NULL,'query',0,NULL,NULL,'2020-10-09 07:42:33',NULL),(12,4,'companyInfo2',1,2,'companyInfo2',NULL,'query',0,NULL,NULL,'2020-10-09 07:42:33',NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_resource`
--

DROP TABLE IF EXISTS `sys_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_resource` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
    `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',
    `category_id` bigint DEFAULT NULL COMMENT '资源分类ID',
    `platform_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '平台ID(eg: MCP平台)',
    `company_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '企业ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update` datetime DEFAULT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) COMMENT='后台资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_resource`
--

LOCK TABLES `sys_resource` WRITE;
/*!40000 ALTER TABLE `sys_resource` DISABLE KEYS */;
INSERT INTO `sys_resource` VALUES (1,'book-api所有接口','/book-api/**',NULL,NULL,NULL,'mcp-app','2020-09-10 06:24:44',NULL),(2,'PDA MNG所有接口','/pda-mng-service/**',NULL,NULL,NULL,'mcp-app','2020-09-10 07:09:23',NULL),(3,'Tenant管理所有接口','/tenant-mng-service/**',NULL,NULL,NULL,'mcp-app','2020-09-23 09:42:14',NULL),(4,'PEMISSION所有接口','/permission-service/**',NULL,NULL,NULL,'mcp-app','2020-09-25 08:54:02',NULL),(5,'BASE INFO所有接口','/base-info-service/**',NULL,NULL,NULL,'mcp-app','2020-10-09 10:22:09',NULL);
/*!40000 ALTER TABLE `sys_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu_relation`
--

DROP TABLE IF EXISTS `sys_role_menu_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu_relation` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `role_id` bigint DEFAULT NULL COMMENT '角色ID',
    `menu_id` bigint DEFAULT NULL COMMENT '菜单ID',
    `platform_id` varchar(50) DEFAULT NULL COMMENT '平台ID(eg: MCP平台)',
    `company_id` varchar(50) DEFAULT NULL COMMENT '企业ID',
    PRIMARY KEY (`id`)
) COMMENT='后台角色菜单关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu_relation`
--

LOCK TABLES `sys_role_menu_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_menu_relation` DISABLE KEYS */;
INSERT INTO `sys_role_menu_relation` VALUES (1,1,1,NULL,'mcp-app'),(2,1,2,NULL,'mcp-app'),(3,1,3,NULL,'mcp-app'),(4,1,4,NULL,'mcp-app'),(5,1,5,NULL,'mcp-app'),(6,1,6,NULL,'mcp-app'),(7,1,7,NULL,'mcp-app'),(8,1,8,NULL,'mcp-app'),(9,1,9,NULL,'mcp-app'),(10,1,10,NULL,'mcp-app'),(11,1,11,NULL,'mcp-app'),(12,1,12,NULL,'mcp-app');
/*!40000 ALTER TABLE `sys_role_menu_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_admin_user`
--

DROP TABLE IF EXISTS `sys_admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_admin_user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `username` varchar(64) DEFAULT NULL,
    `password` varchar(64) DEFAULT NULL,
    `platform_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '平台ID(eg: MCP平台)',
    `company_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '企业ID',
    `icon` varchar(500) DEFAULT NULL COMMENT '头像',
    `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
    `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
    `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
    `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
    `status` int DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
    `pda_group` varchar(50) DEFAULT NULL COMMENT 'PDA用户组',
    `user_type_id` int DEFAULT NULL COMMENT '用户类型ID(1:公司后台用户, 2:PDA用户)',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update` datetime DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`id`)
) COMMENT='后台用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_admin_user`
--

LOCK TABLES `sys_admin_user` WRITE;
/*!40000 ALTER TABLE `sys_admin_user` DISABLE KEYS */;
INSERT INTO `sys_admin_user` VALUES (1,'kg','$2a$10$vjWD16IjmPgu3XwaiGawz.O18VQnXK3Qu5w061947W0LepWutz8qG',NULL,'mcp-app',NULL,'kg518@qq.com','KG',NULL,NULL,1,NULL,1,'2020-09-10 06:24:42',NULL),(2,'pda_wd21','$2a$10$kjT74/1nEzBR1mVqhqBKa.iMhajXYVYBzvr4gHB40Rx8B.cr39kPa',NULL,'wd-app',NULL,NULL,'wd2',NULL,NULL,1,'403',2,'2017-09-21 17:21:03',NULL);
/*!40000 ALTER TABLE `sys_admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(100) DEFAULT NULL COMMENT '名称',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',
    `admin_count` int DEFAULT NULL COMMENT '后台用户数量',
    `status` int DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
    `sort` int DEFAULT '0',
    `platform_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '平台ID(eg: MCP平台)',
    `company_id` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL COMMENT '企业ID',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `last_update` datetime DEFAULT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`id`)
) COMMENT='后台用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'ADMIN','管理员',0,1,0,NULL,NULL,'2020-09-10 06:24:42',NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client_details` (
    `client_id` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin NOT NULL,
    `resource_ids` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    `client_secret` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    `scope` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    `authorized_grant_types` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    `authorities` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    `access_token_validity` int DEFAULT NULL,
    `refresh_token_validity` int DEFAULT NULL,
    `additional_information` varchar(4096) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    `autoapprove` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8_bin DEFAULT NULL,
    PRIMARY KEY (`client_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_details`
--

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` VALUES ('mcp-app',NULL,'$2a$10$LRPmGQiCTkxrGc4xvHDBje.YBNlV3UpfW0vNAkithBLNLzNs.kdsm','all','password,refresh_token',NULL,'all',86400,604800,NULL,'true'),('book-app',NULL,'$2a$10$LRPmGQiCTkxrGc4xvHDBje.YBNlV3UpfW0vNAkithBLNLzNs.kdsm','all','password,refresh_token',NULL,'all',86400,604800,NULL,'true');
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_resource_relation`
--

DROP TABLE IF EXISTS `sys_role_resource_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_resource_relation` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `role_id` bigint DEFAULT NULL COMMENT '角色ID',
    `resource_id` bigint DEFAULT NULL COMMENT '资源ID',
    `platform_id` varchar(50) DEFAULT NULL COMMENT '平台ID(eg: MCP平台)',
    `company_id` varchar(50) DEFAULT NULL COMMENT '企业ID',
    PRIMARY KEY (`id`)
) COMMENT='后台角色资源关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_resource_relation`
--

LOCK TABLES `sys_role_resource_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_resource_relation` DISABLE KEYS */;
INSERT INTO `sys_role_resource_relation` VALUES (1,1,1,NULL,'mcp-app'),(2,1,2,NULL,'mcp-app'),(3,1,3,NULL,'mcp-app'),(4,1,4,NULL,'mcp-app'),(5,1,5,NULL,'mcp-app');
/*!40000 ALTER TABLE `sys_role_resource_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_admin_role_relation`
--

DROP TABLE IF EXISTS `sys_admin_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_admin_role_relation` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `admin_id` bigint DEFAULT NULL,
    `role_id` bigint DEFAULT NULL,
    `platform_id` varchar(50) DEFAULT NULL COMMENT '平台ID(eg: MCP平台)',
    `company_id` varchar(50) DEFAULT NULL COMMENT '企业ID',
    PRIMARY KEY (`id`)
) COMMENT='后台用户和角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_admin_role_relation`
--

LOCK TABLES `sys_admin_role_relation` WRITE;
/*!40000 ALTER TABLE `sys_admin_role_relation` DISABLE KEYS */;
INSERT INTO `sys_admin_role_relation` VALUES (1,1,1,NULL,'mcp-app'),(2,2,1,NULL,'mcp-app');
/*!40000 ALTER TABLE `sys_admin_role_relation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-04 20:44:10
