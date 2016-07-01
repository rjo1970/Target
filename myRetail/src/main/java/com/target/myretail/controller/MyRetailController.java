package com.target.myretail.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.target.myretail.model.Price;
import com.target.myretail.model.Product;
import com.target.myretail.repositories.PriceRepository;
import com.target.myretail.service.MyRetailService;

@RestController
@RequestMapping("/myRetail")
public class MyRetailController {
	
	private static final Logger log = LoggerFactory.getLogger(MyRetailController.class);
	
	@Resource
	PriceRepository priceRepository;
	
	@Autowired
	MyRetailService myRetailService;
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable Integer id) {
		log.info("MyRetailController.getProduct(" + id + ")");
		
		return myRetailService.getProduct(id);		
	}	

    @RequestMapping(value="/products/{id}", method = RequestMethod.POST)
    public void postProduct(@PathVariable Integer id, @RequestBody Price newPrice) {
        log.info("MyRetailController.postProduct(" + id + "); newPrice = " + newPrice);
        
        // JRT / RJ should this go into the service too? Yes, move it
        priceRepository.save(newPrice);
    }   
}
