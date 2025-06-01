package com.app.blep.service;

import com.app.blep.repository.LikesRepo;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    private LikesRepo likesRepo;

    public LikesService(LikesRepo likesRepo) {
        this.likesRepo = likesRepo;
    }
}
