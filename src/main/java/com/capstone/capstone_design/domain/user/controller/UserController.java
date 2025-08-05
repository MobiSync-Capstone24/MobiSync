package com.capstone.capstone_design.domain.user.controller;

import com.capstone.capstone_design.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> getMeInfo() {
        return ResponseEntity.ok(userService.getMyInfo());
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateMyInfo(@RequestBody Object updateRequestDto) {
        userService.updateMyInfo(updateRequestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/me")
    public ResponseEntity<?> deleteMyAccount() {
        userService.deleteMyAccount();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me/tastes")
    public ResponseEntity<?> getMyTastes() {
        return ResponseEntity.ok(userService.getMyTastes());
    }

    @PutMapping("/me/tastes")
    public ResponseEntity<?> updateMyTastes(@RequestBody Object tasteRequestDto) {
        userService.updateMyTastes(tasteRequestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me/dibs")
    public ResponseEntity<?> getMyDibs() {
        return ResponseEntity.ok(userService.getMyDibs());
    }

    @GetMapping("/me/orders")
    public ResponseEntity<?> getMyOrders() {
        return ResponseEntity.ok(userService.getMyOrders());
    }

    @GetMapping("/me/reviews")
    public ResponseEntity<?> getMyReviews() {
        return ResponseEntity.ok(userService.getMyReviews());
    }

    @GetMapping("/me/coupons")
    public ResponseEntity<?> getMyCoupons() {
        return ResponseEntity.ok(userService.getMyCoupons());
    }

    @PostMapping("/me/coupons")
    public ResponseEntity<?> issueCoupon(@RequestBody Object couponRequestDto) {
        userService.issueCoupon(couponRequestDto);
        return ResponseEntity.ok().build();
    }
}
