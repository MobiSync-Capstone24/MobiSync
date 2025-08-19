package com.capstone.capstone_design.domain.dibs.controller;

import com.capstone.capstone_design.domain.dibs.service.DibsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dibs")
@RequiredArgsConstructor
public class DibsController {

    private final DibsService dibsService;

    // 식당 찜 하기
    @PostMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Void> createDibs(@PathVariable Long restaurantId) throws IllegalAccessException {
        Long userId = 1L;

        dibsService.createDibs(userId, restaurantId);
        return ResponseEntity.ok().build();
    }

    // 식당 찜 취소하기
    @DeleteMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Void> deleteDibs(@PathVariable Long restaurantId) {
        Long userId = 1L;

        dibsService.deleteDibs(userId, restaurantId);
        return ResponseEntity.ok().build();
    }
}
