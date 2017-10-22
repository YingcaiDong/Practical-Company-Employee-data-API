# Practical-Company-Employee-data-API
By Yingcai Dong

## Information
The project's data is from MySQL Employee example (https://dev.mysql.com/doc/employee/en/).
>The Employees sample database was developed by Patrick Crews and Giuseppe Maxia and provides a combination of a large base of data (approximately 160MB) spread over six separate tables and consisting of 4 million records in total. The structure is compatible with a wide range of storage engine types. Through an included data file, support for partitioned tables is also provided.

## Installation
### Install the database to MySQL
To install the database, I stronly recommend follow the official installation instruction (https://dev.mysql.com/doc/employee/en/employees-installation.html).

### Install Maven
Run the following command to install it:

`$ brew install maven`

## Usage
### Two options
I already generated a standalone jar file ready for you to run. However, the properties in this application is based on my database settings:
```
spring.datasource.url=jdbc:mysql://localhost:3306/employees
spring.datasource.username=root
#spring.datasource.password=ThePassword
```
If you are in this setting, then jump to **TL;DL**. Otherwise, please follow the **Applicaiton Properties** and the rest.
> Note that **TL;DL** is only for user who don't want to modify the code. However, if you want to add more APIs or more features based on this project, please follow the second option (start from **Application Properties**) to change/add features and packge your own jar file.

### TL;DL
Run the following command to start appliaction

`$ mvn spring-boot:run`

Open this link in Chrom or Safari http://localhost:8080//swagger-ui.html#/

### Run Spring Boot application
To simply run this projet, just follow this instruction.

Run the following command:

`$ mvn spring-boot:run`

### Run standalone application
To generate a standalone application and run everywhere, please follow this instruction.

Direct to the project directory and open Terminal.

`$ mvn clean install`

Then within same project directory
```
$ cd target/
$ ls
```
<img width="637" alt="screen shot 2017-10-12 at 3 11 44 pm" src="https://user-images.githubusercontent.com/22902303/31514599-20c1f4ee-af60-11e7-91e5-d46a91cefcc5.png">

Find the file end with .jar

`$ java -jar theFileName.jar`

## Configuration
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

## Information
### View and check all the APIs
Open Chrom or Safari, go to http://localhost:8080//swagger-ui.html#/ and you will be able to see all the APIs.
<img width="1164" alt="swagger" src="https://user-images.githubusercontent.com/22902303/31514047-645ef46a-af5e-11e7-9a40-ca1d98322488.png">

