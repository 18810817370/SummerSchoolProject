package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUser();

    List<User> getNonVipUser();

    boolean insert(User user);
	
	boolean update(User user);

    boolean givevip(User user);

    boolean delete(User user);

    User findUser(String email,String passwd);

    User getUserbyEmail(String email);

}
