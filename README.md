A minimalistic demo of Speedment and Vaadin 
===========================================

See

* https://github.com/speedment/speedment
* https://github.com/vaadin/vaadin



To run the demo, perform the following steps.

* Create a MySQL database names hares with the following table.

   ```sql
    CREATE TABLE `hare` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `name` varchar(45) NOT NULL,
      `color` varchar(45) NOT NULL,
      `age` int(11) NOT NULL,
      PRIMARY KEY (`id`)
    );
   ```

* With MySQL running, start the Speedment code generator tool

   ```
    mvn speedment:tool
   ```

* Enter database credentials in the UI

* Generate code by clicking the "Generate" button without changing any defaults

* Exit the Speedment Tool

* Build and the application
```
    mvn -Djdbc.password=<pwd> -Djdbc.username=<user> compile exec:java
```
* Point a browser to the Vaadin UI http://localhost:8080

* Add data to the hares MySQL table and return to the browser to see all data updated.
