package com.example.UserDetails.Security;

import com.example.UserDetails.ServiceIMp.UserServiceImp;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
public class webSecurity extends WebSecurityConfigurerAdapter {

@Autowired
    private   Environment env;
@Autowired
private UserServiceImp us;
@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public webSecurity(Environment env, UserServiceImp us,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.env = env;
        this.us = us;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**").permitAll()
                .and()
                .addFilter(getAuthenticationFilter());
        http.headers().frameOptions().disable();

    }
    private AuthenticationFilter getAuthenticationFilter() throws Exception{
        AuthenticationFilter authenticationFilter=new AuthenticationFilter(us,env,authenticationManager());
//        authenticationFilter.setAuthenticationManager(authenticationManager());
        authenticationFilter.setFilterProcessesUrl(env.getProperty("login.url.path"));
        return authenticationFilter;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth )throws Exception{
        auth.userDetailsService(us).passwordEncoder(bCryptPasswordEncoder);
    }
}
