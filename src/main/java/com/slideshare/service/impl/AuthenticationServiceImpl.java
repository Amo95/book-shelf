package com.slideshare.service.impl;

import com.slideshare.dto.request.AuthenticationRequest;
import com.slideshare.dto.response.JwtAuthenticationResponse;
import com.slideshare.enums.Role;
import com.slideshare.model.User;
import com.slideshare.service.AuthenticationService;
import com.slideshare.service.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public JwtAuthenticationResponse signUp(AuthenticationRequest request) {
        User user = User.builder()
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getPassword())
                .indexNumber(request.getIndexNumber())
                .role(Role.USER)
                .build();
        return JwtAuthenticationResponse.builder()
                .token(jwtService.generateToken(user))
                .build();
    }
}
