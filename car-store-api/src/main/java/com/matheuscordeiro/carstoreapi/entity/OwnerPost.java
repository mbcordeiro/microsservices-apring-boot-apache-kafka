package com.matheuscordeiro.carstoreapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "owner_post")
@Getter
@Setter
@NoArgsConstructor
public class OwnerPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String type;

    private String contactNumber;
}