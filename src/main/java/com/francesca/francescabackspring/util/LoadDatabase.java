package com.francesca.francescabackspring.util;

import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.repository.ProductRepository;
import com.francesca.francescabackspring.repository.SalesProductRepository;
import com.francesca.francescabackspring.repository.SalesRepository;
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
    CommandLineRunner initDataBase(@Qualifier("productRepository") ProductRepository productRepository, @Qualifier("salesRepository") SalesRepository salesRepository, @Qualifier("salesProductRepository") SalesProductRepository salesProductRepository) {
        return args -> {
            log.info("Preloading"+ productRepository.save(new Product("Remera",1200, 'M',10 )));
            log.info("Preloading"+ salesRepository.save(new Sales(1, 2, 5800.30)));
        };
    }




}