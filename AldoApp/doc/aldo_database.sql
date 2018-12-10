DROP DATABASE IF EXISTS aldo_vendor;

CREATE DATABASE aldo_vendor;

USE aldo_vendor;

DROP TABLE IF EXISTS branch_master;


CREATE TABLE branch_master (
  branchId INT UNSIGNED NOT NULL AUTO_INCREMENT,
  location VARCHAR(100) DEFAULT NULL,
  locationLat VARCHAR(20) DEFAULT NULL,
  locationLon VARCHAR(20) DEFAULT NULL,
  city VARCHAR(30) NOT NULL,
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0',
  createdOn DATETIME NOT NULL,
  modifiedOn DATETIME NOT NULL,
  PRIMARY KEY (branchId),
  UNIQUE KEY (location)
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC branch_master;

INSERT INTO branch_master (location, locationLat, locationLon, city, createdOn, modifiedOn)
VALUES ('Czernyring 14, 69115 Heidelberg', '49.404011' , '8.670450', 'Heidelberg', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


SELECT * FROM branch_master;




DROP TABLE IF EXISTS branch_timings;

CREATE TABLE branch_timings (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  branchId INT UNSIGNED NOT NULL,
  dayInWeek TINYINT(1) NOT NULL COMMENT '1-Sunday, 2-Monday, 3-Tuesday, 4-Wednesday, 5-Thursday, 6-Friday, 7-Saturday',
  isOpen TINYINT(1) NOT NULL,
  openingTime TIME,
  closingTime TIME,
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0',
  createdOn DATETIME NOT NULL,
  modifiedOn DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (branchId, dayInWeek),
  FOREIGN KEY (branchId) REFERENCES branch_master(branchId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC branch_timings;


-- Sunday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 1, 0, NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Czernyring 14, 69115 Heidelberg';


-- Monday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 2, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Czernyring 14, 69115 Heidelberg';



-- Tuesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 3, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Czernyring 14, 69115 Heidelberg';



-- Wednesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 4, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Czernyring 14, 69115 Heidelberg';



-- Thursday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 5, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Czernyring 14, 69115 Heidelberg';



-- Friday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 6, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Czernyring 14, 69115 Heidelberg';



-- Saturday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 7, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Czernyring 14, 69115 Heidelberg';



SELECT * FROM branch_timings;




DROP TABLE IF EXISTS product_type ;

CREATE TABLE product_type (
  prodTypeId INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  productTypeName VARCHAR(30) NOT NULL UNIQUE,
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0'
) ENGINE=INNODB;

DESC product_type;



INSERT INTO product_type (prodTypeId, productTypeName) VALUES
(1, 'Fruits'), (2, 'Vegetables'), (3, 'Dairy Products');



DROP TABLE IF EXISTS product_master ;


CREATE TABLE product_master (
  productId INT UNSIGNED NOT NULL AUTO_INCREMENT,
  productTypeId INT UNSIGNED NOT NULL,
  productName VARCHAR(50) DEFAULT NULL,
  productDescription TEXT,
  productPrice DECIMAL(9,2) DEFAULT NULL,
  branchId INT UNSIGNED DEFAULT NULL,
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (productId),
  UNIQUE (productName, productTypeId),
  CONSTRAINT productTypeId FOREIGN KEY (productTypeId) REFERENCES product_type (prodTypeId ),
  CONSTRAINT branchId FOREIGN KEY (branchId) REFERENCES branch_master (branchid)
) ENGINE=INNODB;

DESC product_master;


INSERT INTO product_master (productTypeId,productName,productDescription,productPrice,branchId)
SELECT pt.prodTypeId, 'Banana','Brand : Chiquita, Mainly grown in columbia,Slight sour to very sweet','1.83', bm.branchId
FROM product_type pt, branch_master bm
WHERE pt.productTypeName = 'Fruits' AND bm.location = 'Czernyring 14, 69115 Heidelberg';


INSERT INTO product_master (productTypeId,productName,productDescription, productPrice, branchId)
SELECT pt.prodTypeId, 'Broccoli','Origin : Spain Or Italy, Green or Dark Color, Store : In Refrigerator', '1.20', bm.branchId
FROM product_type pt, branch_master bm
WHERE pt.productTypeName = 'Vegetables' AND bm.location = 'Czernyring 14, 69115 Heidelberg';


INSERT INTO product_master (productTypeId,productName,productDescription,productPrice,branchId)
SELECT pt.prodTypeId, 'H-milk','Energy : 197 KJ,1.5 %', '0.79', bm.branchId
FROM product_type pt, branch_master bm
WHERE pt.productTypeName = 'Dairy Products' AND bm.location = 'Czernyring 14, 69115 Heidelberg';


 
