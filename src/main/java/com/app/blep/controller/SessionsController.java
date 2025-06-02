package com.app.blep.controller;

import com.app.blep.model.Sessions;
import com.app.blep.service.SessionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Sessions")
public class SessionsController {
    SessionsService sessionsService;

    public SessionsController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @GetMapping
    public List<Sessions> getAllSessions() {
        return sessionsService.getSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sessions> getSessionById(@PathVariable int id) {
        return sessionsService.getSessionById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public Comments postComment(@PathVariable int userId, @PathVariable int postId,
//                                @PathVariable String commentContent) {
//        return commentsService.addComment(userId, postId, commentContent);
//    }

//    @DeleteMapping("/{id}/delete")
//    public boolean deleteComment(@PathVariable int commentId) {
//        return commentsService.deleteComment(commentId);
//    }

//    @PutMapping("{id}/update")
//    public Comments updateComment(@PathVariable int commentId, @PathVariable int userId, @PathVariable int postId, @PathVariable String commentContent) {
//        return commentsService.updateComment(commentId, userId, postId, commentContent);
//    }
}
