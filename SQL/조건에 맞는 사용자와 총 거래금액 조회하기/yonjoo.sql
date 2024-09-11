-- 코드를 입력하세요
-- group by, inner join, order by
-- WHERE 로 먼저 1차 status 필터링 후 GROUP BY
SELECT u.USER_ID, u.NICKNAME, sum(b.price) as 'TOTAL_SALES'
FROM USED_GOODS_BOARD b
INNER JOIN USED_GOODS_USER u
ON b.WRITER_ID = u.USER_ID
WHERE b.STATUS = 'DONE'
GROUP BY b.WRITER_ID
HAVING sum(b.PRICE) >= 700000
ORDER BY sum(b.price);