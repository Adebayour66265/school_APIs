package com.apis.school.dto;

public record StudentResponseDto(
        String firstName,
        String lastName,
        String email,
        int age
) {
}
