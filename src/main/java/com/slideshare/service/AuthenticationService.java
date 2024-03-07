package com.slideshare.service;

import com.slideshare.dto.request.signinRequest;
import com.slideshare.dto.request.signupRequest;
import com.slideshare.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(signupRequest request);

    JwtAuthenticationResponse signIn(signinRequest request);
}
