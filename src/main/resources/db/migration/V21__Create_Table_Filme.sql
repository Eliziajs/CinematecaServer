CREATE TABLE IF NOT EXISTS `filme` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `ano` int(4) DEFAULT NULL,
  `sinopse` varchar(255) NOT NULL,
  `data` date NOT NULL,
  `genero_id` bigint DEFAULT NULL,
  `diretor_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY  (`diretor_id`),
  KEY (`genero_id`),
  KEY (`user_id`),
  CONSTRAINT  FOREIGN KEY (`genero_id`) REFERENCES `genero` (`id`),
  CONSTRAINT FOREIGN KEY (`diretor_id`) REFERENCES `diretor` (`id`),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)





)





