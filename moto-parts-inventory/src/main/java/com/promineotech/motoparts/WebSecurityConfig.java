package com.promineotech.motoparts;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] WHITELIST = {
            "/v2/api-docs",
            "/v3/api-docs",
            "/**/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "**/swagger-ui.html",
            "/**/swagger-ui.html**",
            "/swagger-ui.html**",
            "/webjars/**"
    };

    @Configuration
    @Order(2)
    public static class SwaggerSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers(WHITELIST).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic();
            ;
            http.csrf().disable();
        }
    }
}


