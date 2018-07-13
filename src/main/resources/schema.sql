drop table if exists prodcustomer;

create table prodcustomer (
	user_id integer primary key,
	email varchar(50) unique,
	password varchar(20),
	firstname varchar(20),
	lastname varchar(20),
	enabled boolean,
	created_on datetime,
	reset_token varchar(130),
	reset_token_expire datetime

); 