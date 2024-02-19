-- 코드를 작성해주세요
select info.ITEM_ID, info.ITEM_NAME, info.RARITY
from ITEM_INFO as info join ITEM_TREE as tree on info.ITEM_ID = tree.ITEM_ID
where 
info.ITEM_ID 
not in 
(select distinct PARENT_ITEM_ID
from ITEM_TREE 
where PARENT_ITEM_ID is not null)

or 

info.ITEM_NAME in ('ITEM_C','ITEM_D','ITEM_E')

order by info.ITEM_ID desc;