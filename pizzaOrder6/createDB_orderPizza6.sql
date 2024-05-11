DROP SCHEMA IF EXISTS `movieCheckOutSystem`;

CREATE SCHEMA `movieCheckOutSystem`;

use `movieCheckOutSystem`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,

  PRIMARY KEY (`id`)
 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `customer` VALUES 
	(1,'Leslie'),
	(2,'Emma'),
	(3,'Avani'),
	(4,'Yuri');
	
DROP TABLE IF EXISTS `checkout_list`;

CREATE TABLE `checkout_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `checkout_date` DATETIME DEFAULT NULL,
  `returned_date` DATETIME DEFAULT NULL,
  
  
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `genre` varchar(45) DEFAULT NULL,
  `release_date` DATE DEFAULT NULL,
  `rating` varchar(45) DEFAULT NULL,
   `numb_of_copies` int(11) DEFAULT NULL,
  

  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
movie


SET FOREIGN_KEY_CHECKS = 1;

