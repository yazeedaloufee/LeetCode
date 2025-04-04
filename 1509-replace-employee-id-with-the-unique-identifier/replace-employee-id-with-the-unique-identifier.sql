# Write your MySQL query statement below
SELECT unique_id, name
FROM Employees
Left Join EmployeeUNI
On Employees.id = EmployeeUNI.id;