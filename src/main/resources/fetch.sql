SELECT * FROM homework

SELECT le.name, le.updatedat, h.name, h.description FROM lesson le join homework h on le.homework_id = h.id 

SELECT le.id, le.name, le.updatedat, h.name, h.description FROM lesson le join homework h on le.homework_id = h.id order by le.updatedat desc

select s.name, s.updatedat, l.name, l.updatedat, l.homework_id  from schedule_lesson sl join schedule s on sl.schedule_id = s.id join lesson l on sl.lesson_id = l.id 

select  s.name, COUNT(*) from schedule_lesson sl join schedule s on sl.schedule_id = s.id group by s.name, s.id  order by s.id