package itriad.com.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@Api(value = "Me", description = "Manager Me", tags = "Me")
@RestController
@RequestMapping(path = "/api/v1/me")
public class PrincipalResource {

//    @PreAuthorize("#oauth2.hasScope('read') and #oauth2.hasScope('write') and hasRole('USER') or hasRole('ADMIN')")
    @ApiOperation(value = "", authorizations = {@Authorization(value = "access_token")})
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> oauth(Principal principal) {

        Optional<Principal> authentication = Optional.ofNullable(principal);

        if (authentication.isPresent()) {

            String login = principal.getName();

            if (login != null) {
                return new ResponseEntity<>(login, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}