CREATE TABLE ingredients
(
id mediumint not null AUTO_INCREMENT,
name varchar(128),
used_quantities varchar(256),
primary key(id)
);

CREATE TABLE quantities
(
id mediumint not null AUTO_INCREMENT,
name varchar(128),
primary key(id)
);

CREATE TABLE descriptors
(
id mediumint not null AUTO_INCREMENT,
name varchar(128),
primary key(id)
);

CREATE TABLE bowls
(
id mediumint not null AUTO_INCREMENT,
ingred_id varchar(16),
quantity varchar(16),
quant_id varchar(16),
original_string varchar(256),
primary key(id)
);

CREATE TABLE recipes
(
id mediumint not null AUTO_INCREMENT,
name varchar(128),
bowl_list varchar(256),
instructions text,
notes text,
primary key(id)
);

