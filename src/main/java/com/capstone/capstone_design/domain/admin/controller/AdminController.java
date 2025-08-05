package com.capstone.capstone_design.domain.admin.controller;

import com.capstone.capstone_design.domain.admin.dto.RestaurantCreateRequestDto;
import com.capstone.capstone_design.domain.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    //식당 추가
    @PostMapping("/restaurants")
    public ResponseEntity<Void> addRestaurant(@RequestBody RestaurantCreateRequestDto requestDto){
        adminService.addRestaurant(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
