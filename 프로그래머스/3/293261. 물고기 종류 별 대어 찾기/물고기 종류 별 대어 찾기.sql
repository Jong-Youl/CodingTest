-- 코드를 작성해주세요
select ID, view1.FISH_NAME, view1.LENGTH
from 
(
select a1.ID, b1.FISH_NAME, a1.LENGTH
from FISH_INFO a1
    inner join
    FISH_NAME_INFO b1
    on a1.FISH_TYPE = b1.FISH_TYPE
) view1
join
(
select a2.FISH_NAME, max(b2.LENGTH) as LENGTH
from
FISH_NAME_INFO as a2
inner join
(
    select *
    from fish_info
    where LENGTH is not null
) as b2
on a2.FISH_TYPE = b2.FISH_TYPE
group by a2.FISH_NAME
) view2
on view1.FISH_NAME = view2.FISH_NAME AND view1.LENGTH = view2.LENGTH
order by ID
;