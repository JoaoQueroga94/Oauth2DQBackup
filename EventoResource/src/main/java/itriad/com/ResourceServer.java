package itriad.com;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;

import java.io.IOException;
import java.util.Collections;

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServer extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAccessTokenConverter customAccessTokenConverter;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
               .antMatchers("/swagger-ui", "/api/v1**")
               .permitAll();

        http.cors().configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.addAllowedOrigin("*");
            config.setAllowCredentials(true);
            return config;
        });
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer config) throws IOException {
        config.tokenServices(tokenServices());
    }

    @Bean
    public TokenStore tokenStore() throws IOException {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() throws IOException {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() throws IOException {

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public.txt");

        String publicKey = IOUtils.toString(resource.getInputStream());
        converter.setVerifierKey(publicKey);
        converter.setAccessTokenConverter(customAccessTokenConverter);

        return converter;
    }
}