package com.app.blep.repository;

import com.app.blep.model.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionsRepo extends JpaRepository<Sessions, Long> {
}
