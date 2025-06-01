package com.app.blep.repository;

import com.app.blep.model.Followers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowersRepo extends JpaRepository<Followers, Long> {
}
