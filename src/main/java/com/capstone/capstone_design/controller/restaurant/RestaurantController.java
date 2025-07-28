package com.capstone.capstone_design.controller.restaurant;

import com.capstone.capstone_design.dto.restaurant.RestaurantListResponse;
import com.capstone.capstone_design.service.restaurant.RestaurantService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/restaurants") // 일단 임시로 /v1/경로 넣어놨음 걍 없앨까
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    //식당 목록 조회
    @GetMapping
    public ResponseEntity<List<RestaurantListResponse>> getRestaurantList() {
        List<RestaurantListResponse> restaurantList = restaurantService.getRestaurantList();
        return ResponseEntity.ok(restaurantList);
    }
}
