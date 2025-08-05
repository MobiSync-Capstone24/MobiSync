package com.capstone.capstone_design.domain.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantListResponseDto {
    private Long restaurantId;
    private String restaurantName;
    private String restaurantAddress;

}
