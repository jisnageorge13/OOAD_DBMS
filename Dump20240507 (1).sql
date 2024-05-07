CREATE DATABASE  IF NOT EXISTS `planningpoker` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `planningpoker`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: planningpoker
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards` (
  `card_id` int NOT NULL AUTO_INCREMENT,
  `value` int NOT NULL,
  `description` text,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (1,1,'Story points 1'),(2,2,'Story points 2'),(3,3,'Story points 3'),(4,5,'Story points 5'),(5,8,'Story points 8'),(6,13,'Story points 13');
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_first_name` varchar(30) NOT NULL,
  `employee_last_name` varchar(30) NOT NULL,
  `sex` enum('M','F') DEFAULT NULL,
  `role` varchar(30) DEFAULT NULL,
  `created_by` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int NOT NULL,
  `updated_date` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Jerin','Jacob','M','HR',1,'2014-09-03',1,'2020-07-18'),(2,'Joyal','Joseph','M','Scrum Master',1,'2020-09-01',1,'2024-01-14'),(3,'Sreeram','B','M','Team Lead',1,'2021-11-10',1,'2022-02-12'),(4,'Melinda','Mary','F','Project Manager',1,'2020-07-23',1,'2023-06-29'),(5,'Reshmi','M','F','Developer',1,'2022-02-24',1,'2021-05-11'),(6,'Dharsan','C','M','Developer',1,'2022-06-19',1,'2023-10-30'),(7,'Adithya','S','F','Developer',1,'2019-04-01',1,'2022-04-15'),(8,'Arjun','T','M','Developer',1,'2016-07-07',1,'2018-12-22');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `epics`
--

DROP TABLE IF EXISTS `epics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `epics` (
  `epic_id` int NOT NULL AUTO_INCREMENT,
  `epic_name` varchar(50) NOT NULL,
  `description` text,
  `project_id` int NOT NULL,
  `created_by` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int NOT NULL,
  `updated_date` date DEFAULT NULL,
  PRIMARY KEY (`epic_id`),
  KEY `project_id` (`project_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `epics_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`),
  CONSTRAINT `epics_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `epics_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `epics`
--

LOCK TABLES `epics` WRITE;
/*!40000 ALTER TABLE `epics` DISABLE KEYS */;
INSERT INTO `epics` VALUES (1,'Customer Authentication','Implement customer authentication',1,2,'2024-02-11',1,'2024-02-22'),(2,'Order Management','Manage orders and deliveries',1,2,'2024-02-17',1,'2024-02-23'),(3,'Account Management','Manage customer accounts',2,2,'2024-01-13',1,'2024-03-10'),(4,'User Authentication','Implement secure user authentication',2,2,'2024-05-03',2,'2024-05-03'),(5,'Transaction Management','Allow users to perform transactions',2,3,'2024-05-03',3,'2024-05-03');
/*!40000 ALTER TABLE `epics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) NOT NULL,
  `description` text,
  `created_by` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int NOT NULL,
  `updated_date` date DEFAULT NULL,
  `status` enum('Active','Completed','Cancelled') NOT NULL,
  PRIMARY KEY (`project_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `projects_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `projects_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Food Delivery','Online platform for food delivery service',4,'2024-02-11',1,'2024-03-15','Active'),(2,'Banking App','Mobile application for banking services',4,'2024-01-13',1,'2024-02-12','Active'),(3,'E-Learning Website','Online platform for learning',4,'2024-04-01',1,'2024-04-15','Completed');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sprints`
--

DROP TABLE IF EXISTS `sprints`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sprints` (
  `sprint_id` int NOT NULL AUTO_INCREMENT,
  `sprint_name` varchar(30) NOT NULL,
  `epic_id` int NOT NULL,
  `created_by` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int NOT NULL,
  `updated_date` date DEFAULT NULL,
  `status` enum('Active','Inactive','Completed') NOT NULL,
  PRIMARY KEY (`sprint_id`),
  KEY `epic_id` (`epic_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `sprints_ibfk_1` FOREIGN KEY (`epic_id`) REFERENCES `epics` (`epic_id`),
  CONSTRAINT `sprints_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `sprints_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprints`
--

LOCK TABLES `sprints` WRITE;
/*!40000 ALTER TABLE `sprints` DISABLE KEYS */;
INSERT INTO `sprints` VALUES (1,'Sprint 1',1,2,'2024-02-11',2,'2024-05-28','Active'),(2,'Sprint 1',1,2,'2024-02-11',2,'2024-05-28','Active'),(3,'Sprint 2',2,2,'2024-02-03',2,'2024-03-30','Inactive'),(4,'sprint 1',1,4,'2024-02-01',4,'2024-02-15','Active'),(5,'Sprint 2',1,3,'2024-03-11',2,'2024-04-11','Inactive'),(8,'Sprint 2',4,4,'2024-05-03',4,'2024-05-03','Active'),(9,'Sprint 2',5,4,'2024-05-03',4,'2024-05-03','Active');
/*!40000 ALTER TABLE `sprints` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_story`
--

DROP TABLE IF EXISTS `user_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_story` (
  `story_id` int NOT NULL AUTO_INCREMENT,
  `description` text,
  `sprint_id` int NOT NULL,
  `card_id` int NOT NULL,
  `conducted_by` int NOT NULL,
  `assigned_to` int NOT NULL,
  `story_points` int NOT NULL,
  `estimated_time` int NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `created_by` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int NOT NULL,
  `updated_date` date DEFAULT NULL,
  `status` enum('To Do','In Progress','Done') NOT NULL,
  PRIMARY KEY (`story_id`),
  KEY `sprint_id` (`sprint_id`),
  KEY `card_id` (`card_id`),
  KEY `conducted_by` (`conducted_by`),
  KEY `assigned_to` (`assigned_to`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `user_story_ibfk_1` FOREIGN KEY (`sprint_id`) REFERENCES `sprints` (`sprint_id`),
  CONSTRAINT `user_story_ibfk_2` FOREIGN KEY (`card_id`) REFERENCES `cards` (`card_id`),
  CONSTRAINT `user_story_ibfk_3` FOREIGN KEY (`conducted_by`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `user_story_ibfk_4` FOREIGN KEY (`assigned_to`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `user_story_ibfk_5` FOREIGN KEY (`created_by`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `user_story_ibfk_6` FOREIGN KEY (`updated_by`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_story`
--

LOCK TABLES `user_story` WRITE;
/*!40000 ALTER TABLE `user_story` DISABLE KEYS */;
INSERT INTO `user_story` VALUES (1,'Implement customer registration',1,1,2,5,5,8,'2024-02-11','2024-05-22',4,'2024-02-11',4,'2024-04-30','In Progress'),(2,'Implement forgot password option',1,2,2,7,3,5,'2024-02-11','2024-05-23',4,'2024-02-27',4,'2024-03-13','To Do'),(3,'Implement account settings',8,3,2,8,8,13,'2024-02-04','2024-03-10',1,'2024-02-03',1,'2024-02-11','Done'),(6,'Implement login page',9,3,1,3,3,5,'2024-05-03','2024-05-08',2,NULL,2,'2024-05-03','In Progress');
/*!40000 ALTER TABLE `user_story` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 15:11:50
