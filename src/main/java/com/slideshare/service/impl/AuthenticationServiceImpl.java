package com.slideshare.service.impl;

import com.slideshare.dto.request.AuthenticationRequest;
import com.slideshare.dto.response.JwtAuthenticationResponse;
import com.slideshare.enums.Role;
import com.slideshare.model.User;
import com.slideshare.service.AuthenticationService;
import com.slideshare.service.JwtService;
import com.slideshare.util.BasicMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final BasicMapper basicMapper;

    public AuthenticationServiceImpl(PasswordEncoder passwordEncoder, JwtService jwtService, BasicMapper basicMapper) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.basicMapper = basicMapper;
    }

    @Override
    public JwtAuthenticationResponse signUp(AuthenticationRequest request) {
        return basicMapper.convertTo(
                jwtService.generateToken(
                        User.builder()
                                .indexNumber(request.getIndexNumber())
                                .email(request.getPassword())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .build()
                ), JwtAuthenticationResponse.class);
    }
}
