package com.app.blep.controller;

import com.app.blep.model.Comments;
import com.app.blep.service.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }
    @GetMapping
    public List<Comments> getComments() {
        System.out.println("in getComments method for get reset command.");
        // commentsService.getAllComments().stream().map(Comments::toString).forEach(System.out::println);
        // System.out.println(commentsService.getAllComments().getFirst().getContent());
        return commentsService.getAllComments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> getCommentById(@PathVariable int id) {
        //.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        return commentsService.getCommentById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Comments postComment(@PathVariable int userId, @PathVariable int postId,
                                @PathVariable String commentContent) {
        return commentsService.addComment(userId, postId, commentContent);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deleteComment(@PathVariable int commentId) {
        return commentsService.deleteComment(commentId);
    }

    @PutMapping("{id}/update")
    public Comments updateComment(@PathVariable int commentId, @PathVariable int userId, @PathVariable int postId, @PathVariable String commentContent) {
        return commentsService.updateComment(commentId, userId, postId, commentContent);
    }
}
