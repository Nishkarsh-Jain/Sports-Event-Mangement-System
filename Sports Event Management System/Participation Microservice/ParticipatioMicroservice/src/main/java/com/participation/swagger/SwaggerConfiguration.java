package com.participation.swagger;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/*
 * Swagger Configuration
 * */

@Configuration
@OpenAPIDefinition(info = @Info(title = "Participation Microservice", version = "2.0", description = "This Microservice is to provide Request for the participation. View the participation request. Update the participation status. List the participation request based on approved/ declined /pending status separately."))
public class SwaggerConfiguration {

}
