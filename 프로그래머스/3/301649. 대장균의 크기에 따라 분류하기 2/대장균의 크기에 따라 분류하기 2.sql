SELECT
    q1.ID,
    CASE 
        WHEN (cast(s_rank as float) / total_count) * 100 <= 25 THEN 'CRITICAL'
        WHEN (cast(s_rank as float) / total_count) * 100 <= 50 THEN 'HIGH'
        WHEN (cast(s_rank as float) / total_count) * 100 <= 75 THEN 'MEDIUM'
        ELSE 'LOW' 
    END AS COLONY_NAME
FROM 
    ecoli_data q1
JOIN
    (
    SELECT ID, 
           RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS s_rank, 
           COUNT(*) OVER () AS total_count
    FROM ecoli_data
    ) q2
    ON q1.id = q2.id
ORDER BY q1.id;
