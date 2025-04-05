# Write your MySQL query statement below

WITH report AS(
Select managerid, COUNT(managerid) AS reports
    from employee
    group by managerId
  
)
Select name
from report a
Join Employee b
On a.managerid = b.id
WHERE a.reports >=5