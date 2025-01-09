-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: gestaoeventos
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `id_Evento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `localizacao` varchar(45) DEFAULT NULL,
  `data_` date DEFAULT NULL,
  `organizadores` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id_Evento`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Conferência de Negócios','Maputo','2024-03-15','Câmara de Comércio'),(2,'Workshop de Tecnologia','Beira','2024-04-10','Tech Mozambique'),(3,'Seminário de Saúde','Nampula','2024-05-20','Ministério da Saúde'),(4,'Feira de Educação','Quelimane','2024-06-25','Educação para Todos'),(5,'Conferência de Negócios','Maputo','2024-03-15','Câmara de Comércio'),(6,'Workshop de Tecnologia','Beira','2024-04-10','Tech Mozambique'),(7,'Seminário de Saúde','Nampula','2024-05-20','Ministério da Saúde'),(8,'Feira de Educação','Quelimane','2024-06-25','Educação para Todos'),(9,'Feira de Agricultura','Xai-Xai','2024-07-10','Agro Mozambique'),(10,'Workshop de Energia','Tete','2024-08-15','Energy Solutions'),(11,'Conferência de Turismo','Inhambane','2024-09-05','Tourism Board'),(12,'Seminário de Meio Ambiente','Chimoio','2024-10-20','Green Earth'),(13,'Feira de Agricultura','Xai-Xai','2024-07-10','Agro Mozambique'),(14,'Workshop de Energia','Tete','2024-08-15','Energy Solutions'),(15,'Conferência de Turismo','Inhambane','2024-09-05','Tourism Board'),(16,'Seminário de Meio Ambiente','Chimoio','2024-10-20','Green Earth');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incricoes`
--

DROP TABLE IF EXISTS `incricoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incricoes` (
  `id_Participante` int NOT NULL,
  `id_Evento` int NOT NULL,
  `nomeEvento` varchar(45) DEFAULT NULL,
  `nomeParticipante` varchar(45) DEFAULT NULL,
  `dataIncricao` date DEFAULT NULL,
  `tipo_bilhete` varchar(15) DEFAULT NULL,
  `statusIncricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Participante`,`id_Evento`),
  KEY `id_Evento` (`id_Evento`),
  CONSTRAINT `incricoes_ibfk_1` FOREIGN KEY (`id_Participante`) REFERENCES `participante` (`id_Participante`),
  CONSTRAINT `incricoes_ibfk_2` FOREIGN KEY (`id_Evento`) REFERENCES `evento` (`id_Evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incricoes`
--

LOCK TABLES `incricoes` WRITE;
/*!40000 ALTER TABLE `incricoes` DISABLE KEYS */;
INSERT INTO `incricoes` VALUES (1,1,'Conferência de Negócios','Joaquim Mondlane','2024-01-10','VIP','Confirmado'),(1,2,'Workshop de Tecnologia','Joaquim Mondlane','2024-02-05','Normal','Confirmado'),(1,3,'Seminário de Saúde','Joaquim Mondlane','2024-03-05','VIP','Confirmado'),(1,4,'Feira de Educação','Joaquim Mondlane','2024-04-05','VIP','Confirmado'),(1,9,'Feira de Agricultura','Joaquim Mondlane','2024-06-15','VIP','Confirmado'),(1,14,'Workshop de Energia','Joaquim Mondlane','2024-08-15','VIP','Confirmado'),(2,1,'Conferência de Negócios','Ana Machel','2024-01-12','Normal','Pendente'),(2,2,'Workshop de Tecnologia','Ana Machel','2024-02-07','VIP','Confirmado'),(2,3,'Seminário de Saúde','Ana Machel','2024-03-07','VIP','Confirmado'),(2,4,'Feira de Educação','Ana Machel','2024-04-07','Normal','Pendente'),(2,9,'Feira de Agricultura','Ana Machel','2024-06-16','Normal','Pendente'),(2,14,'Workshop de Energia','Ana Machel','2024-08-16','Normal','Pendente'),(3,1,'Conferência de Negócios','Carlos Manhique','2024-01-15','VIP','Confirmado'),(3,2,'Workshop de Tecnologia','Carlos Manhique','2024-02-10','VIP','Confirmado'),(3,3,'Seminário de Saúde','Carlos Manhique','2024-03-10','VIP','Confirmado'),(3,4,'Feira de Educação','Carlos Manhique','2024-04-10','VIP','Confirmado'),(3,10,'Workshop de Energia','Carlos Manhique','2024-07-01','Normal','Pendente'),(3,15,'Conferência de Turismo','Carlos Manhique','2024-09-05','VIP','Confirmado'),(4,1,'Conferência de Negócios','Lourdes Mondlane','2024-01-18','Normal','Pendente'),(4,2,'Workshop de Tecnologia','Lourdes Mondlane','2024-02-12','Normal','Pendente'),(4,3,'Seminário de Saúde','Lourdes Mondlane','2024-03-12','Normal','Pendente'),(4,4,'Feira de Educação','Lourdes Mondlane','2024-04-12','Normal','Pendente'),(4,10,'Workshop de Energia','Lourdes Mondlane','2024-07-02','VIP','Confirmado'),(4,15,'Conferência de Turismo','Lourdes Mondlane','2024-09-06','Normal','Pendente'),(5,1,'Conferência de Negócios','José Muchanga','2024-01-20','VIP','Confirmado'),(5,2,'Workshop de Tecnologia','José Muchanga','2024-02-15','VIP','Confirmado'),(5,3,'Seminário de Saúde','José Muchanga','2024-03-15','VIP','Confirmado'),(5,4,'Feira de Educação','José Muchanga','2024-04-15','VIP','Confirmado'),(5,11,'Conferência de Turismo','José Muchanga','2024-08-01','VIP','Confirmado'),(5,16,'Seminário de Meio Ambiente','José Muchanga','2024-10-20','VIP','Confirmado'),(6,1,'Conferência de Negócios','Rosa Malengane','2024-01-22','Normal','Pendente'),(6,2,'Workshop de Tecnologia','Rosa Malengane','2024-02-18','Normal','Pendente'),(6,3,'Seminário de Saúde','Rosa Malengane','2024-03-18','Normal','Pendente'),(6,4,'Feira de Educação','Rosa Malengane','2024-04-18','Normal','Pendente'),(6,11,'Conferência de Turismo','Rosa Malengane','2024-08-02','Normal','Pendente'),(6,16,'Seminário de Meio Ambiente','Rosa Malengane','2024-10-21','Normal','Pendente'),(7,1,'Conferência de Negócios','Manuel Zandamela','2024-01-25','VIP','Confirmado'),(7,2,'Workshop de Tecnologia','Manuel Zandamela','2024-02-20','VIP','Confirmado'),(7,3,'Seminário de Saúde','Manuel Zandamela','2024-03-20','VIP','Confirmado'),(7,4,'Feira de Educação','Manuel Zandamela','2024-04-20','VIP','Confirmado'),(7,12,'Seminário de Meio Ambiente','Manuel Zandamela','2024-09-20','Normal','Pendente'),(7,16,'Seminário de Meio Ambiente','Manuel Zandamela','2024-10-22','VIP','Confirmado'),(8,1,'Conferência de Negócios','Fátima Machava','2024-01-28','VIP','Confirmado'),(8,2,'Workshop de Tecnologia','Fátima Machava','2024-02-22','Normal','Pendente'),(8,3,'Seminário de Saúde','Fátima Machava','2024-03-22','Normal','Pendente'),(8,4,'Feira de Educação','Fátima Machava','2024-04-22','Normal','Pendente'),(8,12,'Seminário de Meio Ambiente','Fátima Machava','2024-09-21','VIP','Confirmado'),(8,16,'Seminário de Meio Ambiente','Fátima Machava','2024-10-23','Normal','Pendente'),(9,1,'Conferência de Negócios','Afonso Tembe','2024-01-30','VIP','Confirmado'),(9,2,'Workshop de Tecnologia','Afonso Tembe','2024-02-25','VIP','Confirmado'),(9,3,'Seminário de Saúde','Afonso Tembe','2024-03-25','VIP','Confirmado'),(9,4,'Feira de Educação','Afonso Tembe','2024-04-25','VIP','Confirmado'),(9,13,'Feira de Agricultura','Afonso Tembe','2024-07-10','Normal','Pendente'),(9,16,'Seminário de Meio Ambiente','Afonso Tembe','2024-10-24','VIP','Confirmado'),(10,1,'Conferência de Negócios','Luciana Chongo','2024-02-02','VIP','Pendente'),(10,2,'Workshop de Tecnologia','Luciana Chongo','2024-02-28','Normal','Pendente'),(10,3,'Seminário de Saúde','Luciana Chongo','2024-03-28','Normal','Pendente'),(10,4,'Feira de Educação','Luciana Chongo','2024-04-28','Normal','Pendente'),(10,13,'Feira de Agricultura','Luciana Chongo','2024-07-11','VIP','Confirmado'),(10,16,'Seminário de Meio Ambiente','Luciana Chongo','2024-10-25','Normal','Pendente'),(11,5,'Feira de Agricultura','Joaquim Mondlane','2024-06-15','VIP','Confirmado'),(11,7,'Conferência de Turismo','Joaquim Mondlane','2024-08-01','VIP','Confirmado'),(12,5,'Feira de Agricultura','Ana Machel','2024-06-16','Normal','Pendente'),(12,7,'Conferência de Turismo','Ana Machel','2024-08-02','Normal','Pendente'),(13,5,'Feira de Agricultura','Carlos Manhique','2024-06-17','VIP','Confirmado'),(13,7,'Conferência de Turismo','Carlos Manhique','2024-08-03','VIP','Confirmado'),(14,5,'Feira de Agricultura','Lourdes Mondlane','2024-06-18','Normal','Pendente'),(14,7,'Conferência de Turismo','Lourdes Mondlane','2024-08-04','Normal','Pendente'),(15,5,'Feira de Agricultura','José Muchanga','2024-06-19','VIP','Confirmado'),(15,7,'Conferência de Turismo','José Muchanga','2024-08-05','VIP','Confirmado'),(16,6,'Workshop de Energia','Rosa Malengane','2024-07-01','Normal','Pendente'),(16,8,'Seminário de Meio Ambiente','Rosa Malengane','2024-09-20','Normal','Pendente'),(17,6,'Workshop de Energia','Manuel Zandamela','2024-07-02','VIP','Confirmado'),(17,8,'Seminário de Meio Ambiente','Manuel Zandamela','2024-09-21','VIP','Confirmado'),(18,6,'Workshop de Energia','Fátima Machava','2024-07-03','Normal','Pendente'),(18,8,'Seminário de Meio Ambiente','Fátima Machava','2024-09-22','Normal','Pendente'),(19,6,'Workshop de Energia','Afonso Tembe','2024-07-04','VIP','Confirmado'),(19,8,'Seminário de Meio Ambiente','Afonso Tembe','2024-09-23','VIP','Confirmado'),(20,6,'Workshop de Energia','Luciana Chongo','2024-07-05','Normal','Pendente'),(20,8,'Seminário de Meio Ambiente','Luciana Chongo','2024-09-24','Normal','Pendente');
/*!40000 ALTER TABLE `incricoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante` (
  `id_Participante` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Participante`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (1,'Joaquim Mondlane','M','joaquim.mondlane@email.com','82-1234567','Maputo'),(2,'Ana Machel','F','ana.machel@email.com','82-2345678','Matola'),(3,'Carlos Manhique','M','carlos.manhique@email.com','82-3456789','Beira'),(4,'Lourdes Mondlane','F','lourdes.mondlane@email.com','82-4567890','Nampula'),(5,'José Muchanga','M','jose.muchanga@email.com','82-5678901','Quelimane'),(6,'Rosa Malengane','F','rosa.malengane@email.com','82-6789012','Chimoio'),(7,'Manuel Zandamela','M','manuel.zandamela@email.com','82-7890123','Tete'),(8,'Fátima Machava','F','fatima.machava@email.com','82-8901234','Xai-Xai'),(9,'Afonso Tembe','M','afonso.tembe@email.com','82-9012345','Inhambane'),(10,'Luciana Chongo','F','luciana.chongo@email.com','82-0123456','Pemba'),(11,'Joaquim Mondlane','M','joaquim.mondlane@email.com','82-1234567','Maputo'),(12,'Ana Machel','F','ana.machel@email.com','82-2345678','Matola'),(13,'Carlos Manhique','M','carlos.manhique@email.com','82-3456789','Beira'),(14,'Lourdes Mondlane','F','lourdes.mondlane@email.com','82-4567890','Nampula'),(15,'José Muchanga','M','jose.muchanga@email.com','82-5678901','Quelimane'),(16,'Rosa Malengane','F','rosa.malengane@email.com','82-6789012','Chimoio'),(17,'Manuel Zandamela','M','manuel.zandamela@email.com','82-7890123','Tete'),(18,'Fátima Machava','F','fatima.machava@email.com','82-8901234','Xai-Xai'),(19,'Afonso Tembe','M','afonso.tembe@email.com','82-9012345','Inhambane'),(20,'Luciana Chongo','F','luciana.chongo@email.com','82-0123456','Pemba'),(21,'Miguel Cossa','M','miguel.cossa@email.com','82-1112223','Maxixe'),(22,'Helena Rafael','F','helena.rafael@email.com','82-3334445','Quelimane'),(23,'Armando Muleta','M','armando.muleta@email.com','82-5556667','Chokwe'),(24,'Lina Chavana','F','lina.chavana@email.com','82-7778889','Inhambane'),(25,'Julio Semedo','M','julio.semedo@email.com','82-9991110','Lichinga'),(26,'Paula Zango','F','paula.zango@email.com','82-2223334','Gurue'),(27,'Dinis Mandlate','M','dinis.mandlate@email.com','82-4445556','Manica'),(28,'Graça Nhassengo','F','graca.nhassengo@email.com','82-6667778','Massinga'),(29,'Henrique Manjate','M','henrique.manjate@email.com','82-8889990','Montepuez'),(30,'Valeria Mahumane','F','valeria.mahumane@email.com','82-0001112','Cuamba'),(31,'Miguel Cossa','M','miguel.cossa@email.com','82-1112223','Maxixe'),(32,'Helena Rafael','F','helena.rafael@email.com','82-3334445','Quelimane'),(33,'Armando Muleta','M','armando.muleta@email.com','82-5556667','Chokwe'),(34,'Lina Chavana','F','lina.chavana@email.com','82-7778889','Inhambane'),(35,'Julio Semedo','M','julio.semedo@email.com','82-9991110','Lichinga'),(36,'Paula Zango','F','paula.zango@email.com','82-2223334','Gurue'),(37,'Dinis Mandlate','M','dinis.mandlate@email.com','82-4445556','Manica'),(38,'Graça Nhassengo','F','graca.nhassengo@email.com','82-6667778','Massinga'),(39,'Henrique Manjate','M','henrique.manjate@email.com','82-8889990','Montepuez'),(40,'Valeria Mahumane','F','valeria.mahumane@email.com','82-0001112','Cuamba');
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-15 22:27:44
