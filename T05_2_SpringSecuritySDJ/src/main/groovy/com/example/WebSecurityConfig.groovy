package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService

/**
 * Created by luis on 10/7/15.
 */
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService

    @Override
    protected void configure(HttpSecurity http) {
        http.authorizeRequests().antMatchers('/').permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
                .loginPage('/login').permitAll()
                .and().logout().permitAll()
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.userDetailsService(userDetailsService)
    }
}
