-- 코드를 작성해주세요
with recursive cte as (
    select ID, PARENT_ID, 1 as GENERATION
    from ECOLI_DATA
    union all
    select e.ID, e.PARENT_ID, cte.GENERATION + 1
    from cte
    join ECOLI_DATA e on e.PARENT_ID = cte.ID
)

SELECT COUNT(*) as COUNT, view.GENERATION
FROM (
select MAX(GENERATION) as GENERATION
from cte
WHERE cte.ID not in (select distinct PARENT_ID FROM ECOLI_DATA WHERE PARENT_ID is not NULL)
group by cte.ID
) as view
GROUP BY view.GENERATION
ORDER BY view.GENERATION asc;