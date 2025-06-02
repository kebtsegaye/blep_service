package com.app.blep.repository;

import com.app.blep.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<Posts, Long> {
}
