package com.ibm.user.service;

import com.ibm.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class UserService {

    private HashMap<String, String> hashMap = new HashMap<>();

    public User createUser( String username, String password, String firstName, String lastName) {
        Random random = new Random();
        int id = random.nextInt();
        User user = new User(id,username, password, firstName, lastName);
        hashMap.put("id", String.valueOf(id));
        hashMap.put("username", username);
        hashMap.put("password", password);
        hashMap.put("firstName", firstName);
        hashMap.put("lastName", lastName);
//        User user = hashMap.get(id);
        return user;
    }

    public User getUser(String firstName) {
        User user = new User();
        user.setId(Integer.parseInt(hashMap.get("id")));
        user.setUsername(hashMap.get("username"));
        user.setFirstName(hashMap.get("firstName"));
        user.setLastName(hashMap.get("lastName"));
        user.setPassword(hashMap.get("password"));
        user.setHashMap(hashMap);
        return user;
    }
//    SELECT * FROM USERS WHERE firstName = '';
    public User updateUser(String newFirstName, String newLastName) {
        User user = new User();
        hashMap.replace("firstName", newFirstName);
        hashMap.replace("lastName", newLastName);

        user.setId(Integer.parseInt(hashMap.get("id")));
        user.setUsername(hashMap.get("username"));
        user.setFirstName(hashMap.get("firstName"));
        user.setLastName(hashMap.get("lastName"));
        user.setPassword(hashMap.get("password"));
        user.setHashMap(hashMap);
        return user;
    }
    public User deleteUser(String firstName) {
        User user = new User();

        hashMap.put("id", null);
        hashMap.put("username", null);
        hashMap.put("password", null);
        hashMap.put("firstName", null);
        hashMap.put("lastName",null);

        System.out.println(hashMap.get("id") == null);

        user.setId(0);
        user.setUsername(hashMap.get("username"));
        user.setFirstName(hashMap.get("firstName"));
        user.setLastName(hashMap.get("lastName"));
        user.setPassword(hashMap.get("password"));
        return user;
    }


}
