package com.springboot.securityprac.security.configuration;

import com.springboot.securityprac.security.service.InMemoryUserDetailsService;
import com.springboot.securityprac.security.user.CustomGrantedAuthority;
import com.springboot.securityprac.security.user.CustomUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class SecurityConfiguration {
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);



        CustomUser customUser = new CustomUser("kimys","12341234",new CustomGrantedAuthority("read"));
        userDetailsManager.createUser(customUser);

        return userDetailsManager;

    }

    //스프링 시큐리티는 회원의 비밀번호 데이터를 암호화하여 저장하기 때문에
    // UserDetailsService를 사용할 때는 반드시 암호화를 담당할 PasswordEncoder를 지정해 주어야 합니다.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
