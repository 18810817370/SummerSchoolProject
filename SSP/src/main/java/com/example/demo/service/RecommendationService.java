package com.example.demo.service;


import com.example.demo.entity.Recommendation;
import com.example.demo.entity.User;

import java.util.List;

public interface RecommendationService {

    List<Recommendation> getAllRecommendation();

    boolean insert(Recommendation recommendation,User user);

}
