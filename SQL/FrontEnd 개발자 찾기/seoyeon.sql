SELECT DISTINCT d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
FROM DEVELOPERS d JOIN SKILLCODES s
WHERE s.CODE = d.SKILL_CODE&s.CODE AND s.CATEGORY LIKE 'Front End'
ORDER BY d.ID;