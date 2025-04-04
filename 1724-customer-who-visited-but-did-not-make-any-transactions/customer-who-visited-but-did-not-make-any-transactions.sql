# Write your MySQL query statement below
SELECT Visits.customer_id, COUNT(Visits.customer_id) AS count_no_trans
FROM Visits
Left Join Transactions
ON Visits.visit_id = Transactions.visit_id 
WHERE Transactions.transaction_id is NUll
Group By (Visits.customer_id);
