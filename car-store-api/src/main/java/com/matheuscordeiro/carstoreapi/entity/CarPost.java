package com.matheuscordeiro.carstoreapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "car_post")
@Getter
@Setter
@NoArgsConstructor
public class CarPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String model;

    private String brand;

    private BigDecimal price;

    private String description;

    private String engineVersion;

    private String city;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private String contact;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_post_id", nullable = false, referencedColumnName = "id")
    private OwnerPost ownerPost;
}
