package com.example.demo.entity;

import lombok.Data;

import java.sql.*;

@Data
public class Proposal {
    private Integer ppid;
    private String author;
    private String ppname;
    private String ppcontent;
    private String status;
    private String vote;
    private String disvote;
}
