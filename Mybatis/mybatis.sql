/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.28 : Database - studyingmybatis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studyingmybatis` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `studyingmybatis`;

/*Table structure for table `tbl_dept` */

DROP TABLE IF EXISTS `tbl_dept`;

CREATE TABLE `tbl_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_dept` */

insert  into `tbl_dept`(`id`,`dept_name`) values (1,'开发部'),(2,'测试部');

/*Table structure for table `tbl_employee` */

DROP TABLE IF EXISTS `tbl_employee`;

CREATE TABLE `tbl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ck_emp` (`d_id`),
  CONSTRAINT `ck_emp` FOREIGN KEY (`d_id`) REFERENCES `tbl_dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `tbl_employee` */

insert  into `tbl_employee`(`id`,`last_name`,`gender`,`email`,`d_id`) values (1,'Admin','1','123@qq.com',1),(3,'jerry','1','jerry@qq.coom',2),(4,'jerry','0','jerry@qq.coom',2),(5,'jerry','1','jerry@qq.coom',1),(6,'jerry','1','jerry@qq.coom',NULL),(7,'jerry','1','jerry@qq.coom',NULL),(8,'jerry','1','jerry@qq.coom',NULL),(9,'jerry','1','jerry@qq.coom',NULL),(10,'jerry','1','jerry@qq.coom',NULL),(11,'jerry','1','jerry@qq.coom',NULL),(12,'smith','1','smith@qq.com',1),(13,'allen','0','smith@qq.com',1),(14,'smith','1','smith@qq.com',1),(15,'allen','0','smith@qq.com',1),(16,'testCache','1','cache',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
