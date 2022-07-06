package com.player.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Swagger Configuration Class
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Player Microservice", version = "2.0", description = "This Microservice helps to add, view & remove the new players along with their details."))
public class SwaggerConfig {

}
