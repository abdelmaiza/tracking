package com.cirta.soft.tracking.actuator.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ActuatorSecurity extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatcher(EndpointRequest.toAnyEndpoint())
//                .authorizeRequests().antMatchers().hasRole("ADMIN");
//        http.httpBasic();
//    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/actuator/**").hasRole("ACTUATOR")
//                .antMatchers("/").permitAll();


        httpSecurity
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/actuator/**").hasRole("ACTUATOR");
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
}
