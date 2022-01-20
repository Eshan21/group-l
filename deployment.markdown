---
layout: default
title: Deployment Guide
permalink: /deployment-guide
---

# Deployment Guide

---

## References
- [Hardware](#hardware)
    - [Consider to use](#consider-to-use)
    - [AWS](#aws)
- [Deploy the website](#deploy-the-website)
    - [Build or Run From Source](#build-or-run-from-source)
    - [Build/Run](#buildrun)
    - [Ideas for deployment managements](#ideas-for-deployment-managements)
## Hardware
### Consider to use
1. AWS
2. Heroku
3. VPS
4. PI (localhost)

### AWS
* AWS is our first choice, so we will use this.

#### Deployment steps

##### Step 1. Prepare account
* still working on this
##### Step 2. Launch the stack
* still working on this
##### Step 3. Add services or applications
* still working on this

#### Deployment guide for AWS Lambda
> You can use versions and aliases provided by AWS Lambda

You can create different versions of the same lambda function and give them an alias. Like when you push your lambda code - create a version (say it's 5) - create an alias this (say TEST).
When you're sure that its ready for production, create a version(or choose an existing version and name that (say PROD).

> Now whenever your lambda function executes, it gives `lambda ARN`
> which contains alias, by that you can know which alias(in context.invokedFunctionArn) is
> executed i.e. that can be used as the environment variable. While
> invoking the function, you can mention which function to execute from
> your invocation code.

```js
let thisARN = context.invokedFunctionArn;

// Get the last string in ARN - It's either function name or the alias name
let thisAlias = thisARN.split(":").pop();
```

Now whenever you deploy a new code, just point the alias to that version.
You can use AWS console or CLI for that.

Take a look at this [lambda versioning and aliases][1]

For directly deploying to your alias(PROD), you can do this -
   
```
aws lambda update-alias \
--region region \
--function-name helloworld \
--function-version 2 \
--name PROD
```

  [1]: https://docs.aws.amazon.com/lambda/latest/dg/versioning-aliases.html

## Deploy the website
[release]: https://github.com/iskapoor/group-l/releases

### Build or Run From Source

#### Install Dependencies
- [JDK 11](https://adoptium.net/releases.html?variant=openjdk11)
- [Maven 3.8.3](https://maven.apache.org/download.cgi)
- [MySQL 8.0.27](https://dev.mysql.com/doc/mysql-getting-started/en/)

Download the source code as a [zip][source] or with git:

[source]: https://github.com/iskapoor/group-l/archive/refs/heads/main.zip

```
git clone https://github.com/iskapoor/group-l.git
```

#### Setup MySQL Database

##### Disable MySQL
---
MySQL Server is needed to store user information and blogs, however you can run without it.
To run without mysql, add to `application.properties`:

```
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,\
    org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
    org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration,\
    org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration

disablemysql=true
```

Or use the run command:

```
./run -nsql
```

#### Install and Connect to MySQL Server
---

Linux 
- Run secure installation
```
mysql_secure_installation
```

- Run MySQL Server
    - Open a new terminal/console window and run:
```
mysqld
```

- Connect to MySQL Server
```
mysql -u root -p
```

---

Windows
- Install from [Windows Installer](https://dev.mysql.com/doc/refman/8.0/en/mysql-installer.html)
- Run MySQL shell
```
mysqlsh
```

- Switch to SQL mode
```
\sql
```

- Connect to MySQL Server
```
\connect root@localhost:3306;
```

---

#### Setup Database
- Setup database and permissions
```mysql
mysql> create database springdb; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'changethispassword'; -- Creates the user
mysql> grant select, insert, delete, update on springdb.* to 'springuser'@'%'; -- Gives specific privileges to the user on the database
mysql> flush privileges; -- Apply privileges
```

- Add to `src/main/resources/application.properties`
```
spring.jpa.defer-datasource-initialization=true
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/springdb
spring.datasource.username=springuser
spring.datasource.password=changethispassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### Build/Run
Then build the JAR file with the build scripts:
- Run `./build` or `./build.cmd`

Or run in place:
- Run `./run` or `./run.cmd`

### Ideas for deployment managements
* Make 2 branches in the GitHub page
  * Main branch is for the daily/latest updates
  * Stable branch is for deployment
* We will merge the Main to stable once we feel like there's no more major errors that can be found.
  * We will try to merge once a week.
* When Deployment manager is not here
  * We will try to automatic all the update processes. 


