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

//    public List<ReportSalesDay> getReportSalesDay() throws JsonProcessingException {
//        List<ReportSalesDay> salesProductList = new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
//        String resourceUrl = "http://localhost:3000/sales";
//        for (SalesDTO s: salesRepository.getAllSales()) {
//            ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl + "/" + s.getId_product(), String.class);
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode root = mapper.readTree(response.getBody());
//            for (Product p: productRepository.findAll()) {
//                ResponseEntity<String> responseProd = restTemplate.getForEntity(resourceUrl + "/" + p.getId(), String.class);
//                ObjectMapper mapperProd = new ObjectMapper();
//                JsonNode rootProd = mapper.readTree(response.getBody());
//                salesProductList.add(new ReportSalesDay(s.getId(), root.path("id").asInt(), s.getId_product(), root.path("idProduct").asInt(),s.getId(), root.path("idSale").asInt(),s.get ));
//            }
//        }
//        return repository.getSales(); }

}
