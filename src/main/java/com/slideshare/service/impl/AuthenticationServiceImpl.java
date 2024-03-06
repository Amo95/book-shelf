package com.slideshare.service.impl;

import com.slideshare.dto.request.AuthenticationRequest;
import com.slideshare.dto.response.AuthenticationResponse;
import com.slideshare.service.AuthenticationService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public AuthenticationResponse signUp(AuthenticationRequest request) {
        return null;
    }
}
