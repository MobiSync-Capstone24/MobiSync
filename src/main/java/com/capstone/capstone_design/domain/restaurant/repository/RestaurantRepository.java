package com.capstone.capstone_design.domain.restaurant.repository;

import com.capstone.capstone_design.domain.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
