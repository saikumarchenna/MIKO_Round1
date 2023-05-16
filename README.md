# MIKO_Round1


Q1: Create a simple file based one table database. It should be a simple text file which holds one table.
The metadata about the table, the names of the columns and the types of the columns should be in a
different table file.
Support integers and character data types for now.
Whenever the user creates a table, the syntax will be of the form CREATE TABLE ( col1 INTEGER, col2
STRING,....). It can have any number of columns. This query will be parsed and info stored in the
metadata file.
Whenever the user issues an insert command the insert will happen in the table file. The insert will be of
the form INSERT into VALUES (col1, col2,..) VALUES(,)...
Write java code which will parse the SQL statements and either create files or insert into
files.




Q2: Create a simple assembly Language which will have 3 operations,
Get a constant into a register of the form
MV REG1,#2000
MV REG2,#4000
Add two registers together. Save results in the first register
ADD REG1, REG2
Add register and constant together. Save results in the first register.
ADD REG1,600
Show the results of a register
SHOW REG
The simple java program should be able to accept a program containing one or more
MV statements and an ADD statement and print the results of a SHOW REG at the end.
Write java code which will parse the SQL statements and either create files or insert into
files.
