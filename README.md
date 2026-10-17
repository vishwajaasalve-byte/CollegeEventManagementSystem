# College Event Management System

A mini project using **Java 17, JSP, Jakarta Servlets, JSTL, JDBC, MySQL, Maven and Apache Tomcat 10.1**.

## Pages and flow
- `index.jsp`: CampusConnect landing page and event registration form.
- `RegisterServlet.java`: validates form fields and inserts registration into MySQL.
- `AdminServlet.java`: reads registration rows from MySQL and forwards them to JSP.
- `admin.jsp`: displays the saved registration records using JSTL.
- `DB.java`: shared JDBC connection.
- `style.css`: responsive styling for the pages.

## Requirements
- JDK 17+
- Apache Maven 3.9+
- MySQL Server
- Apache Tomcat 10.1
- VS Code or another Java IDE

## Setup
1. Run `database.sql` in MySQL Workbench.
2. Open `src/main/java/com/college/DB.java` and set your local MySQL password. Do not commit a real password to a public GitHub repository.
3. Open the folder containing `pom.xml` in VS Code.
4. Run `mvn -U clean package`.
5. Copy `target/CollegeEvents.war` to Tomcat 10.1's `webapps` folder and start Tomcat.
6. Open `http://localhost:8080/CollegeEvents/`.
7. Register a sample entry, then open `http://localhost:8080/CollegeEvents/admin` to view the MySQL records.

## Maven download error
If Maven reports that it cannot transfer a plugin from Maven Central, verify that the URL `https://repo.maven.apache.org/maven2/` is reachable in your browser, then run `mvn -U clean package`. Check proxy/firewall settings if the download remains blocked.

## Note
The admin page is intended for a local classroom demo and does not have authentication. Add login protection before deploying publicly.
