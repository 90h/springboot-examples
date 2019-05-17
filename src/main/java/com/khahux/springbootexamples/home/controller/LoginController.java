package com.khahux.springbootexamples.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.net.URLDecoder;
/*
 *@Author zhangwenyu
 *@Description //登录页控制类
 *@Date 2019/5/17 15:27
 *@Param 
 *@return 
 **/
@Controller
@RequestMapping("/")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserDetailsService userDetailsService;

    private UserDetails userDetails;
    //    @GetMapping({"/", "/hello"})
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
    /*
     *登录页
     */
    @RequestMapping("/")
    public String login(){
        String loginUrl = "/home/index";
        return loginUrl;
    }

    /*
     *错误页
     */
    @RequestMapping("/403")
    public String error(){
        String errorUrl = "/home/error";
        return errorUrl;
    }

    /*
     *用户登录校验
     */
    @RequestMapping(value = "/loginPost")
    public String loginPost(@RequestParam String params) throws Exception{
        params = URLDecoder.decode(params,"UTF-8");
        userDetails = userDetailsService.loadUserByUsername("admin");
        if(userDetails != null){
            logger.info("----pwd:"+ new BCryptPasswordEncoder().matches("admin",userDetails.getPassword()));

            return "/home/login";
        }
        return "/home/error";
    }
}
