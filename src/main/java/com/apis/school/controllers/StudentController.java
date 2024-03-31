package com.apis.school.controllers;

import com.apis.school.ErrorsController.ErrorFile;
import com.apis.school.Services.StudentServices;
import com.apis.school.dto.StudentDto;
import com.apis.school.dto.StudentResponseDto;
import com.apis.school.entity.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentServices studentServices;
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("/")
    public String hello(){
        return "Well Come to Student management Api";
    }

    @PostMapping("/students")
    public StudentResponseDto allStudents(@Valid @RequestBody StudentDto dto){
       return this.studentServices.allStudents(dto);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return studentServices.findAllStudent();
    }

    @GetMapping("/students/{student_id}")
    public Student findStudentById(@PathVariable("student_id") Integer id){
        return studentServices.findStudentById(id);
    }

    @GetMapping("/students/search/{student_name}")
    public List<Student> findStudentsByName(@PathVariable("student_name") String firstName){
        return studentServices.findStudentsByName(firstName);
    }

    @DeleteMapping("/students/{student_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("student_id") Integer id){
        studentServices.deleteStudentById(id);
    }

    @DeleteMapping("/deleteAllStudents")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllStudent(){
        studentServices.deleteAllStudent();
    }
}