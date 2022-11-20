SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE cart
(
	cid int NOT NULL AUTO_INCREMENT,
	pid int NOT NULL,
	oid int NOT NULL,
	quantity int DEFAULT 0 NOT NULL,
	PRIMARY KEY (cid)
);


CREATE TABLE orders
(
	oid int NOT NULL AUTO_INCREMENT,
	odate datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
	oprice int DEFAULT 0 NOT NULL,
	uid varchar(10) NOT NULL,
	PRIMARY KEY (oid)
);


CREATE TABLE products
(
	pid int NOT NULL AUTO_INCREMENT,
	pname varchar(20) NOT NULL,
	cost int NOT NULL,
	price int NOT NULL,
	PRIMARY KEY (pid)
);


CREATE TABLE users
(
	uid varchar(10) NOT NULL,
	uname varchar(8) NOT NULL,
	tel varchar(14) NOT NULL,
	pwd char(44),
	PRIMARY KEY (uid)
);



/* Create Foreign Keys */

ALTER TABLE cart
	ADD FOREIGN KEY (oid)
	REFERENCES orders (oid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE cart
	ADD FOREIGN KEY (pid)
	REFERENCES products (pid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE orders
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



