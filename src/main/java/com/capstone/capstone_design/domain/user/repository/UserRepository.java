package com.capstone.capstone_design.domain.user.repository;

import com.capstone.capstone_design.domain.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    //Optional<Users> findByEmail(String email);

    @Query("SELECT u FROM Users u LEFT JOIN FETCH u.userTaste WHERE u.email = :email")
    Optional<Users> findByEmailWithTaste(@Param("email") String email);
}
