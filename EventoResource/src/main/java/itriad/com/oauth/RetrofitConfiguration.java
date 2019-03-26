package itriad.com.oauth;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfiguration {

    @Value("${oauth.url}")
    private String oauthUrl;

    @Bean
    public OkHttpClient okHttpClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return httpClient.build();
    }

    @Bean
    public Retrofit retrofit(OkHttpClient client) {

        return new Retrofit.Builder()
                .baseUrl(oauthUrl)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    @Bean
    public AuthenticationService userService(Retrofit retrofit) {
        return retrofit.create(AuthenticationService.class);
    }
}