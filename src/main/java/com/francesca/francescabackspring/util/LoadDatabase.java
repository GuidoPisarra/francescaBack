package com.francesca.francescabackspring.util;

import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.repository.ExpensesRepository;
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
    CommandLineRunner initDataBase(@Qualifier("productRepository") ProductRepository productRepository, @Qualifier("salesRepository") SalesRepository salesRepository, @Qualifier("salesProductRepository") SalesProductRepository salesProductRepository,@Qualifier("expensesRepository") ExpensesRepository expensesRepository) {
        return args -> {
            log.info("Preloading"+ productRepository.save(new Product("Buzo Trinidad Crudo",1200,1500,10, 1,"0519690070006A","006A" )));
            log.info("Preloading"+ productRepository.save(new Product("Vestido Trinidad Blanco",1000,1200,15, 1,"0902010000004A","004A" )));
            log.info("Preloading"+ productRepository.save(new Product("Body Indira Tostado",2000,2500,20, 1,"0073480127003M","003M" )));
            log.info("Preloading"+ salesRepository.save(new Sales(1, 2, 5800.30)));
        };
    }




}