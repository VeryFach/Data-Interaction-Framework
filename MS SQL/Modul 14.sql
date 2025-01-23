--Soal 1
USE DBSS_052

BEGIN TRY
    BEGIN TRANSACTION
        INSERT INTO section 
        VALUES (
            (SELECT course_id FROM course WHERE title = 'Game Programming' AND dept_name = 'Comp. Sci.'),
            1, 'Spring', 2004, 'Power', 717, 'A'
        )
        INSERT INTO takes 
        VALUES (
            (SELECT ID FROM student WHERE name = 'Manber'),
            (SELECT course_id FROM course WHERE title = 'Game Programming' AND dept_name = 'Comp. Sci.'),
            1, 'Spring', 2004, 98, 'A+'
        )
    COMMIT TRANSACTION
END TRY
BEGIN CATCH
    IF @@TRANCOUNT > 0
        ROLLBACK TRANSACTION
    PRINT ERROR_MESSAGE();
END CATCH

SELECT * FROM section WHERE course_id = (SELECT course_id FROM course WHERE title = 'Game Programming' AND dept_name = 'Comp. Sci.')
SELECT * FROM takes WHERE course_id = (SELECT course_id FROM course WHERE title = 'Game Programming' AND dept_name = 'Comp. Sci.')

--Soal 2
BEGIN TRY
BEGIN TRANSACTION
UPDATE student
SET tot_cred = (
SELECT SUM(course.credits)
FROM takes
JOIN course ON takes.course_id = course.course_id
WHERE takes.ID = (
SELECT TOP 1 ID
FROM student
WHERE name = 'Manber'
)
)
WHERE ID = (
SELECT TOP 1 ID
FROM student

WHERE name = 'Manber'
)
COMMIT TRANSACTION
END TRY
BEGIN CATCH
IF @@TRANCOUNT > 0
ROLLBACK TRANSACTION
PRINT ERROR_MESSAGE();
END CATCH
SELECT * FROM student WHERE name = 'Manber'

