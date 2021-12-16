# group-l
[scrum_board](https://github.com/iskapoor/group-l/projects/1), [contributors](https://github.com/iskapoor/group-l/graphs/contributors), [PBL Journal](), [Link to the website](http://ricelab.tk:8080)

|  Contributors | Github ID and Profile| Tasks  | Scrum Board | Commits |
| :------------ | :---------------     | :----- | :---------- | :------ |
| Akhil Guntur  | [algolg][alg-git]    | [Tasks][alg-tsk] | [Scrum Board][alg-scb] | [Commits][alg-cmt] |
| Ishan Kapoor  | [iskapoor][ish-git1] and [Eshan21][ish-git2] | [Tasks][ish-tsk] | [Scrum Board][ish-scb] | [Commits][ish-cmt1] and [Commits][ish-cmt2] |
| Jonathan Lin  | [jlaaa][jla-git]     | [Tasks][jla-tsk] | [Scrum Board][jla-scb] | [Commits][jla-cmt] |
| Michael Zhang | [TKperson][TKp-git]  | [Tasks][TKp-tsk] | [Scrum Board][TKp-scb] | [Commits][TKp-cmt] |

[alg-git]: https://github.com/algolg
[alg-tsk]: https://github.com/iskapoor/group-l/issues?q=assignee%3Aalgolg+
[alg-scb]: https://github.com/iskapoor/group-l/projects/1?card_filter_query=assignee%3Aalgolg
[alg-cmt]: https://github.com/iskapoor/group-l/commits?author=algolg
[ish-git1]: https://github.com/iskapoor
[ish-git2]: https://github.com/Eshan21
[ish-tsk]: https://github.com/iskapoor/group-l/issues?q=label%3Aishan
[ish-scb]: https://github.com/iskapoor/group-l/projects/1?card_filter_query=label%3Aishan
[ish-cmt1]: https://github.com/iskapoor/group-l/commits?author=iskapoor
[ish-cmt2]: https://github.com/iskapoor/group-l/commits?author=Eshan21
[jla-git]: https://github.com/jlaaa
[jla-tsk]: https://github.com/iskapoor/group-l/issues?q=assignee%3Ajlaaa+
[jla-scb]: https://github.com/iskapoor/group-l/projects/1?card_filter_query=assignee%3Ajlaaa
[jla-cmt]: https://github.com/iskapoor/group-l/commits?author=jlaaa
[TKp-git]: https://github.com/TKperson
[TKp-tsk]: https://github.com/iskapoor/group-l/issues?q=assignee%3ATKperson+
[TKp-scb]: https://github.com/iskapoor/group-l/projects/1?card_filter_query=assignee%3ATKperson
[TKp-cmt]: https://github.com/iskapoor/group-l/commits?author=TKperson

<details><summary>PBL Team Week 3</summary>
 
| Name | Contributions | Importance | Tangibles |
| --- | --- | --- | --- |
| Akhil | --- | --- | --- |
| Ishan | --- | --- | --- |
| Jonathan | --- | --- | --- |
| Mingzy/Michael | --- | --- | --- |
| Brayden | --- | --- | --- |

</details>

# Purpose
RiceLab is a project made for people that want to show or see other people's [rice](https://thatnixguy.github.io/posts/ricing/). Ricing experts will be able to post their own rice for their environment on the site for other people to use and learn from. We welcome experts and beginners alike to join our coummunity and learn for one another's next rice!

# Install
To install a pre-built release:

- Install [JDK 11](https://adoptium.net/releases.html?variant=openjdk11)
- Download and extract a RiceLab [release][] file
- Run server with `java -jar Ricelab-x.y.z*.jar`

[release]: https://github.com/iskapoor/group-l/releases

# Build or Run From Source

## Install Dependencies
- [JDK 11](https://adoptium.net/releases.html?variant=openjdk11)
- [Maven 3.8.3](https://maven.apache.org/download.cgi)
- [MySQL 8.0.27](https://dev.mysql.com/doc/mysql-getting-started/en/)

Download the source code as a [zip][source] or with git:

[source]: https://github.com/iskapoor/group-l/archive/refs/heads/main.zip

```
git clone https://github.com/iskapoor/group-l.git
```

## Setup MySQL Database
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

### Install and Connect to MySQL Server
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

### Setup Database
- Setup database and permissions
```
mysql> create database springdb; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'changethispassword'; -- Creates the user
mysql> grant select, insert, delete, update on springdb.* to 'springuser'@'%'; -- Gives specific privileges to the user on the database
mysql> flush privileges; -- Apply privileges
```

- Add to `src/main/resources/application.properties`
```
spring.jpa.hibernate.ddl-auto=update # Change to 'none' when deployed
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/springdb
spring.datasource.username=springuser
spring.datasource.password=changethispassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## Build/Run
Then build the JAR file with the build scripts:
- Run `./build` or `./build.cmd`

Or run in place:
- Run `./run` or `./run.cmd`

# How to Contribute / Policies
See [CONTRIBUTING.md](CONTRIBUTING.md) on how to contribute to our project.

# Wiki / Documentation
Javadocs is used for generating documentation. Run `./gendocs` or `./gendocs.cmd` to generate documentation in the `target/site/apidocs/` directory.
