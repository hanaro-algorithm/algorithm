-- 코드를 작성해주세요
# SELECT 
# FROM ECOLI_DATA ...까지밖에 모르겠다

# select a.id
# from ECOLIDATA a
# join ECOLIDATA b on a.PARENTID = b.id
# join ECOLIDATA c on b.PARENTID = c.id and c.parentid is null
# where a.PARENT_ID is not null
# order by id;