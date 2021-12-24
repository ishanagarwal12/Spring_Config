package com.example.UserDetails.Security;

import com.example.UserDetails.Model.LoginRequestModel;
import com.example.UserDetails.Model.UserRequestModel;
import com.example.UserDetails.ServiceIMp.UserServiceImp;
import com.example.UserDetails.Shared.DTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserServiceImp us;
    @Autowired
    private Environment env;
    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthenticationFilter(UserServiceImp us, Environment env, AuthenticationManager authenticationManager){
        this.us=us;
        this.env=env;
        super.setAuthenticationManager(authenticationManager);
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)  {
        try{
            LoginRequestModel creds=new ObjectMapper().readValue(req.getInputStream(),LoginRequestModel.class);
            return getAuthenticationManager().authenticate
                    (new UsernamePasswordAuthenticationToken(creds.getEmail(),creds.getPassword(),new ArrayList<>()));

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException , ServletException {
        String username=((User)auth.getPrincipal()).getUsername();
       DTO ud= us.getUserDetailsByEmail(username);
        String token = Jwts.builder()
                .setSubject(ud.getUid())
                .setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(env.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret") )
                .compact();
        res.addHeader("token",token);
        res.addHeader("uid",ud.getUid());

    }
}
