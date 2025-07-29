package com.capstone.capstone_design.domain.owner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    @Column(name = "owner_name", nullable = false)
    private String name;

    @Column(name = "owner_password", nullable = false)
    private String password;

    @Column(name = "owner_email", nullable = false, unique = true)
    private String email;
}
