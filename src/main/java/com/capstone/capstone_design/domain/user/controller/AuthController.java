package com.capstone.capstone_design.domain.user.controller;

import com.capstone.capstone_design.domain.user.model.Users;
import com.capstone.capstone_design.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Users users) {
        return authService.signup(users);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users users) {
        return authService.login(users);
    }



    /*
    /signup : 사용자 생성 POST
    /login : 로그인 POST
     */
}
