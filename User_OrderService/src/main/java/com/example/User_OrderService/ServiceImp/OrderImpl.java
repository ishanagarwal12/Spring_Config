package com.example.User_OrderService.ServiceImp;


import com.example.User_OrderService.Entity.FeedBack;
import com.example.User_OrderService.Entity.ListItems;
import com.example.User_OrderService.Entity.OrderEntity;
import com.example.User_OrderService.Model.CheckoutResponseModel;
import com.example.User_OrderService.Model.DTO;
import com.example.User_OrderService.Model.FeedBackRequestModel;
import com.example.User_OrderService.Model.OrderResponse;
import com.example.User_OrderService.Shared.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface OrderImpl {


    OrderEntity checkoutOrder(List<UserEntity> list,  DTO ud);


    String feedBackOrder(FeedBack ud, OrderEntity value);
}
