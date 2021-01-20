create database if not exists ups;

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

insert into ups.receivers (name) values ("evroopt");
insert into ups.receivers (name) values ("korona");
insert into ups.receivers (name) values ("sosedi");

insert into ups.expenses (id,paydate,receiver,value) 
values (1, '25.12.2020',1,36.00);
insert into ups.expenses (id,paydate,receiver,value) 
values (2, '2020.12.24',2,25.36);
insert into ups.expenses (paydate,receiver,value) 
values ('2020.12.20',2,10.00);
insert into ups.expenses (paydate,receiver,value) 
values ('2020.12.19',3,150.00);
