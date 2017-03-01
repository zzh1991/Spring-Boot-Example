# Spring-Boot-Example

## URL mapping

- http://localhost:8080/

  - Hello World!

- http://localhost:8080/index.html

  - form to operation the database

  - database setting

    - ```tex
      spring.jpa.hibernate.ddl-auto=create	// none
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      spring.datasource.url=jdbc:mysql://localhost:3306/db_book?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
      ```

      ​

  - JdbcTemplate to get/post the data

  - JPA (CrudRepository<User, Integer>) to get/post the data

- http://localhost:8080/greeting

  - Thymeleaf model

- http://localhost:8080/validate

  - form data validation

## Spring Boot Hot Deployment

- pom.xml

  ```xml
  <!-- spring-boot-devtools -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <optional>true</optional>
  </dependency>

  <!-- Spring Loaded -->
  <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <dependencies>
          <dependency>
              <groupId>org.springframework</groupId>
              <artifactId>springloaded</artifactId>
              <version>1.2.6.RELEASE</version>
          </dependency>
      </dependencies>
  </plugin>

  mvn spring-boot:run
  ```

- model hot deployment (application.properties)

  ```properties
  spring.thymeleaf.cache=false
  spring.devtools.restart.additional-paths= # Additional paths to watch for changes.
  ```

- IDEA Setting

  Complier: Make project automatically