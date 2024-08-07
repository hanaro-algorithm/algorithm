-- 코드를 입력하세요
SELECT b.category as 'CATEGORY', sum(s.sales) as 'TOTAL_SALES'
FROM BOOK b
INNER JOIN BOOK_SALES s
ON b.BOOK_ID = s.BOOK_ID
WHERE s.SALES_DATE like '2022-01%'
GROUP BY b.CATEGORY
ORDER BY b.CATEGORY;
