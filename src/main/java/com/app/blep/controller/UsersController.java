package com.app.blep.controller;

import com.app.blep.model.Comments;
import com.app.blep.model.Users;
import com.app.blep.service.CommentsService;
import com.app.blep.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apk/Users")
public class UsersController {
    UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getCommentById(@PathVariable int id) {
        return usersService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Users addAUser(@PathVariable int userId, @PathVariable String userName,
                                @PathVariable String email, @PathVariable String passwordHash) {
        return usersService.addUser(userId, userName, email, passwordHash);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deleteUser(@PathVariable int userId) {
        return usersService.deleteUser(userId);
    }

    @PutMapping("{id}/update")
    public Users updateComment(@PathVariable int userId, @PathVariable String userName,
                               @PathVariable String email, @PathVariable String passwordHash) {
        return usersService.updateUser(userId, userName, email, passwordHash);
    }
}
