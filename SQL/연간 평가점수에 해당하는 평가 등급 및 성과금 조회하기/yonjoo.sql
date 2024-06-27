-- 코드를 작성해주세요

SELECT distinct(e.EMP_NO),  e.EMP_NAME, CASE 
        WHEN AVG(g.SCORE) >= 96 THEN 'S'
        WHEN AVG(g.SCORE) >= 90 THEN 'A'
        WHEN AVG(g.SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS 'GRADE',
    CASE 
        WHEN AVG(g.SCORE) >= 96 THEN e.sal * 0.2
        WHEN AVG(g.SCORE) >= 90 THEN e.sal * 0.15
        WHEN AVG(g.SCORE) >= 80 THEN e.sal * 0.1
        ELSE e.sal * 0
    END AS 'BONUS'
FROM HR_DEPARTMENT d, HR_EMPLOYEES e, HR_GRADE g
WHERE d.DEPT_ID = e.DEPT_ID and e.EMP_NO = g.EMP_NO
GROUP BY e.EMP_NO, e.EMP_NAME, e.SAL
ORDER BY e.EMP_NO;