
GRANT ALL PRIVILEGES ON *.* To 'suser'@'localhost' IDENTIFIED BY 'secpass';
mysql -u suser -psecpass <schema.sql 
mysql -u suser -psecpass crossover <data.sql 


drop database if exists crossover;
create database crossover;
use crossover;


create table currency (
    id bigint unsigned not null auto_increment primary key,
    code varchar(50) not null,
    name varchar(50) not null,
	unique index code_idx1 (code)
)engine = InnoDb;
