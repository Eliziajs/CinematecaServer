CREATE TABLE IF NOT EXISTS `cadastro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `data` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)

);







