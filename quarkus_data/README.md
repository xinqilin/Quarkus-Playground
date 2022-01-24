### Quarkus Data


##### ORM

```xml
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-hibernate-orm</artifactId>
    </dependency>
```

##### JDBC Driver

```xml
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-jdbc-postgresql</artifactId>
    </dependency>

<!--        # datasource 配置-->
<!--        quarkus.datasource.db-kind = postgresql-->
<!--        quarkus.datasource.username = hibernate-->
<!--        quarkus.datasource.password = hibernate-->
<!--        quarkus.datasource.jdbc.url = jdbc:postgresql://localhost:5432/hibernate_db-->

<!--        # drop and update every times (如果只需更新可用 `update`)-->
<!--        quarkus.hibernate-orm.database.generation=drop-and-create-->
```
