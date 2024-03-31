# School and Student Management API

This API provides endpoints for managing schools and students.

## SchoolController

### Endpoints

- `POST /schools`: Create a new school.
- `GET /schools`: Retrieve all schools.
- `GET /getAllStudentInEachSchool`: Retrieve all students in each school.
- `DELETE /school/{school_id}`: Delete a school by ID.

### Usage

- To create a new school, send a POST request to `/schools` with the school data in the request body.
- To retrieve all schools, send a GET request to `/schools`.
- To retrieve all students in each school, send a GET request to `/getAllStudentInEachSchool`.
- To delete a school by ID, send a DELETE request to `/school/{school_id}`.

## StudentController

### Endpoints

- `GET /`: Get a welcome message.
- `POST /students`: Create a new student.
- `GET /students`: Retrieve all students.
- `GET /students/{student_id}`: Retrieve a student by ID.
- `GET /students/search/{student_name}`: Search for students by name.
- `DELETE /students/{student_id}`: Delete a student by ID.
- `DELETE /deleteAllStudents`: Delete all students.

### Usage

- To get a welcome message, send a GET request to `/`.
- To create a new student, send a POST request to `/students` with the student data in the request body.
- To retrieve all students, send a GET request to `/students`.
- To retrieve a student by ID, send a GET request to `/students/{student_id}`.
- To search for students by name, send a GET request to `/students/search/{student_name}`.
- To delete a student by ID, send a DELETE request to `/students/{student_id}`.
- To delete all students, send a DELETE request to `/deleteAllStudents`.

### Dependencies

- Java
- Spring Boot
- Jakarta Validation API
- Spring Web
- Postgresql
- Lombok
- Openapi Swagger-ui
- Maven Plugin

