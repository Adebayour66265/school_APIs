# School and Student Management API

This API provides endpoints for managing schools and students.

## Prerequisites

Before running this application, you need to have the following installed:
- JDK 11 or newer
- Maven (if you are running the application using Maven)
- An IDE of your choice (Optional, for example, IntelliJ IDEA or Eclipse)

## Running the Application

### Using Maven

1. Open a terminal or command prompt.
2. Navigate to the root directory of the project where the `pom.xml` file is located.
3. Run the following command to compile the project and start the application:


The application will start and by default, it will be accessible at `http://localhost:8080`.

### Using an IDE

1. Import the project into your IDE of choice as a Maven project.
2. Locate the `main` method which is the entry point of the application. It is typically found in a class annotated with `@SpringBootApplication`.
3. Run the `main` method as a Java application.

Your IDE will start the application, and it will be accessible at `http://localhost:8080`.

## Endpoints

### SchoolController

- `POST /schools`: Create a new school.
- `GET /schools`: Retrieve all schools.
- `GET /getAllStudentInEachSchool`: Retrieve all students in each school.
- `DELETE /school/{school_id}`: Delete a school by ID.

### StudentController

- `GET /`: Get a welcome message.
- `POST /students`: Create a new student.
- `GET /students`: Retrieve all students.
- `GET /students/{student_id}`: Retrieve a student by ID.
- `GET /students/search/{student_name}`: Search for students by name.
- `DELETE /students/{student_id}`: Delete a student by ID.
- `DELETE /deleteAllStudents`: Delete all students.

