package com.app.blep.controller;

import com.app.blep.model.Posts;
import com.app.blep.service.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Posts")
public class PostsController {
    PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping
    public List<Posts> getAllPosts() {
        return postsService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostingById(@PathVariable int id) {
        return postsService.getPostingById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Posts postPosting(@PathVariable int userId, @PathVariable String commentContent) {
        return postsService.addPost(userId, commentContent);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deletePosting(@PathVariable int postId) {
        return postsService.deletePost(postId);
    }

    @PutMapping("{id}/update")
    public Posts updatePosting(@PathVariable int postId, @PathVariable int userId, @PathVariable String postContent) {
        return postsService.updatePost(userId, postId, postContent);
    }
}
