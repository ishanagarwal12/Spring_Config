package com.example.UserDetails.Entity;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity,Long> {


//    UserEntity findByUid(String uid);
    UserEntity findByEmail(String email);
}
