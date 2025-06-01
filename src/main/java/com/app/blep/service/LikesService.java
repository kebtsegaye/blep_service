package com.app.blep.service;

import com.app.blep.model.Followers;
import com.app.blep.model.Likes;
import com.app.blep.repository.LikesRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LikesService {
    private final LikesRepo likesRepo;

    public LikesService(LikesRepo likesRepo) {
        this.likesRepo = likesRepo;
    }

    public List<Likes> getAllLikes() {
        return likesRepo.findAll();
    }

    public Likes addLike(int userId, int postId) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Likes like = new Likes();
        like.setPost_id(userId);
        like.setUser_id(postId);
        like.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        likesRepo.save(like);

        return like;
    }

    public boolean removeLike(int likeID) {
        boolean likeIsDeleted = true;
        likesRepo.deleteById((long) likeID);
        if (likesRepo.existsById((long) likeID)) {
            likeIsDeleted = false;
        }
        return likeIsDeleted;
    }
}
