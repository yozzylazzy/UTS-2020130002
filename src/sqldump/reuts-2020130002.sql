-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: uts-2020130002
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detail_equip_set`
--

DROP TABLE IF EXISTS `detail_equip_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_equip_set` (
  `SET_EQUIP_ID` char(10) DEFAULT NULL,
  `EQUIPMENT_ID` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_equip_set`
--

LOCK TABLES `detail_equip_set` WRITE;
/*!40000 ALTER TABLE `detail_equip_set` DISABLE KEYS */;
INSERT INTO `detail_equip_set` VALUES ('ES000001AA','W00001'),('ES000001AA','E00001'),('ES000002AA','W00002'),('ES000002AA','A00002'),('ES000002AA','E00002'),('ES000003AA','W00003'),('ES000003AA','A00003'),('ES000003AA','E00003'),('ES000004AA','W00004'),('ES000004AA','A00004'),('ES000004AA','E00004'),('ES000005AA','W00005'),('ES000005AA','A00005'),('ES000005AA','E00005'),('ES000006AA','W00006'),('ES000006AA','A00006'),('ES000006AA','E00006'),('ES000007AA','W00007'),('ES000007AA','A00007'),('ES000007AA','E00007'),('ES000008AA','W00008'),('ES000008AA','A00008'),('ES000008AA','E00008'),('ES000009AA','W00009'),('ES000009AA','A00009'),('ES000009AA','E00009'),('ES000010AA','W00010'),('ES000010AA','A00010'),('ES000010AA','E00010'),('ES000001AA','A00001'),('TES100001','TES00001'),('TSTWO0002','TSBE0001'),('TES300003','Tes00003');
/*!40000 ALTER TABLE `detail_equip_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_set_efek`
--

DROP TABLE IF EXISTS `detail_set_efek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_set_efek` (
  `SET_EQUIP_ID` char(10) DEFAULT NULL,
  `EFEK_ID` char(10) DEFAULT NULL,
  `ITEM_SET` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_set_efek`
--

LOCK TABLES `detail_set_efek` WRITE;
/*!40000 ALTER TABLE `detail_set_efek` DISABLE KEYS */;
INSERT INTO `detail_set_efek` VALUES ('ES000001AA','E0000001AA',2),('ES000002AA','E0000002AA',2),('ES000003AA','E0000003AA',2),('ES000004AA','E0000004AA',2),('ES000005AA','E0000005AA',2),('ES000006AA','E0000006AA',2),('ES000007AA','E0000007AA',2),('ES000008AA','E0000008AA',2),('ES000009AA','E0000009AA',2),('ES000010AA','E0000010AA',2),('ES000001AA','E0000001AB',3),('ES000002AA','E0000002AB',3),('ES000003AA','E0000003AB',3),('ES000004AA','E0000004AB',3),('ES000005AA','E0000005AB',3),('ES000006AA','E0000006AB',3),('ES000007AA','E0000007AB',3),('ES000008AA','E0000008AB',3),('ES000009AA','E0000009AB',3),('ES000010AA','E0000010AB',3),('TES100001','TSONE0001',1),('TSTWO0002','TWO0002',1),('TES300003','THREE003',1);
/*!40000 ALTER TABLE `detail_set_efek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `efek`
--

DROP TABLE IF EXISTS `efek`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `efek` (
  `EFEK_ID` char(10) NOT NULL,
  `ATK` int DEFAULT NULL,
  `MATK` int DEFAULT NULL,
  `HP` int DEFAULT NULL,
  `MP` int DEFAULT NULL,
  `DEF` int DEFAULT NULL,
  `MDEF` int DEFAULT NULL,
  `HIT` int DEFAULT NULL,
  `ASPD` int DEFAULT NULL,
  `CSPD` int DEFAULT NULL,
  `CRITICAL_RATE` int DEFAULT NULL,
  `CRITICAL_DAMAGE` int DEFAULT NULL,
  PRIMARY KEY (`EFEK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `efek`
--

LOCK TABLES `efek` WRITE;
/*!40000 ALTER TABLE `efek` DISABLE KEYS */;
INSERT INTO `efek` VALUES ('E0000001AA',1,1,1,0,0,0,0,0,0,0,0),('E0000001AB',2,2,2,0,0,0,0,0,0,0,0),('E0000002AA',2,2,2,0,0,0,0,0,0,0,0),('E0000002AB',4,4,4,0,0,0,0,0,0,0,0),('E0000003AA',2,0,1,3,0,0,0,0,0,0,0),('E0000003AB',4,0,2,6,0,0,0,0,0,6,0),('E0000004AA',2,2,1,1,1,0,0,0,0,0,0),('E0000004AB',4,4,2,2,2,0,0,0,0,2,0),('E0000005AA',3,0,0,3,0,3,0,0,0,0,0),('E0000005AB',6,0,0,6,0,6,0,0,0,6,6),('E0000006AA',0,5,0,0,5,0,0,0,0,0,0),('E0000006AB',0,10,0,0,10,0,0,0,0,0,0),('E0000007AA',3,0,3,0,0,2,0,0,0,0,0),('E0000007AB',6,0,6,0,0,4,0,0,0,0,4),('E0000008AA',2,0,1,0,7,0,0,0,0,0,0),('E0000008AB',4,0,10,0,10,5,0,0,0,0,0),('E0000009AA',0,7,0,0,3,0,0,0,0,0,0),('E0000009AB',0,9,0,0,6,0,0,0,0,0,0),('E0000010AA',2,0,0,0,5,3,0,0,0,0,0),('E0000010AB',4,0,0,0,10,6,0,0,0,0,6),('THREE003',9,0,10,0,0,0,0,0,0,0,10),('TSONE0001',3,2,0,6,0,3,0,0,0,0,0),('TWO0002',10,0,0,0,0,0,10,0,0,0,10);
/*!40000 ALTER TABLE `efek` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_set`
--

DROP TABLE IF EXISTS `equipment_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment_set` (
  `SET_EQUIP_ID` char(10) NOT NULL,
  `SET_NAME` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`SET_EQUIP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_set`
--

LOCK TABLES `equipment_set` WRITE;
/*!40000 ALTER TABLE `equipment_set` DISABLE KEYS */;
INSERT INTO `equipment_set` VALUES ('ES000001AA','Newcomer Rage'),('ES000002AA','Leather Burnt'),('ES000003AA','Cotton Burnt'),('ES000004AA','Adventurer Rage'),('ES000005AA','Fighter Rage'),('ES000006AA','Mage Smirk'),('ES000007AA','Warrior Rage'),('ES000008AA','Gladiator Rage'),('ES000009AA','Wizard Master'),('ES000010AA','Hunter x Hunter'),('TES100001','Testingone'),('TES300003','TESTHREEEFEK'),('TSTWO0002','TESTWOFEK');
/*!40000 ALTER TABLE `equipment_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipments`
--

DROP TABLE IF EXISTS `equipments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipments` (
  `EQUIPMENT_ID` char(10) NOT NULL,
  `EQUIPMENT_TYPE` varchar(20) DEFAULT NULL,
  `EQUIPMENT_NAME` varchar(60) DEFAULT NULL,
  `EQUIPMENT_RARITY` int DEFAULT NULL,
  `STR` int DEFAULT NULL,
  `INTL` int DEFAULT NULL,
  `VIT` int DEFAULT NULL,
  `AGI` int DEFAULT NULL,
  `DEX` int DEFAULT NULL,
  `CRIT` int DEFAULT NULL,
  PRIMARY KEY (`EQUIPMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipments`
--

LOCK TABLES `equipments` WRITE;
/*!40000 ALTER TABLE `equipments` DISABLE KEYS */;
INSERT INTO `equipments` VALUES ('A00001','Armor','Newcomer Garb',1,13,1,1,0,0,0),('A00002','Armor','Leather Cloth',1,2,2,2,0,0,0),('A00003','Armor','Cotton Armor',1,2,0,1,3,0,0),('A00004','Armor','Adventurer Garb',2,2,2,1,1,1,0),('A00005','Armor','Fighter Uniform',2,3,0,0,3,0,3),('A00006','Armor','Mage Robe',2,0,5,0,0,5,0),('A00007','Armor','Warrior Mail',3,3,1,3,0,0,2),('A00008','Armor','Gladiator Armor',3,2,0,10,0,7,0),('A00009','Armor','Wizard Robe',3,0,7,0,0,3,0),('A00010','Armor','Hunter Garb',3,2,0,0,0,5,3),('E00001','Belt','Newcomer Belt',1,1,1,1,0,0,0),('E00002','Belt','Leather Belt',1,2,2,2,0,0,0),('E00003','Belt','Cotton Belt',1,2,0,1,3,0,0),('E00004','Belt','Adventurer Belt',2,2,2,1,1,1,0),('E00005','Belt','Fighter Belt',2,3,0,0,3,0,3),('E00006','Belt','Mage Belt',2,0,5,0,0,5,0),('E00007','Belt','Warrior Belt',3,3,0,3,0,0,2),('E00008','Belt','Gladiator Belt',3,2,0,10,0,7,0),('E00009','Belt','Wizard Belt',3,0,7,0,0,3,0),('E00010','Belt','Hunter Pouch',3,2,0,0,0,5,3),('TES00001','Armor','tesarmor',1,6,14,4,14,3,3),('Tes00003','Weapon','Weapptess',3,14,0,29,0,22,26),('tessssss','Belt','testing123',1,30,0,0,0,0,0),('TSBE0001','Belt','awdd',2,13,2,4,3,0,0),('W00001','Weapon','Newcomer Sword',1,1,1,1,0,0,0),('W00002','Weapon','Leather Sword',1,2,2,2,0,0,0),('W00003','Weapon','Cotton Sword',1,2,0,1,3,0,0),('W00004','Weapon','Adventurer Bow',2,2,2,1,1,1,0),('W00005','Weapon','Fighter Sword',2,3,0,0,3,0,3),('W00006','Weapon','Mage Staff',2,0,5,0,0,5,0),('W00007','Weapon','Warrior Sword',3,3,0,3,0,0,2),('W00008','Weapon','Gladiator Sword',3,2,0,10,0,7,0),('W00009','Weapon','Wizard Staff',3,0,7,0,0,3,0),('W00010','Weapon','Hunter Bow',3,2,0,0,1,5,3);
/*!40000 ALTER TABLE `equipments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-10 10:58:42
