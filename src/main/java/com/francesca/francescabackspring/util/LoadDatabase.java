package com.francesca.francescabackspring.util;

import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Configuration
@Slf4j
class LoadDatabase {
    @Bean
    CommandLineRunner initDataBase(@Qualifier("productRepository") ProductRepository productRepository) {
        return args -> {
            log.info("Preloading"+ productRepository.save(new Product("Remera",1200, 'M',10 )));


        };
    }






}