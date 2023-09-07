package com.springboot.securityprac.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {
    public final List<UserDetails> users;

    public InMemoryUserDetailsService(List<UserDetails> users){
        this.users = users;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found Exception"));
    }
/* 스트림 연산이 익숙치 않으면, 이렇게 코딩해도 됨.
* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        for (UserDetails user : users) {
            if (user.getUsername().equals(username)) return user;
        }

        throw new UsernameNotFoundException("User not found Exception");
    }
* */

}
