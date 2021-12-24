package com.example.User_OrderService.ServiceImp;

import com.example.User_OrderService.Entity.OrderIdSequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService{
    @Autowired
    private MongoOperations mongo;

    public int getNextSequence(String seqName)
    {
        OrderIdSequenceGenerator counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                OrderIdSequenceGenerator.class);
        return counter.getSeq();
    }
}