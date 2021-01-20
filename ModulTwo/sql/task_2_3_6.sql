use ups;

select expenses.id, expenses.paydate, expenses.value, receivers.name 
from expenses, receivers 
where receiver=receivers.id and expenses.value>10;

delete from expenses where value<30;


select sum(value) as Потрачено, name 
from expenses, receivers rs 
where receiver=rs.id group by receiver;


select paydate, sum(value) 
from expenses 
where paydate=(select paydate from expenses where value=(select max(value) from expenses));


select paydate, max(value) 
from expenses 
where paydate=(select paydate from expenses where value=(select max(value) from expenses));

