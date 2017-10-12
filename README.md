# Practical-Company-Employee-data-API
The project's data is from MySQL Employee example (https://dev.mysql.com/doc/employee/en/).
>The Employees sample database was developed by Patrick Crews and Giuseppe Maxia and provides a combination of a large base of data (approximately 160MB) spread over six separate tables and consisting of 4 million records in total. The structure is compatible with a wide range of storage engine types. Through an included data file, support for partitioned tables is also provided.

### Install the database to MySQL
To install the database, I stronly recommend follow the official installation instruction (https://dev.mysql.com/doc/employee/en/employees-installation.html).

### Application Properties
Application properties various from people to people. To run this project and manipulate data in the database, you proberbaly need to make some changes based on your MySQL settings. You can modify settings in the directory similar to this:

`$ ./Practical-Company-Employee-data-api/src/main/resources/application.properties`

Then you can change these settings based on personal needs:

```
# Change the url based on your local setting
spring.datasource.url=jdbc:mysql://localhost:3306/employees
# Your user name which is being using in your MySQL
spring.datasource.username=root
# If you don't have password, then you can comment this line.
spring.datasource.password=ThePassword
```

### Run Spring boot application
Direct to the project directory and open Terminal.

`$ mvn clean install`

Then within same project directory
```
$ cd target/
$ ls
```

Find the file end with .jar

`$ java -jar theFileName.jar`

### View and check all the APIs
Open Chrom or Safari, go to http://localhost:8080//swagger-ui.html#/ and you will be able to see all the APIs.