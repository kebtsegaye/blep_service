package com.app.blep.service;

import com.app.blep.repository.PostsRepo;
import org.springframework.stereotype.Service;

@Service
public class PostsService {
    private PostsRepo postsRepo;

    public PostsService(PostsRepo postsRepo) {
        this.postsRepo = postsRepo;
    }
}
