package com.khahux.springbootexamples.home.model;

import lombok.*;

@Data
public class UserBean {

    @NonNull
    private String userName;
    @NonNull
    private String password;
    private long phoneNum;
    private String email;

}
