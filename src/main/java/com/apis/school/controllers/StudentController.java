package com.apis.school.controllers;

import com.apis.school.entity.Student;
import com.apis.school.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String hello(){
        return "Well Come to Student management Api";
    }

    @PostMapping("/students")
    public Student allStudents(@RequestBody Student student){
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent(){
        return repository.findAll();
    }

    @GetMapping("/students/{student_id}")
    public Student findStudentById(@PathVariable("student_id") Integer id){
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{student_name}")
    public List<Student> findStudentsByName(@PathVariable("student_name") String firstName){
        return repository.findAllByFirstNameContaining(firstName);
    }

    @DeleteMapping("/students/{student_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("student_id") Integer id){
        repository.deleteById(id);
    }

    @DeleteMapping("/deleteAllStudents")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllStudent(){
        repository.deleteAll();
    }
}
