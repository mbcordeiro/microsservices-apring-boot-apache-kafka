package com.matheuscordeiro.carsanalytics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car_model")
@Getter
@Setter
@NoArgsConstructor
public class CarModelPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String model;

    private BigDecimal price;

}
