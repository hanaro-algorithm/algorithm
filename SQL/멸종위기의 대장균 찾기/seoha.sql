WITH RECURSIVE CTE
AS
(
    SELECT ID, PARENT_ID, 1 AS DEPTH
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    UNION ALL
    SELECT CHILD.ID, CHILD.PARENT_ID, CTE.DEPTH + 1
    FROM ECOLI_DATA CHILD
    INNER JOIN CTE
        ON CHILD.PARENT_ID = CTE.ID
)

SELECT COUNT(*) AS 'COUNT'
    , DEPTH AS GENERATION
FROM CTE
WHERE ID NOT IN (SELECT PARENT_ID FROM ECOLI_DATA WHERE PARENT_ID IS NOT NULL)
GROUP BY GENERATION
ORDER BY GENERATION