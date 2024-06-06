CREATE TABLE `mastermart`.`products` (
  `prod_id` INT NOT NULL AUTO_INCREMENT,
  `prod_name` VARCHAR(256) NOT NULL,
  `prod_price` INT NOT NULL,
  `prod_description` VARCHAR(256) NOT NULL,
  `prod_sub_time` DATE NOT NULL,
  `prod_photo_url` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`prod_id`));
