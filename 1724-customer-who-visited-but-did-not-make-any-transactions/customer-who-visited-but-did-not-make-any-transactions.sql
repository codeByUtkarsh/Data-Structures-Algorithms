# Write your MySQL query statement below
SELECT customer_id , count(*) AS 'count_no_trans'
FROM visits v
LEFT JOIN Transactions t
          USING (visit_id)
WHERE transaction_id IS NULL
GROUP BY customer_id;