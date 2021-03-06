package com.miniOne.MiniOne.service.impl;

import com.miniOne.MiniOne.entity.User;
import com.miniOne.MiniOne.model.LoginRequest;
import com.miniOne.MiniOne.model.LoginResponse;
import com.miniOne.MiniOne.model.RefreshTokenRequest;
import com.miniOne.MiniOne.model.SignUpRequest;
import com.miniOne.MiniOne.repository.UserRepo;
import com.miniOne.MiniOne.security.JwtHelper;
import com.miniOne.MiniOne.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepo userRepo;
    private final JwtHelper jwtHelper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public void signUp(SignUpRequest signUpRequest) {
        User u = new User();
        u.setEmail(signUpRequest.getEmail());
        u.setFirstname(signUpRequest.getFirstName());
        u.setLastname(signUpRequest.getLastName());
        u.setPassword(signUpRequest.getPassword());
        userRepo.save(u);
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}
