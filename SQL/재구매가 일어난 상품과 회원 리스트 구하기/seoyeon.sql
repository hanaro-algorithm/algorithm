SELECT user_id, product_id from online_sale
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(online_sale_id) > 1
order by user_id asc, product_id desc