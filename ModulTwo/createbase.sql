create database if not exists usp;

create table if not exists expenses (
num int not null primary key,
paydate date not null,
receiver int,
value decimal(7,2) not null
);

create table if not exists receivers (
num int not null,
name varchar(54),
constraint num 
	foreign key (num) 
    references usp.expenses(num)
);

insert into expenses ( num, paydate, val, receiver)
values ( 1, '2011-11-10', 934.44, 2);

insert into receivers ( num, name)
values ( 1, 'Корона');