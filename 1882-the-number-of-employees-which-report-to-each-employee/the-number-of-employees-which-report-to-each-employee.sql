# Write your MySQL query statement below
SELECT managers.employee_id, e.name, reports_count, average_age
From(SELECT reports_to as employee_id, COUNT(reports_to) AS reports_count, ROUND(AVG(age)) AS average_age FROM Employees  group by reports_to) AS managers
JOIN Employees e
ON e.employee_id = managers.employee_id
ORDER BY e.employee_id