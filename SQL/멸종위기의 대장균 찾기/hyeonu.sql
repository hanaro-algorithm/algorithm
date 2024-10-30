WITH RECURSIVE GenerationCTE AS (
    SELECT ID,PARENT_ID,1 AS Generation
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL

    UNION ALL

    SELECT e.ID,e.PARENT_ID, g.Generation + 1 AS Generation
    FROM ECOLI_DATA e
             JOIN GenerationCTE g ON e.PARENT_ID = g.ID
)
SELECT ID
FROM GenerationCTE
WHERE Generation = 3
ORDER BY ID;