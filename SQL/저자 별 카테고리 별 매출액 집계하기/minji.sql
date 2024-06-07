select a.author_id, a.author_name, bs.category, sum(bs.total_sales)
from (select b.category, b.author_id, (b.price*s.sales) as total_sales
from book as b
inner join book_sales as s
on b.book_id = s.book_id
where s.sales_date like '2022-01%') as bs
inner join author as a
on a.author_id = bs.author_id
group by author_name, category
order by author_id asc, category desc;