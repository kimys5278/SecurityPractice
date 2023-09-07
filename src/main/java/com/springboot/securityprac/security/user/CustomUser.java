package com.springboot.securityprac.security.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUser implements UserDetails {
    private final String username;
    private final String password;
    private  final GrantedAuthority authority;

    public CustomUser(String username, String password, GrantedAuthority authority){
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    //계정이 가지고 있는 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

        return authorities;
    }

    //계정의 패스워드를 리턴
    @Override
    public String getPassword(){
        return password;
    }

    //계정의 이름을 리턴
    @Override
    public String getUsername(){
        return username;
    }

    //계정이 만료되지 않았는지를 리턴(true를 리턴하면 만료되지 않음을 의미)
    @Override
    public  boolean isAccountNonExpired(){
        return true;
    }

    //계정이 잠겨있지 않은지를 리턴(true를 리턴하면 계정이 잠겨있지 않음을 의미)
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    //계정의 패스워드가 만료되지 않았는지를 리턴(true를 리턴하면 사용가능한 계정인지를 의미)
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    //계정이 사용가능한 계정인지를 리턴(true를 리턴하면 사용가능한 계정인지를 의미)
    @Override
    public boolean isEnabled() {
        return true;
    }
}

