# Write your MySQL query statement below

SELECT s.student_id , s.student_name , r.subject_name , COUNT(e.student_id) AS attended_exams
FROM Students s
CROSS JOIN Subjects r
LEFT JOIN Examinations e
          ON s.student_id = e.student_id AND r.subject_name = e.subject_name
          GROUP BY s.student_id , r.subject_name , s.student_name
          ORDER BY s.student_id,r.subject_name