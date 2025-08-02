package com.capstone.capstone_design.domain.coupon.model;

import com.capstone.capstone_design.domain.restaurant.model.Restaurant;
import com.capstone.capstone_design.domain.coupon.model.UserCoupon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_coupon_id")
    private UserCoupon userCoupon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "coupon_name")
    private String name;

    @Column(name = "coupon_code")
    private String code;

    @Column(name = "coupon_value")
    private Long value;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status")
    private CouponStatus status;

    @Column(name = "coupon_expired_at")
    private LocalDateTime expiredAt;

    @Column(name = "coupon_created_at")
    private LocalDateTime createdAt;
}