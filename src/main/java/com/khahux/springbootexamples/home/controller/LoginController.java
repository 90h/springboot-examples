package com.khahux.springbootexamples.home.controller;

import com.khahux.springbootexamples.home.model.UserBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    private UserDetailsService userDetailsService;
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
    @RequestMapping(value = "/loginPost",method = {RequestMethod.GET,RequestMethod.POST})
    public String loginPost(@RequestBody String params, HttpServletRequest request ){
        String account = "";

        try {
            params = URLDecoder.decode(params,"UTF-8");
            System.out.println("params:"+params);

            System.out.println("------"+userDetailsService.loadUserByUsername("admin"));

            if(userDetailsService.loadUserByUsername("admin") != null){

                System.out.println("test");

                return "/home/login";
            }
        }catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }
        return "/home/error";
    }


}
