package com.app.blep.controller;

import com.app.blep.model.Followers;
import com.app.blep.service.FollowersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class FollowersController {
    FollowersService followersService;

    public FollowersController(FollowersService followersService) {
        this.followersService = followersService;
    }
    @GetMapping
    public List<Followers> getFollowers() {
        return followersService.getAllFollowers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Followers> getFollowerById(@PathVariable int id) {
        return followersService.getFollowerById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Followers postFollower(@PathVariable int followerId, @PathVariable int followingId) {
        return followersService.addFollower(followerId, followingId);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deleteFollower(@PathVariable int followerId) {
        return followersService.removeFollower(followerId);
    }

    @PutMapping("{id}/update")
    public Followers removeFollower(@PathVariable int followerId, @PathVariable int followingId) {
        return followersService.updateFollower(followerId, followingId);
    }
}
