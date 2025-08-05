package com.capstone.capstone_design.domain.restaurant.controller;

import com.capstone.capstone_design.domain.restaurant.dto.RestaurantDetailResponseDto;
import com.capstone.capstone_design.domain.restaurant.dto.RestaurantListResponseDto;
import com.capstone.capstone_design.domain.restaurant.service.RestaurantService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    //식당 목록 조회
    @GetMapping
    public ResponseEntity<List<RestaurantListResponseDto>> getRestaurantList() {
        List<RestaurantListResponseDto> restaurantList = restaurantService.getRestaurantList();
        return ResponseEntity.ok(restaurantList);
    }

    //특정 식당 상세 조회
    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDetailResponseDto> getRestaurantDetails(
        @PathVariable Long restaurantId){
        RestaurantDetailResponseDto responseDto = restaurantService.getRestaurantDetails(restaurantId);
        return ResponseEntity.ok(responseDto);
    }
}
