package com.capstone.capstone_design.domain.review.model;

import com.capstone.capstone_design.domain.review.model.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review_taste")
public class ReviewTaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_taste_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name = "review_spicy")
    private BigDecimal spicy;

    @Column(name = "review_umami")
    private BigDecimal umami;

    @Column(name = "review_sour")
    private BigDecimal sour;

    @Column(name = "review_sweet")
    private BigDecimal sweet;

    @Column(name = "review_salty")
    private BigDecimal salty;

    @Column(name = "review_bitter")
    private BigDecimal bitter;
}