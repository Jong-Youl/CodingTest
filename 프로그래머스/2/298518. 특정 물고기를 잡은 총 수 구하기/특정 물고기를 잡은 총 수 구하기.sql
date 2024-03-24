-- 코드를 작성해주세요
select count(*) as FISH_COUNT
from 
    FISH_INFO as a
    join
    FISH_NAME_INFO as b
    on a.FISH_TYPE = b.FISH_TYPE
where b.FISH_NAME in ("BASS", "SNAPPER"); 
