package com.app.blep.service;

import com.app.blep.model.Sessions;
import com.app.blep.repository.SessionsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionsService {
    private final SessionsRepo sessionsRepo;

    public SessionsService(SessionsRepo sessionsRepo) {
        this.sessionsRepo = sessionsRepo;
    }

    public List<Sessions> getSessions() {
        return sessionsRepo.findAll();
    }

    public Optional<Sessions> getSessionById(int id) {
        return sessionsRepo.findById((long) id);
    }
}
