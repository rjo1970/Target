package com.target.mygroovyretail

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.target.mygroovyretail.repositories.PriceRepository
import org.bson.Document
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

import static org.junit.Assert.*

/**
 * Created by jrtitko1 on 8/6/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest // new for 1.4
class MyGroovyRetailApplicationTests {

    @Autowired
    PriceRepository priceRepository

    private static MongoDatabase db;

    @Test
    public void testMongoSetup() throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost", 27017);
        db = mongo.getDatabase("myGroovyRetail");

        new MyGroovyRetailApplication(priceRepository, "Demo");

        MongoCollection<Document> table = db.getCollection("price");
        assertEquals(5, table.count());
    }

}
