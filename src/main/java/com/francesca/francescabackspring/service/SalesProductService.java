package com.francesca.francescabackspring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.francesca.francescabackspring.DTO.ProductDTO;
import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.DTO.SalesDTO;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.repository.ProductRepository;
import com.francesca.francescabackspring.repository.SalesProductRepository;
import com.francesca.francescabackspring.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SalesProductService {
    @Qualifier("salesProductRepository")
    @Autowired
    private SalesProductRepository repository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductRepository productRepository;

    public SalesProduct newRegister(SalesProduct sp){return repository.save(sp);};

    public List<SalesProduct> getSalesProduct() {
        return repository.findAll();
    }

    public List<ReportSalesDay> getReportSalesDay() {
      return repository.getSalesReport();
    }


}
