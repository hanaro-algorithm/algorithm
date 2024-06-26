-- 코드를 입력하세요 자동차 정보, 렌탈 기록, 할인률
SELECT DISTINCT CAR.CAR_ID, CAR.CAR_TYPE,
    CASE
        WHEN D.DURATION_TYPE='30일 이상'
        THEN (CAR.DAILY_FEE-REPLACE(D.DISCOUNT_RATE,'%','')*0.01*CAR.DAILY_FEE)*30
        ELSE CAR.DAILY_FEE*30
    END AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS CAR
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS RENTAL
        ON CAR.CAR_ID = RENTAL.CAR_ID
    JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D
        ON CAR.CAR_TYPE = D.CAR_TYPE
WHERE CAR.CAR_ID NOT IN (SELECT CAR_ID
                         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                         WHERE END_DATE > '2022-11-01' AND START_DATE < '2022-12-01')
AND CAR.CAR_TYPE IN('SUV', '세단')
AND D.DURATION_TYPE = '30일 이상'
GROUP BY FEE
HAVING FEE BETWEEN 500000 AND 2000000
ORDER BY FEE DESC, CAR.CAR_TYPE, CAR.CAR_ID DESC