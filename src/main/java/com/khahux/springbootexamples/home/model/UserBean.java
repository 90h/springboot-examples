package com.khahux.springbootexamples.home.model;

import lombok.*;
/*
 *@Author zhangwenyu
 *@Description //用户信息
 *@Date 2019/5/17 15:28
 *@Param
 *@return
 **/
@Data
public class UserBean {

    private String userName;
    private String password;
    private long phoneNum;
    private String email;

}
