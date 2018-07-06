package com.example.demo.entity;

import lombok.Data;
import java.sql.*;


@Data
public class User {

    private Integer id;
    private String username;
    private Boolean gender; //male 0,female 1;
    private Date birthday;
    private String address;
    private String email;
    private String community;
    private String org;
    private String passwd;

}
