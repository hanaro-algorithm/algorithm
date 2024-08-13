-- 코드를 작성해주세요
SELECT i.ITEM_ID, i.ITEM_NAME, i.RARITY
FROM ITEM_INFO i
left join ITEM_TREE t
on i.ITEM_ID = t.parent_item_id 
where t.parent_item_id is null # 누구의 부모도 아니면 됨
order by i.item_id desc;
;