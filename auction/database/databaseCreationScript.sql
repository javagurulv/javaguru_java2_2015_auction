SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Java2_test` DEFAULT CHARACTER SET utf8 ;
USE `Java2_test` ;

-- -----------------------------------------------------
-- Table `java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Java2_test`.`users` ;

CREATE TABLE IF NOT EXISTS `Java2_test`.`users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  PRIMARY KEY (`UserID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;
-- ------------------------------------------------------
-- Product table
-- ------------------------------------------------------
drop table if exists `Java2_test`.`products`;

create table if not exists  `Java2_test`.`products`(
  `ProductID` int(11) not null auto_increment,
  `Name` varchar(35) not null,
  `Description` varchar(3000),
  `OwnerID` int(11) not null,
  primary key(`ProductID`)
 -- foreign key(`OwnerID`) references users(`UserID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1002;

-- -----------------------------------------------------



CREATE TABLE IF NOT EXISTS `Java2_test`.`categories` (
  `CatID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` CHAR(32) NOT NULL,
  PRIMARY KEY (`CatID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 12;



CREATE TABLE IF NOT EXISTS `Java2_test`.`products` (
  `ProductID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` CHAR(32) NOT NULL,
  `Description` VARCHAR(300),
  `Status` BOOL,
  `Image` CHAR(30),
  `Price` DECIMAL(10,2),
  `UserID` INT(11) NOT NULL,
  `CatID` INT(11) NOT NULL,
  PRIMARY KEY (`ProductID`),
  CONSTRAINT UserOwnsProduct FOREIGN KEY (UserID) REFERENCES users(UserID)
	     ON DELETE CASCADE,
	FOREIGN KEY (CatID) REFERENCES categories(CatID)
)
ENGINE = InnoDB
AUTO_INCREMENT = 102;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
