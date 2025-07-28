package com.capstone.capstone_design.service.restaurant;

import com.capstone.capstone_design.domain.restaurant.model.Restaurant;
import com.capstone.capstone_design.dto.restaurant.RestaurantListResponse;
import com.capstone.capstone_design.repository.restaurant.RestaurantRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;


    // 식당 목록 조회
    @Transactional(readOnly = true)
    public List<RestaurantListResponse> getRestaurantList() {

        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants.stream()
            .map(restaurant -> new RestaurantListResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress()))
            .collect(Collectors.toList());
    }
}
