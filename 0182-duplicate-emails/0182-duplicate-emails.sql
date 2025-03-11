# Write your MySQL query statement below
select email from Person 
Group By email
Having count(email)>1;