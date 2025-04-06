# Write your MySQL query statement below
SELECT query_name, ROUND(AVG(rating/q.position), 2) AS quality, 
    ROUND(COUNT(CASE WHEN rating < 3 Then 1 END) * 100/COUNT(query_name), 2) AS poor_query_percentage
FROM Queries q
GROUP BY q.query_name