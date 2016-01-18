drop database if exists testdb;

create database testdb;
use testdb;

DROP TABLE IF EXISTS user;
create table USERS (
	user_id int auto_increment primary key,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	address1 varchar(100) not null,
	address2 varchar(100),
	city varchar(100) not null,
	state varchar(2) not null,
	postal_code integer(5) not null,
	country varchar(10) not null,
	register_date datetime not null
);