# Write your MySQL query statement below
SELECT s.product_id  ,year AS first_year,quantity, price 
FROM Sales s
JOIN Product p 
ON s.product_id   = p.product_id  
Where (s.product_id  , s.year) IN ( SELECT a.product_id  , MIN(a.year) as year FROM Sales a GROUP BY a.product_id)