DROP DATABASE IF EXISTS cloudDB02;
CREATE DATABASE cloudDB02 CHARACTER SET UTF8;

use cloudDB02;
create TABLE dept (
  deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source VARCHAR(60)
) DEFAULT CHARSET=utf8;

INSERT INTO dept(dname,db_source) values('develop',DATABASE());
INSERT INTO dept(dname,db_source) values('operate',DATABASE());
INSERT INTO dept(dname,db_source) values('test',DATABASE());
INSERT INTO dept(dname,db_source) values('hr',DATABASE());
INSERT INTO dept(dname,db_source) values('finance',DATABASE());
INSERT INTO dept(dname,db_source) values('market',DATABASE());

select * from dept;
