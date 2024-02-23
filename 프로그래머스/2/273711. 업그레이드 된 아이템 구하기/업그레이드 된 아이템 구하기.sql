select ITEM_ID,ITEM_NAME, RARITY
from ITEM_TREE t
natural join ITEM_INFO i
where t.PARENT_ITEM_ID in 
    (select ITEM_ID 
     from ITEM_INFO 
     where rarity = 'RARE')
ORDER BY ITEM_ID desc