package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SalesProductRepository extends JpaRepository<SalesProduct, Integer> {
    @Query("SELECT new com.francesca.francescabackspring.DTO.ReportSalesDay(s.id, sp.idProduct, sp.idSale, p.description, sp.quantity, (sp.quantity * p.salePrice),sp.SaleProductDate, sp.typePayment )" +
            "FROM SalesProduct sp " +
            "JOIN Sales s " +
            "ON s.id = sp.idSale "+
            "JOIN  Product p " +
            "ON p.id = sp.idProduct"
    )
    List<ReportSalesDay> getSalesReport();
}