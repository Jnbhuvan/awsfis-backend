package com.awsfis.portfolio.dtos;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String password;
    private String email;
}
