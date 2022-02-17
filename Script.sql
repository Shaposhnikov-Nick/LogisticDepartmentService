create database logistic_department

create table drivers(
id serial primary key not null,
name varchar(50) not null,
surname varchar(50) not null,
driver_license_category_b boolean default false,
driver_license_category_c boolean default false,
driver_license_category_d boolean default false,
driver_license_validity date not null
)


insert into drivers (id, name, surname, driver_license_category_b, driver_license_category_c, driver_license_category_d, driver_license_validity) values (0, 'None', 'None', true, true, true, '2055-12-31')
insert into drivers (name, surname, driver_license_category_b, driver_license_category_c, driver_license_category_d, driver_license_validity) values('Nick', 'Ivanov', true, true, false, '2022-11-08')
insert into drivers (name, surname, driver_license_category_b, driver_license_category_c, driver_license_category_d, driver_license_validity) values('Daria', 'Petrova', true, false, true, '2025-04-17')
insert into drivers (name, surname, driver_license_category_b, driver_license_category_c, driver_license_category_d, driver_license_validity) values('Ivan', 'Ivanov', false, true, false, '2032-06-01')


create table transports(
id serial primary key not null,
model varchar(70) not null,
category varchar(1) not null check (category in ('B', 'C','D')),
driver_id integer references drivers(id)
)

insert into transports (model, category, driver_id) values ('Honda', 'D', 0)

insert into transports (model, category, driver_id) values ('Toyota', 'B', 0)

insert into transports (model, category, driver_id) values ('Subaru', 'C', 0)

insert into transports (model, category, driver_id) values ('AUDI', 'D', 0)







