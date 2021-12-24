package com.example.User_OrderService.Entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<ListItems,Long> {

//    @Query(value="{itemName:'?0'}", fields="{'itemCode' : 1, 'quantity' : 1}")
//
//    List<OrderEntity> findAll(String itemName);
}
