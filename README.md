README for app
==========================

CREATE USER 'userbase'@'localhost' IDENTIFIED BY 'userbase';

CREATE SCHEMA IF NOT EXISTS `userbase` ;

GRANT ALL PRIVILEGES ON userbase . * TO 'userbase'@'localhost';
