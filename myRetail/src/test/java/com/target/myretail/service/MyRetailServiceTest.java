package com.target.myretail.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.target.myretail.model.Price;
import com.target.myretail.model.Product;
import com.target.myretail.model.productapi.Item;
import com.target.myretail.model.productapi.OnlineDescription;
import com.target.myretail.model.productapi.ProductCompositeResponse;
import com.target.myretail.model.productapi.ProductResponse;
import com.target.myretail.repositories.PriceRepository;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class MyRetailServiceTest {

    @Tested
    MyRetailService myRetailService;

    @Mocked
    LoggerFactory mockLoggerFactory;
    @Mocked 
    Logger mockLogger;
    @Mocked 
    RestTemplate mockRestTemplate;
    
    @Injectable
    String productURL = "https//dummyURL";
    @Injectable 
    PriceRepository mockPriceRepository;
    
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("run.mode", "demo");
    }

    @Before
    public void setUp() {
        myRetailService = new MyRetailService();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testBuildProduct() {
        ProductResponse productResponse = buildProductResponse();
        Price price = new Price(13860428, 19.99, "USD");
        
        new Expectations() {{
            mockRestTemplate.getForObject(anyString, (Class<ProductResponse>)any); result = productResponse;
            mockPriceRepository.findOne(anyInt); result = price;
        }};
        
        Product product = myRetailService.getProduct(13860428);
        
        // JRT / RJ how to test the service? should we use JMockit? Yes
        assertNotNull(product);
        assertEquals(Integer.valueOf(13860428), product.getId());
        assertEquals("Hewy Lewis & The News Greatest Hits", product.getName());
        assertNotNull(product.getCurrentPrice());
        assertEquals(Integer.valueOf(13860428), product.getCurrentPrice().getId());
        assertEquals(19.99, product.getCurrentPrice().getValue(), 2);
        assertEquals("USD", product.getCurrentPrice().getCurrencyCode());
        
        new Verifications() {{
            mockLogger.info(productResponse.toString());            
        }};
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testBuildProduct_ProductNotFound() {
        ProductResponse productResponse = buildProductResponseForInvalidProduct();
        
        new Expectations() {{
            mockRestTemplate.getForObject(anyString, (Class<ProductResponse>)any); result = productResponse;
        }};
        
        Product product = myRetailService.getProduct(13860428);
        
        assertNotNull(product);
        assertEquals(Integer.valueOf(13860428), product.getId());
        assertNull(product.getName());
        assertNull(product.getCurrentPrice());
        
        new Verifications() {{
            mockPriceRepository.findOne(anyInt); times = 0;
            mockLogger.info(productResponse.toString());            
            mockLogger.warn("ProductID: 13860428 => Item Online Description is unavailable");            
        }};
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testBuildProduct_PriceNotFound() {
        ProductResponse productResponse = buildProductResponse();
        Price price = null;
        
        new Expectations() {{
            mockRestTemplate.getForObject(anyString, (Class<ProductResponse>)any); result = productResponse;
            mockPriceRepository.findOne(anyInt); result = price;
        }};
        
        Product product = myRetailService.getProduct(13860428);
        
        assertNotNull(product);
        assertEquals(Integer.valueOf(13860428), product.getId());
        assertEquals("Hewy Lewis & The News Greatest Hits", product.getName());
        assertNull(product.getCurrentPrice());
        
        new Verifications() {{
            mockLogger.info(productResponse.toString());            
        }};
    }
    
    private ProductResponse buildProductResponse() {
        OnlineDescription onlineDescription = new OnlineDescription();
        onlineDescription.setValue("Hewy Lewis & The News Greatest Hits");
        Item item = new Item();
        item.setOnlineDescription(onlineDescription);
        List<Item> items = Arrays.asList(item);
        ProductCompositeResponse productCompositeResponse = new ProductCompositeResponse();
        productCompositeResponse.setItems(items);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductCompositeResponse(productCompositeResponse);
        return productResponse;
    }

    private ProductResponse buildProductResponseForInvalidProduct() {
        Item item = new Item();
        item.setOnlineDescription(null);
        List<Item> items = Arrays.asList(item);
        ProductCompositeResponse productCompositeResponse = new ProductCompositeResponse();
        productCompositeResponse.setItems(items);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductCompositeResponse(productCompositeResponse);
        return productResponse;
    }
}
