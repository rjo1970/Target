package com.target.mygroovyretail.controller

import com.target.mygroovyretail.model.Product
import com.target.mygroovyretail.service.MyRetailService
import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by jrtitko1 on 8/6/16.
 */
@RestController
@RequestMapping("/myGroovyRetail")
class MyRetailController {
    static Logger log = Logger.getLogger(MyRetailController.class)

    @Autowired
    MyRetailService myRetailService

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable Integer id) {
        log.info("MyRetailController.getProduct(${id})")
        myRetailService.getProduct(id)
    }
}
