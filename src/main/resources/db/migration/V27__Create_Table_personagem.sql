CREATE TABLE IF NOT EXISTS `personagem` (
  `nome` varchar(255) DEFAULT NULL,
  `filme_id` bigint NOT NULL,
  `ator_id` bigint NOT NULL,
  PRIMARY KEY (`ator_id`,`filme_id`),
  KEY (`filme_id`),
  CONSTRAINT FOREIGN KEY (`filme_id`) REFERENCES `filme` (`id`),
  CONSTRAINT FOREIGN KEY (`ator_id`) REFERENCES `ator` (`id`)
)


