/*
Perform the following operations from the JDBC project.
a. Insert 5 records.
b. Modify Email_Id column to varchar(30) NOT NULL.
c. Insert 2 records and check.
d. Update the name of employee Id 3 to Karthik and phone number to 1234567890.
e. Delete employee records 3 and 4.
f. Remove all records from the table employee.	
*/

create database Graded_Assignment_JDBC;
use Graded_Assignment_JDBC;

create table employee (
Id INT primary key,
Name varchar(50) NOT NULL,
Email_Id varchar(50)
NOT NULL,
Phone_Number varchar(10)
);

insert into employee
values
(1,"Raja","raja@gmail.com","9658456859"),
(2,"Harsha","harsha@gmail.com","9658745215"),
(3,"Mathew","mathew@gmail.com","9658854859"),
(4,"Vinay","vinay@gmail.com","9658454512"),
(5,"David","David@gmail.com","8541253654")
;

select * from employee;