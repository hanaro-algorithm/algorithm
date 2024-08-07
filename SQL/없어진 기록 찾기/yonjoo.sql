-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_OUTS o
left join ANIMAL_INS i on o.animal_id = i.animal_id
where i.animal_id is null

# SELECT  AO.ANIMAL_ID
#         ,AO.NAME
#   FROM  ANIMAL_OUTS AS AO
#   LEFT
#   JOIN  ANIMAL_INS AS AI
#     ON  AO.ANIMAL_ID = AI.ANIMAL_ID
#  WHERE  AI.ANIMAL_ID IS NULL 
#  ORDER
#     BY  ANIMAL_ID
# ;