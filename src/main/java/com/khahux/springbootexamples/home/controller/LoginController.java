package com.khahux.springbootexamples.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/")
public class LoginController {
//    @GetMapping({"/", "/hello"})
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
    /*
     *登录页
     */
    @RequestMapping("/index")
    public String login(){
        String loginUrl = "/home/index";
        return loginUrl;
    }

    /*
     *用户登录校验
     */
    @RequestMapping(value = "/loginPost",method = {RequestMethod.GET,RequestMethod.POST})
    public String loginPost(@RequestBody String params, HttpServletRequest request ){
        String account = "";

        try {
            params = URLDecoder.decode(params,"UTF-8");
            System.out.println("params:"+params);
        }catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }

        return "/home/login";
    }
}
