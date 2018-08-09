-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_riesgos
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `para_dominio`
--

DROP TABLE IF EXISTS `para_dominio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `para_dominio` (
  `DOMI_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DOMI_NOMBRE` varchar(45) DEFAULT NULL,
  `DOMI_TIPO` varchar(45) DEFAULT NULL COMMENT 'Ese tipo establece el alcance del nominio (SISTEMA, CONFIGURACION Y MODULOS)',
  `DOMI_DESCRIPCION` varchar(45) DEFAULT NULL,
  `DOMI_ESTADO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DOMI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `para_dominio`
--

LOCK TABLES `para_dominio` WRITE;
/*!40000 ALTER TABLE `para_dominio` DISABLE KEYS */;
/*!40000 ALTER TABLE `para_dominio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `para_dominio_valor`
--

DROP TABLE IF EXISTS `para_dominio_valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `para_dominio_valor` (
  `DOVA_ID` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `DOMI_ID` bigint(20) NOT NULL,
  `DOVA_VALOR` varchar(45) DEFAULT NULL,
  `DOVA_DESCRIPCION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DOVA_ID`),
  KEY `fk_PARA_DOMINIO_VALOR_PARA_DOMINIO1_idx` (`DOMI_ID`),
  CONSTRAINT `fk_PARA_DOMINIO_VALOR_PARA_DOMINIO1` FOREIGN KEY (`DOMI_ID`) REFERENCES `para_dominio` (`DOMI_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `para_dominio_valor`
--

LOCK TABLES `para_dominio_valor` WRITE;
/*!40000 ALTER TABLE `para_dominio_valor` DISABLE KEYS */;
/*!40000 ALTER TABLE `para_dominio_valor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segu_item`
--

DROP TABLE IF EXISTS `segu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segu_item` (
  `ITEM_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ITEM_NOMBRE` varchar(45) DEFAULT NULL,
  `ITEM_DESCRICPION` varchar(45) DEFAULT NULL,
  `ITEM_ESTADO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segu_item`
--

LOCK TABLES `segu_item` WRITE;
/*!40000 ALTER TABLE `segu_item` DISABLE KEYS */;
INSERT INTO `segu_item` VALUES (1,'MENU 1','DESCRIPCION MENU 1','A'),(2,'MENU 2','DESCRIPCION MENU 2 ','A'),(3,'MENU 3 ','DESCRIPCION MENU 3','A'),(4,'MENU 4','DESCRIPCION MENU 4','A');
/*!40000 ALTER TABLE `segu_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segu_menu_item`
--

DROP TABLE IF EXISTS `segu_menu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segu_menu_item` (
  `MEIT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ITEM_ID` bigint(20) NOT NULL,
  `ROL_ID` bigint(20) NOT NULL,
  `MEIT_ESTADO` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`MEIT_ID`),
  KEY `fk_SEGU_MENU_ITEM_SEGU_ITEM1_idx` (`ITEM_ID`),
  KEY `fk_SEGU_MENU_ITEM_SEGU_ROL1_idx` (`ROL_ID`),
  CONSTRAINT `fk_SEGU_MENU_ITEM_SEGU_ITEM1` FOREIGN KEY (`ITEM_ID`) REFERENCES `segu_item` (`ITEM_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SEGU_MENU_ITEM_SEGU_ROL1` FOREIGN KEY (`ROL_ID`) REFERENCES `segu_rol` (`ROL_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segu_menu_item`
--

LOCK TABLES `segu_menu_item` WRITE;
/*!40000 ALTER TABLE `segu_menu_item` DISABLE KEYS */;
INSERT INTO `segu_menu_item` VALUES (1,1,1,'A'),(2,2,1,'A'),(3,3,2,'A'),(4,4,2,'A'),(5,2,2,'A');
/*!40000 ALTER TABLE `segu_menu_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segu_rol`
--

DROP TABLE IF EXISTS `segu_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segu_rol` (
  `ROL_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROL_NOMBRE` varchar(45) DEFAULT NULL,
  `ROL_DESCRIPCION` varchar(45) DEFAULT NULL,
  `ROL_ESTADO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ROL_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segu_rol`
--

LOCK TABLES `segu_rol` WRITE;
/*!40000 ALTER TABLE `segu_rol` DISABLE KEYS */;
INSERT INTO `segu_rol` VALUES (1,'ROLE_USER','ROLE_USER','A'),(2,'ROLE_ADMIN','ROLE_ADMIN','A');
/*!40000 ALTER TABLE `segu_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segu_usuario`
--

DROP TABLE IF EXISTS `segu_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segu_usuario` (
  `USUA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USUA_NOMBREUSUARIO` varchar(100) NOT NULL,
  `USUA_CLAVE` varchar(100) NOT NULL,
  `USUA_ESTADO` varchar(1) NOT NULL,
  `USUA_EMAIL` varchar(45) NOT NULL,
  `PERS_ID` bigint(20) DEFAULT NULL,
  `USUA_ALIAS` varchar(45) DEFAULT NULL,
  `USUARIO_CREACION` varchar(100) NOT NULL,
  `FECHA_CREACION` datetime NOT NULL,
  `USUARIO_MODIFICACION` varchar(100) DEFAULT NULL,
  `FECHA_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`USUA_ID`),
  UNIQUE KEY `USUA_NOMBREUSUARIO_UNIQUE` (`USUA_NOMBREUSUARIO`),
  UNIQUE KEY `USUA_EMAIL_UNIQUE` (`USUA_EMAIL`),
  KEY `fk_segu_usuario_segu_persona_idx` (`PERS_ID`),
  CONSTRAINT `fk_segu_usuario_segu_persona` FOREIGN KEY (`PERS_ID`) REFERENCES `segu_persona` (`PERS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segu_usuario`
--

LOCK TABLES `segu_usuario` WRITE;
/*!40000 ALTER TABLE `segu_usuario` DISABLE KEYS */;
INSERT INTO `segu_usuario` VALUES (1,'JROJAS','$2a$10$g3mfvUzsdIXxDgA2rlO1D.83lAXdh4NKJppnk9raeBAK6eIpVfDLm','A','julianrojasingMod@gmail.com',NULL,'JROJAS','ADMIN','2018-08-04 00:00:00',NULL,NULL),(2,'DRINCON','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS','A','DRINCON@GMAIL.COM',NULL,'JROJAS','ADMIN','2018-08-04 00:00:00',NULL,NULL),(3,'ADMIN','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS','A','ADMIN@GMAIL.COM',NULL,'ADMIN','ADMIN','2018-08-04 00:00:00',NULL,NULL),(4,'prueba','12345','A','prueba@gmail.com',NULL,'prueba','ADMIN','2018-08-06 10:32:22',NULL,NULL),(9,'yuca2','$2a$10$GB5bJ2qSX7/YUnMlRNRI9OroLDPMw5ozqqBWW3VutkRLTIi8wEDly','A','yuca2@gmail.com',NULL,'yuca2','ADMIN','2018-08-06 12:25:20',NULL,NULL),(10,'yuca3','$2a$10$LXPgS8X3NRMhhADuxBQuzO.pTnMi3uEES5Ak91TPsGRSa86tIgp66','A','yuca3@gmail.com',NULL,'yuca3','ADMIN','2018-08-06 12:32:21',NULL,NULL),(11,'yuca4','$2a$10$LTv','A','yuca4@gmail.com',NULL,'yuca4','ADMIN','2018-08-06 12:42:34',NULL,NULL),(12,'yuca5','$2a$10$g3mfvUzsdIXxDgA2rlO1D.83lAXdh4NKJppnk9raeBAK6eIpVfDLm','A','yuca5@gmail.com',NULL,'yuca5','ADMIN','2018-08-06 12:44:29',NULL,NULL);
/*!40000 ALTER TABLE `segu_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segu_usuario_rol`
--

DROP TABLE IF EXISTS `segu_usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segu_usuario_rol` (
  `USRO_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USUA_ID` bigint(20) NOT NULL,
  `ROL_ID` bigint(20) NOT NULL,
  `USRO_ESTADO` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`USRO_ID`),
  KEY `fk_SEGU_USUARIO_ROL_segu_usuario1_idx` (`USUA_ID`),
  KEY `fk_SEGU_USUARIO_ROL_SEGU_ROL1_idx` (`ROL_ID`),
  CONSTRAINT `fk_SEGU_USUARIO_ROL_SEGU_ROL1` FOREIGN KEY (`ROL_ID`) REFERENCES `segu_rol` (`ROL_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SEGU_USUARIO_ROL_segu_usuario1` FOREIGN KEY (`USUA_ID`) REFERENCES `segu_usuario` (`USUA_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segu_usuario_rol`
--

LOCK TABLES `segu_usuario_rol` WRITE;
/*!40000 ALTER TABLE `segu_usuario_rol` DISABLE KEYS */;
INSERT INTO `segu_usuario_rol` VALUES (1,1,1,'A'),(2,2,1,'A'),(3,3,1,'A'),(4,3,2,'A'),(5,1,2,'A'),(6,12,1,'A');
/*!40000 ALTER TABLE `segu_usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_riesgos'
--

--
-- Dumping routines for database 'db_riesgos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-07  7:26:58
