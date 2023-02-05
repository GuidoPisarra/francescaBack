package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SalesProductRepository extends JpaRepository<SalesProduct, Integer> {
    @Query("SELECT new com.francesca.francescabackspring.DTO.ReportSalesDay(s.id, sp.idProduct, s.id, p.description, s.quantity, (s.quantity * p.salePrice),sp.SaleProductDate )" +
            "FROM Sales s " +
            "JOIN SalesProduct sp " +
            "ON s.id = sp.idSalesProduct "+
            "JOIN  Product p " +
            "ON p.id = s.idProduct"
    )
    List<ReportSalesDay> getSalesReport();

}