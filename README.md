# College Event Management System

A mini project built with Java, JSP, Jakarta Servlets, JSTL, JDBC, MySQL, Maven, and Apache Tomcat 10.1.

## Existing project structure

- `src/main/webapp/index.jsp` — CampusConnect landing page and registration form.
- `src/main/java/com/college/RegisterServlet.java` — validates and saves registrations.
- `src/main/java/com/college/AdminServlet.java` — loads saved rows from MySQL.
- `src/main/java/com/college/Registration.java` — registration model.
- `src/main/java/com/college/DB.java` — JDBC connection configuration.
- `src/main/webapp/admin.jsp` — displays database rows using JSTL.
- `src/main/webapp/style.css` and `script.js` — frontend styling and interactions.
- `database.sql` — creates the database and registrations table.

## Requirements

- JDK 17 or newer (the project compiles to Java 17 bytecode)
- Apache Maven 3.9+
- MySQL Server and MySQL Workbench (Workbench is optional)
- Apache Tomcat 10.1

Tomcat 10.1 uses Jakarta Servlet APIs. This project uses `jakarta.servlet.*`, so do not switch to Tomcat 9 unless you migrate the code to the older `javax.servlet.*` APIs.

## Setup on Windows

1. Start MySQL Server.
2. Open `database.sql` in MySQL Workbench and execute the whole script.
3. Open `src/main/java/com/college/DB.java`. Set the fallback `PASSWORD` value to your local MySQL password, or set the `DB_PASSWORD` environment variable for the Tomcat process. Do not commit a real password to this public repository.
4. Open the root folder containing `pom.xml` in VS Code.
5. In the VS Code terminal, run:

   ```bash
   mvn -U clean package
   ```

6. Confirm Maven prints `BUILD SUCCESS`. The WAR file should be `target/CollegeEvents.war` (the name comes from `<finalName>CollegeEvents</finalName>` in `pom.xml`).
7. Copy `target/CollegeEvents.war` into Tomcat 10.1's `webapps` directory.
8. Start Tomcat and wait for the application to deploy.
9. Open the site at `http://localhost:8080/CollegeEvents/`.
10. Submit a test registration, then open `http://localhost:8080/CollegeEvents/admin` to view the saved MySQL rows.

## Important: don't use Live Server

VS Code Live Server serves static HTML/CSS/JavaScript only. It does not compile JSP files or run Java Servlets and cannot connect this form to the Java backend. Run this project through Tomcat using the URL above, not a `127.0.0.1:5500` URL.

## Verify database storage

Run this query in MySQL Workbench:

```sql
USE college_events;
SELECT * FROM registrations ORDER BY registered_at DESC;
```

## Troubleshooting

- **Maven command not found:** open a new terminal and run `mvn -version`; verify Maven is installed and on PATH.
- **404 on the app URL:** confirm Tomcat is running, the WAR is in `webapps`, and the URL uses `/CollegeEvents/`.
- **Database error:** verify MySQL is running, `database.sql` was executed, and the password in `DB.java` is correct.
- **Build/download error:** check internet/proxy access to Maven Central, then retry `mvn -U clean package`.
- **JSP or servlet error:** check the Tomcat `logs` directory for the stack trace.

## Security note

This is a local classroom demonstration. The admin page has no login protection and should not be exposed publicly without authentication and other production security measures.
