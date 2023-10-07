CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
   `password` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `nascimento` date NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `status` int DEFAULT NULL,
  `data` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)

);







