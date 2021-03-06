package com.miniOne.MiniOne.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
