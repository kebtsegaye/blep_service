package com.app.blep.service;

import com.app.blep.model.Comments;
import com.app.blep.repository.CommentsRepo;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    public Comments addComment(int userId, int postId, String commentContent) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Comments comment = new Comments();
        comment.setUser_id(userId);
        comment.setPost_id(postId);
        comment.setContent(commentContent);
        comment.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        commentsRepo.save(comment);

        return comment;
    }

    public boolean deleteComment(int commentId) {
//        Optional<Comments> commentToBeDeleted = commentsRepo.findById(Long.valueOf(commentId));
//        Comments deletedComment = commentsRepo.delete(commentToBeDeleted);
        boolean commentIsDeleted = true;
        commentsRepo.deleteById((long) commentId);
        if (commentsRepo.existsById((long) commentId)) {
            commentIsDeleted = false;
        }
        return commentIsDeleted;
    }

    public Comments updateComment(int commentId, int userId, int postId, String commentContent) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Comments comment = commentsRepo.findById((long) commentId).orElseThrow(() -> new RuntimeException("Comment can"
                + " not be updated"));
        comment.setUser_id(userId);
        comment.setPost_id(postId);
        comment.setContent(commentContent);
        comment.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        commentsRepo.save(comment);

        return comment;
    }
}
