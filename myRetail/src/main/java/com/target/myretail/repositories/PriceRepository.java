package com.target.myretail.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.target.myretail.model.Price;

@Repository
public interface PriceRepository extends MongoRepository<Price, Integer> {

}
