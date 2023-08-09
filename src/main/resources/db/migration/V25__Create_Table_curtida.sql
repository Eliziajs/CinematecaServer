CREATE TABLE `curtida` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantidade` bigint DEFAULT NULL,
  `data` date DEFAULT NULL,
  `filme_id` bigint DEFAULT NULL,
  `person_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY  (`filme_id`),
  KEY  (`person_id`),
  CONSTRAINT  FOREIGN KEY (`filme_id`) REFERENCES `filme` (`id`),
  CONSTRAINT  FOREIGN KEY (`person_id`) REFERENCES `pessoa` (`id`)
)




