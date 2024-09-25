SELECT a.animal_id, a.animal_type, a.name
from animal_ins a join animal_outs b
on a.animal_id = b.animal_id
where a.sex_upon_intake != b.sex_upon_outcome
order by a.animal_id