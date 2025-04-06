# Write your MySQL query statement below
SELECT p.product_id, COALESCE(ROUND(sum(price * u.units)/sum(u.units),2),0) AS average_price
FROM Prices p
LEFT JOIN UnitsSold u
ON  p.product_id = u.product_id and purchase_date >= start_date and purchase_date <= end_date
GROUP BY product_id