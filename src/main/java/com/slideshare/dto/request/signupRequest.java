package com.slideshare.dto.request;

import lombok.Builder;

@Builder
public record signupRequest(String indexNumber, String email, String password) {
}
