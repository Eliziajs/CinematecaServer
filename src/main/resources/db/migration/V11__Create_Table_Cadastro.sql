
CREATE TABLE IF NOT EXISTS `cadastro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)

);








