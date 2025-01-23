create database latihan1;
create table mahasiswa(mhs_id int primary key identity(1,1), nama varchar(100), telp varchar(15), alamat varchar(200), tgl_bergabung date)

create table mahasiswa2(mhs_id int primary key identity(10,2), nama varchar(100))
insert into mahasiswa2(nama) values ('babi')
select * from mahasiswa2
--cara set identity nya off
set identity_insert mahasiswa2 on
insert into mahasiswa2 (mhs_id, nama) values (19, 'babi hutan');

set identity_insert mahasiswa2 off
-- hanya boleh satu identity per tabel
create table jurusan(jurusan_id int identity(1,1) primary key, nama varchar(100), sks int identity(1,2))
insert into jurusan(nama) values ('bsi tolol goblok')

--sequence 
create sequence counter_item
as int
start with 1
increment by 1

select next value for counter_item

create table penjualan (order_id int, tanggal date)
create table pembelian (order_id int, tanggal date)

insert into penjualan(order_id, tanggal) values (next value for counter_item, GETDATE())
insert into pembelian(order_id, tanggal) values (next value for counter_item, GETDATE())

	select * from penjualan;
	select * from pembelian;

	--alter table
	alter table penjualan
	add totall money null, 
	keterangan varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS

	select * from pembelian

	alter table pembelian 
	add price dec(10,2) constraint ck_positivve_only CHECK(price >= 0)

	alter table pembelian
	drop constraint ck_positivve_only

	create table person(
	person_id int identity not null,
	first_name varchar(50) not null,
	middle_name varchar(50),
	last_name varchar(50),
	dob date
)
insert into person(first_name, middle_name, last_name, dob) values('Asep','','Komarudin','2003-02-23')
insert into person(first_name, middle_name, last_name, dob) values('bsi badjingan','','bank pantek','2003-02-23')

select concat(first_name, '', middle_name, '', last_name) as fullname, dob from person

alter table person
add full_name as (concat(first_name,' ', middle_name, ' ', last_name)) persisted

--select full_name,dob, DATEDIFF(year,dob,GETDATE()) as age from person

-- atau 

alter table person
add age as (DATEDIFF(year,dob,getdate()))

select full_name, dob, age from person

--rename tanle
exec sp_rename 'person', 'uwong'

drop table uwong

create table mahasiswa3(mhs_id int primary key, nama varchar(100))

alter table mahasiswa3
alter column nama varchar(50)