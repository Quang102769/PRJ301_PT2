# Project Setup Instructions

## SQL Server Setup
1. Install SQL Server and create a new database.
2. Ensure that TCP/IP is enabled in SQL Server Configuration Manager.
3. Replace JDBC connection credentials in `DBConnection.java`.

## Tomcat Setup
1. Download and install Apache Tomcat.
2. Deploy the WAR file created by Maven in the webapps directory.
3. Start Tomcat and access the application at `http://localhost:8080/mvc-jsp-servlet`.
