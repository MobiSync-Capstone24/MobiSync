// User.java
package com.capstone.capstone_design.domain.user.model;

import com.capstone.capstone_design.domain.dibs.model.Dibs;
import com.capstone.capstone_design.domain.order.model.Order;
import com.capstone.capstone_design.domain.review.model.Review;
import com.capstone.capstone_design.domain.user.model.UserTaste;
import com.capstone.capstone_design.domain.coupon.model.UserCoupon;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    @Column(name = "users_name")
    private String name;

    private String password;
    private String email;
    private String nickname;
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private UserTaste userTaste;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Dibs> dibsList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<UserCoupon> userCoupons = new ArrayList<>();

}