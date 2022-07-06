package com.sports.event.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/*
 * Swagger Configuration Class
 * */

@Configuration
@OpenAPIDefinition(info = @Info(title = "Sports Event Microservice", version = "2.0", description = "This Microservice is to provide the functionality like to view all the Sports & by its name. Create, update and cancel the events (based on sports name). View all Events and search event by event id."))
public class SwaggerConfig {

}
