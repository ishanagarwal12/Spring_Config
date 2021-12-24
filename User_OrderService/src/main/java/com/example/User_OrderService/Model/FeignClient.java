package com.example.User_OrderService.Model;


import com.example.User_OrderService.Shared.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//import org.springframework.cloud.openfeign.FeignClient;
@org.springframework.cloud.openfeign.FeignClient(name="UserDetails",url="http://192.168.29.106:8083/abc")
public interface FeignClient {
@GetMapping("/{fname}")
public List<UserEntity> getByfName(@PathVariable String fname);
}
