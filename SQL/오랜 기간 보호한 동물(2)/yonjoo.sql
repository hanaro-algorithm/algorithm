-- 코드를 입력하세요
SELECT o.ANIMALID, o.NAME
FROM ANIMALOUTS o
LEFT JOIN ANIMALINS i
ON o.ANIMALID = i.ANIMAL_ID
ORDER BY DATEDIFF(o.DATETIME,i.DATETIME) DESC
LIMIT 2