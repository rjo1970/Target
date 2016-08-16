package com.target.mygroovyretail

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.target.mygroovyretail.repositories.PriceRepository
import org.bson.Document
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by jrtitko1 on 8/6/16.
 */
@SpringBootTest // new for 1.4
class MyGroovyRetailApplicationSpockTest extends Specification {

    @Autowired
    PriceRepository priceRepository

    @Shared MongoClient mongo = new MongoClient("localhost", 27017)

    @Ignore
    def "load database from application startup"() {
        println "PriceRepository => ${priceRepository}"
        println "mongo => ${mongo}"
        given:
        priceRepository.deleteAll()
//        MongoDatabase db = mongo.getDatabase("myGroovyRetail")

//        when:
//        new MyGroovyRetailApplication(priceRepository, "Demo")

//        then:
 //       MongoCollection<Document> table = db.getCollection("price")
 //       table.count() == 5
    }

}
