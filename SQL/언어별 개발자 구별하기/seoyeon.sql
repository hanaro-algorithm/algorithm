WITH J AS (
    SELECT 
        ID,
        EMAIL,
        CASE -- 조건에 맞게 SCORE를 기록
            WHEN COUNT(CASE WHEN CATEGORY = 'Front End' THEN 1 END) > 0 AND 
                COUNT(CASE WHEN NAME = 'Python' THEN 1 END) > 0 
                THEN 3
            WHEN COUNT(CASE WHEN NAME = 'C#' THEN 1 END) > 0 THEN 2
            WHEN COUNT(CASE WHEN CATEGORY = 'Front End' THEN 1 END) > 0 THEN 1
        END AS SCORE
    FROM
        DEVELOPERS AS D
    JOIN -- 비트 논리 연산을 조건으로 JOIN
        SKILLCODES AS S ON D.SKILL_CODE & S.CODE
    GROUP BY 
        ID,EMAIL
    HAVING 
        SCORE > 0
)
SELECT 
    CASE 
        WHEN SCORE = 3 THEN 'A'
        WHEN SCORE = 2 THEN 'B'
        WHEN SCORE = 1 THEN 'C'
    END AS GRADE,
    ID,
    EMAIL
FROM 
    J
ORDER BY 
    1,2