package com.matheuscordeiro.carsanalytics.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brand_analytics")
@Getter
@Setter
@NoArgsConstructor
public class BrandAnalytics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String brand;

    private Long posts;
}
