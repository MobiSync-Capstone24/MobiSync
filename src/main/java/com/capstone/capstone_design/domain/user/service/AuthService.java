package com.capstone.capstone_design.domain.user.service;

import com.capstone.capstone_design.domain.user.dto.UsersDto;
import com.capstone.capstone_design.domain.user.model.UserTaste;
import com.capstone.capstone_design.domain.user.model.Users;
import com.capstone.capstone_design.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<?> signup(@RequestBody Users users) {
        Optional<Users> existingUser = userRepository.findByEmailWithTaste(users.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        UserTaste taste = users.getUserTaste();

        if (taste != null) {
            taste.setUsers(users);
        }

        Users savedUser = userRepository.save(users);
        UsersDto usersDto = UsersDto.fromEntity(savedUser);

        return ResponseEntity.ok().body(usersDto);
    }

    @Transactional
    public ResponseEntity<?> login(@RequestBody Users users) {
        Optional<Users> optionalUser = userRepository.findByEmailWithTaste(users.getEmail());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User doesn't exist");
        }

        Users user = optionalUser.get();

        UserTaste taste = users.getUserTaste();

        if (taste != null) {
            taste.setUsers(users);
        }

        UsersDto usersDto = UsersDto.fromEntity(user);

        // JWT 후에 추가 예정, 테스트 환경 개발
        if(!optionalUser.get().getPassword().equals(users.getPassword())) {
            return ResponseEntity.badRequest().body("Wrong password");
        }

        return ResponseEntity.ok(usersDto);
    }
}
