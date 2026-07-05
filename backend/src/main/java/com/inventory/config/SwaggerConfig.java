package com.inventory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI inventoryOpenAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Inventory Management System API")

                        .description("Spring Boot REST APIs for Inventory Management")

                        .version("1.0")

                        .contact(new Contact()

                                .name("Shivashankar Bansode")

                                .email("bansodeshiv051@gmail.com")

                                .url("https://github.com/basodes")));
    }

}