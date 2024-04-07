# Write your MySQL query statement below
SELECT u.unique_id, name 
FROM Employees e
LEFT JOIN EmployeeUNI u
     ON e.id = u.id;
