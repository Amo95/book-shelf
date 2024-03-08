package com.slideshare.dto.response;

import lombok.Builder;

@Builder
public record JwtAuthenticationResponse(String token) {
}
