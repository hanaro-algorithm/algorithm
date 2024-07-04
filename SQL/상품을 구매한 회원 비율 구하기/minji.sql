select year(sales_date) as year, month(sales_date) as month, 
    count(distinct s.user_id) as purchased_users,
    round(count(distinct s.user_id)/(select count(distinct user_id) 
                                    from user_info 
                                    where joined like '2021-%'), 1) as purchased_ratio
from online_sale s
left join user_info u
on u.user_id = s.user_id
where u.joined like '2021-%'
group by 1, 2
order by 1, 2;