package com.bookshelve.model;

import lombok.Data;

@Data
public class UserAuthResponse {

    private String indexNumber;
    private String email;
    private String password;
}
