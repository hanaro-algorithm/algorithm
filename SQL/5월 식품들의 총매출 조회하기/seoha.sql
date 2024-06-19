SELECT FP.product_id, FP.product_name, SUM(FP.price * FO.amount) as total_sales
from food_product as FP
    join food_order as FO
        ON FP.product_id = FO.product_id
where FO.produce_date LIKE '2022-05-%'
group by FP.product_id
order by total_sales desc, FP.product_id