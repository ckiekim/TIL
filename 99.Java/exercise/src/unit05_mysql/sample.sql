SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS replies;
DROP TABLE IF EXISTS boards;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE boards
(
	bid int NOT NULL AUTO_INCREMENT,
	buid varchar(10) NOT NULL,
	title varchar(100) NOT NULL,
	content varchar(4096),
	modTime datetime DEFAULT NOW(), SYSDATE() NOT NULL,
	viewCount int DEFAULT 0 NOT NULL,
	replyCount int DEFAULT 0 NOT NULL,
	isDeleted int DEFAULT 0 NOT NULL,
	PRIMARY KEY (bid)
);


CREATE TABLE replies
(
	rid int NOT NULL AUTO_INCREMENT,
	rbid int NOT NULL,
	ruid varchar(10) NOT NULL,
	content varchar(256) NOT NULL,
	regTime datetime DEFAULT NOW(), SYSDATE() NOT NULL,
	PRIMARY KEY (rid)
);


CREATE TABLE users
(
	uid varchar(10) NOT NULL,
	uname varchar(8) NOT NULL,
	email varchar(20) NOT NULL,
	regDate date DEFAULT NOW(), SYSDATE() NOT NULL,
	isDeleted int DEFAULT 0 NOT NULL,
	PRIMARY KEY (uid),
	UNIQUE (uid)
);



/* Create Foreign Keys */

ALTER TABLE replies
	ADD FOREIGN KEY (rbid)
	REFERENCES boards (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE boards
	ADD FOREIGN KEY (buid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE replies
	ADD FOREIGN KEY (ruid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



