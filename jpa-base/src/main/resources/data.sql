insert into city (zip, name, state) values (98225, 'Bellingham', 'WA');
insert into city (zip, name, state) values (95388, 'Winton', 'CA');
insert into city (zip, name, state) values (44242, 'Stow', 'OH');
insert into city (zip, name, state) values (61536, 'Hanna name', 'IL');
insert into city (zip, name, state) values (01254, 'Richmond', 'MA');
insert into city (zip, name, state) values (95124, 'San Jose', 'CA');
insert into city (zip, name, state) values (95382, 'Turlock', 'MA');
insert into city (zip, name, state) values (95380, 'Turlock', 'CA');


insert into employee (id, name, city_zip, position) values (1201, 'Jones Hoffer', 98225, 'director');
insert into employee (id, name, city_zip, position) values (1202, 'Jeffrey Prescott', 95388, 'sales manager');
insert into employee (id, name, city_zip, position) values (1203, 'Fred NcFaddeb', 95124, 'assistant');


insert into book (id, title, author, pages, prize) values (10506, 'Accounting 101', 'John Smith', 200, 123.00);
insert into book (id, title, author, pages, prize) values (10507, 'Management 101', 'Anna McQueen', 159, 109.98);
insert into book (id, title, author, pages, prize) values (10508, 'Fraud Cases', 'Neville Astley', 190, 179.99);
insert into book (id, title, author, pages, prize) values (10509, 'CPA Review', 'James White', 65, 299.99);
insert into book (id, title, author, pages, prize) values (10601, 'Peachtree for Dummies', 'James White', 322, 49.99);
insert into book (id, title, author, pages, prize) values (10701, 'Financial Accounting', 'James White', 129, 164.99);
insert into book (id, title, author, pages, prize) values (10800, 'Managerial Accounting', 'Mark Baker', 155, 114.99);
insert into book (id, title, author, pages, prize) values (10900, 'cost accounting', 'Mark Baker', 122, 119.99);
insert into book (id, title, author, pages, prize) values (10901, 'Intermediate Accounting', 'John Smith', 123, 164.99);
insert into book (id, title, author, pages, prize) values (10902, 'XBRL in Nutshell', 'Mark Baker', 124, 109.99);


insert into customer (id, name, street, city_zip, phone) values (23511, 'Michelle Gold', '123 Main St.',98225, '360-636-5555');
insert into customer (id, name, street, city_zip, phone) values (23512, 'George Myer', '237 Ash Ave.',95124, '312-678-5555');
insert into customer (id, name, street, city_zip, phone) values (23513, 'Richard Gold', '123 Main St.',98225, '312-883-7337');
insert into customer (id, name, street, city_zip, phone) values (23514, 'Robert Smith', '54 Gate Dr.',95388, '206-832-1221');
insert into customer (id, name, street, city_zip, phone) values (23515, 'Christopher David', '777 Loto St.',98225, '360-458-9878');
insert into customer (id, name, street, city_zip, phone) values (23516, 'Adam Beethoven', '234 Park Rd..',95380, '209-546-7299');
insert into customer (id, name, street, city_zip, phone) values (23517, 'Lidwig Bach', '5790 Walnut St.',95382, '209-638-2712');


insert into orderdetails (id, book_id, customer_id, employee_id) values (1020, 10507, 23511, 1201);
insert into orderdetails (id, book_id, customer_id, employee_id) values (1021, 10507, 23511, 1203);
insert into orderdetails (id, book_id, customer_id, employee_id) values (1022, 10800, 23512, 1203);

