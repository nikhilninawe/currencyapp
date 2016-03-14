

create table currency (
    id bigint unsigned not null auto_increment primary key,
    code varchar(50) not null,
    name varchar(50) not null)
    engine = InnoDb;