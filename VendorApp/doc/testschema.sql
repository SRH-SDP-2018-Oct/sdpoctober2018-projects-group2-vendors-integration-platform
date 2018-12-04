
DROP DATABASE vendor_app;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`vendor_app` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE vendor_app;


DROP TABLE IF EXISTS user_type;

CREATE TABLE user_type (
   typeId TINYINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'User type id. It will be used as referenece in the users table',
   typeName VARCHAR(20) UNIQUE NOT NULL,
   deleteFlag TINYINT(1) NOT NULL DEFAULT 0
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC user_type;

/*Data for the table `user_master` */

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

/*Data for the table `user_master` */

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
FROM user_master um
  INNER JOIN user_type ON user_type.typeId = um.userType
WHERE user_type.typeName = 'system' AND um.userName='system';

-- Entry -> Customer
INSERT INTO customer_master (createdBy, modifiedBy, username, firstName, lastName, createdOn, modifiedOn, pwd)
SELECT um.userId, um.userId, 'james', 'James', 'Anderson', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
  '9dae67e870c8b41b24e78f44c6a8f74ea931f2cef5b125fbbb2db87566083860' -- Hello@135
FROM user_master um
  INNER JOIN user_type ON user_type.typeId = um.userType
WHERE user_type.typeName = 'system' AND um.userName='system';

SELECT * FROM customer_master;




/*-------MAITREYEE-------*/

DROP TABLE IF EXISTS vendor_master;

CREATE TABLE vendor_master (
  vendorId BIGINT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Auto generated userid of the vendor ',
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

/* Data for the table `vendor_master` */

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


