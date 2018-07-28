

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `proposal`;

CREATE TABLE `proposal` (
`ppid` INT(255) NOT NULL AUTO_INCREMENT,
`author` VARCHAR(255) CHARACTER SET utf8,
`ppname` VARCHAR(255) CHARACTER SET utf8,
`ppcontent` VARCHAR(1023) CHARACTER SET utf8,
`status` VARCHAR(255) DEFAULT 'NOT PASS' ,
`vote` INT(10) DEFAULT 0,
`disvote` INT(10) DEFAULT 0,
PRIMARY KEY (`ppid`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COMMENT='提案表';

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO proposal (author,ppname,status) value ('admin','关于草案评审的工作规范','PASS');
INSERT INTO proposal (author,ppname,status) value ('admin','管理系统申请资格规范','PASS');
INSERT INTO proposal (author,ppname,status) value ('admin','提案草稿审批规范','PASS');
INSERT INTO proposal (author,ppname,status) value ('admin','成立分组规范','PASS');
INSERT INTO proposal (author,ppname,status) value ('admin','草案详情撰写规范','PASS');
INSERT INTO proposal (author,ppname,status) value ('admin','数据管理规范','PASS');

