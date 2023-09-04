create database crudjdbcdb;
create table login(username varchar(255),password varchar(255));
create table product(prodId int,prodName varchar(255),minSellQuantity int,prodPrice int,quantity int);
insert into login(username,password) values('admin','Admin@123');
select * from login;
drop table login;
drop table product;
create table login(username varchar(255),password varchar(255));
create table product(prodId int,prodName varchar(255),minSellQuantity int,prodPrice int,quantity int,prodCost int,stock int);
insert into login(username,password) values('admin','Admin@123');
select * from login;
drop table product;
create table product(prodId int,prodName varchar(255),minSellQuantity int,prodPrice int,quantity int);
select * from login;
select * from product;
drop table product;
create table product(prodId int,prodName varchar(255),minSellQuantity int,prodPrice int,quantity int);
select * from product;


