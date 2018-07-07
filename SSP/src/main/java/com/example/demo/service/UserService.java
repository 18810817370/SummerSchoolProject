package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUser();

    boolean insert(User user);

    User findUser(String email,String passwd);

    User getUserbyEmail(String email);
}