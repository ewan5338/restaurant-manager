CREATE TABLE employees (
    id int(11) NOT NULL AUTO_INCREMENT,
    address varchar(255),
    email varchar(255),
    full_name varchar(255),
    password varchar(40),
    role varchar(255),
    username varchar(40),
    payrate varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE items (
    id int(11) NOT NULL AUTO_INCREMENT,
    amount int(11),
    item varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE items_cart (
    id int(11) NOT NULL AUTO_INCREMENT,
    item_id int(11),
    item_name varchar(255),
    manager_id int(11),
    manager_name varchar(255),
    quantity int(11),
    status varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE menu_items (
    id int(11) NOT NULL AUTO_INCREMENT,
    item_type varchar(255),
    item varchar(255),
    price double,
    PRIMARY KEY (id)
);

CREATE TABLE schedules (
    id int(11),
    employee_name varchar(255),
    monday varchar(255),
    tuesday varchar(255),
    wednesday varchar(255),
    thursday varchar(255),
    friday varchar(255),
    saturday varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE schedules_date (
    id int(11),
    date varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE tables (
    id int(11) NOT NULL AUTO_INCREMENT,
    calls_for_service varchar(255),
    table_name varchar(255),
    table_status varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE table_carts (
    id int(11) NOT NULL AUTO_INCREMENT,
    item_id int(11),
    item_name varchar(255),
    quantity int(11),
    status varchar(255),
    table_id int(11),
    table_name varchar(255),
    total float,
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id int(11),
    password varchar(40),
    role varchar(255),
    username varchar(40),
    PRIMARY KEY(id)
);

INSERT INTO users (id, password, role, username) VALUES
    ('901', 'borby', 'MANAGER', 'ricky'),
    ('902', 'bravo123', 'EMPLOYEE', 'johnny_bravo'),
    ('903', 'black123', 'EMPLOYEE', 'rebecca_black'),
    ('904', 'neff123', 'MANAGER', 'will_neff'),
    ('200', 'table1', 'TABLE', 'Table 1'),
    ('201', 'table2', 'TABLE', 'Table 2'),
    ('202', 'table3', 'TABLE', 'Table 3'),
    ('203', 'table4', 'TABLE', 'Table 4'),
    ('204', 'table5', 'TABLE', 'Table 5'),
    ('205', 'table6', 'TABLE', 'Table 6');

INSERT INTO employees (id, address, email, full_name, password, role, username, payrate) VALUES
    ('902', '78 West Blvd.', 'johnny@gmail.com', 'Johnny Bravo', 'bravo123', 'EMPLOYEE', 'johnny_bravo', '$10.50'),
    ('903', '5 Spring Garden St,', 'rebecca@uncg.edu', 'Rebecca Black', 'black123', 'EMPLOYEE', 'rebecca_black', '$12.50'),
    ('904', '101 Ayo Rd.', 'dawgpog@gmail.com', 'Will Neff', 'neff123', 'MANAGER', 'will_neff', '$12.00');

INSERT INTO items (id, amount, item) VALUES
    ('1', '50', 'Chicken Broth'),
    ('2', '24', 'Sprite'),
    ('3', '5', 'Udon Noodles'),
    ('4', '15', 'Carrots');

INSERT INTO tables (id, table_name, table_status, calls_for_service) VALUES
    (200, 'Table 1', 'Open', 'Okay'),
    (201, 'Table 2', 'Open', 'Okay'),
    (202, 'Table 3', 'Open', 'Okay'),
    (203, 'Table 4', 'Open', 'Okay'),
    (204, 'Table 5', 'Open', 'Okay'),
    (205, 'Table 6', 'Open', 'Okay');

INSERT INTO schedules_date (id, date) VALUES
    (1, 'November 12, 2022 - November 29, 2022');

INSERT INTO schedules (id, employee_name, monday, tuesday, wednesday, thursday, friday, saturday) VALUES
    (902, 'Johnny Bravo', '8:00 AM - 3:00 PM', '8:00 AM - 3:00 PM', 'Off', '8:00 AM - 3:00 PM', '8:00 AM - 3:00 PM', '9:00 AM - 12:00 PM'),
    (903, 'Rebecca Black', '10:00 AM - 5:00 PM', '8:00 AM - 3:00 PM', 'Off', 'Off', '9:30 AM - 4:30 PM', '9:00 AM - 12:00 PM'),
    (904, 'Will Neff', 'Off', '7:00 AM - 2:00 PM', 'Off', '8:30 AM - 3:30 PM', 'Off', '9:00 AM - 12:30 PM');

INSERT INTO menu_items (id, item_type, item, price) VALUES
    (1, 'Custom', 'Bone Broth Soup', 8.55),
    (2, 'Custom', 'Spicy Soup', 9.55),
    (3, 'Custom', 'Chicken Soup', 7.25),
    (4, 'Custom', 'Addition: Carrots', 0),
    (5, 'Custom', 'Addition: Udon Noodles', 0),
    (6, 'Custom', 'Addition: Spinach', 0),
    (7, 'Meal', 'Bulgogi', 10.25),
    (8, 'Meal', 'Korean Fried Chicken', 12.75),
    (9, 'Meal', 'Bibimbap', 9.99),
    (10, 'Dessert', 'Chocolate Cake', 5.99),
    (11, 'Dessert', 'Mochi', 3.99),
    (12, 'Dessert', 'Dasik (Tea Cookies)', 4.55),
    (13, 'Drink', 'Water', 0.99),
    (14, 'Drink', 'Soft Drink', 1.25);