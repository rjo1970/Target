package com.target.myretail;

import static org.junit.Assert.assertEquals;

import java.net.UnknownHostException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyRetailApplication.class)
@WebAppConfiguration
public class MyRetailApplicationTests {

    @Autowired
    MyRetailApplication myRetailApplication;
    
    private static DB db;
    
	@Test
	public void testMongoSetup() throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("myRetail");

        myRetailApplication.init();
	    
        DBCollection table = db.getCollection("price");
        assertEquals(5, table.count());
	}
}
