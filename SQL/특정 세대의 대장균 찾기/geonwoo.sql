SELECT A.ID FROM ECOLI_DATA A
JOIN ECOLI_DATA B
ON A.PARENT_ID = B.ID
JOIN ECOLI_DATA C
ON B.PARENT_ID = C.ID AND C.PARENT_ID IS NULL
WHERE A.PARENT_ID IS NOT NULL
ORDER BY ID;