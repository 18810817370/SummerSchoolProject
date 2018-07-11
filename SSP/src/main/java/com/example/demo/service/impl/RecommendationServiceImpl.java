package com.example.demo.service.impl;

import com.example.demo.dao.RecommendationDAO;
import com.example.demo.entity.Recommendation;
import com.example.demo.entity.User;
import com.example.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    RecommendationDAO recommendationDAO;

    @Override
    public List<Recommendation> getAllRecommendation(){
        return recommendationDAO.getAllRecommendation();
    }

    @Override
    public boolean insert(Recommendation recommendation,User user){
        if (recommendation == null){
            return false;
        }
        recommendationDAO.insert(recommendation,user);
        return true;
    }

}
