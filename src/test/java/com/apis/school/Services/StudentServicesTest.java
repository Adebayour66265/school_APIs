package com.apis.school.Services;

import com.apis.school.dto.StudentDto;
import com.apis.school.dto.StudentResponseDto;
import com.apis.school.entity.Student;
import com.apis.school.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


class StudentServicesTest {

    @InjectMocks
    private StudentServices studentServices;
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void allStudents() {
        StudentDto dto = new StudentDto(1,"Ade", "Bayour","ade@gmail.com", 50);

        Student student = new Student("Ade", "Bayour","ade@gmail.com", 50);

        Student savedStudent = new Student("Ade", "Bayour","ade@gmail.com", 50);

        savedStudent.setId(1);

        Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);
        Mockito.when(repository.save(student)).thenReturn(savedStudent);
        Mockito.when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(
                new StudentResponseDto(
                        "Ade", "Bayour","ade@gmail.com",50
                )
        );


        StudentResponseDto responseDto = studentServices.allStudents(dto);

        Assertions.assertEquals(dto.firstName(), responseDto.firstName());
        Assertions.assertEquals(dto.lastName(), responseDto.lastName());
        Assertions.assertEquals(dto.email(), responseDto.email());
    }

    @Test
    public void findAllStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ade", "Bayour","ade@gmail.com", 50));

        Mockito.when(repository.findAll()).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class))).thenReturn(
                new StudentResponseDto("Ade", "Bayour","ade@gmail.com", 50)
        );
        List<Student> responseDtos = studentServices.findAllStudent();

        Assertions.assertEquals(students.size(), responseDtos.size());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    public void findStudentById() {
        Integer studenId = 1;
        Student student = new Student("Ade", "Bayour","ade@gmail.com", 50);

        Mockito.when(repository.findById(studenId)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDto(
                    "Ade", "Bayour","ade@gmail.com", 50));


        StudentResponseDto dto = studentServices.findStudentById(studenId);

        Assertions.assertEquals(dto.firstName(), student.getFirstName());
        Assertions.assertEquals(dto.lastName(), student.getLastName());
        Assertions.assertEquals(dto.email(), student.getEmail());

        Mockito.verify(repository, Mockito.times(1)).findById(studenId);

    }

    @Test
    public void findStudentsByName() {
        List<Student> students = new ArrayList<>();
        String studenName = "Ade";
        Student student = new Student("Ade", "Bayour","ade@gmail.com", 50);

        Mockito.when(repository.findAllByFirstNameContaining(studenName)).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "Ade", "Bayour","ade@gmail.com", 50));


        var dto = studentServices.findStudentsByName(studenName);

        Assertions.assertEquals(students.size(), dto.size());

        Mockito.verify(repository, Mockito.times(1))
                .findAllByFirstNameContaining(studenName);

    }

    @Test
    void deleteStudentById() {
    }

    @Test
    void deleteAllStudent() {
    }
}