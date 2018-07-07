package com.example.demo.service.impl;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.dao.UserDAO;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findUser(String email,String passwd){
        return  userDAO.findUser(email,passwd);
    }

    @Override
    public User getUserbyEmail(String email){
        return userDAO.getUserbyEmail(email);
    }

    @Override
    public List<User> getAllUser(){
        return userDAO.getAllUser();
    }

    @Override
    public boolean insert(User user){
        if( null == user){
            return false;
        }
        userDAO.insert(user);
        return true;
    }

}
