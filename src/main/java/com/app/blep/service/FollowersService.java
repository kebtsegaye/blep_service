package com.app.blep.service;

import com.app.blep.repository.FollowersRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
public class FollowersService {
    private FollowersRepo followersRepo;

    public FollowersService(FollowersRepo followersRepo) {
        this.followersRepo = followersRepo;
    }
}
