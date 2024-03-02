package com.admazsshipping.entrypoint.http.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info().title("adm-azs-shipping")
                                .description("Shipping information management API")
                                .version("v1.0")
                                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("adm-azs-shipping docs")
                                .url("https://github.com/enlaitc/adm-azs-shipping")
                );
    }
}
