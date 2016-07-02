package com.target.myretail.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.myretail.model.Price;
import com.target.myretail.model.Product;
import com.target.myretail.model.productapi.InformationUnavailableException;
import com.target.myretail.model.productapi.ProductResponse;
import com.target.myretail.repositories.PriceRepository;

@Service
public class MyRetailService {
	
	private static final Logger log = LoggerFactory.getLogger(MyRetailService.class);

	@Value("${product.description.url}")
	private String productURL;
	
	@Resource
	private PriceRepository priceRepository;
	
	public Product getProduct(Integer id) {
	    		
		ProductResponse response = getProductDescription(id);
		
		Product product = buildProduct(id, response);
		
		return product;
	}

    private Product buildProduct(Integer id, ProductResponse productResponse) {
		Product product = new Product();
		product.setId(id);
		try {
		    product.setName(productResponse.getItemOnlineDescription());
	        product.setCurrentPrice(priceRepository.findOne(id));
		} catch (InformationUnavailableException e) {
		    log.warn("ProductID: " + id + " => " + e.getMessage());
        }
        return product;
    }

    private ProductResponse getProductDescription(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
		String url = String.format(productURL, id);
		ProductResponse response = restTemplate.getForObject(url, ProductResponse.class);
		log.info(response.toString());
        return response;
    }	
    
    public void savePrice(Price newPrice) {
        priceRepository.save(newPrice);
    }
}
