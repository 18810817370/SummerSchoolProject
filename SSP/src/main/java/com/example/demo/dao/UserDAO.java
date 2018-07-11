package com.example.demo.dao;

import com.example.demo.entity.User;

import org.apache.ibatis.annotations.*;

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

    @Select(value = "SELECT * FROM user WHERE user.email = #{email} AND user.passwd = #{passwd} AND user.vip = 'YES'")
    User findUser(@Param("email") String email, @Param("passwd") String passwd);

    @Select(value = "SELECT * FROM user WHERE user.vip = 'NO'")
    List<User> getNonVipUser();

	@Delete(value = "DELETE from user WHERE user.id = #{id}")
    int delete(User user);

    @Update(value = "UPDATE user SET user.username = #{username}，user.gender = #{gender},user.birthday = #{birthday},user.address = #{address},user.email = #{email},user.community = #{community},user.org = #{org},user.passwd = #{passwd} WHERE user.id = #{id}")
    int update(User user);

    @Update(value = "UPDATE user SET user.vip = 'YES' WHERE user.id = #{id}")
    int givevip(User user);
}


