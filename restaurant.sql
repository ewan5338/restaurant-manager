CREATE TABLE employees (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    address varchar(255),
    email varchar(255),
    full_name varchar(255),
    password varchar(40),
    role varchar(255),
    username varchar(40),
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id int(11) NOT NULL AUTO_INCREMENT,
    password varchar(10),
    role varchar(255),
    username varchar(40),
    PRIMARY KEY(id)
);

CREATE TABLE items (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    amount bigint(20),
    item varchar(255),
    PRIMARY KEY(id)
);

INSERT INTO users (id, password, role, username) VALUES
    ('1', 'borby', 'MANAGER', 'ricky'),
    ('2', 'fisher123', 'EMPLOYEE', 'hanna_fisher'),
    ('3', 'parker123', 'EMPLOYEE', 'peter_parker'),
    ('4', 'smith123', 'MANAGER', 'john_smith');

INSERT INTO employees (id, address, email, full_name, password, role, username) VALUES
    ('1', '78 West Blvd.', 'johnny@gmail.com', 'Johnny Bravo', 'bravo123', 'EMPLOYEE', 'johnny_bravo'),
    ('2', '5 Spring Garden St,', 'rebecca@uncg.edu', 'Rebecca Black', 'black123', 'EMPLOYEE', 'rebecca_black'),
    ('3', '101 Ayo Rd.', 'dawgpog@gmail.com', 'Will Neff', 'neff123', 'EMPLOYEE', 'will_neff');

INSERT INTO items (id, amount, item) VALUES
    ('1', '50', 'Chicken Broth'),
    ('2', '24', 'Sprite'),
    ('3', '5', 'Udon Noodles'),
    ('4', '15', 'Carrots');
