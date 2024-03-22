package com.apis.school;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "School Application APIs",
                description = "School management application backend",
                version = "v1.0",
                contact = @Contact(
                        name = "MUSTAPHA NURUDEEN",
                        email = "adebayour66265@gmail.com",
                        url = "https://github.com/Adebayour66265/school_APIs"
                ),
                license = @License(
                        name = "School Application APIs",
                        url = "https://github.com/Adebayour66265/school_APIs"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Complete School management application backend",
                url = "https://github.com/Adebayour66265/school_APIs"
        )
)
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
		System.out.println("School website APIs server Connect");
	}

}
