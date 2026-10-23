SELECT e.name
FROM employee AS e
JOIN employee AS m 
ON e.id = m.managerid
GROUP BY e.id , e.name
HAVING COUNT(m.managerid) >= 5;