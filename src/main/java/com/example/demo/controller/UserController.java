package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // @GetMapping("nim/{nim}")
    // public ResponseEntity<User> getUserByNim(@PathVariable String nim) {
    //     User user = userService.getUserByNim(nim);
    //     if (user != null) {
    //         return ResponseEntity.ok(user);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nim/{nim}")
    public ResponseEntity<User> getUserByNim(@PathVariable String nim) {
        User user = userService.getUserByNim(nim);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @GetMapping("query")
    // public ResponseEntity<User> getUserByQuery(@RequestParam String id) {
    // User user = userService.getUserByQuery(id);
    // if (user != null) {
    // return new ResponseEntity<>(user, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }
}
