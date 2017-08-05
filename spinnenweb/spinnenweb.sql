CREATE DATABASE  IF NOT EXISTS `spinnenweb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `spinnenweb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: spinnenweb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  `actief` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `naam_UNIQUE` (`naam`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categorie_evaluatie`
--

DROP TABLE IF EXISTS `categorie_evaluatie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorie_evaluatie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `categorie_id` bigint(20) NOT NULL,
  `evaluatiedocument_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categorieevaluatie_evaluatiedocument_idx` (`evaluatiedocument_id`),
  KEY `categorieevaluatie_categorie_idx` (`categorie_id`),
  CONSTRAINT `categorieevaluatie_categorie` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `categorieevaluatie_evaluatiedocument` FOREIGN KEY (`evaluatiedocument_id`) REFERENCES `evaluatiedocument` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `evaluatiedocument`
--

DROP TABLE IF EXISTS `evaluatiedocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluatiedocument` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `persoon_id` bigint(20) NOT NULL,
  `evaluatiedoel` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `evaluatiedocument_persoon_idx` (`persoon_id`),
  CONSTRAINT `evaluatiedocument_persoon` FOREIGN KEY (`persoon_id`) REFERENCES `persoon` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `persoon`
--

DROP TABLE IF EXISTS `persoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persoon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naam` varchar(100) NOT NULL,
  `persoon_type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `persoon_tag`
--

DROP TABLE IF EXISTS `persoon_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persoon_tag` (
  `persoon_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`persoon_id`,`tag_id`),
  KEY `persoontag_tag_idx` (`tag_id`),
  CONSTRAINT `persoontag_persoon` FOREIGN KEY (`persoon_id`) REFERENCES `persoon` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `persoontag_tag` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subcategorie_id` bigint(20) NOT NULL,
  `naam` varchar(45) NOT NULL,
  `actief` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `naam_UNIQUE` (`subcategorie_id`,`naam`),
  KEY `skill_subcategorie_idx` (`subcategorie_id`),
  CONSTRAINT `skill_subcategorie` FOREIGN KEY (`subcategorie_id`) REFERENCES `subcategorie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `skill_evaluatie`
--

DROP TABLE IF EXISTS `skill_evaluatie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_evaluatie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subcategorie_evaluatie_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  `evaluatie_score` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `skillevaluatie_subcategorieevaluatie_idx` (`subcategorie_evaluatie_id`),
  KEY `skillevaluatie_skill_idx` (`skill_id`),
  CONSTRAINT `skillevaluatie_skill` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `skillevaluatie_subcategorieevaluatie` FOREIGN KEY (`subcategorie_evaluatie_id`) REFERENCES `subcategorie_evaluatie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1322 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subcategorie`
--

DROP TABLE IF EXISTS `subcategorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategorie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `categorie_id` bigint(20) NOT NULL,
  `naam` varchar(45) NOT NULL,
  `actief` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `naam_UNIQUE` (`naam`),
  KEY `subcategorie_categorie_idx` (`categorie_id`),
  CONSTRAINT `subcategorie_categorie` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subcategorie_evaluatie`
--

DROP TABLE IF EXISTS `subcategorie_evaluatie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategorie_evaluatie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subcategorie_id` bigint(20) NOT NULL,
  `categorie_evaluatie_id` bigint(20) NOT NULL,
  `evaluatie_score` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subcategorieevaluatie_subcategorie_idx` (`subcategorie_id`),
  KEY `subcategorieevaluatie_categorieevaluatie_idx` (`categorie_evaluatie_id`),
  CONSTRAINT `subcategorieevaluatie_categorieevaluatie` FOREIGN KEY (`categorie_evaluatie_id`) REFERENCES `categorie_evaluatie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `subcategorieevaluatie_subcategorie` FOREIGN KEY (`subcategorie_id`) REFERENCES `subcategorie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=432 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-13 19:53:33
