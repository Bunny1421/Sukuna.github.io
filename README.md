# Ryomen Sukuna

jong hong pa chom


# HOW TO LOGIN

User is :admin
Password is :123


# Data base

CREATE TABLE `branchs` (
  `b_id` int NOT NULL AUTO_INCREMENT,
  `b_name` varchar(100) DEFAULT NULL,
  `b_nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;


CREATE TABLE `empolyee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(100) DEFAULT NULL,
  `emp_user` varchar(100) DEFAULT NULL,
  `emp_password` varchar(100) DEFAULT NULL,
  `emp_id_branch` int DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `empolyee_FK` (`emp_id_branch`),
  CONSTRAINT `empolyee_FK` FOREIGN KEY (`emp_id_branch`) REFERENCES `branchs` (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


CREATE TABLE `event_datail` (
  `ev_id` int NOT NULL AUTO_INCREMENT,
  `eventroomid` int DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ev_id`),
  KEY `event_datail_FK` (`eventroomid`),
  CONSTRAINT `event_datail_FK` FOREIGN KEY (`eventroomid`) REFERENCES `room_details` (`rd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;


CREATE TABLE `room_details` (
  `rd_id` int NOT NULL AUTO_INCREMENT,
  `rd_name` varchar(100) DEFAULT NULL,
  `rd_id_status` int DEFAULT NULL,
  `rd_floor` varchar(100) DEFAULT NULL,
  `rd_building` varchar(100) DEFAULT NULL,
  `rd_id_branch` int DEFAULT NULL,
  PRIMARY KEY (`rd_id`),
  KEY `room_details_FK` (`rd_id_branch`),
  KEY `room_details_FK_1` (`rd_id_status`),
  CONSTRAINT `room_details_FK` FOREIGN KEY (`rd_id_branch`) REFERENCES `branchs` (`b_id`),
  CONSTRAINT `room_details_FK_1` FOREIGN KEY (`rd_id_status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;


CREATE TABLE `status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;





# Data you can insert from webpage 
