package com.apis.school.Services;

import com.apis.school.dto.StudentDto;
import com.apis.school.dto.StudentResponseDto;
import com.apis.school.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void toStudent() {
        StudentDto dto = new StudentDto(1, "Ayinla", "Adebayour", "adebayour@gmail.com", 28);

        Student student = studentMapper.toStudent(dto);
        Assertions.assertEquals(dto.firstName(), student.getFirstName());
        Assertions.assertEquals(dto.lastName(), student.getLastName());
        Assertions.assertEquals(dto.email(), student.getEmail());
        Assertions.assertEquals(dto.age(), student.getAge());
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    void toStudentResponseDto() {
        Student student = new Student( "Ishola", "Nurudeen", "ade@gmail.com", 30);

        StudentResponseDto responseDto = studentMapper.toStudentResponseDto(student);

        Assertions.assertEquals(responseDto.firstName(), student.getFirstName());
        Assertions.assertEquals(responseDto.lastName(), student.getLastName());
        Assertions.assertEquals(responseDto.email(), student.getEmail());
        Assertions.assertEquals(responseDto.age(), student.getAge());

    }
}