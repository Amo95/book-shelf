package com.slideshare.dto.request;

import lombok.Builder;

@Builder
public record signinRequest(String indexNumber, String password) {
}
