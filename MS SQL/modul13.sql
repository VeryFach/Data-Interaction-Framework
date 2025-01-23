use DBSS_052

--Nomer 1
Create procedure GetAdvisor
@name varchar (50)
as 
select *
from advisor a 
join student s on s.ID=a.s_ID
join instructor i on i.ID=a.i_ID
where s.name = @name

Execute GetAdvisor 'Manber'

--Nomer 2
Create procedure GetCourse
@name varchar(50)
as
Select *
from course c
join takes t on c.course_id=t.course_id
join student s on s.ID=t.ID
where s.name = @name
Execute GetCourse 'Manber'

--Nomer 3
--Nomer 3
CREATE FUNCTION [dbo].GetNilaiHuruf
(@nilaiAngka INT)
RETURNS VARCHAR(5)
AS
BEGIN
    DECLARE @Grade VARCHAR(5);
    SET @Grade =
    CASE
        WHEN @nilaiAngka > 85 AND @nilaiAngka <= 100 THEN 'A'
        WHEN @nilaiAngka > 80 AND @nilaiAngka <= 85 THEN 'A-'
        WHEN @nilaiAngka > 75 AND @nilaiAngka <= 80 THEN 'B+'
        WHEN @nilaiAngka > 70 AND @nilaiAngka <= 75 THEN 'B'
        WHEN @nilaiAngka > 65 AND @nilaiAngka <= 70 THEN 'B-'
        WHEN @nilaiAngka > 60 AND @nilaiAngka <= 65 THEN 'C+'
        WHEN @nilaiAngka > 55 AND @nilaiAngka <= 60 THEN 'C'
        WHEN @nilaiAngka > 40 AND @nilaiAngka <= 55 THEN 'D'
        WHEN @nilaiAngka <= 40 THEN 'E'
    END;
    RETURN @Grade;
END;
select dbo.GetNilaiHuruf(98)

--Nomer 4
--Nomer 4
SELECT 
    t.ID,
    t.course_id,
    t.sec_id,
    t.semester,
    t.year,
    t.score,
    dbo.GetNilaiHuruf(t.score) AS grade,
    s.ID AS student_id,
    s.name,
    s.dept_name,
    s.tot_cred
FROM takes t
JOIN student s ON s.ID = t.ID
WHERE dbo.GetNilaiHuruf(t.score) IN ('A', 'A-');


