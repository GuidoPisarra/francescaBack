package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Integer> {
    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.ReportSalesDay(s.saleDay, SUM(s.quantity) , (s.price*s.quantity)) FROM Sales s GROUP BY s.saleDay, s.quantity, s.price")
    List<ReportSalesDay> getReportSalesDay();
 //TODO falta mejorar reporte, mismo dia pero distinta hora, lo toma como diferente dia

}
