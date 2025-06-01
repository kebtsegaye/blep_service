package com.app.blep.service;

import com.app.blep.model.Comments;
import com.app.blep.repository.CommentsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    private final CommentsRepo commentsRepo;

    public CommentsService(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }


    public List<Comments> getAllComments() {
        return commentsRepo.findAll();
    }

    public Optional<Comments> getCommentById(int id) {
        return commentsRepo.findById((long)id);
    }
}
