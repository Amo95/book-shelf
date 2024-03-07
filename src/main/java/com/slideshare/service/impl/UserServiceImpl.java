package com.slideshare.service.impl;

import com.slideshare.repository.UserRepository;
import com.slideshare.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return indexNumber -> userRepository.findByIndexNumber(indexNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
