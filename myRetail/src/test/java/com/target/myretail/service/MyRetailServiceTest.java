package com.target.myretail.service;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.target.myretail.MyRetailApplication;
import com.target.myretail.model.Product;
import com.target.myretail.objects.Item;
import com.target.myretail.objects.OnlineDescription;
import com.target.myretail.objects.ProductCompositeResponse;
import com.target.myretail.objects.ProductResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyRetailApplication.class)
public class MyRetailServiceTest {

    @Autowired
    MyRetailService myRetailService;
    
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("run.mode", "demo");
    }
    
    @Test
    public void testBuildProduct() {
        OnlineDescription onlineDescription = new OnlineDescription();
        onlineDescription.setValue("Hewy Lewis & The News Greatest Hits");
        Item item = new Item();
        item.setOnlineDescription(onlineDescription);
        List<Item> items = Arrays.asList(item);
        ProductCompositeResponse productCompositeResponse = new ProductCompositeResponse();
        productCompositeResponse.setItems(items);
        ProductResponse response = new ProductResponse();
        response.setProductCompositeResponse(productCompositeResponse);
        
        Product product = myRetailService.getProduct(13860428);
        
        // JRT / RJ how to test the service? should we use JMockit? Yes
    }

}
