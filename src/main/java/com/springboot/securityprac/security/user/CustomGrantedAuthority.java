package com.springboot.securityprac.security.user;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
    private final String authority;

    public CustomGrantedAuthority (String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority(){
        return authority;
    }
}
