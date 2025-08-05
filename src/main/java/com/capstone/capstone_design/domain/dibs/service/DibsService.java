package com.capstone.capstone_design.domain.dibs.service;

import com.capstone.capstone_design.domain.dibs.model.Dibs;
import com.capstone.capstone_design.domain.dibs.repository.DibsRepository;
import com.capstone.capstone_design.domain.restaurant.model.Restaurant;
import com.capstone.capstone_design.domain.restaurant.repository.RestaurantRepository;

import java.util.NoSuchElementException;

import com.capstone.capstone_design.domain.user.model.Users;
import com.capstone.capstone_design.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DibsService {

    private final DibsRepository dibsRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void createDibs(Long userId, Long restaurantId) throws IllegalAccessException {
        Users user = userRepository.findById(userId)
            .orElseThrow(() -> new NoSuchElementException("해당 유저를 찾을 수 없습니다."));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
            .orElseThrow(() -> new NoSuchElementException("해당 식당을 찾을 수 없습니다."));

        if (dibsRepository.existsByUsersAndRestaurant(user, restaurant)) {
            throw new IllegalAccessException("이미 찜한 식당입니다.");
        }

        Dibs newDibs = new Dibs(user, restaurant);

        dibsRepository.save(newDibs);

    }
}
