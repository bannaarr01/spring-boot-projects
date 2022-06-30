package com.tbannaarr.com.roomwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //defines which routes u actually want to control : here (everytin)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//http.authorizeHttpRequests().antMatchers("/", "/api/*").permitAll()
        http.authorizeHttpRequests().antMatchers("/", "/api/rest/*").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login").permitAll()
        .and()
        .logout().permitAll();//we actually not going to implement logout
        //but gives an idea of what u need to do.
    }
    //Auto wire config
    @Autowired
    public void ConfigureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        //build auth (NoOp is deprecated Don't use in real system. for demo only
        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("user").password("password").roles("USER");
    }

}
