package com.francesca.francescabackspring.service;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.Sales;
import com.francesca.francescabackspring.entity.SalesProduct;
import com.francesca.francescabackspring.repository.SalesProductRepository;
import com.francesca.francescabackspring.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalesService {

    @Qualifier("salesRepository")
    @Autowired
    private SalesRepository repository;
    //@Qualifier("salesProductRepository")
    //@Autowired
    //private SalesProductRepository salesProductrepository;
    public SalesService(@Qualifier("salesRepository") SalesRepository repository){
        this.repository= repository;
    }

    public Sales newSales(Sales s){
        Sales newSale =repository.save(s);
        double total = s.getQuantity() * s.getPrice();
        Date fechaVenta = new Date();
        System.out.println(fechaVenta);
        SalesProduct newSaleProduct = new SalesProduct(newSale.getId(), newSale.getIdProduct(), fechaVenta);
        //salesProductrepository.save(newSaleProduct);
        return newSale;
    }

    public List<Sales> getSales(){return repository.findAll();}


    public void deleteSale(int p) { repository.deleteById(p); }



}
