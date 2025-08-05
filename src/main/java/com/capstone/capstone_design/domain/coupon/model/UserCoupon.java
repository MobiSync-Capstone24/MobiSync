package com.capstone.capstone_design.domain.coupon.model;

<<<<<<< HEAD
import com.capstone.capstone_design.domain.user.model.Users;
=======
import com.capstone.capstone_design.domain.user.model.User;
>>>>>>> e70374ad7c8544967a036f57a7e850562a3f66e8
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users_coupon")
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_coupon_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")

    private Users users;

    private User user;

    @Column(name = "coupon_used")
    private Boolean used;

    @Column(name = "coupon_used_at")
    private LocalDateTime usedAt;

    @Column(name = "coupon_issue_date")
    private LocalDateTime issueDate;

    @OneToMany(mappedBy = "userCoupon", cascade = CascadeType.ALL)
    private List<Coupon> coupons = new ArrayList<>();
}