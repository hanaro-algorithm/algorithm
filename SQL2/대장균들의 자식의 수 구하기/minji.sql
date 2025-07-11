SELECT ID, IFNULL(CHILD_COUNT, 0) AS CHILD_COUNT
FROM ECOLI_DATA E1
LEFT OUTER JOIN (
    SELECT PARENT_ID, COUNT(*) AS CHILD_COUNT
    FROM ECOLI_DATA
    GROUP BY PARENT_ID) E2
ON E1.ID = E2.PARENT_ID
ORDER BY 1;