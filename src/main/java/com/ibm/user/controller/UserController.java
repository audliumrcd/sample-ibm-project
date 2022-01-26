package com.ibm.user.controller;

import com.ibm.user.entity.User;
import com.ibm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {this.userService = userService; }

    @GetMapping("/create-sample")
    public User hello() {

        return userService.createUser(  "testusername", "testpassword", "firstName", "lastName");
    }

    @GetMapping("/read")
    public User getUser(@RequestParam String id) {

        return userService.getUser(user1);
    }

    /*@PostMapping("/create")
    public User createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable String id) {

        return userService.update(id,user );
    }*/

}
