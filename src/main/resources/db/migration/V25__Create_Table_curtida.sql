CREATE TABLE IF NOT EXISTS `curtida` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantidade` bigint DEFAULT NULL,
  `data` date DEFAULT NULL,
  `filme_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY  (`filme_id`),
  KEY  (`user_id`),
  CONSTRAINT  FOREIGN KEY (`filme_id`) REFERENCES `filme` (`id`),
  CONSTRAINT  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)




