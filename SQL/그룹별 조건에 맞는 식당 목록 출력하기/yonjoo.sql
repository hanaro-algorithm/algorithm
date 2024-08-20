-- 코드를 입력하세요
# SELECT MEMBER_NAME , REVIEW_TEXT, DATE_FORMAT(review_date, '%Y-%m-%d') as 'REVIEW_DATE'
# FROM MEMBER_PROFILE p
# join REST_REVIEW r
# on p.member_id = r.member_id
# WHERE r.member_id = (
#     select member_id 
#     FROM rest_review 
#     order by count(*)
# )
# order by r.review_date asc, r.review_text asc;

-- 코드를 입력하세요
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE M
JOIN REST_REVIEW R ON M.MEMBER_ID = R.MEMBER_ID
WHERE R.MEMBER_ID = (
    SELECT MEMBER_ID 
    FROM REST_REVIEW R 
    GROUP BY MEMBER_ID
    ORDER BY COUNT(*) DESC
    LIMIT 1)

ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;