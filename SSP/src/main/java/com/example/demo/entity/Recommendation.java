package com.example.demo.entity;


import lombok.Data;

@Data
public class Recommendation {

    private Integer id;
    private String author;
    private String target;
    private String content;

}
