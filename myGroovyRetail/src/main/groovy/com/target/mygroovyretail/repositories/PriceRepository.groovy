package com.target.mygroovyretail.repositories

import com.target.mygroovyretail.model.Price
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by jrtitko1 on 8/6/16.
 */
@Repository
interface PriceRepository extends MongoRepository<Price, Integer> {

}