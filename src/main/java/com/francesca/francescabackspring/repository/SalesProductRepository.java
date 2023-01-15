package com.francesca.francescabackspring.repository;


import com.francesca.francescabackspring.DTO.ReportSalesDay;
import com.francesca.francescabackspring.DTO.SalesDTO;
import com.francesca.francescabackspring.entity.SalesProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SalesProductRepository extends JpaRepository<SalesProduct, Integer> {
    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.SalesDTO(s.idProduct,s.quantity,(s.price*s.quantity)) FROM Sales s ")
    List<SalesDTO> getSales();
    //TODO reporte hecho a medias

}