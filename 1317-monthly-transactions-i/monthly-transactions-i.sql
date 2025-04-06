# Write your MySQL query statement below
SELECT 
DATE_FORMAT(trans_date, "%Y-%m") as month, 
country,
 COUNT(id)AS trans_count,
 COUNT(CASE WHEN state = 'approved' Then 1 END) as approved_count,
 SUM(amount) As trans_total_amount,
 SUM( CASE WHEN t.state = 'approved' THEN amount ELSE 0 END) AS approved_total_amount
 FROM Transactions t
 GROUP BY DATE_FORMAT(trans_date, "%Y-%m"), country