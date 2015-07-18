#like cups, teaspoons
DROP TABLE IF EXISTS `quantities`;
CREATE TABLE quantities
(
id mediumint not null AUTO_INCREMENT,
name varchar(128),
plural_name varchar(128),
primary key(id)
);


DROP TABLE IF EXISTS `not_quantities`;
CREATE TABLE not_quantities
(
  id mediumint not null AUTO_INCREMENT,
  name varchar(128),
  primary key(id)
);

DROP TABLE IF EXISTS `bowls`;
CREATE TABLE bowls
(
id mediumint not null AUTO_INCREMENT,
name varchar(128),
recipie_id MEDIUMINT not null,
primary key(id)
);

DROP TABLE IF EXISTS `bowl_ingredients`;
CREATE TABLE bowl_ingredients
(
id mediumint not null AUTO_INCREMENT,
bowl_id mediumint not null,
number_amount varchar(16),
quantity_id varchar(16),
descriptor varchar(256),
primary key(id)
);

DROP TABLE IF EXISTS `recipes`;
CREATE TABLE recipes
(
id mediumint not null AUTO_INCREMENT,
name varchar(128),
instructions text,
notes text,
primary key(id)
);

commit

