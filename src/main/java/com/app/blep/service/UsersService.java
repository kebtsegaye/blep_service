package com.app.blep.service;

import aj.org.objectweb.asm.commons.Remapper;
import com.app.blep.model.Posts;
import com.app.blep.model.Users;
import com.app.blep.repository.UsersRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepo usersRepo;

    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public boolean deleteUser(int userId) {
        boolean userIsDeleted = true;
        usersRepo.deleteById((long) userId);
        if (usersRepo.existsById((long) userId)) {
            userIsDeleted = false;
        }
        return userIsDeleted;
    }

    public Users updateUser(int userId, String userName, String email, String passwordHash) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Users user = usersRepo.findById((long) userId).orElseThrow(() -> new RuntimeException("Comment can"
                + " not be updated"));
        user.setUsername(userName);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        user.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        usersRepo.save(user);

        return user;
    }

    public Users addUser(String userName, String email, String passwordHash) {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Users user = new Users();
        user.setUsername(userName);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        user.setCreated_at(Timestamp.valueOf(localTime.format(formatter)));

        usersRepo.save(user);

        return user;
    }

    public Users signUpUser(String username, String password) {
        Users user = new Users();
        user.setUsername(username);
        user.setPasswordHash(password);
        return user;
    }

    public Optional<Users> getUserById(int id) {
        return usersRepo.findById((long) id);
    }

    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    public Optional<Users> findUserByName(String username) {
        return usersRepo.findByUsername(username);
    }
}
