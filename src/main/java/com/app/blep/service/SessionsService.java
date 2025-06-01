package com.app.blep.service;

import com.app.blep.repository.SessionsRepo;
import org.springframework.stereotype.Service;

@Service
public class SessionsService {
    private SessionsRepo sessionsRepo;

    public SessionsService(SessionsRepo sessionsRepo) {
        this.sessionsRepo = sessionsRepo;
    }
}
