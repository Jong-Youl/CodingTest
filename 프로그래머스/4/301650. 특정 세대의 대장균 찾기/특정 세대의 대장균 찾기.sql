-- 코드를 작성해주세요
# 3세대 대장균 의 ID를 출력하는 SQL문
WITH recursive cte as (

    select ID, PARENT_ID, 1 as GENERATION
    from ECOLI_DATA   
    where PARENT_ID is NULL

    UNION ALL
    
    select b.ID, b.PARENT_ID, a.GENERATION + 1
    from cte as a
    inner join ECOLI_DATA as b ON a.ID = b.PARENT_ID
)


Select ID
From cte
where GENERATION = 3
ORDER BY ID ASC
;