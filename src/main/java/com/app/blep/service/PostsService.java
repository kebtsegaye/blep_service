package com.app.blep.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.app.blep.model.Comments;
import com.app.blep.model.Posts;
import com.app.blep.repository.PostsRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService {
    private final PostsRepo postsRepo;

    public PostsService(PostsRepo postsRepo) {
        this.postsRepo = postsRepo;
    }

    public List<Posts> getAllPosts() {
        return postsRepo.findAll();
    }

    public Optional<Posts> getPostingById(int id) {
        return postsRepo.findById((long)id);
    }

    public Posts addPost(int userId, String commentContent) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Posts post = new Posts();
        post.setUser_id(userId);
        post.setContent(commentContent);
        post.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        postsRepo.save(post);

        return post;
    }

    public boolean deletePost(int postId) {
        boolean postIsDeleted = true;
        postsRepo.deleteById((long) postId);
        if (postsRepo.existsById((long) postId)) {
            postIsDeleted = false;
        }
        return postIsDeleted;
    }

    public Posts updatePost(int userId, int postId, String postContent) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Posts post = postsRepo.findById((long) postId).orElseThrow(() -> new RuntimeException("Comment can"
                + " not be updated"));
        post.setUser_id(userId);
        post.setContent(postContent);
        post.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        postsRepo.save(post);

        return post;
    }
}
