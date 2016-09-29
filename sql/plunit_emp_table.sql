drop table emp;

CREATE TABLE emp (
  EMPNO NUMBER(4,0),
  ENAME VARCHAR2(10),
  JOB VARCHAR2(9),
  MGR NUMBER(4,0),
  HIREDATE DATE,
  SAL NUMBER(7,2),
  COMM NUMBER(7,2),
  DEPTNO NUMBER(2,0));


insert into emp values (7369, 'SMITH', 'CLERK', 7902, to_date('17-DEC-80'), 800, NULL, 20);
insert into emp values (7499, 'ALLEN', 'SALESMAN', 7698, to_date('20-FEB-81'), 1600, 300, 30);
insert into emp values (7521, 'WARD', 'SALESMAN', 7698, to_date('22-FEB-81'), 1250, 500, 30);
insert into emp values (7566, 'JONES', 'MANAGER', 7839, to_date('02-APR-81'), 2975, NULL, 20);
insert into emp values (7654, 'MARTIN', 'SALESMAN', 7698, to_date('28-SEP-81'), 1250, 1400, 30);
insert into emp values (7698, 'BLAKE', 'MANAGER', 7839, to_date('01-MAY-81'), 2850, NULL, 30);
insert into emp values (7782, 'CLARK', 'MANAGER', 7839, to_date('09-JUN-81'), 2450, NULL, 10);
insert into emp values (7788, 'SCOTT', 'ANALYST', 7566, to_date('19-APR-87'), 3000, NULL, 20);
insert into emp values (7839, 'KING', 'PRESIDENT', NULL, to_date('17-NOV-81'), 5000, NULL, 10);
insert into emp values (7844, 'TURNER', 'SALESMAN', 7698, to_date('08-SEP-81'), 1500, 0, 30);
insert into emp values (7876, 'ADAMS', 'CLERK', 7788, to_date('23-MAY-87'), 1100, NULL, 20);
insert into emp values (7900, 'JAMES', 'CLERK', 7698, to_date('03-DEC-81'), 950, NULL, 30);
insert into emp values (7902, 'FORD', 'ANALYST', 7566, to_date('03-DEC-81'), 3000, NULL, 20);
insert into emp values (7934, 'MILLER', 'CLERK', 7782, to_date('23-JAN-82'), 1300, NULL, 10);


commit;

