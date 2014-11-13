CREATE DATABASE  IF NOT EXISTS `rampa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `rampa`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: rampa
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `CODIGO` varchar(10) DEFAULT NULL,
  `CUOTA` double DEFAULT NULL,
  `DESCRIPCION` varchar(200) DEFAULT NULL,
  `FECHAINICIO` date DEFAULT NULL,
  `FECHAFIN` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CODIGO_UNIQUE` (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `CURSO` varchar(45) DEFAULT NULL,
  `OBSERVACIONES` varchar(200) DEFAULT NULL,
  `SOCIO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SOCIO_ID_idx` (`SOCIO_ID`),
  CONSTRAINT `SOCIO_ID` FOREIGN KEY (`SOCIO_ID`) REFERENCES `socio` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripcion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FECHAALTA` date DEFAULT NULL,
  `FECHABAJA` date DEFAULT NULL,
  `PAGOALDIA` binary(1) DEFAULT NULL,
  `ACTIVIDAD_ID` int(11) DEFAULT NULL,
  `ALUMNO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_idx` (`ACTIVIDAD_ID`),
  KEY `ID_ALUMNO_idx` (`ALUMNO_ID`),
  CONSTRAINT `ID_ACTIVIDAD` FOREIGN KEY (`ACTIVIDAD_ID`) REFERENCES `actividad` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_ALUMNO` FOREIGN KEY (`ALUMNO_ID`) REFERENCES `alumno` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NUMERO` int(11) DEFAULT NULL,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `APELLIDO1` varchar(45) DEFAULT NULL,
  `APELLIDO2` varchar(45) DEFAULT NULL,
  `DIRECCION` varchar(200) DEFAULT NULL,
  `TELEFONO` varchar(9) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-08 13:57:26
