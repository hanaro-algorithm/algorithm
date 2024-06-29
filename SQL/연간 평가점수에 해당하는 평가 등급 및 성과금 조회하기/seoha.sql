select GRADE.emp_no, GRADE.EMP_NAME, GRADE.GRADE,
    CASE
            WHEN GRADE.GRADE = 'S' THEN hr_employees.sal*0.2
            WHEN GRADE.GRADE = 'A' THEN hr_employees.sal*0.15
            WHEN GRADE.GRADE = 'B' THEN hr_employees.sal*0.1
            ELSE 0
        END AS BONUS
from hr_employees
    join (
    select HE.EMP_NO, HE.EMP_NAME,
        CASE
            WHEN AVG(HG.SCORE) >=96 THEN 'S'
            WHEN AVG(HG.SCORE) >=90 THEN 'A'
            WHEN AVG(HG.SCORE) >=80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    from hr_employees HE
    join hr_grade HG
        on HE.EMP_NO = HG.EMP_NO
    group by HE.EMP_NO
) AS GRADE
ON hr_employees.EMP_NO = GRADE.EMP_NO
order by GRADE.EMP_NO

-- 서브쿼리 안썼을 때
--select HE.EMP_NO, HE.EMP_NAME,
--        CASE
--            WHEN AVG(HG.SCORE) >=96 THEN 'S'
--            WHEN AVG(HG.SCORE) >=90 THEN 'A'
--            WHEN AVG(HG.SCORE) >=80 THEN 'B'
--            ELSE 'C'
--        END AS GRADE,
--        CASE
--            WHEN AVG(HG.SCORE) >=96 THEN HE.SAL*0.2
--            WHEN AVG(HG.SCORE) >=90 THEN HE.SAL*0.15
--            WHEN AVG(HG.SCORE) >=80 THEN HE.SAL*0.1
--            ELSE 0
--        END AS BONUS
--    from hr_employees HE
--    join hr_grade HG
--        on HE.EMP_NO = HG.EMP_NO
--    group by HE.EMP_NO
--    order by HE.EMP_NO