WITH BEST AS (
    SELECT CATEGORY, MAX(PRICE) PRICE
    FROM FOOD_PRODUCT
    WHERE CATEGORY IN ("과자", "국", "김치", "식용유")
    GROUP BY CATEGORY
)

SELECT CATEGORY, PRICE MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE (CATEGORY, PRICE) IN (SELECT * FROM BEST)
GROUP BY CATEGORY
ORDER BY PRICE DESC