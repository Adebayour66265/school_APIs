package com.apis.school.Services;

import com.apis.school.dto.StudentDto;
import com.apis.school.dto.StudentResponseDto;
import com.apis.school.entity.Student;
import com.apis.school.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentServices(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto allStudents(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<Student> findAllStudent(){
        return repository.findAll();
    }
    public Student findStudentById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<Student> findStudentsByName(String firstName){
        return repository.findAllByFirstNameContaining(firstName);
    }

    public void deleteStudentById(Integer id){
        repository.deleteById(id);
    }

    public void deleteAllStudent(){
        repository.deleteAll();
    }
}
