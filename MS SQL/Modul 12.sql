USE DBSS_052;

--NOMOR 1
SELECT * FROM instructor i
WHERE NOT EXISTS (SELECT * FROM teaches t WHERE t.ID = i.ID)
--NOMOR 2
SELECT * FROM course c WHERE c.course_id IN (SELECT t.course_id FROM teaches t
JOIN teaches t1 ON t1.course_id = t.course_id WHERE t.ID != t1.ID GROUP BY
t.course_id HAVING COUNT(t.course_id) >=2)

--NOMOR 3
SELECT s.ID, s.name, COUNT(*) AS TotalA
FROM takes t
JOIN student s ON t.ID = s.ID
WHERE t.grade = 'A'
GROUP BY s.ID, s.name
HAVING COUNT(*) = (
    SELECT MAX(A_Count)
    FROM (
        SELECT COUNT(*) AS A_Count
        FROM takes
        WHERE grade = 'A'
        GROUP BY ID
    ) AS Subquery
);

--SOAL PENGAYAAN 

--NOMOR 1
USE DBSS_052;

SELECT course_id, title, dept_name, credits
FROM course
WHERE credits > (
    SELECT AVG(credits) 
    FROM course AS c
    WHERE c.dept_name = course.dept_name
);
--NOMOR 2 
USE DBSS_052;

SELECT s.name, t.score
FROM student s
JOIN takes t ON s.ID = t.ID
JOIN course c ON t.course_id = c.course_id
WHERE c.title = 'Manufacturing' 
  AND t.score = (
      SELECT MAX(score)
      FROM takes t2
      JOIN course c2 ON t2.course_id = c2.course_id
      WHERE c2.title = 'Manufacturing'
);




