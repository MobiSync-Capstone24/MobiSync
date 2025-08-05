package com.capstone.capstone_design.domain.dibs.repository;

import com.capstone.capstone_design.domain.dibs.model.Dibs;
import com.capstone.capstone_design.domain.restaurant.model.Restaurant;
import com.capstone.capstone_design.domain.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DibsRepository extends JpaRepository<Dibs, Long> {

    boolean existsByUsersAndRestaurant(Users users, Restaurant restaurant);
}
