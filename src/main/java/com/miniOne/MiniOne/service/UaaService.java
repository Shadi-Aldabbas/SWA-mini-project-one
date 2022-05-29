package com.miniOne.MiniOne.service;

import com.miniOne.MiniOne.model.LoginRequest;
import com.miniOne.MiniOne.model.LoginResponse;
import com.miniOne.MiniOne.model.RefreshTokenRequest;
import com.miniOne.MiniOne.model.SignUpRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    void signUp(SignUpRequest signUpRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
