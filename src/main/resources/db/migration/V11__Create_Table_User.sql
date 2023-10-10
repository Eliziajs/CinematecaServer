CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` datetime(6) DEFAULT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `nascimento` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) UNIQUE DEFAULT NULL,
  `status` int DEFAULT NULL,
  `sobrenome` varchar(255) NOT NULL,

  PRIMARY KEY (`id`)

)







