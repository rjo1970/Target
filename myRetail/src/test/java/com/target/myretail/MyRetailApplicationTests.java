package com.target.myretail;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
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
    
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.setProperty("run.mode", "demo");
        MongoClient mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("myRetail");
        db.dropDatabase();
    }
    
	@Test
	public void testMongoSetup_DemoMode() {

        myRetailApplication.init();
	    
        DBCollection table = db.getCollection("price");
        assertEquals(6, table.count());
	}
}
