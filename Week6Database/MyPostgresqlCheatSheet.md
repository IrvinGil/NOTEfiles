# PostgreSQL Commands:
- Access the PostgreSQL server from psql with a specific user:
```PostgreSQL
psql -U [username];

//For example, the following command uses the postgres user to access the PostgreSQL database server:

psql -U postgres
```
- Connect to a specific database:
```PostgreSQL
\c database_name;

//For example, the following command connects to the dvdrental database:

\c dvdrental;
You are now connected to database "dvdrental" as user "postgres".
```
- To quit the psql:
```PostgreSQL
 \q
```
- List all databases in the PostgreSQL database server:
```PostgreSQL
 \l
```
- List all schemas:
```PostgreSQL
\dn
```
- List all stored procedures and functions:
```PostgreSQL
\df
```
- List all views:
```PostgreSQL
\dv
```
- List all tables in current database:
```PostgreSQL
\dt
```
- Or get more information on tables in the current database:
```PostgreSQL
\dt+
```
- Get detailed information on table:
```PostgreSQL
\d+ table_name
```
- Show a stored procedure or function code:
```PostgreSQL
\df + function_name
```
- List all users:
```PostgreSQL
\du
```
- Create new role:
```PostgreSQL
CREATE ROLE role_name;
```
- Create a new role with `username` and `password`:
```PostgreSQL
CREATE ROLE username NOINHERIT LOGIN PASSWORD password;
```
- Change role for the current session to the new_role:
```PostgreSQL
SET ROLE new_role;
```
- Allow `role1` to set its role as `role2`;
```PostgreSQL
GRANT role_2 TO role_1;
```

# Managing Databases:

- Creating new database:
```PostgreSQL
CREATE DATABASE [IF NOT EXISTS] db_name;
```
- Delete a database permanently:
```PostgreSQL
DROP DATABASE [IF EXISTS] db_name;
```
---
## Managing Tables:

- Create a new table or a temporary table:
```PostgreSQL
CREATE [TEMP] TABLE [IF NOT EXISTS] table_name(
   pk SERIAL PRIMARY KEY,
   c1 type(size) NOT NULL,
   c2 type(size) NULL,
   ...
);
```
- Add a new column to a table:
```PostgreSQL
ALTER TABLE table_name ADD COLUMN new_column_name TYPE;
```

- Drop a column in a table:
```PostgreSQL
ALTER TABLE table_name DROP COLUMN column_name;
```

- Rename a column:
```PostgreSQL
ALTER TABLE table_name RENAME column_name TO new_column_name;
```  

- Set or remove a default value for a column:
```PostgreSQL
ALTER TABLE table_name ALTER COLUMN [SET DEFAULT value | DROP DEFAULT]
```

- Add a primary key to a table:
```PostgreSQL
ALTER TABLE table_name ADD PRIMARY KEY (column,...);
```

- Remove the `primary key` from a table:
```PostgreSQL
ALTER TABLE table_name 
DROP CONSTRAINT primary_key_constraint_name;
```

- Rename a table:
```PostgreSQL
ALTER TABLE table_name RENAME TO new_table_name;
```

-Drop a table and its dependent objects:
```PostgreSQL
DROP TABLE [IF EXISTS] table_name CASCADE;
```
---

## Managing Views:

- Create a view:
```PostgreSQL
CREATE OR REPLACE view_name AS
query;
```

- Create a recursive view:
```PostgreSQL
CREATE RECURSIVE VIEW view_name(column_list) AS
SELECT column_list;
```

- Create a materialized view:
```PostgreSQL
CREATE MATERIALIZED VIEW view_name
AS
query
WITH [NO] DATA;
```

- Refresh a materialized view:
```PostgreSQL
REFRESH MATERIALIZED VIEW CONCURRENTLY view_name;
```

- Drop a view:
```PostgreSQL
DROP VIEW [ IF EXISTS ] view_name;
```

- Drop a materialized view:
```PostgreSQL
DROP MATERIALIZED VIEW view_name;
```

- Rename a view:
```PostgreSQL
ALTER VIEW view_name RENAME TO new_name;
```
---
## Managing Indexes:

- Query all data from a table:
```PostgreSQL
SELECT * FROM table_name;
```

- Query data from specified columns of all rows in a table:
```PostgreSQL
SELECT column_list
FROM table;
```

- Query data from a table with a filter:
```PostgreSQL
SELECT *
FROM table
WHERE condition;
```

- Assign an alias to a column in the result set:
```PostgreSQL
SELECT column_1 AS new_column_1, ...
FROM table;
```

- Query data using the LIKE operator:
```PostgreSQL
Query data using the LIKE operator:
```

- Query data using the BETWEEN operator:
```PostgreSQL
SELECT * FROM table_name
WHERE column BETWEEN low AND high;
```

- Query data using the IN operator:
```PostgreSQL
SELECT * FROM table_name
WHERE column IN (value1, value2,...);
```

- Constrain the returned rows with the LIMIT clause:
```PostgreSQL
SELECT * FROM table_name
LIMIT limit OFFSET offset
ORDER BY column_name;
```

- Query data from multiple using the inner join, left join, full outer join, cross join and natural join:
```PostgreSQL
SELECT * 
FROM table1
INNER JOIN table2 ON conditions
```
```PostgreSQL
SELECT * 
FROM table1
LEFT JOIN table2 ON conditions
```
```PostgreSQL
SELECT * 
FROM table1
FULL OUTER JOIN table2 ON conditions
```
```PostgreSQL
SELECT * 
FROM table1
CROSS JOIN table2;
```
```PostgreSQL
SELECT * 
FROM table1
NATURAL JOIN table2;
```

- Return the number of rows of a table.
```PostgreSQL
SELECT COUNT (*)
FROM table_name;
```

- Sort rows in ascending or descending order:
```PostgreSQL
SELECT select_list
FROM table
ORDER BY column ASC [DESC], column2 ASC [DESC],...;
```

- Group rows using GROUP BY clause.
```PostgreSQL
SELECT *
FROM table
GROUP BY column_1, column_2, ...;
```

- Filter groups using the HAVING clause.
```PostgreSQL
SELECT *
FROM table
GROUP BY column_1
HAVING condition;
```

## Set Operations:

- Combine the result set of two or more queries with UNION operator:
```PostgreSQL
SELECT * FROM table1
UNION
SELECT * FROM table2;
```

- Minus a result set using EXCEPT operator:
```PostgreSQL
SELECT * FROM table1
EXCEPT
SELECT * FROM table2;
```

- Get intersection of the result sets of two queries:
```PostgreSQL
SELECT * FROM table1
INTERSECT
SELECT * FROM table2;
```

## Modifying Data:

- Insert a new row into a table:
```PostgreSQL
INSERT INTO table(column1,column2,...)
VALUES(value_1,value_2,...);
```

- Insert multiple rows into a table:
```PostgreSQL
INSERT INTO table_name(column1,column2,...)
VALUES(value_1,value_2,...),
      (value_1,value_2,...),
      (value_1,value_2,...)...
```

- Update data for all rows:
```PostgreSQL
UPDATE table_name
SET column_1 = value_1,
    ...;
```

- Update data for a set of rows specified by a condition in the WHERE clause.
```PostgreSQL
UPDATE table
SET column_1 = value_1,
    ...
WHERE condition;
```

- Delete all rows of a table:
```PostgreSQL
DELETE FROM table_name;
```

- Delete specific rows based on a condition:
```PostgreSQL
Delete specific rows based on a condition:
```