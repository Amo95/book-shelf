package com.slideshare.service;

import com.slideshare.dto.request.AuthenticationRequest;
import com.slideshare.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(AuthenticationRequest request);
}
