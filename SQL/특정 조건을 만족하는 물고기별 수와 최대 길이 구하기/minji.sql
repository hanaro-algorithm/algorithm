select FISH_COUNT, MAX_LENGTH, FISH_TYPE
from (
select fish_type, avg(length) as avg_fish, max(length) as max_length, count(*) as fish_count
from (select fish_type, ifnull(length, 10) as length from fish_info) fish_info2
group by fish_type) fish_info3
where max_length >= 33
order by fish_type asc;