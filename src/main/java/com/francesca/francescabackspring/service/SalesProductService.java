package com.francesca.francescabackspring.service;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.DTO.SalesDTO;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.repository.SalesProductRepository;
import com.francesca.francescabackspring.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesProductService {
    @Qualifier("salesProductRepository")
    @Autowired
    private SalesProductRepository repository;

    public SalesProduct newRegister(SalesProduct sp){return repository.save(sp);};

    public List<SalesProduct> getSalesProduct() {
        return repository.findAll();
    }

    public List<SalesDTO> getReportSalesDay() { return repository.getSales(); }

}
