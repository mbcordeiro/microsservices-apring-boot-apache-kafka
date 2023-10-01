package com.matheuscordeiro.carstoreapi.repository;

import com.matheuscordeiro.carstoreapi.entity.CarPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {
}