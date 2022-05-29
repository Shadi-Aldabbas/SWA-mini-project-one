package com.miniOne.MiniOne.controller;

import com.miniOne.MiniOne.model.LoginRequest;
import com.miniOne.MiniOne.model.LoginResponse;
import com.miniOne.MiniOne.model.RefreshTokenRequest;
import com.miniOne.MiniOne.model.SignUpRequest;
import com.miniOne.MiniOne.service.UaaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/uaa")
@CrossOrigin
public class UaaController {

    private final UaaService uaaService;

    public UaaController(UaaService uaaService) {
        this.uaaService = uaaService;
    }

    @GetMapping("/test")
    public String test() {
        return "test work";
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = uaaService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }
    @PostMapping("/add")
    public String signUp(@RequestBody SignUpRequest body) {
        uaaService.signUp(body);
        return "success";
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return uaaService.refreshToken(refreshTokenRequest);
    }
}
