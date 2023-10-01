package com.matheuscordeiro.carstoreapi.service;

import com.matheuscordeiro.carstoreapi.dto.OwnerPostDto;
import com.matheuscordeiro.carstoreapi.entity.OwnerPost;
import com.matheuscordeiro.carstoreapi.repository.OwnerPostRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {
    private final OwnerPostRepository ownerPostRepository;

    public OwnerPostServiceImpl(OwnerPostRepository ownerPostRepository) {
        this.ownerPostRepository = ownerPostRepository;
    }

    @Override
    public void createOwnerPost(OwnerPostDto ownerPostDto) {
        final var ownerPost = new OwnerPost();
        ownerPost.setName(ownerPostDto.name());
        ownerPost.setType(ownerPostDto.type());
        ownerPost.setContact(ownerPostDto.contact());
        ownerPostRepository.save(ownerPost);
    }
}
