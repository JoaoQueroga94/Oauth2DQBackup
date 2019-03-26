package itriad.com.oauth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthenticationService {

    @FormUrlEncoded
    @Headers({
            "Authorization: Basic ZXZlbnRvOnNlY3JldA==",
            "Accept: application/json"
    })
    @POST("oauth/token")
    Call<SessionToken> getToken(@Field("password") String password,
                                @Field("username") String username,
                                @Field("grant_type") String grantType,
                                @Field("scope") String scope,
                                @Field("client_id") String clientId);
}