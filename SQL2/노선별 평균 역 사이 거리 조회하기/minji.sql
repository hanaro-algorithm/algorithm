/*
ROUND(숫자, 반올림할 자릿수): 반올림할 자릿수+1 자릿수에서 반올림 => 반올림
TRUNCATE(숫자, 버릴 자릿수): 숫자를 버릴 자릿수 아래로 버림 => 버림
*/
SELECT TRUNCATE(PRICE/10000, 0)*10000 AS PRICE_GROUP, COUNT(*) AS PRODUCTS
FROM PRODUCT
GROUP BY PRICE_GROUP
ORDER BY 1;