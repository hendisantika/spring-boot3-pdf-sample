package com.hendisantika.springbootpdfsample.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/9/24
 * Time: 08:36
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    private static final String REDIRECT_URL = "/swagger-ui.html";

    @Value("${spring.mvc.servlet.path}")
    private String baseUrl;

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", baseUrl.concat(REDIRECT_URL));
        registry.addRedirectViewController("/swagger-ui", baseUrl.concat(REDIRECT_URL));
        registry.addRedirectViewController("/api", baseUrl.concat(REDIRECT_URL));
    }

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring Boot 3 PDF")
                                .description("")
                                .version("0.0.1")
                                .contact(new Contact().name("hendisantika").email("hendisantika@yahoo.co.id")))
                .externalDocs(
                        new ExternalDocumentation()
                                .description("Documentation")
                                .url("https://s.id/hendisantika"));
    }

    @Bean
    public GroupedOpenApi postApi() {
        return groupedOpenApi("posts", "/v1/posts/**");
    }

    @Bean
    public GroupedOpenApi authorApi() {
        return groupedOpenApi("authors", "/v1/authors/**");
    }

    @Bean
    public GroupedOpenApi tagApi() {
        return groupedOpenApi("tags", "/v1/tags/**");
    }


    @Bean
    public GroupedOpenApi pdfApi() {
        return groupedOpenApi("pdf", "/v1/pdf/**");
    }

    private GroupedOpenApi groupedOpenApi(String group, String... pathToMatch) {
        return GroupedOpenApi.builder().group(group).pathsToMatch(pathToMatch).build();
    }
}
