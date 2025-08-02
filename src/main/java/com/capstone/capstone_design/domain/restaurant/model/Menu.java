package com.capstone.capstone_design.domain.restaurant.model;

import com.capstone.capstone_design.domain.order.model.OrderMenu;
import com.capstone.capstone_design.domain.restaurant.model.Restaurant;
import com.capstone.capstone_design.domain.review.model.Review;
import com.capstone.capstone_design.domain.restaurant.model.MenuTaste;
import com.capstone.capstone_design.domain.owner.model.Owner;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "menu")
public class Menu {
    @Id
    @Column(name = "menu_id")
    private String id;

    @Column(name = "menu_name")
    private String name;

    @Column(name = "menu_price")
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<OrderMenu> orderMenus = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToOne(mappedBy = "menu", cascade = CascadeType.ALL)
    private MenuTaste menuTaste;
}