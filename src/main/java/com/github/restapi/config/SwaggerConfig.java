package com.github.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;  // 올바른 SecurityScheme 임포트

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("blog 프로젝트 API")
                        .description("게시물을 올리고 삭제하는 기능")
                        .version("1.0.0"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)  // SecurityScheme의 Type 사용
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }
}