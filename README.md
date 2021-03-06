# jersey2-spring-seed-project
[![Build Status](https://travis-ci.org/julesbond007/jersey2-spring-seed-project.svg?branch=master)](https://travis-ci.org/julesbond007/jersey2-spring-seed-project)
[![Coverage Status](https://coveralls.io/repos/julesbond007/jersey2-spring-seed-project/badge.svg?branch=master&service=github)](https://coveralls.io/github/julesbond007/jersey2-spring-seed-project?branch=master) 

Seed project to create REST API using Jersey2 and Spring Framework for dependency injection.  

- Spring beans and dependencies are configured using annotations.
- Database access via Spring Data/JPA/Hibernate
- Gradle as build management
- Testng with hsqldb for unit testing.

This also comes with a gradle task to aggregate unit test coverage from subprojects: 
- `gradle jacocoRootReport`

#full tech stack
- Java 1.7
- Jersey 2.22.1
- Spring 4.2.2
- Spring Data/JPA 1.9.0
- PostGreSQL 9.4.5
- Gradle 2.2.1
- TestNG 6.9.4
- HSQLDB 2.3.3

#setup
- Rename subprojects `project-*` to `yourproject name` i.e: `project-api` --> `fantastic-api`
- Rename the default package  `com.project` to `com.your-company`
- Update `gradle.settings` with new project names
- Update `web.xml` with new package names
- Ensure JNDI resource exists in `$TOMCAT_HOME/conf/server.xml`:
```xml
<Resource name="jndiDBresource"
        auth="Container"
        type="javax.sql.DataSource"
        username="postgres"
        password=""
        driverClassName="org.postgresql.Driver"
        url="jdbc:postgresql://localhost:5432/postgres"
        maxTotal="25"
        maxIdle="10"
        validationQuery="select 1" />
```
