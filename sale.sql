create database sales_management;
use sales_management;
create table category(
                         id int auto_increment primary key,
                         name varchar(50)
);
insert into category (name) values ('WOMAN'),
                                   ('ACCESSORIES'),
                                   ('MEN');
create table product (
                         id int primary key auto_increment,
                         name varchar(100),
                         price double,
                         description varchar(100),
                         category_id int,
                         image varchar(100),
                         foreign key (category_id) references category(id)
);
create table role(
                     id int primary key auto_increment,
                     name varchar(10)
);
create table user(
                     id int primary key auto_increment,
                     username varchar(50) unique,
                     address varchar(50),
                     phone varchar(50),
                     password varchar(50),
                     role_id int,
                     foreign key (role_id) references role(id)
);
create table cart(
                     id int primary key auto_increment,
                     user_id int,
                     orderDate date,
                     foreign key (user_id) references user(id)
);
create table orderDetail(
                            id int primary key auto_increment,
                            cart_id int,
                            product_id int,
                            quantity int,
                            foreign key (cart_id) references cart(id),
                            foreign key (product_id) references product(id)
);
insert into product(name, price, description, category_id, image) VALUES
                                                                      ('Long Dress',30,'New item',1,'https://target.scene7.com/is/image/Target/GUEST_d208cad5-144e-4ece-81b0-a3736a9aa0c9?wid=325&hei=325&qlt=80&fmt=pjpeg'),
                                                                      ('Graphic T-Shirt',25,'New item',1,'https://target.scene7.com/is/image/Target/GUEST_4da17e0c-5635-4a05-90c0-b9f919e5a64d?wid=325&hei=325&qlt=80&fmt=pjpeg');
alter table product modify image varchar(256);
insert into role(name) values ('admin'),
                              ('user');
insert into user(username, address, phone, password, role_id) VALUES
                                                                  ('admin1','Ha Noi','0978518826','admin1',1),
                                                                  ('admin2','Ha Noi','0978518826','admin2',1),
                                                                  ('user1','Ha Noi','0978518826','user1',2),
                                                                  ('user2','Ha Noi','0978518826','user2',2),
                                                                  ('user3','Ha Noi','0978518826','user3',2);
insert into cart(user_id, orderDate) VALUES
    (3,'2022-03-09');
insert into orderdetail(cart_id, product_id, quantity) VALUES
    (1,2,2);
use sales_management;
alter table user add column status bit;
insert into user(username, address, phone, password, role_id,status) VALUES
('user4','HN','0123456789','user4',2,1);
alter table user add column email varchar(50);
alter table user drop column email;
alter table user add column email varchar(50) unique;




delimiter //
create procedure delete_category(in inputId int)
begin
update product set category_id = null where category_id = inputId;
delete from category where id = inputId;
end //
delimiter ;