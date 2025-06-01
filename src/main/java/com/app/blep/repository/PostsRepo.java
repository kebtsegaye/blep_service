package com.app.blep.repository;

import com.app.blep.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<Comments, Long> {
}
