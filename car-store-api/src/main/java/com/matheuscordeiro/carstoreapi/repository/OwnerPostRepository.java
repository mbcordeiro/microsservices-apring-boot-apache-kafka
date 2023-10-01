package com.matheuscordeiro.carstoreapi.repository;

import com.matheuscordeiro.carstoreapi.entity.OwnerPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerPostRepository extends JpaRepository<OwnerPost, Long> {
}