package com.target.myretail.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.myretail.model.Product;
import com.target.myretail.objects.ProductResponse;
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

    protected Product buildProduct(Integer id, ProductResponse productResponse) {
		Product product = new Product();
		product.setId(id);
		try {
		    product.setName(productResponse.getProductCompositeResponse().getItems().get(0).getOnlineDescription().getValue()); // from API
	        product.setCurrentPrice(priceRepository.findOne(id));
		} catch (NullPointerException e) {
		    product.setName("");
		}
        return product;
    }

    protected ProductResponse getProductDescription(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
		String url = String.format(productURL, id);
		ProductResponse response = restTemplate.getForObject(url, ProductResponse.class);
		log.info(response.toString());
        return response;
    }	
}
