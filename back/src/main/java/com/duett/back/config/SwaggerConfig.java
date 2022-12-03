package com.duett.back.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api1() {
        return GroupedOpenApi.builder()
                .group("DesafioDuettApplication")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customizeOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Desafio Duett")
                .description("Application that represents the classes.")
                .version("v1")
            )
            .externalDocs(new ExternalDocumentation()
                .description("Desafio Duett Repo")
                .url("https://github.com/GiovanniFrozza/Fruteira-Duett")
            );
    }
}
