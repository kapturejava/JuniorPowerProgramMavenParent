DROP DATABASE IF EXISTS TailorFit;
CREATE DATABASE TailorFit;

USE TailorFit;

DROP TABLE IF EXISTS ClothingItem;
CREATE TABLE ClothingItem (
      id int(11) NOT NULL auto_increment,
      Size int(11) NOT NULL,
      Color varchar(50) NOT NULL DEFAULT 'white',
      PRIMARY KEY (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ;

DROP TABLE IF EXISTS Person;
CREATE TABLE Person (
	  id int(11) NOT NULL auto_increment,
      Size int(11) NOT NULL,
      Gender int(11) NOT NULL DEFAULT 0,
      FirstName varchar(50) NOT NULL DEFAULT '',
      LastName varchar(50) NOT NULL DEFAULT '',
      PRIMARY KEY (id)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ;