# Graduate Program Notes on Database (Web):

- The word **Persist** is the a word used to describe **Saving** data into a database.
- Video explaining ORM and Hibernate [here](https://www.youtube.com/watch?v=PMR0ld5h938).
- When generating ID's and unique fields, the company practice is to use sequence table.
- **Scripts** and **SQL querries**  are written in *snake_case*.
- For `@JoinColumns` annotation: it will always focuse on the foriegn key as reference for creating column names.
- **table_names** and **column_names** are set to singular by company practice.
- For every entity, the name of the ***sequence_process*** must be unique.
- Might want to consider using ***Views*** in the future for making templates on retrieving data from the database.
- *Cascade* means more like: include.
- `@Entity` -create table.
- ***By company practice:*** creating the interface for PagingAndSorting must be on package level.
- `@Transactional` annotation makes use of the #BEGIN and #ROLLBACK method in database level operation. It performs a *rollback* when there is an exception thrown inside the function. This is done in order to protect the data where there is an exception that occured when performing the action inside the function. The `@Transacitonal` just ends when the `.saved()` method is envoked by the repository object. That is why when you are making too many trips to the database, use `@Transactional`.
- ***By company practice:*** It is usually and most of the time avoided to perform to much trips to the database.
- 

## Terminal/CLI commands:
- Start the database (postgreSQL):
```PostgreSQL
service postgresql <start>
```
- Open a database:
```PostgreSQL
sudo -u postgres psql
//or
sudo -u postgres psql <database_name>
```

- Selecting the next value from an order_sequence:
```PostgreSQL
SELECT nextval('sequence_name');
```
- Inserting new row in the database table (manualy):
```PostgreSQL
INSERT INTO product (nextval('product_sequence'), 'test', 'productDescription', 100, 9.0)
```
&emsp;or you can insert 2 rows of into the table at the same time (*note: you can use comma to separate 2 querries to insert into the database as shown above*)
```PostgreSQL
INSERT INTO product (nextval('product_sequence'), 'test', 'productDescription', 100, 9.0),
(nextval('product_sequence'), 'test', 'Product', 100, 9.0);
```
- Using #LIKE in querry(*take note of the '%', and '%like_word%*):
```PostgreSQL
SELECT * FROM products WHERE  DESCRIPTION LIKE '%<word-to-filter>%;
```
- Querry for selecting date with specified range:
```PostgreSQL
SELECT * FROM orders WHERE date_ordered BETWEEN '2022-08-18' AND '2022-08-20';

```

## Custom Querry code using Spring Data JPA:
- Sample Querry code for getting a list of the id from the database where the product.name has a LIKE content and the product.id is notEqual (<>) to the passed id:
```Java
@Query("SELECT product.id FROM Product product WHERE UPPER(product.name) LIKE UPPER(:productName) AND product.id <> :productId")
    List<Long> listOfId (@Param("productName") String productName,
                         @Param("productId") Long id);
```
&emsp;***Explanation:***
```Java
@Query("SELECT <db_alias>.id FROM <database_name> <db_alias> WHERE UPPER(<db_alias>.<target_column>) LIKE UPPER(:<variable>) AND <db_alias>.id <> :<variable>")
    List<Long> listOfId (@Param("<variable_name>") String productName,
                         @Param("productId") Long id);
```
>*Note: a quick hack for making custom querries like the one above is creating a function first like the one below and then running the application and viewing the hibernate generated querry on the runtime stack and then translating it to a querry. The use of methods such as the one below are not practiced by the company probably due to the complexity these methods might become or be constructed.*

- Example of a custom querry function on the `ProductRepository.java`. This returns a boolean value when the passed name exists on the target database (`Product`).
```Java
boolean existsProductByName(String productName);
```