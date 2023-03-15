
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mc87q8fpvldpdyfo9o5633o5l` (`email`)
);








