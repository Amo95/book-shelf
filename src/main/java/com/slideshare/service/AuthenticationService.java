package com.slideshare.service;

import com.slideshare.dto.request.AuthenticationRequest;
import com.slideshare.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse signUp(AuthenticationRequest request);
}
