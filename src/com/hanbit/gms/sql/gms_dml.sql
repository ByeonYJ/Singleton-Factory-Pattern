-- id,name,password,ssn,regdate 자바의 Bean과 DB의 값이 일치해야한다
INSERT INTO Member(id,name,password,ssn,regdate)--DML 구조 (컬럼명 : id,name,password,ssn,regdate)
VALUES('hong','홍길동','1','861114-1025114',SYSDATE);--""가 아닌 ''로 문자열을 표기
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('byeon','변용주','a','861014-1030114',SYSDATE);--SYSDATE는 자동으로 날짜를 계산해주는 명령어
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim','김하윤','a','931122-2015415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('cho','조봉기','a','842115-1014415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('hong','홍지후','a','891115-1035415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('park','박준용','a','881135-1019415',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('song','송상훈','a','861125-1013315',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim2','김기근','a','851125-1014615',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim1','김기근','a','851015-1014615',SYSDATE);
INSERT INTO Member(id,name,password,ssn,regdate) VALUES('kim3','김기군','a','851015-1014615',SYSDATE);
SELECT * FROM Member;--getter call이라고 한다
SELECT * FROM Member WHERE name ='김기근';
SELECT COUNT(*) AS count FROM Member;--모든 카운트를 가져온다, 함수 이름은 COUNT(*)다
SELECT * FROM Member WHERE id='cho';
UPDATE Member SET password='2' WHERE id='kim';
DELETE FROM Member WHERE id='kim3';
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'byeon','부러진 검','부러진건 다시 붙이면 돼',0,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'kim','회피','나에게 진짜 무기가 있었다면 어땠겠소',1,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'cho','우주류검술','당신의 실력은 형편없소',2,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'song','5픽 티모요','후후카카헤헤',98,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'kim2','혼령질주','미드는 로밍이 생명',133,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'hong','아따따뚜겐','용권선풍각',411,SYSDATE);
INSERT INTO board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'byeon','aa','aa',0,SYSDATE);
SELECT * FROM Board;