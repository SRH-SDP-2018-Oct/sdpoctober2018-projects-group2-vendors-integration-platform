
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
INSERT INTO user_master (userType, createdBy, modifiedBy, username, pwd, firstName, lastName, createdOn, modifiedOn)
SELECT user_type.typeId, '1', '1', 'root', '', 'root', 'root', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM user_type
WHERE user_type.typeName = 'admin';

-- Entry -> SYSTEM User
INSERT INTO user_master (userType, createdBy, modifiedBy, username, pwd, firstName, lastName, createdOn, modifiedOn)
SELECT user_type.typeId , um.userId, um.userId, 'system', '', 'system', 'system', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM user_type, user_master um
WHERE user_type.typeName = 'system' AND um.userName='root';


SELECT * FROM user_master;

