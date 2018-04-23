-- @file: create_db_and_table.sql
-- @author: Thierry JEAN-LOUIS
-- @date: 07.12.2018
-- @desc: Create database and tables

create database eyeemtracker; 
GO
use eyeemtracker 
GO
create table followers (ID int NOT NULL PRIMARY KEY IDENTITY, NAME VARCHAR(45) NOT NULL PRIMARY KEY, LINK VARCHAR(135) NOT NULL, FOLLOWED BIT DEFAULT 0);
GO
insert into followers values ('scanaki', 'https://www.eyeem.com/u/scanaki', 0);
GO
