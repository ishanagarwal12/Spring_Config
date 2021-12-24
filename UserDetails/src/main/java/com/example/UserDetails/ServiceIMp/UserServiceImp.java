package com.example.UserDetails.ServiceIMp;

import com.example.UserDetails.Entity.UserEntity;
import com.example.UserDetails.Shared.DTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceImp extends UserDetailsService {
    DTO createUser(DTO userDTO);

//    UserEntity findByuID(String uid);

    DTO getUserDetailsByEmail(String email);


//    DTO getUserDetailsByEmail(String username);
}
