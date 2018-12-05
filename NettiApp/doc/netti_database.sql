
DROP DATABASE IF EXISTS netti_vendor;

CREATE DATABASE netti_vendor;

USE netti_vendor;

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
VALUES ('Mannheimer Str. 177, 69123 Heidelberg', '49.419090' , '8.651890', 'Heidelberg', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


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
WHERE branch_master.location = 'Mannheimer Str. 177, 69123 Heidelberg';


-- Monday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 2, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Tuesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 3, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Wednesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 4, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Thursday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 5, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Friday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 6, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Saturday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 7, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.location = 'Mannheimer Str. 177, 69123 Heidelberg';



SELECT * FROM branch_timings;



DROP TABLE IF EXISTS `product_types` ;

CREATE TABLE `product_types` (
  `prodTypeId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `productType` VARCHAR(30) NOT NULL,
   deleteFlag TINYINT(1) NOT NULL DEFAULT '0',
  UNIQUE (productType),
  PRIMARY KEY (`prodtypeId`)
) ENGINE=InnoDB;

DESC product_types;


insert into product_types (productType) values
('Dairy'), ('Fruits'), ('Vegetables');



DROP TABLE IF EXISTS `products` ;


CREATE TABLE `products` (
  `productId` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `productTypeId` int UNSIGNED NOT NULL,
  `productName` varchar(50) DEFAULT NULL,
  `productDescription` text,
  `productPrice` decimal(10,0) DEFAULT NULL,
  `branchId` int UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE (productName, productTypeId),
  CONSTRAINT `productTypeId` FOREIGN KEY (`productTypeId`) REFERENCES `product_types` (`prodTypeId` ),
  CONSTRAINT `branchId` FOREIGN KEY (`branchId`) REFERENCES `branch_master` (`branchid`)
) ENGINE=InnoDB;



INSERT INTO products (`productTypeId`,`productName`,`productDescription`,`productPrice`,`branchId`)
SELECT pt.prodTypeId, 'H-milk','Energy : 197 KJ,1.5 %', '0.79', bm.branchId
FROM product_types pt, branch_master bm
WHERE pt.productType = 'Dairy' AND bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';


INSERT INTO products (`productTypeId`,`productName`,`productDescription`,`productPrice`,`branchId`)
SELECT pt.prodTypeId, 'Banana','Brand : Chiquita, Mainly grown in columbia,Slight sour to very sweet','1.83', bm.branchId
FROM product_types pt, branch_master bm
WHERE pt.productType = 'Fruits' AND bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';


INSERT INTO products (`productTypeId`,`productName`,`productDescription`, `productPrice`,`branchId`)
SELECT pt.prodTypeId, 'Broccoli','Origin : Spain Or Italy, Green or Dark Color, Store : In Refrigerator', '1.20', bm.branchId
FROM product_types pt, branch_master bm
WHERE pt.productType = 'Vegetables' AND bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';


 
