-- id,name,password,ssn,regdate
SELECT * FROM Member;
SELECT * FROM Board;
DROP TABLE Member;--DDL 구조
DROP SEQUENCE article_seq;

CREATE SEQUENCE article_seq
START WITH 1000--1000부터 시작한다는 뜻
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE TABLE Member(--DDL은 구조 
	id VARCHAR2(10),
	name VARCHAR2(10),
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(id)
);

CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(80),
	hitcount NUMBER,
	regdate DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES Member(id)
		ON DELETE CASCADE--누군가가 탈퇴하면 그 사람이 사용한 글까지 삭제해라 ON DELETE CASCADE
);

SELECT COUNT(*) AS article_seq FROM Board;