-- 코드를 작성해주세요
SELECT table1.ID, IFNULL(table2.CHILD_COUNT, 0) as CHILD_COUNT
FROM
ECOLI_DATA table1
LEFT OUTER JOIN
(
SELECT a.ID, COUNT(a.ID) as CHILD_COUNT
FROM 
    ECOLI_DATA a
    JOIN 
    ECOLI_DATA b
    ON
    a.ID = b.PARENT_ID
GROUP BY a.ID
) as table2
ON table1.ID = table2.ID

;
