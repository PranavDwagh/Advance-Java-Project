/* Day 1=> PROCEDURE */


drop procedure if EXISTS pro1;

delimiter $ 
create procedure pro1()
BEGIN
	
	select "Hello World " as "Message Window";

end $
delimiter ;



drop procedure if exists pro2;
delimiter $
create procedure pro2(in x int, in y int, in z int)
BEGIN
	declare w int;
	set w := x + y +z;
	select w;
end $
delimiter ;


drop procedure if exists pro3;
delimiter $
create procedure pro3(in p1 int, in p2 int)
BEGIN

	
	insert into pl values (p1, p2);
	select concat("The ",p1 ,p2 ," inserted into table") as "Message Window";
	
end $
delimiter ;



drop procedure if exists pro4;
delimiter $
create procedure pro4()
BEGIN
	declare x int;
	
	set x :=1000;
	
	if x<100 THEN
		select "GOOD";
	ELSE
		select "BAD";
	end if;
end $
delimiter ;



drop procedure if exists pro5;
delimiter $
create procedure pro5(in p1 int, in p2 varchar(12), in p3 varchar(10), in p4 varchar(20))
begin
	if p3 = 'pune' THEN
		insert into dept values(p1,p2,p3,p4);
		select "Data inserted Sucessfully" as "Message Window";
	ELSE
		select "Invalid City" as "Message Window";
		end if;
end $
delimiter ;


drop procedure if EXISTS pro6;
delimiter $
create procedure pro6(in P1 int)
BEGIN
	if (P1<=40) then
		select * from emp where deptno = P1;
	ELSE
		select "Enter Dept in 10 to 40" as "Message Window";
		end IF;
	
	end $
	delimiter ;


drop procedure if EXISTS pro7;
delimiter $
create procedure pro7(in p1 int, in p2 int, out p3 int)
BEGIN
		declare x int;
		
		set x := p1+p2;
		
		set p3 := x;
		
	end $
delimiter ;


drop procedure if exists pro8;
delimiter $
create procedure pro8(in P1 int, in P2 int, out P3 int, out p4 int)
begin
	set p3 := p1 + p2;
	set p4 := p1 - p2;
	
end $
delimiter ;



drop procedure if exists pro9;
delimiter $

create procedure pro9()
begin 
	declare x int;
	set x:= (select extract(day from now()));
	
	if x=10 then 
	 create table e11 as select * from emp where false;
	 ELSE
	 select "Not Today" as "Change Date to 10";
	 end if ;
end $
delimiter ;


drop procedure if exists pro10;
delimiter $
create procedure pro10()
begin

	prepare a from "select * from emp";
	execute a;
	
end $
delimiter ;


drop procedure if exists pro11;
delimiter $
create procedure pro11()
begin
	set @x := "select * from emp";
	
	prepare a from @x;
	
	execute a;
	
end $
delimiter ;
/*

drop procedure if exists pro12;
delimiter $
create procedure pro12(col varchar(200), tblname varchar(200))
BEGIN	
	set @x1 := "select col from tblname" ;
	
	/* above statement will become  ==> mysql> select col from tblname; which is invalid
	
	below statement will fetch correct output */
	
	/*
	set @x2 :=  concat ("select ",col, " from ",tblname);
	select @x2;
	prepare stmt from @x2;
	execute stmt;
	*/	
end $
delimiter ;

	

drop procedure if exists pro12;
delimiter $
create procedure pro12(col varchar(20), tblname varchar(20))
begin
	SET @x1 := "select col from tblname";
	SET @x2 := concat ("select ", col, " from ", tblname);
	
	prepare a from @x2;
	execute a;
	select @x1;
	select repeat('*', 30);
	select @x2;
	
end $
delimiter ;


drop function if exists f2;
delimiter $
create function f2(x int , y int) returns int
deterministic
BEGIN
	return ifnull(x, 0)+ ifnull(y, 0);
end $
delimiter ;




drop procedure if exists pro13;
delimiter $
create procedure pro13(in _empno int)
begin
	declare x bool;
	select true into x from emp where empno= _Empno;
	
	if x then 
		select f2(sal, comm) from emp where empno= _empno;
		ELSE
			select "Employee not Found!";
			
		end if;
		
end $
delimiter ;

drop function if existse f3;
delimiter $
create function f3() returns int
deterministic
begin 
	declare x int;
	
	set x := (select max(deptno) + 1 from dept);
	
	return x;
end $
delimiter ;


drop procedure if exists pro14;
delimiter //
create procedure pro14()
begin
	
	declare exit handler for 1062  select "Duplicate Entry in Dept Column";
	DECLARE exit handler for 1146 select "table not found";
	insert into dept0 values(-1,1,1,1);
	
end //
delimiter ;


drop procedure if exists pro17;
delimiter //
create procedure pro17()
begin
	declare x int default 0;
	z:loop 
		set x := x + 1;
		if x>10 then 
			leave z;
		ELSE
			select x;
	end loop z;
END //
delimiter ;
	
	

drop procedure if exists pro16;
delimiter //
create procedure pro16()
begin
	declare a int;
	declare b,c,d varchar(20);
	declare cur1 CURSOR for select * from dept;
	declare exit handler for 1329 select "EOF";
	open cur1;
	z:loop 
		fetch cur1 into a,b,c,d;
		select a, b, c, d;
	end loop z;
end //
delimiter ;


drop procedure if exists pro18;
delimiter //
create procedure pro18(custID int)
b1 : BEGIN
	declare x tinyint;
	select true into x from customers where cnum=custID;
	declare exit handler for 1329 select "EOF";
	
	if x then 
	b2:begin
	declare a,b,c float(7,2);
	declare c1 CURSOR for select onum, amt, cnum from orders where cnum=custID;
	
	open c1;
		LOOP
			fetch c1 into a,b,c;
			select a,b,c ;
		end loop;
		close c1;
	END b2;

		ELSE
		select "Customer Not Found";
	END IF;
	
	END b1 //
	
	delimiter ;
		

drop procedure if EXISTS pro19;
delimiter //
create procedure pro19()
b1:begin 

	declare x int default 1001;
	#select true into x from customers where cnum=id;
	b2:BEGIN
	
	declare y int default 2002;
	select x;	
	end b2;
		select y;                # outer begin variable are accesible in inside begin
	end b1 //						# but inside begin variable are  not accessible outside like functions
	delimiter ;
	

drop procedure if exists pro20 ;
delimiter //
create procedure pro20(eno int, jb varchar(20))
b1:BEGIN
    declare x bool;
	select true into x from emp where empno=eno;
	#set x :=1;
	if x then 
		b2:BEGIN
		declare a , b , c , d VARCHAR(20);
		declare cur1 CURSOR for select empno, ename, job, sal from emp where job=jb;
		declare exit handler for 1329 select "EOF";
		open cur1;
		l:LOOP
		fetch cur1 into a, b, c, d;
		select a ,b,c,d;
		end loop l;
		close cur1;
		end b2 ;
	else 
		select "Enter department number not exists in dept table" ;
	end if;	
end b1 //
	
delimiter ;
	
			

drop procedure if exists expro ;
delimiter //
create procedure expro()
BEGIN
	#declare @x VARCHAR(50);
	
	set @x := "Hello" ;
	
	select @x ;

end //

delimiter ;

/*
drop TRIGGER IF EXISTS tr1;
delimiter //
create trigger tr1 before insert on dept for each ROW
BEGIN
	insert into D values (new.deptno, new.dname, new.loc, new.pwd, current_date(), current_time(), user());
	end //
	
	delimiter ;
	
	
	
drop trigger if exists tr2;
delimiter //
create trigger tr2 before delete on dept for each ROW
BEGIN
	INSERT INTO D values (old.deptno, old.dname, old.loc, old.pwd, current_date, current_time, USER() );
	end //
delimiter ;
	
	


drop trigger if exists tr4;
delimiter //
create trigger tr4 after insert on temp for each row
begin 
	INSERT INTO  a1 values(new.c1);
end//
delimiter ;


drop trigger if exists tr5;
delimiter //
create trigger tr5 after insert on temp for each ROW
BEGIN
	insert into a1 values(1000);
	if dayname(now()) = '1sunday' THEN
		signal sqlstate '42000' set message_text='Today is Sunday';
		end if;
end //
	
delimiter ;
	
	


drop trigger if exists tr5;
delimiter //
create trigger tr5 AFTER INSERT on temp for each ROW
BEGIN	
	declare x int default 0;
	insert into a2 values(new.c1);
	select count(*) into x from temp;
	
	insert into cnt values(x);
	
	if x >=	5 THEN
		signal sqlstate '42000' set message_text= '>5';
		
	end if ;
end //
delimiter ;
*/