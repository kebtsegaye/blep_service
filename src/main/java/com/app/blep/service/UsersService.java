package com.app.blep.service;

import com.app.blep.repository.UsersRepo;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private UsersRepo usersRepo;

    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }
}
