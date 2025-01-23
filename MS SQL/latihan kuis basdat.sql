use car

select * from car
select * from Specification
select * from Loc

select * from car where not year = 2017
select * from car where name like '%a'
select name, year from car where year between 2005 and 2006

--Inner join
select car.Name, car.ID, Specification.Engine_id, Specification.Engine from Car
inner join Specification on car.ID = Specification.Engine_id

