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
import org.springframework.stereotype.Service;

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


    public List<SalesProduct> newSalesProduct(List<SalesProduct> sp) {
        int saleId = 0;
        for (SalesProduct lis : sp){
            Product saleProduct = productRepository.getProductById(lis.getIdProduct());
            if(saleProduct.getQuantity() < lis.getQuantity()){
                return null;
            }
        }
        for (SalesProduct lis : sp ) {
            Sales newSale = salesRepository.save(new Sales(lis.getIdProduct()));
            lis.setSaleProductDate(new Date());
            if(saleId==0){
                saleId=newSale.getId();
            }
            lis.setIdSale(saleId);
            Product saleProduct = productRepository.getProductById(lis.getIdProduct());
            int newQuantity = saleProduct.getQuantity() - lis.getQuantity();
            saleProduct.setQuantity(newQuantity);
            SalesProduct newSaleProduct = repository.save(lis);
        }
        return sp;
    }


}
