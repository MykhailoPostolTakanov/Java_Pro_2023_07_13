select avg(h.height) from hero h

select h."name" from hero h where h.height = (select max(h2.height) from hero h2) 

select h."name" from hero h where h.weight  = (select max(h2.weight) from hero h2)  

select h.gender, count(h.gender) from hero h group by h.gender 

select h.alignment, count(h.alignment) from hero h group by h.alignment  

select h.publisher from hero h group by h.publisher order by count(h.publisher) desc limit 5

select h.haircolor from hero h group by h.haircolor order by count(h.haircolor) desc limit 3

select h.eyecolor from hero h group by h.eyecolor order by count(h.eyecolor) desc limit 1