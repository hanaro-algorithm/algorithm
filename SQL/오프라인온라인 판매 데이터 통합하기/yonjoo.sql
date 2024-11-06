-- 코드를 입력하세요

select date_format(SALES_DATE, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, null as USER_ID, SALES_AMOUNT
from OFFLINE_SALE
where month(SALES_DATE) = 3 and year(SALES_DATE) = 2022

union all

select date_format(SALES_DATE, "%Y-%m-%d") as SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
from ONLINE_SALE

where month(SALES_DATE) = 3 and year(SALES_DATE) = 2022

order by SALES_DATE asc, product_id asc, user_id asc