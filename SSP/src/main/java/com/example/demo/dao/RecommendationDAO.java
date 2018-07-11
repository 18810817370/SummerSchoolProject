package com.example.demo.dao;

import com.example.demo.entity.Recommendation;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface RecommendationDAO {

    @Select(value = "SELECT * FROM recommendation")
    List<Recommendation> getAllRecommendation();

    @Insert(value = "INSERT INTO recommendation (recommendation.`author`,recommendation.`target`,recommendation.`content`) VALUE (#{User.username},#{Recommendation.target},#{Recommendation.content})")
    int insert(@Param("Recommendation") Recommendation recommendation, @Param("User") User user);

}
