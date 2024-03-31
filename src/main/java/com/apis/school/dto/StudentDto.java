package com.apis.school.dto;


import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        Integer schoolId,
        @NotEmpty(message = "First Name should not be empty")
        String firstName,

        @NotEmpty(message = "Last Name should not be empty")
        String lastName,
        String email,
        int age
) {

}
