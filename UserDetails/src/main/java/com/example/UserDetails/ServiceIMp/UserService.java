package com.example.UserDetails.ServiceIMp;
import com.example.UserDetails.Entity.UserEntity;
import com.example.UserDetails.Entity.UserEntityRepository;
import com.example.UserDetails.Shared.DTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.UUID;
@Service
public class UserService implements UserServiceImp {
    @Autowired
   private UserEntityRepository repository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RestTemplate restTemplate;
    public UserService(UserEntityRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public DTO createUser(DTO userDto){
        ModelMapper modelmapper = new ModelMapper();
        modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        userDto.setUid(UUID.randomUUID().toString());
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        UserEntity userEntity =modelmapper.map(userDto, UserEntity.class);
        repository.save(userEntity);
        DTO rv=modelmapper.map(userEntity,DTO.class);
        return  rv;
    }


//    @Override
//    public UserEntity findByuID(String uid) {
//       return repository.findByUid(uid);
//    }

    @Override
    public DTO getUserDetailsByEmail(String email) {
        UserEntity userEntity=repository.findByEmail(email);
        if(userEntity==null) throw new UsernameNotFoundException(email);
        return new ModelMapper().map(userEntity,DTO.class);
    }

    @Autowired private MongoTemplate mongoTemplate;
    public UserEntity findByEmail(String email,String password){
    return null;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=repository.findByEmail(username);
        if(userEntity==null) throw new UsernameNotFoundException(username);
        return new User(userEntity.getEmail(),userEntity.getPassword(),true,true,
                true,true,new ArrayList<>());
    }
//    public OrderResponse createOrder(DTO ud){
//        OrderEntity orderEntity=ud.getOrderEntity();
//        UserEntity userEntity=ud.getUserEntity();
//        orderEntity.setUid(userEntity.getUid());
//        OrderEntity response=restTemplate.getForObject("http://OrderDetailService/order/{itemName}",OrderEntity.class);
//        repository.save(userEntity);
//         return new OrderResponse(response.getItemName(),response.getQuantity(),response.getItemCode()
//        ,response.getAmount(),response.getOrderId(),userEntity.getUid());
//}
}

