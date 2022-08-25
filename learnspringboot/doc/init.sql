create database if not exists learnspringboot character set 'utf8mb4';
use learnspringboot;
create table user(
    id int auto_increment primary key ,
    name varchar(50),
    hx bigint,
    birth datetime
);
select * from user;
