package com.app.blep.controller;

import com.app.blep.model.Likes;
import com.app.blep.service.LikesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LikesController {
    LikesService likesService;

    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }
    @GetMapping
    public List<Likes> getLikes() {
        return likesService.getAllLikes();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Likes> getFollowerById(@PathVariable int id) {
//        return likesService.getLikeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

    @PostMapping
    public Likes postLike(@PathVariable int userId, @PathVariable int postId) {
        return likesService.addLike(userId, postId);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deleteLike(@PathVariable int followerId) {
        return likesService.removeLike(followerId);
    }

//    @PutMapping("{id}/update")
//    public Likes removeLike(@PathVariable int followerId, @PathVariable int followingId) {
//        return likesService.updateLike(followerId, followingId);
//    }
}
