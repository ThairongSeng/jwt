package com.istad.friendlyjwt.controller;

import com.istad.friendlyjwt.model.request.LoginRequest;
import com.istad.friendlyjwt.model.response.LoginResponse;
import com.istad.friendlyjwt.service.TokenService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    private final TokenService tokenService;
    private final AuthenticationProvider authenticationProvider;
    public AuthenticationController( AuthenticationProvider authenticationProvider, TokenService tokenService){
        this.tokenService=tokenService;
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping ("/loginform")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
    Authentication authentication = new UsernamePasswordAuthenticationToken(
            loginRequest.getUsername()
            ,loginRequest.getPassword()
    );
    authentication = authenticationProvider.authenticate(authentication);

    // JWT
    LoginResponse response = new LoginResponse();
    String token = tokenService.generateToken(authentication);
    response.setAccessToken(token);
    response.setTokenType("Bebe");
    return response;

}
}
