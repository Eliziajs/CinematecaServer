CREATE TABLE IF NOT EXISTS `user_filme` (
    `user_id` bigint NOT NULL,
    `filme_id` bigint NOT NULL,
    KEY  (`filme_id`),
    KEY (`user_id`),
    CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT  FOREIGN KEY (`filme_id`) REFERENCES `filme` (`id`)

  )