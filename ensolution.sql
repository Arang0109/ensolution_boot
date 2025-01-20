CREATE DATABASE  IF NOT EXISTS `ensolution` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ensolution`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ensolution
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `ceo_name` varchar(50) DEFAULT NULL,
  `biz_number` char(12) NOT NULL,
  `reg_date` date DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `biz_number_UNIQUE` (`biz_number`),
  UNIQUE KEY `company_name_UNIQUE` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COMMENT='- Stores essential details of companies for measurement service management.\n- Stores client company details: ID, name, address, CEO, business number, and registration date.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (2,'현대자동차(주) 울산공장','울산 북구 염포로 700 (양정동)','장재훈','620-86-00010','2024-10-29'),(3,'(주) 넥센','경남 김해시 김해대로 2595 (안동)','강호찬','618-81-15827','2024-10-29'),(4,'에이치디현대미포 주식회사','울산 동구 방어진순환도로 100 (방어동)','신현대','620-81-00900','2024-10-29'),(5,'에이치디현대중공업','울산 동구 방어진순환도로 140 (방어동)','한영석, 이상균','252-87-01412','2024-10-29'),(6,'삼양소재화학(주)','경남 양산시 유산동 462-1','최영재','621-81-54525','2024-10-29'),(7,'(주) 동헌레미콘','부산 강서구 명동길 47 (지사동) 2층','박병철','887-88-01549','2024-10-29'),(53,'다모야','부산진구 동평로 291번길 30 (103-403)','유수진','325-17-01564','2024-11-21'),(54,'에쓰-오일 주식회사','서울 마포구 백범로 192 (공덕동)','안와르 에이알 히즈아지','116-81-36743','2024-12-03');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factory`
--

DROP TABLE IF EXISTS `factory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factory` (
  `factory_id` int NOT NULL AUTO_INCREMENT,
  `workplace_id` int DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`factory_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_factory_workplace_id_idx` (`workplace_id`),
  CONSTRAINT `fk_factory_workplace_id` FOREIGN KEY (`workplace_id`) REFERENCES `workplace` (`workplace_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factory`
--

LOCK TABLES `factory` WRITE;
/*!40000 ALTER TABLE `factory` DISABLE KEYS */;
INSERT INTO `factory` VALUES (1,10,'3공장'),(2,10,'4공장'),(3,10,'소재공장');
/*!40000 ALTER TABLE `factory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `management_department`
--

DROP TABLE IF EXISTS `management_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `management_department` (
  `management_department_id` int NOT NULL AUTO_INCREMENT,
  `workplace_id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `tel` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`management_department_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_md_workplace_id_idx` (`workplace_id`),
  CONSTRAINT `fk_md_workplace_id` FOREIGN KEY (`workplace_id`) REFERENCES `workplace` (`workplace_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `management_department`
--

LOCK TABLES `management_department` WRITE;
/*!40000 ALTER TABLE `management_department` DISABLE KEYS */;
INSERT INTO `management_department` VALUES (9,10,'도장 3부',NULL),(10,10,'의장 32부',NULL),(11,10,'도장 4부',NULL),(12,10,'의장 31부',NULL),(13,10,'도장 31부',NULL),(14,10,'도장 32부',NULL),(15,10,'소재설비관리부',NULL),(16,10,'의장 42부',NULL),(17,10,'의장 41부',NULL),(19,10,'생산관리 4부',NULL);
/*!40000 ALTER TABLE `management_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pollutant`
--

DROP TABLE IF EXISTS `pollutant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pollutant` (
  `pollutant_id` int NOT NULL AUTO_INCREMENT,
  `pollutant_name` varchar(50) NOT NULL,
  `pollutant_name_en` varchar(50) DEFAULT NULL,
  `method` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pollutant_id`),
  UNIQUE KEY `pollutant_name_UNIQUE` (`pollutant_name`),
  UNIQUE KEY `pollutant_name_en_UNIQUE` (`pollutant_name_en`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pollutant`
--

LOCK TABLES `pollutant` WRITE;
/*!40000 ALTER TABLE `pollutant` DISABLE KEYS */;
INSERT INTO `pollutant` VALUES (17,'먼지','Dust','먼지'),(18,'질소산화물','NOx','현장측정'),(19,'황산화물','SOx','현장측정'),(20,'일산화탄소','CO','현장측정'),(21,'총탄화수소','THC','현장측정'),(22,'이산화탄소','CO2','현장측정'),(23,'염화수소','HCL','흡수액'),(24,'플루오린화합물','HF','흡수액'),(25,'페놀화합물','C6H5OH','흡수액'),(26,'브로민화합물','Br','흡수액'),(27,'황화수소','H2S','흡수액'),(28,'시안화수소','HCN','흡수액'),(29,'이황화탄소','CS2','흡수액'),(30,'암모니아','NH3','흡수액'),(31,'비소화합물','As','비소'),(32,'납','Pb','중금속'),(33,'카드뮴','Cd','중금속'),(34,'구리','Cu','중금속'),(35,'니켈','Ni','중금속'),(36,'아연','Zn','중금속'),(37,'망간','Mn','중금속'),(38,'철','Fe','중금속'),(39,'알루미늄','Al','중금속'),(40,'베릴륨','Be','중금속'),(41,'트리클로로에틸렌','TCE','흡착관(T)'),(42,'에틸벤젠','EB','흡착관(T)'),(43,'벤젠','B','흡착관(T)'),(44,'스타이렌','SM','흡착관(T)'),(45,'클로로폼','CF','흡착관(T)'),(46,'아크릴로나이트릴','An','흡착관(T)'),(47,'1.2-다이클로로에테인','1.2-DCM','흡착관(T)'),(48,'다이클로로메테인','DCM','흡착관(T)'),(49,'테트라클로로에틸렌','PCE','흡착관(T)'),(50,'톨루엔',NULL,'흡착관(T)'),(51,'자일렌',NULL,'흡착관(T)'),(52,'사염화탄소',NULL,'흡착관(A)'),(53,'1.3-뷰타다이엔',NULL,'흡착관(A)'),(54,'염화바이닐',NULL,'흡착관(A)'),(55,'아세트알데하이드','CH3CHO','카트리지'),(56,'폼알데하이드','HCHO','카트리지'),(57,'아크롤레인',NULL,'카트리지'),(58,'그 외 알데하이드류',NULL,'카트리지'),(59,'수은','Hg','수은'),(60,'크롬','Cr','중금속'),(61,'이황화메틸','DSMC','테드라백'),(62,'주석','Sn','중금속');
/*!40000 ALTER TABLE `pollutant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `team_id` int NOT NULL,
  `stack_measurement_id` int NOT NULL,
  `measure_date` date DEFAULT NULL,
  `is_completed` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`schedule_id`),
  KEY `fk_stack_measurement_id_idx` (`stack_measurement_id`),
  KEY `fk_team_id_idx` (`team_id`),
  CONSTRAINT `fk_stack_measurement_id` FOREIGN KEY (`stack_measurement_id`) REFERENCES `stack_measurement` (`stack_measurement_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_team_id` FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=261 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (245,2,435,'2024-12-11',1),(246,2,440,'2024-12-11',1),(255,2,435,'2024-11-11',1),(256,2,440,'2024-11-11',1),(257,2,435,'2024-10-16',1),(258,3,440,'2024-10-16',1),(259,2,436,'2024-12-27',1),(260,2,441,'2024-12-27',1);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stack`
--

DROP TABLE IF EXISTS `stack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stack` (
  `stack_id` int NOT NULL AUTO_INCREMENT,
  `workplace_id` int NOT NULL,
  `stack_name` varchar(50) NOT NULL,
  `prevention` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `note` longtext,
  `sub_factory_id` int DEFAULT NULL,
  `management_department_id` int DEFAULT NULL,
  PRIMARY KEY (`stack_id`),
  KEY `fk_stack_workplace_id_idx` (`workplace_id`),
  KEY `fk_stack_md_id_idx` (`management_department_id`),
  KEY `fk_stack_sub_factory_id_idx` (`sub_factory_id`),
  CONSTRAINT `fk_stack_md_id` FOREIGN KEY (`management_department_id`) REFERENCES `management_department` (`management_department_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stack_sub_factory_id` FOREIGN KEY (`sub_factory_id`) REFERENCES `sub_factory` (`sub_factory_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stack_workplace_id` FOREIGN KEY (`workplace_id`) REFERENCES `workplace` (`workplace_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=465 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stack`
--

LOCK TABLES `stack` WRITE;
/*!40000 ALTER TABLE `stack` DISABLE KEYS */;
INSERT INTO `stack` VALUES (5,2,'계량시설 1m3',NULL,'2024-11-20','12월 13일 전까지 측정해야함',NULL,NULL),(6,2,'계량시설 2m3',NULL,'2024-11-20',NULL,NULL,NULL),(7,2,'저장시설 500m3 #1',NULL,'2024-11-20',NULL,NULL,NULL),(8,2,'저장시설 500m3 #2',NULL,'2024-11-20',NULL,NULL,NULL),(9,2,'저장시설 500m3, 혼합시설 3m3 #3',NULL,'2024-11-20',NULL,NULL,NULL),(10,2,'저장시설 500m3, 혼합시설 3m3 #4',NULL,'2024-11-20',NULL,NULL,NULL),(11,3,'가황시설1-몰딩',NULL,'2024-11-20',NULL,NULL,NULL),(12,3,'가황시설2-압출',NULL,'2024-11-20',NULL,NULL,NULL),(33,9,'1ton 보일러(49-1)',NULL,'2024-11-20',NULL,NULL,NULL),(34,9,'3ton 보일러(50-1)',NULL,'2024-11-20',NULL,NULL,NULL),(35,9,'3ton 보일러(51-1)',NULL,'2024-11-20',NULL,NULL,NULL),(36,9,'6ton, 8ton 보일러(52-1, 53-1)',NULL,'2024-11-20',NULL,NULL,NULL),(37,9,'가황시설(33)',NULL,'2024-11-20',NULL,NULL,NULL),(38,9,'가황시설(35)',NULL,'2024-11-20',NULL,NULL,NULL),(39,9,'가황시설(36)',NULL,'2024-11-20',NULL,NULL,NULL),(40,9,'가황시설(42)',NULL,'2024-11-20',NULL,NULL,NULL),(41,9,'가황시설(43)',NULL,'2024-11-20',NULL,NULL,NULL),(42,9,'가황시설(48)',NULL,'2024-11-20',NULL,NULL,NULL),(43,9,'가황시설(프레스성형)(58)',NULL,'2024-11-20',NULL,NULL,NULL),(44,9,'건조+도장시설(47)',NULL,'2024-11-20',NULL,NULL,NULL),(45,9,'건조+접착시설(41)',NULL,'2024-11-20',NULL,NULL,NULL),(46,9,'건조시설(2-1)',NULL,'2024-11-20',NULL,NULL,NULL),(47,9,'건조시설(2-2)',NULL,'2024-11-20',NULL,NULL,NULL),(48,9,'건조시설(29)',NULL,'2024-11-20',NULL,NULL,NULL),(49,9,'도장시설(34)',NULL,'2024-11-20',NULL,NULL,NULL),(50,9,'도장시설(55)',NULL,'2024-11-20',NULL,NULL,NULL),(51,9,'도장시설(56)',NULL,'2024-11-20',NULL,NULL,NULL),(52,9,'도포시설(54)',NULL,'2024-11-20',NULL,NULL,NULL),(53,9,'성형시설(32)',NULL,'2024-11-20',NULL,NULL,NULL),(54,9,'성형시설(46)',NULL,'2024-11-20',NULL,NULL,NULL),(55,9,'탈사시설(30)',NULL,'2024-11-20',NULL,NULL,NULL),(56,9,'혼합+성형시설(57)',NULL,'2024-11-20',NULL,NULL,NULL),(57,9,'혼합시설(10)',NULL,'2024-11-20',NULL,NULL,NULL),(58,9,'혼합시설(11-1)',NULL,'2024-11-20',NULL,NULL,NULL),(59,9,'혼합시설(11-2)',NULL,'2024-11-20',NULL,NULL,NULL),(60,9,'혼합시설(11-3)',NULL,'2024-11-20',NULL,NULL,NULL),(61,9,'혼합시설(16)',NULL,'2024-11-20',NULL,NULL,NULL),(62,9,'혼합시설(17)',NULL,'2024-11-20',NULL,NULL,NULL),(63,9,'혼합시설(18)',NULL,'2024-11-20',NULL,NULL,NULL),(64,9,'혼합시설(28)',NULL,'2024-11-20',NULL,NULL,NULL),(65,9,'혼합시설(31)',NULL,'2024-11-20',NULL,NULL,NULL),(66,4,'소각시설 2호기 촉매반응을 이용한 시설 후단',NULL,'2024-11-20',NULL,NULL,NULL),(67,4,'소각시설 2호기 흡수에 의한 시설',NULL,'2024-11-20',NULL,NULL,NULL),(68,4,'소각시설 2호기 흡수에 의한 시설 전단',NULL,'2024-11-20',NULL,NULL,NULL),(69,4,'소각시설 2호기 흡수에 의한 시설 후단',NULL,'2024-11-20',NULL,NULL,NULL),(70,4,'소각로 1호기 전기집진시설',NULL,'2024-11-20',NULL,NULL,NULL),(71,4,'소각로 1호기 흡수에 의한 시설',NULL,'2024-11-20',NULL,NULL,NULL),(72,4,'소각시설 1호기',NULL,'2024-11-20',NULL,NULL,NULL),(73,4,'소각시설 1호기 전기집진시설 전단',NULL,'2024-11-20',NULL,NULL,NULL),(74,4,'소각시설 1호기 전기집진시설 후단',NULL,'2024-11-20',NULL,NULL,NULL),(75,4,'소각시설 1호기 촉매반응을 이용한 시설',NULL,'2024-11-20',NULL,NULL,NULL),(76,4,'소각시설 1호기 촉매반응을 이용한 시설 전단',NULL,'2024-11-20',NULL,NULL,NULL),(77,4,'소각시설 1호기 촉매반응을 이용한 시설 후단',NULL,'2024-11-20',NULL,NULL,NULL),(78,4,'소각시설 1호기 흡수에 의한 시설 전단',NULL,'2024-11-20',NULL,NULL,NULL),(79,4,'소각시설 1호기 흡수에 의한 시설 후단',NULL,'2024-11-20',NULL,NULL,NULL),(80,4,'소각시설 2호기',NULL,'2024-11-20',NULL,NULL,NULL),(81,4,'소각시설 2호기 전기집진시설',NULL,'2024-11-20',NULL,NULL,NULL),(82,4,'소각시설 2호기 전기집진시설 전단',NULL,'2024-11-20',NULL,NULL,NULL),(83,4,'소각시설 2호기 전기집진시설 후단',NULL,'2024-11-20',NULL,NULL,NULL),(84,4,'소각시설 2호기 촉매반응을 이용한 시설',NULL,'2024-11-20',NULL,NULL,NULL),(85,4,'소각시설 2호기 촉매반응을 이용한 시설 전단',NULL,'2024-11-20',NULL,NULL,NULL),(86,5,'1현사 보일러',NULL,'2024-11-20',NULL,NULL,NULL),(87,5,'1현사 식당 보일러 시설',NULL,'2024-11-20',NULL,NULL,NULL),(88,5,'2현사 보일러 시설',NULL,'2024-11-20',NULL,NULL,NULL),(89,5,'3현사 보일러 시설',NULL,'2024-11-20',NULL,NULL,NULL),(90,5,'5현사 보일러 시설1',NULL,'2024-11-20',NULL,NULL,NULL),(91,5,'5현사 보일러 시설2',NULL,'2024-11-20',NULL,NULL,NULL),(92,5,'6현사 보일러 시설1',NULL,'2024-11-20',NULL,NULL,NULL),(93,5,'6현사 보일러 시설2',NULL,'2024-11-20',NULL,NULL,NULL),(94,5,'9현사 보일러',NULL,'2024-11-20',NULL,NULL,NULL),(95,5,'B1,2 탈청시설(4100)',NULL,'2024-11-20',NULL,NULL,NULL),(96,5,'B1 선별시설',NULL,'2024-11-20',NULL,NULL,NULL),(97,5,'B1 탈청시설(1100)',NULL,'2024-11-20',NULL,NULL,NULL),(98,5,'B2 선별시설',NULL,'2024-11-20',NULL,NULL,NULL),(99,5,'B2 탈청시설',NULL,'2024-11-20',NULL,NULL,NULL),(100,5,'B3 선별시설',NULL,'2024-11-20',NULL,NULL,NULL),(101,5,'B3 탈청시설',NULL,'2024-11-20',NULL,NULL,NULL),(102,5,'B4 선별시설',NULL,'2024-11-20',NULL,NULL,NULL),(103,5,'B4 탈청시설',NULL,'2024-11-20',NULL,NULL,NULL),(104,5,'B5,6 선별시설 (재순환시설)',NULL,'2024-11-20',NULL,NULL,NULL),(105,5,'B5 탈청시설',NULL,'2024-11-20',NULL,NULL,NULL),(115,15,'#1 저장시설500t','','2024-11-20',NULL,NULL,NULL),(116,15,'#2 혼합시설3.5㎥(1)','','2024-11-20',NULL,NULL,NULL),(117,15,'#3 혼합시설3.5㎥(2)','','2024-11-20',NULL,NULL,NULL),(140,31,'SG-7941A/B','촉매반응을 이용한 시설','2024-12-03',NULL,NULL,NULL),(141,31,'SG-43401A/B','촉매반응을 이용한 시설','2024-12-03',NULL,NULL,NULL),(142,31,'X-104401','촉매반응을 이용한 시설','2024-12-03',NULL,NULL,NULL),(143,31,'ST-6601','연소조절에 의한 시설','2024-12-03','노란색 굴뚝 수직 40M 사다리',NULL,NULL),(144,31,'H-11101','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(145,31,'H-11301','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(146,31,'H-11302','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(147,31,'H-16101','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(148,31,'H-16301/2','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(149,31,'H-16601','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(150,31,'H-30201/2/3/4','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(151,31,'H-30621','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(152,31,'H-30601','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(153,31,'H-30602','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(154,31,'H-30301/2','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(155,31,'H-50101/2','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(156,31,'H1-101101','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(157,31,'H-101102','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(158,31,'H2-101101','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(159,31,'H-30401','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(160,31,'H-31102','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(161,31,'H-31301','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(162,31,'H-20101/01/A/02','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(163,31,'H-21102','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(165,31,'H-51102','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(166,31,'H-7101/7102/7205','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(167,31,'H-7201/2/3/4','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(168,31,'H-7501/2','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(169,31,'H-41101','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(170,31,'H-47101','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(171,31,'H-47102/3','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(172,31,'H-47201/2/3/4','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(173,31,'H-47205','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(174,31,'H-40001A/B, 40501','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(175,31,'H-40101','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(176,31,'H-40201','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(177,31,'H-40301A/B','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(178,31,'H-48201','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(179,31,'H-48202','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(180,31,'H-48301','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(181,31,'H-48501','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(182,31,'H-43001','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(183,31,'H-1813','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(184,31,'H-1814','방지시설 설치 면제','2024-12-03',NULL,NULL,NULL),(185,31,'H-2302','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(186,31,'H-2301/2601','연소조절에 의한 시설','2024-12-03',NULL,NULL,NULL),(187,31,'H-102801','','2024-12-03',NULL,NULL,NULL),(188,31,'SG-20501','','2024-12-03',NULL,NULL,NULL),(189,31,'R-101205 (STK-101501)','','2024-12-03',NULL,NULL,NULL),(190,31,'L-16955','촉매반응을 이용한 시설','2024-12-03',NULL,NULL,NULL),(191,31,'R-51902','직접연소에 의한 시설','2024-12-03',NULL,NULL,NULL),(192,31,'R-31902','직접연소에 의한 시설','2024-12-03',NULL,NULL,NULL),(193,31,'R-21902','직접연소에 의한 시설','2024-12-03',NULL,NULL,NULL),(194,31,'D-205951/205961 (STK-205901)','','2024-12-03',NULL,NULL,NULL),(309,30,'#1','','2024-12-11',NULL,NULL,NULL),(310,30,'#2','','2024-12-11',NULL,NULL,NULL),(311,30,'#3','','2024-12-11',NULL,NULL,NULL),(315,10,'stack 170','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(316,10,'stack 171','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(318,10,'stack 172','세정집진시설','2024-12-14','stack 172, 173\n - 위치 : 3공장 3층 외부 커다란 벽돌 굴뚝\n - 굴뚝 내부 지름 겁나 큼',16,9),(319,10,'stack 173','세정집진시설','2024-12-14','stack 172, 173\n - 위치 : 3공장 3층 외부 커다란 벽돌 굴뚝\n - 굴뚝 내부 지름 겁나 큼',16,9),(320,10,'stack 175','흡착에 의한 시설','2024-12-14',NULL,16,9),(321,10,'stack 183','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(322,10,'stack 184','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(323,10,'stack 208','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(324,10,'stack 216','세정집진시설','2024-12-14',NULL,18,11),(325,10,'stack 217','세정집진시설','2024-12-14',NULL,18,11),(326,10,'stack 218','흡착에 의한 시설','2024-12-14',NULL,18,11),(327,10,'stack 219','세정집진시설','2024-12-14',NULL,18,11),(328,10,'stack 237','여과집진시설','2024-12-14',NULL,18,11),(329,10,'stack 238','여과집진시설','2024-12-14',NULL,18,11),(330,10,'stack 240','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(331,10,'stack 241','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(332,10,'stack 242','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(333,10,'stack 243','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(334,10,'stack 244','세정집진시설','2024-12-14',NULL,18,11),(335,10,'stack 245','세정집진시설','2024-12-14',NULL,18,11),(336,10,'stack 246','세정집진시설','2024-12-14',NULL,18,11),(337,10,'stack 247','세정집진시설','2024-12-14',NULL,18,11),(338,10,'stack 248','세정집진시설','2024-12-14',NULL,18,11),(339,10,'stack 249','세정집진시설','2024-12-14',NULL,18,11),(340,10,'stack 250','세정집진시설','2024-12-14',NULL,18,11),(341,10,'stack 251','세정집진시설','2024-12-14',NULL,18,11),(342,10,'stack 264','흡착에 의한 시설','2024-12-14',NULL,18,11),(343,10,'stack 281','흡수에 의한 시설','2024-12-14',NULL,20,11),(344,10,'stack 282','흡수에 의한 시설','2024-12-14',NULL,20,11),(345,10,'stack 283','흡수에 의한 시설','2024-12-14',NULL,20,11),(346,10,'stack 284','방지시설 설치의무 면제','2024-12-14',NULL,20,11),(347,10,'stack 290','세정집진시설','2024-12-14',NULL,20,11),(348,10,'stack 291','세정집진시설','2024-12-14',NULL,20,11),(349,10,'stack 292','세정집진시설','2024-12-14',NULL,20,11),(350,10,'stack 293','세정집진시설','2024-12-14',NULL,20,11),(351,10,'stack 294','세정집진시설','2024-12-14',NULL,20,11),(352,10,'stack 295','세정집진시설','2024-12-14',NULL,20,11),(353,10,'stack 296','세정집진시설','2024-12-14',NULL,20,11),(354,10,'stack 297','세정집진시설','2024-12-14',NULL,20,11),(355,10,'stack 298','세정집진시설','2024-12-14',NULL,20,11),(356,10,'stack 304','여과집진시설','2024-12-14',NULL,20,11),(357,10,'stack 305','여과집진시설','2024-12-14',NULL,20,11),(358,10,'stack 525','세정집진시설','2024-12-14',NULL,29,15),(359,10,'stack 526','세정집진시설','2024-12-14',NULL,29,15),(360,10,'stack 527','세정집진시설','2024-12-14',NULL,29,15),(361,10,'stack 528','세정집진시설','2024-12-14',NULL,29,15),(362,10,'stack 530','여과집진시설','2024-12-14',NULL,29,15),(363,10,'stack 571','세정집진시설','2024-12-14',NULL,29,15),(364,10,'stack 572','세정집진시설','2024-12-14',NULL,27,15),(365,10,'stack 573','세정집진시설','2024-12-14',NULL,27,15),(366,10,'stack 615','세정집진시설','2024-12-14',NULL,30,15),(367,10,'stack 616','세정집진시설','2024-12-14',NULL,30,15),(368,10,'stack 617','세정집진시설','2024-12-14',NULL,30,15),(369,10,'stack 620','세정집진시설','2024-12-14',NULL,28,15),(370,10,'stack 1212','직접연소에 의한 시설','2024-12-14',NULL,18,11),(371,10,'stack 1219','세정집진시설','2024-12-14',NULL,16,9),(372,10,'stack 1256','세정집진시설','2024-12-14',NULL,25,15),(373,10,'stack 1285','여과집진시설','2024-12-14',NULL,29,15),(374,10,'stack 1288','세정집진시설','2024-12-14',NULL,29,15),(375,10,'stack 1289','세정집진시설','2024-12-14',NULL,30,15),(376,10,'stack 1302','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(377,10,'stack 1303','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(378,10,'stack 1304','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(379,10,'stack 1305','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(380,10,'stack 1306','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(381,10,'stack 1311','방지시설 설치의무 면제','2024-12-14',NULL,21,16),(382,10,'stack 1312','방지시설 설치의무 면제','2024-12-14',NULL,21,16),(383,10,'stack 1313','방지시설 설치의무 면제','2024-12-14',NULL,21,16),(384,10,'stack 1321','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(385,10,'stack 1322','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(387,10,'stack 1328','방지시설 설치의무 면제','2024-12-14',NULL,21,16),(388,10,'stack 1359','세정집진시설','2024-12-14',NULL,29,15),(389,10,'stack 1362','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(390,10,'stack 1363','세정집진시설','2024-12-14',NULL,26,15),(391,10,'stack 1395','직접연소에 의한 시설','2024-12-14',NULL,16,9),(392,10,'stack 1397','세정집진시설','2024-12-14',NULL,29,15),(393,10,'stack 1398','세정집진시설','2024-12-14',NULL,29,15),(394,10,'stack 1404','여과집진시설','2024-12-14',NULL,24,15),(395,10,'stack 1420','여과집진시설','2024-12-14',NULL,29,15),(396,10,'stack 1477','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(397,10,'stack 1485','여과집진시설','2024-12-14',NULL,29,15),(398,10,'stack 1486','여과집진시설','2024-12-14',NULL,29,15),(399,10,'stack 1570','방지시설 설치의무 면제','2024-12-14','위치 : 3공장 3층 외부',16,9),(400,10,'stack 1571','방지시설 설치의무 면제','2024-12-14','위치 : 3공장 1층 외부\n사각형 삿갓 모양 지붕 밑에 측정공 있음',16,9),(401,10,'stack 1575','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(402,10,'stack 1576','방지시설 설치의무 면제','2024-12-14',NULL,18,11),(403,10,'stack 1579','방지시설 설치의무 면제','2024-12-14',NULL,20,11),(404,10,'stack 1704','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(405,10,'stack 1745','방지시설 설치의무 면제','2024-12-14','위치 : 3공장 3층 내부\n미가동일 가능성이 높음! 담당자 연락 미리 취하는게 좋음',16,9),(406,10,'stack 1746','흡착에 의한 시설','2024-12-14',NULL,19,17),(407,10,'stack 1785','세정집진시설','2024-12-14',NULL,18,11),(408,10,'stack 1786','세정집진시설','2024-12-14',NULL,18,11),(409,10,'stack 1787','세정집진시설','2024-12-14',NULL,18,11),(410,10,'stack 1788','세정집진시설','2024-12-14',NULL,18,11),(411,10,'stack 1789','세정집진시설','2024-12-14',NULL,18,11),(412,10,'stack 1790','세정집진시설','2024-12-14',NULL,18,11),(413,10,'stack 1791','세정집진시설','2024-12-14',NULL,18,11),(414,10,'stack 1792','세정집진시설','2024-12-14',NULL,18,11),(415,10,'stack 1793','세정집진시설','2024-12-14',NULL,18,11),(416,10,'stack 1794','세정집진시설','2024-12-14',NULL,18,11),(417,10,'stack 1847','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(418,10,'stack 1848','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(419,10,'stack 1901','여과집진시설','2024-12-14',NULL,30,15),(420,10,'stack 1920','흡착에 의한 시설','2024-12-14',NULL,16,9),(421,10,'stack 1939','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(422,10,'stack 1940','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(423,10,'stack 1943','여과집진시설','2024-12-14',NULL,25,15),(424,10,'stack 1944','여과집진시설','2024-12-14',NULL,26,15),(425,10,'stack 1966','방지시설 설치의무 면제','2024-12-14',NULL,30,15),(426,10,'stack 1967','방지시설 설치의무 면제','2024-12-14',NULL,30,15),(427,10,'stack 2047','연소조절에 의한 시설','2024-12-14',NULL,30,15),(428,10,'stack 2048','연소조절에 의한 시설','2024-12-14',NULL,30,15),(429,10,'stack 2049','연소조절에 의한 시설','2024-12-14',NULL,30,15),(430,10,'stack 2063','연소조절에 의한 시설','2024-12-14',NULL,26,15),(431,10,'stack 2144','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(432,10,'stack 2151','직접연소에 의한 시설','2024-12-14',NULL,20,11),(433,10,'stack 2154','여과집진시설','2024-12-14',NULL,27,15),(434,10,'stack 2160','연소조절에 의한 시설','2024-12-14','위치 : 3공장 1층 내부 들어가서 오른쪽으로 조금 가다 보면 문 있음 열고 들어가면 됨',17,12),(435,10,'stack 2161','흡착에 의한 시설','2024-12-14',NULL,16,9),(436,10,'stack 2163','세정집진시설','2024-12-14',NULL,30,15),(437,10,'stack 2186','연소조절에 의한 시설','2024-12-14',NULL,22,19),(438,10,'stack 2187','연소조절에 의한 시설','2024-12-14',NULL,23,19),(439,10,'stack 2309','방지시설 설치의무 면제','2024-12-14',NULL,17,10),(440,10,'stack 2315','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(441,10,'stack 2316','방지시설 설치의무 면제','2024-12-14',NULL,19,17),(442,10,'stack 2317','방지시설 설치의무 면제','2024-12-14',NULL,21,16),(443,10,'stack 2318','방지시설 설치의무 면제','2024-12-14',NULL,21,16),(444,10,'stack 2327','여과집진시설','2024-12-14',NULL,30,15),(445,10,'stack 2328','연소조절에 의한 시설','2024-12-14',NULL,30,15),(446,10,'stack 2329','연소조절에 의한 시설','2024-12-14',NULL,30,15),(447,10,'stack 2330','연소조절에 의한 시설','2024-12-14',NULL,30,15),(448,10,'stack 2337','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(449,10,'stack 2342','여과집진시설','2024-12-14',NULL,28,15),(450,10,'stack 2343','여과집진시설','2024-12-14',NULL,29,15),(451,10,'stack 2344','여과집진시설','2024-12-14',NULL,29,15),(452,10,'stack 2350','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(453,10,'stack 2351','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(454,10,'stack 2352','방지시설 설치의무 면제','2024-12-14',NULL,16,9),(455,10,'stack 2353','흡착에 의한 시설','2024-12-14',NULL,16,9),(456,10,'stack 2354','흡착에 의한 시설','2024-12-14',NULL,16,9),(457,10,'stack 2355','흡착에 의한 시설','2024-12-14',NULL,21,16),(458,10,'stack 2367','방지시설 설치의무 면제','2024-12-14',NULL,20,11),(459,10,'stack 2378','방지시설 설치의무 면제','2024-12-14',NULL,30,15);
/*!40000 ALTER TABLE `stack` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_stack_insert` AFTER INSERT ON `stack` FOR EACH ROW BEGIN
    INSERT INTO stack_info (stack_info_id)
    VALUES (NEW.stack_id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `stack_images`
--

DROP TABLE IF EXISTS `stack_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stack_images` (
  `stack_images_id` int NOT NULL AUTO_INCREMENT,
  `stack_id` int NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stack_images_id`),
  KEY `fk_stack_id_idx` (`stack_id`),
  CONSTRAINT `fk_stack_id_stack_images` FOREIGN KEY (`stack_id`) REFERENCES `stack` (`stack_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stack_images`
--

LOCK TABLES `stack_images` WRITE;
/*!40000 ALTER TABLE `stack_images` DISABLE KEYS */;
INSERT INTO `stack_images` VALUES (8,318,'C:/EnSolution/uploads\\stack172.jpg','stack172.jpg'),(9,319,'C:/EnSolution/uploads\\stack173.jpg','stack173.jpg'),(10,399,'C:/EnSolution/uploads\\stack1570.jpg','stack1570.jpg'),(11,400,'C:/EnSolution/uploads\\stack1571.jpg','stack1571.jpg'),(12,405,'C:/EnSolution/uploads\\stack1745.jpg','stack1745.jpg'),(13,405,'C:/EnSolution/uploads\\stack1745-1.jpg','stack1745-1.jpg'),(14,439,'C:/EnSolution/uploads\\KakaoTalk_20241213_110704572_01.jpg','KakaoTalk_20241213_110704572_01.jpg'),(15,439,'C:/EnSolution/uploads\\KakaoTalk_20241213_110704572_02.jpg','KakaoTalk_20241213_110704572_02.jpg'),(16,434,'C:/EnSolution/uploads\\KakaoTalk_20241213_110930520_01.jpg','KakaoTalk_20241213_110930520_01.jpg'),(17,434,'C:/EnSolution/uploads\\KakaoTalk_20241213_110930520_02.jpg','KakaoTalk_20241213_110930520_02.jpg'),(18,380,'C:/EnSolution/uploads\\KakaoTalk_20241213_111307284_01.jpg','KakaoTalk_20241213_111307284_01.jpg'),(19,380,'C:/EnSolution/uploads\\KakaoTalk_20241213_111307284_02.jpg','KakaoTalk_20241213_111307284_02.jpg'),(20,323,'C:/EnSolution/uploads\\KakaoTalk_20241213_112156229.jpg','KakaoTalk_20241213_112156229.jpg');
/*!40000 ALTER TABLE `stack_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stack_info`
--

DROP TABLE IF EXISTS `stack_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stack_info` (
  `stack_info_id` int NOT NULL,
  `diameter` double DEFAULT NULL,
  `dynamic_pressure` double DEFAULT NULL,
  `static_pressure` double DEFAULT NULL,
  `velocity_speed` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `temperature` double DEFAULT NULL,
  KEY `fk_stack_info_stack_id` (`stack_info_id`),
  CONSTRAINT `fk_stack_info_stack_id` FOREIGN KEY (`stack_info_id`) REFERENCES `stack` (`stack_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stack_info`
--

LOCK TABLES `stack_info` WRITE;
/*!40000 ALTER TABLE `stack_info` DISABLE KEYS */;
INSERT INTO `stack_info` VALUES (5,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,NULL,NULL),(8,NULL,NULL,NULL,NULL,NULL,NULL),(9,NULL,NULL,NULL,NULL,NULL,NULL),(10,NULL,NULL,NULL,NULL,NULL,NULL),(11,NULL,NULL,NULL,NULL,NULL,NULL),(12,NULL,NULL,NULL,NULL,NULL,NULL),(33,NULL,NULL,NULL,NULL,NULL,NULL),(34,NULL,NULL,NULL,NULL,NULL,NULL),(35,NULL,NULL,NULL,NULL,NULL,NULL),(36,NULL,NULL,NULL,NULL,NULL,NULL),(37,NULL,NULL,NULL,NULL,NULL,NULL),(38,NULL,NULL,NULL,NULL,NULL,NULL),(39,NULL,NULL,NULL,NULL,NULL,NULL),(40,NULL,NULL,NULL,NULL,NULL,NULL),(41,NULL,NULL,NULL,NULL,NULL,NULL),(42,NULL,NULL,NULL,NULL,NULL,NULL),(43,NULL,NULL,NULL,NULL,NULL,NULL),(44,NULL,NULL,NULL,NULL,NULL,NULL),(45,NULL,NULL,NULL,NULL,NULL,NULL),(46,NULL,NULL,NULL,NULL,NULL,NULL),(47,NULL,NULL,NULL,NULL,NULL,NULL),(48,NULL,NULL,NULL,NULL,NULL,NULL),(49,NULL,NULL,NULL,NULL,NULL,NULL),(50,NULL,NULL,NULL,NULL,NULL,NULL),(51,NULL,NULL,NULL,NULL,NULL,NULL),(52,NULL,NULL,NULL,NULL,NULL,NULL),(53,NULL,NULL,NULL,NULL,NULL,NULL),(54,NULL,NULL,NULL,NULL,NULL,NULL),(55,NULL,NULL,NULL,NULL,NULL,NULL),(56,NULL,NULL,NULL,NULL,NULL,NULL),(57,NULL,NULL,NULL,NULL,NULL,NULL),(58,NULL,NULL,NULL,NULL,NULL,NULL),(59,NULL,NULL,NULL,NULL,NULL,NULL),(60,NULL,NULL,NULL,NULL,NULL,NULL),(61,NULL,NULL,NULL,NULL,NULL,NULL),(62,NULL,NULL,NULL,NULL,NULL,NULL),(63,NULL,NULL,NULL,NULL,NULL,NULL),(64,NULL,NULL,NULL,NULL,NULL,NULL),(65,NULL,NULL,NULL,NULL,NULL,NULL),(66,NULL,NULL,NULL,NULL,NULL,NULL),(67,NULL,NULL,NULL,NULL,NULL,NULL),(68,NULL,NULL,NULL,NULL,NULL,NULL),(69,NULL,NULL,NULL,NULL,NULL,NULL),(70,NULL,NULL,NULL,NULL,NULL,NULL),(71,NULL,NULL,NULL,NULL,NULL,NULL),(72,NULL,NULL,NULL,NULL,NULL,NULL),(73,NULL,NULL,NULL,NULL,NULL,NULL),(74,NULL,NULL,NULL,NULL,NULL,NULL),(75,NULL,NULL,NULL,NULL,NULL,NULL),(76,NULL,NULL,NULL,NULL,NULL,NULL),(77,NULL,NULL,NULL,NULL,NULL,NULL),(78,NULL,NULL,NULL,NULL,NULL,NULL),(79,NULL,NULL,NULL,NULL,NULL,NULL),(80,NULL,NULL,NULL,NULL,NULL,NULL),(81,NULL,NULL,NULL,NULL,NULL,NULL),(82,NULL,NULL,NULL,NULL,NULL,NULL),(83,NULL,NULL,NULL,NULL,NULL,NULL),(84,NULL,NULL,NULL,NULL,NULL,NULL),(85,NULL,NULL,NULL,NULL,NULL,NULL),(86,NULL,NULL,NULL,NULL,NULL,NULL),(87,NULL,NULL,NULL,NULL,NULL,NULL),(88,NULL,NULL,NULL,NULL,NULL,NULL),(89,NULL,NULL,NULL,NULL,NULL,NULL),(90,NULL,NULL,NULL,NULL,NULL,NULL),(91,NULL,NULL,NULL,NULL,NULL,NULL),(92,NULL,NULL,NULL,NULL,NULL,NULL),(93,NULL,NULL,NULL,NULL,NULL,NULL),(94,NULL,NULL,NULL,NULL,NULL,NULL),(95,NULL,NULL,NULL,NULL,NULL,NULL),(96,NULL,NULL,NULL,NULL,NULL,NULL),(97,NULL,NULL,NULL,NULL,NULL,NULL),(98,NULL,NULL,NULL,NULL,NULL,NULL),(99,NULL,NULL,NULL,NULL,NULL,NULL),(100,NULL,NULL,NULL,NULL,NULL,NULL),(101,NULL,NULL,NULL,NULL,NULL,NULL),(102,NULL,NULL,NULL,NULL,NULL,NULL),(103,NULL,NULL,NULL,NULL,NULL,NULL),(104,NULL,NULL,NULL,NULL,NULL,NULL),(105,NULL,NULL,NULL,NULL,NULL,NULL),(115,NULL,NULL,NULL,NULL,NULL,NULL),(116,NULL,NULL,NULL,NULL,NULL,NULL),(117,NULL,NULL,NULL,NULL,NULL,NULL),(140,NULL,NULL,NULL,NULL,NULL,NULL),(141,NULL,NULL,NULL,NULL,NULL,NULL),(142,NULL,NULL,NULL,NULL,NULL,NULL),(143,NULL,NULL,NULL,NULL,NULL,NULL),(144,NULL,NULL,NULL,NULL,NULL,NULL),(145,NULL,NULL,NULL,NULL,NULL,NULL),(146,NULL,NULL,NULL,NULL,NULL,NULL),(147,NULL,NULL,NULL,NULL,NULL,NULL),(148,NULL,NULL,NULL,NULL,NULL,NULL),(149,NULL,NULL,NULL,NULL,NULL,NULL),(150,NULL,NULL,NULL,NULL,NULL,NULL),(151,NULL,NULL,NULL,NULL,NULL,NULL),(152,NULL,NULL,NULL,NULL,NULL,NULL),(153,NULL,NULL,NULL,NULL,NULL,NULL),(154,NULL,NULL,NULL,NULL,NULL,NULL),(155,NULL,NULL,NULL,NULL,NULL,NULL),(156,NULL,NULL,NULL,NULL,NULL,NULL),(157,NULL,NULL,NULL,NULL,NULL,NULL),(158,NULL,NULL,NULL,NULL,NULL,NULL),(159,NULL,NULL,NULL,NULL,NULL,NULL),(160,NULL,NULL,NULL,NULL,NULL,NULL),(161,NULL,NULL,NULL,NULL,NULL,NULL),(162,NULL,NULL,NULL,NULL,NULL,NULL),(163,NULL,NULL,NULL,NULL,NULL,NULL),(165,NULL,NULL,NULL,NULL,NULL,NULL),(166,NULL,NULL,NULL,NULL,NULL,NULL),(167,NULL,NULL,NULL,NULL,NULL,NULL),(168,NULL,NULL,NULL,NULL,NULL,NULL),(169,NULL,NULL,NULL,NULL,NULL,NULL),(170,NULL,NULL,NULL,NULL,NULL,NULL),(171,NULL,NULL,NULL,NULL,NULL,NULL),(172,NULL,NULL,NULL,NULL,NULL,NULL),(173,NULL,NULL,NULL,NULL,NULL,NULL),(174,NULL,NULL,NULL,NULL,NULL,NULL),(175,NULL,NULL,NULL,NULL,NULL,NULL),(176,NULL,NULL,NULL,NULL,NULL,NULL),(177,NULL,NULL,NULL,NULL,NULL,NULL),(178,NULL,NULL,NULL,NULL,NULL,NULL),(179,NULL,NULL,NULL,NULL,NULL,NULL),(180,NULL,NULL,NULL,NULL,NULL,NULL),(181,NULL,NULL,NULL,NULL,NULL,NULL),(182,NULL,NULL,NULL,NULL,NULL,NULL),(183,NULL,NULL,NULL,NULL,NULL,NULL),(184,NULL,NULL,NULL,NULL,NULL,NULL),(185,NULL,NULL,NULL,NULL,NULL,NULL),(186,NULL,NULL,NULL,NULL,NULL,NULL),(187,NULL,NULL,NULL,NULL,NULL,NULL),(188,NULL,NULL,NULL,NULL,NULL,NULL),(189,NULL,NULL,NULL,NULL,NULL,NULL),(190,NULL,NULL,NULL,NULL,NULL,NULL),(191,NULL,NULL,NULL,NULL,NULL,NULL),(192,NULL,NULL,NULL,NULL,NULL,NULL),(193,NULL,NULL,NULL,NULL,NULL,NULL),(194,NULL,NULL,NULL,NULL,NULL,NULL),(309,NULL,NULL,NULL,NULL,NULL,NULL),(310,NULL,NULL,NULL,NULL,NULL,NULL),(311,NULL,NULL,NULL,NULL,NULL,NULL),(315,NULL,NULL,NULL,NULL,NULL,NULL),(316,NULL,NULL,NULL,NULL,NULL,NULL),(318,NULL,NULL,NULL,NULL,NULL,NULL),(319,NULL,NULL,NULL,NULL,NULL,NULL),(320,NULL,NULL,NULL,NULL,NULL,NULL),(321,NULL,NULL,NULL,NULL,NULL,NULL),(322,NULL,NULL,NULL,NULL,NULL,NULL),(323,NULL,NULL,NULL,NULL,NULL,NULL),(324,NULL,NULL,NULL,NULL,NULL,NULL),(325,NULL,NULL,NULL,NULL,NULL,NULL),(326,NULL,NULL,NULL,NULL,NULL,NULL),(327,NULL,NULL,NULL,NULL,NULL,NULL),(328,NULL,NULL,NULL,NULL,NULL,NULL),(329,NULL,NULL,NULL,NULL,NULL,NULL),(330,NULL,NULL,NULL,NULL,NULL,NULL),(331,NULL,NULL,NULL,NULL,NULL,NULL),(332,NULL,NULL,NULL,NULL,NULL,NULL),(333,NULL,NULL,NULL,NULL,NULL,NULL),(334,NULL,NULL,NULL,NULL,NULL,NULL),(335,NULL,NULL,NULL,NULL,NULL,NULL),(336,NULL,NULL,NULL,NULL,NULL,NULL),(337,NULL,NULL,NULL,NULL,NULL,NULL),(338,NULL,NULL,NULL,NULL,NULL,NULL),(339,NULL,NULL,NULL,NULL,NULL,NULL),(340,NULL,NULL,NULL,NULL,NULL,NULL),(341,NULL,NULL,NULL,NULL,NULL,NULL),(342,NULL,NULL,NULL,NULL,NULL,NULL),(343,NULL,NULL,NULL,NULL,NULL,NULL),(344,NULL,NULL,NULL,NULL,NULL,NULL),(345,NULL,NULL,NULL,NULL,NULL,NULL),(346,NULL,NULL,NULL,NULL,NULL,NULL),(347,NULL,NULL,NULL,NULL,NULL,NULL),(348,NULL,NULL,NULL,NULL,NULL,NULL),(349,NULL,NULL,NULL,NULL,NULL,NULL),(350,NULL,NULL,NULL,NULL,NULL,NULL),(351,NULL,NULL,NULL,NULL,NULL,NULL),(352,NULL,NULL,NULL,NULL,NULL,NULL),(353,NULL,NULL,NULL,NULL,NULL,NULL),(354,NULL,NULL,NULL,NULL,NULL,NULL),(355,NULL,NULL,NULL,NULL,NULL,NULL),(356,NULL,NULL,NULL,NULL,NULL,NULL),(357,NULL,NULL,NULL,NULL,NULL,NULL),(358,NULL,NULL,NULL,NULL,NULL,NULL),(359,NULL,NULL,NULL,NULL,NULL,NULL),(360,NULL,NULL,NULL,NULL,NULL,NULL),(361,NULL,NULL,NULL,NULL,NULL,NULL),(362,NULL,NULL,NULL,NULL,NULL,NULL),(363,NULL,NULL,NULL,NULL,NULL,NULL),(364,NULL,NULL,NULL,NULL,NULL,NULL),(365,NULL,NULL,NULL,NULL,NULL,NULL),(366,NULL,NULL,NULL,NULL,NULL,NULL),(367,NULL,NULL,NULL,NULL,NULL,NULL),(368,NULL,NULL,NULL,NULL,NULL,NULL),(369,NULL,NULL,NULL,NULL,NULL,NULL),(370,NULL,NULL,NULL,NULL,NULL,NULL),(371,NULL,NULL,NULL,NULL,NULL,NULL),(372,NULL,NULL,NULL,NULL,NULL,NULL),(373,NULL,NULL,NULL,NULL,NULL,NULL),(374,NULL,NULL,NULL,NULL,NULL,NULL),(375,NULL,NULL,NULL,NULL,NULL,NULL),(376,NULL,NULL,NULL,NULL,NULL,NULL),(377,NULL,NULL,NULL,NULL,NULL,NULL),(378,NULL,NULL,NULL,NULL,NULL,NULL),(379,NULL,NULL,NULL,NULL,NULL,NULL),(380,NULL,NULL,NULL,NULL,NULL,NULL),(381,NULL,NULL,NULL,NULL,NULL,NULL),(382,NULL,NULL,NULL,NULL,NULL,NULL),(383,NULL,NULL,NULL,NULL,NULL,NULL),(384,NULL,NULL,NULL,NULL,NULL,NULL),(385,NULL,NULL,NULL,NULL,NULL,NULL),(387,NULL,NULL,NULL,NULL,NULL,NULL),(388,NULL,NULL,NULL,NULL,NULL,NULL),(389,NULL,NULL,NULL,NULL,NULL,NULL),(390,NULL,NULL,NULL,NULL,NULL,NULL),(391,NULL,NULL,NULL,NULL,NULL,NULL),(392,NULL,NULL,NULL,NULL,NULL,NULL),(393,NULL,NULL,NULL,NULL,NULL,NULL),(394,NULL,NULL,NULL,NULL,NULL,NULL),(395,NULL,NULL,NULL,NULL,NULL,NULL),(396,NULL,NULL,NULL,NULL,NULL,NULL),(397,NULL,NULL,NULL,NULL,NULL,NULL),(398,NULL,NULL,NULL,NULL,NULL,NULL),(399,NULL,NULL,NULL,NULL,NULL,NULL),(400,NULL,NULL,NULL,NULL,NULL,NULL),(401,NULL,NULL,NULL,NULL,NULL,NULL),(402,NULL,NULL,NULL,NULL,NULL,NULL),(403,NULL,NULL,NULL,NULL,NULL,NULL),(404,NULL,NULL,NULL,NULL,NULL,NULL),(405,NULL,NULL,NULL,NULL,NULL,NULL),(406,NULL,NULL,NULL,NULL,NULL,NULL),(407,NULL,NULL,NULL,NULL,NULL,NULL),(408,NULL,NULL,NULL,NULL,NULL,NULL),(409,NULL,NULL,NULL,NULL,NULL,NULL),(410,NULL,NULL,NULL,NULL,NULL,NULL),(411,NULL,NULL,NULL,NULL,NULL,NULL),(412,NULL,NULL,NULL,NULL,NULL,NULL),(413,NULL,NULL,NULL,NULL,NULL,NULL),(414,NULL,NULL,NULL,NULL,NULL,NULL),(415,NULL,NULL,NULL,NULL,NULL,NULL),(416,NULL,NULL,NULL,NULL,NULL,NULL),(417,NULL,NULL,NULL,NULL,NULL,NULL),(418,NULL,NULL,NULL,NULL,NULL,NULL),(419,NULL,NULL,NULL,NULL,NULL,NULL),(420,NULL,NULL,NULL,NULL,NULL,NULL),(421,NULL,NULL,NULL,NULL,NULL,NULL),(422,NULL,NULL,NULL,NULL,NULL,NULL),(423,NULL,NULL,NULL,NULL,NULL,NULL),(424,NULL,NULL,NULL,NULL,NULL,NULL),(425,NULL,NULL,NULL,NULL,NULL,NULL),(426,NULL,NULL,NULL,NULL,NULL,NULL),(427,NULL,NULL,NULL,NULL,NULL,NULL),(428,NULL,NULL,NULL,NULL,NULL,NULL),(429,NULL,NULL,NULL,NULL,NULL,NULL),(430,NULL,NULL,NULL,NULL,NULL,NULL),(431,NULL,NULL,NULL,NULL,NULL,NULL),(432,NULL,NULL,NULL,NULL,NULL,NULL),(433,NULL,NULL,NULL,NULL,NULL,NULL),(434,NULL,NULL,NULL,NULL,NULL,NULL),(435,NULL,NULL,NULL,NULL,NULL,NULL),(436,NULL,NULL,NULL,NULL,NULL,NULL),(437,NULL,NULL,NULL,NULL,NULL,NULL),(438,NULL,NULL,NULL,NULL,NULL,NULL),(439,NULL,NULL,NULL,NULL,NULL,NULL),(440,NULL,NULL,NULL,NULL,NULL,NULL),(441,NULL,NULL,NULL,NULL,NULL,NULL),(442,NULL,NULL,NULL,NULL,NULL,NULL),(443,NULL,NULL,NULL,NULL,NULL,NULL),(444,NULL,NULL,NULL,NULL,NULL,NULL),(445,NULL,NULL,NULL,NULL,NULL,NULL),(446,NULL,NULL,NULL,NULL,NULL,NULL),(447,NULL,NULL,NULL,NULL,NULL,NULL),(448,NULL,NULL,NULL,NULL,NULL,NULL),(449,NULL,NULL,NULL,NULL,NULL,NULL),(450,NULL,NULL,NULL,NULL,NULL,NULL),(451,NULL,NULL,NULL,NULL,NULL,NULL),(452,NULL,NULL,NULL,NULL,NULL,NULL),(453,NULL,NULL,NULL,NULL,NULL,NULL),(454,NULL,NULL,NULL,NULL,NULL,NULL),(455,NULL,NULL,NULL,NULL,NULL,NULL),(456,NULL,NULL,NULL,NULL,NULL,NULL),(457,NULL,NULL,NULL,NULL,NULL,NULL),(458,NULL,NULL,NULL,NULL,NULL,NULL),(459,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `stack_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stack_measurement`
--

DROP TABLE IF EXISTS `stack_measurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stack_measurement` (
  `stack_measurement_id` int NOT NULL AUTO_INCREMENT,
  `stack_id` int NOT NULL,
  `pollutant_id` int NOT NULL,
  `cycle_type` enum('monthly','twiceamonth','onceinfebruary','quarterly','semiannual','annual','additional','nomeasure') NOT NULL,
  `is_completed` tinyint(1) NOT NULL DEFAULT '0',
  `is_measure` tinyint(1) DEFAULT '1',
  `allow_value` double DEFAULT NULL,
  PRIMARY KEY (`stack_measurement_id`),
  KEY `fk_stack_id_idx` (`stack_id`),
  KEY `fk_pollutant_id_idx` (`pollutant_id`),
  CONSTRAINT `fk_pollutant_id` FOREIGN KEY (`pollutant_id`) REFERENCES `pollutant` (`pollutant_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stack_id` FOREIGN KEY (`stack_id`) REFERENCES `stack` (`stack_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1376 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stack_measurement`
--

LOCK TABLES `stack_measurement` WRITE;
/*!40000 ALTER TABLE `stack_measurement` DISABLE KEYS */;
INSERT INTO `stack_measurement` VALUES (104,11,17,'semiannual',0,1,NULL),(105,11,21,'semiannual',0,1,NULL),(106,12,17,'semiannual',0,1,NULL),(107,12,21,'semiannual',0,1,NULL),(108,5,17,'annual',0,1,NULL),(109,6,17,'annual',0,1,NULL),(110,7,17,'semiannual',0,1,NULL),(111,8,17,'semiannual',0,1,NULL),(112,9,17,'semiannual',0,1,NULL),(113,10,17,'semiannual',0,1,NULL),(114,115,17,'semiannual',0,1,NULL),(115,116,17,'semiannual',0,1,NULL),(116,117,17,'semiannual',0,1,NULL),(132,140,19,'quarterly',0,1,NULL),(133,140,26,'semiannual',0,1,NULL),(134,140,30,'semiannual',0,1,NULL),(135,140,24,'semiannual',0,1,NULL),(136,140,23,'semiannual',0,1,NULL),(137,140,53,'semiannual',0,1,NULL),(138,140,28,'semiannual',0,1,NULL),(139,140,27,'semiannual',0,1,NULL),(140,140,55,'semiannual',0,1,NULL),(141,140,29,'semiannual',0,1,NULL),(142,140,43,'semiannual',0,1,NULL),(143,141,19,'quarterly',0,1,NULL),(144,141,26,'semiannual',0,1,NULL),(145,141,30,'semiannual',0,1,NULL),(146,141,24,'semiannual',0,1,NULL),(147,141,23,'semiannual',0,1,NULL),(148,141,53,'semiannual',0,1,NULL),(149,141,28,'semiannual',0,1,NULL),(150,141,27,'semiannual',0,1,NULL),(151,141,55,'semiannual',0,1,NULL),(152,141,29,'semiannual',0,1,NULL),(153,141,43,'semiannual',0,1,NULL),(154,141,36,'semiannual',0,1,NULL),(155,142,19,'quarterly',0,1,NULL),(156,142,26,'semiannual',0,1,NULL),(157,142,30,'semiannual',0,1,NULL),(158,142,24,'semiannual',0,1,NULL),(159,142,23,'semiannual',0,1,NULL),(160,142,53,'semiannual',0,1,NULL),(161,142,28,'semiannual',0,1,NULL),(162,142,27,'semiannual',0,1,NULL),(163,142,55,'semiannual',0,1,NULL),(164,142,29,'semiannual',0,1,NULL),(165,142,36,'semiannual',0,1,NULL),(166,143,24,'monthly',0,1,NULL),(167,143,23,'monthly',0,1,NULL),(168,143,27,'monthly',0,1,NULL),(169,143,26,'quarterly',0,1,NULL),(170,143,30,'quarterly',0,1,NULL),(173,143,53,'quarterly',0,1,NULL),(174,143,43,'quarterly',0,1,NULL),(175,143,28,'quarterly',0,1,NULL),(176,143,56,'quarterly',0,1,NULL),(177,143,55,'quarterly',0,1,NULL),(178,144,19,'quarterly',0,1,NULL),(179,144,26,'semiannual',0,1,NULL),(180,144,30,'semiannual',0,1,NULL),(181,144,24,'semiannual',0,1,NULL),(182,144,23,'semiannual',0,1,NULL),(183,144,53,'semiannual',0,1,NULL),(184,144,28,'semiannual',0,1,NULL),(185,144,27,'semiannual',0,1,NULL),(186,144,55,'semiannual',0,1,NULL),(187,144,29,'semiannual',0,1,NULL),(188,144,43,'semiannual',0,1,NULL),(189,143,29,'quarterly',0,1,NULL),(435,309,17,'monthly',1,1,NULL),(436,310,17,'monthly',1,1,NULL),(437,311,17,'monthly',0,1,NULL),(440,309,59,'monthly',1,1,NULL),(441,310,60,'monthly',0,1,NULL),(442,310,57,'semiannual',0,1,NULL),(447,315,17,'annual',0,1,30),(449,315,21,'annual',0,1,NULL),(450,316,17,'annual',0,1,30),(452,316,21,'annual',0,1,NULL),(453,318,17,'twiceamonth',0,1,30),(454,318,55,'twiceamonth',0,1,NULL),(455,318,56,'twiceamonth',0,1,NULL),(457,318,19,'twiceamonth',0,1,200),(460,318,42,'twiceamonth',0,1,12),(461,319,17,'twiceamonth',0,1,30),(462,319,55,'twiceamonth',0,1,NULL),(463,319,56,'twiceamonth',0,1,4),(465,319,19,'twiceamonth',0,1,200),(468,319,42,'twiceamonth',0,1,12),(469,319,18,'nomeasure',0,0,150),(470,319,20,'nomeasure',0,0,NULL),(471,319,21,'nomeasure',0,0,NULL),(472,315,20,'nomeasure',0,0,NULL),(473,316,20,'nomeasure',0,0,NULL),(474,318,18,'nomeasure',0,0,NULL),(475,318,20,'nomeasure',0,0,NULL),(476,318,21,'nomeasure',0,0,NULL),(477,320,17,'annual',0,1,30),(478,320,55,'monthly',0,1,NULL),(479,320,56,'annual',0,1,4),(480,320,21,'annual',0,1,NULL),(481,320,42,'monthly',0,1,12),(482,321,20,'nomeasure',0,0,NULL),(483,321,17,'annual',0,1,30),(484,321,18,'annual',0,1,150),(485,321,19,'annual',0,1,200),(486,321,21,'annual',0,1,NULL),(487,322,17,'annual',0,1,30),(488,322,18,'annual',0,1,150),(489,322,19,'annual',0,1,200),(490,322,20,'nomeasure',0,0,NULL),(491,322,21,'annual',0,1,NULL),(492,323,17,'annual',0,1,30),(493,323,21,'annual',0,1,110),(494,324,17,'annual',0,1,30),(495,324,35,'monthly',0,1,2),(496,324,36,'annual',0,1,4),(497,324,55,'monthly',0,1,NULL),(498,324,56,'monthly',0,1,4),(499,324,21,'annual',0,1,200),(500,324,23,'monthly',0,1,2),(501,324,42,'monthly',0,1,12),(502,325,17,'annual',0,1,30),(503,325,60,'monthly',0,1,NULL),(504,325,34,'annual',0,1,4),(505,325,35,'monthly',0,1,2),(506,325,36,'annual',0,1,4),(507,325,37,'nomeasure',0,0,NULL),(508,325,55,'monthly',0,1,NULL),(509,325,56,'monthly',0,1,NULL),(510,325,18,'annual',0,1,150),(511,325,21,'annual',0,1,200),(512,325,23,'monthly',0,1,3),(513,325,24,'annual',0,1,2),(514,325,43,'monthly',0,1,6),(515,325,48,'monthly',0,1,50),(516,325,42,'monthly',0,1,12),(517,326,17,'annual',0,1,30),(518,326,55,'monthly',0,1,NULL),(519,326,56,'annual',0,1,4),(520,326,21,'nomeasure',0,0,NULL),(521,326,48,'annual',0,1,50),(522,326,42,'monthly',0,1,12),(523,327,17,'annual',0,1,30),(524,327,55,'monthly',0,1,NULL),(525,327,56,'annual',0,1,4),(526,327,18,'annual',0,1,150),(527,327,19,'annual',0,1,200),(528,327,20,'nomeasure',0,0,NULL),(529,327,21,'nomeasure',0,0,NULL),(530,327,44,'monthly',0,1,23),(531,327,42,'monthly',0,1,12),(532,328,17,'annual',0,1,30),(533,328,18,'annual',0,1,150),(534,328,19,'annual',0,1,200),(535,328,20,'nomeasure',0,0,NULL),(536,328,21,'nomeasure',0,0,NULL),(537,329,17,'annual',0,1,30),(538,329,18,'annual',0,1,150),(539,329,19,'annual',0,1,200),(540,329,20,'nomeasure',0,0,NULL),(541,329,21,'nomeasure',0,0,NULL),(542,330,17,'annual',0,1,30),(543,330,18,'annual',0,1,150),(544,330,19,'annual',0,1,200),(545,330,20,'nomeasure',0,0,NULL),(546,330,21,'annual',0,1,NULL),(547,331,17,'annual',0,1,30),(548,331,18,'annual',0,1,150),(549,331,19,'annual',0,1,200),(550,331,20,'nomeasure',0,0,NULL),(551,331,21,'nomeasure',0,0,NULL),(552,332,17,'annual',0,1,30),(553,332,18,'annual',0,1,150),(554,332,19,'annual',0,1,200),(555,332,20,'nomeasure',0,0,NULL),(556,332,21,'annual',0,1,NULL),(562,333,17,'annual',0,1,30),(563,333,18,'annual',0,1,150),(564,333,19,'annual',0,1,200),(565,333,20,'nomeasure',0,0,NULL),(566,333,21,'annual',0,1,NULL),(567,334,17,'annual',0,1,30),(568,334,55,'monthly',0,1,NULL),(569,334,56,'annual',0,1,4),(570,334,18,'annual',0,1,150),(571,334,19,'annual',0,1,200),(572,334,20,'nomeasure',0,0,NULL),(573,334,21,'nomeasure',0,0,NULL),(574,334,42,'monthly',0,1,12),(575,335,17,'annual',0,1,30),(576,335,55,'monthly',0,1,NULL),(577,335,56,'annual',0,1,4),(578,335,18,'annual',0,1,150),(579,335,19,'annual',0,1,200),(580,335,20,'nomeasure',0,0,NULL),(581,335,21,'nomeasure',0,0,NULL),(582,335,42,'monthly',0,1,12),(583,336,17,'annual',0,1,30),(584,336,55,'monthly',0,1,NULL),(585,336,56,'annual',0,1,4),(586,336,18,'annual',0,1,150),(587,336,19,'annual',0,1,200),(588,336,20,'nomeasure',0,0,NULL),(589,336,21,'nomeasure',0,0,NULL),(590,336,42,'monthly',0,1,12),(591,337,17,'annual',0,1,30),(592,337,55,'monthly',0,1,NULL),(593,337,56,'annual',0,1,4),(594,337,18,'annual',0,1,150),(595,337,19,'annual',0,1,200),(596,337,20,'nomeasure',0,0,NULL),(597,337,21,'nomeasure',0,0,NULL),(598,337,42,'monthly',0,1,12),(599,338,17,'annual',0,1,30),(600,338,55,'monthly',0,1,NULL),(601,338,56,'annual',0,1,4),(602,338,18,'annual',0,1,150),(603,338,19,'annual',0,1,200),(604,338,20,'nomeasure',0,0,NULL),(605,338,21,'nomeasure',0,0,NULL),(606,338,42,'monthly',0,1,12),(607,339,17,'annual',0,1,30),(608,339,55,'monthly',0,1,NULL),(609,339,56,'annual',0,1,4),(610,339,18,'annual',0,1,150),(611,339,19,'annual',0,1,200),(612,339,20,'nomeasure',0,0,NULL),(613,339,21,'nomeasure',0,0,NULL),(614,339,42,'monthly',0,1,12),(615,340,17,'annual',0,1,30),(616,340,55,'monthly',0,1,NULL),(617,340,56,'monthly',0,1,4),(618,340,18,'annual',0,1,150),(619,340,19,'annual',0,1,200),(620,340,20,'nomeasure',0,0,NULL),(621,340,21,'annual',0,1,NULL),(622,340,44,'monthly',0,1,23),(623,340,42,'monthly',0,1,12),(624,341,17,'annual',0,1,30),(625,341,55,'monthly',0,1,NULL),(626,341,56,'monthly',0,1,4),(627,341,18,'annual',0,1,150),(628,341,19,'annual',0,1,200),(629,341,20,'nomeasure',0,0,NULL),(630,341,21,'annual',0,1,NULL),(631,341,44,'monthly',0,1,23),(632,341,42,'monthly',0,1,12),(633,342,17,'annual',0,1,30),(634,342,55,'monthly',0,1,NULL),(635,342,56,'annual',0,1,4),(636,342,21,'nomeasure',0,0,NULL),(637,342,42,'monthly',0,1,12),(638,343,17,'annual',0,1,30),(639,343,35,'monthly',0,1,2),(640,343,36,'annual',0,1,4),(641,343,55,'monthly',0,1,NULL),(642,343,56,'monthly',0,1,4),(643,343,21,'annual',0,1,200),(644,343,25,'monthly',0,1,4),(645,343,42,'monthly',0,1,12),(646,344,17,'annual',0,1,30),(647,344,60,'monthly',0,1,NULL),(648,344,32,'monthly',0,1,NULL),(649,344,34,'annual',0,1,4),(650,344,35,'monthly',0,1,2),(651,344,36,'annual',0,1,4),(652,344,37,'nomeasure',0,0,NULL),(653,344,55,'monthly',0,1,NULL),(654,344,56,'monthly',0,1,4),(655,344,21,'annual',0,1,200),(656,344,23,'monthly',0,1,3),(657,344,24,'annual',0,1,2),(658,344,48,'monthly',0,1,50),(659,344,42,'monthly',0,1,12),(660,345,17,'annual',0,1,30),(661,345,55,'monthly',0,1,NULL),(662,345,56,'annual',0,1,4),(663,345,21,'nomeasure',0,0,NULL),(664,345,48,'annual',0,1,50),(665,345,42,'monthly',0,1,12),(666,346,17,'annual',0,1,30),(667,346,18,'annual',0,1,150),(668,346,19,'annual',0,1,200),(669,346,20,'nomeasure',0,0,NULL),(670,346,21,'nomeasure',0,0,NULL),(671,347,17,'annual',0,1,30),(672,347,55,'monthly',0,1,NULL),(673,347,56,'annual',0,1,4),(674,347,18,'annual',0,1,150),(675,347,19,'annual',0,1,200),(676,347,20,'nomeasure',0,0,NULL),(677,347,21,'nomeasure',0,0,NULL),(678,347,42,'monthly',0,1,12),(679,348,17,'annual',0,1,30),(680,348,55,'monthly',0,1,NULL),(681,348,56,'annual',0,1,4),(682,348,18,'annual',0,1,150),(683,348,19,'annual',0,1,200),(684,348,20,'nomeasure',0,0,NULL),(685,348,21,'nomeasure',0,0,NULL),(686,348,42,'monthly',0,1,12),(687,349,17,'annual',0,1,30),(688,349,55,'monthly',0,1,NULL),(689,349,56,'annual',0,1,4),(690,349,18,'annual',0,1,150),(691,349,19,'annual',0,1,200),(692,349,20,'nomeasure',0,0,NULL),(693,349,21,'nomeasure',0,0,NULL),(694,349,42,'monthly',0,1,12),(695,350,17,'annual',0,1,30),(696,350,55,'monthly',0,1,NULL),(697,350,56,'annual',0,1,4),(698,350,18,'annual',0,1,150),(699,350,19,'annual',0,1,200),(700,350,20,'nomeasure',0,0,NULL),(701,350,21,'nomeasure',0,0,NULL),(702,350,42,'monthly',0,1,12),(703,350,45,'monthly',0,1,5),(704,351,17,'annual',0,1,30),(705,351,55,'monthly',0,1,NULL),(706,351,56,'annual',0,1,4),(707,351,18,'annual',0,1,150),(708,351,19,'annual',0,1,200),(709,351,20,'nomeasure',0,0,NULL),(710,351,21,'nomeasure',0,0,NULL),(711,351,42,'monthly',0,1,12),(712,352,17,'annual',0,1,30),(713,352,55,'monthly',0,1,NULL),(714,352,56,'annual',0,1,4),(715,352,18,'annual',0,1,150),(716,352,19,'annual',0,1,200),(717,352,20,'nomeasure',0,0,NULL),(718,352,21,'nomeasure',0,0,NULL),(719,352,42,'monthly',0,1,12),(720,353,17,'annual',0,1,30),(721,353,55,'monthly',0,1,NULL),(722,353,56,'annual',0,1,4),(723,353,18,'annual',0,1,150),(724,353,19,'annual',0,1,200),(725,353,20,'nomeasure',0,0,NULL),(726,353,21,'nomeasure',0,0,NULL),(727,353,42,'monthly',0,1,12),(728,354,17,'annual',0,1,30),(729,354,55,'monthly',0,1,NULL),(730,354,56,'annual',0,1,4),(731,354,18,'annual',0,1,150),(732,354,19,'annual',0,1,200),(733,354,20,'nomeasure',0,0,NULL),(734,354,21,'nomeasure',0,0,NULL),(735,354,42,'monthly',0,1,12),(741,355,17,'annual',0,1,30),(742,355,19,'annual',0,1,200),(743,355,18,'annual',0,1,150),(744,355,20,'nomeasure',0,0,NULL),(745,355,21,'annual',0,1,NULL),(746,355,56,'monthly',0,1,4),(747,355,55,'monthly',0,1,NULL),(748,355,42,'monthly',0,1,12),(749,356,17,'annual',0,1,30),(750,356,19,'annual',0,1,200),(751,356,18,'annual',0,1,150),(752,356,20,'nomeasure',0,0,NULL),(753,356,21,'nomeasure',0,0,NULL),(754,357,17,'annual',0,1,30),(755,357,19,'annual',0,1,200),(756,357,18,'annual',0,1,150),(757,357,20,'nomeasure',0,0,NULL),(758,357,21,'nomeasure',0,0,NULL),(759,358,17,'annual',0,1,25),(760,358,18,'annual',0,1,150),(761,358,56,'monthly',0,1,4),(762,358,55,'monthly',0,1,NULL),(763,358,24,'annual',0,1,2),(764,358,23,'monthly',0,1,3),(765,358,39,'nomeasure',0,0,NULL),(766,358,34,'annual',0,1,4),(767,358,36,'annual',0,1,4),(768,358,38,'nomeasure',0,0,NULL),(769,358,37,'nomeasure',0,0,NULL),(770,358,20,'nomeasure',0,0,NULL),(771,358,21,'nomeasure',0,0,NULL),(772,359,17,'annual',0,1,25),(773,359,19,'annual',0,1,200),(774,359,18,'annual',0,1,150),(775,359,56,'monthly',0,1,4),(776,359,55,'monthly',0,1,NULL),(777,359,24,'annual',0,1,2),(778,359,23,'monthly',0,1,3),(779,359,39,'nomeasure',0,0,NULL),(780,359,34,'annual',0,1,4),(781,359,36,'annual',0,1,4),(782,359,38,'nomeasure',0,0,NULL),(783,359,37,'nomeasure',0,0,NULL),(784,359,21,'nomeasure',0,0,NULL),(785,360,17,'annual',0,1,15),(786,360,56,'monthly',0,1,4),(787,360,55,'monthly',0,1,NULL),(788,360,25,'monthly',0,1,4),(789,360,30,'annual',0,1,30),(790,360,21,'nomeasure',0,0,NULL),(791,361,17,'annual',0,1,30),(792,361,56,'annual',0,1,4),(793,361,55,'monthly',0,1,NULL),(794,361,25,'annual',0,1,4),(795,361,30,'annual',0,1,30),(796,361,21,'nomeasure',0,0,NULL),(797,362,17,'annual',0,1,30),(798,362,21,'nomeasure',0,0,NULL),(799,363,17,'quarterly',0,1,30),(800,363,56,'annual',0,1,4),(801,363,55,'monthly',0,1,NULL),(802,363,25,'annual',0,1,4),(803,363,30,'annual',0,1,30),(804,363,20,'nomeasure',0,0,NULL),(805,363,21,'nomeasure',0,0,NULL),(806,364,17,'annual',0,1,25),(807,364,19,'annual',0,1,200),(808,364,18,'annual',0,1,150),(809,364,56,'monthly',0,1,4),(810,364,55,'monthly',0,1,NULL),(811,364,24,'annual',0,1,2),(812,364,23,'monthly',0,1,3),(813,364,39,'nomeasure',0,0,NULL),(814,364,34,'annual',0,1,4),(815,364,36,'annual',0,1,4),(816,364,38,'nomeasure',0,0,NULL),(817,364,37,'nomeasure',0,0,NULL),(818,364,20,'nomeasure',0,0,NULL),(819,364,32,'annual',0,1,NULL),(820,364,35,'annual',0,1,2),(821,364,48,'annual',0,1,50),(822,364,43,'annual',0,1,6),(823,364,42,'monthly',0,1,12),(824,364,45,'annual',0,1,5),(825,364,25,'monthly',0,1,4),(826,364,28,'annual',0,1,4),(827,364,21,'nomeasure',0,0,NULL),(828,365,17,'annual',0,1,25),(829,365,19,'annual',0,1,200),(830,365,18,'annual',0,1,150),(831,365,56,'monthly',0,1,4),(832,365,55,'monthly',0,1,NULL),(833,365,24,'annual',0,1,2),(834,365,23,'monthly',0,1,3),(835,365,39,'nomeasure',0,0,NULL),(836,365,34,'annual',0,1,4),(837,365,36,'annual',0,1,4),(838,365,38,'nomeasure',0,0,NULL),(839,365,37,'nomeasure',0,0,NULL),(840,365,20,'nomeasure',0,0,NULL),(841,365,21,'nomeasure',0,0,NULL),(842,366,17,'annual',0,1,25),(843,366,19,'annual',0,1,200),(844,366,18,'annual',0,1,150),(845,366,56,'monthly',0,1,4),(846,366,55,'monthly',0,1,NULL),(847,366,24,'annual',0,1,2),(848,366,23,'monthly',0,1,3),(849,366,39,'nomeasure',0,0,NULL),(850,366,34,'annual',0,1,4),(851,366,36,'annual',0,1,4),(852,366,38,'nomeasure',0,0,NULL),(853,366,37,'nomeasure',0,0,NULL),(854,366,20,'nomeasure',0,0,NULL),(855,366,21,'nomeasure',0,0,NULL),(856,367,56,'monthly',0,1,4),(857,367,55,'monthly',0,1,NULL),(858,367,25,'monthly',0,1,4),(859,367,30,'quarterly',0,1,30),(860,367,20,'nomeasure',0,0,NULL),(861,367,21,'nomeasure',0,0,NULL),(862,368,17,'annual',0,1,30),(863,368,56,'monthly',0,1,4),(864,368,43,'monthly',0,1,6),(865,368,55,'monthly',0,1,NULL),(866,368,25,'monthly',0,1,4),(867,368,30,'annual',0,1,30),(868,368,39,'nomeasure',0,0,NULL),(869,368,34,'annual',0,1,4),(870,368,36,'annual',0,1,4),(871,368,38,'nomeasure',0,0,NULL),(872,368,37,'nomeasure',0,0,NULL),(873,368,35,'monthly',0,1,2),(874,368,32,'monthly',0,1,NULL),(875,368,20,'nomeasure',0,0,NULL),(876,368,21,'nomeasure',0,0,NULL),(877,369,17,'quarterly',0,1,25),(878,369,19,'annual',0,1,200),(879,369,18,'quarterly',0,1,150),(880,369,56,'monthly',0,1,4),(881,369,55,'monthly',0,1,NULL),(882,369,24,'quarterly',0,1,2),(883,369,23,'monthly',0,1,3),(884,369,39,'nomeasure',0,0,NULL),(885,369,34,'quarterly',0,1,4),(886,369,36,'quarterly',0,1,4),(887,369,38,'nomeasure',0,0,NULL),(888,369,37,'nomeasure',0,0,NULL),(889,369,20,'nomeasure',0,0,NULL),(890,369,60,'monthly',0,1,NULL),(891,369,21,'nomeasure',0,0,NULL),(892,370,17,'annual',0,1,25),(893,370,19,'annual',0,1,35),(894,370,18,'annual',0,1,70),(895,370,56,'monthly',0,1,4),(896,370,55,'monthly',0,1,10),(897,370,42,'monthly',0,1,12),(898,370,44,'monthly',0,1,23),(899,370,46,'monthly',0,1,3),(900,370,48,'monthly',0,1,50),(901,370,60,'monthly',0,1,NULL),(902,370,20,'annual',0,1,200),(903,370,30,'annual',0,1,20),(904,370,23,'monthly',0,1,10),(905,370,31,'monthly',0,1,NULL),(906,370,28,'monthly',0,1,4),(907,370,61,'monthly',0,1,3),(908,370,21,'monthly',0,1,NULL),(909,371,17,'annual',0,1,30),(910,371,56,'monthly',0,1,4),(911,371,55,'monthly',0,1,NULL),(912,371,42,'monthly',0,1,12),(913,371,24,'annual',0,1,2),(914,371,23,'monthly',0,1,2),(915,371,39,'nomeasure',0,0,NULL),(916,371,35,'monthly',0,1,2),(917,371,36,'annual',0,1,4),(918,371,37,'nomeasure',0,0,NULL),(919,371,48,'monthly',0,1,50),(920,371,29,'annual',0,1,10),(921,371,21,'annual',0,1,200),(922,371,20,'nomeasure',0,0,NULL),(923,372,17,'annual',0,1,25),(924,372,18,'annual',0,1,150),(925,372,56,'monthly',0,1,4),(926,372,55,'monthly',0,1,NULL),(927,372,24,'annual',0,1,2),(928,372,23,'monthly',0,1,3),(929,372,39,'nomeasure',0,0,NULL),(930,372,34,'annual',0,1,4),(931,372,36,'annual',0,1,4),(932,372,38,'nomeasure',0,0,NULL),(933,372,37,'nomeasure',0,0,NULL),(934,372,20,'nomeasure',0,0,NULL),(935,372,35,'annual',0,1,2),(936,372,43,'annual',0,1,6),(937,372,31,'monthly',0,1,0.5),(938,372,28,'annual',0,1,4),(939,372,42,'monthly',0,1,12),(940,372,60,'annual',0,1,0.4),(941,372,45,'annual',0,1,5),(942,372,21,'nomeasure',0,0,NULL),(943,373,17,'annual',0,1,30),(944,373,20,'nomeasure',0,0,NULL),(945,373,21,'nomeasure',0,0,NULL),(946,374,17,'quarterly',0,1,30),(947,374,56,'annual',0,1,4),(948,374,55,'monthly',0,1,NULL),(949,374,25,'annual',0,1,4),(950,374,30,'annual',0,1,30),(951,374,39,'nomeasure',0,0,NULL),(952,374,34,'annual',0,1,4),(953,374,36,'annual',0,1,4),(954,374,38,'nomeasure',0,0,NULL),(955,374,37,'nomeasure',0,0,NULL),(956,374,35,'annual',0,1,2),(957,374,32,'annual',0,1,0.8),(958,374,20,'nomeasure',0,0,NULL),(959,374,21,'nomeasure',0,0,NULL),(960,375,17,'annual',0,1,30),(961,375,56,'annual',0,1,4),(962,375,55,'monthly',0,1,NULL),(963,375,25,'annual',0,1,4),(964,375,30,'annual',0,1,30),(965,375,21,'nomeasure',0,0,NULL),(966,376,17,'annual',0,1,30),(967,376,20,'nomeasure',0,0,NULL),(968,376,21,'annual',0,1,110),(969,377,17,'annual',0,1,30),(970,377,21,'annual',0,1,110),(971,378,17,'annual',0,1,30),(972,378,21,'annual',0,1,110),(973,378,20,'nomeasure',0,0,NULL),(974,379,17,'annual',0,1,30),(975,379,21,'annual',0,1,110),(976,379,20,'nomeasure',0,0,NULL),(977,380,17,'annual',0,1,30),(978,380,21,'annual',0,1,110),(979,381,17,'annual',0,1,30),(980,381,21,'annual',0,1,110),(981,382,17,'annual',0,1,30),(982,382,21,'annual',0,1,110),(983,383,17,'annual',0,1,30),(984,383,21,'annual',0,1,110),(985,384,17,'annual',0,1,30),(986,384,21,'annual',0,1,110),(987,384,20,'nomeasure',0,0,NULL),(988,385,17,'annual',0,1,30),(989,385,21,'annual',0,1,110),(990,387,17,'annual',0,1,30),(991,387,21,'annual',0,1,110),(992,388,17,'quarterly',0,1,30),(993,388,56,'monthly',0,1,4),(994,388,43,'monthly',0,1,6),(995,388,55,'monthly',0,1,NULL),(996,388,25,'monthly',0,1,4),(997,388,30,'quarterly',0,1,30),(998,388,39,'nomeasure',0,0,NULL),(999,388,34,'quarterly',0,1,4),(1000,388,36,'quarterly',0,1,4),(1001,388,38,'nomeasure',0,0,NULL),(1002,388,62,'nomeasure',0,0,NULL),(1003,388,37,'nomeasure',0,0,NULL),(1004,388,35,'monthly',0,1,2),(1005,388,32,'monthly',0,1,0.8),(1006,388,20,'nomeasure',0,0,NULL),(1007,388,21,'nomeasure',0,0,NULL),(1008,389,17,'annual',0,1,30),(1009,389,19,'annual',0,1,200),(1010,389,18,'annual',0,1,150),(1011,389,20,'nomeasure',0,0,NULL),(1012,389,21,'annual',0,1,NULL),(1013,390,17,'quarterly',0,1,15),(1014,390,19,'annual',0,1,200),(1015,390,18,'quarterly',0,1,150),(1016,390,56,'monthly',0,1,4),(1017,390,55,'monthly',0,1,NULL),(1018,390,24,'quarterly',0,1,2),(1019,390,23,'monthly',0,1,3),(1020,390,39,'nomeasure',0,0,NULL),(1021,390,34,'quarterly',0,1,4),(1022,390,36,'quarterly',0,1,4),(1023,390,38,'nomeasure',0,0,NULL),(1024,390,62,'nomeasure',0,0,NULL),(1025,390,37,'nomeasure',0,0,NULL),(1026,390,20,'nomeasure',0,0,NULL),(1027,390,60,'monthly',0,1,0.4),(1028,390,21,'nomeasure',0,0,NULL),(1029,391,17,'quarterly',0,1,25),(1030,391,56,'monthly',0,1,4),(1031,391,55,'monthly',0,1,10),(1032,391,42,'monthly',0,1,12),(1033,391,48,'monthly',0,1,50),(1034,391,60,'monthly',0,1,0.2),(1035,391,20,'quarterly',0,1,200),(1036,391,31,'monthly',0,1,0.2),(1037,391,30,'quarterly',0,1,20),(1038,391,23,'monthly',0,1,10),(1039,391,18,'nomeasure',0,0,70),(1040,391,28,'monthly',0,1,4),(1041,391,35,'monthly',0,1,2),(1042,391,21,'monthly',0,1,NULL),(1043,391,61,'monthly',0,1,3),(1044,391,19,'quarterly',0,1,35),(1045,392,17,'annual',0,1,30),(1046,392,56,'annual',0,1,4),(1047,392,55,'monthly',0,1,NULL),(1048,392,25,'annual',0,1,4),(1049,392,30,'annual',0,1,30),(1050,392,39,'nomeasure',0,0,NULL),(1051,392,34,'annual',0,1,4),(1052,392,36,'annual',0,1,4),(1053,392,38,'nomeasure',0,0,NULL),(1054,392,62,'nomeasure',0,0,NULL),(1055,392,37,'nomeasure',0,0,NULL),(1056,392,35,'annual',0,1,2),(1057,392,32,'annual',0,1,0.8),(1058,392,20,'nomeasure',0,0,NULL),(1059,392,21,'nomeasure',0,0,NULL),(1060,393,17,'quarterly',0,1,30),(1061,393,56,'monthly',0,1,4),(1062,393,55,'monthly',0,1,NULL),(1063,393,42,'monthly',0,1,12),(1064,393,25,'monthly',0,1,4),(1065,393,30,'quarterly',0,1,30),(1066,393,39,'nomeasure',0,0,NULL),(1067,393,34,'quarterly',0,1,4),(1068,393,36,'quarterly',0,1,4),(1069,393,38,'nomeasure',0,0,NULL),(1070,393,37,'nomeasure',0,0,NULL),(1071,393,35,'monthly',0,1,2),(1072,393,32,'monthly',0,1,0.8),(1073,393,20,'nomeasure',0,0,NULL),(1074,393,21,'nomeasure',0,0,NULL),(1075,394,17,'quarterly',0,1,15),(1076,394,21,'nomeasure',0,0,NULL),(1077,396,17,'annual',0,1,30),(1078,396,19,'annual',0,1,200),(1079,396,18,'annual',0,1,150),(1080,396,20,'nomeasure',0,0,NULL),(1081,396,21,'annual',0,1,NULL),(1082,397,17,'monthly',0,1,30),(1083,397,21,'nomeasure',0,0,NULL),(1084,398,17,'annual',0,1,30),(1085,398,21,'nomeasure',0,0,NULL),(1086,399,17,'annual',0,1,30),(1087,399,19,'annual',0,1,200),(1088,399,18,'annual',0,1,150),(1089,399,20,'nomeasure',0,0,NULL),(1090,399,21,'annual',0,1,200),(1091,399,42,'annual',0,1,12),(1092,400,17,'annual',0,1,30),(1093,400,21,'annual',0,1,200),(1094,401,17,'annual',0,1,30),(1095,401,21,'annual',0,1,200),(1096,401,42,'annual',0,1,12),(1097,402,17,'annual',0,1,30),(1098,402,21,'annual',0,1,200),(1099,402,42,'annual',0,1,12),(1100,403,17,'annual',0,1,30),(1101,403,21,'annual',0,1,200),(1102,403,42,'annual',0,1,12),(1103,404,17,'annual',0,1,30),(1104,404,21,'annual',0,1,110),(1105,405,17,'annual',0,1,30),(1106,405,21,'nomeasure',0,0,NULL),(1107,405,20,'nomeasure',0,0,NULL),(1108,395,17,'annual',0,1,30),(1109,395,21,'nomeasure',0,0,NULL),(1110,406,17,'annual',0,1,30),(1111,406,56,'annual',0,1,4),(1112,406,55,'monthly',0,1,NULL),(1113,406,42,'monthly',0,1,12),(1114,406,21,'annual',0,1,110),(1115,407,17,'annual',0,1,30),(1116,407,19,'annual',0,1,200),(1117,407,18,'annual',0,1,150),(1118,407,20,'nomeasure',0,0,NULL),(1119,407,56,'annual',0,1,4),(1120,407,55,'monthly',0,1,NULL),(1121,407,42,'monthly',0,1,12),(1122,407,21,'nomeasure',0,0,NULL),(1123,408,17,'annual',0,1,30),(1124,408,19,'annual',0,1,200),(1125,408,18,'annual',0,1,150),(1126,408,20,'nomeasure',0,0,NULL),(1127,408,56,'annual',0,1,4),(1128,408,55,'monthly',0,1,NULL),(1129,408,42,'monthly',0,1,12),(1130,408,21,'nomeasure',0,0,NULL),(1131,409,17,'annual',0,1,30),(1132,409,19,'annual',0,1,200),(1133,409,18,'annual',0,1,150),(1134,409,20,'nomeasure',0,0,NULL),(1135,409,56,'annual',0,1,4),(1136,409,55,'monthly',0,1,NULL),(1137,409,42,'monthly',0,1,12),(1138,409,21,'nomeasure',0,0,NULL),(1139,410,17,'annual',0,1,30),(1140,410,19,'annual',0,1,200),(1141,410,18,'annual',0,1,150),(1142,410,20,'nomeasure',0,0,NULL),(1143,410,56,'annual',0,1,4),(1144,410,55,'monthly',0,1,NULL),(1145,410,42,'monthly',0,1,12),(1146,410,21,'nomeasure',0,0,NULL),(1147,411,17,'annual',0,1,30),(1148,411,19,'annual',0,1,200),(1149,411,18,'annual',0,1,150),(1150,411,20,'nomeasure',0,0,NULL),(1151,411,56,'annual',0,1,4),(1152,411,55,'monthly',0,1,NULL),(1153,411,42,'monthly',0,1,12),(1154,411,21,'nomeasure',0,0,NULL),(1155,412,17,'annual',0,1,30),(1156,412,19,'annual',0,1,200),(1157,412,18,'annual',0,1,150),(1158,412,20,'nomeasure',0,0,NULL),(1159,412,56,'annual',0,1,4),(1160,412,55,'monthly',0,1,NULL),(1161,412,42,'monthly',0,1,12),(1162,412,21,'nomeasure',0,0,NULL),(1163,413,17,'annual',0,1,30),(1164,413,19,'annual',0,1,200),(1165,413,18,'annual',0,1,150),(1166,413,20,'nomeasure',0,0,NULL),(1167,413,56,'annual',0,1,4),(1168,413,55,'monthly',0,1,NULL),(1169,413,42,'monthly',0,1,12),(1170,413,21,'nomeasure',0,0,NULL),(1171,414,17,'annual',0,1,30),(1172,414,19,'annual',0,1,200),(1173,414,18,'annual',0,1,150),(1174,414,20,'nomeasure',0,0,NULL),(1175,414,56,'annual',0,1,4),(1176,414,55,'monthly',0,1,NULL),(1177,414,42,'monthly',0,1,12),(1178,414,21,'nomeasure',0,0,NULL),(1179,415,17,'annual',0,1,30),(1180,415,19,'annual',0,1,200),(1181,415,18,'annual',0,1,150),(1182,415,20,'nomeasure',0,0,NULL),(1183,415,56,'annual',0,1,4),(1184,415,55,'monthly',0,1,NULL),(1185,415,42,'monthly',0,1,12),(1186,415,21,'nomeasure',0,0,NULL),(1187,416,17,'annual',0,1,30),(1188,416,19,'annual',0,1,200),(1189,416,18,'annual',0,1,150),(1190,416,20,'nomeasure',0,0,NULL),(1191,416,56,'annual',0,1,4),(1192,416,55,'monthly',0,1,NULL),(1193,416,42,'monthly',0,1,12),(1194,416,21,'nomeasure',0,0,NULL),(1195,417,17,'annual',0,1,30),(1196,417,21,'annual',0,1,110),(1197,418,17,'annual',0,1,30),(1198,418,21,'annual',0,1,110),(1199,419,17,'annual',0,1,15),(1200,420,17,'annual',0,1,30),(1201,420,21,'annual',0,1,NULL),(1202,420,42,'monthly',0,1,12),(1203,420,39,'nomeasure',0,0,NULL),(1204,420,38,'nomeasure',0,0,NULL),(1205,420,19,'annual',0,1,200),(1206,420,18,'annual',0,1,150),(1207,421,17,'annual',0,1,30),(1208,421,21,'annual',0,1,110),(1209,422,17,'annual',0,1,30),(1210,422,21,'annual',0,1,110),(1211,423,17,'semiannual',0,1,30),(1212,424,17,'semiannual',0,1,30),(1213,425,17,'annual',0,1,30),(1214,425,19,'annual',0,1,35),(1215,425,18,'annual',0,1,40),(1216,425,20,'nomeasure',0,0,NULL),(1217,426,17,'annual',0,1,30),(1218,426,19,'annual',0,1,35),(1219,426,18,'annual',0,1,40),(1220,426,20,'nomeasure',0,0,NULL),(1221,427,17,'annual',0,1,10),(1222,427,19,'annual',0,1,200),(1223,427,18,'annual',0,1,150),(1224,427,20,'nomeasure',0,0,NULL),(1225,427,21,'nomeasure',0,0,NULL),(1226,428,17,'annual',0,1,10),(1227,428,19,'annual',0,1,200),(1228,428,18,'annual',0,1,150),(1229,428,20,'nomeasure',0,0,NULL),(1230,428,21,'nomeasure',0,0,NULL),(1231,429,17,'annual',0,1,10),(1232,429,19,'annual',0,1,200),(1233,429,18,'annual',0,1,150),(1234,429,20,'nomeasure',0,0,NULL),(1235,429,21,'nomeasure',0,0,NULL),(1236,430,17,'annual',0,1,10),(1237,430,19,'annual',0,1,200),(1238,430,18,'annual',0,1,150),(1239,430,20,'nomeasure',0,0,NULL),(1240,430,21,'nomeasure',0,0,NULL),(1241,431,17,'annual',0,1,30),(1242,431,21,'annual',0,1,110),(1243,431,42,'annual',0,1,12),(1244,432,17,'annual',0,1,20),(1245,432,19,'annual',0,1,30),(1246,432,18,'annual',0,1,70),(1247,432,21,'monthly',0,1,NULL),(1248,432,56,'monthly',0,1,4),(1249,432,55,'monthly',0,1,10),(1250,432,42,'monthly',0,1,12),(1251,432,48,'monthly',0,1,50),(1252,432,60,'monthly',0,1,0.2),(1253,432,31,'monthly',0,1,0.2),(1254,432,20,'annual',0,1,200),(1255,432,30,'annual',0,1,20),(1256,432,23,'monthly',0,1,10),(1257,432,28,'monthly',0,1,4),(1258,432,61,'monthly',0,1,3),(1259,433,17,'quarterly',0,1,30),(1260,433,23,'monthly',0,1,3),(1261,433,31,'monthly',0,1,0.5),(1262,434,17,'annual',0,1,30),(1263,434,19,'annual',0,1,35),(1264,434,18,'annual',0,1,40),(1265,434,20,'nomeasure',0,0,NULL),(1266,435,17,'annual',0,1,30),(1267,435,19,'annual',0,1,200),(1268,435,18,'annual',0,1,150),(1269,435,20,'nomeasure',0,0,NULL),(1270,435,21,'annual',0,1,NULL),(1271,435,42,'monthly',0,1,12),(1272,436,17,'annual',0,1,30),(1273,436,39,'nomeasure',0,0,NULL),(1274,436,34,'annual',0,1,4),(1275,436,38,'nomeasure',0,0,NULL),(1276,436,23,'monthly',0,1,3),(1277,436,56,'monthly',0,1,4),(1278,436,55,'monthly',0,1,NULL),(1279,436,35,'monthly',0,1,2),(1280,436,60,'monthly',0,1,0.4),(1281,436,31,'monthly',0,1,0.5),(1282,436,43,'monthly',0,1,6),(1283,436,48,'annual',0,1,50),(1284,436,24,'annual',0,1,2),(1285,436,28,'annual',0,1,4),(1286,436,45,'annual',0,1,5),(1287,436,25,'monthly',0,1,4),(1288,436,20,'nomeasure',0,0,NULL),(1289,436,21,'nomeasure',0,0,NULL),(1290,437,17,'annual',0,1,30),(1291,437,19,'annual',0,1,10),(1292,437,18,'annual',0,1,40),(1293,437,20,'nomeasure',0,0,NULL),(1294,438,17,'annual',0,1,30),(1295,438,19,'annual',0,1,10),(1296,438,18,'annual',0,1,40),(1297,438,20,'nomeasure',0,0,NULL),(1298,439,17,'annual',0,1,30),(1299,439,21,'annual',0,1,200),(1300,439,42,'annual',0,1,12),(1301,440,17,'annual',0,1,30),(1302,440,21,'annual',0,1,200),(1303,440,42,'annual',0,1,12),(1304,441,17,'annual',0,1,30),(1305,441,21,'annual',0,1,200),(1306,441,42,'annual',0,1,12),(1307,442,17,'annual',0,1,30),(1308,442,21,'annual',0,1,200),(1309,442,42,'annual',0,1,12),(1310,443,17,'annual',0,1,30),(1311,443,21,'annual',0,1,200),(1312,443,42,'annual',0,1,12),(1313,444,17,'annual',0,1,15),(1314,444,21,'nomeasure',0,0,NULL),(1315,445,17,'annual',0,1,10),(1316,445,19,'annual',0,1,200),(1317,445,18,'annual',0,1,150),(1318,445,20,'nomeasure',0,0,NULL),(1319,445,21,'nomeasure',0,0,NULL),(1320,446,17,'annual',0,1,10),(1321,446,19,'annual',0,1,200),(1322,446,18,'annual',0,1,150),(1323,446,20,'nomeasure',0,0,NULL),(1324,446,21,'nomeasure',0,0,NULL),(1325,447,17,'annual',0,1,10),(1326,447,19,'annual',0,1,200),(1327,447,18,'annual',0,1,150),(1328,447,20,'nomeasure',0,0,NULL),(1329,447,21,'nomeasure',0,0,NULL),(1330,448,17,'annual',0,1,30),(1331,448,20,'nomeasure',0,0,NULL),(1332,448,21,'nomeasure',0,0,NULL),(1333,449,17,'annual',0,1,30),(1334,449,21,'nomeasure',0,0,NULL),(1335,450,17,'annual',0,1,30),(1336,450,21,'nomeasure',0,0,NULL),(1337,451,17,'annual',0,1,30),(1338,451,21,'nomeasure',0,0,NULL),(1339,452,17,'annual',0,1,30),(1340,452,19,'annual',0,1,200),(1341,452,18,'annual',0,1,150),(1342,452,20,'nomeasure',0,0,NULL),(1343,453,17,'annual',0,1,30),(1344,453,19,'annual',0,1,200),(1345,453,18,'annual',0,1,150),(1346,453,20,'nomeasure',0,0,NULL),(1347,454,17,'annual',0,1,30),(1348,454,19,'annual',0,1,200),(1349,454,18,'annual',0,1,150),(1350,454,20,'nomeasure',0,0,NULL),(1351,455,17,'annual',0,1,30),(1352,455,19,'annual',0,1,200),(1353,455,18,'annual',0,1,150),(1354,455,20,'nomeasure',0,0,NULL),(1355,455,21,'annual',0,1,NULL),(1356,455,42,'monthly',0,1,12),(1357,456,17,'annual',0,1,30),(1358,456,19,'annual',0,1,200),(1359,456,18,'annual',0,1,150),(1360,456,20,'nomeasure',0,0,NULL),(1361,456,21,'annual',0,1,NULL),(1362,456,42,'monthly',0,1,12),(1363,457,17,'annual',0,1,30),(1364,457,21,'annual',0,1,110),(1365,457,42,'monthly',0,1,12),(1366,458,17,'annual',0,1,30),(1367,459,17,'annual',0,1,30),(1368,459,19,'annual',0,1,200),(1369,459,18,'annual',0,1,150),(1370,459,20,'nomeasure',0,0,NULL);
/*!40000 ALTER TABLE `stack_measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_factory`
--

DROP TABLE IF EXISTS `sub_factory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_factory` (
  `sub_factory_id` int NOT NULL AUTO_INCREMENT,
  `factory_id` int NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`sub_factory_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_subFactory_factory_id_idx` (`factory_id`),
  CONSTRAINT `fk_subFactory_factory_id` FOREIGN KEY (`factory_id`) REFERENCES `factory` (`factory_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_factory`
--

LOCK TABLES `sub_factory` WRITE;
/*!40000 ALTER TABLE `sub_factory` DISABLE KEYS */;
INSERT INTO `sub_factory` VALUES (16,1,'도장 3공장'),(17,1,'의장 3공장'),(18,2,'도장 41공장'),(19,2,'의장 41공장'),(20,2,'도장 42공장'),(21,2,'의장 42공장'),(22,2,'42창고'),(23,2,'SUB장'),(24,3,'단조 공장'),(25,3,'블록 1공장'),(26,3,'블록 2공장'),(27,3,'케이스 1공장'),(28,3,'케이스 2공장'),(29,3,'헤드 1공장'),(30,3,'헤드 2공장');
/*!40000 ALTER TABLE `sub_factory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
  `team_id` int NOT NULL AUTO_INCREMENT,
  `team_name` varchar(10) NOT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'1팀'),(2,'2팀'),(3,'3팀'),(4,'4팀');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workplace`
--

DROP TABLE IF EXISTS `workplace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workplace` (
  `workplace_id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `workplace_name` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  PRIMARY KEY (`workplace_id`),
  UNIQUE KEY `workplace_name_UNIQUE` (`workplace_name`),
  KEY `fk_workplace_company_id_idx` (`company_id`),
  CONSTRAINT `fk_workplace_company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workplace`
--

LOCK TABLES `workplace` WRITE;
/*!40000 ALTER TABLE `workplace` DISABLE KEYS */;
INSERT INTO `workplace` VALUES (2,7,'(주)동헌레미콘 양산2공장','부산 강서구 명동길 47 (지사동) 2층','2024-10-29'),(3,6,'삼양소재화학(주)','경남 양산시 유산동 462-1','2024-10-29'),(4,5,'에이치디현대중공업','울산 동구 방어진순환도로 140 (방어동)','2024-10-29'),(5,4,'(주) 현대미포조선','울산 동구 방어진순환도로 100 (방어동)','2024-10-29'),(6,4,'(주) 현대미포조선 용연공장','울산 남구 처용로 800 (황성동)','2024-10-29'),(7,4,'(주) 현대미포조선 모화공장','경북 경주시 외동읍 문산리 804-3 ','2024-10-29'),(8,4,'(주) 현대미포조선 온산공장','울산 울주군 온산읍 산암로 487','2024-10-29'),(9,3,'(주) 넥센','경남 김해시 김해대로 2595 (안동)','2024-10-29'),(10,2,'현대자동차(주) 울산공장','울산 북구 염포로 700 (양정동)','2024-10-29'),(15,7,'(주)동헌레미콘','부산 강서구 명동길 47 (지사동) 2층','2024-11-20'),(30,53,'다모야 부산지점','부산진구 동평로 291번길 30 (103-403)','2024-11-21'),(31,54,'S-OIL 온산공장','울산 울주군 온산읍 온산로 68','2024-12-03');
/*!40000 ALTER TABLE `workplace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ensolution'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `reset_is_completed_all_cycles` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8mb4 */ ;;
/*!50003 SET character_set_results = utf8mb4 */ ;;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `reset_is_completed_all_cycles` ON SCHEDULE EVERY 1 DAY STARTS '2024-12-10 20:12:52' ON COMPLETION NOT PRESERVE ENABLE DO UPDATE stack_measurement
SET is_completed = 0
WHERE (cycle_type = 'montly' AND DATE_ADD(CURRENT_DATE, INTERVAL -1 DAY) = LAST_DAY(DATE_ADD(CURRENT_DATE, INTERVAL -1 MONTH)))
   OR (cycle_type = 'quarterly' AND MONTH(DATE_ADD(CURRENT_DATE, INTERVAL -1 DAY)) IN (3, 6, 9, 12) AND DATE_ADD(CURRENT_DATE, INTERVAL -1 DAY) = LAST_DAY(DATE_ADD(CURRENT_DATE, INTERVAL -1 MONTH)))
   OR (cycle_type = 'semiannual' AND MONTH(DATE_ADD(CURRENT_DATE, INTERVAL -1 DAY)) IN (6, 12) AND DATE_ADD(CURRENT_DATE, INTERVAL -1 DAY) = LAST_DAY(DATE_ADD(CURRENT_DATE, INTERVAL -1 MONTH)))
   OR (cycle_type = 'annual' AND DATE_ADD(CURRENT_DATE, INTERVAL -1 DAY) = '2024-12-31') */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'ensolution'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-20 20:37:46
