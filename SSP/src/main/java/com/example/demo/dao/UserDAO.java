package com.example.demo.dao;

import com.example.demo.entity.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDAO {

    @Select(value = "SELECT * FROM user")
    List<User> getAllUser();

    @Insert(value = "INSERT INTO user (user.`username`,user.gender,user.`birthday`,user.`address`,user.`email`,user.`community`,user.`org`,user.`passwd` )\n" +
            "VALUE(#{username},#{gender},#{birthday},#{address},#{email},#{community},#{org},#{passwd})")
    int insert(User user);

    @Select(value = "SELECT * FROM user WHERE user.email= #{email}")
    User getUserbyEmail(@Param("email") String  email);

    @Select(value = "SELECT * FROM user WHERE user.email = #{email} AND user.passwd = #{passwd}")
    User findUser(@Param("email") String email, @Param("passwd") String passwd);
}


