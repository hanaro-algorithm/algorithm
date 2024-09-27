SELECT a.rest_id, a.rest_name, a.food_type, a.favorites, a.address, c.score
from rest_info a
join (select b.rest_id, round(avg(b.review_score), 2) as score
     from rest_review b
     group by b.rest_id) c
on a.rest_id = c.rest_id and a.address like "서울%"
order by score desc, a.favorites desc