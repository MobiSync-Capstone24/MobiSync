package com.capstone.capstone_design.domain.user.model;

<<<<<<< HEAD
=======
import com.capstone.capstone_design.domain.user.model.User;
>>>>>>> e70374ad7c8544967a036f57a7e850562a3f66e8
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
import lombok.Setter;
=======
>>>>>>> e70374ad7c8544967a036f57a7e850562a3f66e8

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

<<<<<<< HEAD
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;
=======
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;
>>>>>>> e70374ad7c8544967a036f57a7e850562a3f66e8

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
<<<<<<< HEAD

=======
>>>>>>> e70374ad7c8544967a036f57a7e850562a3f66e8
}