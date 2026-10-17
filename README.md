# College Event Management System

Beginner-friendly mini project using Java 17, HTML, CSS, MySQL, JDBC, Maven and Apache Tomcat 10.1.

## Features
- Modern home page
- Event registration form
- Saves registration data to MySQL
- Admin page lists saved registrations

## Requirements
- JDK 17 or newer
- MySQL Server (Workbench is optional)
- Apache Maven
- Apache Tomcat 10.1
- VS Code (Java and Maven extensions recommended)

## Setup
1. Open MySQL Workbench and run `database.sql`.
2. Open `src/main/java/com/college/DB.java` and replace `YOUR_MYSQL_PASSWORD` with your local MySQL password. Do not commit a real password to GitHub.
3. In VS Code, use **File → Open Folder** and select the repository/project folder that contains `pom.xml`.
4. Open **Terminal → New Terminal**. In PowerShell, run `dir` and confirm that `pom.xml` is listed in the current directory.
5. Run `mvn clean package`.
6. When the build succeeds, find `target/CollegeEvents.war`.
7. Copy that WAR file into Tomcat's `webapps` folder.
8. Start Tomcat using `bin/startup.bat`.
9. Open `http://localhost:8080/CollegeEvents/`.
10. View saved registrations at `http://localhost:8080/CollegeEvents/admin`.

## Fix for "there is no POM in this directory"
This error means Maven was started from a folder that does not contain `pom.xml`. Open the project folder itself (not its parent folder), or change to the correct directory in PowerShell before running Maven. For example:

```powershell
cd "C:\path\to\CollegeEventManagementSystem"
dir
mvn clean package
```

Replace the example path with your actual project path. The `dir` output must include `pom.xml`.

## Troubleshooting
- If `mvn` is not recognized, install Maven and make sure `mvn -version` works in a new terminal.
- If Tomcat reports a deployment error, use Tomcat 10.1; this project uses Jakarta Servlet 6 and will not run on Tomcat 9 without changes.
- MySQL Server must be running before registration.
- The `/admin` page is a simple classroom demo page and has no login protection. Do not publish it publicly without adding authentication.
