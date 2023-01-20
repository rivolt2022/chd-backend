CREATE TABLE IF NOT EXISTS `translate`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `query` VARCHAR(500),
    `translation` VARCHAR(500),
    `created_at` DATETIME,
    `updated_at` DATETIME,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

