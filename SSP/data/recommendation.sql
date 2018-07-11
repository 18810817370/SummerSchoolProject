

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `recommendation`;

CREATE TABLE `recommendation` (
`id` INT(255) NOT NULL AUTO_INCREMENT,
`author` VARCHAR(255) CHARACTER SET utf8,
`target` VARCHAR(255) CHARACTER SET utf8,
`content` VARCHAR(1023) CHARACTER SET utf8,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=latin1 COMMENT='推荐表';

SET FOREIGN_KEY_CHECKS = 1;

