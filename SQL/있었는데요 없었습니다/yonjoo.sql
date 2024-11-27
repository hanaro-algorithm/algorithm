-- 코드를 입력하세요
SELECT i.animal_id, I.NAME
from animal_ins i, animal_outs o
where i.animal_id = o.animal_id and i.datetime > o.datetime
order by i.datetime;