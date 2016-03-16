

drop database if exists crossover;
create database crossover;
use crossover;


create table currency (
    id bigint unsigned not null auto_increment primary key,
    code varchar(50) not null,
    name varchar(50) not null,
	unique index code_idx1 (code)
)engine = InnoDb;