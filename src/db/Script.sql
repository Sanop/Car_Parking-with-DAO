create database if not exists carpark;

use carpark;

create table customer(
id varchar(20)primary key,
name varchar(100)not null,
address varchar(100)not null,
contact varchar(20)not null,
nic varchar(20)not null,
carNumber varchar(100)not null,
carModel varchar(100)not null
);

create table carCells(
cellid varchar(10)primary key not null,
status varchar(20)not null
);

insert into carCells values('lblA1','not reserved');
insert into carCells values('lblA2','not reserved');
insert into carCells values('lblA3','not reserved');
insert into carCells values('lblA4','not reserved');
insert into carCells values('lblB1','not reserved');
insert into carCells values('lblB2','not reserved');
insert into carCells values('lblB3','not reserved');
insert into carCells values('lblB4','not reserved');
insert into carCells values('lblC1','not reserved');
insert into carCells values('lblC2','not reserved');
insert into carCells values('lblC3','not reserved');
insert into carCells values('lblC4','not reserved');
insert into carCells values('lblD1','not reserved');
insert into carCells values('lblD2','not reserved');
insert into carCells values('lblD3','not reserved');
insert into carCells values('lblD4','not reserved');
insert into carCells values('lblE1','not reserved');
insert into carCells values('lblE2','not reserved');
insert into carCells values('lblE3','not reserved');
insert into carCells values('lblE4','not reserved');
insert into carCells values('lblF1','not reserved');
insert into carCells values('lblF2','not reserved');
insert into carCells values('lblF3','not reserved');
insert into carCells values('lblF4','not reserved');
insert into carCells values('lblG1','not reserved');
insert into carCells values('lblG2','not reserved');
insert into carCells values('lblG3','not reserved');
insert into carCells values('lblG4','not reserved');
insert into carCells values('lblH1','not reserved');
insert into carCells values('lblH2','not reserved');
insert into carCells values('lblH3','not reserved');
insert into carCells values('lblH4','not reserved');
insert into carCells values('lblI1','not reserved');
insert into carCells values('lblI2','not reserved');
insert into carCells values('lblI3','not reserved');
insert into carCells values('lblI4','not reserved');
insert into carCells values('lblJ1','not reserved');
insert into carCells values('lblJ2','not reserved');
insert into carCells values('lblJ3','not reserved');
insert into carCells values('lblJ4','not reserved');
insert into carCells values('lblK1','not reserved');
insert into carCells values('lblK2','not reserved');
insert into carCells values('lblK3','not reserved');
insert into carCells values('lblK4','not reserved');
insert into carCells values('lblL1','not reserved');
insert into carCells values('lblL2','not reserved');
insert into carCells values('lblL3','not reserved');
insert into carCells values('lblL4','not reserved');
insert into carCells values('lblM1','not reserved');
insert into carCells values('lblM2','not reserved');
insert into carCells values('lblM3','not reserved');
insert into carCells values('lblM4','not reserved');
insert into carCells values('lblN1','not reserved');
insert into carCells values('lblN2','not reserved');
insert into carCells values('lblN3','not reserved');
insert into carCells values('lblN4','not reserved');


create table defaultPayment(
id int not null auto_increment,
cid varchar(20),
cellId varchar(20)not null,
inTime varchar(20)not null,
outTime varchar(20)not null,
constraint primary key(id),
constraint foreign key(cellId)references carCells(cellId)
);

alter table defaultPayment add invoiceNumber varchar(100);

create table payment(
invoice varchar(100)not null,
payment varchar(100)not null,
date varchar(20)not null
);

create table package(
id varchar(20)primary key,
type varchar(100)not null,
price varchar(100)not null
);

create table packageCells(
cellId varchar(20)primary key,
status varchar(20)not null
);

create table packagePayment(
id varchar(20),
price varchar(100)not null,
cellid varchar(10)not null,
inDate varchar(100)not null,
outDate varchar(100)not null,
invoice varchar(100)not null,
cid varchar(20)not null,
constraint foreign key(id)references package(id),
constraint foreign key(cellid)references packageCells(cellId),
constraint foreign key(cid) references customer(id)
);



insert into packageCells values ('lblA1P','not reserved');
insert into packageCells values ('lblA2P','not reserved');
insert into packageCells values ('lblB1P','not reserved');
insert into packageCells values ('lblB2P','not reserved');
insert into packageCells values ('lblC1P','not reserved');
insert into packageCells values ('lblC2P','not reserved');
insert into packageCells values ('lblD1P','not reserved');
insert into packageCells values ('lblD2P','not reserved');
insert into packageCells values ('lblE1P','not reserved');
insert into packageCells values ('lblE2P','not reserved');
insert into packageCells values ('lblF1P','not reserved');
insert into packageCells values ('lblF2P','not reserved');