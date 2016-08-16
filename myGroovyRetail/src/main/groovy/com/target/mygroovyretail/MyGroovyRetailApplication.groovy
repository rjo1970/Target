package com.target.mygroovyretail

import com.target.mygroovyretail.config.MongoConfiguration
import com.target.mygroovyretail.model.Price
import com.target.mygroovyretail.repositories.PriceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

/**
 * Created by jrtitko1 on 8/6/16.
 */
@SpringBootApplication
@Import([MongoConfiguration.class])
class MyGroovyRetailApplication {

    MyGroovyRetailApplication(@Autowired PriceRepository priceRepository, @Value('${run.mode}') String runMode) {
        println "***** started => ${priceRepository}"
        if ("demo".equalsIgnoreCase(runMode)) {
            println "***** IN DEMO MODE"
            priceRepository.deleteAll();
            priceRepository.save(new Price(id: 13860428, value: 13.49, currencyCode: "USD"));
            priceRepository.save(new Price(id: 15117729, value: 10.99, currencyCode: "USD"));
            priceRepository.save(new Price(id: 16483589, value: 22.09, currencyCode: "USD"));
            priceRepository.save(new Price(id: 16696652, value: 125.00, currencyCode: "USD"));
            //                priceRepository.save(new Price(id: 16752456, value: 1000.00, currencyCode: "CAD"));
            priceRepository.save(new Price(id: 15643793, value: 0.54, currencyCode: "USD"));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MyGroovyRetailApplication.class, args);
    }
}
