SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
`id` INT(255) NOT NULL AUTO_INCREMENT,
`username` VARCHAR(255) CHARACTER SET utf8,
`gender` INT,
`birthday` Date,
`address` VARCHAR(255) CHARACTER SET utf8,
`email` VARCHAR(255),
`community` VARCHAR(255) CHARACTER SET utf8,
`org` VARCHAR(255) CHARACTER SET utf8,
`passwd` VARCHAR(255),
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='用户表';

SET FOREIGN_KEY_CHECKS = 1;