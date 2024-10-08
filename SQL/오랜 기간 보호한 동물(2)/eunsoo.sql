WITH DIFF AS (
    SELECT AI.ANIMAL_ID AS ID, DATEDIFF(AO.DATETIME,AI.DATETIME) AS DD
    FROM ANIMAL_INS AS AI
    JOIN ANIMAL_OUTS AS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID
)
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS AS AI
JOIN DIFF ON AI.ANIMAL_ID = DIFF.ID
ORDER BY DIFF.DD DESC LIMIT 2