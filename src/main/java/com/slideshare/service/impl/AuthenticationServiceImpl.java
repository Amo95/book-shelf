package com.slideshare.service.impl;

import com.slideshare.dto.request.signinRequest;
import com.slideshare.dto.request.signupRequest;
import com.slideshare.dto.response.JwtAuthenticationResponse;
import com.slideshare.enums.Role;
import com.slideshare.model.User;
import com.slideshare.repository.UserRepository;
import com.slideshare.service.AuthenticationService;
import com.slideshare.service.JwtService;
import com.slideshare.util.BasicMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final BasicMapper basicMapper;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, BasicMapper basicMapper, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.basicMapper = basicMapper;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public JwtAuthenticationResponse signUp(signupRequest request) {
        User user = User.builder()
                .indexNumber(request.indexNumber())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return JwtAuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }

    @Override
    public JwtAuthenticationResponse signIn(signinRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.indexNumber(),
                        request.password())
        );

        User user = userRepository.findByIndexNumber(request.indexNumber())
                .orElseThrow(() -> new IllegalArgumentException("Invalid index number or password."));
        return JwtAuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }
}
