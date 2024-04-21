package ru.martinov.externalsystem.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    /**
     * По адресу http://localhost:{порт_приложения}/swagger-ui/index.html мы можем увидеть сваггер
     */
    @Bean
    public GroupedOpenApi customOpenAPI() {
        return GroupedOpenApi.builder()
                .group("debezium-master-postgresql-api")
                .packagesToScan("ru.martinov.externalsystem.controller")
                .build();
    }
}
