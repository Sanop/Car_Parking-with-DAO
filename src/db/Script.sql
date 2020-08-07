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
cellid varchar(10)not null,
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
insert into carCells values('lblD1','not reserved');
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
