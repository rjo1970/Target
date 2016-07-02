package com.target.myretail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.target.myretail.config.MongoConfiguration;
import com.target.myretail.model.Price;
import com.target.myretail.repositories.PriceRepository;

@SpringBootApplication
@Import({MongoConfiguration.class})
public class MyRetailApplication {
    
    @Value("${run.mode}")
    private String runMode;
    
    @Autowired
    private PriceRepository priceRepository;

    @Bean
    public CommandLineRunner init() {
        if ("demo".equalsIgnoreCase(runMode)) {
            return (env) -> {
                priceRepository.deleteAll();
                priceRepository.save(new Price(13860428,  13.49, "USD"));
                priceRepository.save(new Price(15117729,  10.99, "USD"));
                priceRepository.save(new Price(16483589,  22.09, "USD"));
                priceRepository.save(new Price(16696652, 125.00, "USD"));
//                priceRepository.save(new Price(16752456, 1000.00, "CAD"));
                priceRepository.save(new Price(15643793,   0.54, "USD"));
            };
        } else {
            return null;
        }
    }
    
	public static void main(String[] args) {
        SpringApplication.run(MyRetailApplication.class, args);
    }
}
