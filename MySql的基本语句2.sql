
-- 92写法
SELECT 
    e.ename, d.dname
FROM
    emp e,
    dept d
WHERE
    e.deptno = d.deptno;

-- 99写法
SELECT 
    e.ename, d.dname
FROM
    emp e
        JOIN
    dept d ON e.deptno = d.deptno;
    
    -- 每个员工对应的薪资等级
SELECT 
    e.ename, e.sal, s.grade
FROM
    emp e
        JOIN
    salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
    
    -- 每个员工对应的领导  内链接
SELECT 
    e.ename, e1.ename
FROM
    emp e
        JOIN
    emp e1 ON e.MGR = e1.EMPNO;
    
    -- 左链接或者右链接，会把对应的表的对应数据都显示出来(把没有领导的king也显示出来了)
	SELECT 
    e.ename, e1.ename
FROM
    emp e
        RIGHT JOIN
    emp e1 ON e.MGR = e1.EMPNO;
    
    -- 三表链接
SELECT 
    e.ename, e.sal, d.dname, s.grade
FROM
    emp e
        JOIN
    dept d ON e.deptno = d.deptno
        JOIN
    salgrade s ON e.sal BETWEEN s.losal AND s.hisal;

-- 子查询
-- 找出每个部门平均薪资的薪水等级
-- 括号内容作为新表
SELECT 
    t.job, t.avgsal, s.grade
FROM
    salgrade s
        JOIN
    (SELECT 
        job, AVG(sal) AS avgsal
    FROM
        emp
    GROUP BY job) t ON t.avgsal BETWEEN s.losal AND s.hisal;


-- union 把两个表取交集
select ename,job from emp where job='manager'
union
select ename,job from emp where job='salesman';
