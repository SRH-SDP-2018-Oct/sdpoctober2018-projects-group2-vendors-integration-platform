
DROP DATABASE IF EXISTS vendor_integration_app;

CREATE DATABASE /*!32312 IF NOT EXISTS*/vendor_integration_app /*!40100 DEFAULT CHARACTER SET latin1 */;

USE vendor_integration_app;


DROP TABLE IF EXISTS user_type;

CREATE TABLE user_type (
   typeId TINYINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'User type id. It will be used as referenece in the users table',
   typeName VARCHAR(20) UNIQUE NOT NULL,
   deleteFlag TINYINT(1) NOT NULL DEFAULT 0
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC user_type;

/*Data for the table user_master */

INSERT INTO user_type(typeName) VALUES ('admin');
INSERT INTO user_type(typeName) VALUES ('system');
INSERT INTO user_type(typeName) VALUES ('normal');

SELECT * FROM user_type;



DROP TABLE IF EXISTS user_master;

CREATE TABLE user_master (
  userId INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Auto generated userid of the system user to perform management/maintenance',
  username VARCHAR(75) NOT NULL UNIQUE COMMENT 'user name to login within the application as the system user',
  pwd TEXT COMMENT 'User Password',
  userType TINYINT UNSIGNED NOT NULL COMMENT 'User type to define privileges',
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  phone VARCHAR(15) DEFAULT '',
  email VARCHAR(75) DEFAULT '',
  address VARCHAR(100) DEFAULT '',
  pin VARCHAR(10) DEFAULT '',
  country VARCHAR(30) DEFAULT '',
  deleteFlag TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'flag to mark the entry as deleted -> 0-Active, 1-Deleted' ,
  createdBy INT UNSIGNED NOT NULL COMMENT 'user who registered the given user',
  createdOn DATETIME NOT NULL COMMENT 'user created on',
  modifiedBy INT UNSIGNED NOT NULL COMMENT 'user who modified the given user',
  modifiedOn DATETIME NOT NULL COMMENT 'user modified on',
  FOREIGN KEY (userType) REFERENCES user_type(typeId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC user_master;

/*Data for the table user_master */

-- Entry -> ROOT User
INSERT INTO user_master (userType, createdBy, modifiedBy, username, firstName, lastName, createdOn, modifiedOn, pwd)
SELECT user_type.typeId, '1', '1', 'root', 'root', 'root', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '9dae67e870c8b41b24e78f44c6a8f74ea931f2cef5b125fbbb2db87566083860'
FROM user_type
WHERE user_type.typeName = 'admin';

-- Entry -> SYSTEM User
INSERT INTO user_master (userType, createdBy, modifiedBy, username, firstName, lastName, createdOn, modifiedOn, pwd)
SELECT user_type.typeId , um.userId, um.userId, 'system', 'system', 'system', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '9dae67e870c8b41b24e78f44c6a8f74ea931f2cef5b125fbbb2db87566083860'
FROM user_type, user_master um
WHERE user_type.typeName = 'system' AND um.userName='root';

SELECT * FROM user_master;





/* ********************************************************************************** */
-- CUSTOMER
/* ********************************************************************************** */

DROP TABLE IF EXISTS customer_master;

CREATE TABLE customer_master (
  customerId BIGINT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Auto generated userid of the customer ',
  username VARCHAR(75) NOT NULL UNIQUE COMMENT 'user name to login within the application as a customer',
  pwd TEXT COMMENT 'Customer Password',
  firstName VARCHAR(30) NOT NULL,
  lastName VARCHAR(30) NOT NULL,
  phone VARCHAR(15) DEFAULT '',
  email VARCHAR(75) DEFAULT '',
  address VARCHAR(100) DEFAULT 'Wieblingen',
  pin VARCHAR(10) DEFAULT '69123',
  country VARCHAR(30) DEFAULT 'Germany',
  defaultLocation VARCHAR(100) DEFAULT 'Wieblingen',
  defaultLocationLat VARCHAR(20) DEFAULT '49.428550',
  defaultLocationLon VARCHAR(20) DEFAULT '8.645980',
  deleteFlag TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'flag to mark the entry as deleted -> 0-Active, 1-Deleted' ,
  createdBy INT UNSIGNED NOT NULL COMMENT 'user who registered the given user',
  createdOn TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'user created on',
  modifiedBy INT UNSIGNED NOT NULL COMMENT 'user who modified the given user',
  modifiedOn DATETIME NOT NULL COMMENT 'user modified on',
  FOREIGN KEY (createdBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (modifiedBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB ;

DESC customer_master;


-- Entry -> Customer
INSERT INTO customer_master (createdBy, modifiedBy, username, firstName, lastName, createdOn, modifiedOn, pwd)
SELECT um.userId, um.userId, 'john', 'John', 'Doe', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '9dae67e870c8b41b24e78f44c6a8f74ea931f2cef5b125fbbb2db87566083860' -- Hello@135
FROM user_type, user_master um
WHERE user_type.typeName = 'system' AND um.userName='system';

-- Entry -> Customer
INSERT INTO customer_master (createdBy, modifiedBy, username, firstName, lastName, createdOn, modifiedOn, pwd)
SELECT um.userId, um.userId, 'james', 'James', 'Anderson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '9dae67e870c8b41b24e78f44c6a8f74ea931f2cef5b125fbbb2db87566083860' -- Hello@135
FROM user_type, user_master um
WHERE user_type.typeName = 'system' AND um.userName='system';

SELECT * FROM customer_master;



/* ********************************************************************************** */
-- VENDOR
/* ********************************************************************************** */

DROP TABLE IF EXISTS vendor_master;

CREATE TABLE vendor_master (
  vendorId INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Auto generated userid of the vendor ',
  vendorName VARCHAR(75) NOT NULL UNIQUE COMMENT 'user name to login within the application as a vendor',
  phone VARCHAR(15) DEFAULT '',
  email VARCHAR(75) DEFAULT '',
  country VARCHAR(30) DEFAULT 'Germany',
  deleteFlag TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'flag to mark the entry as deleted -> 0-Active, 1-Deleted' ,
  createdBy INT UNSIGNED NOT NULL COMMENT 'user who registered the given user',
  createdOn DATETIME NOT NULL COMMENT 'user created on',
  modifiedBy INT UNSIGNED NOT NULL COMMENT 'user who modified the given user',
  modifiedOn DATETIME NOT NULL COMMENT 'user modified on',
  FOREIGN KEY (createdBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (modifiedBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB ;

DESC vendor_master;

/* Data for the table vendor_master */

-- Entry -> NETTI Vendor
INSERT INTO vendor_master (createdBy, modifiedBy, vendorName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'Netti', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM user_master um
  INNER JOIN user_type ON user_type.typeId = um.userType
WHERE user_type.typeName = 'system' AND um.userName='system';

-- Entry -> ALDO Vendor
INSERT INTO vendor_master (createdBy, modifiedBy, vendorName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'Aldo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM user_master um
  INNER JOIN user_type ON user_type.typeId = um.userType
WHERE user_type.typeName = 'system' AND um.userName='system';


SELECT * FROM vendor_master;


DROP TABLE IF EXISTS vendor_branches;


CREATE TABLE vendor_branches (
  branchId INT UNSIGNED NOT NULL AUTO_INCREMENT,
  vendorId INT UNSIGNED NOT NULL, 
  location VARCHAR(100) DEFAULT NULL,
  locationLat VARCHAR(20) DEFAULT NULL,
  locationLon VARCHAR(20) DEFAULT NULL,
  city VARCHAR(30) NOT NULL,
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0',
  createdBy INT UNSIGNED NOT NULL COMMENT 'user who registered the given user',
  createdOn DATETIME NOT NULL COMMENT 'user created on',
  modifiedBy INT UNSIGNED NOT NULL COMMENT 'user who modified the given user',
  modifiedOn DATETIME NOT NULL COMMENT 'user modified on',
  PRIMARY KEY (branchId),
  UNIQUE KEY (vendorId, location),
  FOREIGN KEY (vendorId) REFERENCES vendor_master(vendorId) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (createdBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (modifiedBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC vendor_branches;


INSERT INTO vendor_branches (vendorId, createdBy, modifiedBy, location, locationLat, locationLon, city, createdOn, modifiedOn)
SELECT vm.vendorId, um.userId, um.userId,
  'Mannheimer Str. 177, 69123 Heidelberg', '49.419090' , '8.651890', 'Heidelberg', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_master vm, user_master um
WHERE vm.vendorName = 'Netti' AND um.username='system';


INSERT INTO vendor_branches (vendorId, createdBy, modifiedBy, location, locationLat, locationLon, city, createdOn, modifiedOn)
SELECT vm.vendorId, um.userId, um.userId,
  'Czernyring 14, 69115 Heidelberg', '49.404011' , '8.670450', 'Heidelberg', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_master vm, user_master um
WHERE vm.vendorName = 'Aldo' AND um.username='system';



SELECT * FROM vendor_branches ;



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
  FOREIGN KEY (branchId) REFERENCES vendor_branches(branchId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC branch_timings;


-- Sunday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT bm.branchId, 1, 0, NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_branches bm
WHERE bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';


-- Monday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT bm.branchId, 2, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_branches bm
WHERE bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Tuesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT bm.branchId, 3, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_branches bm
WHERE bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Wednesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT bm.branchId, 4, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_branches bm
WHERE bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Thursday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT bm.branchId, 5, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_branches bm
WHERE bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Friday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT bm.branchId, 6, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_branches bm
WHERE bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';



-- Saturday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT bm.branchId, 7, 1, '07:00:00', '22:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM vendor_branches bm
WHERE bm.location = 'Mannheimer Str. 177, 69123 Heidelberg';



SELECT * FROM branch_timings;





/* ********************************************************************************** */
-- API CONFIG
/* ********************************************************************************** */


DROP TABLE IF EXISTS vendor_api_config;

CREATE TABLE vendor_api_config (
  id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Auto generated id',
  vendorId INT UNSIGNED NOT NULL COMMENT 'Vendor id',
  connectionUrl VARCHAR(100) NOT NULL,
  secured TINYINT(1) DEFAULT '0' COMMENT '1-Secured, 0-Open' ,
  username VARCHAR(30) DEFAULT '',
  pwd TEXT,
  deleteFlag TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'flag to mark the entry as deleted -> 0-Active, 1-Deleted' ,
  createdBy INT UNSIGNED NOT NULL COMMENT 'user who registered the given Vendor',
  createdOn DATETIME NOT NULL COMMENT 'Vendor created on',
  modifiedBy INT UNSIGNED NOT NULL COMMENT 'user who modified the given Vendor',
  modifiedOn DATETIME NOT NULL COMMENT 'Vendor modified on',
  UNIQUE (vendorId, connectionUrl, secured, username),
  FOREIGN KEY (createdBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (modifiedBy) REFERENCES user_master(userId) ON UPDATE CASCADE ON DELETE CASCADE
);

DESC vendor_api_config;



INSERT INTO vendor_api_config (createdBy, modifiedBy, vendorId, connectionUrl, secured, username, pwd, createdOn, modifiedOn )
SELECT um.userId, um.userId, vm.vendorId, 'http://localhost:8070/nettiapp/products', 1, 'netticlient', 'nettiApiConnnect', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM user_master um, vendor_master vm
WHERE um.userName='system' AND vm.vendorName = 'Netti';

SELECT * FROM vendor_api_config;



DROP TABLE IF EXISTS api_structure_constants;


CREATE TABLE api_structure_constants (
  apiStructId INT UNSIGNED NOT NULL AUTO_INCREMENT,
  constantName VARCHAR(50) NOT NULL COMMENT 'constant name of the keys to be mapped',
  displayName VARCHAR(70) NOT NULL COMMENT 'Display name of the key to be mapped',
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0' COMMENT '0- Active; 1- Deleted',
  createdOn DATETIME NOT NULL,
  createdBy INT UNSIGNED NOT NULL,
  modifiedOn DATETIME NOT NULL,
  modifiedBy INT UNSIGNED NOT NULL,
  PRIMARY KEY (apistructId),
  UNIQUE KEY (constantName),
  FOREIGN KEY (createdBy) REFERENCES user_master (userId),
  FOREIGN KEY (modifiedBy) REFERENCES user_master (userId)
) ENGINE=INNODB ;


DESC api_structure_constants;


INSERT INTO api_structure_constants (createdBy, modifiedBy, constantName, displayName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'product_id', 'Product Id', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um
WHERE um.username = 'system';

INSERT INTO api_structure_constants (createdBy, modifiedBy, constantName, displayName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'product_name', 'Product Name', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um
WHERE um.username = 'system';

INSERT INTO api_structure_constants (createdBy, modifiedBy, constantName, displayName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'product_description', 'Product Description', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um
WHERE um.username = 'system';

INSERT INTO api_structure_constants (createdBy, modifiedBy, constantName, displayName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'product_type', 'Product Type', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um
WHERE um.username = 'system';

INSERT INTO api_structure_constants (createdBy, modifiedBy, constantName, displayName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'product_price', 'Product Price', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um
WHERE um.username = 'system';

INSERT INTO api_structure_constants (createdBy, modifiedBy, constantName, displayName, createdOn, modifiedOn)
SELECT um.userId, um.userId, 'vendor_id', 'Vendor Id', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um
WHERE um.username = 'system';

SELECT * FROM api_structure_constants;


DROP TABLE IF EXISTS api_structure;


CREATE TABLE api_structure (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  keyConstantId INT UNSIGNED NOT NULL,
  keyName VARCHAR(75) NOT NULL,
  vendorId INT UNSIGNED NOT NULL,
  deleteFlag TINYINT(1) NOT NULL DEFAULT 0,
  createdOn DATETIME NOT NULL,
  createdBy INT UNSIGNED NOT NULL,
  modifiedOn DATETIME NOT NULL,
  modifiedBy INT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (keyConstantId, keyName, vendorId),
  FOREIGN KEY (keyConstantId) REFERENCES api_structure_constants (apiStructId),
  FOREIGN KEY (vendorId) REFERENCES vendor_master (vendorId),
  FOREIGN KEY (createdBy) REFERENCES user_master (userId),
  FOREIGN KEY (modifiedBy) REFERENCES user_master (userId)
) ENGINE=INNODB;


DESC api_structure;

-- Netti - Product Id
INSERT INTO api_structure (createdBy, modifiedBy, keyConstantId, vendorId, keyName, createdOn, modifiedOn)
SELECT um.userId, um.userId, apisc.apiStructId, vm.vendorId, 'id', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um, api_structure_constants apisc, vendor_master vm
WHERE um.username = 'system'  AND  apisc.constantName='product_id' AND vm.vendorName = 'Netti' ;

-- Netti - Product Name
INSERT INTO api_structure (createdBy, modifiedBy, keyConstantId, vendorId, keyName, createdOn, modifiedOn)
SELECT um.userId, um.userId, apisc.apiStructId, vm.vendorId, 'name', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP 
FROM user_master um, api_structure_constants apisc, vendor_master vm
WHERE um.username = 'system'  AND  apisc.constantName='product_name' AND vm.vendorName = 'Netti' ;





/* ********************************************************************************** */
-- Product
/* ********************************************************************************** */

DROP TABLE IF EXISTS product_type;

CREATE TABLE product_type(
  productTypeId INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  productTypeName VARCHAR(30) NOT NULL,
  vendorId INT UNSIGNED NOT NULL,
  deleteFlag TINYINT(1) DEFAULT '0' NOT NULL,
  createdOn DATETIME NOT NULL,
  createdBy INT UNSIGNED NOT NULL,
  modifiedOn DATETIME NOT NULL,
  modifiedBy INT UNSIGNED NOT NULL,
  FOREIGN KEY (vendorId) REFERENCES vendor_master (vendorId),
  FOREIGN KEY (createdBy) REFERENCES user_master (userId),
  FOREIGN KEY (modifiedBy) REFERENCES user_master (userId)
);

DESC product_type;




DROP TABLE IF EXISTS products_master;

CREATE TABLE products_master(
  productId INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  productTypeId INT UNSIGNED NOT NULL,
  productName VARCHAR(50) NOT NULL,
  productPrice DECIMAL(10,0) DEFAULT NULL,
  productDescription TEXT,
  productShelfLife VARCHAR(50) DEFAULT '',
  hasAnOffer TINYINT(1) DEFAULT '0' NOT NULL,
  offerDetail TEXT NOT NULL,
  vendorId INT UNSIGNED NOT NULL,
  branchId INT UNSIGNED NOT NULL,
  otherDetails TEXT NOT NULL,
  apiDetails TEXT NOT NULL,
  deleteFlag TINYINT(1) DEFAULT '0' NOT NULL,
  createdOn DATETIME NOT NULL,
  createdBy INT UNSIGNED NOT NULL,
  modifiedOn DATETIME NOT NULL,
  modifiedBy INT UNSIGNED NOT NULL,
  FOREIGN KEY (productTypeId) REFERENCES product_type (productTypeId),
  FOREIGN KEY (vendorId) REFERENCES vendor_master (vendorId),
  FOREIGN KEY (branchId) REFERENCES vendor_branches (branchId),
  FOREIGN KEY (createdBy) REFERENCES user_master (userId),
  FOREIGN KEY (modifiedBy) REFERENCES user_master (userId)
);

DESC products_master;

