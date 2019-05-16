package com.khahux.springbootexamples.home.service.impl;

import com.khahux.springbootexamples.home.model.UserBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username:"+username);
        UserBean userBean = new UserBean();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(username.equals("admin")){

            userBean.setUserName(username);
            userBean.setPassword(new BCryptPasswordEncoder().encode("admin"));
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            grantedAuthorities.add(grantedAuthority);
            System.out.println(new User(userBean.getUserName(),
                    userBean.getPassword(),grantedAuthorities));
            return new User(userBean.getUserName(),
                    userBean.getPassword(),grantedAuthorities);
        }
        return null;
    }
}
