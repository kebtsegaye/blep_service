package com.app.blep.repository;

import com.app.blep.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepo extends JpaRepository<Likes, Long> {
}
