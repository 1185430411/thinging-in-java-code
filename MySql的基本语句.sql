CREATE TABLE dept (
    DEPTNO INT(2),
    DNAME VARCHAR(14),
    LOC VARCHAR(13)
);

INSERT INTO dept values(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept values(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept values(30, 'SALES', 'CHICAGO');
INSERT INTO dept values(40, 'OPERATIONS', 'BOSTON');


CREATE TABLE emp (
    EMPNO INT(4),
    ENAME VARCHAR(10),
    JOB VARCHAR(9),
    MGR INT(4),
    HIREDATE DATE,
    SAL DOUBLE(7 , 2 ),
    COMM DOUBLE(7 , 2 ),
    DEPTNO INT(2)
);

INSERT INTO emp values(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp values(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO emp values(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);
INSERT INTO emp values(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20);
INSERT INTO emp values(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
INSERT INTO emp values(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);
INSERT INTO emp values(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);
INSERT INTO emp values(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20);
INSERT INTO emp values(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp values(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO emp values(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20);
INSERT INTO emp values(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);
INSERT INTO emp values(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);
INSERT INTO emp values(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);


CREATE TABLE salgrade (
    GRADE INT(11),
    HISAL INT(11),
    LOSAL INT(11)
);

INSERT INTO SALGRADE VALUES (1,1200,700); 
INSERT INTO SALGRADE VALUES (2,1400,1201); 
INSERT INTO SALGRADE VALUES (3,2000,1401);
INSERT INTO SALGRADE VALUES (4,3000,2001);
INSERT INTO SALGRADE VALUES (5,9999,3001);



SELECT 
    ename, job
FROM
    emp;

SELECT 
    *
FROM
    emp;

SELECT 
    ename, job, sal * 12 AS yearsalary
FROM
    emp;

SELECT 
    *
FROM
    emp
WHERE
    sal > 1000 AND sal < 5000;

SELECT 
    *
FROM
    emp
WHERE
    job = 'clerk' OR job = 'analyst';

SELECT 
    *
FROM
    emp
WHERE
    job IN ('clerk' , 'analyst');

SELECT 
    *
FROM
    emp
WHERE
    job NOT IN ('clerk' , 'analyst');

SELECT 
    *
FROM
    emp
WHERE
    ename LIKE 'A%';

SELECT 
    *
FROM
    emp
WHERE
    ename LIKE '%A%';

SELECT 
    *
FROM
    emp
WHERE
    ename LIKE '_A%';
 
 -- 根据薪水升序排序
SELECT 
    ename, sal
FROM
    emp
ORDER BY sal;
 
 -- 根据薪水降序排序
SELECT 
    *
FROM
    emp
ORDER BY sal DESC;
 
-- 优先根据姓名，再到薪水排
SELECT 
    *
FROM
    emp
ORDER BY ename , sal;
 
 -- 转换为小写
SELECT 
    LOWER(ename)
FROM
    emp;
 
 -- 转为大写
SELECT 
    UPPER(ename)
FROM
    emp;
 
 -- 查询并显示员工名字的第二个字母 substr
SELECT 
    SUBSTR(ename, 2, 1)
FROM
    emp;-- 从第二个开始，取一个
 
SELECT 
    ename, LENGTH(ename) AS enamelength
FROM
    emp;
 
 -- ifnull
SELECT 
    ename, IFNULL(comm, 0) AS comm
FROM
    emp;
    
    
    -- case when then end 不会改变表中数据，只会更改显示内容
SELECT 
    ename,
    sal,
    (CASE job
        WHEN 'salesman' THEN sal * 1.5
        WHEN 'manager' THEN sal * 1.1
        ELSE sal
    END)
FROM
    emp;
    
    -- round
SELECT 
    ename, ROUND(sal, 2)
FROM
    emp;
    
    -- mysql能识别yyyy-mm-dd或者yyy/mm/dd或者yyyymmdd的字符串作为日期类,其他格式的字符串需要进行转换
SELECT 
    *
FROM
    emp
WHERE
    hiredate = '1981-12-03';
    
    -- str_to_date
SELECT 
    *
FROM
    emp
WHERE
    hiredate = STR_TO_DATE('12-03-1981', '%m-%d-%Y');
    
    
    -- date_format
SELECT 
    DATE_FORMAT(hiredate, '%m-%d-%Y')
FROM
    emp;
    
    -- sum
SELECT 
    SUM(sal)
FROM
    emp;
    
    -- avg max min
    
SELECT 
    AVG(sal), MAX(sal), MIN(sal)
FROM
    emp;
    
    -- count 数据总条数
SELECT 
    COUNT(*)
FROM
    emp;
    
SELECT 
    (COUNT(*) - COUNT(comm))
FROM
    emp;
    -- distinct：重复的数据只显示一条
SELECT DISTINCT
    job
FROM
    emp;
    
    -- 同时不同
SELECT DISTINCT
    job, deptno
FROM
    emp;
    
    -- group by 每个职位的最高薪水
SELECT 
    MAX(sal)
FROM
    emp
GROUP BY job;

SELECT 
    job, MAX(sal) AS maxsal
FROM
    emp
GROUP BY job
ORDER BY maxsal;

SELECT 
    deptno, job, MAX(sal) AS maxsal
FROM
    emp
GROUP BY deptno , job;
-- where后不能跟聚合函数。如果需要接聚合函数,要用having
SELECT 
    job, AVG(sal) AS avgsal
FROM
    emp
GROUP BY job
HAVING avgsal > 2000;
