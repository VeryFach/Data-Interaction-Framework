USE DBSS_052
SELECT *  FROM instructor where dept_name = 'Statistics' AND salary > 55000

SELECT TOP 10 * FROM student

SELECT dept_name FROM student

SELECT DISTINCT dept_name FROM student

SELECT * FROM student ORDER BY name ASC, dept_name ASC

select *, salary * 0.05 as tax, Salary - (salary * 0.05) as paid FROM instructor

