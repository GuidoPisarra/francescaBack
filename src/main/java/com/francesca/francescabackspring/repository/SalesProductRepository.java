package com.francesca.francescabackspring.repository;


import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.DTO.SalesDTO;
import com.francesca.francescabackspring.entity.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SalesProductRepository extends JpaRepository<SalesProduct, Integer> {
    //@Query(value = "SELECT new com.francesca.francescabackspring.DTO.ReportSalesDay(sp.idSalesProduct,sp.idProduct, sp.idSale, sp.SaleProductDate, sp.) FROM SalesProduct sp")
    //List<ReportSalesDay> getSales();
    //TODO reporte hecho a medias

}