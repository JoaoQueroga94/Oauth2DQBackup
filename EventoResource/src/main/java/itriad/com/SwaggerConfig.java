package itriad.com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.ant;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${oauth.url}")
    private String oauthUrl;

    public static final String CLIENT_ID = "evento";
    public static final String CLIENT_SECRET = "secret";

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(ant("/api/v1/**"))
                .build()
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Evento  Api Documentation")
                .title("Evento School API")
                .description("Documentation to integrate with Evento features")
                .termsOfServiceUrl("http://evento.com.br/terms")
                .contact(new Contact("Evento", "https://evento.com.br", "support@evento.com.br"))
                .license("Evento License Version 2.0")
                .licenseUrl("https://evento/license/LICENSE-2.0")
                .version("1.0")
                .build();
    }

    @Bean
    public SecurityConfiguration security() {

        return SecurityConfigurationBuilder.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("access_token", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("spring_oauth", scopes())))
                .forPaths(PathSelectors.regex("/api/v1.*"))
                .build();
    }

    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations"),
                new AuthorizationScope("evento", "Access foo API")
        };
    }
}