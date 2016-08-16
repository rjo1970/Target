package com.target.mygroovyretail.service

import com.target.mygroovyretail.model.Product
import com.target.mygroovyretail.repositories.PriceRepository
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

import javax.annotation.Resource


/**
 * Created by jrtitko1 on 8/6/16.
 */
@Service
class MyRetailService {

    static Logger log = Logger.getLogger(MyRetailService.class)

    @Value('${product.description.url}')
    String productURL

    @Resource
    PriceRepository priceRepository

    Product getProduct(def id) {

    }
}
