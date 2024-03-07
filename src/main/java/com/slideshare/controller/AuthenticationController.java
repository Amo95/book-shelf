package com.slideshare.controller;

import com.slideshare.dto.request.signinRequest;
import com.slideshare.dto.request.signupRequest;
import com.slideshare.dto.response.JwtAuthenticationResponse;
import com.slideshare.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody signupRequest request) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody signinRequest request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
