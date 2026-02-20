# Project Overview
    The Planner application is an application that allows the user to create certain tasks to complete and manage these tasks in an organized manner. Each task will have a title, a description, and a due date. The user can add as many tasks as they desire and update the status of the task to be completed whenever the task is done. The user may also delete tasks from their planner, change a completed task back to incomplete, and filter their tasks based on their status by selecting buttons on the UI. These tasks are automatically sorted by date, with the highest priority tasks (tasks with earlier due dates) at the top of the list. Below are the instructions on how to start the backend portion of this application.
# 1. Login to PostgreSQL
    Run "psql -U postgres" in command line. 
    Enter password.
# 2. Create the planner database in PostgreSQL
    Execute "CREATE DATABASE plannerdb;".
    
# 3. Connect to PostgresSQL database
    Execute "\c planner db".

# 4. Add "application.yml" file to your project with the variables below
  spring:
    datasource:
      url: jdbc:postgresql://localhost:5432/plannerdb
      username: postgres
      password: yourpassword

    jpa:
      hibernate:
        ddl-auto: update
      show-sql: true
      properties:
        hibernate:
          format_sql: true

    database-platform: org.hibernate.dialect.PostgreSQLDialect

  server:
    port: 8080

# 5. Clone the project 
    git clone https://github.com/thomasliu2019/Planner-Application-Backend

# 6. Navigate to the project directory
    cd Planner-Application-Backend

# 7. Build the project
    mvn clean install -DskipTests
    
# 8. Run the project 
    mvn spring-boot:run
