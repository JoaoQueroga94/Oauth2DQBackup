package itriad.com.controllers;

import io.swagger.annotations.Api;
import itriad.com.oauth.AuthenticationService;
import itriad.com.oauth.SessionToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Api(value = "Login", description = "Manager Login", tags = "Login")
@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginService {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<SessionToken> login(@RequestParam("login") String login, @RequestParam("password") String password) {

        Call<SessionToken> call = authenticationService.getToken(password, login, "password", "read write", "evento");

        try {

            Response<SessionToken> execute = call.execute();

            if (execute.isSuccessful()) {
                SessionToken response = execute.body();

                System.out.println("SessionToken" + response.toString());

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                System.out.println("Error Request");
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}