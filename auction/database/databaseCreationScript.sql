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
`FirstName` VARCHAR(32) NOT NULL,
`LastName` VARCHAR(32) NOT NULL,
`Login` VARCHAR(16) NOT NULL,
`Password` VARCHAR(80) NOT NULL,
`Balance` DECIMAL(10,2),
`Email` VARCHAR(30),
`Avatar` VARCHAR(30),
unique (`Email`, `Login`, `Password`),
PRIMARY KEY (`UserID`)

)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;
-- -----------------------------------------------------
-- Category table
-- -----------------------------------------------------
drop table if exists `Java2_test`.`categories`;
CREATE TABLE IF NOT EXISTS `Java2_test`.`categories` (
`CategoryID` INT(11) NOT NULL AUTO_INCREMENT,
`Name` CHAR(32) NOT NULL,
PRIMARY KEY (`CategoryID`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 12;
-- ------------------------------------------------------
-- Product table
-- ------------------------------------------------------
drop table if exists `Java2_test`.`products`;
CREATE TABLE IF NOT EXISTS `Java2_test`.`products` (
`ProductID` INT(11) NOT NULL AUTO_INCREMENT,
`Name` CHAR(32) NOT NULL,
`Description` VARCHAR(3000),
`Status` BOOL,
`Image` CHAR(30),
`Price` DECIMAL(10,2),
`OwnerID` INT(11) NOT NULL,
-- `CategoryID` INT(11) NOT NULL,
PRIMARY KEY (`ProductID`),
CONSTRAINT UserOwnsProduct FOREIGN KEY (OwnerID) REFERENCES users(UserID)
ON DELETE CASCADE
-- FOREIGN KEY (CategoryID) REFERENCES categories(CategoryID)
)
ENGINE = InnoDB
AUTO_INCREMENT = 102;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;