
CREATE DATABASE IF NOT EXISTS*/vendor_app /*!40100 DEFAULT CHARACTER SET latin1 */;

USE vendor_app;

/*Table structure for table user_master */

DROP TABLE IF EXISTS user_master;

CREATE TABLE user_master (
  userId int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Auto generated userid of the system user to perform management/maintenance',
  username varchar(75) NOT NULL COMMENT 'user name to login within the application as the system user',
  uPwd text NOT NULL,
  uType varchar(15) NOT NULL COMMENT 'User type to segregate whether the user has normal, admin or sub-admin privileges',
  firstName varchar(30) NOT NULL,
  lastName varchar(30) NOT NULL,
  phone varchar(15) DEFAULT '',
  email varchar(75) DEFAULT '',
  address varchar(100) DEFAULT '',
  pin varchar(10) DEFAULT '',
  country varchar(30) DEFAULT '',
  deleteFlag tinyint(1) NOT NULL DEFAULT '0' COMMENT 'flag to mark the entry as deleted -> 0-Active, 1-Deleted',
  createdBy int(11) unsigned NOT NULL COMMENT 'user who registered the given user',
  createdOn datetime NOT NULL COMMENT 'user created on',
  modifiedBy int(11) unsigned NOT NULL COMMENT 'user who modified the given user',
  modifiedOn datetime NOT NULL COMMENT 'user modified on',
  PRIMARY KEY (userId),
  UNIQUE KEY username (username)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

DESC user_master;


/*Data for the table user_master */

insert  into user_master(userId,username,uPwd,uType,firstName,lastName,phone,email,address,pin,country,deleteFlag,createdBy,createdOn,modifiedBy,modifiedOn) values 
(1,'system','','system','system','system','','','','','',0,1,'2018-11-28 18:32:08',1,'2018-11-28 18:32:08');


SELECT * FROM user_master;
