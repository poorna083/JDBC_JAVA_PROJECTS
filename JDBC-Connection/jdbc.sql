create database jdbc;
show databases;
use jdbc;
show schemas;
create table details(usename varchar(20),password varchar(50),name varchar(30),email varchar(30));
alter table details drop column usename;
select * from details;
alter table details modify username varchar(30) first;
delete from details where password ="poorna__";