package com.capstone.capstone_design.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestaurantListResponse {
    private Long restaurantId;
    private String restaurantName;
    private String restaurantAddress;

}
