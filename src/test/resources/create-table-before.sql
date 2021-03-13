
delete from customer;
delete from address;

insert into address(id, country, region, city, street, house, flat, created, modified) values
(1, 'Россия', '54', 'Новосибирск', 'Закаменский мкр' , '50', '60', '2011-03-12', '2011-03-12');
insert into address(id, country, region, city, street, house, flat, created, modified) values
(2, 'Россия', '54', 'Новосибирск', 'Фрунзе' , '10', '30', '2021-03-08', '2021-03-08');


insert into customer(id, registred_address_id, actual_address_id, first_name, last_name, middle_name, sex) values
(1, 1, 1, 'Иван', 'Петров' , 'Иванович', 'male');
