-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: userbase
-- ------------------------------------------------------
-- Server version	5.1.59-community
use userbase;

DROP TABLE IF EXISTS `condidate_registration`;
CREATE TABLE `condidate_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `contact_number` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `institute` varchar(45) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
);
CREATE TABLE `questions` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) DEFAULT NULL,
  `answer1` varchar(45) DEFAULT NULL,
  `answer2` varchar(45) DEFAULT NULL,
  `answer3` varchar(45) DEFAULT NULL,
  `answer4` varchar(45) DEFAULT NULL,
  `correct_answer` varchar(45) DEFAULT NULL,
  `language_type` varchar(45) DEFAULT NULL,
  `question_set` varchar(45) DEFAULT NULL,
  `question_type` varchar(45) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `results` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `answered_count` varchar(255) DEFAULT NULL,
  `correct_answer_count` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `questions` varchar(255) DEFAULT NULL,
  `total_count` varchar(255) DEFAULT NULL,
  `total_marks` varchar(255) DEFAULT NULL,
  `un_answered_count` varchar(255) DEFAULT NULL,
  `candidate_id` int(20) DEFAULT NULL,
  `result_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_userid_role` (`role`,`userid`),
  KEY `fk_user_idx` (`userid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`)
);
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(60) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);
CREATE TABLE `candidate_test_set_configuration` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `candidate_id` int(10) DEFAULT NULL,
  `test_set_id` int(10) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
 );
 CREATE TABLE `test_packages` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `candidate_id` int(10) DEFAULT NULL,
  `amount_paid` int(10) DEFAULT NULL,
  `discount` int(10) DEFAULT NULL,
  `actual_amount` int(10) DEFAULT NULL,
  `no_of_test` int(10) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `package_status` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `test_set` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `question_set` varchar(10) DEFAULT NULL,
  `time_in_min` int(10) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `update_notification` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `users` VALUES 
(1,'admin','admin@gmail.com','$2a$12$U6T2Y0QYqNJJhmroilGSJOcX00QKf/RWfd/86O..Z4QoGNCUvd2Fu',NULL,1);

INSERT INTO `user_roles` VALUES (1,1,'ROLE_ADMIN');
/************************Date:-2017-04-03************************/
ALTER TABLE `userbase`.`questions` 
CHANGE COLUMN `date_created` `date_created` DATETIME NULL DEFAULT NULL COMMENT '' AFTER `question_set`,
ADD COLUMN `answer1type` VARCHAR(45) NULL COMMENT '' AFTER `question_type`,
ADD COLUMN `answer2type` VARCHAR(45) NULL COMMENT '' AFTER `answer1type`,
ADD COLUMN `answer3type` VARCHAR(45) NULL COMMENT '' AFTER `answer2type`,
ADD COLUMN `answer4type` VARCHAR(45) NULL COMMENT '' AFTER `answer3type`,
ADD COLUMN `correct_answer_type` VARCHAR(45) NULL COMMENT '' AFTER `answer4type`;

ALTER TABLE `userbase`.`questions` 
CHANGE COLUMN `question_type` `question_type` VARCHAR(45) NULL DEFAULT 't' COMMENT '' ,
CHANGE COLUMN `answer1type` `answer1type` VARCHAR(45) NULL DEFAULT 't' COMMENT '' ,
CHANGE COLUMN `answer2type` `answer2type` VARCHAR(45) NULL DEFAULT 't' COMMENT '' ,
CHANGE COLUMN `answer3type` `answer3type` VARCHAR(45) NULL DEFAULT 't' COMMENT '' ,
CHANGE COLUMN `answer4type` `answer4type` VARCHAR(45) NULL DEFAULT 't' COMMENT '' ,
CHANGE COLUMN `correct_answer_type` `correct_answer_type` VARCHAR(45) NULL DEFAULT 't' COMMENT '' ;

/************************Date:-2017-04-13************************/

ALTER TABLE `userbase`.`test_packages` 
ADD COLUMN `payment_status` VARCHAR(45) NULL COMMENT '' AFTER `create_date`;

ALTER TABLE `userbase`.`test_packages` 
CHANGE COLUMN `discount` `discount` INT(10) NULL DEFAULT 0 COMMENT '' ,
CHANGE COLUMN `no_of_test` `no_of_test` INT(10) ZEROFILL NULL DEFAULT NULL COMMENT '' ;

ALTER TABLE `userbase`.`test_set` 
CHANGE COLUMN `question_set` `question_set` VARCHAR(10) NOT NULL COMMENT '' ;

/************************Date:-2017-05-19************************/

ALTER TABLE `userbase`.`test_packages` 
ADD COLUMN `active` TINYINT(1) NULL DEFAULT 1 COMMENT '' AFTER `payment_status`;

ALTER TABLE `userbase`.`candidate_test_set_configuration` 
CHANGE COLUMN `create_date` `create_date` DATETIME NULL DEFAULT NULL COMMENT '' ;

/************************Date:-2017-05-22************************/
ALTER TABLE `userbase`.`results` 
ADD COLUMN `test_set_id` INT(10) NULL COMMENT '' AFTER `result_date`;

ALTER TABLE `userbase`.`test_set` 
ADD UNIQUE INDEX `question_set_UNIQUE` (`question_set` ASC)  COMMENT '';

CREATE TABLE `userbase`.`contact_us` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `email` VARCHAR(45) NULL COMMENT '',
  `comment` VARCHAR(1000) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

ALTER TABLE `userbase`.`questions` 
ADD COLUMN `simplefication` VARCHAR(255) NULL COMMENT '' AFTER `correct_answer_type`;

ALTER TABLE `userbase`.`test_set` 
ADD COLUMN `is_enable` TINYINT(1) NULL DEFAULT 1 COMMENT '' AFTER `create_date`;

ALTER TABLE `userbase`.`candidate_registration` 
ADD COLUMN `is_package` TINYINT(1) NULL DEFAULT 0 COMMENT '' AFTER `is_enabled`;
