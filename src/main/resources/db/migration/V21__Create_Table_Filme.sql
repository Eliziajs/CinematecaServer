
CREATE TABLE IF NOT EXISTS `filme` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `ano` int(4) DEFAULT NULL,
  `sinopse` varchar(255) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`)

);








