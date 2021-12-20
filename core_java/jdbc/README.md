# Introduction
The application interacts with postgresql database hosted locally using docker containers and performed CRUD operations. The app allows users to connect to a database with the java application and RDBMS and run SQL queries. It is implemented following the Data Access Object design pattern. 

## Technologies Used
 - Java
 - JDBC
 - PostgresSQL
 - Maven
 - Docker


# Implementation
## ER Diagram
![](er.png)



## Design Patterns
There are two patterns that can be implemented to access databse from java application using JDBC. The data access object (DAO) or repository pattern. For this instance we used the data access object Model.

### Data Access Object Model (DAO)

The DAO provides CRUD capabilities by executing transaction on the database. The DAO creates Data Transfer Object(DTO) which allows for transfering data between process. 
This design pattern allows the application to be isolated from the database and all of its functionality of performing CRUD operations. The DAO uses DTO to store in its query code into objects and encapsulates its parameters. In our case, a DTO named 'Customer' class was created to form a relationship between the database and the 'JDBCExecutor' class was used to rexecute the queries. 


### Respository Design Pattern 

The repository design pattern is similar to the DAO, however since the repository is more abstracted from the storage it is more closer to the business logic of the app. It allows the business logic to access the data without knowing about the underlying data access architecture. 

# Test

The application had been tested manually against the database. The database queries were checked based on counts and running simple queries to check for correct results. 



