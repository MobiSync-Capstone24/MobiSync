package com.capstone.capstone_design.domain.user.model;

import com.capstone.capstone_design.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users_taste")
public class UserTaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_taste_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "users_spicy")
    private BigDecimal spicy;

    @Column(name = "users_umami")
    private BigDecimal umami;

    @Column(name = "users_sour")
    private BigDecimal sour;

    @Column(name = "users_sweet")
    private BigDecimal sweet;

    @Column(name = "users_salty")
    private BigDecimal salty;

    @Column(name = "users_bitter")
    private BigDecimal bitter;
}