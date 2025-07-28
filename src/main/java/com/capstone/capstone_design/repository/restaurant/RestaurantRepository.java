package com.capstone.capstone_design.repository.restaurant;

import com.capstone.capstone_design.domain.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
