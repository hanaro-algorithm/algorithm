select new_c.car_id, new_c.car_type, new_c.fee
from (select c.car_id, c.car_type, ceil(c.daily_fee*(1-p.discount_rate*0.01)) as fee
from CAR_RENTAL_COMPANY_CAR as c, CAR_RENTAL_COMPANY_DISCOUNT_PLAN as p
where c.car_type in ('SUV', '세단') and p.car_type in ('SUV','세단') and p.duration_type = '30일 이상') as new_c
inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
on new_c.car_id = h.car_id
where h.end_date>=date('2022-11-01') and h.start_date<=date('2022-12-01')
order by new_c.fee desc, new_c.car_type asc, new_c.car_id;