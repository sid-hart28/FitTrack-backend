package com.siddharth.FitTrack.controller;

import com.siddharth.FitTrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/create")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        System.out.println("In UserController(addUser)");
//        User createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
}
