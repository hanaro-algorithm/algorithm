-- 코드를 작성해주세요
SELECT d.DEPT_ID, d.DEPT_NAME_EN, ROUND(avg(e.SAL), 0) AS AVG_SAL
FROM HR_DEPARTMENT d, HR_EMPLOYEES e
WHERE d.DEPT_ID = E.DEPT_ID
GROUP BY d.DEPT_ID
ORDER BY AVG_SAL desc; # 'AVG_SAL' -> AVG_SAL 로 바꿨더니 통과

# SELECT
#     d.DEPT_ID,
#     d.DEPT_NAME_EN,
#     ROUND(AVG(e.SAL), 0) AS AVG_SAL
# FROM HR_EMPLOYEES e
# JOIN HR_DEPARTMENT d
#     ON e.DEPT_ID = d.DEPT_ID
# GROUP BY d.DEPT_ID
# ORDER BY AVG_SAL DESC