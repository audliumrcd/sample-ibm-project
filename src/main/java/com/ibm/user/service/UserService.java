package com.ibm.user.service;

import com.ibm.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class UserService {

    private final HashMap<Long, User> hashMap = new HashMap<>();

    public void createUser( String username, String password, String firstName, String lastName) {
        Random random = new Random();
        Long id = random.nextLong();
        User user = new User(id,username, password, firstName, lastName);
        hashMap.put(id, user);
        User user1 = hashMap.get(id);
    }

    public User getUser(String id) {


        User user = hashMap.get(id);

        return user;
    }




}
