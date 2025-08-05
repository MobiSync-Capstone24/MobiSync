package com.capstone.capstone_design.domain.dibs.controller;

import com.capstone.capstone_design.domain.dibs.service.DibsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dibs")
@RequiredArgsConstructor
public class DibsController {

    private final DibsService dibsService;

    @PostMapping("/restaurants/{restaurantId}")
    public ResponseEntity<Void> createDibs(@PathVariable Long restaurantId) {
        Long userId = 1L;

        dibsService.createDibs(userId, restaurantId);
        return ResponseEntity.ok().build();
    }
}
