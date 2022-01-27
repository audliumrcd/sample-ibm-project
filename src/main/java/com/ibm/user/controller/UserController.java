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

    @PostMapping("/create-sample")
    public User hello(@RequestParam String username, @RequestParam String password,
                      @RequestParam String firstName, @RequestParam String lastName) {

        return userService.createUser(username, password, firstName, lastName);
    }

    @GetMapping("/read")
    public User getUser(@RequestParam String firstName) {

        return userService.getUser(firstName);
    }

    /*@PostMapping("/create")
    public User createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return userService.createUser(user);
    }*/

    @PutMapping("/update/")
    public User updateUser(@RequestParam String newFirstName,
                           @RequestParam String newLastName) {

        return userService.updateUser(newFirstName, newLastName);
    }

    @DeleteMapping("/delete")
    public User deleteUser(@RequestParam String firstName) {

        return userService.deleteUser(firstName);
    }
}
