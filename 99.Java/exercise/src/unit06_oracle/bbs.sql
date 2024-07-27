
/* Drop Triggers */

DROP TRIGGER TRI_board_bid;
DROP TRIGGER TRI_reply_rid;



/* Drop Tables */

DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_board_bid;
DROP SEQUENCE SEQ_reply_rid;




/* Create Sequences */

CREATE SEQUENCE SEQ_board_bid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_reply_rid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE board
(
	bid number NOT NULL,
	buid varchar2(16 char) NOT NULL,
	title varchar2(128 char) NOT NULL,
	content varchar2(4000 char),
	modTime timestamp DEFAULT SYSDATE,
	isDeleted number DEFAULT 0,
	viewCount number DEFAULT 0,
	replyCount number DEFAULT 0,
	files varchar2(400 char),
	PRIMARY KEY (bid)
);


CREATE TABLE reply
(
	rid number NOT NULL,
	"comment" varchar2(256 char) NOT NULL,
	regTime timestamp DEFAULT SYSDATE,
	isMine number DEFAULT 0,
	ruid varchar2(16 char) NOT NULL,
	rbid number NOT NULL,
	PRIMARY KEY (rid)
);


CREATE TABLE users
(
	"uid" varchar2(16 char) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar2(16 char) NOT NULL,
	email varchar2(32),
	regDate date DEFAULT SYSDATE,
	isDeleted number DEFAULT 0,
	"profile" varchar2(40 char),
	addr varchar2(32 char),
	PRIMARY KEY ("uid")
);



/* Create Foreign Keys */

ALTER TABLE reply
	ADD FOREIGN KEY (rbid)
	REFERENCES board (bid)
;


ALTER TABLE board
	ADD FOREIGN KEY (buid)
	REFERENCES users ("uid")
;


ALTER TABLE reply
	ADD FOREIGN KEY (ruid)
	REFERENCES users ("uid")
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_board_bid BEFORE INSERT ON board
FOR EACH ROW
BEGIN
	SELECT SEQ_board_bid.nextval
	INTO :new.bid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_reply_rid BEFORE INSERT ON reply
FOR EACH ROW
BEGIN
	SELECT SEQ_reply_rid.nextval
	INTO :new.rid
	FROM dual;
END;

/




