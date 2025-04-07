# Write your MySQL query statement below
SELECT class 
FROM (SELECT class, COUNT(student) AS students FROM Courses GROUP BY class) as a
WHERE students >= 5