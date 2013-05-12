CREATE TABLE ingredients
(
id varchar(16),
name varchar(128),
used_quantities varchar(256)
);

CREATE TABLE quantities
(
id varchar(16),
name varchar(128)
);

CREATE TABLE descriptors
(
id varchar(16),
name varchar(128)
);

CREATE TABLE bowls
(
bowl_id varchar(16),
ingred_id varchar(16),
quantity varchar(16),
quant_id varchar(16),
original_string varchar(256)
);

CREATE TABLE recipes
(
id varchar(16),
name varchar(128),
bowl_list varchar(256),
instructions text,
notes text
);
