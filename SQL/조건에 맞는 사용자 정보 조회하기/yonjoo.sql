-- 코드를 입력하세요
SELECT u.user_id, u.nickname, concat(u.city," ", u.street_address1, " ", u.street_address2) as '전체주소', concat(SUBSTRING(u.TLNO, 1, 3), "-", SUBSTRING(u.TLNO,4, 4), "-", SUBSTRING(u.TLNO, 8, 4)) as '전화번호'
FROM USED_GOODS_BOARD b
inner join USED_GOODS_USER u
on b.WRITER_ID = u.USER_ID
group by u.user_id
having count(*) >= 3
order by u.user_id desc;