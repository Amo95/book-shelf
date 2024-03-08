package com.slideshare;

import com.slideshare.config.TokenConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TokenConfigProperties.class)
public class BookShelveApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShelveApplication.class, args);
    }

}
