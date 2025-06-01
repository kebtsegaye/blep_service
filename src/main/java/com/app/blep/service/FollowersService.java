package com.app.blep.service;

import com.app.blep.model.Followers;
import com.app.blep.repository.FollowersRepo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class FollowersService {
    private final FollowersRepo followersRepo;

    public FollowersService(FollowersRepo followersRepo) {
        this.followersRepo = followersRepo;
    }

    public List<Followers> getAllFollowers() {
        return followersRepo.findAll();
    }

    public Optional<Followers> getFollowerById(int id) {
        return followersRepo.findById((long) id);
    }

    public Followers addFollower(int followingId, int followerId) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Followers follower = new Followers();
        follower.setFollowers_id(followerId);
        follower.setFollowing_id(followingId);
        follower.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        followersRepo.save(follower);

        return follower;
    }

    public boolean removeFollower(int commentId) {
        boolean followerIsDeleted = true;
        followersRepo.deleteById((long) commentId);
        if (followersRepo.existsById((long) commentId)) {
            followerIsDeleted = false;
        }
        return followerIsDeleted;
    }

    public Followers updateFollower(int followerId, int followingId) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Followers follower = followersRepo.findById((long) followingId).orElseThrow(() -> new RuntimeException("Comment can"
                + " not be updated"));
        follower.setFollowers_id(followerId);
        follower.setFollowing_id(followingId);
        follower.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        followersRepo.save(follower);

        return follower;
    }
}